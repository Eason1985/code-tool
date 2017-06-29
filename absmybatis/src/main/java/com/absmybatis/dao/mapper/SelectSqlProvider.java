package com.absmybatis.dao.mapper;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.absmybatis.Sysparam;
import com.absmybatis.common.AbsDto;
import com.absmybatis.common.IntervalQueryWare;
import com.absmybatis.common.SelectParamHandle;
import com.absmybatis.exception.BaseDtoException;
/**
 * 查询sql提供者
 * @author jason.shu
 *
 */
public class SelectSqlProvider {
	
	private final String ORDER_BY =" ORDER  BY " ;
	private static final Logger LOGGER = Logger.getLogger(SelectSqlProvider.class);
	
	//================select  a entity 
	public String selectObjectSql(Map<String ,Object> parames) throws Exception {
		Object obj = parames.get("entity") ; 
		String sql =  " SELECT * FROM " + SelectSqlProviderUtil.obtainTableName(obj)+ 
				" WHERE 1=1 " + assembleParam(obj)  ; 
		LOGGER.debug(sql);
		return	sql ;	  
	}
	
	//查询
	public String selectObjectHaveIntervalQuerySql(Map<String ,Object> parames) throws Exception {
		Object obj = parames.get("entity") ; 
		SelectParamHandle selectParamHandle = (SelectParamHandle)parames.get("selectParamHandle") ; 
		String sql =  " SELECT * FROM " + SelectSqlProviderUtil.obtainTableName(obj)+ 
				" WHERE 1=1 " + assembleParam(obj) 
				+ assembleIntervalQuery(obj , selectParamHandle) ; 
		LOGGER.debug(sql);
		return	sql ;	  
	}

	
	/***
	 * 区间条件查询时参数组合
	 * @param selectParamHandle
	 * @return
	 */
	private String assembleIntervalQuery(Object obj , SelectParamHandle selectParamHandle) {
		if(selectParamHandle == null||
				selectParamHandle.intervalQueryHandle()==null||
				selectParamHandle.intervalQueryHandle().size()==0||
				(!(obj instanceof AbsDto))){
			return "";
		}
		AbsDto o = (AbsDto)obj ; 
		ArrayList<IntervalQueryWare> intervalQueryWares = selectParamHandle.intervalQueryHandle();
		if(intervalQueryWares != null && intervalQueryWares.size()>0){
			StringBuffer sb = new StringBuffer("") ; 
			HashMap<String,Object> paramValues = new HashMap<String,Object>(); 
			Field[] propertyes  = o.getClass().getDeclaredFields() ; 
			int paramNum =0 ; 
			for(IntervalQueryWare intervalQueryWare: intervalQueryWares){
				a:for(Field property:propertyes){
					property.setAccessible(true);//当前private属性值
					if(property.getName().equals(intervalQueryWare.getProperty() )){
						paramNum++;
						// name = #{entity.name,jdbcType=VARCHAR }
						String keyvalue[] = SelectSqlProviderUtil.obtainKeyValueByProperty(property).split("#") ; 
						//keyvalue[0] = name = ; keyvalue[1] = {entity.name,jdbc=VARCHAR }
						//nameValue[0] =  #{entity.name; nameValue[1] = jdbc=VARCHAR }
						String nameValue[] = keyvalue[1].split(",") ; 
						//add name > #{entity._specialQueryValues.name_1,jdbcType=VARCHAR }
						sb.append(" and "+keyvalue[0].replace("=", intervalQueryWare.getInterval_type() )+
								" #{entity._intervalQueryValues."+intervalQueryWare.getProperty()+"_"+paramNum+","+nameValue[1]) ;
						paramValues.put(intervalQueryWare.getProperty()+"_"+paramNum, intervalQueryWare.getValue()) ; 
						break a ; 
					}
				}
			}
			o.set_intervalQueryValues(paramValues);
			return sb.toString().replace("  ", " ");
		}else{
			return ""; 
		}
	}

	/**
	 * select list  entity
	 * @param parames
	 * @return
	 * @throws Exception
	 */
	public String selectListSql(Map<String ,Object> parames) throws BaseDtoException {
		Object obj = parames.get("entity") ; 
		SelectParamHandle scb = null ; 
		String orderParam = "" ; 
		if(parames.containsKey("selectParamHandle")&&
				parames.get("selectParamHandle")!=null){
			scb =  	(SelectParamHandle) parames.get("selectParamHandle"); 
			orderParam = checkSpecialOrderParam(scb.getOrderParam()) ;
		}
		String sql =   " SELECT * FROM " + SelectSqlProviderUtil.obtainTableName(obj)+ 
				" WHERE 1=1 " + assembleParam(obj) + assembleIntervalQuery(obj , scb) 
				+ " " + orderParam ; 
		LOGGER.debug(sql);
		return sql ; 
	}

	
	/**
	 * 
	 * @param parames
	 * @return
	 * @throws Exception
	 */
	public String selectListByPageSql(Map<String ,Object> parames) throws BaseDtoException {
		if(Sysparam.DB_TYPE_ORACLE.equals(Sysparam.sysDbType())){
			return selectListByPageSqlForOracle(parames);
		}else if(Sysparam.DB_TYPE_MYSQL.equals(Sysparam.sysDbType())){
			return selectListByPageSqlForMysql(parames);
		}else {
			throw new BaseDtoException("数据库定义不正确");
		}
	}
	/**
	 * 	
	 * @param parames
	 * @return
	 */
	private String selectListByPageSqlForMysql(Map<String, Object> parames) {
		SelectParamHandle scb =  null;
		if(!parames.containsKey("selectParamHandle") || 
				parames.get("selectParamHandle")==null ){
			throw new BaseDtoException ("查询分页的数据时分页辅助类不能为空，因为需要提供分页信息");
		}else {
			scb = (SelectParamHandle) parames.get("selectParamHandle") ; 
			if(scb.getPage()==null||scb.getPageSize()==null){
				throw new BaseDtoException ("分页辅助类中的分页信息不明");
			}
		}
		/*
		 * 分页时，需要提供一个排序字段
		 */
		if(scb.getOrderParam()==null||scb.getOrderParam().trim().length()==0){
			String pkId = SqlProviderUtil.obtainPk(parames.get("entity"));
			if(pkId==null||pkId.trim().length()==0){
				throw new BaseDtoException("分页查询时,该表没有主键");
			}
			scb.setOrderParam(pkId);
		}
		String sql = selectListSql(parames);
		String tableName = SelectSqlProviderUtil.obtainTableName(parames.get("entity")) ;
		String pkString = SelectSqlProviderUtil.obtainPk(parames.get("entity")) ; 
		String[] pkes = pkString.split(",");
		StringBuffer pkIdEqual = new StringBuffer(" ) AS temp WHERE 1=1 ");
		for(String pk:pkes){
			pkIdEqual.append(" AND ");
			pkIdEqual.append("t."+pk +"= temp."+pk );
		}
		
		String[] whereAndOrder =  sql.split("WHERE")[1].split(ORDER_BY) ;
		String[] wheres =  whereAndOrder[0].split("AND") ;
		StringBuffer sbWhere = new StringBuffer(" WHERE 1=1 ");
		for(String where:wheres){
			if("1=1".equals(where.replace(" ", ""))){
				continue; 
			}
			//TODO
			sbWhere.append(" AND t."+where.trim()) ;
//			sbWhere.append(" AND t."+where) ;
		}
		whereAndOrder[1]=whereAndOrder[1].replace(",", ",t.").trim() ;
		
		StringBuffer sqlsb = new StringBuffer( " SELECT * FROM " + tableName) ; 
		sqlsb.append(" AS t")
			.append(sbWhere).append(ORDER_BY).append("t.").append(whereAndOrder[1]).append(" DESC LIMIT ").append((scb.getPage()-1)*scb.getPageSize()).append(",").append(scb.getPageSize());
		return sqlsb.toString() ;
	}
	/**
	 * 
	 * @param parames
	 * @return
	 * @throws Exception
	 */
	public String selectListByPageSqlForOracle(Map<String ,Object> parames) throws BaseDtoException {
		SelectParamHandle scb =  null;
		if(!parames.containsKey("selectParamHandle") || 
				parames.get("selectParamHandle")==null ){
			throw new BaseDtoException ("查询分页的数据时分页辅助类不能为空，因为需要提供分页信息");
		}else {
			scb = (SelectParamHandle) parames.get("selectParamHandle") ; 
			if(scb.getPage()==null||scb.getPageSize()==null){
				throw new BaseDtoException ("分页辅助类中的分页信息不明");
			}
		}
		/*
		 * 分页时，需要提供一个排序字段
		 */
		if(scb.getOrderParam().trim().length()==0){
			String pkId = SelectSqlProviderUtil.obtainPk(parames.get("entity"));
			if(pkId==null||pkId.trim().length()==0){
				throw new BaseDtoException("分页查询时,该表没有主键");
			}
			scb.setOrderParam(pkId);
		}
		String sql = selectListSql(parames);
		sql =  "SELECT * FROM ( SELECT t.* ,rownum rn FROM ("+ 
						sql
						+") t where  ROWNUM <= " +scb.getPage()*scb.getPageSize() +
				") where rn > " +((scb.getPage()-1)*scb.getPageSize()) ;
		LOGGER.debug(sql);
		return sql ;
	}
	
	
		
	/**
	 * 组装查询条数的sql
	 * @param parames
	 * @return
	 * @throws Exception
	 */
	public String selectCountSql(Map<String ,Object> parames) throws BaseDtoException {
		String sql = selectListSql(parames).replace("*", "count(1)") ; 
		LOGGER.debug(sql);
		return sql ;
	}
	/**
	 * 组装查询条数的sql
	 * @param parames
	 * @return
	 * @throws Exception
	 */
	public String selectCountSelectParamSql(Map<String ,Object> parames) throws BaseDtoException {
		String sql = selectListSql(parames).replace("*", "count(1)") ; 
		LOGGER.debug(sql);
		return sql ;
	}
		
	
	
	//==============private===========================================================
	/**
	 * 组装参数
	 * @param o
	 * @return
	 * @throws Exception
	 */
	private String assembleParam(Object o ) throws BaseDtoException{
		ArrayList<String>  paramKeyVlaues = SelectSqlProviderUtil.obtainKeyValueByEntity(o);
		StringBuffer sb = new StringBuffer(""); 
		for(String paramKeyVlaue:paramKeyVlaues){
			sb = sb.append(" AND "+paramKeyVlaue + " ");
		}
		return sb.toString(); 
	}
	/**
	 *   order by
	 * @param orderParam
	 * @return
	 */
	private String checkSpecialOrderParam(String orderParam) {
		if (orderParam ==null ||orderParam.trim().length()==0){
			return "";
		}else {
			if(!orderParam.replace(" ", "").trim().toUpperCase().startsWith("ORDERBY")){
				return  ORDER_BY  + orderParam.toUpperCase() ;
			}
		}
		return orderParam.toUpperCase();
	}

	
	
	public static class SelectSqlProviderUtil extends SqlProviderUtil{
		/**
		 * 获取key Value值
		 * @param o 
		 * @return  entity.property = #{entity.property,javaType=string,jdbcType=VARCHAR}   
		 * @throws Exception
		 */
		public static  ArrayList<String> obtainKeyValueByEntity(Object o ) throws BaseDtoException {
			ArrayList<String> result =new ArrayList<String>(); 
			Field[] propertyes  = o.getClass().getDeclaredFields() ; 
			for(Field property:propertyes){
				property.setAccessible(true);//当前private属性值
				try {
					if (property.get(o) != null && property.get(o).toString().trim().length() !=  0 ) {
						/*
						 * 如果该属性的值为：　$like$:***** 表示前台想使用模糊查询  ***** 为模糊查询的值
						 */
						if(property.get(o).toString().startsWith("$like$:") &&property.get(o).toString().split(":").length > 1){
							String kv =  obtainKeyValueByProperty( property) ; 
							result.add(kv.substring(0, kv.indexOf("="))+" like " +kv.substring(kv.indexOf("=")+1)) ;
							property.set(o,property.get(o).toString().substring( property.get(o).toString().indexOf(":")+1) );
						}else{
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
	}
}
