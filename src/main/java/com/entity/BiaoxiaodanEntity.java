package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 报销单
 *
 * @author 
 * @email
 */
@TableName("biaoxiaodan")
public class BiaoxiaodanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public BiaoxiaodanEntity() {

	}

	public BiaoxiaodanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 用户
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 财会审核人员
     */
    @TableField(value = "caikuai_id")

    private Integer caikuaiId;


    /**
     * 报销单编号
     */
    @TableField(value = "biaoxiaodan_uuid_number")

    private String biaoxiaodanUuidNumber;


    /**
     * 报销单名称
     */
    @TableField(value = "biaoxiaodan_name")

    private String biaoxiaodanName;


    /**
     * 报销人姓名
     */
    @TableField(value = "biaoxiaodan_baoxiaoren_name")

    private String biaoxiaodanBaoxiaorenName;


    /**
     * 报销人头像照片
     */
    @TableField(value = "biaoxiaodan_baoxiaoren_photo")

    private String biaoxiaodanBaoxiaorenPhoto;


    /**
     * 身份证正面
     */
    @TableField(value = "biaoxiaodan_baoxiaoren_shenfenzhengz_photo")

    private String biaoxiaodanBaoxiaorenShenfenzhengzPhoto;


    /**
     * 身份证反面
     */
    @TableField(value = "biaoxiaodan_baoxiaoren_shenfenzhengf_photo")

    private String biaoxiaodanBaoxiaorenShenfenzhengfPhoto;


    /**
     * 报销人联系方式
     */
    @TableField(value = "biaoxiaodan_baoxiaoren_phone")

    private String biaoxiaodanBaoxiaorenPhone;


    /**
     * 报销人身份证号
     */
    @TableField(value = "biaoxiaodan_baoxiaoren_id_number")

    private String biaoxiaodanBaoxiaorenIdNumber;


    /**
     * 人员状态
     */
    @TableField(value = "biaoxiaodan_renyuan_types")

    private Integer biaoxiaodanRenyuanTypes;


    /**
     * 病情
     */
    @TableField(value = "biaoxiaodan_bingqing_types")

    private Integer biaoxiaodanBingqingTypes;


    /**
     * 费用类型
     */
    @TableField(value = "biaoxiaodan_yiliaofeiyong_types")

    private Integer biaoxiaodanYiliaofeiyongTypes;


    /**
     * 报销金额
     */
    @TableField(value = "biaoxiaodan_new_jine")

    private Double biaoxiaodanNewJine;


    /**
     * 相关报销凭证
     */
    @TableField(value = "biaoxiaodan_file")

    private String biaoxiaodanFile;


    /**
     * 其他备注
     */
    @TableField(value = "biaoxiaodan_content")

    private String biaoxiaodanContent;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 审核状态
     */
    @TableField(value = "biaoxiaodan_yesno_types")

    private Integer biaoxiaodanYesnoTypes;


    /**
     * 审核意见
     */
    @TableField(value = "biaoxiaodan_yesno_text")

    private String biaoxiaodanYesnoText;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：财会审核人员
	 */
    public Integer getCaikuaiId() {
        return caikuaiId;
    }
    /**
	 * 获取：财会审核人员
	 */

    public void setCaikuaiId(Integer caikuaiId) {
        this.caikuaiId = caikuaiId;
    }
    /**
	 * 设置：报销单编号
	 */
    public String getBiaoxiaodanUuidNumber() {
        return biaoxiaodanUuidNumber;
    }
    /**
	 * 获取：报销单编号
	 */

    public void setBiaoxiaodanUuidNumber(String biaoxiaodanUuidNumber) {
        this.biaoxiaodanUuidNumber = biaoxiaodanUuidNumber;
    }
    /**
	 * 设置：报销单名称
	 */
    public String getBiaoxiaodanName() {
        return biaoxiaodanName;
    }
    /**
	 * 获取：报销单名称
	 */

    public void setBiaoxiaodanName(String biaoxiaodanName) {
        this.biaoxiaodanName = biaoxiaodanName;
    }
    /**
	 * 设置：报销人姓名
	 */
    public String getBiaoxiaodanBaoxiaorenName() {
        return biaoxiaodanBaoxiaorenName;
    }
    /**
	 * 获取：报销人姓名
	 */

    public void setBiaoxiaodanBaoxiaorenName(String biaoxiaodanBaoxiaorenName) {
        this.biaoxiaodanBaoxiaorenName = biaoxiaodanBaoxiaorenName;
    }
    /**
	 * 设置：报销人头像照片
	 */
    public String getBiaoxiaodanBaoxiaorenPhoto() {
        return biaoxiaodanBaoxiaorenPhoto;
    }
    /**
	 * 获取：报销人头像照片
	 */

    public void setBiaoxiaodanBaoxiaorenPhoto(String biaoxiaodanBaoxiaorenPhoto) {
        this.biaoxiaodanBaoxiaorenPhoto = biaoxiaodanBaoxiaorenPhoto;
    }
    /**
	 * 设置：身份证正面
	 */
    public String getBiaoxiaodanBaoxiaorenShenfenzhengzPhoto() {
        return biaoxiaodanBaoxiaorenShenfenzhengzPhoto;
    }
    /**
	 * 获取：身份证正面
	 */

    public void setBiaoxiaodanBaoxiaorenShenfenzhengzPhoto(String biaoxiaodanBaoxiaorenShenfenzhengzPhoto) {
        this.biaoxiaodanBaoxiaorenShenfenzhengzPhoto = biaoxiaodanBaoxiaorenShenfenzhengzPhoto;
    }
    /**
	 * 设置：身份证反面
	 */
    public String getBiaoxiaodanBaoxiaorenShenfenzhengfPhoto() {
        return biaoxiaodanBaoxiaorenShenfenzhengfPhoto;
    }
    /**
	 * 获取：身份证反面
	 */

    public void setBiaoxiaodanBaoxiaorenShenfenzhengfPhoto(String biaoxiaodanBaoxiaorenShenfenzhengfPhoto) {
        this.biaoxiaodanBaoxiaorenShenfenzhengfPhoto = biaoxiaodanBaoxiaorenShenfenzhengfPhoto;
    }
    /**
	 * 设置：报销人联系方式
	 */
    public String getBiaoxiaodanBaoxiaorenPhone() {
        return biaoxiaodanBaoxiaorenPhone;
    }
    /**
	 * 获取：报销人联系方式
	 */

    public void setBiaoxiaodanBaoxiaorenPhone(String biaoxiaodanBaoxiaorenPhone) {
        this.biaoxiaodanBaoxiaorenPhone = biaoxiaodanBaoxiaorenPhone;
    }
    /**
	 * 设置：报销人身份证号
	 */
    public String getBiaoxiaodanBaoxiaorenIdNumber() {
        return biaoxiaodanBaoxiaorenIdNumber;
    }
    /**
	 * 获取：报销人身份证号
	 */

    public void setBiaoxiaodanBaoxiaorenIdNumber(String biaoxiaodanBaoxiaorenIdNumber) {
        this.biaoxiaodanBaoxiaorenIdNumber = biaoxiaodanBaoxiaorenIdNumber;
    }
    /**
	 * 设置：人员状态
	 */
    public Integer getBiaoxiaodanRenyuanTypes() {
        return biaoxiaodanRenyuanTypes;
    }
    /**
	 * 获取：人员状态
	 */

    public void setBiaoxiaodanRenyuanTypes(Integer biaoxiaodanRenyuanTypes) {
        this.biaoxiaodanRenyuanTypes = biaoxiaodanRenyuanTypes;
    }
    /**
	 * 设置：病情
	 */
    public Integer getBiaoxiaodanBingqingTypes() {
        return biaoxiaodanBingqingTypes;
    }
    /**
	 * 获取：病情
	 */

    public void setBiaoxiaodanBingqingTypes(Integer biaoxiaodanBingqingTypes) {
        this.biaoxiaodanBingqingTypes = biaoxiaodanBingqingTypes;
    }
    /**
	 * 设置：费用类型
	 */
    public Integer getBiaoxiaodanYiliaofeiyongTypes() {
        return biaoxiaodanYiliaofeiyongTypes;
    }
    /**
	 * 获取：费用类型
	 */

    public void setBiaoxiaodanYiliaofeiyongTypes(Integer biaoxiaodanYiliaofeiyongTypes) {
        this.biaoxiaodanYiliaofeiyongTypes = biaoxiaodanYiliaofeiyongTypes;
    }
    /**
	 * 设置：报销金额
	 */
    public Double getBiaoxiaodanNewJine() {
        return biaoxiaodanNewJine;
    }
    /**
	 * 获取：报销金额
	 */

    public void setBiaoxiaodanNewJine(Double biaoxiaodanNewJine) {
        this.biaoxiaodanNewJine = biaoxiaodanNewJine;
    }
    /**
	 * 设置：相关报销凭证
	 */
    public String getBiaoxiaodanFile() {
        return biaoxiaodanFile;
    }
    /**
	 * 获取：相关报销凭证
	 */

    public void setBiaoxiaodanFile(String biaoxiaodanFile) {
        this.biaoxiaodanFile = biaoxiaodanFile;
    }
    /**
	 * 设置：其他备注
	 */
    public String getBiaoxiaodanContent() {
        return biaoxiaodanContent;
    }
    /**
	 * 获取：其他备注
	 */

    public void setBiaoxiaodanContent(String biaoxiaodanContent) {
        this.biaoxiaodanContent = biaoxiaodanContent;
    }
    /**
	 * 设置：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：审核状态
	 */
    public Integer getBiaoxiaodanYesnoTypes() {
        return biaoxiaodanYesnoTypes;
    }
    /**
	 * 获取：审核状态
	 */

    public void setBiaoxiaodanYesnoTypes(Integer biaoxiaodanYesnoTypes) {
        this.biaoxiaodanYesnoTypes = biaoxiaodanYesnoTypes;
    }
    /**
	 * 设置：审核意见
	 */
    public String getBiaoxiaodanYesnoText() {
        return biaoxiaodanYesnoText;
    }
    /**
	 * 获取：审核意见
	 */

    public void setBiaoxiaodanYesnoText(String biaoxiaodanYesnoText) {
        this.biaoxiaodanYesnoText = biaoxiaodanYesnoText;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Biaoxiaodan{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", caikuaiId=" + caikuaiId +
            ", biaoxiaodanUuidNumber=" + biaoxiaodanUuidNumber +
            ", biaoxiaodanName=" + biaoxiaodanName +
            ", biaoxiaodanBaoxiaorenName=" + biaoxiaodanBaoxiaorenName +
            ", biaoxiaodanBaoxiaorenPhoto=" + biaoxiaodanBaoxiaorenPhoto +
            ", biaoxiaodanBaoxiaorenShenfenzhengzPhoto=" + biaoxiaodanBaoxiaorenShenfenzhengzPhoto +
            ", biaoxiaodanBaoxiaorenShenfenzhengfPhoto=" + biaoxiaodanBaoxiaorenShenfenzhengfPhoto +
            ", biaoxiaodanBaoxiaorenPhone=" + biaoxiaodanBaoxiaorenPhone +
            ", biaoxiaodanBaoxiaorenIdNumber=" + biaoxiaodanBaoxiaorenIdNumber +
            ", biaoxiaodanRenyuanTypes=" + biaoxiaodanRenyuanTypes +
            ", biaoxiaodanBingqingTypes=" + biaoxiaodanBingqingTypes +
            ", biaoxiaodanYiliaofeiyongTypes=" + biaoxiaodanYiliaofeiyongTypes +
            ", biaoxiaodanNewJine=" + biaoxiaodanNewJine +
            ", biaoxiaodanFile=" + biaoxiaodanFile +
            ", biaoxiaodanContent=" + biaoxiaodanContent +
            ", insertTime=" + insertTime +
            ", biaoxiaodanYesnoTypes=" + biaoxiaodanYesnoTypes +
            ", biaoxiaodanYesnoText=" + biaoxiaodanYesnoText +
            ", createTime=" + createTime +
        "}";
    }
}
