package com.entity.model;

import com.entity.LingdaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 领导
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class LingdaoModel implements Serializable {
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
     * 领导姓名
     */
    private String lingdaoName;


    /**
     * 领导手机号
     */
    private String lingdaoPhone;


    /**
     * 领导头像
     */
    private String lingdaoPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 电子邮箱
     */
    private String lingdaoEmail;


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
	 * 获取：领导姓名
	 */
    public String getLingdaoName() {
        return lingdaoName;
    }


    /**
	 * 设置：领导姓名
	 */
    public void setLingdaoName(String lingdaoName) {
        this.lingdaoName = lingdaoName;
    }
    /**
	 * 获取：领导手机号
	 */
    public String getLingdaoPhone() {
        return lingdaoPhone;
    }


    /**
	 * 设置：领导手机号
	 */
    public void setLingdaoPhone(String lingdaoPhone) {
        this.lingdaoPhone = lingdaoPhone;
    }
    /**
	 * 获取：领导头像
	 */
    public String getLingdaoPhoto() {
        return lingdaoPhoto;
    }


    /**
	 * 设置：领导头像
	 */
    public void setLingdaoPhoto(String lingdaoPhoto) {
        this.lingdaoPhoto = lingdaoPhoto;
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
    public String getLingdaoEmail() {
        return lingdaoEmail;
    }


    /**
	 * 设置：电子邮箱
	 */
    public void setLingdaoEmail(String lingdaoEmail) {
        this.lingdaoEmail = lingdaoEmail;
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
