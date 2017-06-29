package com.web.contentmanager.sysproperty;


import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.web.common.exception.BusinessException;
import com.web.contentmanager.ContentSubjectKeyEnum;

/**
 * 系统属性
 * @author shuzhiyun
 *
 */
public class SysPropertyHandle {
	
	private static  Map<String, Field>  fieldMap  ; 
	
	public static String getProperty(ContentSubjectKeyEnum contentSubjectKeyEnum) {
		if(fieldMap == null ){
			synchronized (SysPropertyHandle.class) {
				if(fieldMap == null ){
					fieldMap = new HashMap<String,Field>();
					Field[]  listes = SystemPropertyContent.class.getDeclaredFields() ;
					for(Field field:listes){
						field.setAccessible(true);
						fieldMap.put(field.getName(), field) ; 
					}
				}
			}
		}
		if(contentSubjectKeyEnum==null ){
			throw new BusinessException("获取系统参数出错，参数为空"); 
		}else if(fieldMap == null || fieldMap.get(contentSubjectKeyEnum.getSubjectKey())==null  ){
			throw new BusinessException("获取系统参数出错，系统未配置该参数{}",contentSubjectKeyEnum.getSubjectKey()); 
		}else{
			try {
				return (String) fieldMap.get(contentSubjectKeyEnum.getSubjectKey()).get(SystemPropertyContent.getInstance());
			} catch (Exception e) {
				throw new BusinessException("获取系统参数出错"); 
			}
		}
		 
	}

}
