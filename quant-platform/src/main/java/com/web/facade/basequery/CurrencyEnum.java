package com.web.facade.basequery;

import java.util.EnumMap;
import java.util.Map;
public enum CurrencyEnum {
	
	/**
	 *   所有油漆工时统计报表数据
	 */
	obtainPaintWorkersData("stOrderWorkersMapper.obtainPaintWorkersData") ,
	/**
	 *   所有工时统计报表数据
	 */
	obtainOrderWorkersData("stOrderWorkersMapper.obtainOrderWorkersData") ,
	
	/**
	 *   工单量报表数据
	 */
	receptionWorkOrderStatistics("stOrderWorkersMapper.receptionWorkOrderStatistics") ,
	
	/**
	 *   所有维修工绩效报表数据
	 */
	obtainRepairerJixiaoData("stOrderWorkersMapper.obtainRepairerJixiaoData") ,
	/**
	 *   油漆工绩效统计报表数据
	 */
	obtainPainterJixiaoData("stOrderWorkersMapper.obtainPainterJixiaoData") 
	;
		 
	private String value;

    public String getValue() {
        return value;
    }
    
    CurrencyEnum(String value) {
        this.value = value;
    }
    
    public final static Map<CurrencyEnum, String> map ;
    static{
    	map = new EnumMap<CurrencyEnum, String>(CurrencyEnum.class);
	 	map.put(CurrencyEnum.obtainPaintWorkersData , "所有油漆工时统计报表数据");
    }
    /**
     * 跟据value返回枚举对应的key
     * 
     * @param value
     * @return NotifyErrorCode
     */
    public static CurrencyEnum getEnum(String value) {
    	CurrencyEnum tmpKey = null;
        for (CurrencyEnum tmpEnum : CurrencyEnum.values()) {
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
        return CurrencyEnum.map.get(
        		CurrencyEnum.getEnum(value));
    }
    
	
}
