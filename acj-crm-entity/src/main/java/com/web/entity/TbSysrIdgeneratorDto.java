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
@EntityPK(Pk = "entityname", tableName = "tb_sysr_idgenerator")
public class TbSysrIdgeneratorDto {//
	//
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = ""  )
	private java.lang.String currentvalue;//
	//
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = ""  )
	private java.lang.String entityname;//
	//
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = ""  )
	private java.lang.String step;//


   /**
	* 获取 
	* @return
	*/
	public java.lang.String getCurrentvalue() {
		return currentvalue;
	}
	
   /**
	* 设置 
	* @param currentvalue
	*/
 	public void setCurrentvalue(java.lang.String currentvalue) {
		this.currentvalue = currentvalue;
	}
	 

   /**
	* 获取 
	* @return
	*/
	public java.lang.String getEntityname() {
		return entityname;
	}
	
   /**
	* 设置 
	* @param entityname
	*/
 	public void setEntityname(java.lang.String entityname) {
		this.entityname = entityname;
	}
	 

   /**
	* 获取 
	* @return
	*/
	public java.lang.String getStep() {
		return step;
	}
	
   /**
	* 设置 
	* @param step
	*/
 	public void setStep(java.lang.String step) {
		this.step = step;
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
