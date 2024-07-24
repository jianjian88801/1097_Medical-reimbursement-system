package com.entity.model;

import com.entity.CaikuaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 财会审核人员
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class CaikuaiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 财会审核人员姓名
     */
    private String caikuaiName;


    /**
     * 财会审核人员手机号
     */
    private String caikuaiPhone;


    /**
     * 财会审核人员头像
     */
    private String caikuaiPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 电子邮箱
     */
    private String caikuaiEmail;


    /**
     * 创建时间
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
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：财会审核人员姓名
	 */
    public String getCaikuaiName() {
        return caikuaiName;
    }


    /**
	 * 设置：财会审核人员姓名
	 */
    public void setCaikuaiName(String caikuaiName) {
        this.caikuaiName = caikuaiName;
    }
    /**
	 * 获取：财会审核人员手机号
	 */
    public String getCaikuaiPhone() {
        return caikuaiPhone;
    }


    /**
	 * 设置：财会审核人员手机号
	 */
    public void setCaikuaiPhone(String caikuaiPhone) {
        this.caikuaiPhone = caikuaiPhone;
    }
    /**
	 * 获取：财会审核人员头像
	 */
    public String getCaikuaiPhoto() {
        return caikuaiPhoto;
    }


    /**
	 * 设置：财会审核人员头像
	 */
    public void setCaikuaiPhoto(String caikuaiPhoto) {
        this.caikuaiPhoto = caikuaiPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：电子邮箱
	 */
    public String getCaikuaiEmail() {
        return caikuaiEmail;
    }


    /**
	 * 设置：电子邮箱
	 */
    public void setCaikuaiEmail(String caikuaiEmail) {
        this.caikuaiEmail = caikuaiEmail;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
