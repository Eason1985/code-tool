package com.web.entity;
import java.util.HashMap;
import java.util.Map;

import com.absmybatis.dao.annotation.EntityPK;
import com.absmybatis.dao.annotation.EntityColumn;

	
/**
 * 类功能:自动代码生成 DTO 
 * <p>创建者:</p>
 * <p>创建时间:</p>
 * <p>修改者:</p>
 * <p>修改时间:</p>
 * <p>修改原因：</p>
 * <p>审核者:</p>
 * <p>审核时间:</p>
 * <p>审核意见：</p>
 *
 */
@EntityPK(Pk = "logininfo_id", tableName = "tb_sysr_logininfo")
public class TbSysrLogininfoDto {//
	//登录信息ID
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "登录信息ID"  )
	private java.lang.String logininfo_id;//登录信息ID
	//用户代码
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "用户代码"  )
	private java.lang.String user_code;//用户代码
	//输入密码
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "输入密码"  )
	private java.lang.String in_pass;//输入密码
	//IP地址
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "IP地址"  )
	private java.lang.String ip_addr;//IP地址
	//验证码
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "验证码"  )
	private java.lang.String yzm;//验证码
	//网点号
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "网点号"  )
	private java.lang.String netno;//网点号
	//创建时间
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "创建时间"  )
	private java.lang.String createtime;//创建时间
	//创建人
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "创建人"  )
	private java.lang.String create_user_id;//创建人


   /**
	* 获取 登录信息ID
	* @return
	*/
	public java.lang.String getLogininfo_id() {
		return logininfo_id;
	}
	
   /**
	* 设置 登录信息ID
	* @param logininfo_id
	*/
 	public void setLogininfo_id(java.lang.String logininfo_id) {
		this.logininfo_id = logininfo_id;
	}
	 

   /**
	* 获取 用户代码
	* @return
	*/
	public java.lang.String getUser_code() {
		return user_code;
	}
	
   /**
	* 设置 用户代码
	* @param user_code
	*/
 	public void setUser_code(java.lang.String user_code) {
		this.user_code = user_code;
	}
	 

   /**
	* 获取 输入密码
	* @return
	*/
	public java.lang.String getIn_pass() {
		return in_pass;
	}
	
   /**
	* 设置 输入密码
	* @param in_pass
	*/
 	public void setIn_pass(java.lang.String in_pass) {
		this.in_pass = in_pass;
	}
	 

   /**
	* 获取 IP地址
	* @return
	*/
	public java.lang.String getIp_addr() {
		return ip_addr;
	}
	
   /**
	* 设置 IP地址
	* @param ip_addr
	*/
 	public void setIp_addr(java.lang.String ip_addr) {
		this.ip_addr = ip_addr;
	}
	 

   /**
	* 获取 验证码
	* @return
	*/
	public java.lang.String getYzm() {
		return yzm;
	}
	
   /**
	* 设置 验证码
	* @param yzm
	*/
 	public void setYzm(java.lang.String yzm) {
		this.yzm = yzm;
	}
	 

   /**
	* 获取 网点号
	* @return
	*/
	public java.lang.String getNetno() {
		return netno;
	}
	
   /**
	* 设置 网点号
	* @param netno
	*/
 	public void setNetno(java.lang.String netno) {
		this.netno = netno;
	}
	 

   /**
	* 获取 创建时间
	* @return
	*/
	public java.lang.String getCreatetime() {
		return createtime;
	}
	
   /**
	* 设置 创建时间
	* @param createtime
	*/
 	public void setCreatetime(java.lang.String createtime) {
		this.createtime = createtime;
	}
	 

   /**
	* 获取 创建人
	* @return
	*/
	public java.lang.String getCreate_user_id() {
		return create_user_id;
	}
	
   /**
	* 设置 创建人
	* @param create_user_id
	*/
 	public void setCreate_user_id(java.lang.String create_user_id) {
		this.create_user_id = create_user_id;
	}
	 


/**
 	 * 
 	 * 属性枚举类
 	 * 状态【正常,密码锁定,无效】
 	 * @author Administrator
 	 *
 	 */
 	public static  class PropertyEnum{
 		/*
 		 * 数据格式： 
 		 * <user_stat,<0,正常;1,密码锁定;2,无效>>
 		 */
 		private  static Map<String,Map<String,String>> propertyEnumMap = new HashMap<String,Map<String,String>>();
 		static{
 		}
		public static Map<String, Map<String, String>> getPropertyEnumMap() {
			return propertyEnumMap;
		}
 		
 	}
 	
}
