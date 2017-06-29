package com.web.entity;
import java.util.EnumMap;
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
@EntityPK(Pk = "sysr_role_id", tableName = "tb_sysr_role")
public class TbSysrRoleDto {//
	//角色ID
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "角色ID"  )
	private java.lang.String sysr_role_id;//角色ID
	//角色名
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "角色名"  )
	private java.lang.String role_name;//角色名
	//角色描述
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "角色描述"  )
	private java.lang.String description;//角色描述
	//角色组
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "角色组"  )
	private java.lang.String role_group;//角色组
	//网点号
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "网点号"  )
	private java.lang.String netno;//网点号
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
	* 获取 角色ID
	* @return
	*/
	public java.lang.String getSysr_role_id() {
		return sysr_role_id;
	}
	
   /**
	* 设置 角色ID
	* @param sysr_role_id
	*/
 	public void setSysr_role_id(java.lang.String sysr_role_id) {
		this.sysr_role_id = sysr_role_id;
	}
	 

   /**
	* 获取 角色名
	* @return
	*/
	public java.lang.String getRole_name() {
		return role_name;
	}
	
   /**
	* 设置 角色名
	* @param role_name
	*/
 	public void setRole_name(java.lang.String role_name) {
		this.role_name = role_name;
	}
	 

   /**
	* 获取 角色描述
	* @return
	*/
	public java.lang.String getDescription() {
		return description;
	}
	
   /**
	* 设置 角色描述
	* @param description
	*/
 	public void setDescription(java.lang.String description) {
		this.description = description;
	}
	 

   /**
	* 获取 角色组
	* @return
	*/
	public java.lang.String getRole_group() {
		return role_group;
	}
	
   /**
	* 设置 角色组
	* @param role_group
	*/
 	public void setRole_group(java.lang.String role_group) {
		this.role_group = role_group;
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
 		}
		public static Map<String, Map<String, String>> getPropertyEnumMap() {
			return propertyEnumMap;
		}
 		
 	}
 	public static  enum SYSR_ROLE_IDEnum{
 		
		/**
 		 *  超级管理员
 		 */
 		SYSR_ROLE_ID_000("000"),
		/**
 		 *  一般员工
 		 */
 		SYSR_ROLE_ID_001("001"),
 		/**
 		 *  老板
 		 */
 		SYSR_ROLE_ID_003("003"),
 		/**
 		 *  接待
 		 */
 		SYSR_ROLE_ID_004("004"),
 		/**
 		 *  仓管
 		 */
 		SYSR_ROLE_ID_005("005"),
 		/**
 		 *  钣金
 		 */
 		SYSR_ROLE_ID_010("010"),
 		/**
 		 *  喷漆
 		 */
 		SYSR_ROLE_ID_011("011"),
 		/**
 		 *  机修
 		 */
 		SYSR_ROLE_ID_014("014"),
 		/**
 		 *  洗车
 		 */
 		SYSR_ROLE_ID_015("015")
 			;
 		 
 		private String value;

	    public String getValue() {
	        return value;
	    }
	    
	    SYSR_ROLE_IDEnum(String value) {
	        this.value = value;
	    }
	    
	    public final static Map<SYSR_ROLE_IDEnum, String> map ;
	    static{
	    	map = new EnumMap<SYSR_ROLE_IDEnum, String>(SYSR_ROLE_IDEnum.class);
		 	map.put(SYSR_ROLE_IDEnum.SYSR_ROLE_ID_000 , "超级管理员");
		 	map.put(SYSR_ROLE_IDEnum.SYSR_ROLE_ID_001 , "一般员工");
		 	map.put(SYSR_ROLE_IDEnum.SYSR_ROLE_ID_003 , "老板");
		 	map.put(SYSR_ROLE_IDEnum.SYSR_ROLE_ID_004 , "接待");
		 	map.put(SYSR_ROLE_IDEnum.SYSR_ROLE_ID_005 , "仓管");
		 	map.put(SYSR_ROLE_IDEnum.SYSR_ROLE_ID_010 , "钣金");
		 	map.put(SYSR_ROLE_IDEnum.SYSR_ROLE_ID_011 , "喷漆");
		 	map.put(SYSR_ROLE_IDEnum.SYSR_ROLE_ID_014 , "机修");
		 	map.put(SYSR_ROLE_IDEnum.SYSR_ROLE_ID_015 , "洗车");
	    }
	    /**
	     * 跟据value返回枚举对应的key
	     * 
	     * @param value
	     * @return NotifyErrorCode
	     */
	    public static SYSR_ROLE_IDEnum getEnum(String value) {
	    	SYSR_ROLE_IDEnum tmpKey = null;
	        for (SYSR_ROLE_IDEnum tmpEnum : SYSR_ROLE_IDEnum.values()) {
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
	        return SYSR_ROLE_IDEnum.map.get(
	        		SYSR_ROLE_IDEnum.getEnum(value));
	    }
	    
 	}	
}
