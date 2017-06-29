package com.web.contentmanager.cache;

import java.util.Set;

import com.web.common.exception.BusinessException;
import com.web.contentmanager.ContentSubjectKeyEnum;

public class RedisContentHandle {
	
	/*************************一般缓存数据处理**************************************************************/
	/**
	 * 根据key获取数据
	 * @param subjectKey
	 * @return
	 */
	public static String get(String subjectKey){
		checkParam(subjectKey) ; 
		return RedisConnectFactory.getRedisClient().get(subjectKey);
	}
	
	/**
	 * 获取subject数据
	 * @param subject
	 * @return
	 */
	public static String get(ContentSubjectKeyEnum contentSubjectKeyEnum ){
		checkParam(contentSubjectKeyEnum) ; 
		return RedisConnectFactory.getRedisClient().get(contentSubjectKeyEnum.getSubjectKey());
	}
	
	/**
	 * 设置subject数据
	 * @param subject
	 * @return
	 */
	public static void set(String subjectKey, String subject  ){
		checkParam(subjectKey) ; 
		RedisConnectFactory.getRedisClient().set(subjectKey, subject)  ; 
	}
	/**
	 * 设置subject数据
	 * @param subject
	 * @return
	 */
	public static void set(ContentSubjectKeyEnum contentSubjectKeyEnum, String subject  ){
		checkParam(contentSubjectKeyEnum) ; 
		RedisConnectFactory.getRedisClient().set(contentSubjectKeyEnum.getSubjectKey(), subject)  ; 
	}
	
	/**
	 * 设置subject数据
	 * @param subject
	 * @return
	 */
	public static Long del(String subjectKey ){
		checkParam(subjectKey) ; 
		return RedisConnectFactory.getRedisClient().del(subjectKey )  ; 
	}
	/**
	 * 设置subject数据
	 * @param subject
	 * @return
	 */
	public static Long del(ContentSubjectKeyEnum subjectKey ){
		checkParam(subjectKey) ; 
		return RedisConnectFactory.getRedisClient().del(subjectKey.getSubjectKey() )  ; 
	}
	
	
	/*************************集合处理**************************************************************/
	
	/**
	 * 集合处理
	 * 给一个集合添加元素
	 */
	public static void sadd(ContentSubjectKeyEnum contentSubjectKeyEnum, String... member  ){
		checkParam(contentSubjectKeyEnum) ; 
		RedisConnectFactory.getRedisClient().sadd(contentSubjectKeyEnum.getSubjectKey(), member) ; 
	}
	
	/**
	 * 集合处理
	 * 查询集合中元素个数
	 */
	public static Long scard(ContentSubjectKeyEnum contentSubjectKeyEnum  ){
		checkParam(contentSubjectKeyEnum) ; 
		return RedisConnectFactory.getRedisClient().scard(contentSubjectKeyEnum.getSubjectKey() ) ; 
	}
	/**
	 * 集合处理
	 * 查询所有集合
	 */
	public static Set<String> smembers(ContentSubjectKeyEnum contentSubjectKeyEnum  ){
		checkParam(contentSubjectKeyEnum) ; 
		return RedisConnectFactory.getRedisClient().smembers(contentSubjectKeyEnum.getSubjectKey() ) ; 
	}
	/**
	 * 从set中删除一个参数
	 * @param key
	 */
	public static Long srem(ContentSubjectKeyEnum contentSubjectKeyEnum , String remValue  ){
		checkParam(contentSubjectKeyEnum) ; 
		return RedisConnectFactory.getRedisClient().srem(contentSubjectKeyEnum.getSubjectKey(),remValue ) ; 
	}
	
	/***************************************************************************************/
	
	
	
	
	
	
	
	
	
	
	/***************************************工具类************************************************/
	
	/*
	 * 检查参数
	 */
	private static void checkParam(Object key ){
		if(key == null ){
			throw new BusinessException("key值为空");
		}
	}
	
}
