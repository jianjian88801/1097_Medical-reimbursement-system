package com.entity.model;

import com.entity.BiaoxiaodanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 报销单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class BiaoxiaodanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 财会审核人员
     */
    private Integer caikuaiId;


    /**
     * 报销单编号
     */
    private String biaoxiaodanUuidNumber;


    /**
     * 报销单名称
     */
    private String biaoxiaodanName;


    /**
     * 报销人姓名
     */
    private String biaoxiaodanBaoxiaorenName;


    /**
     * 报销人头像照片
     */
    private String biaoxiaodanBaoxiaorenPhoto;


    /**
     * 身份证正面
     */
    private String biaoxiaodanBaoxiaorenShenfenzhengzPhoto;


    /**
     * 身份证反面
     */
    private String biaoxiaodanBaoxiaorenShenfenzhengfPhoto;


    /**
     * 报销人联系方式
     */
    private String biaoxiaodanBaoxiaorenPhone;


    /**
     * 报销人身份证号
     */
    private String biaoxiaodanBaoxiaorenIdNumber;


    /**
     * 人员状态
     */
    private Integer biaoxiaodanRenyuanTypes;


    /**
     * 病情
     */
    private Integer biaoxiaodanBingqingTypes;


    /**
     * 费用类型
     */
    private Integer biaoxiaodanYiliaofeiyongTypes;


    /**
     * 报销金额
     */
    private Double biaoxiaodanNewJine;


    /**
     * 相关报销凭证
     */
    private String biaoxiaodanFile;


    /**
     * 其他备注
     */
    private String biaoxiaodanContent;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 审核状态
     */
    private Integer biaoxiaodanYesnoTypes;


    /**
     * 审核意见
     */
    private String biaoxiaodanYesnoText;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：财会审核人员
	 */
    public Integer getCaikuaiId() {
        return caikuaiId;
    }


    /**
	 * 设置：财会审核人员
	 */
    public void setCaikuaiId(Integer caikuaiId) {
        this.caikuaiId = caikuaiId;
    }
    /**
	 * 获取：报销单编号
	 */
    public String getBiaoxiaodanUuidNumber() {
        return biaoxiaodanUuidNumber;
    }


    /**
	 * 设置：报销单编号
	 */
    public void setBiaoxiaodanUuidNumber(String biaoxiaodanUuidNumber) {
        this.biaoxiaodanUuidNumber = biaoxiaodanUuidNumber;
    }
    /**
	 * 获取：报销单名称
	 */
    public String getBiaoxiaodanName() {
        return biaoxiaodanName;
    }


    /**
	 * 设置：报销单名称
	 */
    public void setBiaoxiaodanName(String biaoxiaodanName) {
        this.biaoxiaodanName = biaoxiaodanName;
    }
    /**
	 * 获取：报销人姓名
	 */
    public String getBiaoxiaodanBaoxiaorenName() {
        return biaoxiaodanBaoxiaorenName;
    }


    /**
	 * 设置：报销人姓名
	 */
    public void setBiaoxiaodanBaoxiaorenName(String biaoxiaodanBaoxiaorenName) {
        this.biaoxiaodanBaoxiaorenName = biaoxiaodanBaoxiaorenName;
    }
    /**
	 * 获取：报销人头像照片
	 */
    public String getBiaoxiaodanBaoxiaorenPhoto() {
        return biaoxiaodanBaoxiaorenPhoto;
    }


    /**
	 * 设置：报销人头像照片
	 */
    public void setBiaoxiaodanBaoxiaorenPhoto(String biaoxiaodanBaoxiaorenPhoto) {
        this.biaoxiaodanBaoxiaorenPhoto = biaoxiaodanBaoxiaorenPhoto;
    }
    /**
	 * 获取：身份证正面
	 */
    public String getBiaoxiaodanBaoxiaorenShenfenzhengzPhoto() {
        return biaoxiaodanBaoxiaorenShenfenzhengzPhoto;
    }


    /**
	 * 设置：身份证正面
	 */
    public void setBiaoxiaodanBaoxiaorenShenfenzhengzPhoto(String biaoxiaodanBaoxiaorenShenfenzhengzPhoto) {
        this.biaoxiaodanBaoxiaorenShenfenzhengzPhoto = biaoxiaodanBaoxiaorenShenfenzhengzPhoto;
    }
    /**
	 * 获取：身份证反面
	 */
    public String getBiaoxiaodanBaoxiaorenShenfenzhengfPhoto() {
        return biaoxiaodanBaoxiaorenShenfenzhengfPhoto;
    }


    /**
	 * 设置：身份证反面
	 */
    public void setBiaoxiaodanBaoxiaorenShenfenzhengfPhoto(String biaoxiaodanBaoxiaorenShenfenzhengfPhoto) {
        this.biaoxiaodanBaoxiaorenShenfenzhengfPhoto = biaoxiaodanBaoxiaorenShenfenzhengfPhoto;
    }
    /**
	 * 获取：报销人联系方式
	 */
    public String getBiaoxiaodanBaoxiaorenPhone() {
        return biaoxiaodanBaoxiaorenPhone;
    }


    /**
	 * 设置：报销人联系方式
	 */
    public void setBiaoxiaodanBaoxiaorenPhone(String biaoxiaodanBaoxiaorenPhone) {
        this.biaoxiaodanBaoxiaorenPhone = biaoxiaodanBaoxiaorenPhone;
    }
    /**
	 * 获取：报销人身份证号
	 */
    public String getBiaoxiaodanBaoxiaorenIdNumber() {
        return biaoxiaodanBaoxiaorenIdNumber;
    }


    /**
	 * 设置：报销人身份证号
	 */
    public void setBiaoxiaodanBaoxiaorenIdNumber(String biaoxiaodanBaoxiaorenIdNumber) {
        this.biaoxiaodanBaoxiaorenIdNumber = biaoxiaodanBaoxiaorenIdNumber;
    }
    /**
	 * 获取：人员状态
	 */
    public Integer getBiaoxiaodanRenyuanTypes() {
        return biaoxiaodanRenyuanTypes;
    }


    /**
	 * 设置：人员状态
	 */
    public void setBiaoxiaodanRenyuanTypes(Integer biaoxiaodanRenyuanTypes) {
        this.biaoxiaodanRenyuanTypes = biaoxiaodanRenyuanTypes;
    }
    /**
	 * 获取：病情
	 */
    public Integer getBiaoxiaodanBingqingTypes() {
        return biaoxiaodanBingqingTypes;
    }


    /**
	 * 设置：病情
	 */
    public void setBiaoxiaodanBingqingTypes(Integer biaoxiaodanBingqingTypes) {
        this.biaoxiaodanBingqingTypes = biaoxiaodanBingqingTypes;
    }
    /**
	 * 获取：费用类型
	 */
    public Integer getBiaoxiaodanYiliaofeiyongTypes() {
        return biaoxiaodanYiliaofeiyongTypes;
    }


    /**
	 * 设置：费用类型
	 */
    public void setBiaoxiaodanYiliaofeiyongTypes(Integer biaoxiaodanYiliaofeiyongTypes) {
        this.biaoxiaodanYiliaofeiyongTypes = biaoxiaodanYiliaofeiyongTypes;
    }
    /**
	 * 获取：报销金额
	 */
    public Double getBiaoxiaodanNewJine() {
        return biaoxiaodanNewJine;
    }


    /**
	 * 设置：报销金额
	 */
    public void setBiaoxiaodanNewJine(Double biaoxiaodanNewJine) {
        this.biaoxiaodanNewJine = biaoxiaodanNewJine;
    }
    /**
	 * 获取：相关报销凭证
	 */
    public String getBiaoxiaodanFile() {
        return biaoxiaodanFile;
    }


    /**
	 * 设置：相关报销凭证
	 */
    public void setBiaoxiaodanFile(String biaoxiaodanFile) {
        this.biaoxiaodanFile = biaoxiaodanFile;
    }
    /**
	 * 获取：其他备注
	 */
    public String getBiaoxiaodanContent() {
        return biaoxiaodanContent;
    }


    /**
	 * 设置：其他备注
	 */
    public void setBiaoxiaodanContent(String biaoxiaodanContent) {
        this.biaoxiaodanContent = biaoxiaodanContent;
    }
    /**
	 * 获取：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：申请时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：审核状态
	 */
    public Integer getBiaoxiaodanYesnoTypes() {
        return biaoxiaodanYesnoTypes;
    }


    /**
	 * 设置：审核状态
	 */
    public void setBiaoxiaodanYesnoTypes(Integer biaoxiaodanYesnoTypes) {
        this.biaoxiaodanYesnoTypes = biaoxiaodanYesnoTypes;
    }
    /**
	 * 获取：审核意见
	 */
    public String getBiaoxiaodanYesnoText() {
        return biaoxiaodanYesnoText;
    }


    /**
	 * 设置：审核意见
	 */
    public void setBiaoxiaodanYesnoText(String biaoxiaodanYesnoText) {
        this.biaoxiaodanYesnoText = biaoxiaodanYesnoText;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
