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
<div id="div_tbProductInfo_list" class="container">
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
										<th class="wd-20"><label>产品名称</label></th>
										<td>
												<input type="text" name="search_product_name"  data-options="required:true"  style="width:200px;"/>
										</td>
										<th class="wd-20"><label>立项时间</label></th>
										<td>
											<input type="text"  name="search_project_time"   style="width:200px;" class="easyui-datebox" />
										</td>
									 </tr>
									 <tr>
										<th class="wd-20"><label>业务类型</label></th>
										<td>
												<select name="search_bis_type"  class="easyui-combobox"　 style="width:200px;">
													<option value="">未选择</option>
														<option value="0">0-对公业务</option>
														<option value="1">1-交通金融</option>
														<option value="2">2-投资产品业务</option>
														<option value="3">3-消费金融</option>
												</select>
										</td>
										<th class="wd-20"><label>项目管理人</label></th>
										<td>
												<input type="text" name="search_project_manager"  data-options="required:true"  style="width:200px;"/>
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
				<table  id="dg_tbProductInfo" class="easyui-datagrid" title="DataGrid Title" style="width:auto;height:300px"
					data-options="rownumbers:false,singleSelect:true,collapsible:true,sortName:'',sortOrder:'desc',pagination:'true',url:'<%=path%>/search_tbProductInfo_getListData.do',method:'post'">
					<thead>
						<tr>
						 	<th data-options="field:'detail',width:50,align:'center'">明细</th>
							<th data-options="field:'edit',width:50,align:'center'">编辑</th>
							<th data-options="field:'id',width:120,sortable:'true',align:'right'">id</th>
							<th data-options="field:'product_name',width:120,sortable:'true',align:'right'">产品名称</th>
							<th data-options="field:'scene_explain',width:120,sortable:'true',align:'right'">场景说明</th>
							<th data-options="field:'channel_id',width:120,sortable:'true',align:'right'">渠道ID</th>
							<th data-options="field:'project_time',width:120,sortable:'true',align:'right'">立项时间</th>
							<th data-options="field:'bis_type',width:120,sortable:'true',align:'right'">业务类型</th>
							<th data-options="field:'project_manager',width:120,sortable:'true',align:'right'">项目管理人</th>
							<th data-options="field:'product_manager',width:120,sortable:'true',align:'right'">产品经理</th>
							<th data-options="field:'business_condition_explain',width:120,sortable:'true',align:'right'">商务条件说明</th>
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
var tbProductInfo_list ={};
jQuery(function($){
	var path = '<%=path%>';
	
    //定义一览页面查询的参数(JSON格式)
    tbProductInfo_list.buildJsonQueryParams = function(){
		  	var searchContent =	{
		  		//标准查询部分
			 	pageNumber:$('div#div_tbProductInfo_list #dg_tbProductInfo').datagrid('options').pageNumber,
		  		//页面查询框部分
					id :$("input[name='search_id']").val(), 
					product_name :$("input[name='search_product_name']").val(), 
					scene_explain :$("input[name='search_scene_explain']").val(), 
					channel_id :$("input[name='search_channel_id']").val(), 
					project_time :$("input[name='search_project_time']").val(), 
					bis_type :$("input[name='search_bis_type']").val(), 
					project_manager :$("input[name='search_project_manager']").val(), 
					product_manager :$("input[name='search_product_manager']").val(), 
					business_condition_explain :$("input[name='search_business_condition_explain']").val(), 
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
    tbProductInfo_list.buildJsonAddParams = function(){
		  	var addContent =	{
		  		//页面输入框部分
					id :$("input[name='add_id']").val(), 
					product_name :$("input[name='add_product_name']").val(), 
					scene_explain :$("input[name='add_scene_explain']").val(), 
					channel_id :$("input[name='add_channel_id']").val(), 
					project_time :$("input[name='add_project_time']").val(), 
					bis_type :$("input[name='add_bis_type']").val(), 
					project_manager :$("input[name='add_project_manager']").val(), 
					product_manager :$("input[name='add_product_manager']").val(), 
					business_condition_explain :$("input[name='add_business_condition_explain']").val(), 
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
	$('div#div_tbProductInfo_list #search_btn').click(function(){
		var searchContentStr = tbProductInfo_list.buildJsonQueryParams();		
		var url = path+"/search_tbProductInfo_getListData.do?searchContentStr="+searchContentStr; 
		//重新赋值url 属性
        $("#dg_tbProductInfo").datagrid("options").url=url;
        $("#dg_tbProductInfo").datagrid("reload"); 
	});
	
	//重置查询条件并刷新内容
	$('div#div_tbProductInfo_list #clear_btn').click(function(){
		//清空查询条件
			$("input[name='search_id']").val("");
			$("input[name='search_product_name']").val("");
			$("input[name='search_scene_explain']").val("");
			$("input[name='search_channel_id']").val("");
			$("input[name='search_project_time']").val("");
			$("input[name='search_bis_type']").val("");
			$("input[name='search_project_manager']").val("");
			$("input[name='search_product_manager']").val("");
			$("input[name='search_business_condition_explain']").val("");
			$("input[name='search_gmt_created']").val("");
			$("input[name='search_gmt_modified']").val("");
			$("input[name='search_creator']").val("");
			$("input[name='search_modifier']").val("");
			$("input[name='search_is_deleted']").val("");
		var form = $(searchForm);
	    form.find("select.easyui-combobox").combobox("setValue","");
	    form.find("input.easyui-datebox").datebox("clear");
	    form.find(":input[name]").not(":hidden").val("");
		var searchContentStr = tbProductInfo_list.buildQueryParams();
		var url = path+"/search_tbProductInfo_getListData.do?searchContentStr="+searchContentStr; 
	    $("#dg_tbProductInfo").datagrid("options").url=url;
	    $("#dg_tbProductInfo").datagrid("reload"); 
	});
	
	/*
	 * 点击新增按钮打开新增信息弹框
	 */
	$('div#div_tbProductInfo_list #add_btn').click(function(){
		var add_form_id ='#addTbProductInfoFrom';
		$('<div id="dialog_holder"></div>').dialog({
		    title: '新增tb_product_info',
		    width: 800,
		    height: 500,
		    href: path+'/page/tbProductInfo/addTbProductInfoPage.jsp',
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
						     url:'<%=path%>'+"/add_TbProductInfo.do?addContentStr="+tbProductInfo_list.buildJsonAddParams(),
							 success:function(data){
							        $.messager.progress('close');
									data = $.parseJSON(data);
									if(data.error){
									    $.messager.alert("操作提示",data.message);
									    return;
									}else{
									    $.messager.alert("操作提示",data.message);
										$('#dialog_holder').dialog('close');
								        $("#dg_tbProductInfo").datagrid("reload"); 
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
    tbProductInfo_list.buildJsonEditParams = function(){
		  	var editContent =	{
		  		//页面输入框部分
					id :$("input[name='edit_id']").val(), 
					product_name :$("input[name='edit_product_name']").val(), 
					scene_explain :$("input[name='edit_scene_explain']").val(), 
					channel_id :$("input[name='edit_channel_id']").val(), 
					project_time :$("input[name='edit_project_time']").val(), 
					bis_type :$("input[name='edit_bis_type']").val(), 
					project_manager :$("input[name='edit_project_manager']").val(), 
					product_manager :$("input[name='edit_product_manager']").val(), 
					business_condition_explain :$("input[name='edit_business_condition_explain']").val(), 
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
	tbProductInfo_list.updateFormSubmit = function(pkid){
	    var edit_form_id ='#editTbProductInfoFrom';
		$('<div id="dialog_holder"></div>').dialog({
		    title: 'TbProductInfo',
		    width: 800,
		    height: 500,
		    href: path+"/page/tbProductInfo/editTbProductInfoPage.jsp?pkid="+pkid,
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
						    url:'<%=path%>'+"/edit_TbProductInfo.do?editContentStr="+tbProductInfo_list.buildJsonEditParams(),
							success:function(data){
							        $.messager.progress('close');
									data = $.parseJSON(data);
									if(data.error){
									    $.messager.alert("操作提示",data.message);
									    return;
									}else{
									    $.messager.alert("操作提示",data.message);
										$('#dialog_holder').dialog('close');
								        $("#dg_tbProductInfo").datagrid("reload"); 
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
						 		url:path+"/del_TbProductInfo.do?pkid="+pkid,    
						 		success:function(data){
						 		 	data = $.parseJSON(data);
						 		 	if(data.error){
									    $.messager.alert("操作提示",data.message);
									    return;
						 		 	}else{
									    $.messager.alert("操作提示",data.message);
							 			$("#dialog_holder").dialog("destroy");
							 		    $("#dialog_holder").dialog("close");
							 		    $("#dg_tbProductInfo").datagrid("reload"); 
						 		 	}		 		 		
						 		}
						 	});
						   } ,
						   id:'del_cancel'}
						   ]
						});
	} ;
	
	//详细
	tbProductInfo_list.detailFormSubmit = function(pkid){
		$('<div id="dialog_holder"></div>').dialog({
		    title: '详细TbProductInfo',
		    width: 800,
		    height: 500,
		    href: path+"/page/tbProductInfo/detailTbProductInfoPage.jsp?pkid="+pkid, 
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
			        $("#dg_tbProductInfo").datagrid("reload"); 
				}
		     },buttons: [{
		    	text: "关闭",
		    	handler: function(){
		    		$("#dialog_holder").dialog('close');
		    	}
		    }]
		});
	};
	
	
	
	
});

</script>
<%@ include file="/page/common/footer.jsp"%>
</body>
</html>