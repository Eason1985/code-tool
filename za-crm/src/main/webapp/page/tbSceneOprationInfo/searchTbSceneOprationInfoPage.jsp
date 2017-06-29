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
<div id="div_tbSceneOprationInfo_list" class="container">
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
										<th class="wd-20"><label>场景</label></th>
										<td>
												<select id="search_scene_id" name="search_scene_id" class="easyui-combobox"  style="width:200px;">
												</select>
										</td>
										<th class="wd-20"><label>开始日期</label></th>
										<td>
												<input type="text" name="search_begain_date"    data-options="required:true,invalidMessage:'格式为:YYYYMMDD',missingMessage:'格式为:YYYYMMDD'"  style="width:200px;" />
										</td>
										<th class="wd-20"><label>结束日期</label></th>
										<td>
												<input type="text" name="search_end_date"    data-options="required:true,invalidMessage:'格式为:YYYYMMDD',missingMessage:'格式为:YYYYMMDD'"  style="width:200px;" />
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
				<table  id="dg_tbSceneOprationInfo" class="easyui-datagrid" title="DataGrid Title" style="width:auto;height:300px"
					data-options="rownumbers:false,singleSelect:true,collapsible:true,sortName:'',sortOrder:'desc',pagination:'true',url:'<%=path%>/search_tbSceneOprationInfo_getListData.do',method:'post'">
					<thead>
						<tr>
						 	<th data-options="field:'detail',width:50,align:'center'">明细</th>
							<th data-options="field:'edit',width:50,align:'center'">编辑</th>
							<th data-options="field:'id',width:120,sortable:'true',align:'right'"></th>
							<th data-options="field:'scene_id',width:120,sortable:'true',align:'right'">场景</th>
							<th data-options="field:'begain_date',width:120,sortable:'true',align:'right'">开始日期</th>
							<th data-options="field:'end_date',width:120,sortable:'true',align:'right'">结束日期</th>
							<th data-options="field:'time_intervar_simle_name',width:120,sortable:'true',align:'right'">时间区间简称(如:1月,1季度等)</th>
							<th data-options="field:'plan_asset_size',width:120,sortable:'true',align:'right'">预计资产规模</th>
							<th data-options="field:'reality_asset_size',width:120,sortable:'true',align:'right'">实际资产规模</th>
							<th data-options="field:'plan_premium',width:120,sortable:'true',align:'right'">预计保费</th>
							<th data-options="field:'reality_premium',width:120,sortable:'true',align:'right'">实际保费</th>
							<th data-options="field:'occur_cust_num',width:120,sortable:'true',align:'right'">用户数(对应预计业务规模发生额)</th>
							<th data-options="field:'balance_cust_num',width:120,sortable:'true',align:'right'">用户数(对应预计业务规模余额)</th>
<!-- 							<th data-options="field:'gmt_created',width:120,sortable:'true',align:'right'">创建时间</th> -->
<!-- 							<th data-options="field:'gmt_modified',width:120,sortable:'true',align:'right'">修改时间</th> -->
<!-- 							<th data-options="field:'creator',width:120,sortable:'true',align:'right'">创建人</th> -->
<!-- 							<th data-options="field:'modifier',width:120,sortable:'true',align:'right'">修改人</th> -->
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
var tbSceneOprationInfo_list ={};
jQuery(function($){
	var path = '<%=path%>';
	
    //定义一览页面查询的参数(JSON格式)
    tbSceneOprationInfo_list.buildJsonQueryParams = function(){
		  	var searchContent =	{
		  		//标准查询部分
			 	pageNumber:$('div#div_tbSceneOprationInfo_list #dg_tbSceneOprationInfo').datagrid('options').pageNumber,
		  		//页面查询框部分
					id :$("input[name='search_id']").val(), 
					scene_id :$("input[name='search_scene_id']").val(), 
					begain_date :$("input[name='search_begain_date']").val(), 
					end_date :$("input[name='search_end_date']").val(), 
					time_intervar_simle_name :$("input[name='search_time_intervar_simle_name']").val(), 
					plan_asset_size :$("input[name='search_plan_asset_size']").val(), 
					reality_asset_size :$("input[name='search_reality_asset_size']").val(), 
					plan_premium :$("input[name='search_plan_premium']").val(), 
					reality_premium :$("input[name='search_reality_premium']").val(), 
					occur_cust_num :$("input[name='search_occur_cust_num']").val(), 
					balance_cust_num :$("input[name='search_balance_cust_num']").val(), 
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
    tbSceneOprationInfo_list.buildJsonAddParams = function(){
		  	var addContent =	{
		  		//页面输入框部分
					id :$("input[name='add_id']").val(), 
					scene_id :$("input[name='add_scene_id']").val(), 
					begain_date :$("input[name='add_begain_date']").val(), 
					end_date :$("input[name='add_end_date']").val(), 
					time_intervar_simle_name :$("input[name='add_time_intervar_simle_name']").val(), 
					plan_asset_size :$("input[name='add_plan_asset_size']").val(), 
					reality_asset_size :$("input[name='add_reality_asset_size']").val(), 
					plan_premium :$("input[name='add_plan_premium']").val(), 
					reality_premium :$("input[name='add_reality_premium']").val(), 
					occur_cust_num :$("input[name='add_occur_cust_num']").val(), 
					balance_cust_num :$("input[name='add_balance_cust_num']").val(), 
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
	$('div#div_tbSceneOprationInfo_list #search_btn').click(function(){
		var searchContentStr = tbSceneOprationInfo_list.buildJsonQueryParams();		
		var url = path+"/search_tbSceneOprationInfo_getListData.do?searchContentStr="+searchContentStr; 
		//重新赋值url 属性
        $("#dg_tbSceneOprationInfo").datagrid("options").url=url;
        $("#dg_tbSceneOprationInfo").datagrid("reload"); 
	});
	
	//重置查询条件并刷新内容
	$('div#div_tbSceneOprationInfo_list #clear_btn').click(function(){
		//清空查询条件
			$("input[name='search_id']").val("");
			$("input[name='search_scene_id']").val("");
			$("input[name='search_begain_date']").val("");
			$("input[name='search_end_date']").val("");
			$("input[name='search_time_intervar_simle_name']").val("");
			$("input[name='search_plan_asset_size']").val("");
			$("input[name='search_reality_asset_size']").val("");
			$("input[name='search_plan_premium']").val("");
			$("input[name='search_reality_premium']").val("");
			$("input[name='search_occur_cust_num']").val("");
			$("input[name='search_balance_cust_num']").val("");
			$("input[name='search_gmt_created']").val("");
			$("input[name='search_gmt_modified']").val("");
			$("input[name='search_creator']").val("");
			$("input[name='search_modifier']").val("");
			$("input[name='search_is_deleted']").val("");
		var form = $(searchForm);
	    form.find("select.easyui-combobox").combobox("setValue","");
	    form.find("input.easyui-datebox").datebox("clear");
	    form.find(":input[name]").not(":hidden").val("");
		var searchContentStr = tbSceneOprationInfo_list.buildQueryParams();
		var url = path+"/search_tbSceneOprationInfo_getListData.do?searchContentStr="+searchContentStr; 
	    $("#dg_tbSceneOprationInfo").datagrid("options").url=url;
	    $("#dg_tbSceneOprationInfo").datagrid("reload"); 
	});
	
	/*
	 * 点击新增按钮打开新增信息弹框
	 */
	$('div#div_tbSceneOprationInfo_list #add_btn').click(function(){
		var add_form_id ='#addTbSceneOprationInfoFrom';
		$('<div id="dialog_holder"></div>').dialog({
		    title: '新增tb_scene_opration_info',
		    width: 800,
		    height: 500,
		    href: path+'/page/tbSceneOprationInfo/addTbSceneOprationInfoPage.jsp',
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
						     url:'<%=path%>'+"/add_TbSceneOprationInfo.do?addContentStr="+tbSceneOprationInfo_list.buildJsonAddParams(),
							 success:function(data){
							        $.messager.progress('close');
									data = $.parseJSON(data);
									if(data.error){
									    $.messager.alert("操作提示",data.message);
									    return;
									}else{
									    $.messager.alert("操作提示",data.message);
										$('#dialog_holder').dialog('close');
								        $("#dg_tbSceneOprationInfo").datagrid("reload"); 
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
    tbSceneOprationInfo_list.buildJsonEditParams = function(){
		  	var editContent =	{
		  		//页面输入框部分
					id :$("input[name='edit_id']").val(), 
					scene_id :$("input[name='edit_scene_id']").val(), 
					begain_date :$("input[name='edit_begain_date']").val(), 
					end_date :$("input[name='edit_end_date']").val(), 
					time_intervar_simle_name :$("input[name='edit_time_intervar_simle_name']").val(), 
					plan_asset_size :$("input[name='edit_plan_asset_size']").val(), 
					reality_asset_size :$("input[name='edit_reality_asset_size']").val(), 
					plan_premium :$("input[name='edit_plan_premium']").val(), 
					reality_premium :$("input[name='edit_reality_premium']").val(), 
					occur_cust_num :$("input[name='edit_occur_cust_num']").val(), 
					balance_cust_num :$("input[name='edit_balance_cust_num']").val(), 
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
	tbSceneOprationInfo_list.updateFormSubmit = function(pkid){
	    var edit_form_id ='#editTbSceneOprationInfoFrom';
		$('<div id="dialog_holder"></div>').dialog({
		    title: 'TbSceneOprationInfo',
		    width: 800,
		    height: 500,
		    href: path+"/page/tbSceneOprationInfo/editTbSceneOprationInfoPage.jsp?pkid="+pkid,
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
						    url:'<%=path%>'+"/edit_TbSceneOprationInfo.do?editContentStr="+tbSceneOprationInfo_list.buildJsonEditParams(),
							success:function(data){
							        $.messager.progress('close');
									data = $.parseJSON(data);
									if(data.error){
									    $.messager.alert("操作提示",data.message);
									    return;
									}else{
									    $.messager.alert("操作提示",data.message);
										$('#dialog_holder').dialog('close');
								        $("#dg_tbSceneOprationInfo").datagrid("reload"); 
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
						 		url:path+"/del_TbSceneOprationInfo.do?pkid="+pkid,    
						 		success:function(data){
						 		 	data = $.parseJSON(data);
						 		 	if(data.error){
									    $.messager.alert("操作提示",data.message);
									    return;
						 		 	}else{
									    $.messager.alert("操作提示",data.message);
							 			$("#dialog_holder").dialog("destroy");
							 		    $("#dialog_holder").dialog("close");
							 		    $("#dg_tbSceneOprationInfo").datagrid("reload"); 
						 		 	}		 		 		
						 		}
						 	});
						   } ,
						   id:'del_cancel'}
						   ]
						});
	} ;
	
	//详细
	tbSceneOprationInfo_list.detailFormSubmit = function(pkid){
		$('<div id="dialog_holder"></div>').dialog({
		    title: '详细TbSceneOprationInfo',
		    width: 800,
		    height: 500,
		    href: path+"/page/tbSceneOprationInfo/detailTbSceneOprationInfoPage.jsp?pkid="+pkid, 
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
			        $("#dg_tbSceneOprationInfo").datagrid("reload"); 
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
		     url:'<%=path%>'+"/obtainTbSceneInfo.do",
			 success:function(data){
						data = $.parseJSON(data);
					    $("#search_scene_id").combobox({	
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