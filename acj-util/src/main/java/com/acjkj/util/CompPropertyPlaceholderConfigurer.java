/*
 *  Copyright 2007, ShangHai HOWBUY INVESTMENT MANAGEMENT Co., Ltd. 
 *  All right reserved.
 *
 *  THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF HOWBUY INVESTMENT 
 *  MANAGEMENT CO., LTD.  THE CONTENTS OF THIS FILE MAY NOT BE DISCLOSED
 *  TO THIRD PARTIES, COPIED OR DUPLICATED IN ANY FORM, IN WHOLE OR IN PART,
 *  WITHOUT THE PRIOR WRITTEN PERMISSION OF HOWBUY INVESTMENT MANAGEMENT
 *  CO., LTD.
 */

/*
 * Created on 2007-6-20
 * $Id$
 */
package com.acjkj.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;


/**
 * <p>公司的属性配置文件工具
 * Title: 		handle propertiy file value
 * Description: read global environment variable
 * Copyright: 	Copyright (c) 2007
 * </p>
 * 
 * @author Chris
 * @version 1.0
 */

public class CompPropertyPlaceholderConfigurer extends org.springframework.beans.factory.config.PropertyPlaceholderConfigurer{
	
	private static final Logger LOGGER = Logger.getLogger(CompPropertyPlaceholderConfigurer.class);

	private static Map<String, String> ctxPropertiesMap; 
	 
    @Override 
    protected void processProperties( 
            ConfigurableListableBeanFactory beanFactoryToProcess, 
            Properties props) throws BeansException { 
        super.processProperties(beanFactoryToProcess, props); 
        ctxPropertiesMap = new HashMap<String, String>(); 
        for (Object key : props.keySet()) { 
            String keyStr = key.toString(); 
            String value = props.getProperty(keyStr); 
            ctxPropertiesMap.put(keyStr, value); 
        } 
    } 
    protected String resolvePlaceholder(String placeholder, Properties props) {

        String s = props.getProperty(placeholder);

        if (placeholder != null && s != null) {

            if (placeholder.startsWith("jdbc")) {

                if(placeholder.endsWith(".username")){

                    s = Encrypter.decrypt(s);

                }

                if(placeholder.endsWith(".password")){

                    s = Encrypter.decrypt(s);

                }

            }
        }

        return s;
    }
    public static String getValue(String name, String defaultValue) { 
//        if( ctxPropertiesMap ==null){
//        	processProperties();
//        }
        return ctxPropertiesMap.get(name) == null ?defaultValue:ctxPropertiesMap.get(name); 
    } 
    
//	
//	private static Properties prop = null;
//
//	public PropFileValue() throws Exception {
//		LOGGER.debug("开始初始化配置文件");
//		loadProperties();
//	}
//	/**
//	 * 
//	 * @param key
//	 * @param defaultValue
//	 * @return
//	 * @throws Exception 
//	 */
//	public static String getValue(String key, String defaultValue) throws Exception {
//		LOGGER.debug("开始获取配置文件中的数据key="+key);
//		String value = null;
//		Object obj = null;
//		if (prop == null) {
//			loadProperties();
//		}
//		if (prop != null) {
//			obj = prop.getProperty(key, defaultValue);
//			LOGGER.debug("配置文件中的数据="+prop.toString());;
//		}
//		if (obj == null) {
//			LOGGER.debug("开始获取配置文件中的默认数据defaultValue="+defaultValue);
//			value = defaultValue;
//		} else {
//			LOGGER.debug("开始获取配置文件中的数据key="+key+",obj="+obj);
//			value = (String) obj;
//		}
//		return value;
//	}
//
//	/**
//	 * Read configure file
//	 * @throws Exception 
//	 * 
//	 */
//	private static void loadProperties() throws Exception {
//		LOGGER.debug("开始导入配置文件");
//		if (prop == null) {
//			String host =  (String) PropertyPlaceholderConfigurer.getContextProperty("mail.smtp.host");
//			String path ="/project/file/crm/config/properties/system.properties";
//			LOGGER.error("开始导入配置文件数据==="+path);
//			File file = new File(path);
//			if(!file.exists()){
//				LOGGER.error("没有找到===/project/file/crm/config/properties/system.properties配置文件");
//				throw new Exception();
//			}
//			InputStream inStream = null ; 
//			try{
//				
//				prop = new Properties();
//				
//				inStream = new FileInputStream(file);  
//				prop.load(inStream);
//				LOGGER.debug("配置文件路径：="+file.getPath());
//			} catch (MalformedURLException ex) {
//				LOGGER.error("导入配置文件出现异常 " + path + " error", ex);
//			} catch (IOException ex) {
//				LOGGER.error("导入配置文件出现IO异常 " + path + " error", ex);
//			}finally{
//				if(inStream !=null){
//					try {
//						inStream.close();
//					} catch (IOException e) {}
//				}
//			}
//		}
//		return;
//	}

}