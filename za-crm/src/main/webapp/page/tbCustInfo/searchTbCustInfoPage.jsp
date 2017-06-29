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
<div id="div_tbCustInfo_list" class="container">
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
										<th class="wd-20"><label>客户名称</label></th>
										<td>
												<input type="text" name="search_cust_name"  data-options="required:true"  style="width:200px;"/>
										</td>
										<th class="wd-20"><label>BD对接人</label></th>
										<td>
												<select id="search_bd_on_access" name="search_bd_on_access" class="easyui-combobox"  style="width:200px;">
												</select>
										</td>
									  </tr>
									 <tr>
										<th class="wd-20"><label>产品对接人</label></th>
										<td>
												<select id="search_product_on_access" name="search_product_on_access" class="easyui-combobox"  style="width:200px;">
												</select>
										</td>
										<th class="wd-20"><label>状态</label></th>
										<td>
												<select name="search_status"  class="easyui-combobox"　 style="width:200px;">
													<option value="">未选择</option>
														<option value="0">0-接触</option>
														<option value="1">1-搁置</option>
														<option value="2">2-合作</option>
														<option value="3">3-中断合作</option>
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
				<table  id="dg_tbCustInfo" class="easyui-datagrid" title="DataGrid Title" style="width:auto;height:300px"
					data-options="rownumbers:false,singleSelect:true,collapsible:true,sortName:'',sortOrder:'desc',pagination:'true',url:'<%=path%>/search_tbCustInfo_getListData.do',method:'post'">
					<thead>
						<tr>
						 	<th data-options="field:'detail',width:50,align:'center'">明细</th>
							<th data-options="field:'edit',width:50,align:'center'">编辑</th>
							<th data-options="field:'cust_name',width:120,sortable:'true',align:'right'">客户名称</th>
							<th data-options="field:'bd_on_access',width:120,sortable:'true',align:'right'">BD对接人</th>
							<th data-options="field:'address',width:120,sortable:'true',align:'right'">地点</th>
							<th data-options="field:'product_on_access',width:120,sortable:'true',align:'right'">产品对接人</th>
							<th data-options="field:'status',width:120,sortable:'true',align:'right'">状态</th>
							<th data-options="field:'business_condition',width:120,sortable:'true',align:'right'">商务条件</th>
							<th data-options="field:'memo',width:120,sortable:'true',align:'right'">备注</th>
							<th data-options="field:'gmt_created',width:120,sortable:'true',align:'right'">创建时间</th>
							<th data-options="field:'gmt_modified',width:120,sortable:'true',align:'right'">修改时间</th>
							<th data-options="field:'creator',width:120,sortable:'true',align:'right'">创建人</th>
							<th data-options="field:'modifier',width:120,sortable:'true',align:'right'">修改人</th>
						</tr>
					</thead>
				</table>
			</div>
			<!--搜索栏结果end-->
		</div>
	</article>
</div>

<script>
var tbCustInfo_list ={};
jQuery(function($){
	var path = '<%=path%>';
	
    //定义一览页面查询的参数(JSON格式)
    tbCustInfo_list.buildJsonQueryParams = function(){
		  	var searchContent =	{
		  		//标准查询部分
			 	pageNumber:$('div#div_tbCustInfo_list #dg_tbCustInfo').datagrid('options').pageNumber,
		  		//页面查询框部分
					id :$("input[name='search_id']").val(), 
					cust_name :$("input[name='search_cust_name']").val(), 
					bd_on_access :$("input[name='search_bd_on_access']").val(), 
					address :$("input[name='search_address']").val(), 
					product_on_access :$("input[name='search_product_on_access']").val(), 
					status :$("input[name='search_status']").val(), 
					business_condition :$("input[name='search_business_condition']").val(), 
					memo :$("input[name='search_memo']").val(), 
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
    tbCustInfo_list.buildJsonAddParams = function(){
		  	var addContent =	{
		  		//页面输入框部分
					id :$("input[name='add_id']").val(), 
					cust_name :$("input[name='add_cust_name']").val(), 
					bd_on_access :$("input[name='add_bd_on_access']").val(), 
					address :$("input[name='add_address']").val(), 
					product_on_access :$("input[name='add_product_on_access']").val(), 
					status :$("input[name='add_status']").val(), 
					business_condition :$("input[name='add_business_condition']").val(), 
					memo :$("input[name='add_memo']").val(), 
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
	$('div#div_tbCustInfo_list #search_btn').click(function(){
		var searchContentStr = tbCustInfo_list.buildJsonQueryParams();		
		var url = path+"/search_tbCustInfo_getListData.do?searchContentStr="+searchContentStr; 
		//重新赋值url 属性
        $("#dg_tbCustInfo").datagrid("options").url=url;
        $("#dg_tbCustInfo").datagrid("reload"); 
	});
	
	//重置查询条件并刷新内容
	$('div#div_tbCustInfo_list #clear_btn').click(function(){
		//清空查询条件
			$("input[name='search_id']").val("");
			$("input[name='search_cust_name']").val("");
			$("input[name='search_bd_on_access']").val("");
			$("input[name='search_address']").val("");
			$("input[name='search_product_on_access']").val("");
			$("input[name='search_status']").val("");
			$("input[name='search_business_condition']").val("");
			$("input[name='search_memo']").val("");
			$("input[name='search_gmt_created']").val("");
			$("input[name='search_gmt_modified']").val("");
			$("input[name='search_creator']").val("");
			$("input[name='search_modifier']").val("");
			$("input[name='search_is_deleted']").val("");
		var form = $(searchForm);
	    form.find("select.easyui-combobox").combobox("setValue","");
	    form.find("input.easyui-datebox").datebox("clear");
	    form.find(":input[name]").not(":hidden").val("");
		var searchContentStr = tbCustInfo_list.buildQueryParams();
		var url = path+"/search_tbCustInfo_getListData.do?searchContentStr="+searchContentStr; 
	    $("#dg_tbCustInfo").datagrid("options").url=url;
	    $("#dg_tbCustInfo").datagrid("reload"); 
	});
	
	/*
	 * 点击新增按钮打开新增信息弹框
	 */
	$('div#div_tbCustInfo_list #add_btn').click(function(){
		var add_form_id ='#addTbCustInfoFrom';
		$('<div id="dialog_holder"></div>').dialog({
		    title: '新增tb_cust_info',
		    width: 800,
		    height: 500,
		    href: path+'/page/tbCustInfo/addTbCustInfoPage.jsp',
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
						     url:'<%=path%>'+"/add_TbCustInfo.do?addContentStr="+tbCustInfo_list.buildJsonAddParams(),
							 success:function(data){
							        $.messager.progress('close');
									data = $.parseJSON(data);
									if(data.error){
									    $.messager.alert("操作提示",data.message);
									    return;
									}else{
									    $.messager.alert("操作提示",data.message);
										$('#dialog_holder').dialog('close');
								        $("#dg_tbCustInfo").datagrid("reload"); 
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
    tbCustInfo_list.buildJsonEditParams = function(){
		  	var editContent =	{
		  		//页面输入框部分
					id :$("input[name='edit_id']").val(), 
					cust_name :$("input[name='edit_cust_name']").val(), 
					bd_on_access :$("input[name='edit_bd_on_access']").val(), 
					address :$("input[name='edit_address']").val(), 
					product_on_access :$("input[name='edit_product_on_access']").val(), 
					status :$("input[name='edit_status']").val(), 
					business_condition :$("input[name='edit_business_condition']").val(), 
					memo :$("input[name='edit_memo']").val(), 
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
	tbCustInfo_list.updateFormSubmit = function(pkid){
	    var edit_form_id ='#editTbCustInfoFrom';
		$('<div id="dialog_holder"></div>').dialog({
		    title: 'TbCustInfo',
		    width: 800,
		    height: 500,
		    href: path+"/page/tbCustInfo/editTbCustInfoPage.jsp?pkid="+pkid,
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
						    url:'<%=path%>'+"/edit_TbCustInfo.do?editContentStr="+tbCustInfo_list.buildJsonEditParams(),
							success:function(data){
							        $.messager.progress('close');
									data = $.parseJSON(data);
									if(data.error){
									    $.messager.alert("操作提示",data.message);
									    return;
									}else{
									    $.messager.alert("操作提示",data.message);
										$('#dialog_holder').dialog('close');
								        $("#dg_tbCustInfo").datagrid("reload"); 
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
						 		url:path+"/del_TbCustInfo.do?pkid="+pkid,    
						 		success:function(data){
						 		 	data = $.parseJSON(data);
						 		 	if(data.error){
									    $.messager.alert("操作提示",data.message);
									    return;
						 		 	}else{
									    $.messager.alert("操作提示",data.message);
							 			$("#dialog_holder").dialog("destroy");
							 		    $("#dialog_holder").dialog("close");
							 		    $("#dg_tbCustInfo").datagrid("reload"); 
						 		 	}		 		 		
						 		}
						 	});
						   } ,
						   id:'del_cancel'}
						   ]
						});
	} ;
	
	//详细
	tbCustInfo_list.detailFormSubmit = function(pkid){
		$('<div id="dialog_holder"></div>').dialog({
		    title: '详细TbCustInfo',
		    width: 800,
		    height: 500,
		    href: path+"/page/tbCustInfo/detailTbCustInfoPage.jsp?pkid="+pkid, 
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
			        $("#dg_tbCustInfo").datagrid("reload"); 
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
		     url:'<%=path%>'+"/obtainTbSysrUserBD.do",
			 success:function(data){
						data = $.parseJSON(data);
					    $("#search_bd_on_access").combobox({	
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
		     url:'<%=path%>'+"/obtainTbSysrUserProduct.do",
			 success:function(data){
						data = $.parseJSON(data);
					    $("#search_product_on_access").combobox({	
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