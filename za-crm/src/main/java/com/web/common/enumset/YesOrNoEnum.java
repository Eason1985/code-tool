package com.web.common.enumset;

import java.util.EnumMap;
import java.util.Map;

/**
 * 是否枚举
 * @author 疏志云
 * 1是
 * 0否
 */
public enum YesOrNoEnum {
	/**
	 * 是
	 */
	isYes("1"),
	/**
	 *否
	 */
	isNo("0"),
	;
	
	private String value;

    public String getValue() {
        return value;
    }
    
    YesOrNoEnum(String value) {
        this.value = value;
    }
    
    public final static Map<YesOrNoEnum, String> map ;
    
    static{
    	map = new EnumMap<YesOrNoEnum, String>(YesOrNoEnum.class);
    	map.put(YesOrNoEnum.isYes, "是");
    	map.put(YesOrNoEnum.isNo, "否");
    
    }
    
    /**
     * 跟据value返回枚举对应的key
     * 
     * @param value
     * @return NotifyErrorCode
     */
    public static YesOrNoEnum getEnum(String value) {
    	YesOrNoEnum tmpKey = null;
        for (YesOrNoEnum tmpEnum : YesOrNoEnum.values()) {
            if (tmpEnum.value.equals(value)) {
                tmpKey = tmpEnum;
                break;
            }
        }
        return tmpKey;
    }
    /**
     * 返回NotifyErrorCode对应的描述.
     * @param value int.
     * @return String
     */
    public static String getEnumDesc(final String value) {
        return YesOrNoEnum.map.get(
        		YesOrNoEnum.getEnum(value));
    }
    
}
