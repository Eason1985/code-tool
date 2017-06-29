<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/page/common/easyui_head.jsp"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>"> 
<title>模板内容页</title>
<link href="css/default.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="css/themes/icon.css">
<script type='text/javascript' src='<%=basePath%>js/common.js'></script>
</head>
<body>
<!--内容-->
<div id="div_tbSceneInfo_list" class="container">
	<div class="page-toolbar clearfix">
		<ul class="page-toolbar-list">
			<li><a href="javascript:;" id="add_btn"><i class="icon-add"></i>新增</a></li>
		</ul>
	</div>
	<article id="content" class="content">
		<div class="content-body">
			<!--搜索栏开始-->
			<div class="search-panel toggle-panel">
				<div class="panel-header" data-role="toggle-handle">
					<h2 class="panel-title">查询条件</h2>
				</div>
				<div class="search-panel-content">
					<form id="searchForm" name="searchForm" method="post" >
						<div class="search-panel-bd">
							<table class="search-table">
									 <tr>
										<th class="wd-20"><label>客户ID</label></th>
										<td>
												<select id="search_cust_id" name="search_cust_id" class="easyui-combobox"  style="width:200px;">
												</select>
										</td>
										<th class="wd-20"><label>产品ID</label></th>
										<td>
												<select id="search_product_id" name="search_product_id" class="easyui-combobox"  style="width:200px;">
												</select>
										</td>
									  </tr>
									 <tr>
										<th class="wd-20"><label>项目名称</label></th>
										<td>
												<input type="text" name="search_project_name"  data-options="required:true"  style="width:200px;"/>
										</td>
										<th class="wd-20"><label>子品牌</label></th>
										<td>
												<input type="text" name="search_sub_brand"  data-options="required:true"  style="width:200px;"/>
										</td>
									  </tr>
									 <tr>
										<th class="wd-20"><label>场景类型</label></th>
										<td>
												<select name="search_scene_type"  class="easyui-combobox"　 style="width:200px;">
													<option value="">未选择</option>
														<option value="0">0-商品分期</option>
														<option value="1">1-现金贷</option>
												</select>
										</td>
										<th class="wd-20"><label>融资方式</label></th>
										<td>
												<select name="search_way_of_financing"  class="easyui-combobox"　 style="width:200px;">
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
												<select name="search_demand_type"  class="easyui-combobox"　 style="width:200px;">
													<option value="">未选择</option>
														<option value="0">0-新增资产规模</option>
														<option value="1">1-新增资金需求</option>
												</select>
										</td>
										<th class="wd-20"><label>匹配资金类型</label></th>
										<td>
												<select name="search_matching_type"  class="easyui-combobox"　 style="width:200px;">
													<option value="">未选择</option>
														<option value="0">0-现金贷</option>
														<option value="1">1-保理</option>
												</select>
										</td>
									  </tr>
									 <tr>
										<th class="wd-20"><label>项目状态</label></th>
										<td>
												<select name="search_status"  class="easyui-combobox"　 style="width:200px;">
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
						<div class="search-btn-area">
							<input id="search_btn" type="button" value="查 询" />
							<input id="clear_btn" type="button" value="清 除" />
						</div>
					</form>
				</div>
			</div>
			<!--搜索栏结束-->
			
			<!--搜索结果开始-->
			<div class="result-content">
				<table  id="dg_tbSceneInfo" class="easyui-datagrid" title="DataGrid Title" style="width:auto;height:300px"
					data-options="rownumbers:false,singleSelect:true,collapsible:true,sortName:'',sortOrder:'desc',pagination:'true',url:'<%=path%>/search_tbSceneInfo_getListData.do',method:'post'">
					<thead>
						<tr>
						 	<th data-options="field:'detail',width:50,align:'center'">明细</th>
							<th data-options="field:'edit',width:50,align:'center'">编辑</th>
							<th data-options="field:'cust_id',width:120,sortable:'true',align:'right'">客户ID</th>
							<th data-options="field:'product_id',width:120,sortable:'true',align:'right'">产品ID</th>
							<th data-options="field:'project_name',width:120,sortable:'true',align:'right'">项目名称</th>
							<th data-options="field:'sub_brand',width:120,sortable:'true',align:'right'">子品牌</th>
							<th data-options="field:'scene_type',width:120,sortable:'true',align:'right'">场景类型</th>
							<th data-options="field:'way_of_financing',width:120,sortable:'true',align:'right'">融资方式</th>
							<th data-options="field:'demand_type',width:120,sortable:'true',align:'right'">需求类型</th>
							<th data-options="field:'matching_type',width:120,sortable:'true',align:'right'">匹配资金类型</th>
							<th data-options="field:'product_time',width:120,sortable:'true',align:'right'">立项时间</th>
							<th data-options="field:'area',width:120,sortable:'true',align:'right'">区域</th>
							<th data-options="field:'project_manager',width:120,sortable:'true',align:'right'">项目管理人</th>
							<th data-options="field:'product_manager',width:120,sortable:'true',align:'right'">产品经理人</th>
							<th data-options="field:'risk_controller',width:120,sortable:'true',align:'right'">风控负责人</th>
							<th data-options="field:'law_worker',width:120,sortable:'true',align:'right'">法务负责人</th>
							<th data-options="field:'oprater',width:120,sortable:'true',align:'right'">运营负责人</th>
							<th data-options="field:'it_manager',width:120,sortable:'true',align:'right'">开发负责人</th>
							<th data-options="field:'business_analyzer',width:120,sortable:'true',align:'right'">BA</th>
							<th data-options="field:'data_manager',width:120,sortable:'true',align:'right'">数据负责人</th>
							<th data-options="field:'raise_demand',width:120,sortable:'true',align:'right'">募集需求</th>
							<th data-options="field:'business_condition',width:120,sortable:'true',align:'right'">商务条件</th>
							<th data-options="field:'scene_doc',width:120,sortable:'true',align:'right'">场景说明</th>
							<th data-options="field:'actual_rate',width:120,sortable:'true',align:'right'">实际费率</th>
							<th data-options="field:'line_of_credit',width:120,sortable:'true',align:'right'">授信额度</th>
							<th data-options="field:'underwrite_balance_mix',width:120,sortable:'true',align:'right'">最低承保余额</th>
							<th data-options="field:'product_manager_colony',width:120,sortable:'true',align:'right'">产品经理属地</th>
							<th data-options="field:'project_colony',width:120,sortable:'true',align:'right'">项目属地</th>
							<th data-options="field:'money_closed_loop',width:120,sortable:'true',align:'right'">资金闭环</th>
							<th data-options="field:'legal_relation_closed_loop',width:120,sortable:'true',align:'right'">法律关系闭环</th>
							<th data-options="field:'data_closed_loop',width:120,sortable:'true',align:'right'">数据闭环</th>
							<th data-options="field:'low_works_boost',width:120,sortable:'true',align:'right'">法务-多年期条款推进</th>
							<th data-options="field:'loan_repayment_stability',width:120,sortable:'true',align:'right'">放款还款-稳定性</th>
							<th data-options="field:'limitation_of_the_trust',width:120,sortable:'true',align:'right'">放款还款-信托限额</th>
							<th data-options="field:'reg_limits',width:120,sortable:'true',align:'right'">放款还款-监管限额</th>
							<th data-options="field:'bankroll',width:120,sortable:'true',align:'right'">放款还款-竞争环境下资金供给</th>
							<th data-options="field:'third_pay',width:120,sortable:'true',align:'right'">放款还款-接入第三方支付</th>
							<th data-options="field:'account',width:120,sortable:'true',align:'right'">放款还款-大型第三方不开立金融账户</th>
							<th data-options="field:'mortgage_registration',width:120,sortable:'true',align:'right'">业务-租赁公司全国抵押备案</th>
							<th data-options="field:'credit_aduit_limit',width:120,sortable:'true',align:'right'">信审会额度限制</th>
							<th data-options="field:'memo',width:120,sortable:'true',align:'right'">memo</th>
							<th data-options="field:'management_ability',width:120,sortable:'true',align:'right'">业务-车抵贷管理能力</th>
							<th data-options="field:'expected_online_time',width:120,sortable:'true',align:'right'">预计上线时间</th>
							<th data-options="field:'status',width:120,sortable:'true',align:'right'">项目状态</th>
							<th data-options="field:'gmt_created',width:120,sortable:'true',align:'right'">创建时间</th>
							<th data-options="field:'gmt_modified',width:120,sortable:'true',align:'right'">修改时间</th>
							<th data-options="field:'creator',width:120,sortable:'true',align:'right'">创建人</th>
							<th data-options="field:'modifier',width:120,sortable:'true',align:'right'">修改人</th>
<!-- 							<th data-options="field:'is_deleted',width:120,sortable:'true',align:'right'">是否删除</th> -->
						</tr>
					</thead>
				</table>
			</div>
			<!--搜索栏结果end-->
		</div>
	</article>
</div>

<script>
var tbSceneInfo_list ={};
jQuery(function($){
	var path = '<%=path%>';
	
    //定义一览页面查询的参数(JSON格式)
    tbSceneInfo_list.buildJsonQueryParams = function(){
		  	var searchContent =	{
		  		//标准查询部分
			 	pageNumber:$('div#div_tbSceneInfo_list #dg_tbSceneInfo').datagrid('options').pageNumber,
		  		//页面查询框部分
					id :$("input[name='search_id']").val(), 
					cust_id :$("input[name='search_cust_id']").val(), 
					product_id :$("input[name='search_product_id']").val(), 
					project_name :$("input[name='search_project_name']").val(), 
					sub_brand :$("input[name='search_sub_brand']").val(), 
					scene_type :$("input[name='search_scene_type']").val(), 
					way_of_financing :$("input[name='search_way_of_financing']").val(), 
					demand_type :$("input[name='search_demand_type']").val(), 
					matching_type :$("input[name='search_matching_type']").val(), 
					product_time :$("input[name='search_product_time']").val(), 
					area :$("input[name='search_area']").val(), 
					project_manager :$("input[name='search_project_manager']").val(), 
					product_manager :$("input[name='search_product_manager']").val(), 
					risk_controller :$("input[name='search_risk_controller']").val(), 
					law_worker :$("input[name='search_law_worker']").val(), 
					oprater :$("input[name='search_oprater']").val(), 
					it_manager :$("input[name='search_it_manager']").val(), 
					business_analyzer :$("input[name='search_business_analyzer']").val(), 
					data_manager :$("input[name='search_data_manager']").val(), 
					raise_demand :$("input[name='search_raise_demand']").val(), 
					business_condition :$("input[name='search_business_condition']").val(), 
					scene_doc :$("input[name='search_scene_doc']").val(), 
					actual_rate :$("input[name='search_actual_rate']").val(), 
					line_of_credit :$("input[name='search_line_of_credit']").val(), 
					underwrite_balance_mix :$("input[name='search_underwrite_balance_mix']").val(), 
					product_manager_colony :$("input[name='search_product_manager_colony']").val(), 
					project_colony :$("input[name='search_project_colony']").val(), 
					money_closed_loop :$("input[name='search_money_closed_loop']").val(), 
					legal_relation_closed_loop :$("input[name='search_legal_relation_closed_loop']").val(), 
					data_closed_loop :$("input[name='search_data_closed_loop']").val(), 
					low_works_boost :$("input[name='search_low_works_boost']").val(), 
					loan_repayment_stability :$("input[name='search_loan_repayment_stability']").val(), 
					limitation_of_the_trust :$("input[name='search_limitation_of_the_trust']").val(), 
					reg_limits :$("input[name='search_reg_limits']").val(), 
					bankroll :$("input[name='search_bankroll']").val(), 
					third_pay :$("input[name='search_third_pay']").val(), 
					account :$("input[name='search_account']").val(), 
					mortgage_registration :$("input[name='search_mortgage_registration']").val(), 
					credit_aduit_limit :$("input[name='search_credit_aduit_limit']").val(), 
					memo :$("input[name='search_memo']").val(), 
					management_ability :$("input[name='search_management_ability']").val(), 
					expected_online_time :$("input[name='search_expected_online_time']").val(), 
					status :$("input[name='search_status']").val(), 
					gmt_created :$("input[name='search_gmt_created']").val(), 
					gmt_modified :$("input[name='search_gmt_modified']").val(), 
					creator :$("input[name='search_creator']").val(), 
					modifier :$("input[name='search_modifier']").val(), 
					is_deleted :$("input[name='search_is_deleted']").val(), 
		    };
			var searchContentStr  =JSON.stringify(searchContent);
			//传到到后台的URL 必须先编码化
			return encodeURI(searchContentStr);
	 };
	 
	//定义新增信息的参数(JSON格式)
    tbSceneInfo_list.buildJsonAddParams = function(){
		  	var addContent =	{
		  		//页面输入框部分
					id :$("input[name='add_id']").val(), 
					cust_id :$("input[name='add_cust_id']").val(), 
					product_id :$("input[name='add_product_id']").val(), 
					project_name :$("input[name='add_project_name']").val(), 
					sub_brand :$("input[name='add_sub_brand']").val(), 
					scene_type :$("input[name='add_scene_type']").val(), 
					way_of_financing :$("input[name='add_way_of_financing']").val(), 
					demand_type :$("input[name='add_demand_type']").val(), 
					matching_type :$("input[name='add_matching_type']").val(), 
					product_time :$("input[name='add_product_time']").val(), 
					area :$("input[name='add_area']").val(), 
					project_manager :$("input[name='add_project_manager']").val(), 
					product_manager :$("input[name='add_product_manager']").val(), 
					risk_controller :$("input[name='add_risk_controller']").val(), 
					law_worker :$("input[name='add_law_worker']").val(), 
					oprater :$("input[name='add_oprater']").val(), 
					it_manager :$("input[name='add_it_manager']").val(), 
					business_analyzer :$("input[name='add_business_analyzer']").val(), 
					data_manager :$("input[name='add_data_manager']").val(), 
					raise_demand :$("input[name='add_raise_demand']").val(), 
					business_condition :$("input[name='add_business_condition']").val(), 
					scene_doc :$("input[name='add_scene_doc']").val(), 
					actual_rate :$("input[name='add_actual_rate']").val(), 
					line_of_credit :$("input[name='add_line_of_credit']").val(), 
					underwrite_balance_mix :$("input[name='add_underwrite_balance_mix']").val(), 
					product_manager_colony :$("input[name='add_product_manager_colony']").val(), 
					project_colony :$("input[name='add_project_colony']").val(), 
					money_closed_loop :$("input[name='add_money_closed_loop']").val(), 
					legal_relation_closed_loop :$("input[name='add_legal_relation_closed_loop']").val(), 
					data_closed_loop :$("input[name='add_data_closed_loop']").val(), 
					low_works_boost :$("input[name='add_low_works_boost']").val(), 
					loan_repayment_stability :$("input[name='add_loan_repayment_stability']").val(), 
					limitation_of_the_trust :$("input[name='add_limitation_of_the_trust']").val(), 
					reg_limits :$("input[name='add_reg_limits']").val(), 
					bankroll :$("input[name='add_bankroll']").val(), 
					third_pay :$("input[name='add_third_pay']").val(), 
					account :$("input[name='add_account']").val(), 
					mortgage_registration :$("input[name='add_mortgage_registration']").val(), 
					credit_aduit_limit :$("input[name='add_credit_aduit_limit']").val(), 
					memo :$("input[name='add_memo']").val(), 
					management_ability :$("input[name='add_management_ability']").val(), 
					expected_online_time :$("input[name='add_expected_online_time']").val(), 
					status :$("input[name='add_status']").val(), 
					gmt_created :$("input[name='add_gmt_created']").val(), 
					gmt_modified :$("input[name='add_gmt_modified']").val(), 
					creator :$("input[name='add_creator']").val(), 
					modifier :$("input[name='add_modifier']").val(), 
					is_deleted :$("input[name='add_is_deleted']").val(), 
		    };
			var addContentStr  =JSON.stringify(addContent);
			//传到到后台的URL 必须先编码化
			return encodeURI(addContentStr);
	 };
	
	//重新按照条件刷新查询一览内容
	$('div#div_tbSceneInfo_list #search_btn').click(function(){
		var searchContentStr = tbSceneInfo_list.buildJsonQueryParams();		
		var url = path+"/search_tbSceneInfo_getListData.do?searchContentStr="+searchContentStr; 
		//重新赋值url 属性
        $("#dg_tbSceneInfo").datagrid("options").url=url;
        $("#dg_tbSceneInfo").datagrid("reload"); 
	});
	
	//重置查询条件并刷新内容
	$('div#div_tbSceneInfo_list #clear_btn').click(function(){
		//清空查询条件
			$("input[name='search_id']").val("");
			$("input[name='search_cust_id']").val("");
			$("input[name='search_product_id']").val("");
			$("input[name='search_project_name']").val("");
			$("input[name='search_sub_brand']").val("");
			$("input[name='search_scene_type']").val("");
			$("input[name='search_way_of_financing']").val("");
			$("input[name='search_demand_type']").val("");
			$("input[name='search_matching_type']").val("");
			$("input[name='search_product_time']").val("");
			$("input[name='search_area']").val("");
			$("input[name='search_project_manager']").val("");
			$("input[name='search_product_manager']").val("");
			$("input[name='search_risk_controller']").val("");
			$("input[name='search_law_worker']").val("");
			$("input[name='search_oprater']").val("");
			$("input[name='search_it_manager']").val("");
			$("input[name='search_business_analyzer']").val("");
			$("input[name='search_data_manager']").val("");
			$("input[name='search_raise_demand']").val("");
			$("input[name='search_business_condition']").val("");
			$("input[name='search_scene_doc']").val("");
			$("input[name='search_actual_rate']").val("");
			$("input[name='search_line_of_credit']").val("");
			$("input[name='search_underwrite_balance_mix']").val("");
			$("input[name='search_product_manager_colony']").val("");
			$("input[name='search_project_colony']").val("");
			$("input[name='search_money_closed_loop']").val("");
			$("input[name='search_legal_relation_closed_loop']").val("");
			$("input[name='search_data_closed_loop']").val("");
			$("input[name='search_low_works_boost']").val("");
			$("input[name='search_loan_repayment_stability']").val("");
			$("input[name='search_limitation_of_the_trust']").val("");
			$("input[name='search_reg_limits']").val("");
			$("input[name='search_bankroll']").val("");
			$("input[name='search_third_pay']").val("");
			$("input[name='search_account']").val("");
			$("input[name='search_mortgage_registration']").val("");
			$("input[name='search_credit_aduit_limit']").val("");
			$("input[name='search_memo']").val("");
			$("input[name='search_management_ability']").val("");
			$("input[name='search_expected_online_time']").val("");
			$("input[name='search_status']").val("");
			$("input[name='search_gmt_created']").val("");
			$("input[name='search_gmt_modified']").val("");
			$("input[name='search_creator']").val("");
			$("input[name='search_modifier']").val("");
			$("input[name='search_is_deleted']").val("");
		var form = $(searchForm);
	    form.find("select.easyui-combobox").combobox("setValue","");
	    form.find("input.easyui-datebox").datebox("clear");
	    form.find(":input[name]").not(":hidden").val("");
		var searchContentStr = tbSceneInfo_list.buildQueryParams();
		var url = path+"/search_tbSceneInfo_getListData.do?searchContentStr="+searchContentStr; 
	    $("#dg_tbSceneInfo").datagrid("options").url=url;
	    $("#dg_tbSceneInfo").datagrid("reload"); 
	});
	
	/*
	 * 点击新增按钮打开新增信息弹框
	 */
	$('div#div_tbSceneInfo_list #add_btn').click(function(){
		var add_form_id ='#addTbSceneInfoFrom';
		$('<div id="dialog_holder"></div>').dialog({
		    title: '新增tb_scene_info',
		    width: 800,
		    height: 500,
		    href: path+'/page/tbSceneInfo/addTbSceneInfoPage.jsp',
		    modal: true,
		    method: "POST",
			onClose: function(){
				$(this).dialog("destroy");
			},
		    buttons: [{
		    	text: "保存",
		    	handler: function(){
		    		if($(add_form_id).form("validate")==true){
						$.messager.progress(); 
						$.ajax({
							 type:'POST',
							 cache:false,
					 		 async: false,
						     url:'<%=path%>'+"/add_TbSceneInfo.do?addContentStr="+tbSceneInfo_list.buildJsonAddParams(),
							 success:function(data){
							        $.messager.progress('close');
									data = $.parseJSON(data);
									if(data.error){
									    $.messager.alert("操作提示",data.message);
									    return;
									}else{
									    $.messager.alert("操作提示",data.message);
										$('#dialog_holder').dialog('close');
								        $("#dg_tbSceneInfo").datagrid("reload"); 
									} 
							}
						});
					};   
		    	},id:'add_save'
		    },{text: "退出",
		    	handler: function(e){
		    		$("#dialog_holder").dialog("destroy");
			 		$("#dialog_holder").dialog('close');
		    	},id:'add_cancel'}
		    ]
		});
	});
	
	
	//定义修改信息的参数(JSON格式)
    tbSceneInfo_list.buildJsonEditParams = function(){
		  	var editContent =	{
		  		//页面输入框部分
					id :$("input[name='edit_id']").val(), 
					cust_id :$("input[name='edit_cust_id']").val(), 
					product_id :$("input[name='edit_product_id']").val(), 
					project_name :$("input[name='edit_project_name']").val(), 
					sub_brand :$("input[name='edit_sub_brand']").val(), 
					scene_type :$("input[name='edit_scene_type']").val(), 
					way_of_financing :$("input[name='edit_way_of_financing']").val(), 
					demand_type :$("input[name='edit_demand_type']").val(), 
					matching_type :$("input[name='edit_matching_type']").val(), 
					product_time :$("input[name='edit_product_time']").val(), 
					area :$("input[name='edit_area']").val(), 
					project_manager :$("input[name='edit_project_manager']").val(), 
					product_manager :$("input[name='edit_product_manager']").val(), 
					risk_controller :$("input[name='edit_risk_controller']").val(), 
					law_worker :$("input[name='edit_law_worker']").val(), 
					oprater :$("input[name='edit_oprater']").val(), 
					it_manager :$("input[name='edit_it_manager']").val(), 
					business_analyzer :$("input[name='edit_business_analyzer']").val(), 
					data_manager :$("input[name='edit_data_manager']").val(), 
					raise_demand :$("input[name='edit_raise_demand']").val(), 
					business_condition :$("input[name='edit_business_condition']").val(), 
					scene_doc :$("input[name='edit_scene_doc']").val(), 
					actual_rate :$("input[name='edit_actual_rate']").val(), 
					line_of_credit :$("input[name='edit_line_of_credit']").val(), 
					underwrite_balance_mix :$("input[name='edit_underwrite_balance_mix']").val(), 
					product_manager_colony :$("input[name='edit_product_manager_colony']").val(), 
					project_colony :$("input[name='edit_project_colony']").val(), 
					money_closed_loop :$("input[name='edit_money_closed_loop']").val(), 
					legal_relation_closed_loop :$("input[name='edit_legal_relation_closed_loop']").val(), 
					data_closed_loop :$("input[name='edit_data_closed_loop']").val(), 
					low_works_boost :$("input[name='edit_low_works_boost']").val(), 
					loan_repayment_stability :$("input[name='edit_loan_repayment_stability']").val(), 
					limitation_of_the_trust :$("input[name='edit_limitation_of_the_trust']").val(), 
					reg_limits :$("input[name='edit_reg_limits']").val(), 
					bankroll :$("input[name='edit_bankroll']").val(), 
					third_pay :$("input[name='edit_third_pay']").val(), 
					account :$("input[name='edit_account']").val(), 
					mortgage_registration :$("input[name='edit_mortgage_registration']").val(), 
					credit_aduit_limit :$("input[name='edit_credit_aduit_limit']").val(), 
					memo :$("input[name='edit_memo']").val(), 
					management_ability :$("input[name='edit_management_ability']").val(), 
					expected_online_time :$("input[name='edit_expected_online_time']").val(), 
					status :$("input[name='edit_status']").val(), 
					gmt_created :$("input[name='edit_gmt_created']").val(), 
					gmt_modified :$("input[name='edit_gmt_modified']").val(), 
					creator :$("input[name='edit_creator']").val(), 
					modifier :$("input[name='edit_modifier']").val(), 
					is_deleted :$("input[name='edit_is_deleted']").val(), 
		    };
			var editContentStr  =JSON.stringify(editContent);
			//传到到后台的URL 必须先编码化
			return encodeURI(editContentStr);
	 };
	 
	/*
	 * 点击编辑按钮弹出编辑信息框
	 pkid:主键
	 */
	tbSceneInfo_list.updateFormSubmit = function(pkid){
	    var edit_form_id ='#editTbSceneInfoFrom';
		$('<div id="dialog_holder"></div>').dialog({
		    title: 'TbSceneInfo',
		    width: 800,
		    height: 500,
		    href: path+"/page/tbSceneInfo/editTbSceneInfoPage.jsp?pkid="+pkid,
		    modal: true,
		    method: "POST",
		    async: false,
			onClose: function(){
				$(this).dialog("destroy");
			},
		    buttons: [{
		    	text: "保 存",
		    	handler: function(e){
				    //验证不能为空的信息是否都填充
				    if($(edit_form_id).form("validate")==true){
					  	$.messager.progress(); 
			      		$.ajax({
							type:'POST',
							cache:false,
					 		async: false,
						    url:'<%=path%>'+"/edit_TbSceneInfo.do?editContentStr="+tbSceneInfo_list.buildJsonEditParams(),
							success:function(data){
							        $.messager.progress('close');
									data = $.parseJSON(data);
									if(data.error){
									    $.messager.alert("操作提示",data.message);
									    return;
									}else{
									    $.messager.alert("操作提示",data.message);
										$('#dialog_holder').dialog('close');
								        $("#dg_tbSceneInfo").datagrid("reload"); 
									} 
							}
						}); 
					};   
		    	},id:'edit_save'
		    },{text:'退出',
				    handler:function(e){
				      $("#dialog_holder").dialog("destroy");
					  $("#dialog_holder").dialog('close');
					},id:'add_cancel'
			},{ text: "删  除",
				    handler: function(e){
				    	var del = confirm("确定删除吗?");
				    	if(!del){
					       return false;
					    }
		     			$.ajax({
						 		type:'POST',
						 		url:path+"/del_TbSceneInfo.do?pkid="+pkid,    
						 		success:function(data){
						 		 	data = $.parseJSON(data);
						 		 	if(data.error){
									    $.messager.alert("操作提示",data.message);
									    return;
						 		 	}else{
									    $.messager.alert("操作提示",data.message);
							 			$("#dialog_holder").dialog("destroy");
							 		    $("#dialog_holder").dialog("close");
							 		    $("#dg_tbSceneInfo").datagrid("reload"); 
						 		 	}		 		 		
						 		}
						 	});
						   } ,
						   id:'del_cancel'}
						   ]
						});
	} ;
	
	//详细
	tbSceneInfo_list.detailFormSubmit = function(pkid){
		$('<div id="dialog_holder"></div>').dialog({
		    title: '详细TbSceneInfo',
		    width: 800,
		    height: 500,
		    href: path+"/page/tbSceneInfo/detailTbSceneInfoPage.jsp?pkid="+pkid, 
		    modal: true,
		    method: "POST",
			onClose: function(){
				$(this).dialog("destroy");
			},
		    success:function(data){
				if(data.error){
				    $.messager.alert("操作提示",data.message);
				    return;
				}else{
				    $.messager.alert("操作提示",data.message);
					$('#dialog_holder').dialog('close');
			        $("#dg_tbSceneInfo").datagrid("reload"); 
				}
		     },buttons: [{
		    	text: "关闭",
		    	handler: function(){
		    		$("#dialog_holder").dialog('close');
		    	}
		    }]
		});
	};
	
	
	
			$.ajax({
			 type:'POST',
			 cache:false,
			 async: false,
		     url:'<%=path%>'+"/obtainTbCustInfo.do",
			 success:function(data){
						data = $.parseJSON(data);
					    $("#search_cust_id").combobox({	
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
					    $("#search_product_id").combobox({	
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
					    $("#search_project_manager").combobox({	
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
					    $("#search_product_manager").combobox({	
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
					    $("#search_risk_controller").combobox({	
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
					    $("#search_law_worker").combobox({	
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
					    $("#search_oprater").combobox({	
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
					    $("#search_it_manager").combobox({	
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
					    $("#search_business_analyzer").combobox({	
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
					    $("#search_data_manager").combobox({	
					    			data:data.rows,
					    			valueField:'id', 
					    			textField:'text' ,
					    		});
				}
		});	
	
});

</script>
<%@ include file="/page/common/footer.jsp"%>
</body>
</html>