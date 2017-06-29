package com.absmybatis.dao.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface EntityColumn {
	/*
	 * 与java.sql.Types相同 具体参见如下最后的注释
	 */
	int dataType();
	/*
	 * columnType =12 时，columnTypeName有可能等于varchar或者varchar2 
	 * 字段名称。如：varchar ,varchar2 ,number等 
	 */
	String typeName();
	/*
	 * REMARKS String => 描述列的注释（可为 null）
	 * @return
	 */
	String remarks();
//	/*
//	 * # NULLABLE int => 是否允许使用 NULL。
//	 *  1=可以用空  0=不可以为空
//	 * @return
//	 */
//	int nullable() default 1;
//	/*
//	 * 列的大小。对于 char 或 date 类型，
//	 * 列的大小是最大字符数，
//	 * 对于 numeric 和 decimal 类型，列的大小就是精度。
//	 */
//	int column_size() default 0 ; 
//	/*
//	 * 小数部分的位数
//	 * @return
//	 */
//	int decimal_digits() default 0 ;
//	
//	/*
//	 * COLUMN_DEF String => 默认值（可为 null）
//	 */
//	String columnDef() default "";
//	/*
//	 * 对于 char 类型，该长度是列中的最大字节数
//	 * @return
//	 */
//	int charOctetLength() default 0 ;
	
	
}
/*
        public final static int BIT             =  -7;
        public final static int TINYINT         =  -6;
        public final static int SMALLINT        =   5;
        public final static int INTEGER         =   4;
        public final static int BIGINT          =  -5;
        public final static int FLOAT           =   6;
        public final static int REAL            =   7;
        public final static int DOUBLE          =   8;
        public final static int NUMERIC         =   2;
        public final static int DECIMAL         =   3;
        public final static int CHAR            =   1;
        public final static int VARCHAR         =  12;
        public final static int LONGVARCHAR     =  -1;
        public final static int DATE            =  91;
        public final static int TIME            =  92;
        public final static int TIMESTAMP       =  93;
        public final static int BINARY          =  -2;
        public final static int VARBINARY       =  -3;
        public final static int LONGVARBINARY   =  -4;
        public final static int NULL            =   0;
        public final static int OTHER           = 1111;
        public final static int JAVA_OBJECT         = 2000;
        public final static int DISTINCT            = 2001;
        public final static int STRUCT              = 2002;
        public final static int ARRAY               = 2003;
        public final static int BLOB                = 2004;
        public final static int CLOB                = 2005;
        public final static int REF                 = 2006;
	    public final static int DATALINK = 70;
	    public final static int BOOLEAN = 16;
	    public final static int ROWID = -8;
	    public static final int NCHAR = -15;
	    public static final int NVARCHAR = -9;
	    public static final int LONGNVARCHAR = -16;
	    public static final int NCLOB = 2011;
	    public static final int SQLXML = 2009;
*/