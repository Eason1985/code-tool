<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ include file="/page/common/easyui_head.jsp"%>
<title>模板内容页</title>
</head>
<body>
<div class="content-body" id="addTbSceneInfo">
	<div class="search-panel toggle-panel">
		<div class="search-panel-content">
			<form id="addTbSceneInfoFrom" name="addTbSceneInfoFrom" method="post">
				<div class="search-panel-bd">
				 <table class="search-table">
						 <tr>
							<th class="wd-20"><label>客户ID</label></th>
							<td>
									<select id="add_cust_id" name="add_cust_id" class="easyui-combobox"  style="width:200px;">
									</select>
							</td>
							<th class="wd-20"><label>产品ID</label></th>
							<td>
									<select id="add_product_id" name="add_product_id" class="easyui-combobox"  style="width:200px;">
									</select>
							</td>
						  </tr>
						 <tr>
							<th class="wd-20"><label>项目名称</label></th>
							<td>
									<input type="text" id="add_project_name" name="add_project_name" class="easyui-validatebox"   data-options="required:true,invalidMessage:'project_name不能为空',missingMessage:'project_name不能为空'"  style="width:200px;" />
							</td>
							<th class="wd-20"><label>子品牌</label></th>
							<td>
									<input type="text" id="add_sub_brand" name="add_sub_brand" class="easyui-validatebox"   data-options="required:true,invalidMessage:'sub_brand不能为空',missingMessage:'sub_brand不能为空'"  style="width:200px;" />
							</td>
						  </tr>
						 <tr>
							<th class="wd-20"><label>场景类型</label></th>
							<td>
									<select id="add_scene_type" class="easyui-combobox" name="add_scene_type" style="width:200px;">
											<option value="0">0-商品分期</option>
											<option value="1">1-现金贷</option>
									</select>
							</td>
							<th class="wd-20"><label>融资方式</label></th>
							<td>
									<select id="add_way_of_financing" class="easyui-combobox" name="add_way_of_financing" style="width:200px;">
											<option value="0">0-转债</option>
											<option value="1">1-直融</option>
											<option value="2">2-转债加直融</option>
									</select>
							</td>
						  </tr>
						 <tr>
							<th class="wd-20"><label>需求类型</label></th>
							<td>
									<select id="add_demand_type" class="easyui-combobox" name="add_demand_type" style="width:200px;">
											<option value="0">0-新增资产规模</option>
											<option value="1">1-新增资金需求</option>
									</select>
							</td>
							<th class="wd-20"><label>匹配资金类型</label></th>
							<td>
									<select id="add_matching_type" class="easyui-combobox" name="add_matching_type" style="width:200px;">
											<option value="0">0-现金贷</option>
											<option value="1">1-保理</option>
									</select>
							</td>
						  </tr>
						<tr>
							<th class="wd-20"><label>立项时间</label></th>
							<td>
								<input type="text" id="add_product_time" name="add_product_time" class="easyui-datebox" data-options="required:true,invalidMessage:'product_time格式必须为yyyy-mm-dd',missingMessage:'product_time格式必须为yyyy-mm-dd'"  style="width:200px;"/>
							</td>
							<th class="wd-20"><label>区域</label></th>
							<td>
									<input type="text" id="add_area" name="add_area" class="easyui-validatebox"   data-options="required:true,invalidMessage:'area不能为空',missingMessage:'area不能为空'"  style="width:200px;" />
							</td>
						  </tr>
						 <tr>
							<th class="wd-20"><label>项目管理人</label></th>
							<td>
									<select id="add_project_manager" name="add_project_manager" class="easyui-combobox"  style="width:200px;">
									</select>
							</td>
							<th class="wd-20"><label>产品经理人</label></th>
							<td>
									<select id="add_product_manager" name="add_product_manager" class="easyui-combobox"  style="width:200px;">
									</select>
							</td>
						  </tr>
						 <tr>
							<th class="wd-20"><label>风控负责人</label></th>
							<td>
									<select id="add_risk_controller" name="add_risk_controller" class="easyui-combobox"  style="width:200px;">
									</select>
							</td>
							<th class="wd-20"><label>法务负责人</label></th>
							<td>
									<select id="add_law_worker" name="add_law_worker" class="easyui-combobox"  style="width:200px;">
									</select>
							</td>
						  </tr>
						 <tr>
							<th class="wd-20"><label>运营负责人</label></th>
							<td>
									<select id="add_oprater" name="add_oprater" class="easyui-combobox"  style="width:200px;">
									</select>
							</td>
							<th class="wd-20"><label>开发负责人</label></th>
							<td>
									<select id="add_it_manager" name="add_it_manager" class="easyui-combobox"  style="width:200px;">
									</select>
							</td>
						  </tr>
						 <tr>
							<th class="wd-20"><label>BA</label></th>
							<td>
									<select id="add_business_analyzer" name="add_business_analyzer" class="easyui-combobox"  style="width:200px;">
									</select>
							</td>
							<th class="wd-20"><label>数据负责人</label></th>
							<td>
									<select id="add_data_manager" name="add_data_manager" class="easyui-combobox"  style="width:200px;">
									</select>
							</td>
						  </tr>
						 <tr>
							<th class="wd-20"><label>募集需求</label></th>
							<td>
									<input type="text" id="add_raise_demand" name="add_raise_demand" class="easyui-validatebox"   data-options="required:true,invalidMessage:'raise_demand不能为空',missingMessage:'raise_demand不能为空'"  style="width:200px;" />
							</td>
							<th class="wd-20"><label>商务条件</label></th>
							<td>
									<input type="text" id="add_business_condition" name="add_business_condition" class="easyui-validatebox"   data-options="required:true,invalidMessage:'business_condition不能为空',missingMessage:'business_condition不能为空'"  style="width:200px;" />
							</td>
						  </tr>
						 <tr>
							<th class="wd-20"><label>场景说明</label></th>
							<td>
									<input type="text" id="add_scene_doc" name="add_scene_doc" class="easyui-validatebox"   data-options="required:true,invalidMessage:'scene_doc不能为空',missingMessage:'scene_doc不能为空'"  style="width:200px;" />
							</td>
							<th class="wd-20"><label>实际费率</label></th>
							<td>
								<input type="text" id="add_actual_rate" name="add_actual_rate" class="easyui-validatebox"  data-options="required:true,validType:'number[2,16]',invalidMessage:'actual_rate必须为数字',missingMessage:'actual_rate必须为数字'" style="width:200px;"/>
							</td>
						  </tr>
						 <tr>
							<th class="wd-20"><label>授信额度</label></th>
							<td>
								<input type="text" id="add_line_of_credit" name="add_line_of_credit" class="easyui-validatebox"  data-options="required:true,validType:'number[2,16]',invalidMessage:'line_of_credit必须为数字',missingMessage:'line_of_credit必须为数字'" style="width:200px;"/>
							</td>
							<th class="wd-20"><label>最低承保余额</label></th>
							<td>
								<input type="text" id="add_underwrite_balance_mix" name="add_underwrite_balance_mix" class="easyui-validatebox"  data-options="required:true,validType:'number[2,16]',invalidMessage:'underwrite_balance_mix必须为数字',missingMessage:'underwrite_balance_mix必须为数字'" style="width:200px;"/>
							</td>
						  </tr>
						 <tr>
							<th class="wd-20"><label>产品经理属地</label></th>
							<td>
									<input type="text" id="add_product_manager_colony" name="add_product_manager_colony" class="easyui-validatebox"   data-options="required:true,invalidMessage:'product_manager_colony不能为空',missingMessage:'product_manager_colony不能为空'"  style="width:200px;" />
							</td>
							<th class="wd-20"><label>项目属地</label></th>
							<td>
									<input type="text" id="add_project_colony" name="add_project_colony" class="easyui-validatebox"   data-options="required:true,invalidMessage:'project_colony不能为空',missingMessage:'project_colony不能为空'"  style="width:200px;" />
							</td>
						  </tr>
						 <tr>
							<th class="wd-20"><label>资金闭环</label></th>
							<td>
									<select id="add_money_closed_loop" class="easyui-combobox" name="add_money_closed_loop" style="width:200px;">
											<option value="0">0-否</option>
											<option value="1">1-是</option>
									</select>
							</td>
							<th class="wd-20"><label>法律关系闭环</label></th>
							<td>
									<select id="add_legal_relation_closed_loop" class="easyui-combobox" name="add_legal_relation_closed_loop" style="width:200px;">
											<option value="0">0-否</option>
											<option value="1">1-是</option>
									</select>
							</td>
						  </tr>
						 <tr>
							<th class="wd-20"><label>数据闭环</label></th>
							<td>
									<select id="add_data_closed_loop" class="easyui-combobox" name="add_data_closed_loop" style="width:200px;">
											<option value="0">0-否</option>
											<option value="1">1-是</option>
									</select>
							</td>
							<th class="wd-20"><label>法务-多年期条款推进</label></th>
							<td>
									<input type="text" id="add_low_works_boost" name="add_low_works_boost" class="easyui-validatebox"   data-options="required:true,invalidMessage:'low_works_boost不能为空',missingMessage:'low_works_boost不能为空'"  style="width:200px;" />
							</td>
						  </tr>
						 <tr>
							<th class="wd-20"><label>放款还款-稳定性</label></th>
							<td>
									<input type="text" id="add_loan_repayment_stability" name="add_loan_repayment_stability" class="easyui-validatebox"   data-options="required:true,invalidMessage:'loan_repayment_stability不能为空',missingMessage:'loan_repayment_stability不能为空'"  style="width:200px;" />
							</td>
							<th class="wd-20"><label>放款还款-信托限额</label></th>
							<td>
									<input type="text" id="add_limitation_of_the_trust" name="add_limitation_of_the_trust" class="easyui-validatebox"   data-options="required:true,invalidMessage:'limitation_of_the_trust不能为空',missingMessage:'limitation_of_the_trust不能为空'"  style="width:200px;" />
							</td>
						  </tr>
						 <tr>
							<th class="wd-20"><label>放款还款-监管限额</label></th>
							<td>
									<input type="text" id="add_reg_limits" name="add_reg_limits" class="easyui-validatebox"   data-options="required:true,invalidMessage:'reg_limits不能为空',missingMessage:'reg_limits不能为空'"  style="width:200px;" />
							</td>
							<th class="wd-20"><label>放款还款-竞争环境下资金供给</label></th>
							<td>
									<input type="text" id="add_bankroll" name="add_bankroll" class="easyui-validatebox"   data-options="required:true,invalidMessage:'bankroll不能为空',missingMessage:'bankroll不能为空'"  style="width:200px;" />
							</td>
						  </tr>
						 <tr>
							<th class="wd-20"><label>放款还款-接入第三方支付</label></th>
							<td>
									<input type="text" id="add_third_pay" name="add_third_pay" class="easyui-validatebox"   data-options="required:true,invalidMessage:'third_pay不能为空',missingMessage:'third_pay不能为空'"  style="width:200px;" />
							</td>
							<th class="wd-20"><label>放款还款-大型第三方不开立金融账户</label></th>
							<td>
									<input type="text" id="add_account" name="add_account" class="easyui-validatebox"   data-options="required:true,invalidMessage:'account不能为空',missingMessage:'account不能为空'"  style="width:200px;" />
							</td>
						  </tr>
						 <tr>
							<th class="wd-20"><label>业务-租赁公司全国抵押备案</label></th>
							<td>
									<input type="text" id="add_mortgage_registration" name="add_mortgage_registration" class="easyui-validatebox"   data-options="required:true,invalidMessage:'mortgage_registration不能为空',missingMessage:'mortgage_registration不能为空'"  style="width:200px;" />
							</td>
							<th class="wd-20"><label>信审会额度限制</label></th>
							<td>
									<input type="text" id="add_credit_aduit_limit" name="add_credit_aduit_limit" class="easyui-validatebox"   data-options="required:true,invalidMessage:'credit_aduit_limit不能为空',missingMessage:'credit_aduit_limit不能为空'"  style="width:200px;" />
							</td>
						  </tr>
						 <tr>
							<th class="wd-20"><label>memo</label></th>
							<td>
									<input type="text" id="add_memo" name="add_memo" class="easyui-validatebox"   data-options="required:true,invalidMessage:'memo不能为空',missingMessage:'memo不能为空'"  style="width:200px;" />
							</td>
							<th class="wd-20"><label>业务-车抵贷管理能力</label></th>
							<td>
									<input type="text" id="add_management_ability" name="add_management_ability" class="easyui-validatebox"   data-options="required:true,invalidMessage:'management_ability不能为空',missingMessage:'management_ability不能为空'"  style="width:200px;" />
							</td>
						  </tr>
						 <tr>
							<th class="wd-20"><label>预计上线时间</label></th>
							<td>
									<input type="text" id="add_expected_online_time" name="add_expected_online_time" class="easyui-validatebox"   data-options="required:true,invalidMessage:'expected_online_time不能为空',missingMessage:'expected_online_time不能为空'"  style="width:200px;" />
							</td>
							<th class="wd-20"><label>项目状态</label></th>
							<td>
									<select id="add_status" class="easyui-combobox" name="add_status" style="width:200px;">
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
						$("#add_cust_id").combobox({	
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
						$("#add_product_id").combobox({	
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
						$("#add_project_manager").combobox({	
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
						$("#add_product_manager").combobox({	
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
						$("#add_risk_controller").combobox({	
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
						$("#add_law_worker").combobox({	
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
						$("#add_oprater").combobox({	
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
						$("#add_it_manager").combobox({	
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
						$("#add_business_analyzer").combobox({	
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
						$("#add_data_manager").combobox({	
					    			data:data.rows,
					    			valueField:'id', 
					    			textField:'text' ,
					    		});
				}
		});	
}); 
</script>
</body>
</html>