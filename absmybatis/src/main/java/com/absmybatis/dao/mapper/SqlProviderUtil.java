package com.absmybatis.dao.mapper;

import java.lang.reflect.Field;
import java.util.ArrayList;

import com.absmybatis.dao.annotation.EntityColumn;
import com.absmybatis.dao.annotation.EntityPK;
import com.absmybatis.exception.BaseDtoException;
import com.absmybatis.util.JdbcTableUtil;

public class SqlProviderUtil {

	/**
	 * 获得表名
	 * @param o
	 * @return
	 * @throws Exception
	 */
	public static  String obtainTableName (Object o ) throws BaseDtoException{
		EntityPK entity = o.getClass().getAnnotation(EntityPK.class);
        if (entity == null || "".equals(entity.tableName())) {
        	throw  new BaseDtoException("该实体类没有与表对应");
        }
        return entity.tableName();
	}
	
	/*
	 * 根据  返回一个String,格式为： string(表示单个主键) string1,string2(表示联合主键)
	 */
	public static  String obtainPk(Object o ) throws BaseDtoException{
		EntityPK entity = o.getClass().getAnnotation(EntityPK.class);
        if (entity == null || "".equals(entity.Pk())) {
        	throw  new BaseDtoException("该实体类定义主键");
        }
        return entity.Pk();
	}
	
	public static EntityColumn obtainEntityColumn(Field f) throws BaseDtoException{
		EntityColumn column =  f.getAnnotation(EntityColumn.class);
		return column; 
	}
	/**
	 * 获得表名主键值
	 * 获取一个属性的主键值
	 * 主键值为空则返回空
	 */
	public static String obtainPkValue(Object o ) throws BaseDtoException{
		String key = obtainPk(o) ;
		Field[] propertyes  = o.getClass().getDeclaredFields() ;
		for(Field property:propertyes){
			property.setAccessible(true);//当前private属性值
			if(property.getName().equals(key)){
				try {
					return (String) property.get(o) ;
				} catch (Exception e) {
					e.printStackTrace();
					throw  new BaseDtoException("获取主键属性值出错:"+property.getName());
				}
			}
		}
		throw new BaseDtoException("主键属性不存在");
	}

	public static  ArrayList<String> obtainKeyValueByEntity(Object o ) throws BaseDtoException {
		return obtainKeyValueByEntity(o,false);
	} 
	/**
	 * 获取key Value值  (value非空)  
	 * @param o 
	 * @param valueIsCanNull true 表示参数值 为空也需要组装参数
	 * @return  entity.property = #{entity.property,javaType=string,jdbcType=VARCHAR}   
	 * @throws Exception
	 */
	public static  ArrayList<String> obtainKeyValueByEntity(Object o , boolean valueIsCanNull) throws BaseDtoException {
		ArrayList<String> result =new ArrayList<String>(); 
		Field[] propertyes  = o.getClass().getDeclaredFields() ; 
		for(Field property:propertyes){
			property.setAccessible(true);//当前private属性值
			try {
				if(valueIsCanNull){
					result.add(obtainKeyValueByProperty( property) ) ;
				}else{
					if (property.get(o) != null && property.get(o).toString().trim().length() !=  0 ) {
						result.add(obtainKeyValueByProperty( property) ) ;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new BaseDtoException("组装sql查询条件出错",e);
			}
		}
		return result ; 
	}
	
	
	/*
	 *return  entity.property = #{entity.property,javaType=string,jdbcType=VARCHAR}   
	 */
	public static  String obtainKeyValueByProperty( Field property)throws BaseDtoException {
		if(property==null){
			throw new BaseDtoException("组装sql查询条件出错,传入的属性为空");
		}
		property.setAccessible(true);//当前private属性值
		EntityColumn column = obtainEntityColumn(property) ;
		return " "+property.getName()+" = #{entity."+property.getName()+ ",jdbcType="+JdbcTableUtil.obtainJdbcTypeByTypeValue(column.dataType())+"} "  ;  
	}
	 
}
