<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ include file="/page/common/easyui_head.jsp"%>
<title>模板内容页</title>
</head>
<body>
<div class="content-body">
	<div class="search-panel toggle-panel">
		<div class="search-panel-content">
			<form id="editTbSceneInfoFrom" name="editTbSceneInfoFrom" method='post'>
				<div class="search-panel-bd">
							<input type="hidden" id="edit_id" name="edit_id"   />
					<table class="search-table">
								 <tr>
									<th class="wd-20"><label>客户</label></th>
									<td>
											<select id="edit_cust_id" name="edit_cust_id" class="easyui-combobox"  style="width:200px;">
											</select>
									</td>
									<th class="wd-20"><label>产品</label></th>
									<td>
											<select id="edit_product_id" name="edit_product_id" class="easyui-combobox"  style="width:200px;">
											</select>
									</td>
								  </tr>
								 <tr>
									<th class="wd-20"><label>项目名称</label></th>
									<td>
											<input type="text" id="edit_project_name" name="edit_project_name" class="easyui-validatebox"   data-options="required:true,invalidMessage:'项目名称不能为空',missingMessage:'项目名称不能为空'"  style="width:200px;" />
									</td>
									<th class="wd-20"><label>子品牌</label></th>
									<td>
											<input type="text" id="edit_sub_brand" name="edit_sub_brand" class="easyui-validatebox"   data-options="required:true,invalidMessage:'子品牌不能为空',missingMessage:'子品牌不能为空'"  style="width:200px;" />
									</td>
								  </tr>
								 <tr>
									<th class="wd-20"><label>场景类型</label></th>
									<td>
											<select id="edit_scene_type" name="edit_scene_type" class="easyui-combobox"  style="width:200px;">
												<option value="">未选择</option>
													<option value="0">0-商品分期</option>
													<option value="1">1-现金贷</option>
											</select>
									</td>
									<th class="wd-20"><label>融资方式</label></th>
									<td>
											<select id="edit_way_of_financing" name="edit_way_of_financing" class="easyui-combobox"  style="width:200px;">
												<option value="">未选择</option>
													<option value="0">0-转债</option>
													<option value="1">1-直融</option>
													<option value="2">2-转债加直融</option>
											</select>
									</td>
								  </tr>
								 <tr>
									<th class="wd-20"><label>需求类型</label></th>
									<td>
											<select id="edit_demand_type" name="edit_demand_type" class="easyui-combobox"  style="width:200px;">
												<option value="">未选择</option>
													<option value="0">0-新增资产规模</option>
													<option value="1">1-新增资金需求</option>
											</select>
									</td>
									<th class="wd-20"><label>匹配资金类型</label></th>
									<td>
											<select id="edit_matching_type" name="edit_matching_type" class="easyui-combobox"  style="width:200px;">
												<option value="">未选择</option>
													<option value="0">0-现金贷</option>
													<option value="1">1-保理</option>
											</select>
									</td>
								  </tr>
								<tr>
									<th class="wd-20"><label>立项时间</label></th>
									<td>
										<input type="text" id="edit_product_time" name="edit_product_time"   class="easyui-datebox" data-options="required:true,invalidMessage:'立项时间格式必须为yyyy-mm-dd',missingMessage:'立项时间格式必须为yyyy-mm-dd'"  style="width:200px;"/>
									</td>
									<th class="wd-20"><label>区域</label></th>
									<td>
											<input type="text" id="edit_area" name="edit_area" class="easyui-validatebox"   data-options="required:true,invalidMessage:'区域不能为空',missingMessage:'区域不能为空'"  style="width:200px;" />
									</td>
								  </tr>
								 <tr>
									<th class="wd-20"><label>项目管理人</label></th>
									<td>
											<select id="edit_project_manager" name="edit_project_manager" class="easyui-combobox"  style="width:200px;">
											</select>
									</td>
									<th class="wd-20"><label>产品经理人</label></th>
									<td>
											<select id="edit_product_manager" name="edit_product_manager" class="easyui-combobox"  style="width:200px;">
											</select>
									</td>
								  </tr>
								 <tr>
									<th class="wd-20"><label>风控负责人</label></th>
									<td>
											<select id="edit_risk_controller" name="edit_risk_controller" class="easyui-combobox"  style="width:200px;">
											</select>
									</td>
									<th class="wd-20"><label>法务负责人</label></th>
									<td>
											<select id="edit_law_worker" name="edit_law_worker" class="easyui-combobox"  style="width:200px;">
											</select>
									</td>
								  </tr>
								 <tr>
									<th class="wd-20"><label>运营负责人</label></th>
									<td>
											<select id="edit_oprater" name="edit_oprater" class="easyui-combobox"  style="width:200px;">
											</select>
									</td>
									<th class="wd-20"><label>开发负责人</label></th>
									<td>
											<select id="edit_it_manager" name="edit_it_manager" class="easyui-combobox"  style="width:200px;">
											</select>
									</td>
								  </tr>
								 <tr>
									<th class="wd-20"><label>BA</label></th>
									<td>
											<select id="edit_business_analyzer" name="edit_business_analyzer" class="easyui-combobox"  style="width:200px;">
											</select>
									</td>
									<th class="wd-20"><label>数据负责人</label></th>
									<td>
											<select id="edit_data_manager" name="edit_data_manager" class="easyui-combobox"  style="width:200px;">
											</select>
									</td>
								  </tr>
								 <tr>
									<th class="wd-20"><label>募集需求</label></th>
									<td>
											<input type="text" id="edit_raise_demand" name="edit_raise_demand" class="easyui-validatebox"   data-options="required:true,invalidMessage:'募集需求不能为空',missingMessage:'募集需求不能为空'"  style="width:200px;" />
									</td>
									<th class="wd-20"><label>商务条件</label></th>
									<td>
											<input type="text" id="edit_business_condition" name="edit_business_condition" class="easyui-validatebox"   data-options="required:true,invalidMessage:'商务条件不能为空',missingMessage:'商务条件不能为空'"  style="width:200px;" />
									</td>
								  </tr>
								 <tr>
									<th class="wd-20"><label>场景说明</label></th>
									<td>
											<input type="text" id="edit_scene_doc" name="edit_scene_doc" class="easyui-validatebox"   data-options="required:true,invalidMessage:'场景说明不能为空',missingMessage:'场景说明不能为空'"  style="width:200px;" />
									</td>
									<th class="wd-20"><label>实际费率</label></th>
									<td>
										<input type="text" id="edit_actual_rate" name="edit_actual_rate"   class="easyui-validatebox" data-options="required:true,validType:'number[2,16]',invalidMessage:'实际费率必须为数字',missingMessage:'实际费率必须为数字'" style="width:200px;"/>
									</td>
								  </tr>
								 <tr>
									<th class="wd-20"><label>授信额度</label></th>
									<td>
										<input type="text" id="edit_line_of_credit" name="edit_line_of_credit"   class="easyui-validatebox" data-options="required:true,validType:'number[2,16]',invalidMessage:'授信额度必须为数字',missingMessage:'授信额度必须为数字'" style="width:200px;"/>
									</td>
									<th class="wd-20"><label>最低承保余额</label></th>
									<td>
										<input type="text" id="edit_underwrite_balance_mix" name="edit_underwrite_balance_mix"   class="easyui-validatebox" data-options="required:true,validType:'number[2,16]',invalidMessage:'最低承保余额必须为数字',missingMessage:'最低承保余额必须为数字'" style="width:200px;"/>
									</td>
								  </tr>
								 <tr>
									<th class="wd-20"><label>产品经理属地</label></th>
									<td>
											<input type="text" id="edit_product_manager_colony" name="edit_product_manager_colony" class="easyui-validatebox"   data-options="required:true,invalidMessage:'产品经理属地不能为空',missingMessage:'产品经理属地不能为空'"  style="width:200px;" />
									</td>
									<th class="wd-20"><label>项目属地</label></th>
									<td>
											<input type="text" id="edit_project_colony" name="edit_project_colony" class="easyui-validatebox"   data-options="required:true,invalidMessage:'项目属地不能为空',missingMessage:'项目属地不能为空'"  style="width:200px;" />
									</td>
								  </tr>
								 <tr>
									<th class="wd-20"><label>资金闭环</label></th>
									<td>
											<select id="edit_money_closed_loop" name="edit_money_closed_loop" class="easyui-combobox"  style="width:200px;">
												<option value="">未选择</option>
													<option value="0">0-否</option>
													<option value="1">1-是</option>
											</select>
									</td>
									<th class="wd-20"><label>法律关系闭环</label></th>
									<td>
											<select id="edit_legal_relation_closed_loop" name="edit_legal_relation_closed_loop" class="easyui-combobox"  style="width:200px;">
												<option value="">未选择</option>
													<option value="0">0-否</option>
													<option value="1">1-是</option>
											</select>
									</td>
								  </tr>
								 <tr>
									<th class="wd-20"><label>数据闭环</label></th>
									<td>
											<select id="edit_data_closed_loop" name="edit_data_closed_loop" class="easyui-combobox"  style="width:200px;">
												<option value="">未选择</option>
													<option value="0">0-否</option>
													<option value="1">1-是</option>
											</select>
									</td>
									<th class="wd-20"><label>法务-多年期条款推进</label></th>
									<td>
											<input type="text" id="edit_low_works_boost" name="edit_low_works_boost" class="easyui-validatebox"   data-options="required:true,invalidMessage:'法务-多年期条款推进不能为空',missingMessage:'法务-多年期条款推进不能为空'"  style="width:200px;" />
									</td>
								  </tr>
								 <tr>
									<th class="wd-20"><label>放款还款-稳定性</label></th>
									<td>
											<input type="text" id="edit_loan_repayment_stability" name="edit_loan_repayment_stability" class="easyui-validatebox"   data-options="required:true,invalidMessage:'放款还款-稳定性不能为空',missingMessage:'放款还款-稳定性不能为空'"  style="width:200px;" />
									</td>
									<th class="wd-20"><label>放款还款-信托限额</label></th>
									<td>
											<input type="text" id="edit_limitation_of_the_trust" name="edit_limitation_of_the_trust" class="easyui-validatebox"   data-options="required:true,invalidMessage:'放款还款-信托限额不能为空',missingMessage:'放款还款-信托限额不能为空'"  style="width:200px;" />
									</td>
								  </tr>
								 <tr>
									<th class="wd-20"><label>放款还款-监管限额</label></th>
									<td>
											<input type="text" id="edit_reg_limits" name="edit_reg_limits" class="easyui-validatebox"   data-options="required:true,invalidMessage:'放款还款-监管限额不能为空',missingMessage:'放款还款-监管限额不能为空'"  style="width:200px;" />
									</td>
									<th class="wd-20"><label>放款还款-竞争环境下资金供给</label></th>
									<td>
											<input type="text" id="edit_bankroll" name="edit_bankroll" class="easyui-validatebox"   data-options="required:true,invalidMessage:'放款还款-竞争环境下资金供给不能为空',missingMessage:'放款还款-竞争环境下资金供给不能为空'"  style="width:200px;" />
									</td>
								  </tr>
								 <tr>
									<th class="wd-20"><label>放款还款-接入第三方支付</label></th>
									<td>
											<input type="text" id="edit_third_pay" name="edit_third_pay" class="easyui-validatebox"   data-options="required:true,invalidMessage:'放款还款-接入第三方支付不能为空',missingMessage:'放款还款-接入第三方支付不能为空'"  style="width:200px;" />
									</td>
									<th class="wd-20"><label>放款还款-大型第三方不开立金融账户</label></th>
									<td>
											<input type="text" id="edit_account" name="edit_account" class="easyui-validatebox"   data-options="required:true,invalidMessage:'放款还款-大型第三方不开立金融账户不能为空',missingMessage:'放款还款-大型第三方不开立金融账户不能为空'"  style="width:200px;" />
									</td>
								  </tr>
								 <tr>
									<th class="wd-20"><label>业务-租赁公司全国抵押备案</label></th>
									<td>
											<input type="text" id="edit_mortgage_registration" name="edit_mortgage_registration" class="easyui-validatebox"   data-options="required:true,invalidMessage:'业务-租赁公司全国抵押备案不能为空',missingMessage:'业务-租赁公司全国抵押备案不能为空'"  style="width:200px;" />
									</td>
									<th class="wd-20"><label>信审会额度限制</label></th>
									<td>
											<input type="text" id="edit_credit_aduit_limit" name="edit_credit_aduit_limit" class="easyui-validatebox"   data-options="required:true,invalidMessage:'信审会额度限制不能为空',missingMessage:'信审会额度限制不能为空'"  style="width:200px;" />
									</td>
								  </tr>
								 <tr>
									<th class="wd-20"><label>memo</label></th>
									<td>
											<input type="text" id="edit_memo" name="edit_memo" class="easyui-validatebox"   data-options="required:true,invalidMessage:'memo不能为空',missingMessage:'memo不能为空'"  style="width:200px;" />
									</td>
									<th class="wd-20"><label>业务-车抵贷管理能力</label></th>
									<td>
											<input type="text" id="edit_management_ability" name="edit_management_ability" class="easyui-validatebox"   data-options="required:true,invalidMessage:'业务-车抵贷管理能力不能为空',missingMessage:'业务-车抵贷管理能力不能为空'"  style="width:200px;" />
									</td>
								  </tr>
								 <tr>
									<th class="wd-20"><label>预计上线时间</label></th>
									<td>
											<input type="text" id="edit_expected_online_time" name="edit_expected_online_time" class="easyui-validatebox"   data-options="required:true,invalidMessage:'预计上线时间不能为空',missingMessage:'预计上线时间不能为空'"  style="width:200px;" />
									</td>
									<th class="wd-20"><label>项目状态</label></th>
									<td>
											<select id="edit_status" name="edit_status" class="easyui-combobox"  style="width:200px;">
												<option value="">未选择</option>
													<option value="0">0-立项</option>
													<option value="1">1-信审会通过</option>
													<option value="2">2-法务</option>
													<option value="3">3-预备上会</option>
													<option value="4">4-上会</option>
													<option value="5">5-上线</option>
											</select>
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
	
			$.ajax({
			 type:'POST',
			 cache:false,
			 async: false,
		     url:'<%=path%>'+"/obtainTbCustInfo.do",
			 success:function(data){
						data = $.parseJSON(data);
						$("#edit_cust_id").combobox({	
					    			data:data.rows,
					    			valueField:'id', 
					    			textField:'text' ,
					    		});
				}
		});	
			$.ajax({
			 type:'POST',
			 cache:false,
			 async: false,
		     url:'<%=path%>'+"/obtainTbProductInfo.do",
			 success:function(data){
						data = $.parseJSON(data);
						$("#edit_product_id").combobox({	
					    			data:data.rows,
					    			valueField:'id', 
					    			textField:'text' ,
					    		});
				}
		});	
			$.ajax({
			 type:'POST',
			 cache:false,
			 async: false,
		     url:'<%=path%>'+"/obtainTbSysrUserProjectManager.do",
			 success:function(data){
						data = $.parseJSON(data);
						$("#edit_project_manager").combobox({	
					    			data:data.rows,
					    			valueField:'id', 
					    			textField:'text' ,
					    		});
				}
		});	
			$.ajax({
			 type:'POST',
			 cache:false,
			 async: false,
		     url:'<%=path%>'+"/obtainTbSysrUserProductManager.do",
			 success:function(data){
						data = $.parseJSON(data);
						$("#edit_product_manager").combobox({	
					    			data:data.rows,
					    			valueField:'id', 
					    			textField:'text' ,
					    		});
				}
		});	
			$.ajax({
			 type:'POST',
			 cache:false,
			 async: false,
		     url:'<%=path%>'+"/obtainTbSysrUserRiskController.do",
			 success:function(data){
						data = $.parseJSON(data);
						$("#edit_risk_controller").combobox({	
					    			data:data.rows,
					    			valueField:'id', 
					    			textField:'text' ,
					    		});
				}
		});	
			$.ajax({
			 type:'POST',
			 cache:false,
			 async: false,
		     url:'<%=path%>'+"/obtainTbSysrUserLowWorker.do",
			 success:function(data){
						data = $.parseJSON(data);
						$("#edit_law_worker").combobox({	
					    			data:data.rows,
					    			valueField:'id', 
					    			textField:'text' ,
					    		});
				}
		});	
			$.ajax({
			 type:'POST',
			 cache:false,
			 async: false,
		     url:'<%=path%>'+"/obtainTbSysrUserOperater.do",
			 success:function(data){
						data = $.parseJSON(data);
						$("#edit_oprater").combobox({	
					    			data:data.rows,
					    			valueField:'id', 
					    			textField:'text' ,
					    		});
				}
		});	
			$.ajax({
			 type:'POST',
			 cache:false,
			 async: false,
		     url:'<%=path%>'+"/obtainTbSysrUserItManager.do",
			 success:function(data){
						data = $.parseJSON(data);
						$("#edit_it_manager").combobox({	
					    			data:data.rows,
					    			valueField:'id', 
					    			textField:'text' ,
					    		});
				}
		});	
			$.ajax({
			 type:'POST',
			 cache:false,
			 async: false,
		     url:'<%=path%>'+"/obtainTbSysrUserBA.do",
			 success:function(data){
						data = $.parseJSON(data);
						$("#edit_business_analyzer").combobox({	
					    			data:data.rows,
					    			valueField:'id', 
					    			textField:'text' ,
					    		});
				}
		});	
			$.ajax({
			 type:'POST',
			 cache:false,
			 async: false,
		     url:'<%=path%>'+"/obtainTbSysrUserDataManager.do",
			 success:function(data){
						data = $.parseJSON(data);
						$("#edit_data_manager").combobox({	
					    			data:data.rows,
					    			valueField:'id', 
					    			textField:'text' ,
					    		});
				}
		});	


	<%String pkid=request.getParameter("pkid"); %>
	$.ajax({
		type:'POST',
		url:'<%=path%>'+"/editDetail_TbSceneInfo.do?pkid="+'<%=pkid%>',    
		success:function(data){
		 	data = $.parseJSON(data);
		 	var message = data.message;
					$("#edit_id").val(message.id); 
		 			$("#edit_cust_id").combobox('select', message.cust_id);
		 			$("#edit_product_id").combobox('select', message.product_id);
					$("#edit_project_name").val(message.project_name); 
					$("#edit_sub_brand").val(message.sub_brand); 
		 			$("#edit_scene_type").combobox('select', message.scene_type);
		 			$("#edit_way_of_financing").combobox('select', message.way_of_financing);
		 			$("#edit_demand_type").combobox('select', message.demand_type);
		 			$("#edit_matching_type").combobox('select', message.matching_type);
					$("#edit_product_time").val(message.product_time); 
					$("#edit_area").val(message.area); 
		 			$("#edit_project_manager").combobox('select', message.project_manager);
		 			$("#edit_product_manager").combobox('select', message.product_manager);
		 			$("#edit_risk_controller").combobox('select', message.risk_controller);
		 			$("#edit_law_worker").combobox('select', message.law_worker);
		 			$("#edit_oprater").combobox('select', message.oprater);
		 			$("#edit_it_manager").combobox('select', message.it_manager);
		 			$("#edit_business_analyzer").combobox('select', message.business_analyzer);
		 			$("#edit_data_manager").combobox('select', message.data_manager);
					$("#edit_raise_demand").val(message.raise_demand); 
					$("#edit_business_condition").val(message.business_condition); 
					$("#edit_scene_doc").val(message.scene_doc); 
					$("#edit_actual_rate").val(message.actual_rate); 
					$("#edit_line_of_credit").val(message.line_of_credit); 
					$("#edit_underwrite_balance_mix").val(message.underwrite_balance_mix); 
					$("#edit_product_manager_colony").val(message.product_manager_colony); 
					$("#edit_project_colony").val(message.project_colony); 
		 			$("#edit_money_closed_loop").combobox('select', message.money_closed_loop);
		 			$("#edit_legal_relation_closed_loop").combobox('select', message.legal_relation_closed_loop);
		 			$("#edit_data_closed_loop").combobox('select', message.data_closed_loop);
					$("#edit_low_works_boost").val(message.low_works_boost); 
					$("#edit_loan_repayment_stability").val(message.loan_repayment_stability); 
					$("#edit_limitation_of_the_trust").val(message.limitation_of_the_trust); 
					$("#edit_reg_limits").val(message.reg_limits); 
					$("#edit_bankroll").val(message.bankroll); 
					$("#edit_third_pay").val(message.third_pay); 
					$("#edit_account").val(message.account); 
					$("#edit_mortgage_registration").val(message.mortgage_registration); 
					$("#edit_credit_aduit_limit").val(message.credit_aduit_limit); 
					$("#edit_memo").val(message.memo); 
					$("#edit_management_ability").val(message.management_ability); 
					$("#edit_expected_online_time").val(message.expected_online_time); 
		 			$("#edit_status").combobox('select', message.status);
					$("#edit_gmt_created").val(message.gmt_created); 
					$("#edit_gmt_modified").val(message.gmt_modified); 
					$("#edit_creator").val(message.creator); 
					$("#edit_modifier").val(message.modifier); 
					$("#edit_is_deleted").val(message.is_deleted); 
		}
	});	
}); 
</script>
</body>
</html>