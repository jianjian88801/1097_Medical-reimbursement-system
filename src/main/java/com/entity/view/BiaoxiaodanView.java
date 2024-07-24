package com.entity.view;

import com.entity.BiaoxiaodanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 报销单
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("biaoxiaodan")
public class BiaoxiaodanView extends BiaoxiaodanEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 人员状态的值
		*/
		private String biaoxiaodanRenyuanValue;
		/**
		* 病情的值
		*/
		private String biaoxiaodanBingqingValue;
		/**
		* 费用类型的值
		*/
		private String biaoxiaodanYiliaofeiyongValue;
		/**
		* 审核状态的值
		*/
		private String biaoxiaodanYesnoValue;



		//级联表 caikuai
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
			* 电子邮箱
			*/
			private String caikuaiEmail;

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 用户手机号
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 用户头像
			*/
			private String yonghuPhoto;
			/**
			* 电子邮箱
			*/
			private String yonghuEmail;

	public BiaoxiaodanView() {

	}

	public BiaoxiaodanView(BiaoxiaodanEntity biaoxiaodanEntity) {
		try {
			BeanUtils.copyProperties(this, biaoxiaodanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 人员状态的值
			*/
			public String getBiaoxiaodanRenyuanValue() {
				return biaoxiaodanRenyuanValue;
			}
			/**
			* 设置： 人员状态的值
			*/
			public void setBiaoxiaodanRenyuanValue(String biaoxiaodanRenyuanValue) {
				this.biaoxiaodanRenyuanValue = biaoxiaodanRenyuanValue;
			}
			/**
			* 获取： 病情的值
			*/
			public String getBiaoxiaodanBingqingValue() {
				return biaoxiaodanBingqingValue;
			}
			/**
			* 设置： 病情的值
			*/
			public void setBiaoxiaodanBingqingValue(String biaoxiaodanBingqingValue) {
				this.biaoxiaodanBingqingValue = biaoxiaodanBingqingValue;
			}
			/**
			* 获取： 费用类型的值
			*/
			public String getBiaoxiaodanYiliaofeiyongValue() {
				return biaoxiaodanYiliaofeiyongValue;
			}
			/**
			* 设置： 费用类型的值
			*/
			public void setBiaoxiaodanYiliaofeiyongValue(String biaoxiaodanYiliaofeiyongValue) {
				this.biaoxiaodanYiliaofeiyongValue = biaoxiaodanYiliaofeiyongValue;
			}
			/**
			* 获取： 审核状态的值
			*/
			public String getBiaoxiaodanYesnoValue() {
				return biaoxiaodanYesnoValue;
			}
			/**
			* 设置： 审核状态的值
			*/
			public void setBiaoxiaodanYesnoValue(String biaoxiaodanYesnoValue) {
				this.biaoxiaodanYesnoValue = biaoxiaodanYesnoValue;
			}








				//级联表的get和set caikuai

					/**
					* 获取： 财会审核人员姓名
					*/
					public String getCaikuaiName() {
						return caikuaiName;
					}
					/**
					* 设置： 财会审核人员姓名
					*/
					public void setCaikuaiName(String caikuaiName) {
						this.caikuaiName = caikuaiName;
					}

					/**
					* 获取： 财会审核人员手机号
					*/
					public String getCaikuaiPhone() {
						return caikuaiPhone;
					}
					/**
					* 设置： 财会审核人员手机号
					*/
					public void setCaikuaiPhone(String caikuaiPhone) {
						this.caikuaiPhone = caikuaiPhone;
					}

					/**
					* 获取： 财会审核人员头像
					*/
					public String getCaikuaiPhoto() {
						return caikuaiPhoto;
					}
					/**
					* 设置： 财会审核人员头像
					*/
					public void setCaikuaiPhoto(String caikuaiPhoto) {
						this.caikuaiPhoto = caikuaiPhoto;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getCaikuaiEmail() {
						return caikuaiEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setCaikuaiEmail(String caikuaiEmail) {
						this.caikuaiEmail = caikuaiEmail;
					}











				//级联表的get和set yonghu

					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}

					/**
					* 获取： 用户手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 用户手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}

					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}

					/**
					* 获取： 用户头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 用户头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}




}
