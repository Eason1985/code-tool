package com.web.common.util;

import java.lang.reflect.Field;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.util.StringUtils;

import com.web.common.ForeignKeyProperty;
import com.web.mapper.AllEntityMapperFactory;

public class PropertyValueChangeUtil {

	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss" ; 
	/**
	 * 该方法将枚举值转换为枚举描述 工具类
	 * 如 object 中属性 user_stat 其值为0 ；user_stat的枚举：0,无效;1,有效
	 * 该方法就是将该object中  user_stat 的值改为无效
	 * @param object
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void enumValue2Desc(Map object , Map<String,Map<String,String>> propertyEnumMap){
		Iterator it = object.keySet().iterator() ; 
		while(it.hasNext()){
			String propertyName = it.next().toString() ; 
			if(propertyEnumMap.containsKey(propertyName.toUpperCase())){
				Object properValue = object.get(propertyName);
				if(StringUtils.isEmpty(properValue)){
					continue;
				}else{
					properValue=properValue.toString().trim();
					Object enumDesc = propertyEnumMap.get(propertyName.toUpperCase()).get(properValue);
					object.put(propertyName,  //key
							StringUtils.isEmpty(object.get(propertyName))?
									"":enumDesc==null?"":enumDesc) ;
				}
				
			}
		}
	}
	
	@SuppressWarnings({ "rawtypes"  })
	public static void dateValue2Desc(Map object ){
		dateValue2Desc(object, DATE_FORMAT);
	}
	
	/**
	 * 该方法将枚举值转换为枚举描述 工具类
	 * 修改object的createtime 与 updatetime的字符
	 * @param object
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void dateValue2Desc(Map object ,String dateFormat ){
		SimpleDateFormat sdf = new SimpleDateFormat(StringUtils.isEmpty(dateFormat)?DATE_FORMAT:dateFormat);
		Set<String> keyes = object.keySet();
		for(String key:keyes){
			if(object.get(key) instanceof java.util.Date || object.get(key) instanceof java.sql.Date
					||object.get(key) instanceof java.sql.Timestamp){
				try {
					object.put(key, sdf.format(object.get(key)) ) ;
				} catch (Exception e) {
					
				} 
			}
		}
	}
	
	
	/**
	 * 外键
	 * @param objectMap
	 * @param foreignKeyProperties
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void foreignKey2Desc(Map objectMap , List<ForeignKeyProperty> foreignKeyProperties){
		Object o_temp = null; 
		String objectProperty = null ; 
		Field keyField = null ; 
		Field valueField = null ; 
		if(objectMap == null || foreignKeyProperties ==null || foreignKeyProperties.size() ==0 ){
			return ;
		}
		Set<String> objectProperties = objectMap.keySet() ; 
		try{
			for(ForeignKeyProperty foreignKeyProperty:foreignKeyProperties){
				o_temp = foreignKeyProperty.getForeignEntityClass().newInstance();
				//智能投顾
				for(String objectPropertyTemp : objectProperties){
					if(foreignKeyProperty.getPropertyName().toUpperCase().equals(objectPropertyTemp.toUpperCase())){
						keyField =  foreignKeyProperty.getForeignEntityClass().getDeclaredField(foreignKeyProperty.getForeignEntityKeyProperty());
						keyField.setAccessible(true);
						objectProperty = objectPropertyTemp ; 
						break ; 
					} 
				}
				if(o_temp !=null && objectProperty !=null && keyField != null && objectMap.get(objectProperty) != null ){
					keyField.set(o_temp, objectMap.get(objectProperty));
					o_temp = AllEntityMapperFactory.getAllEntityMapper().selectObject(o_temp);
					valueField =  foreignKeyProperty.getForeignEntityClass().getDeclaredField(foreignKeyProperty.getForeignEntityValueProperty());
					valueField.setAccessible(true);
					if( valueField.get(o_temp) != null){
						objectMap.put(objectProperty, valueField.get(o_temp)) ; 
					}
				}
				o_temp = null ;
				objectProperty = null ; 
				keyField = null ; 
			}
		}catch(Exception e ){
			e.printStackTrace(); 
		}
	
	}
	
}
