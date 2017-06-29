package com.web.common.util.web;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.BeanMap;
import org.apache.log4j.Logger;

/**
 * 获取实体类属性并赋值
 * 
 * @author Administrator
 * 
 */
public class BeanRefUtil {
	private static final Logger LOGGER = Logger.getLogger(BeanRefUtil.class);

	/**
	 * 解析实体类，获得实体类的属性名称，根据属性名称 获取对应的值，并赋值给实体类
	 * 
	 * @param model
	 *            实体类
	 * @param map
	 *            结果集
	 * @return 返回实体类
	 */
	@SuppressWarnings("rawtypes")
	public static Object getRefBean(Object model, Map map) {

		// 获取实体类的所有属性，返回Field数组
		Field[] field = model.getClass().getDeclaredFields();

		try {
			for (int j = 0; j < field.length; j++) { // 遍历所有属性
				String name = field[j].getName(); // 获取属性的名字
				name = name.substring(0, 1).toUpperCase() + name.substring(1); // 将属性的首字符大写，方便构造get，set方法
				String type = field[j].getGenericType().toString(); // 获取属性的类型
				Method m = null;
				if (type.equals("class java.lang.String")) {
					m = model.getClass().getMethod("set" + name, String.class);
				}
				if (type.equals("class java.lang.Integer")) {
					m = model.getClass().getMethod("set" + name, Integer.class);
				}
				if (type.equals("class java.lang.Boolean")) {
					m = model.getClass().getMethod("set" + name, Boolean.class);
				}
				if (type.equals("class java.util.Date")) {
					m = model.getClass().getMethod("set" + name, Date.class);
				}
				if (type.equals("class java.lang.Double")) {
					m = model.getClass().getMethod("set" + name, Double.class);
				}
				// 后续用到类型可再添加

				if (m != null) {
					m.invoke(model, map.get(name.toUpperCase()));
				}
			}

			LOGGER.info("==赋值之后的实体====>" + model.toString());
		} catch (NoSuchMethodException e) {
			LOGGER.error(e.getMessage(),e);
		} catch (SecurityException e) {
			LOGGER.error(e.getMessage(),e);
		} catch (IllegalAccessException e) {
			LOGGER.error(e.getMessage(),e);
		} catch (IllegalArgumentException e) {
			LOGGER.error(e.getMessage(),e);
		} catch (InvocationTargetException e) {
			LOGGER.error(e.getMessage());
		}
		return model;

	}

	// Bean --> Map 1: 利用Introspector和PropertyDescriptor 将Bean --> Map
	public static Map<String, Object> transBean2Map(Object obj) {

		if (obj == null) {
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo
					.getPropertyDescriptors();
			for (PropertyDescriptor property : propertyDescriptors) {
				String key = property.getName();

				// 过滤class属性
				if (!key.equals("class")) {
					// 得到property对应的getter方法
					Method getter = property.getReadMethod();
					Object value = getter.invoke(obj);

					map.put(key, value);
				}

			}
		} catch (Exception e) {
			System.out.println("transBean2Map Error " + e);
		}

		return map;

	}

	/**
	 * 获取属性名数组
	 * */
	private static String[] getFiledName(Object o) {
		Field[] fields = o.getClass().getDeclaredFields();
		String[] fieldNames = new String[fields.length];
		for (int i = 0; i < fields.length; i++) {
			fieldNames[i] = fields[i].getName();
		}
		return fieldNames;
	}

	/**
	 * 根据属性名获取属性值
	 * */
	private static Object getFieldValueByName(String fieldName, Object o) {
		try {
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			String getter = "get" + firstLetter + fieldName.substring(1);
			Method method = o.getClass().getMethod(getter, new Class[] {});
			Object value = method.invoke(o, new Object[] {});
			return value;
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return null;
		}
	}

	/**
	 * 获取对象的所有属性值，返回一个对象数组
	 * */
	public static Object[] getFiledValues(Object o) {
		String[] fieldNames = getFiledName(o);
		Object[] value = new Object[fieldNames.length];
		for (int i = 0; i < fieldNames.length; i++) {
			value[i] = getFieldValueByName(fieldNames[i], o);
		}
		return value;
	}
	
	public static String getStrByObjArr(Object[] objArr){
		StringBuffer sb=new StringBuffer();
		for (int i = 0; i < objArr.length; i++) {
			if(i==0){
				sb.append(objArr[i]);
			}else{
				sb.append("|"+objArr[i]);
			}
		}
		return sb.toString();
	}
	
    /**
     * 将map转化为JavaBean
     *
     * @param map 待转化的Map
     * @param c   待转化成的类
     * @return 转化成的JavaBean对象
     * @throws InstantiationException 
     * @throws IllegalAccessException 
     */
    public static Object convertMapToObj( Map map, Class c ) throws InstantiationException, IllegalAccessException
    {
        if(map == null) return null;
        Object oc;
        try
        {
            oc = c.newInstance();
        }
        catch ( InstantiationException e )
        {
        	LOGGER.error(e.getMessage());
            e.printStackTrace();
        	throw e;
        }
        catch ( IllegalAccessException e )
        {
        	LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw  e;
        }
        BeanMap tmp = new BeanMap( oc );
        for ( Iterator iter = map.keySet().iterator(); iter.hasNext(); )
        {
            Object o = iter.next();
            Object value = map.get( o );
            if ( PropertyUtils.isWriteable( oc, o.toString() ) && value != null )
            {
                if ( value instanceof Number )
                {
                    if ( tmp.getType( o.toString() ).equals( Integer.class ) )
                        tmp.put( o, new Integer( ( ( Number ) value ).intValue() ) );
                    else if ( tmp.getType( o.toString() ).equals( Double.class ) )
                        tmp.put( o, new Double( ( ( Number ) value ).doubleValue() ) );
                    else if ( tmp.getType( o.toString() ).equals( Float.class ) )
                        tmp.put( o, new Float( ( ( Number ) value ).floatValue() ) );
                    else if ( tmp.getType( o.toString() ).equals( Long.class ) )
                        tmp.put( o, new Long( ( ( Number ) value ).longValue() ) );
                    else if ( tmp.getType( o.toString() ).equals( Short.class ) )
                        tmp.put( o, new Short( ( ( Number ) value ).shortValue() ) );
                    else if ( tmp.getType( o.toString() ).equals( Byte.class ) )
                        tmp.put( o, new Byte( ( ( Number ) value ).byteValue() ) );
                    else if ( tmp.getType( o.toString() ).equals( String.class ) )
                        tmp.put( o, value.toString() );
                    else tmp.put( o, value );
                }
                else
                    tmp.put( o, value );
            }
        }
        return tmp.getBean();
    }

    /**
     * //$like$:
     * @Description: 组装模糊查询条件
     * @param    
     * @return void  
     * @throws
     * @author witt.wang
     * @date 2016年5月7日
     */
    public static String setLikeConditon(String param){
    	if(param != null && !"".equals(param)){
    		param = "$like$:%"+param+"%";
    	}else{
    		param = "";
    	}
    	return param;
    }
	
}
