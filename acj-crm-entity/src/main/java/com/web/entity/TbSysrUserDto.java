package com.web.entity;
import java.util.HashMap;
import java.util.Map;

import com.absmybatis.dao.annotation.EntityPK;
import com.absmybatis.dao.annotation.EntityColumn;

import com.web.common.ChainMap;	
import java.util.EnumMap;		
	
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
@EntityPK(Pk = "sysr_user_id", tableName = "tb_sysr_user")
public class TbSysrUserDto {//
	//用户ID
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "用户ID"  )
	private java.lang.String sysr_user_id;//用户ID
	//用户代码
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "用户代码"  )
	private java.lang.String user_code;//用户代码
	//用户姓名
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "用户姓名"  )
	private java.lang.String user_name;//用户姓名
	//登录密码
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "登录密码"  )
	private java.lang.String password;//登录密码
	//手机号
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "手机号"  )
	private java.lang.String mobile;//手机号
	//电子邮箱
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "电子邮箱"  )
	private java.lang.String email;//电子邮箱
	//上次登录时间
	@EntityColumn(dataType=93, typeName="TIMESTAMP", remarks = "上次登录时间"  )
	private java.sql.Timestamp last_login_time;//上次登录时间
	//登录次数
	@EntityColumn(dataType=4, typeName="INT", remarks = "登录次数"  )
	private java.lang.Long login_count;//登录次数
	//每次登录密码错误次数
	@EntityColumn(dataType=4, typeName="INT", remarks = "每次登录密码错误次数"  )
	private java.lang.Long pass_error_num;//每次登录密码错误次数
	//用户状态
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "用户状态"  )
	private java.lang.String user_state;//用户状态
	//初始密码是否修改
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "初始密码是否修改"  )
	private java.lang.String init_pass_update;//初始密码是否修改
	//密码创建时间
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "密码创建时间"  )
	private java.lang.String create_pass_time;//密码创建时间
	//网点号
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "网点号"  )
	private java.lang.String netno;//网点号
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "token值"  )
	private java.lang.String token_value;//token值
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "token更新时间"  )
	private java.lang.String token_update_time;//token更新时间	
	
	
	//创建时间
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "创建时间"  )
	private java.lang.String createtime;//创建时间
	//修改时间
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "修改时间"  )
	private java.lang.String updatetime;//修改时间
	//创建人
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "创建人"  )
	private java.lang.String create_user_id;//创建人
	//更新人
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "更新人"  )
	private java.lang.String update_user_id;//更新人


   public java.lang.String getToken_value() {
		return token_value;
	}

	public void setToken_value(java.lang.String token_value) {
		this.token_value = token_value;
	}

	public java.lang.String getToken_update_time() {
		return token_update_time;
	}

	public void setToken_update_time(java.lang.String token_update_time) {
		this.token_update_time = token_update_time;
	}

/**
	* 获取 用户ID
	* @return
	*/
	public java.lang.String getSysr_user_id() {
		return sysr_user_id;
	}
	
   /**
	* 设置 用户ID
	* @param sysr_user_id
	*/
 	public void setSysr_user_id(java.lang.String sysr_user_id) {
		this.sysr_user_id = sysr_user_id;
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
	* 获取 用户姓名
	* @return
	*/
	public java.lang.String getUser_name() {
		return user_name;
	}
	
   /**
	* 设置 用户姓名
	* @param user_name
	*/
 	public void setUser_name(java.lang.String user_name) {
		this.user_name = user_name;
	}
	 

   /**
	* 获取 登录密码
	* @return
	*/
	public java.lang.String getPassword() {
		return password;
	}
	
   /**
	* 设置 登录密码
	* @param password
	*/
 	public void setPassword(java.lang.String password) {
		this.password = password;
	}
	 

   /**
	* 获取 手机号
	* @return
	*/
	public java.lang.String getMobile() {
		return mobile;
	}
	
   /**
	* 设置 手机号
	* @param mobile
	*/
 	public void setMobile(java.lang.String mobile) {
		this.mobile = mobile;
	}
	 

   /**
	* 获取 电子邮箱
	* @return
	*/
	public java.lang.String getEmail() {
		return email;
	}
	
   /**
	* 设置 电子邮箱
	* @param email
	*/
 	public void setEmail(java.lang.String email) {
		this.email = email;
	}
	 

   /**
	* 获取 上次登录时间
	* @return
	*/
	public java.sql.Timestamp getLast_login_time() {
		return last_login_time;
	}
	
   /**
	* 设置 上次登录时间
	* @param last_login_time
	*/
 	public void setLast_login_time(java.sql.Timestamp last_login_time) {
		this.last_login_time = last_login_time;
	}
	 

   /**
	* 获取 登录次数
	* @return
	*/
	public java.lang.Long getLogin_count() {
		return login_count;
	}
	
   /**
	* 设置 登录次数
	* @param login_count
	*/
 	public void setLogin_count(java.lang.Long login_count) {
		this.login_count = login_count;
	}
	 

   /**
	* 获取 每次登录密码错误次数
	* @return
	*/
	public java.lang.Long getPass_error_num() {
		return pass_error_num;
	}
	
   /**
	* 设置 每次登录密码错误次数
	* @param pass_error_num
	*/
 	public void setPass_error_num(java.lang.Long pass_error_num) {
		this.pass_error_num = pass_error_num;
	}
	 

   /**
	* 获取 用户状态
	* @return
	*/
	public java.lang.String getUser_state() {
		return user_state;
	}
	
   /**
	* 设置 用户状态
	* @param user_state
	*/
 	public void setUser_state(java.lang.String user_state) {
		this.user_state = user_state;
	}
	 

   /**
	* 获取 初始密码是否修改
	* @return
	*/
	public java.lang.String getInit_pass_update() {
		return init_pass_update;
	}
	
   /**
	* 设置 初始密码是否修改
	* @param init_pass_update
	*/
 	public void setInit_pass_update(java.lang.String init_pass_update) {
		this.init_pass_update = init_pass_update;
	}
	 

   /**
	* 获取 密码创建时间
	* @return
	*/
	public java.lang.String getCreate_pass_time() {
		return create_pass_time;
	}
	
   /**
	* 设置 密码创建时间
	* @param create_pass_time
	*/
 	public void setCreate_pass_time(java.lang.String create_pass_time) {
		this.create_pass_time = create_pass_time;
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
	* 获取 修改时间
	* @return
	*/
	public java.lang.String getUpdatetime() {
		return updatetime;
	}
	
   /**
	* 设置 修改时间
	* @param updatetime
	*/
 	public void setUpdatetime(java.lang.String updatetime) {
		this.updatetime = updatetime;
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
	* 获取 更新人
	* @return
	*/
	public java.lang.String getUpdate_user_id() {
		return update_user_id;
	}
	
   /**
	* 设置 更新人
	* @param update_user_id
	*/
 	public void setUpdate_user_id(java.lang.String update_user_id) {
		this.update_user_id = update_user_id;
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
			propertyEnumMap.put("USER_STATE", new ChainMap<String,String>()
					.chainPut("0", "正常")
					.chainPut("1", "密码锁定")
					.chainPut("2", "无效")
			) ; 
			propertyEnumMap.put("INIT_PASS_UPDATE", new ChainMap<String,String>()
					.chainPut("0", "否")
					.chainPut("1", "是")
			) ; 
 		}
		public static Map<String, Map<String, String>> getPropertyEnumMap() {
			return propertyEnumMap;
		}
 		
 	}
 	
	public static  enum USER_STATEEnum{
	
		/**
 		 *  正常
 		 */
 			USER_STATE_0("0"),
		/**
 		 *  密码锁定
 		 */
 			USER_STATE_1("1"),
		/**
 		 *  无效
 		 */
 			USER_STATE_2("2")
 			;
 		 
 		private String value;

	    public String getValue() {
	        return value;
	    }
	    
	    USER_STATEEnum(String value) {
	        this.value = value;
	    }
	    
	    public final static Map<USER_STATEEnum, String> map ;
	    static{
	    	map = new EnumMap<USER_STATEEnum, String>(USER_STATEEnum.class);
		 	map.put(USER_STATEEnum.USER_STATE_0 , "正常");
		 	map.put(USER_STATEEnum.USER_STATE_1 , "密码锁定");
		 	map.put(USER_STATEEnum.USER_STATE_2 , "无效");
	    }
	    /**
	     * 跟据value返回枚举对应的key
	     * 
	     * @param value
	     * @return NotifyErrorCode
	     */
	    public static USER_STATEEnum getEnum(String value) {
	    	USER_STATEEnum tmpKey = null;
	        for (USER_STATEEnum tmpEnum : USER_STATEEnum.values()) {
	            if (tmpEnum.value.equals(value)) {
	                tmpKey = tmpEnum;
	                break;
	            }
	        }
	        return tmpKey;
	    }
	    /**
	     * 返回NotifyErrorCode对应的描述.
	     * @param value int.
	     * @return String
	     */
	    public static String getEnumDesc(final String value) {
	        return USER_STATEEnum.map.get(
	        		USER_STATEEnum.getEnum(value));
	    }
	    
 	}	
	public static  enum INIT_PASS_UPDATEEnum{
	
		/**
 		 *  否
 		 */
 			INIT_PASS_UPDATE_0("0"),
		/**
 		 *  是
 		 */
 			INIT_PASS_UPDATE_1("1")
 			;
 		 
 		private String value;

	    public String getValue() {
	        return value;
	    }
	    
	    INIT_PASS_UPDATEEnum(String value) {
	        this.value = value;
	    }
	    
	    public final static Map<INIT_PASS_UPDATEEnum, String> map ;
	    static{
	    	map = new EnumMap<INIT_PASS_UPDATEEnum, String>(INIT_PASS_UPDATEEnum.class);
		 	map.put(INIT_PASS_UPDATEEnum.INIT_PASS_UPDATE_0 , "否");
		 	map.put(INIT_PASS_UPDATEEnum.INIT_PASS_UPDATE_1 , "是");
	    }
	    /**
	     * 跟据value返回枚举对应的key
	     * 
	     * @param value
	     * @return NotifyErrorCode
	     */
	    public static INIT_PASS_UPDATEEnum getEnum(String value) {
	    	INIT_PASS_UPDATEEnum tmpKey = null;
	        for (INIT_PASS_UPDATEEnum tmpEnum : INIT_PASS_UPDATEEnum.values()) {
	            if (tmpEnum.value.equals(value)) {
	                tmpKey = tmpEnum;
	                break;
	            }
	        }
	        return tmpKey;
	    }
	    /**
	     * 返回NotifyErrorCode对应的描述.
	     * @param value int.
	     * @return String
	     */
	    public static String getEnumDesc(final String value) {
	        return INIT_PASS_UPDATEEnum.map.get(
	        		INIT_PASS_UPDATEEnum.getEnum(value));
	    }
	    
 	}	
}
