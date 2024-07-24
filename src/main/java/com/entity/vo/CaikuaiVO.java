package com.entity.vo;

import com.entity.CaikuaiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 财会审核人员
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("caikuai")
public class CaikuaiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 财会审核人员姓名
     */

    @TableField(value = "caikuai_name")
    private String caikuaiName;


    /**
     * 财会审核人员手机号
     */

    @TableField(value = "caikuai_phone")
    private String caikuaiPhone;


    /**
     * 财会审核人员头像
     */

    @TableField(value = "caikuai_photo")
    private String caikuaiPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 电子邮箱
     */

    @TableField(value = "caikuai_email")
    private String caikuaiEmail;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：财会审核人员姓名
	 */
    public String getCaikuaiName() {
        return caikuaiName;
    }


    /**
	 * 获取：财会审核人员姓名
	 */

    public void setCaikuaiName(String caikuaiName) {
        this.caikuaiName = caikuaiName;
    }
    /**
	 * 设置：财会审核人员手机号
	 */
    public String getCaikuaiPhone() {
        return caikuaiPhone;
    }


    /**
	 * 获取：财会审核人员手机号
	 */

    public void setCaikuaiPhone(String caikuaiPhone) {
        this.caikuaiPhone = caikuaiPhone;
    }
    /**
	 * 设置：财会审核人员头像
	 */
    public String getCaikuaiPhoto() {
        return caikuaiPhoto;
    }


    /**
	 * 获取：财会审核人员头像
	 */

    public void setCaikuaiPhoto(String caikuaiPhoto) {
        this.caikuaiPhoto = caikuaiPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：电子邮箱
	 */
    public String getCaikuaiEmail() {
        return caikuaiEmail;
    }


    /**
	 * 获取：电子邮箱
	 */

    public void setCaikuaiEmail(String caikuaiEmail) {
        this.caikuaiEmail = caikuaiEmail;
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

}
