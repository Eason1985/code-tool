package com.web.mapper.metadbIdgenerator;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.absmybatis.exception.BaseDtoException;
import com.web.entity.MetadbIdgeneratorDto;
import com.web.mapper.AllEntityMapperFactory;

/**
 * 
 * @author szy
 * 
 */
@Service("metadbIdgeneratorMapperApp")
public class MetadbIdgeneratorMapperApp {

	@Autowired
	private MetadbIdgeneratorMapper metadbIdgeneratorMapper;

	public static final ArrayList<String> entityTable = new ArrayList<String>();

	// 客户信息实体表对应的实体名称
	public static final String TBR_REPAIR_CUSTINFO = "TBR_REPAIR_CUSTINFO";
	// 车辆客户信息关联
	public static final String TBR_REPAIR_CAR_USER = "TBR_REPAIR_CAR_USER";
	// app维修种类维护
	public static final String TBU_CUSTINFO = "TBU_CUSTINFO";

	// 用户表
	public static final String TB_SYSR_USER = "TB_SYSR_USER";

	public static final String TB_P_NETINFO = "TB_P_NETINFO";
	public static final String TB_SYSR_IDGENERATOR = "TB_SYSR_IDGENERATOR";
	public static final String TB_SYSR_LOGININFO = "TB_SYSR_LOGININFO";
	public static final String TB_SYSR_RELATION_RES_SELF = "TB_SYSR_RELATION_RES_SELF";
	public static final String TB_SYSR_RELATION_ROLE_RESOURCE = "TB_SYSR_RELATION_ROLE_RESOURCE";
	public static final String TB_SYSR_RELATION_USER_ROLE = "TB_SYSR_RELATION_USER_ROLE";
	public static final String TB_SYSR_RESOURCE = "TB_SYSR_RESOURCE";
	public static final String TB_SYSR_ROLE = "TB_SYSR_ROLE";
	public static final String TBR_BESPEAK_ORDER_INFO = "TBR_BESPEAK_ORDER_INFO";
	public static final String TBR_CAR_AGENT_SERVICE = "TBR_CAR_AGENT_SERVICE";
	public static final String TBR_CAR_MAINTAIN_SERVICE = "TBR_CAR_MAINTAIN_SERVICE";
	public static final String TBR_CAR_PAINT_SERVICE = "TBR_CAR_PAINT_SERVICE";
	public static final String TBR_CAR_SPA_SERVICE = "TBR_CAR_SPA_SERVICE";
	public static final String TBR_CAR_WASH_SERVICE = "TBR_CAR_WASH_SERVICE";
	public static final String TBR_CAR_WASH_VOUCHER = "TBR_CAR_WASH_VOUCHER";
	public static final String TBR_ELEPREPAID_CARD = "TBR_ELEPREPAID_CARD";
	public static final String TBR_ELEPREPAID_CARD_CONSUME = "TBR_ELEPREPAID_CARD_CONSUME";
	public static final String TBR_ELEPREPAID_CARD_RECHARGE = "TBR_ELEPREPAID_CARD_RECHARGE";
	public static final String TBR_HISTORY_PARTS_PRICE = "TBR_HISTORY_PARTS_PRICE";
	public static final String TBR_HISTORY_WORKHOURS_PRICE = "TBR_HISTORY_WORKHOURS_PRICE";
	public static final String TBR_LATELY_PARTS_PRICE = "TBR_LATELY_PARTS_PRICE";
	public static final String TBR_LATELY_WORKHOURS_PRICE = "TBR_LATELY_WORKHOURS_PRICE";
	public static final String TBR_MESSAGE = "TBR_MESSAGE";
	public static final String TBR_ORDER_PARTS = "TBR_ORDER_PARTS";
	public static final String TBR_ORDER_PARTS_TEMP = "TBR_ORDER_PARTS_TEMP";
	public static final String TBR_ORDER_WORKHOURS = "TBR_ORDER_WORKHOURS";
	public static final String TBR_ORDER_WORKHOURS_TEMP = "TBR_ORDER_WORKHOURS_TEMP";
	public static final String TBR_READ_MESSAGE_INFO = "TBR_READ_MESSAGE_INFO";
	public static final String TBR_RED_BAG = "TBR_RED_BAG";
	public static final String TBR_RED_BAG_USER_CONSUME = "TBR_RED_BAG_USER_CONSUME";
	public static final String TBR_RED_BAG_USER_RECEIVE = "TBR_RED_BAG_USER_RECEIVE";
	public static final String TBR_REPAIR_CAR_INFO = "TBR_REPAIR_CAR_INFO";
	public static final String TBR_REPAIR_GROUP = "TBR_REPAIR_GROUP";
	public static final String TBR_REPAIR_ORDER = "TBR_REPAIR_ORDER";
	public static final String TBR_USER_JUDGE = "TBR_USER_JUDGE";
	public static final String TBR_VOUCHER = "TBR_VOUCHER";
	public static final String TBR_VOUCHER_CONSUME = "TBR_VOUCHER_CONSUME";
	public static final String TBR_VOUCHER_USER_RECEIVE = "TBR_VOUCHER_USER_RECEIVE";
	public static final String TBS_CAR_BRAND = "TBS_CAR_BRAND";
	public static final String TBS_CAR_BRAND_SERIES = "TBS_CAR_BRAND_SERIES";
	public static final String TBS_CITY_INFO = "TBS_CITY_INFO";
	public static final String TBS_COUNTY_INFO = "TBS_COUNTY_INFO";
	public static final String TBS_DICTIONARY = "TBS_DICTIONARY";
	public static final String TBS_PARTS = "TBS_PARTS";
	public static final String TBS_PARTS_CITY_PRICE = "TBS_PARTS_CITY_PRICE";
	public static final String TBS_PARTS_DIMENSION_CARBODY = "TBS_PARTS_DIMENSION_CARBODY";
	public static final String TBS_PARTS_DIMENSION_STRUCTURE_ONE = "TBS_PARTS_DIMENSION_STRUCTURE_ONE";
	public static final String TBS_PARTS_DIMENSION_STRUCTURE_THREE = "TBS_PARTS_DIMENSION_STRUCTURE_THREE";
	public static final String TBS_PARTS_DIMENSION_STRUCTURE_TWO = "TBS_PARTS_DIMENSION_STRUCTURE_TWO";
	public static final String TBS_PROVINCE_INFO = "TBS_PROVINCE_INFO";
	public static final String TBS_RUN_PARAM = "TBS_RUN_PARAM";
	public static final String TBS_WORK_TYPE = "TBS_WORK_TYPE";
	public static final String TBS_WORKHOURS = "TBS_WORKHOURS";
	public static final String TBS_WORKHOURS_CITY_PRICE = "TBS_WORKHOURS_CITY_PRICE";
	public static final String TBS_WORKHOURS_DIMENSION_CARBODY = "TBS_WORKHOURS_DIMENSION_CARBODY";
	public static final String TBS_WORKHOURS_DIMENSION_TYPE = "TBS_WORKHOURS_DIMENSION_TYPE";
	public static final String TBU_CAR_INFO = "TBU_CAR_INFO";
	public static final String TBU_CAR_USER = "TBU_CAR_USER";
	public static final String TBU_CUST_FOLLOW_REPAIR_INFO = "TBU_CUST_FOLLOW_REPAIR_INFO";
	public static final String TBU_CUST_FOLLOW_REPAIR_INFO_HIS = "TBU_CUST_FOLLOW_REPAIR_INFO_HIS";
	public static final String TBU_USER_MESSAGE_POOL = "TBU_USER_MESSAGE_POOL";
	public static final String TBU_USER_RED_BAG_POOL = "TBU_USER_RED_BAG_POOL";
	public static final String TBU_USER_VOUCHER_POOL = "TBU_USER_VOUCHER_POOL";
	public static final String TB_SYSR_GROUP = "TB_SYSR_GROUP";
	public static final String TBK_WAREHOURSE_ORDER = "TBK_WAREHOURSE_ORDER";
	public static final String TBK_WAREHOURSE_PARTS = "TBK_WAREHOURSE_PARTS";
	public static final String TBK_WAREHOURSE = "TBK_WAREHOURSE";
	public static final String TBK_ISP = "TBK_ISP";
	public static final String TBK_CUSTOM_PARTS = "TBK_CUSTOM_PARTS";
	public static final String TBR_VIP_BANK_CARD = "TBR_VIP_BANK_CARD";
	public static final String TBR_VIP_BANK_CARD_ORDER ="TBR_VIP_BANK_CARD_ORDER";
	public static final String TBR_VIP_COUNT_CARD="TBR_VIP_COUNT_CARD";
	public static final String TBR_VIP_COUNT_CARD_ORDER="TBR_VIP_COUNT_CARD_ORDER";
	public static final String TBR_ORDER_PAY_DETAIL="TBR_ORDER_PAY_DETAIL";
	public static final String TBR_REPAIR_ORDER_PAY="TBR_REPAIR_ORDER_PAY";
	public static final String TBR_CUSTOM_WORKHOURS="TBR_CUSTOM_WORKHOURS";
	public static final String TBR_CUSTOM_PARTS="TBR_CUSTOM_PARTS";
	public static final String TBR_LATENT_PROJECT="TBR_LATENT_PROJECT";
	static {
		entityTable.add(TBR_REPAIR_ORDER_PAY);
		entityTable.add(TBR_ORDER_PAY_DETAIL);
		entityTable.add(TBR_VIP_COUNT_CARD_ORDER);
		entityTable.add(TBR_VIP_COUNT_CARD);
		entityTable.add(TBR_VIP_BANK_CARD_ORDER);
		entityTable.add(TBR_VIP_BANK_CARD);
		entityTable.add(TBK_WAREHOURSE_ORDER);
		entityTable.add(TBK_WAREHOURSE_PARTS);
		entityTable.add(TBK_WAREHOURSE);
		entityTable.add(TBK_ISP);
		entityTable.add(TBK_CUSTOM_PARTS);
		entityTable.add(TB_P_NETINFO);
		entityTable.add(TB_SYSR_IDGENERATOR);
		entityTable.add(TB_SYSR_LOGININFO);
		entityTable.add(TB_SYSR_RELATION_RES_SELF);
		entityTable.add(TB_SYSR_RELATION_ROLE_RESOURCE);
		entityTable.add(TB_SYSR_RELATION_USER_ROLE);
		entityTable.add(TB_SYSR_RESOURCE);
		entityTable.add(TB_SYSR_ROLE);
		entityTable.add(TB_SYSR_USER);
		entityTable.add(TBR_BESPEAK_ORDER_INFO);
		entityTable.add(TBR_CAR_AGENT_SERVICE);
		entityTable.add(TBR_CAR_MAINTAIN_SERVICE);
		entityTable.add(TBR_CAR_PAINT_SERVICE);
		entityTable.add(TBR_CAR_SPA_SERVICE);
		entityTable.add(TBR_CAR_WASH_SERVICE);
		entityTable.add(TBR_CAR_WASH_VOUCHER);
		entityTable.add(TBR_ELEPREPAID_CARD);
		entityTable.add(TBR_ELEPREPAID_CARD_CONSUME);
		entityTable.add(TBR_ELEPREPAID_CARD_RECHARGE);
		entityTable.add(TBR_HISTORY_PARTS_PRICE);
		entityTable.add(TBR_HISTORY_WORKHOURS_PRICE);
		entityTable.add(TBR_LATELY_PARTS_PRICE);
		entityTable.add(TBR_LATELY_WORKHOURS_PRICE);
		entityTable.add(TBR_MESSAGE);
		entityTable.add(TBR_ORDER_PARTS);
		entityTable.add(TBR_ORDER_PARTS_TEMP);
		entityTable.add(TBR_ORDER_WORKHOURS);
		entityTable.add(TBR_ORDER_WORKHOURS_TEMP);
		entityTable.add(TBR_READ_MESSAGE_INFO);
		entityTable.add(TBR_RED_BAG);
		entityTable.add(TBR_RED_BAG_USER_CONSUME);
		entityTable.add(TBR_RED_BAG_USER_RECEIVE);
		entityTable.add(TBR_REPAIR_CAR_INFO);
		entityTable.add(TBR_REPAIR_CAR_USER);
		entityTable.add(TBR_REPAIR_CUSTINFO);
		entityTable.add(TBR_REPAIR_GROUP);
		entityTable.add(TBR_REPAIR_ORDER);
		entityTable.add(TBR_USER_JUDGE);
		entityTable.add(TBR_VOUCHER);
		entityTable.add(TBR_VOUCHER_CONSUME);
		entityTable.add(TBR_VOUCHER_USER_RECEIVE);
		entityTable.add(TBS_CAR_BRAND);
		entityTable.add(TBS_CAR_BRAND_SERIES);
		entityTable.add(TBS_CITY_INFO);
		entityTable.add(TBS_COUNTY_INFO);
		entityTable.add(TBS_DICTIONARY);
		entityTable.add(TBS_PARTS);
		entityTable.add(TBS_PARTS_CITY_PRICE);
		entityTable.add(TBS_PARTS_DIMENSION_CARBODY);
		entityTable.add(TBS_PARTS_DIMENSION_STRUCTURE_ONE);
		entityTable.add(TBS_PARTS_DIMENSION_STRUCTURE_THREE);
		entityTable.add(TBS_PARTS_DIMENSION_STRUCTURE_TWO);
		entityTable.add(TBS_PROVINCE_INFO);
		entityTable.add(TBS_RUN_PARAM);
		entityTable.add(TBS_WORK_TYPE);
		entityTable.add(TBS_WORKHOURS);
		entityTable.add(TBS_WORKHOURS_CITY_PRICE);
		entityTable.add(TBS_WORKHOURS_DIMENSION_CARBODY);
		entityTable.add(TBS_WORKHOURS_DIMENSION_TYPE);
		entityTable.add(TBU_CAR_INFO);
		entityTable.add(TBU_CAR_USER);
		entityTable.add(TBU_CUST_FOLLOW_REPAIR_INFO);
		entityTable.add(TBU_CUST_FOLLOW_REPAIR_INFO_HIS);
		entityTable.add(TBU_CUSTINFO);
		entityTable.add(TBU_USER_MESSAGE_POOL);
		entityTable.add(TBU_USER_RED_BAG_POOL);
		entityTable.add(TBU_USER_VOUCHER_POOL);
		entityTable.add(TB_SYSR_GROUP);
		entityTable.add(TBR_CUSTOM_WORKHOURS);
		entityTable.add(TBR_CUSTOM_PARTS);
		entityTable.add(TBR_LATENT_PROJECT);

	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE, rollbackFor = Exception.class)
	public synchronized int getMetaDbObjectIdValue(String entityName)
			throws BaseDtoException {
		if (entityName == null || !entityTable.contains(entityName)) {
			throw new BaseDtoException("该实体不是MetaDB表，无需调用MetaDB主键生成器");
		}
		MetadbIdgeneratorDto metadbIdgeneratorDto = metadbIdgeneratorMapper
				.queryMetaDbIdgenerator(entityName);
		Integer current = Integer.valueOf(metadbIdgeneratorDto
				.getCurrentvalue())
				+ Integer.valueOf(metadbIdgeneratorDto.getStep());
		metadbIdgeneratorDto.setCurrentvalue(String.valueOf(current));
		AllEntityMapperFactory.getAllEntityMapper().updateEntityById(
				metadbIdgeneratorDto);
		return current;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE, rollbackFor = Exception.class)
	public synchronized String getMetaDbObjectIdStr(String entityName)
			throws BaseDtoException {
		if (entityName == null || !entityTable.contains(entityName)) {
			throw new BaseDtoException("该实体不是MetaDB表，无需调用MetaDB主键生成器");
		}
		MetadbIdgeneratorDto metadbIdgeneratorDto = metadbIdgeneratorMapper
				.queryMetaDbIdgenerator(entityName);
		int current = Integer.valueOf(metadbIdgeneratorDto
				.getCurrentvalue())
				+ Integer.valueOf(metadbIdgeneratorDto.getStep());
		metadbIdgeneratorDto.setCurrentvalue(String.valueOf(current));
		AllEntityMapperFactory.getAllEntityMapper().updateEntityById(
				metadbIdgeneratorDto);
		return String.valueOf(current);
	}

}
