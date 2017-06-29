package com.absmybatis;

public class Sysparam {

	
	public static final String DB_TYPE_ORACLE ="ORACLE" ;
	
 
	public static final String DB_TYPE_MYSQL ="MYSQL" ;
 
	public static final String IDGENRATORTYPE_MYSQL_UUID ="UUID()" ;//UUID
	public static final String IDGENRATORTYPE_MYSQL_AUTO_ADD ="AUTO_ADD" ;//自增长
	public static final String IDGENRATORTYPE_ORACLE ="PKG_PUB_UTIL.ld_idgenerator" ;//包
 
	
	/**
	 * 该方法需要配置： 配置数据库类型
	 * @return
	 */
	public static final String  sysDbType(){
		return DB_TYPE_MYSQL ;
	}
	/**
	 * 配置oracle的主键
	 * @return
	 */
	public static final String  oracleIDGenratorType(){
		return IDGENRATORTYPE_ORACLE ;
	}
	
	public static final String mysqlIdGenratorType(){
		return IDGENRATORTYPE_MYSQL_UUID ;
	}
	public static final String sysIdIDGenratorType(){
		if(sysDbType().equals(DB_TYPE_ORACLE)){
			return oracleIDGenratorType();
		}else {
			return mysqlIdGenratorType();
		}
	}

	
	
	 
}
