package com.web.contentmanager.cache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/***
 * redis链接工厂
 * @author shuzhiyun
 *
 */
public class RedisConnectFactory {
	
	private static JedisPool jedisPool = null;
	private static Jedis jedis = null;
    //TODO 配置文件中获取 Redis服务器IP
    private static String ADDR = "192.168.14.129";
    //TODO 配置文件中获取  Redis的端口号
    private static int PORT = 6379;
    //TODO 配置文件中获取 访问密码
    private static String AUTH = "123456";
    private static int POOL_TIMEOUT = 3000 ; 
    
    private static boolean BlockWhenExhausted = true; 
    private static String EvictionPolicyClassName = "org.apache.commons.pool2.impl.DefaultEvictionPolicy"; 
    private static boolean JMXENABLED = true ; 
    private static int MAXIDLE = 8 ; 
    private static int MAXTOTAL = 200 ; 
    private static int MAXWAITMILLIS = 1000 * 100 ; 
    private static boolean TESTONBORROW = true; 
    /**
     * 初始化Redis连接池
     */
    static {
        JedisPoolConfig config = new JedisPoolConfig();
        // 连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
        config.setBlockWhenExhausted(BlockWhenExhausted);
        // 设置的逐出策略类名, 默认DefaultEvictionPolicy(当连接超过最大空闲时间,或连接数超过最大空闲连接数)
        config.setEvictionPolicyClassName(EvictionPolicyClassName);
        // 是否启用pool的jmx管理功能, 默认true
        config.setJmxEnabled(JMXENABLED);
        // 最大空闲连接数, 默认8个 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
        config.setMaxIdle(MAXIDLE);
        // 最大连接数, 默认8个
        config.setMaxTotal(MAXTOTAL);
        // 表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
        config.setMaxWaitMillis(MAXWAITMILLIS);
        // 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
        config.setTestOnBorrow(TESTONBORROW);
        jedisPool = new JedisPool(config, ADDR, PORT, POOL_TIMEOUT, AUTH);
         
    }

    /**
     * 获取Jedis实例
     * 
     * @return
     */
    public static Jedis getRedisClient() {
        if (jedis == null) {
        	synchronized (ADDR) {
        		if(jedis == null){
        			jedis = jedisPool.getResource();
        		}
			}
        }
		return jedis;
    }

    /**
     * 释放jedis资源
     * 
     * @param jedis
     */
    public static void close(final Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }
    
   
}
