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
@EntityPK(Pk = "object_id", tableName = "tb_sysr_relation_user_role")
public class TbSysrRelationUserRoleDto {//
	//实体物理主键
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "实体物理主键"  )
	private java.lang.String object_id;//实体物理主键
	//用户ID
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "用户ID"  )
	private java.lang.String sysr_user_id;//用户ID
	//角色ID
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "角色ID"  )
	private java.lang.String sysr_role_id;//角色ID
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
	* 获取 实体物理主键
	* @return
	*/
	public java.lang.String getObject_id() {
		return object_id;
	}
	
   /**
	* 设置 实体物理主键
	* @param object_id
	*/
 	public void setObject_id(java.lang.String object_id) {
		this.object_id = object_id;
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
 	
}
