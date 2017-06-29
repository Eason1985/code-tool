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
@EntityPK(Pk = "employee_message_id", tableName = "tbr_employee_message")
public class TbrEmployeeMessageDto {//
	//员工消息ID
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "员工消息ID"  )
	private java.lang.String employee_message_id;//员工消息ID
	//维修厂号
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "维修厂号"  )
	private java.lang.String netno;//维修厂号
	//用户ID
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "用户ID"  )
	private java.lang.String sysr_user_id;//用户ID
	//消息内容表
	@EntityColumn(dataType=-1, typeName="TEXT", remarks = "消息内容表"  )
	private java.lang.String message_context;//消息内容表
	//消息读取状态
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "消息读取状态"  )
	private java.lang.String message_state;//消息读取状态
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


   /**
	* 获取 员工消息ID
	* @return
	*/
	public java.lang.String getEmployee_message_id() {
		return employee_message_id;
	}
	
   /**
	* 设置 员工消息ID
	* @param employee_message_id
	*/
 	public void setEmployee_message_id(java.lang.String employee_message_id) {
		this.employee_message_id = employee_message_id;
	}
	 

   /**
	* 获取 维修厂号
	* @return
	*/
	public java.lang.String getNetno() {
		return netno;
	}
	
   /**
	* 设置 维修厂号
	* @param netno
	*/
 	public void setNetno(java.lang.String netno) {
		this.netno = netno;
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
	* 获取 消息内容表
	* @return
	*/
	public java.lang.String getMessage_context() {
		return message_context;
	}
	
   /**
	* 设置 消息内容表
	* @param message_context
	*/
 	public void setMessage_context(java.lang.String message_context) {
		this.message_context = message_context;
	}
	 

   /**
	* 获取 消息读取状态
	* @return
	*/
	public java.lang.String getMessage_state() {
		return message_state;
	}
	
   /**
	* 设置 消息读取状态
	* @param message_state
	*/
 	public void setMessage_state(java.lang.String message_state) {
		this.message_state = message_state;
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
 	 * 状态【0-正常,1-密码锁定,2-无效】
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
			propertyEnumMap.put("MESSAGE_STATE", new ChainMap<String,String>()
					.chainPut("0", "0-未读")
					.chainPut("1", "1-已读")
			) ; 
 		}
		public static Map<String, Map<String, String>> getPropertyEnumMap() {
			return propertyEnumMap;
		}
 		
 	}
 	
	public static  enum MESSAGE_STATEEnum{
	
		/**
 		 *  0-未读
 		 */
 			MESSAGE_STATE_0("0"),
		/**
 		 *  1-已读
 		 */
 			MESSAGE_STATE_1("1")
 			;
 		 
 		private String value;

	    public String getValue() {
	        return value;
	    }
	    
	    MESSAGE_STATEEnum(String value) {
	        this.value = value;
	    }
	    
	    public final static Map<MESSAGE_STATEEnum, String> map ;
	    static{
	    	map = new EnumMap<MESSAGE_STATEEnum, String>(MESSAGE_STATEEnum.class);
		 	map.put(MESSAGE_STATEEnum.MESSAGE_STATE_0 , "0-未读");
		 	map.put(MESSAGE_STATEEnum.MESSAGE_STATE_1 , "1-已读");
	    }
	    /**
	     * 跟据value返回枚举对应的key
	     * 
	     * @param value
	     * @return NotifyErrorCode
	     */
	    public static MESSAGE_STATEEnum getEnum(String value) {
	    	MESSAGE_STATEEnum tmpKey = null;
	        for (MESSAGE_STATEEnum tmpEnum : MESSAGE_STATEEnum.values()) {
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
	        return MESSAGE_STATEEnum.map.get(
	        		MESSAGE_STATEEnum.getEnum(value));
	    }
	    
 	}	
}
