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
@EntityPK(Pk = "id", tableName = "tb_scene_trace_info")
public class TbSceneTraceInfoDto {//
	//
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = ""  )
	private java.lang.String id;//
	//场景
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "场景"  )
	private java.lang.String scene_id;//场景
	//跟踪时间
	@EntityColumn(dataType=93, typeName="DATETIME", remarks = "跟踪时间"  )
	private java.sql.Timestamp trace_time;//跟踪时间
	//跟踪人
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "跟踪人"  )
	private java.lang.String tracer;//跟踪人
	//跟踪描述
	@EntityColumn(dataType=-1, typeName="TEXT", remarks = "跟踪描述"  )
	private java.lang.String trace_describe;//跟踪描述
	//创建时间
	@EntityColumn(dataType=93, typeName="DATETIME", remarks = "创建时间"  )
	private java.sql.Timestamp gmt_created;//创建时间
	//修改时间
	@EntityColumn(dataType=93, typeName="DATETIME", remarks = "修改时间"  )
	private java.sql.Timestamp gmt_modified;//修改时间
	//创建人
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "创建人"  )
	private java.lang.String creator;//创建人
	//修改人
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "修改人"  )
	private java.lang.String modifier;//修改人
	//是否删除
	@EntityColumn(dataType=1, typeName="CHAR", remarks = "是否删除"  )
	private java.lang.String is_deleted;//是否删除


   /**
	* 获取 
	* @return
	*/
	public java.lang.String getId() {
		return id;
	}
	
   /**
	* 设置 
	* @param id
	*/
 	public void setId(java.lang.String id) {
		this.id = id;
	}
	 

   /**
	* 获取 场景
	* @return
	*/
	public java.lang.String getScene_id() {
		return scene_id;
	}
	
   /**
	* 设置 场景
	* @param scene_id
	*/
 	public void setScene_id(java.lang.String scene_id) {
		this.scene_id = scene_id;
	}
	 

   /**
	* 获取 跟踪时间
	* @return
	*/
	public java.sql.Timestamp getTrace_time() {
		return trace_time;
	}
	
   /**
	* 设置 跟踪时间
	* @param trace_time
	*/
 	public void setTrace_time(java.sql.Timestamp trace_time) {
		this.trace_time = trace_time;
	}
	 

   /**
	* 获取 跟踪人
	* @return
	*/
	public java.lang.String getTracer() {
		return tracer;
	}
	
   /**
	* 设置 跟踪人
	* @param tracer
	*/
 	public void setTracer(java.lang.String tracer) {
		this.tracer = tracer;
	}
	 

   /**
	* 获取 跟踪描述
	* @return
	*/
	public java.lang.String getTrace_describe() {
		return trace_describe;
	}
	
   /**
	* 设置 跟踪描述
	* @param trace_describe
	*/
 	public void setTrace_describe(java.lang.String trace_describe) {
		this.trace_describe = trace_describe;
	}
	 

   /**
	* 获取 创建时间
	* @return
	*/
	public java.sql.Timestamp getGmt_created() {
		return gmt_created;
	}
	
   /**
	* 设置 创建时间
	* @param gmt_created
	*/
 	public void setGmt_created(java.sql.Timestamp gmt_created) {
		this.gmt_created = gmt_created;
	}
	 

   /**
	* 获取 修改时间
	* @return
	*/
	public java.sql.Timestamp getGmt_modified() {
		return gmt_modified;
	}
	
   /**
	* 设置 修改时间
	* @param gmt_modified
	*/
 	public void setGmt_modified(java.sql.Timestamp gmt_modified) {
		this.gmt_modified = gmt_modified;
	}
	 

   /**
	* 获取 创建人
	* @return
	*/
	public java.lang.String getCreator() {
		return creator;
	}
	
   /**
	* 设置 创建人
	* @param creator
	*/
 	public void setCreator(java.lang.String creator) {
		this.creator = creator;
	}
	 

   /**
	* 获取 修改人
	* @return
	*/
	public java.lang.String getModifier() {
		return modifier;
	}
	
   /**
	* 设置 修改人
	* @param modifier
	*/
 	public void setModifier(java.lang.String modifier) {
		this.modifier = modifier;
	}
	 

   /**
	* 获取 是否删除
	* @return
	*/
	public java.lang.String getIs_deleted() {
		return is_deleted;
	}
	
   /**
	* 设置 是否删除
	* @param is_deleted
	*/
 	public void setIs_deleted(java.lang.String is_deleted) {
		this.is_deleted = is_deleted;
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
 		}
		public static Map<String, Map<String, String>> getPropertyEnumMap() {
			return propertyEnumMap;
		}
 		
 	}
 	
}
