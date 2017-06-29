package com.web.entity;
import java.util.HashMap;
import java.util.Map;

import com.absmybatis.dao.annotation.EntityPK;
import com.absmybatis.dao.annotation.EntityColumn;
@EntityPK(Pk = "group_id", tableName = "TB_SYSR_GROUP")
public class TbSysrGroupDto {//
	//组ID
	@EntityColumn(dataType=1, typeName="CHAR", remarks = "组ID"  )
	private java.lang.String group_id;//组ID
	//组名
	@EntityColumn(dataType=12, typeName="VARCHAR2", remarks = "组名"  )
	private java.lang.String group_name;//组名
	//网点号
	@EntityColumn(dataType=1, typeName="CHAR", remarks = "网点号"  )
	private java.lang.String netno;//网点号
	//创建时间
	@EntityColumn(dataType=93, typeName="TIMESTAMP(6)", remarks = "创建时间"  )
	private String createtime;//创建时间
	//修改时间
	@EntityColumn(dataType=93, typeName="TIMESTAMP(6)", remarks = "修改时间"  )
	private String updatetime;//修改时间
	//创建人
	@EntityColumn(dataType=1, typeName="CHAR", remarks = "创建人"  )
	private java.lang.String create_user_id;//创建人
	//更新人
	@EntityColumn(dataType=1, typeName="CHAR", remarks = "更新人"  )
	private java.lang.String update_user_id;//更新人
	

   /**
	* 获取 组ID
	* @return
	*/
	public java.lang.String getGroup_id() {
		return group_id;
	}
	
   /**
	* 设置 组ID
	* @param group_id
	*/
 	public void setGroup_id(java.lang.String group_id) {
		this.group_id = group_id;
	}
	 

   /**
	* 获取 组名
	* @return
	*/
	public java.lang.String getGroup_name() {
		return group_name;
	}
	
   /**
	* 设置 组名
	* @param group_name
	*/
 	public void setGroup_name(java.lang.String group_name) {
		this.group_name = group_name;
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
	public String getCreatetime() {
		return createtime;
	}
	
   /**
	* 设置 创建时间
	* @param createtime
	*/
 	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	 

   /**
	* 获取 修改时间
	* @return
	*/
	public String getUpdatetime() {
		return updatetime;
	}
	
   /**
	* 设置 修改时间
	* @param updatetime
	*/
 	public void setUpdatetime(String updatetime) {
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
			 //propertyEnumMap.put("USER_STATE", new ChainMap<String,String>().chainPut("0", "无效").chainPut("1", "有效").chainPut("2", "密码锁定")) ; 
 		}
		public static Map<String, Map<String, String>> getPropertyEnumMap() {
			return propertyEnumMap;
		}
 		
 	}
}
