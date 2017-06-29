<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ include file="/page/common/easyui_head.jsp"%>
<title>模板内容页</title>
<script type='text/javascript' src='<%=basePath%>js/common.js'></script>
</head>
<body>
<div class="content-body">
	<div class="search-panel toggle-panel">
		<div class="search-panel-content">
				<div class="search-panel-bd">
					<table class="search-table">
					   		 <tr>
								<th class="wd-20"><label>客户ID</label></th>
								<td>
									<input type="text" id="detail_cust_id" name="detail_cust_id"   style="width:200px;border-width: 0" readonly="true" />
								</td>
								<th class="wd-20"><label>产品ID</label></th>
								<td>
									<input type="text" id="detail_product_id" name="detail_product_id"   style="width:200px;border-width: 0" readonly="true" />
								</td>
							  </tr>
							 <tr>
								<th class="wd-20"><label>项目名称</label></th>
								<td>
									<input type="text" id="detail_project_name" name="detail_project_name"   style="width:200px;border-width: 0" readonly="true" />
								</td>
								<th class="wd-20"><label>子品牌</label></th>
								<td>
									<input type="text" id="detail_sub_brand" name="detail_sub_brand"   style="width:200px;border-width: 0" readonly="true" />
								</td>
							  </tr>
							 <tr>
								<th class="wd-20"><label>场景类型</label></th>
								<td>
									<input type="text" id="detail_scene_type" name="detail_scene_type"   style="width:200px;border-width: 0" readonly="true" />
								</td>
								<th class="wd-20"><label>融资方式</label></th>
								<td>
									<input type="text" id="detail_way_of_financing" name="detail_way_of_financing"   style="width:200px;border-width: 0" readonly="true" />
								</td>
							  </tr>
							 <tr>
								<th class="wd-20"><label>需求类型</label></th>
								<td>
									<input type="text" id="detail_demand_type" name="detail_demand_type"   style="width:200px;border-width: 0" readonly="true" />
								</td>
								<th class="wd-20"><label>匹配资金类型</label></th>
								<td>
									<input type="text" id="detail_matching_type" name="detail_matching_type"   style="width:200px;border-width: 0" readonly="true" />
								</td>
							  </tr>
							<tr>
								<th class="wd-20"><label>立项时间</label></th>
								<td>
									<input type="text" id="detail_product_time" name="detail_product_time" style="width:200px;border-width: 0" readonly="true" />
								</td>
								<th class="wd-20"><label>区域</label></th>
								<td>
									<input type="text" id="detail_area" name="detail_area"   style="width:200px;border-width: 0" readonly="true" />
								</td>
							  </tr>
							 <tr>
								<th class="wd-20"><label>项目管理人</label></th>
								<td>
									<input type="text" id="detail_project_manager" name="detail_project_manager"   style="width:200px;border-width: 0" readonly="true" />
								</td>
								<th class="wd-20"><label>产品经理人</label></th>
								<td>
									<input type="text" id="detail_product_manager" name="detail_product_manager"   style="width:200px;border-width: 0" readonly="true" />
								</td>
							  </tr>
							 <tr>
								<th class="wd-20"><label>风控负责人</label></th>
								<td>
									<input type="text" id="detail_risk_controller" name="detail_risk_controller"   style="width:200px;border-width: 0" readonly="true" />
								</td>
								<th class="wd-20"><label>法务负责人</label></th>
								<td>
									<input type="text" id="detail_law_worker" name="detail_law_worker"   style="width:200px;border-width: 0" readonly="true" />
								</td>
							  </tr>
							 <tr>
								<th class="wd-20"><label>运营负责人</label></th>
								<td>
									<input type="text" id="detail_oprater" name="detail_oprater"   style="width:200px;border-width: 0" readonly="true" />
								</td>
								<th class="wd-20"><label>开发负责人</label></th>
								<td>
									<input type="text" id="detail_it_manager" name="detail_it_manager"   style="width:200px;border-width: 0" readonly="true" />
								</td>
							  </tr>
							 <tr>
								<th class="wd-20"><label>BA</label></th>
								<td>
									<input type="text" id="detail_business_analyzer" name="detail_business_analyzer"   style="width:200px;border-width: 0" readonly="true" />
								</td>
								<th class="wd-20"><label>数据负责人</label></th>
								<td>
									<input type="text" id="detail_data_manager" name="detail_data_manager"   style="width:200px;border-width: 0" readonly="true" />
								</td>
							  </tr>
							 <tr>
								<th class="wd-20"><label>募集需求</label></th>
								<td>
									<input type="text" id="detail_raise_demand" name="detail_raise_demand"   style="width:200px;border-width: 0" readonly="true" />
								</td>
								<th class="wd-20"><label>商务条件</label></th>
								<td>
									<input type="text" id="detail_business_condition" name="detail_business_condition"   style="width:200px;border-width: 0" readonly="true" />
								</td>
							  </tr>
							 <tr>
								<th class="wd-20"><label>场景说明</label></th>
								<td>
									<input type="text" id="detail_scene_doc" name="detail_scene_doc"   style="width:200px;border-width: 0" readonly="true" />
								</td>
								<th class="wd-20"><label>实际费率</label></th>
								<td>
									<input type="text" id="detail_actual_rate" name="detail_actual_rate"   style="width:200px;border-width: 0" readonly="true" />
								</td>
							  </tr>
							 <tr>
								<th class="wd-20"><label>授信额度</label></th>
								<td>
									<input type="text" id="detail_line_of_credit" name="detail_line_of_credit"   style="width:200px;border-width: 0" readonly="true" />
								</td>
								<th class="wd-20"><label>最低承保余额</label></th>
								<td>
									<input type="text" id="detail_underwrite_balance_mix" name="detail_underwrite_balance_mix"   style="width:200px;border-width: 0" readonly="true" />
								</td>
							  </tr>
							 <tr>
								<th class="wd-20"><label>产品经理属地</label></th>
								<td>
									<input type="text" id="detail_product_manager_colony" name="detail_product_manager_colony"   style="width:200px;border-width: 0" readonly="true" />
								</td>
								<th class="wd-20"><label>项目属地</label></th>
								<td>
									<input type="text" id="detail_project_colony" name="detail_project_colony"   style="width:200px;border-width: 0" readonly="true" />
								</td>
							  </tr>
							 <tr>
								<th class="wd-20"><label>资金闭环</label></th>
								<td>
									<input type="text" id="detail_money_closed_loop" name="detail_money_closed_loop"   style="width:200px;border-width: 0" readonly="true" />
								</td>
								<th class="wd-20"><label>法律关系闭环</label></th>
								<td>
									<input type="text" id="detail_legal_relation_closed_loop" name="detail_legal_relation_closed_loop"   style="width:200px;border-width: 0" readonly="true" />
								</td>
							  </tr>
							 <tr>
								<th class="wd-20"><label>数据闭环</label></th>
								<td>
									<input type="text" id="detail_data_closed_loop" name="detail_data_closed_loop"   style="width:200px;border-width: 0" readonly="true" />
								</td>
								<th class="wd-20"><label>法务-多年期条款推进</label></th>
								<td>
									<input type="text" id="detail_low_works_boost" name="detail_low_works_boost"   style="width:200px;border-width: 0" readonly="true" />
								</td>
							  </tr>
							 <tr>
								<th class="wd-20"><label>放款还款-稳定性</label></th>
								<td>
									<input type="text" id="detail_loan_repayment_stability" name="detail_loan_repayment_stability"   style="width:200px;border-width: 0" readonly="true" />
								</td>
								<th class="wd-20"><label>放款还款-信托限额</label></th>
								<td>
									<input type="text" id="detail_limitation_of_the_trust" name="detail_limitation_of_the_trust"   style="width:200px;border-width: 0" readonly="true" />
								</td>
							  </tr>
							 <tr>
								<th class="wd-20"><label>放款还款-监管限额</label></th>
								<td>
									<input type="text" id="detail_reg_limits" name="detail_reg_limits"   style="width:200px;border-width: 0" readonly="true" />
								</td>
								<th class="wd-20"><label>放款还款-竞争环境下资金供给</label></th>
								<td>
									<input type="text" id="detail_bankroll" name="detail_bankroll"   style="width:200px;border-width: 0" readonly="true" />
								</td>
							  </tr>
							 <tr>
								<th class="wd-20"><label>放款还款-接入第三方支付</label></th>
								<td>
									<input type="text" id="detail_third_pay" name="detail_third_pay"   style="width:200px;border-width: 0" readonly="true" />
								</td>
								<th class="wd-20"><label>放款还款-大型第三方不开立金融账户</label></th>
								<td>
									<input type="text" id="detail_account" name="detail_account"   style="width:200px;border-width: 0" readonly="true" />
								</td>
							  </tr>
							 <tr>
								<th class="wd-20"><label>业务-租赁公司全国抵押备案</label></th>
								<td>
									<input type="text" id="detail_mortgage_registration" name="detail_mortgage_registration"   style="width:200px;border-width: 0" readonly="true" />
								</td>
								<th class="wd-20"><label>信审会额度限制</label></th>
								<td>
									<input type="text" id="detail_credit_aduit_limit" name="detail_credit_aduit_limit"   style="width:200px;border-width: 0" readonly="true" />
								</td>
							  </tr>
							 <tr>
								<th class="wd-20"><label>memo</label></th>
								<td>
									<input type="text" id="detail_memo" name="detail_memo"   style="width:200px;border-width: 0" readonly="true" />
								</td>
								<th class="wd-20"><label>业务-车抵贷管理能力</label></th>
								<td>
									<input type="text" id="detail_management_ability" name="detail_management_ability"   style="width:200px;border-width: 0" readonly="true" />
								</td>
							  </tr>
							 <tr>
								<th class="wd-20"><label>预计上线时间</label></th>
								<td>
									<input type="text" id="detail_expected_online_time" name="detail_expected_online_time"   style="width:200px;border-width: 0" readonly="true" />
								</td>
								<th class="wd-20"><label>项目状态</label></th>
								<td>
									<input type="text" id="detail_status" name="detail_status"   style="width:200px;border-width: 0" readonly="true" />
								</td>
							  </tr>
							<tr>
								<th class="wd-20"><label>创建时间</label></th>
								<td>
									<input type="text" id="detail_gmt_created" name="detail_gmt_created" style="width:200px;border-width: 0" readonly="true" />
								</td>
								<th class="wd-20"><label>修改时间</label></th>
								<td>
									<input type="text" id="detail_gmt_modified" name="detail_gmt_modified" style="width:200px;border-width: 0" readonly="true" />
								</td>
							 </tr>
							 <tr>
								<th class="wd-20"><label>创建人</label></th>
								<td>
									<input type="text" id="detail_creator" name="detail_creator"   style="width:200px;border-width: 0" readonly="true" />
								</td>
								<th class="wd-20"><label>修改人</label></th>
								<td>
									<input type="text" id="detail_modifier" name="detail_modifier"   style="width:200px;border-width: 0" readonly="true" />
								</td>
							  </tr>
					</table>
				</div>
			</form>
		</div>
	</div>
</div>

<script type="text/javascript">
$(document).ready(function(){ 
	//页面加载时带出相关信息
	<%String pkid=request.getParameter("pkid"); %>
	$.ajax({
		type:'POST',
		url:'<%=path%>'+"/detail_TbSceneInfo.do?pkid="+'<%=pkid%>',    
		success:function(data){
		 	data = $.parseJSON(data);
		 	var message = data.message;
				$("#detail_id").val(message.id); 
				$("#detail_cust_id").val(message.cust_id); 
				$("#detail_product_id").val(message.product_id); 
				$("#detail_project_name").val(message.project_name); 
				$("#detail_sub_brand").val(message.sub_brand); 
				$("#detail_scene_type").val(message.scene_type); 
				$("#detail_way_of_financing").val(message.way_of_financing); 
				$("#detail_demand_type").val(message.demand_type); 
				$("#detail_matching_type").val(message.matching_type); 
				$("#detail_product_time").val(message.product_time); 
				$("#detail_area").val(message.area); 
				$("#detail_project_manager").val(message.project_manager); 
				$("#detail_product_manager").val(message.product_manager); 
				$("#detail_risk_controller").val(message.risk_controller); 
				$("#detail_law_worker").val(message.law_worker); 
				$("#detail_oprater").val(message.oprater); 
				$("#detail_it_manager").val(message.it_manager); 
				$("#detail_business_analyzer").val(message.business_analyzer); 
				$("#detail_data_manager").val(message.data_manager); 
				$("#detail_raise_demand").val(message.raise_demand); 
				$("#detail_business_condition").val(message.business_condition); 
				$("#detail_scene_doc").val(message.scene_doc); 
				$("#detail_actual_rate").val(message.actual_rate); 
				$("#detail_line_of_credit").val(message.line_of_credit); 
				$("#detail_underwrite_balance_mix").val(message.underwrite_balance_mix); 
				$("#detail_product_manager_colony").val(message.product_manager_colony); 
				$("#detail_project_colony").val(message.project_colony); 
				$("#detail_money_closed_loop").val(message.money_closed_loop); 
				$("#detail_legal_relation_closed_loop").val(message.legal_relation_closed_loop); 
				$("#detail_data_closed_loop").val(message.data_closed_loop); 
				$("#detail_low_works_boost").val(message.low_works_boost); 
				$("#detail_loan_repayment_stability").val(message.loan_repayment_stability); 
				$("#detail_limitation_of_the_trust").val(message.limitation_of_the_trust); 
				$("#detail_reg_limits").val(message.reg_limits); 
				$("#detail_bankroll").val(message.bankroll); 
				$("#detail_third_pay").val(message.third_pay); 
				$("#detail_account").val(message.account); 
				$("#detail_mortgage_registration").val(message.mortgage_registration); 
				$("#detail_credit_aduit_limit").val(message.credit_aduit_limit); 
				$("#detail_memo").val(message.memo); 
				$("#detail_management_ability").val(message.management_ability); 
				$("#detail_expected_online_time").val(message.expected_online_time); 
				$("#detail_status").val(message.status); 
				$("#detail_gmt_created").val(message.gmt_created); 
				$("#detail_gmt_modified").val(message.gmt_modified); 
				$("#detail_creator").val(message.creator); 
				$("#detail_modifier").val(message.modifier); 
				$("#detail_is_deleted").val(message.is_deleted); 
		}
	});
}); 
</script>
</body>
</html>