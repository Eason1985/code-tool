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
@EntityPK(Pk = "param_id", tableName = "tbs_run_param")
public class TbsRunParamDto {//
	//参数ID
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "参数ID"  )
	private java.lang.String param_id;//参数ID
	//维修厂编号
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "维修厂编号"  )
	private java.lang.String repair_comp_id;//维修厂编号
	//参数KEY
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "参数KEY"  )
	private java.lang.String paramkey;//参数KEY
	//参数名称
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "参数名称"  )
	private java.lang.String paramname;//参数名称
	//参数值
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "参数值"  )
	private java.lang.String paramvalue;//参数值
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
	* 获取 参数ID
	* @return
	*/
	public java.lang.String getParam_id() {
		return param_id;
	}
	
   /**
	* 设置 参数ID
	* @param param_id
	*/
 	public void setParam_id(java.lang.String param_id) {
		this.param_id = param_id;
	}
	 

   /**
	* 获取 维修厂编号
	* @return
	*/
	public java.lang.String getRepair_comp_id() {
		return repair_comp_id;
	}
	
   /**
	* 设置 维修厂编号
	* @param repair_comp_id
	*/
 	public void setRepair_comp_id(java.lang.String repair_comp_id) {
		this.repair_comp_id = repair_comp_id;
	}
	 

   /**
	* 获取 参数KEY
	* @return
	*/
	public java.lang.String getParamkey() {
		return paramkey;
	}
	
   /**
	* 设置 参数KEY
	* @param paramkey
	*/
 	public void setParamkey(java.lang.String paramkey) {
		this.paramkey = paramkey;
	}
	 

   /**
	* 获取 参数名称
	* @return
	*/
	public java.lang.String getParamname() {
		return paramname;
	}
	
   /**
	* 设置 参数名称
	* @param paramname
	*/
 	public void setParamname(java.lang.String paramname) {
		this.paramname = paramname;
	}
	 

   /**
	* 获取 参数值
	* @return
	*/
	public java.lang.String getParamvalue() {
		return paramvalue;
	}
	
   /**
	* 设置 参数值
	* @param paramvalue
	*/
 	public void setParamvalue(java.lang.String paramvalue) {
		this.paramvalue = paramvalue;
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
