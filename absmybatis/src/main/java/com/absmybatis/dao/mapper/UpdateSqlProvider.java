package com.absmybatis.dao.mapper;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;

import org.apache.log4j.Logger;

import com.absmybatis.exception.BaseDtoException;

/**
 * 更新sql提供者
 * @author jason.shu
 *
 */
public class UpdateSqlProvider {
	private static final Logger LOGGER = Logger.getLogger(SelectSqlProvider.class);
	
	/**
	 * 根据主键update
	 * @param parames
	 * @return updateEntityByIdAllColumnSql
	 * @throws Exception
	 */
	public String updateEntityByIdAllColumnSql(Map<String ,Object> parames)   {
		Object updateEntity = parames.get("entity") ; 
		StringBuffer sql = new StringBuffer(" UPDATE ");
		sql.append(SqlProviderUtil.obtainTableName(updateEntity)) ; 
		sql.append(" SET ") ; 
		sql.append( assembleSetValue(updateEntity,true)) ; 
		sql.append(" WHERE 1=1 ") ; 
		sql.append(assembleWhereParam(updateEntity)) ; 
		LOGGER.debug(sql);
		return sql.toString(); 
		
	}
		
	
	
	/**
	 * 根据主键update
	 * @param parames
	 * @return updateEntityByIdAllColumnSql
	 * @throws Exception
	 */
	public String updateEntityByIdSql(Map<String ,Object> parames)   {
		Object updateEntity = parames.get("entity") ; 
		StringBuffer sql = new StringBuffer(" UPDATE ");
		sql.append(SqlProviderUtil.obtainTableName(updateEntity)) ; 
		sql.append(" SET ") ; 
		sql.append( assembleSetValue(updateEntity,false)) ; 
		sql.append(" WHERE 1=1 ") ; 
		sql.append(assembleWhereParam(updateEntity)) ; 
		LOGGER.debug(sql);
		return sql.toString(); 
	}
	 
	/**
	 * 组装更新set值
	 * @param o
	 * @return
	 * @throws Exception 
	 */
	private String assembleSetValue(Object o ,boolean valueIsCanNull ) {
		ArrayList<String>  paramKeyVlaues = SqlProviderUtil.obtainKeyValueByEntity(o,valueIsCanNull);
		StringBuffer sb = new StringBuffer(""); 
		boolean isFirst = true ; 
		for(String paramKeyVlaue:paramKeyVlaues){
			if(isFirst){
				sb = sb.append(" " + paramKeyVlaue +" ");
				isFirst = false ; 
			}else {
				sb = sb.append("," + paramKeyVlaue + " " );
			}
		}
		return sb.toString(); 
	}

	private String assembleWhereParam(Object updateEntity)   {
		String[] id_propertyes = SqlProviderUtil.obtainPk(updateEntity).split(",") ;//ID主键 -可以格式为id1,id2 . 
		StringBuffer sb = new StringBuffer(); 
		try {
			for(String id_property:id_propertyes){
				Field id_field = updateEntity.getClass().getDeclaredField(id_property) ;
				if(id_field==null){
					throw new BaseDtoException ("没有获取到主键属性(注意大小写):"+id_property); 
				}
				id_field.setAccessible(true);
				Object id = id_field.get(updateEntity) ; 
				if(id == null || id.toString().trim().length()==0){
					throw new BaseDtoException ("主键值为空,不能根据主键更新实体,实体:"+updateEntity+",属性为："+id_property); 
				}
				sb.append(" AND "+SqlProviderUtil.obtainKeyValueByProperty(id_field)) ;
			}
			//默认以主键为条件
			return sb.toString();
		} catch (BaseDtoException e) {
			e.printStackTrace();
			throw e; 
		} catch (Exception e) {
			e.printStackTrace();
			throw new BaseDtoException (""+updateEntity); 
		}
	}
	
}
