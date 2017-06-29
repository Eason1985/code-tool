package com.web.entity;
import java.util.HashMap;
import java.util.Map;

import com.absmybatis.dao.annotation.EntityPK;
import com.absmybatis.dao.annotation.EntityColumn;

import com.web.common.ChainMap;	
import java.util.EnumMap;		
	
/**
 * 类功能:自动代码生成 DTO 
 * <p>创建者:</p>
 * <p>创建时间:</p>
 * <p>修改者:</p>
 * <p>修改时间:</p>
 * <p>修改原因：</p>
 * <p>审核者:</p>
 * <p>审核时间:</p>
 * <p>审核意见：</p>
 *
 */
@EntityPK(Pk = "id", tableName = "tb_scene_info")
public class TbSceneInfoDto {//
	//场景ID
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "场景ID"  )
	private java.lang.String id;//场景ID
	//客户ID
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "客户ID"  )
	private java.lang.String cust_id;//客户ID
	//产品ID
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "产品ID"  )
	private java.lang.String product_id;//产品ID
	//项目名称
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "项目名称"  )
	private java.lang.String project_name;//项目名称
	//子品牌
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "子品牌"  )
	private java.lang.String sub_brand;//子品牌
	//场景类型
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "场景类型"  )
	private java.lang.String scene_type;//场景类型
	//融资方式
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "融资方式"  )
	private java.lang.String way_of_financing;//融资方式
	//需求类型
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "需求类型"  )
	private java.lang.String demand_type;//需求类型
	//匹配资金类型
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "匹配资金类型"  )
	private java.lang.String matching_type;//匹配资金类型
	//立项时间
	@EntityColumn(dataType=93, typeName="DATETIME", remarks = "立项时间"  )
	private java.sql.Timestamp product_time;//立项时间
	//区域
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "区域"  )
	private java.lang.String area;//区域
	//项目管理人
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "项目管理人"  )
	private java.lang.String project_manager;//项目管理人
	//产品经理人
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "产品经理人"  )
	private java.lang.String product_manager;//产品经理人
	//风控负责人
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "风控负责人"  )
	private java.lang.String risk_controller;//风控负责人
	//法务负责人
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "法务负责人"  )
	private java.lang.String law_worker;//法务负责人
	//运营负责人
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "运营负责人"  )
	private java.lang.String oprater;//运营负责人
	//开发负责人
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "开发负责人"  )
	private java.lang.String it_manager;//开发负责人
	//BA
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "BA"  )
	private java.lang.String business_analyzer;//BA
	//数据负责人
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "数据负责人"  )
	private java.lang.String data_manager;//数据负责人
	//募集需求
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "募集需求"  )
	private java.lang.String raise_demand;//募集需求
	//商务条件
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "商务条件"  )
	private java.lang.String business_condition;//商务条件
	//场景说明
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "场景说明"  )
	private java.lang.String scene_doc;//场景说明
	//实际费率
	@EntityColumn(dataType=8, typeName="DOUBLE", remarks = "实际费率"  )
	private java.lang.Double actual_rate;//实际费率
	//授信额度
	@EntityColumn(dataType=8, typeName="DOUBLE", remarks = "授信额度"  )
	private java.lang.Double line_of_credit;//授信额度
	//最低承保余额
	@EntityColumn(dataType=8, typeName="DOUBLE", remarks = "最低承保余额"  )
	private java.lang.Double underwrite_balance_mix;//最低承保余额
	//产品经理属地
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "产品经理属地"  )
	private java.lang.String product_manager_colony;//产品经理属地
	//项目属地
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "项目属地"  )
	private java.lang.String project_colony;//项目属地
	//资金闭环
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "资金闭环"  )
	private java.lang.String money_closed_loop;//资金闭环
	//法律关系闭环
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "法律关系闭环"  )
	private java.lang.String legal_relation_closed_loop;//法律关系闭环
	//数据闭环
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "数据闭环"  )
	private java.lang.String data_closed_loop;//数据闭环
	//法务-多年期条款推进
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "法务-多年期条款推进"  )
	private java.lang.String low_works_boost;//法务-多年期条款推进
	//放款还款-稳定性
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "放款还款-稳定性"  )
	private java.lang.String loan_repayment_stability;//放款还款-稳定性
	//放款还款-信托限额
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "放款还款-信托限额"  )
	private java.lang.String limitation_of_the_trust;//放款还款-信托限额
	//放款还款-监管限额
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "放款还款-监管限额"  )
	private java.lang.String reg_limits;//放款还款-监管限额
	//放款还款-竞争环境下资金供给
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "放款还款-竞争环境下资金供给"  )
	private java.lang.String bankroll;//放款还款-竞争环境下资金供给
	//放款还款-接入第三方支付
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "放款还款-接入第三方支付"  )
	private java.lang.String third_pay;//放款还款-接入第三方支付
	//放款还款-大型第三方不开立金融账户
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "放款还款-大型第三方不开立金融账户"  )
	private java.lang.String account;//放款还款-大型第三方不开立金融账户
	//业务-租赁公司全国抵押备案
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "业务-租赁公司全国抵押备案"  )
	private java.lang.String mortgage_registration;//业务-租赁公司全国抵押备案
	//信审会额度限制
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "信审会额度限制"  )
	private java.lang.String credit_aduit_limit;//信审会额度限制
	//memo
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "memo"  )
	private java.lang.String memo;//memo
	//业务-车抵贷管理能力
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "业务-车抵贷管理能力"  )
	private java.lang.String management_ability;//业务-车抵贷管理能力
	//预计上线时间
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "预计上线时间"  )
	private java.lang.String expected_online_time;//预计上线时间
	//项目状态
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "项目状态"  )
	private java.lang.String status;//项目状态
	//创建时间
	@EntityColumn(dataType=93, typeName="DATETIME", remarks = "创建时间"  )
	private java.sql.Timestamp gmt_created;//创建时间
	//修改时间
	@EntityColumn(dataType=93, typeName="DATETIME", remarks = "修改时间"  )
	private java.sql.Timestamp gmt_modified;//修改时间
	//创建人
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "创建人"  )
	private java.lang.String creator;//创建人
	//修改人
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "修改人"  )
	private java.lang.String modifier;//修改人
	//是否删除
	@EntityColumn(dataType=1, typeName="CHAR", remarks = "是否删除"  )
	private java.lang.String is_deleted;//是否删除


   /**
	* 获取 场景ID
	* @return
	*/
	public java.lang.String getId() {
		return id;
	}
	
   /**
	* 设置 场景ID
	* @param id
	*/
 	public void setId(java.lang.String id) {
		this.id = id;
	}
	 

   /**
	* 获取 客户ID
	* @return
	*/
	public java.lang.String getCust_id() {
		return cust_id;
	}
	
   /**
	* 设置 客户ID
	* @param cust_id
	*/
 	public void setCust_id(java.lang.String cust_id) {
		this.cust_id = cust_id;
	}
	 

   /**
	* 获取 产品ID
	* @return
	*/
	public java.lang.String getProduct_id() {
		return product_id;
	}
	
   /**
	* 设置 产品ID
	* @param product_id
	*/
 	public void setProduct_id(java.lang.String product_id) {
		this.product_id = product_id;
	}
	 

   /**
	* 获取 项目名称
	* @return
	*/
	public java.lang.String getProject_name() {
		return project_name;
	}
	
   /**
	* 设置 项目名称
	* @param project_name
	*/
 	public void setProject_name(java.lang.String project_name) {
		this.project_name = project_name;
	}
	 

   /**
	* 获取 子品牌
	* @return
	*/
	public java.lang.String getSub_brand() {
		return sub_brand;
	}
	
   /**
	* 设置 子品牌
	* @param sub_brand
	*/
 	public void setSub_brand(java.lang.String sub_brand) {
		this.sub_brand = sub_brand;
	}
	 

   /**
	* 获取 场景类型
	* @return
	*/
	public java.lang.String getScene_type() {
		return scene_type;
	}
	
   /**
	* 设置 场景类型
	* @param scene_type
	*/
 	public void setScene_type(java.lang.String scene_type) {
		this.scene_type = scene_type;
	}
	 

   /**
	* 获取 融资方式
	* @return
	*/
	public java.lang.String getWay_of_financing() {
		return way_of_financing;
	}
	
   /**
	* 设置 融资方式
	* @param way_of_financing
	*/
 	public void setWay_of_financing(java.lang.String way_of_financing) {
		this.way_of_financing = way_of_financing;
	}
	 

   /**
	* 获取 需求类型
	* @return
	*/
	public java.lang.String getDemand_type() {
		return demand_type;
	}
	
   /**
	* 设置 需求类型
	* @param demand_type
	*/
 	public void setDemand_type(java.lang.String demand_type) {
		this.demand_type = demand_type;
	}
	 

   /**
	* 获取 匹配资金类型
	* @return
	*/
	public java.lang.String getMatching_type() {
		return matching_type;
	}
	
   /**
	* 设置 匹配资金类型
	* @param matching_type
	*/
 	public void setMatching_type(java.lang.String matching_type) {
		this.matching_type = matching_type;
	}
	 

   /**
	* 获取 立项时间
	* @return
	*/
	public java.sql.Timestamp getProduct_time() {
		return product_time;
	}
	
   /**
	* 设置 立项时间
	* @param product_time
	*/
 	public void setProduct_time(java.sql.Timestamp product_time) {
		this.product_time = product_time;
	}
	 

   /**
	* 获取 区域
	* @return
	*/
	public java.lang.String getArea() {
		return area;
	}
	
   /**
	* 设置 区域
	* @param area
	*/
 	public void setArea(java.lang.String area) {
		this.area = area;
	}
	 

   /**
	* 获取 项目管理人
	* @return
	*/
	public java.lang.String getProject_manager() {
		return project_manager;
	}
	
   /**
	* 设置 项目管理人
	* @param project_manager
	*/
 	public void setProject_manager(java.lang.String project_manager) {
		this.project_manager = project_manager;
	}
	 

   /**
	* 获取 产品经理人
	* @return
	*/
	public java.lang.String getProduct_manager() {
		return product_manager;
	}
	
   /**
	* 设置 产品经理人
	* @param product_manager
	*/
 	public void setProduct_manager(java.lang.String product_manager) {
		this.product_manager = product_manager;
	}
	 

   /**
	* 获取 风控负责人
	* @return
	*/
	public java.lang.String getRisk_controller() {
		return risk_controller;
	}
	
   /**
	* 设置 风控负责人
	* @param risk_controller
	*/
 	public void setRisk_controller(java.lang.String risk_controller) {
		this.risk_controller = risk_controller;
	}
	 

   /**
	* 获取 法务负责人
	* @return
	*/
	public java.lang.String getLaw_worker() {
		return law_worker;
	}
	
   /**
	* 设置 法务负责人
	* @param law_worker
	*/
 	public void setLaw_worker(java.lang.String law_worker) {
		this.law_worker = law_worker;
	}
	 

   /**
	* 获取 运营负责人
	* @return
	*/
	public java.lang.String getOprater() {
		return oprater;
	}
	
   /**
	* 设置 运营负责人
	* @param oprater
	*/
 	public void setOprater(java.lang.String oprater) {
		this.oprater = oprater;
	}
	 

   /**
	* 获取 开发负责人
	* @return
	*/
	public java.lang.String getIt_manager() {
		return it_manager;
	}
	
   /**
	* 设置 开发负责人
	* @param it_manager
	*/
 	public void setIt_manager(java.lang.String it_manager) {
		this.it_manager = it_manager;
	}
	 

   /**
	* 获取 BA
	* @return
	*/
	public java.lang.String getBusiness_analyzer() {
		return business_analyzer;
	}
	
   /**
	* 设置 BA
	* @param business_analyzer
	*/
 	public void setBusiness_analyzer(java.lang.String business_analyzer) {
		this.business_analyzer = business_analyzer;
	}
	 

   /**
	* 获取 数据负责人
	* @return
	*/
	public java.lang.String getData_manager() {
		return data_manager;
	}
	
   /**
	* 设置 数据负责人
	* @param data_manager
	*/
 	public void setData_manager(java.lang.String data_manager) {
		this.data_manager = data_manager;
	}
	 

   /**
	* 获取 募集需求
	* @return
	*/
	public java.lang.String getRaise_demand() {
		return raise_demand;
	}
	
   /**
	* 设置 募集需求
	* @param raise_demand
	*/
 	public void setRaise_demand(java.lang.String raise_demand) {
		this.raise_demand = raise_demand;
	}
	 

   /**
	* 获取 商务条件
	* @return
	*/
	public java.lang.String getBusiness_condition() {
		return business_condition;
	}
	
   /**
	* 设置 商务条件
	* @param business_condition
	*/
 	public void setBusiness_condition(java.lang.String business_condition) {
		this.business_condition = business_condition;
	}
	 

   /**
	* 获取 场景说明
	* @return
	*/
	public java.lang.String getScene_doc() {
		return scene_doc;
	}
	
   /**
	* 设置 场景说明
	* @param scene_doc
	*/
 	public void setScene_doc(java.lang.String scene_doc) {
		this.scene_doc = scene_doc;
	}
	 

   /**
	* 获取 实际费率
	* @return
	*/
	public java.lang.Double getActual_rate() {
		return actual_rate;
	}
	
   /**
	* 设置 实际费率
	* @param actual_rate
	*/
 	public void setActual_rate(java.lang.Double actual_rate) {
		this.actual_rate = actual_rate;
	}
	 

   /**
	* 获取 授信额度
	* @return
	*/
	public java.lang.Double getLine_of_credit() {
		return line_of_credit;
	}
	
   /**
	* 设置 授信额度
	* @param line_of_credit
	*/
 	public void setLine_of_credit(java.lang.Double line_of_credit) {
		this.line_of_credit = line_of_credit;
	}
	 

   /**
	* 获取 最低承保余额
	* @return
	*/
	public java.lang.Double getUnderwrite_balance_mix() {
		return underwrite_balance_mix;
	}
	
   /**
	* 设置 最低承保余额
	* @param underwrite_balance_mix
	*/
 	public void setUnderwrite_balance_mix(java.lang.Double underwrite_balance_mix) {
		this.underwrite_balance_mix = underwrite_balance_mix;
	}
	 

   /**
	* 获取 产品经理属地
	* @return
	*/
	public java.lang.String getProduct_manager_colony() {
		return product_manager_colony;
	}
	
   /**
	* 设置 产品经理属地
	* @param product_manager_colony
	*/
 	public void setProduct_manager_colony(java.lang.String product_manager_colony) {
		this.product_manager_colony = product_manager_colony;
	}
	 

   /**
	* 获取 项目属地
	* @return
	*/
	public java.lang.String getProject_colony() {
		return project_colony;
	}
	
   /**
	* 设置 项目属地
	* @param project_colony
	*/
 	public void setProject_colony(java.lang.String project_colony) {
		this.project_colony = project_colony;
	}
	 

   /**
	* 获取 资金闭环
	* @return
	*/
	public java.lang.String getMoney_closed_loop() {
		return money_closed_loop;
	}
	
   /**
	* 设置 资金闭环
	* @param money_closed_loop
	*/
 	public void setMoney_closed_loop(java.lang.String money_closed_loop) {
		this.money_closed_loop = money_closed_loop;
	}
	 

   /**
	* 获取 法律关系闭环
	* @return
	*/
	public java.lang.String getLegal_relation_closed_loop() {
		return legal_relation_closed_loop;
	}
	
   /**
	* 设置 法律关系闭环
	* @param legal_relation_closed_loop
	*/
 	public void setLegal_relation_closed_loop(java.lang.String legal_relation_closed_loop) {
		this.legal_relation_closed_loop = legal_relation_closed_loop;
	}
	 

   /**
	* 获取 数据闭环
	* @return
	*/
	public java.lang.String getData_closed_loop() {
		return data_closed_loop;
	}
	
   /**
	* 设置 数据闭环
	* @param data_closed_loop
	*/
 	public void setData_closed_loop(java.lang.String data_closed_loop) {
		this.data_closed_loop = data_closed_loop;
	}
	 

   /**
	* 获取 法务-多年期条款推进
	* @return
	*/
	public java.lang.String getLow_works_boost() {
		return low_works_boost;
	}
	
   /**
	* 设置 法务-多年期条款推进
	* @param low_works_boost
	*/
 	public void setLow_works_boost(java.lang.String low_works_boost) {
		this.low_works_boost = low_works_boost;
	}
	 

   /**
	* 获取 放款还款-稳定性
	* @return
	*/
	public java.lang.String getLoan_repayment_stability() {
		return loan_repayment_stability;
	}
	
   /**
	* 设置 放款还款-稳定性
	* @param loan_repayment_stability
	*/
 	public void setLoan_repayment_stability(java.lang.String loan_repayment_stability) {
		this.loan_repayment_stability = loan_repayment_stability;
	}
	 

   /**
	* 获取 放款还款-信托限额
	* @return
	*/
	public java.lang.String getLimitation_of_the_trust() {
		return limitation_of_the_trust;
	}
	
   /**
	* 设置 放款还款-信托限额
	* @param limitation_of_the_trust
	*/
 	public void setLimitation_of_the_trust(java.lang.String limitation_of_the_trust) {
		this.limitation_of_the_trust = limitation_of_the_trust;
	}
	 

   /**
	* 获取 放款还款-监管限额
	* @return
	*/
	public java.lang.String getReg_limits() {
		return reg_limits;
	}
	
   /**
	* 设置 放款还款-监管限额
	* @param reg_limits
	*/
 	public void setReg_limits(java.lang.String reg_limits) {
		this.reg_limits = reg_limits;
	}
	 

   /**
	* 获取 放款还款-竞争环境下资金供给
	* @return
	*/
	public java.lang.String getBankroll() {
		return bankroll;
	}
	
   /**
	* 设置 放款还款-竞争环境下资金供给
	* @param bankroll
	*/
 	public void setBankroll(java.lang.String bankroll) {
		this.bankroll = bankroll;
	}
	 

   /**
	* 获取 放款还款-接入第三方支付
	* @return
	*/
	public java.lang.String getThird_pay() {
		return third_pay;
	}
	
   /**
	* 设置 放款还款-接入第三方支付
	* @param third_pay
	*/
 	public void setThird_pay(java.lang.String third_pay) {
		this.third_pay = third_pay;
	}
	 

   /**
	* 获取 放款还款-大型第三方不开立金融账户
	* @return
	*/
	public java.lang.String getAccount() {
		return account;
	}
	
   /**
	* 设置 放款还款-大型第三方不开立金融账户
	* @param account
	*/
 	public void setAccount(java.lang.String account) {
		this.account = account;
	}
	 

   /**
	* 获取 业务-租赁公司全国抵押备案
	* @return
	*/
	public java.lang.String getMortgage_registration() {
		return mortgage_registration;
	}
	
   /**
	* 设置 业务-租赁公司全国抵押备案
	* @param mortgage_registration
	*/
 	public void setMortgage_registration(java.lang.String mortgage_registration) {
		this.mortgage_registration = mortgage_registration;
	}
	 

   /**
	* 获取 信审会额度限制
	* @return
	*/
	public java.lang.String getCredit_aduit_limit() {
		return credit_aduit_limit;
	}
	
   /**
	* 设置 信审会额度限制
	* @param credit_aduit_limit
	*/
 	public void setCredit_aduit_limit(java.lang.String credit_aduit_limit) {
		this.credit_aduit_limit = credit_aduit_limit;
	}
	 

   /**
	* 获取 memo
	* @return
	*/
	public java.lang.String getMemo() {
		return memo;
	}
	
   /**
	* 设置 memo
	* @param memo
	*/
 	public void setMemo(java.lang.String memo) {
		this.memo = memo;
	}
	 

   /**
	* 获取 业务-车抵贷管理能力
	* @return
	*/
	public java.lang.String getManagement_ability() {
		return management_ability;
	}
	
   /**
	* 设置 业务-车抵贷管理能力
	* @param management_ability
	*/
 	public void setManagement_ability(java.lang.String management_ability) {
		this.management_ability = management_ability;
	}
	 

   /**
	* 获取 预计上线时间
	* @return
	*/
	public java.lang.String getExpected_online_time() {
		return expected_online_time;
	}
	
   /**
	* 设置 预计上线时间
	* @param expected_online_time
	*/
 	public void setExpected_online_time(java.lang.String expected_online_time) {
		this.expected_online_time = expected_online_time;
	}
	 

   /**
	* 获取 项目状态
	* @return
	*/
	public java.lang.String getStatus() {
		return status;
	}
	
   /**
	* 设置 项目状态
	* @param status
	*/
 	public void setStatus(java.lang.String status) {
		this.status = status;
	}
	 

   /**
	* 获取 创建时间
	* @return
	*/
	public java.sql.Timestamp getGmt_created() {
		return gmt_created;
	}
	
   /**
	* 设置 创建时间
	* @param gmt_created
	*/
 	public void setGmt_created(java.sql.Timestamp gmt_created) {
		this.gmt_created = gmt_created;
	}
	 

   /**
	* 获取 修改时间
	* @return
	*/
	public java.sql.Timestamp getGmt_modified() {
		return gmt_modified;
	}
	
   /**
	* 设置 修改时间
	* @param gmt_modified
	*/
 	public void setGmt_modified(java.sql.Timestamp gmt_modified) {
		this.gmt_modified = gmt_modified;
	}
	 

   /**
	* 获取 创建人
	* @return
	*/
	public java.lang.String getCreator() {
		return creator;
	}
	
   /**
	* 设置 创建人
	* @param creator
	*/
 	public void setCreator(java.lang.String creator) {
		this.creator = creator;
	}
	 

   /**
	* 获取 修改人
	* @return
	*/
	public java.lang.String getModifier() {
		return modifier;
	}
	
   /**
	* 设置 修改人
	* @param modifier
	*/
 	public void setModifier(java.lang.String modifier) {
		this.modifier = modifier;
	}
	 

   /**
	* 获取 是否删除
	* @return
	*/
	public java.lang.String getIs_deleted() {
		return is_deleted;
	}
	
   /**
	* 设置 是否删除
	* @param is_deleted
	*/
 	public void setIs_deleted(java.lang.String is_deleted) {
		this.is_deleted = is_deleted;
	}
	 


/**
 	 * 
 	 * 属性枚举类
 	 * 状态【0-正常,1-密码锁定,2-无效】
 	 * @author Administrator
 	 *
 	 */
 	public static  class PropertyEnum{
 		/*
 		 * 数据格式： 
 		 * <user_stat,<0,正常;1,密码锁定;2,无效>>
 		 */
 		private  static Map<String,Map<String,String>> propertyEnumMap = new HashMap<String,Map<String,String>>();
 		static{
			propertyEnumMap.put("SCENE_TYPE", new ChainMap<String,String>()
					.chainPut("0", "0-商品分期")
					.chainPut("1", "1-现金贷")
			) ; 
			propertyEnumMap.put("WAY_OF_FINANCING", new ChainMap<String,String>()
					.chainPut("0", "0-转债")
					.chainPut("1", "1-直融")
					.chainPut("2", "2-转债加直融")
			) ; 
			propertyEnumMap.put("DEMAND_TYPE", new ChainMap<String,String>()
					.chainPut("0", "0-新增资产规模")
					.chainPut("1", "1-新增资金需求")
			) ; 
			propertyEnumMap.put("MATCHING_TYPE", new ChainMap<String,String>()
					.chainPut("0", "0-现金贷")
					.chainPut("1", "1-保理")
			) ; 
			propertyEnumMap.put("MONEY_CLOSED_LOOP", new ChainMap<String,String>()
					.chainPut("0", "0-否")
					.chainPut("1", "1-是")
			) ; 
			propertyEnumMap.put("LEGAL_RELATION_CLOSED_LOOP", new ChainMap<String,String>()
					.chainPut("0", "0-否")
					.chainPut("1", "1-是")
			) ; 
			propertyEnumMap.put("DATA_CLOSED_LOOP", new ChainMap<String,String>()
					.chainPut("0", "0-否")
					.chainPut("1", "1-是")
			) ; 
			propertyEnumMap.put("STATUS", new ChainMap<String,String>()
					.chainPut("0", "0-立项")
					.chainPut("1", "1-信审会通过")
					.chainPut("2", "2-法务")
					.chainPut("3", "3-预备上会")
					.chainPut("4", "4-上会")
					.chainPut("5", "5-上线")
			) ; 
 		}
		public static Map<String, Map<String, String>> getPropertyEnumMap() {
			return propertyEnumMap;
		}
 		
 	}
 	
	public static  enum SCENE_TYPEEnum{
	
		/**
 		 *  0-商品分期
 		 */
 			SCENE_TYPE_0("0"),
		/**
 		 *  1-现金贷
 		 */
 			SCENE_TYPE_1("1")
 			;
 		 
 		private String value;

	    public String getValue() {
	        return value;
	    }
	    
	    SCENE_TYPEEnum(String value) {
	        this.value = value;
	    }
	    
	    public final static Map<SCENE_TYPEEnum, String> map ;
	    static{
	    	map = new EnumMap<SCENE_TYPEEnum, String>(SCENE_TYPEEnum.class);
		 	map.put(SCENE_TYPEEnum.SCENE_TYPE_0 , "0-商品分期");
		 	map.put(SCENE_TYPEEnum.SCENE_TYPE_1 , "1-现金贷");
	    }
	    /**
	     * 跟据value返回枚举对应的key
	     * 
	     * @param value
	     * @return NotifyErrorCode
	     */
	    public static SCENE_TYPEEnum getEnum(String value) {
	    	SCENE_TYPEEnum tmpKey = null;
	        for (SCENE_TYPEEnum tmpEnum : SCENE_TYPEEnum.values()) {
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
	        return SCENE_TYPEEnum.map.get(
	        		SCENE_TYPEEnum.getEnum(value));
	    }
	    
 	}	
	public static  enum WAY_OF_FINANCINGEnum{
	
		/**
 		 *  0-转债
 		 */
 			WAY_OF_FINANCING_0("0"),
		/**
 		 *  1-直融
 		 */
 			WAY_OF_FINANCING_1("1"),
		/**
 		 *  2-转债加直融
 		 */
 			WAY_OF_FINANCING_2("2")
 			;
 		 
 		private String value;

	    public String getValue() {
	        return value;
	    }
	    
	    WAY_OF_FINANCINGEnum(String value) {
	        this.value = value;
	    }
	    
	    public final static Map<WAY_OF_FINANCINGEnum, String> map ;
	    static{
	    	map = new EnumMap<WAY_OF_FINANCINGEnum, String>(WAY_OF_FINANCINGEnum.class);
		 	map.put(WAY_OF_FINANCINGEnum.WAY_OF_FINANCING_0 , "0-转债");
		 	map.put(WAY_OF_FINANCINGEnum.WAY_OF_FINANCING_1 , "1-直融");
		 	map.put(WAY_OF_FINANCINGEnum.WAY_OF_FINANCING_2 , "2-转债加直融");
	    }
	    /**
	     * 跟据value返回枚举对应的key
	     * 
	     * @param value
	     * @return NotifyErrorCode
	     */
	    public static WAY_OF_FINANCINGEnum getEnum(String value) {
	    	WAY_OF_FINANCINGEnum tmpKey = null;
	        for (WAY_OF_FINANCINGEnum tmpEnum : WAY_OF_FINANCINGEnum.values()) {
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
	        return WAY_OF_FINANCINGEnum.map.get(
	        		WAY_OF_FINANCINGEnum.getEnum(value));
	    }
	    
 	}	
	public static  enum DEMAND_TYPEEnum{
	
		/**
 		 *  0-新增资产规模
 		 */
 			DEMAND_TYPE_0("0"),
		/**
 		 *  1-新增资金需求
 		 */
 			DEMAND_TYPE_1("1")
 			;
 		 
 		private String value;

	    public String getValue() {
	        return value;
	    }
	    
	    DEMAND_TYPEEnum(String value) {
	        this.value = value;
	    }
	    
	    public final static Map<DEMAND_TYPEEnum, String> map ;
	    static{
	    	map = new EnumMap<DEMAND_TYPEEnum, String>(DEMAND_TYPEEnum.class);
		 	map.put(DEMAND_TYPEEnum.DEMAND_TYPE_0 , "0-新增资产规模");
		 	map.put(DEMAND_TYPEEnum.DEMAND_TYPE_1 , "1-新增资金需求");
	    }
	    /**
	     * 跟据value返回枚举对应的key
	     * 
	     * @param value
	     * @return NotifyErrorCode
	     */
	    public static DEMAND_TYPEEnum getEnum(String value) {
	    	DEMAND_TYPEEnum tmpKey = null;
	        for (DEMAND_TYPEEnum tmpEnum : DEMAND_TYPEEnum.values()) {
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
	        return DEMAND_TYPEEnum.map.get(
	        		DEMAND_TYPEEnum.getEnum(value));
	    }
	    
 	}	
	public static  enum MATCHING_TYPEEnum{
	
		/**
 		 *  0-现金贷
 		 */
 			MATCHING_TYPE_0("0"),
		/**
 		 *  1-保理
 		 */
 			MATCHING_TYPE_1("1")
 			;
 		 
 		private String value;

	    public String getValue() {
	        return value;
	    }
	    
	    MATCHING_TYPEEnum(String value) {
	        this.value = value;
	    }
	    
	    public final static Map<MATCHING_TYPEEnum, String> map ;
	    static{
	    	map = new EnumMap<MATCHING_TYPEEnum, String>(MATCHING_TYPEEnum.class);
		 	map.put(MATCHING_TYPEEnum.MATCHING_TYPE_0 , "0-现金贷");
		 	map.put(MATCHING_TYPEEnum.MATCHING_TYPE_1 , "1-保理");
	    }
	    /**
	     * 跟据value返回枚举对应的key
	     * 
	     * @param value
	     * @return NotifyErrorCode
	     */
	    public static MATCHING_TYPEEnum getEnum(String value) {
	    	MATCHING_TYPEEnum tmpKey = null;
	        for (MATCHING_TYPEEnum tmpEnum : MATCHING_TYPEEnum.values()) {
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
	        return MATCHING_TYPEEnum.map.get(
	        		MATCHING_TYPEEnum.getEnum(value));
	    }
	    
 	}	
	public static  enum MONEY_CLOSED_LOOPEnum{
	
		/**
 		 *  0-否
 		 */
 			MONEY_CLOSED_LOOP_0("0"),
		/**
 		 *  1-是
 		 */
 			MONEY_CLOSED_LOOP_1("1")
 			;
 		 
 		private String value;

	    public String getValue() {
	        return value;
	    }
	    
	    MONEY_CLOSED_LOOPEnum(String value) {
	        this.value = value;
	    }
	    
	    public final static Map<MONEY_CLOSED_LOOPEnum, String> map ;
	    static{
	    	map = new EnumMap<MONEY_CLOSED_LOOPEnum, String>(MONEY_CLOSED_LOOPEnum.class);
		 	map.put(MONEY_CLOSED_LOOPEnum.MONEY_CLOSED_LOOP_0 , "0-否");
		 	map.put(MONEY_CLOSED_LOOPEnum.MONEY_CLOSED_LOOP_1 , "1-是");
	    }
	    /**
	     * 跟据value返回枚举对应的key
	     * 
	     * @param value
	     * @return NotifyErrorCode
	     */
	    public static MONEY_CLOSED_LOOPEnum getEnum(String value) {
	    	MONEY_CLOSED_LOOPEnum tmpKey = null;
	        for (MONEY_CLOSED_LOOPEnum tmpEnum : MONEY_CLOSED_LOOPEnum.values()) {
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
	        return MONEY_CLOSED_LOOPEnum.map.get(
	        		MONEY_CLOSED_LOOPEnum.getEnum(value));
	    }
	    
 	}	
	public static  enum LEGAL_RELATION_CLOSED_LOOPEnum{
	
		/**
 		 *  0-否
 		 */
 			LEGAL_RELATION_CLOSED_LOOP_0("0"),
		/**
 		 *  1-是
 		 */
 			LEGAL_RELATION_CLOSED_LOOP_1("1")
 			;
 		 
 		private String value;

	    public String getValue() {
	        return value;
	    }
	    
	    LEGAL_RELATION_CLOSED_LOOPEnum(String value) {
	        this.value = value;
	    }
	    
	    public final static Map<LEGAL_RELATION_CLOSED_LOOPEnum, String> map ;
	    static{
	    	map = new EnumMap<LEGAL_RELATION_CLOSED_LOOPEnum, String>(LEGAL_RELATION_CLOSED_LOOPEnum.class);
		 	map.put(LEGAL_RELATION_CLOSED_LOOPEnum.LEGAL_RELATION_CLOSED_LOOP_0 , "0-否");
		 	map.put(LEGAL_RELATION_CLOSED_LOOPEnum.LEGAL_RELATION_CLOSED_LOOP_1 , "1-是");
	    }
	    /**
	     * 跟据value返回枚举对应的key
	     * 
	     * @param value
	     * @return NotifyErrorCode
	     */
	    public static LEGAL_RELATION_CLOSED_LOOPEnum getEnum(String value) {
	    	LEGAL_RELATION_CLOSED_LOOPEnum tmpKey = null;
	        for (LEGAL_RELATION_CLOSED_LOOPEnum tmpEnum : LEGAL_RELATION_CLOSED_LOOPEnum.values()) {
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
	        return LEGAL_RELATION_CLOSED_LOOPEnum.map.get(
	        		LEGAL_RELATION_CLOSED_LOOPEnum.getEnum(value));
	    }
	    
 	}	
	public static  enum DATA_CLOSED_LOOPEnum{
	
		/**
 		 *  0-否
 		 */
 			DATA_CLOSED_LOOP_0("0"),
		/**
 		 *  1-是
 		 */
 			DATA_CLOSED_LOOP_1("1")
 			;
 		 
 		private String value;

	    public String getValue() {
	        return value;
	    }
	    
	    DATA_CLOSED_LOOPEnum(String value) {
	        this.value = value;
	    }
	    
	    public final static Map<DATA_CLOSED_LOOPEnum, String> map ;
	    static{
	    	map = new EnumMap<DATA_CLOSED_LOOPEnum, String>(DATA_CLOSED_LOOPEnum.class);
		 	map.put(DATA_CLOSED_LOOPEnum.DATA_CLOSED_LOOP_0 , "0-否");
		 	map.put(DATA_CLOSED_LOOPEnum.DATA_CLOSED_LOOP_1 , "1-是");
	    }
	    /**
	     * 跟据value返回枚举对应的key
	     * 
	     * @param value
	     * @return NotifyErrorCode
	     */
	    public static DATA_CLOSED_LOOPEnum getEnum(String value) {
	    	DATA_CLOSED_LOOPEnum tmpKey = null;
	        for (DATA_CLOSED_LOOPEnum tmpEnum : DATA_CLOSED_LOOPEnum.values()) {
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
	        return DATA_CLOSED_LOOPEnum.map.get(
	        		DATA_CLOSED_LOOPEnum.getEnum(value));
	    }
	    
 	}	
	public static  enum STATUSEnum{
	
		/**
 		 *  0-立项
 		 */
 			STATUS_0("0"),
		/**
 		 *  1-信审会通过
 		 */
 			STATUS_1("1"),
		/**
 		 *  2-法务
 		 */
 			STATUS_2("2"),
		/**
 		 *  3-预备上会
 		 */
 			STATUS_3("3"),
		/**
 		 *  4-上会
 		 */
 			STATUS_4("4"),
		/**
 		 *  5-上线
 		 */
 			STATUS_5("5")
 			;
 		 
 		private String value;

	    public String getValue() {
	        return value;
	    }
	    
	    STATUSEnum(String value) {
	        this.value = value;
	    }
	    
	    public final static Map<STATUSEnum, String> map ;
	    static{
	    	map = new EnumMap<STATUSEnum, String>(STATUSEnum.class);
		 	map.put(STATUSEnum.STATUS_0 , "0-立项");
		 	map.put(STATUSEnum.STATUS_1 , "1-信审会通过");
		 	map.put(STATUSEnum.STATUS_2 , "2-法务");
		 	map.put(STATUSEnum.STATUS_3 , "3-预备上会");
		 	map.put(STATUSEnum.STATUS_4 , "4-上会");
		 	map.put(STATUSEnum.STATUS_5 , "5-上线");
	    }
	    /**
	     * 跟据value返回枚举对应的key
	     * 
	     * @param value
	     * @return NotifyErrorCode
	     */
	    public static STATUSEnum getEnum(String value) {
	    	STATUSEnum tmpKey = null;
	        for (STATUSEnum tmpEnum : STATUSEnum.values()) {
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
	        return STATUSEnum.map.get(
	        		STATUSEnum.getEnum(value));
	    }
	    
 	}	
}
