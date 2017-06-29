package com.web.common;

import java.util.HashMap;
/**
 * 链式Map
 * @param key
 * @param value
 * @return
 */
public class ChainMap<K,V> extends HashMap<K,V> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 链式put
	 * @param key
	 * @param value
	 * @return
	 */
	public ChainMap<K, V> chainPut(K key, V value){
		super.put(key, value);
		return this ; 
	}
}
