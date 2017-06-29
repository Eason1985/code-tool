package com.absmybatis.dao.mapper;

import java.util.ArrayList;
import java.util.Map;

import org.apache.log4j.Logger;
/**
 * 删除sql提供者
 * @author jason.shu
 *
 */
public class DeleteSqlProvider {
	private static final Logger LOGGER = Logger.getLogger(SelectSqlProvider.class);
	
	public String deleteEntitySql(Map<String ,Object> parames)   {
		Object deleteEntity = parames.get("entity") ; 
		StringBuffer sql = new StringBuffer(" delete FROM ");
		sql.append(SqlProviderUtil.obtainTableName(deleteEntity)) ; 
		sql.append(" where 1=1 ") ; 
		sql.append(assembleParam(deleteEntity)) ; 
		LOGGER.debug(sql);
		return sql.toString(); 
	}
	 
	/**
	 * 组装参数
	 * @param o
	 * @return
	 * @throws Exception
	 */
	private String assembleParam(Object o ){
		ArrayList<String>  paramKeyVlaues = SqlProviderUtil.obtainKeyValueByEntity(o);
		StringBuffer sb = new StringBuffer(""); 
		for(String paramKeyVlaue:paramKeyVlaues){
			sb = sb.append(" and "+paramKeyVlaue + " ");
		}
		return sb.toString(); 
	}
	
}
