package com.absmybatis.dao.mapper;

import java.util.ArrayList;
import java.util.Map;

import org.apache.log4j.Logger;

import com.absmybatis.Sysparam;
import com.absmybatis.exception.BaseDtoException;

/**
 * 插入sql提供者
 * @author jason.shu
 *
 */
public class InsertSqlProvider {
	private static final Logger LOGGER = Logger.getLogger(SelectSqlProvider.class);
	
	/*
	 *  SET("test_text = #{testBean.testText,javaType=string,jdbcType=VARCHAR}");  
        WHERE("test_id = #{testBean.id,javaType=string,jdbcType=VARCHAR}");  
	 */
	public String insertEntitySql(Map<String ,Object> parames)   {
		Object insertEntity = parames.get("entity") ; 
		String[] temp =  assembleInsertParam(insertEntity) ; 
		StringBuffer sql = new StringBuffer(" INSERT INTO ");
		sql.append(SqlProviderUtil.obtainTableName(insertEntity)) ; 
		sql.append(" ( ") ; 
		sql.append(temp[0].toUpperCase()) ; 
		sql.append(") VALUES ( ") ; 
		sql.append(temp[1]) ; 
		sql.append( " ) ") ; 
		LOGGER.debug(sql);
		return sql.toString(); 
	}
	 
	/**
	 * 组装insert参数
	 * @param o
	 * @return
	 * @throws Exception 
	 */
	private String[] assembleInsertParam(Object o ) {
		ArrayList<String>  paramKeyVlaues = SqlProviderUtil.obtainKeyValueByEntity(o);
		StringBuffer property = new StringBuffer(""); 
		StringBuffer value = new StringBuffer(""); 
		boolean isHavePk = false ; 
		String[] pk_keyes  = SqlProviderUtil.obtainPk(o).split(",")  ;
		 
		for(String paramKeyVlaue:paramKeyVlaues){
			int index = paramKeyVlaue.indexOf("=");
			String key =  paramKeyVlaue.substring(0, index).trim() ; 
			if(pk_keyes.length==1 && key.equals(pk_keyes[0])){
				isHavePk = true ; 
			}
			property = property.append(key +",");
			value = value.append(paramKeyVlaue.substring(index+1).trim() +",");
		}
		String[] result = new String[2] ; 
		if(pk_keyes.length==1 && isHavePk){
			result[0]=  property.substring(0,property.length()-1); 
			result[1]=  value.substring(0,value.length()-1); 
		}else if (pk_keyes.length==1 && !isHavePk){
			result[0]=  property+pk_keyes[0] ; 
			result[1]=  value+Sysparam.sysIdIDGenratorType() ; 
		}else{//联合主键  == pk_keyes.length==1 && isHavePk 但是，必须判断非空
			result[0]=  property.substring(0,property.length()-1); 
			result[1]=  value.substring(0,value.length()-1); 
			for(String pk_key:pk_keyes){
				if(result[0].indexOf(pk_key )>0){
					continue ;
				}
				throw new BaseDtoException("创建持久化语句失败，失败原因：该实体为联合主键，但是联合主键中有部分主键为空，为空字段为："+pk_key);
			}
		}
		return result; 
	}
	
}
