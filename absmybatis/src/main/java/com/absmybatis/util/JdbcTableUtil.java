package com.absmybatis.util ;

import com.absmybatis.exception.BaseDtoException;

/**
 * @author shuzhiyun
 */
public class JdbcTableUtil {
	
	/**
	 * 通过表名获得该表对应的实体的名称
	 * @param inputString
	 * @param firstCharacterUppercase
	 * @return
	 */
	public static String getCamelCaseString(String inputString,
			boolean firstCharacterUppercase) {
		StringBuilder sb = new StringBuilder();

		boolean nextUpperCase = false;
		for (int i = 0; i < inputString.length(); i++) {
			char c = inputString.charAt(i);

			switch (c) {
			case '_':
			case '-':
			case '@':
			case '$':
			case '#':
			case ' ':
				if (sb.length() > 0) {
					nextUpperCase = true;
				}
				break;

			default:
				if (nextUpperCase) {
					sb.append(Character.toUpperCase(c));
					nextUpperCase = false;
				} else {
					sb.append(Character.toLowerCase(c));
				}
				break;
			}
		}

		if (firstCharacterUppercase) {
			sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
		}

		return sb.toString();
	}

	/**
	 * add by  
	 * 
	 * @todo 替换换行、回车、tab符号;\r 换行、\t tab符合、\n 回车
	 * @param source
	 * @param target
	 * @return
	 */
	public static String clearMistyChars(String source, String target) {
		String ss = source.replaceAll("\r", target).replaceAll("\t", target)
				.replaceAll("\n", target);

		return ss;
	}

	/**
	 * 根据类型值返回类型名称
	 * @param typeValue
	 * @return
	 * @throws BaseDtoException
	 */
	public static String obtainJdbcTypeByTypeValue(int typeValue) throws BaseDtoException{
		switch(typeValue){
			case java.sql.Types.BIT :return "BIT" ;
			case java.sql.Types.TINYINT: return "TINYINT" ;
	        case java.sql.Types.SMALLINT: return "SMALLINT" ;
	        case java.sql.Types.INTEGER: return "INTEGER" ;
	        case java.sql.Types.BIGINT: return "BIGINT" ;
	        case java.sql.Types.FLOAT: return "FLOAT" ;
	        case java.sql.Types.REAL: return "REAL" ;
	        case java.sql.Types.DOUBLE: return "DOUBLE" ;
	        case java.sql.Types.NUMERIC: return "NUMERIC" ;
	        case java.sql.Types.DECIMAL: return "DECIMAL" ;
	        case java.sql.Types.CHAR: return "CHAR" ;
	        case java.sql.Types.VARCHAR:return "VARCHAR" ;
	        case java.sql.Types.LONGVARCHAR:return "LONGVARCHAR" ;
	        case java.sql.Types.DATE:return "DATE" ;
	        case java.sql.Types.TIME:return "TIME" ;
	        case java.sql.Types.TIMESTAMP:return "TIMESTAMP" ;
	        case java.sql.Types.BINARY:return "BINARY" ;
	        case java.sql.Types.VARBINARY:return "VARBINARY" ;
	        case java.sql.Types.LONGVARBINARY:return "LONGVARBINARY" ;
	        case java.sql.Types.NULL:return "NULL" ;
	        case java.sql.Types.OTHER:return "OTHER" ;
	        case java.sql.Types.JAVA_OBJECT:return "JAVA_OBJECT" ;
	        case java.sql.Types.DISTINCT:return "DISTINCT" ;
	        case java.sql.Types.STRUCT:return "STRUCT" ;
	        case java.sql.Types.ARRAY:return "ARRAY" ;
	        case java.sql.Types.BLOB:return "BLOB" ;
	        case java.sql.Types.CLOB:return "CLOB" ;
	        case java.sql.Types.REF:return "REF" ;
		    case java.sql.Types.DATALINK:return "DATALINK" ;
		    case java.sql.Types.BOOLEAN:return "BOOLEAN" ;
		    case java.sql.Types.ROWID:return "ROWID" ;
		    case java.sql.Types.NCHAR:return "NCHAR" ;
		    case java.sql.Types.NVARCHAR:return "NVARCHAR" ;
		    case java.sql.Types.LONGNVARCHAR:return "LONGNVARCHAR" ;
		    case java.sql.Types.NCLOB:return "NCLOB" ;
		    case java.sql.Types.SQLXML:return "SQLXML";
		}
		throw new BaseDtoException("数据库类型错误");
		
	}
}
