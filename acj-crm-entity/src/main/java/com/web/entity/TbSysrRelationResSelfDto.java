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
@EntityPK(Pk = "relation_res_self_id", tableName = "tb_sysr_relation_res_self")
public class TbSysrRelationResSelfDto {//
	//资源自关联ID
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "资源自关联ID"  )
	private java.lang.String relation_res_self_id;//资源自关联ID
	//父资源
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "父资源"  )
	private java.lang.String parent_res_id;//父资源
	//优先级
	@EntityColumn(dataType=4, typeName="INT", remarks = "优先级"  )
	private java.lang.Long priority;//优先级
	//子资源
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "子资源"  )
	private java.lang.String child_res_id;//子资源
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
	* 获取 资源自关联ID
	* @return
	*/
	public java.lang.String getRelation_res_self_id() {
		return relation_res_self_id;
	}
	
   /**
	* 设置 资源自关联ID
	* @param relation_res_self_id
	*/
 	public void setRelation_res_self_id(java.lang.String relation_res_self_id) {
		this.relation_res_self_id = relation_res_self_id;
	}
	 

   /**
	* 获取 父资源
	* @return
	*/
	public java.lang.String getParent_res_id() {
		return parent_res_id;
	}
	
   /**
	* 设置 父资源
	* @param parent_res_id
	*/
 	public void setParent_res_id(java.lang.String parent_res_id) {
		this.parent_res_id = parent_res_id;
	}
	 

   /**
	* 获取 优先级
	* @return
	*/
	public java.lang.Long getPriority() {
		return priority;
	}
	
   /**
	* 设置 优先级
	* @param priority
	*/
 	public void setPriority(java.lang.Long priority) {
		this.priority = priority;
	}
	 

   /**
	* 获取 子资源
	* @return
	*/
	public java.lang.String getChild_res_id() {
		return child_res_id;
	}
	
   /**
	* 设置 子资源
	* @param child_res_id
	*/
 	public void setChild_res_id(java.lang.String child_res_id) {
		this.child_res_id = child_res_id;
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
 	
}
