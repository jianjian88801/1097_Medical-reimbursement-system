
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 报销单
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/biaoxiaodan")
public class BiaoxiaodanController {
    private static final Logger logger = LoggerFactory.getLogger(BiaoxiaodanController.class);

    @Autowired
    private BiaoxiaodanService biaoxiaodanService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private CaikuaiService caikuaiService;
    @Autowired
    private YonghuService yonghuService;

    @Autowired
    private LingdaoService lingdaoService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("财会审核人员".equals(role))
            params.put("caikuaiId",request.getSession().getAttribute("userId"));
        else if("领导".equals(role))
            params.put("lingdaoId",request.getSession().getAttribute("userId"));
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = biaoxiaodanService.queryPage(params);

        //字典表数据转换
        List<BiaoxiaodanView> list =(List<BiaoxiaodanView>)page.getList();
        for(BiaoxiaodanView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        BiaoxiaodanEntity biaoxiaodan = biaoxiaodanService.selectById(id);
        if(biaoxiaodan !=null){
            //entity转view
            BiaoxiaodanView view = new BiaoxiaodanView();
            BeanUtils.copyProperties( biaoxiaodan , view );//把实体数据重构到view中

                //级联表
                CaikuaiEntity caikuai = caikuaiService.selectById(biaoxiaodan.getCaikuaiId());
                if(caikuai != null){
                    BeanUtils.copyProperties( caikuai , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setCaikuaiId(caikuai.getId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(biaoxiaodan.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody BiaoxiaodanEntity biaoxiaodan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,biaoxiaodan:{}",this.getClass().getName(),biaoxiaodan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            biaoxiaodan.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("财会审核人员".equals(role))
            biaoxiaodan.setCaikuaiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<BiaoxiaodanEntity> queryWrapper = new EntityWrapper<BiaoxiaodanEntity>()
            .eq("yonghu_id", biaoxiaodan.getYonghuId())
            .eq("biaoxiaodan_uuid_number", biaoxiaodan.getBiaoxiaodanUuidNumber())
            .eq("biaoxiaodan_name", biaoxiaodan.getBiaoxiaodanName())
            .eq("biaoxiaodan_baoxiaoren_name", biaoxiaodan.getBiaoxiaodanBaoxiaorenName())
            .eq("biaoxiaodan_baoxiaoren_phone", biaoxiaodan.getBiaoxiaodanBaoxiaorenPhone())
            .eq("biaoxiaodan_baoxiaoren_id_number", biaoxiaodan.getBiaoxiaodanBaoxiaorenIdNumber())
            .eq("biaoxiaodan_renyuan_types", biaoxiaodan.getBiaoxiaodanRenyuanTypes())
            .eq("biaoxiaodan_bingqing_types", biaoxiaodan.getBiaoxiaodanBingqingTypes())
            .eq("biaoxiaodan_yiliaofeiyong_types", biaoxiaodan.getBiaoxiaodanYiliaofeiyongTypes())
            .eq("biaoxiaodan_yesno_types", biaoxiaodan.getBiaoxiaodanYesnoTypes())
            .eq("biaoxiaodan_yesno_text", biaoxiaodan.getBiaoxiaodanYesnoText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BiaoxiaodanEntity biaoxiaodanEntity = biaoxiaodanService.selectOne(queryWrapper);
        if(biaoxiaodanEntity==null){
            biaoxiaodan.setInsertTime(new Date());
            biaoxiaodan.setBiaoxiaodanYesnoTypes(1);
            biaoxiaodan.setCreateTime(new Date());
            biaoxiaodanService.insert(biaoxiaodan);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody BiaoxiaodanEntity biaoxiaodan, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,biaoxiaodan:{}",this.getClass().getName(),biaoxiaodan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            biaoxiaodan.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("财会审核人员".equals(role))
            biaoxiaodan.setCaikuaiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<BiaoxiaodanEntity> queryWrapper = new EntityWrapper<BiaoxiaodanEntity>()
            .notIn("id",biaoxiaodan.getId())
            .andNew()
            .eq("yonghu_id", biaoxiaodan.getYonghuId())
            .eq("biaoxiaodan_uuid_number", biaoxiaodan.getBiaoxiaodanUuidNumber())
            .eq("biaoxiaodan_name", biaoxiaodan.getBiaoxiaodanName())
            .eq("biaoxiaodan_baoxiaoren_name", biaoxiaodan.getBiaoxiaodanBaoxiaorenName())
            .eq("biaoxiaodan_baoxiaoren_phone", biaoxiaodan.getBiaoxiaodanBaoxiaorenPhone())
            .eq("biaoxiaodan_baoxiaoren_id_number", biaoxiaodan.getBiaoxiaodanBaoxiaorenIdNumber())
            .eq("biaoxiaodan_renyuan_types", biaoxiaodan.getBiaoxiaodanRenyuanTypes())
            .eq("biaoxiaodan_bingqing_types", biaoxiaodan.getBiaoxiaodanBingqingTypes())
            .eq("biaoxiaodan_yiliaofeiyong_types", biaoxiaodan.getBiaoxiaodanYiliaofeiyongTypes())
            .eq("insert_time", biaoxiaodan.getInsertTime())
            .eq("biaoxiaodan_yesno_types", biaoxiaodan.getBiaoxiaodanYesnoTypes())
            .eq("biaoxiaodan_yesno_text", biaoxiaodan.getBiaoxiaodanYesnoText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BiaoxiaodanEntity biaoxiaodanEntity = biaoxiaodanService.selectOne(queryWrapper);
        if("".equals(biaoxiaodan.getBiaoxiaodanBaoxiaorenPhoto()) || "null".equals(biaoxiaodan.getBiaoxiaodanBaoxiaorenPhoto())){
                biaoxiaodan.setBiaoxiaodanBaoxiaorenPhoto(null);
        }
        if("".equals(biaoxiaodan.getBiaoxiaodanBaoxiaorenShenfenzhengzPhoto()) || "null".equals(biaoxiaodan.getBiaoxiaodanBaoxiaorenShenfenzhengzPhoto())){
                biaoxiaodan.setBiaoxiaodanBaoxiaorenShenfenzhengzPhoto(null);
        }
        if("".equals(biaoxiaodan.getBiaoxiaodanBaoxiaorenShenfenzhengfPhoto()) || "null".equals(biaoxiaodan.getBiaoxiaodanBaoxiaorenShenfenzhengfPhoto())){
                biaoxiaodan.setBiaoxiaodanBaoxiaorenShenfenzhengfPhoto(null);
        }
        if("".equals(biaoxiaodan.getBiaoxiaodanFile()) || "null".equals(biaoxiaodan.getBiaoxiaodanFile())){
                biaoxiaodan.setBiaoxiaodanFile(null);
        }
        if(biaoxiaodanEntity==null){
            biaoxiaodanService.updateById(biaoxiaodan);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        biaoxiaodanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<BiaoxiaodanEntity> biaoxiaodanList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            BiaoxiaodanEntity biaoxiaodanEntity = new BiaoxiaodanEntity();
//                            biaoxiaodanEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            biaoxiaodanEntity.setCaikuaiId(Integer.valueOf(data.get(0)));   //财会审核人员 要改的
//                            biaoxiaodanEntity.setBiaoxiaodanUuidNumber(data.get(0));                    //报销单编号 要改的
//                            biaoxiaodanEntity.setBiaoxiaodanName(data.get(0));                    //报销单名称 要改的
//                            biaoxiaodanEntity.setBiaoxiaodanBaoxiaorenName(data.get(0));                    //报销人姓名 要改的
//                            biaoxiaodanEntity.setBiaoxiaodanBaoxiaorenPhoto("");//详情和图片
//                            biaoxiaodanEntity.setBiaoxiaodanBaoxiaorenShenfenzhengzPhoto("");//详情和图片
//                            biaoxiaodanEntity.setBiaoxiaodanBaoxiaorenShenfenzhengfPhoto("");//详情和图片
//                            biaoxiaodanEntity.setBiaoxiaodanBaoxiaorenPhone(data.get(0));                    //报销人联系方式 要改的
//                            biaoxiaodanEntity.setBiaoxiaodanBaoxiaorenIdNumber(data.get(0));                    //报销人身份证号 要改的
//                            biaoxiaodanEntity.setBiaoxiaodanRenyuanTypes(Integer.valueOf(data.get(0)));   //人员状态 要改的
//                            biaoxiaodanEntity.setBiaoxiaodanBingqingTypes(Integer.valueOf(data.get(0)));   //病情 要改的
//                            biaoxiaodanEntity.setBiaoxiaodanYiliaofeiyongTypes(Integer.valueOf(data.get(0)));   //费用类型 要改的
//                            biaoxiaodanEntity.setBiaoxiaodanNewJine(data.get(0));                    //报销金额 要改的
//                            biaoxiaodanEntity.setBiaoxiaodanFile(data.get(0));                    //相关报销凭证 要改的
//                            biaoxiaodanEntity.setBiaoxiaodanContent("");//详情和图片
//                            biaoxiaodanEntity.setInsertTime(date);//时间
//                            biaoxiaodanEntity.setBiaoxiaodanYesnoTypes(Integer.valueOf(data.get(0)));   //审核状态 要改的
//                            biaoxiaodanEntity.setBiaoxiaodanYesnoText(data.get(0));                    //审核意见 要改的
//                            biaoxiaodanEntity.setCreateTime(date);//时间
                            biaoxiaodanList.add(biaoxiaodanEntity);


                            //把要查询是否重复的字段放入map中
                                //报销单编号
                                if(seachFields.containsKey("biaoxiaodanUuidNumber")){
                                    List<String> biaoxiaodanUuidNumber = seachFields.get("biaoxiaodanUuidNumber");
                                    biaoxiaodanUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> biaoxiaodanUuidNumber = new ArrayList<>();
                                    biaoxiaodanUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("biaoxiaodanUuidNumber",biaoxiaodanUuidNumber);
                                }
                        }

                        //查询是否重复
                         //报销单编号
                        List<BiaoxiaodanEntity> biaoxiaodanEntities_biaoxiaodanUuidNumber = biaoxiaodanService.selectList(new EntityWrapper<BiaoxiaodanEntity>().in("biaoxiaodan_uuid_number", seachFields.get("biaoxiaodanUuidNumber")));
                        if(biaoxiaodanEntities_biaoxiaodanUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(BiaoxiaodanEntity s:biaoxiaodanEntities_biaoxiaodanUuidNumber){
                                repeatFields.add(s.getBiaoxiaodanUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [报销单编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        biaoxiaodanService.insertBatch(biaoxiaodanList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
