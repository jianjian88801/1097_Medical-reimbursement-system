
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
 * 财会审核人员
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/caikuai")
public class CaikuaiController {
    private static final Logger logger = LoggerFactory.getLogger(CaikuaiController.class);

    @Autowired
    private CaikuaiService caikuaiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private LingdaoService lingdaoService;
    @Autowired
    private YonghuService yonghuService;


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
        PageUtils page = caikuaiService.queryPage(params);

        //字典表数据转换
        List<CaikuaiView> list =(List<CaikuaiView>)page.getList();
        for(CaikuaiView c:list){
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
        CaikuaiEntity caikuai = caikuaiService.selectById(id);
        if(caikuai !=null){
            //entity转view
            CaikuaiView view = new CaikuaiView();
            BeanUtils.copyProperties( caikuai , view );//把实体数据重构到view中

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
    public R save(@RequestBody CaikuaiEntity caikuai, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,caikuai:{}",this.getClass().getName(),caikuai.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<CaikuaiEntity> queryWrapper = new EntityWrapper<CaikuaiEntity>()
            .eq("username", caikuai.getUsername())
            .or()
            .eq("caikuai_phone", caikuai.getCaikuaiPhone())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CaikuaiEntity caikuaiEntity = caikuaiService.selectOne(queryWrapper);
        if(caikuaiEntity==null){
            caikuai.setCreateTime(new Date());
            caikuai.setPassword("123456");
            caikuaiService.insert(caikuai);
            return R.ok();
        }else {
            return R.error(511,"账户或者财会审核人员手机号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody CaikuaiEntity caikuai, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,caikuai:{}",this.getClass().getName(),caikuai.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<CaikuaiEntity> queryWrapper = new EntityWrapper<CaikuaiEntity>()
            .notIn("id",caikuai.getId())
            .andNew()
            .eq("username", caikuai.getUsername())
            .or()
            .eq("caikuai_phone", caikuai.getCaikuaiPhone())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CaikuaiEntity caikuaiEntity = caikuaiService.selectOne(queryWrapper);
        if("".equals(caikuai.getCaikuaiPhoto()) || "null".equals(caikuai.getCaikuaiPhoto())){
                caikuai.setCaikuaiPhoto(null);
        }
        if(caikuaiEntity==null){
            caikuaiService.updateById(caikuai);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者财会审核人员手机号已经被使用");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        caikuaiService.deleteBatchIds(Arrays.asList(ids));
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
            List<CaikuaiEntity> caikuaiList = new ArrayList<>();//上传的东西
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
                            CaikuaiEntity caikuaiEntity = new CaikuaiEntity();
//                            caikuaiEntity.setUsername(data.get(0));                    //账户 要改的
//                            //caikuaiEntity.setPassword("123456");//密码
//                            caikuaiEntity.setCaikuaiName(data.get(0));                    //财会审核人员姓名 要改的
//                            caikuaiEntity.setCaikuaiPhone(data.get(0));                    //财会审核人员手机号 要改的
//                            caikuaiEntity.setCaikuaiPhoto("");//详情和图片
//                            caikuaiEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            caikuaiEntity.setCaikuaiEmail(data.get(0));                    //电子邮箱 要改的
//                            caikuaiEntity.setCreateTime(date);//时间
                            caikuaiList.add(caikuaiEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //财会审核人员手机号
                                if(seachFields.containsKey("caikuaiPhone")){
                                    List<String> caikuaiPhone = seachFields.get("caikuaiPhone");
                                    caikuaiPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> caikuaiPhone = new ArrayList<>();
                                    caikuaiPhone.add(data.get(0));//要改的
                                    seachFields.put("caikuaiPhone",caikuaiPhone);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<CaikuaiEntity> caikuaiEntities_username = caikuaiService.selectList(new EntityWrapper<CaikuaiEntity>().in("username", seachFields.get("username")));
                        if(caikuaiEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(CaikuaiEntity s:caikuaiEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //财会审核人员手机号
                        List<CaikuaiEntity> caikuaiEntities_caikuaiPhone = caikuaiService.selectList(new EntityWrapper<CaikuaiEntity>().in("caikuai_phone", seachFields.get("caikuaiPhone")));
                        if(caikuaiEntities_caikuaiPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(CaikuaiEntity s:caikuaiEntities_caikuaiPhone){
                                repeatFields.add(s.getCaikuaiPhone());
                            }
                            return R.error(511,"数据库的该表中的 [财会审核人员手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        caikuaiService.insertBatch(caikuaiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }


    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        CaikuaiEntity caikuai = caikuaiService.selectOne(new EntityWrapper<CaikuaiEntity>().eq("username", username));
        if(caikuai==null || !caikuai.getPassword().equals(password))
            return R.error("账号或密码不正确");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(.getRoleTypes());
        String token = tokenService.generateToken(caikuai.getId(),username, "caikuai", "财会审核人员");
        R r = R.ok();
        r.put("token", token);
        r.put("role","财会审核人员");
        r.put("username",caikuai.getCaikuaiName());
        r.put("tableName","caikuai");
        r.put("userId",caikuai.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody CaikuaiEntity caikuai){
//    	ValidatorUtils.validateEntity(user);
        Wrapper<CaikuaiEntity> queryWrapper = new EntityWrapper<CaikuaiEntity>()
            .eq("username", caikuai.getUsername())
            .or()
            .eq("caikuai_phone", caikuai.getCaikuaiPhone())
            ;
        CaikuaiEntity caikuaiEntity = caikuaiService.selectOne(queryWrapper);
        if(caikuaiEntity != null)
            return R.error("账户或者财会审核人员手机号已经被使用");
        caikuai.setCreateTime(new Date());
        caikuaiService.insert(caikuai);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        CaikuaiEntity caikuai = new CaikuaiEntity();
        caikuai.setPassword("123456");
        caikuai.setId(id);
        caikuaiService.updateById(caikuai);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        CaikuaiEntity caikuai = caikuaiService.selectOne(new EntityWrapper<CaikuaiEntity>().eq("username", username));
        if(caikuai!=null){
            caikuai.setPassword("123456");
            boolean b = caikuaiService.updateById(caikuai);
            if(!b){
               return R.error();
            }
        }else{
           return R.error("账号不存在");
        }
        return R.ok();
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrCaikuai(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        CaikuaiEntity caikuai = caikuaiService.selectById(id);
        if(caikuai !=null){
            //entity转view
            CaikuaiView view = new CaikuaiView();
            BeanUtils.copyProperties( caikuai , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }





}
