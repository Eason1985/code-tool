package com.absmybatis.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.absmybatis.exception.BaseDtoException;


public class BeanMapUtil  {
	/**
	 * 
	 * @param type
	 * @param map
	 * @return
	 * @throws IntrospectionException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 */
	@SuppressWarnings("rawtypes")
	public static Object Map2Bean(Class type, Map map)
			throws BaseDtoException  {
		if (map == null) {
			return null;
		}
		BeanInfo beanInfo = null;
		try {
			beanInfo = Introspector.getBeanInfo(type);
		} catch (IntrospectionException e) {
			e.printStackTrace();
			throw new BaseDtoException("对象转换出问题!");
		}

		Object obj = null ;
		try {
			obj = type.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new BaseDtoException("对象转换出问题!");
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new BaseDtoException("对象转换出问题!");
		}

		PropertyDescriptor[] propertyDescriptors = beanInfo
				.getPropertyDescriptors();

		for (int i = 0; i < propertyDescriptors.length; ++i) {
			PropertyDescriptor descriptor = propertyDescriptors[i];
			String propertyName = descriptor.getName();
			if (!(map.containsKey(propertyName)||map.containsKey(propertyName.toUpperCase())))
				continue;
			Object value = map.get(propertyName.toUpperCase())==null?map.get(propertyName):map.get(propertyName.toUpperCase());
			try {
				/*
				 * 
				 * 修改于20151011日
				 * 如果数据库中是DATE类型，查询时，mybatis查询出来的值的类型为：class java.sql.Timestamp
				 * 如果数据库中是TIMSTAMP(6)类型，查询时，mybatis查询出来的值的类型为：class oracle.sql.TIMESTAMP
				 * 
				 * 无论数据库中是什么类型，全部将其转换为java.sql.Timestamp类型。
				 * 
				 */
				if(value!=null&&value.getClass().toString().equals("class oracle.sql.TIMESTAMP") ){
					value = DateUtil.date2javaSqlTimestamp(DateUtil.oracleSqlTIMESTAMP2javaSqlDate((oracle.sql.TIMESTAMP)value));
				}else if(value!=null&&value.getClass().toString().equals("class oracle.sql.CLOB") ){
					value = value.toString() ; 
				}else if(value!=null&&value.getClass().toString().equals("class oracle.sql.BLOB") ){
					value = oracleSqlBLOG2Bytes((oracle.sql.BLOB)value) ;
				}
				BeanUtils.setProperty(obj, propertyName, value);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				throw new BaseDtoException("对象转换出问题!");
			} catch (InvocationTargetException e) {
				e.printStackTrace();
				throw new BaseDtoException("对象转换出问题!");
			}  
		}
		return obj;
	}

	 private static byte[] oracleSqlBLOG2Bytes(oracle.sql.BLOB blob) {  
	        try {  
	            InputStream ins = blob.getBinaryStream();  
	            byte[] b = new byte[1024];  
	            int num = 0;  
	            String res = "";  
	            while ((num = ins.read(b)) != -1) {  
	                res += new String(b, 0, num);  
	            }  
	            return res.getBytes();  
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	        return null;  
	    }  
	 
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map bean2Map(Object bean) throws IntrospectionException,
			IllegalAccessException, InvocationTargetException {
		if(bean == null){
			return null; 
		}
		Class type = bean.getClass();
		Map returnMap = new HashMap();
		BeanInfo beanInfo = Introspector.getBeanInfo(type);

		PropertyDescriptor[] propertyDescriptors = beanInfo
				.getPropertyDescriptors();
		for (int i = 0; i < propertyDescriptors.length; ++i) {
			PropertyDescriptor descriptor = propertyDescriptors[i];
			String propertyName = descriptor.getName();
			if (!(propertyName.equals("class"))) {
				Method readMethod = descriptor.getReadMethod();
				Object result = readMethod.invoke(bean, new Object[0]);
				if (result != null)
					returnMap.put(propertyName, result);
				else {
					returnMap.put(propertyName, "");
				}
			}
		}
		return returnMap;
	}
}