<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/page/common/easyui_head.jsp"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>"> 
<title></title>
<link href="css/default.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="css/themes/icon.css">
<script type='text/javascript' src='<%=basePath%>js/common.js'></script>
</head>
<body>
<!--内容-->
<div id="div_tbSysrGroup_list" class="container">
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
										<th class="wd-20"><label>组名</label></th>
										<td>
											<input type="text"  name="search_group_name"  data-options="required:true"  style="color:black;width:180px;height:30px;border:solid 1px #B2DFEE" />
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
				<table  id="dg_tbSysrGroup" class="easyui-datagrid" title="DataGrid Title" style="width:auto;height:300px"
					data-options="rownumbers:false,singleSelect:true,collapsible:true,sortName:'',sortOrder:'desc',pagination:'true',url:'<%=path%>/search_tbSysrGroup_getListData.do',method:'post',onLoadSuccess:function(dataObj){redirectToLogin(dataObj);}">
					<thead>
						<tr>
						 	<th data-options="field:'detail',width:50,align:'center'">明细</th>
							<th data-options="field:'edit',width:50,align:'center'">编辑</th>
							<th data-options="field:'group_id',width:120,sortable:'true',align:'right'">组ID</th>
							<th data-options="field:'group_name',width:120,sortable:'true',align:'right'">组名</th>
							<th data-options="field:'netno',width:120,sortable:'true',align:'right'">网点号</th>
							<th data-options="field:'createtime',width:120,sortable:'true',align:'right'">创建时间</th>
							<th data-options="field:'updatetime',width:120,sortable:'true',align:'right'">修改时间</th>
							<th data-options="field:'create_user_id',width:120,sortable:'true',align:'right'">创建人</th>
							<th data-options="field:'update_user_id',width:120,sortable:'true',align:'right'">更新人</th>
						</tr>
					</thead>
				</table>
			</div>
			<!--搜索栏结果end-->
		</div>
	</article>
</div>

<script>
var tbSysrGroup_list ={};
var forwardPath = '<%=path%>';
jQuery(function($){
	var path = '<%=path%>';
    //定义一览页面查询的参数(JSON格式)
    tbSysrGroup_list.buildJsonQueryParams = function(){
		  	var searchContent =	{
		  		//标准查询部分
			 	pageNumber:$('div#div_tbSysrGroup_list #dg_tbSysrGroup').datagrid('options').pageNumber,
		  		//页面查询框部分
					group_id :$("input[name='search_group_id']").val(), 
					group_name :$("input[name='search_group_name']").val(), 
					netno :$("input[name='search_netno']").val(), 
					createtime :$("input[name='search_createtime']").val(), 
					updatetime :$("input[name='search_updatetime']").val(), 
					create_user_id :$("input[name='search_create_user_id']").val(), 
					update_user_id :$("input[name='search_update_user_id']").val(), 
		    };
			var searchContentStr  =JSON.stringify(searchContent);
			//传到到后台的URL 必须先编码化
			return encodeURI(searchContentStr);
	 };
	 
	//定义新增信息的参数(JSON格式)
    tbSysrGroup_list.buildJsonAddParams = function(){
		  	var addContent =	{
		  		//页面输入框部分
					group_id :$("input[name='tbSysrGroupDto.group_id']").val(), 
					group_name :$("input[name='tbSysrGroupDto.group_name']").val(), 
					netno :$("input[name='tbSysrGroupDto.netno']").val(), 
					createtime :$("input[name='tbSysrGroupDto.createtime']").val(), 
					updatetime :$("input[name='tbSysrGroupDto.updatetime']").val(), 
					create_user_id :$("input[name='tbSysrGroupDto.create_user_id']").val(), 
					update_user_id :$("input[name='tbSysrGroupDto.update_user_id']").val(), 
		    };
			var addContentStr  =JSON.stringify(addContent);
			//传到到后台的URL 必须先编码化
			return encodeURI(addContentStr);
	 };
	
	//重新按照条件刷新查询一览内容
	$('div#div_tbSysrGroup_list #search_btn').click(function(){
		var searchContentStr = tbSysrGroup_list.buildJsonQueryParams();		
		var url = path+"/search_tbSysrGroup_getListData.do?searchContentStr="+searchContentStr; 
		//重新赋值url 属性
        $("#dg_tbSysrGroup").datagrid("options").url=url;
        $("#dg_tbSysrGroup").datagrid("reload"); 
	});
	
	//重置查询条件并刷新内容
	$('div#div_tbSysrGroup_list #clear_btn').click(function(){
		//清空查询条件
			$("input[name='search_group_id']").val("");
			$("input[name='search_group_name']").val("");
			$("input[name='search_netno']").val("");
			$("input[name='search_createtime']").val("");
			$("input[name='search_updatetime']").val("");
			$("input[name='search_create_user_id']").val("");
			$("input[name='search_update_user_id']").val("");
		var form = $(searchForm);
	    form.find("select.easyui-combobox").combobox("setValue","");
	    form.find("input.easyui-datebox").datebox("clear");
	    form.find(":input[name]").not(":hidden").val("");
		var searchContentStr = tbSysrGroup_list.buildQueryParams();
		var url = path+"/search_tbSysrGroup_getListData.do?searchContentStr="+searchContentStr; 
	    $("#dg_tbSysrGroup").datagrid("options").url=url;
	    $("#dg_tbSysrGroup").datagrid("reload"); 
	});
	
	/*
	 * 点击新增按钮打开新增信息弹框
	 */
	$('div#div_tbSysrGroup_list #add_btn').click(function(){
		var add_form_id ='#addTbSysrGroupFrom';
		$('<div id="dialog_holder"></div>').dialog({
		    title: '新增TB_SYSR_GROUP',
		    width: 800,
		    height: 150,
		    href: path+'/page/authority/tbSysrGroup/addTbSysrGroupPage.jsp',
		    modal: true,
		    method: "POST",
			onClose: function(){
				$(this).dialog("destroy");
			},
		    buttons: [{
		    	text: "保存",
		    	handler: function(){
		    		//validate and sbumit
				    if($(add_form_id).form("validate")==true){
					  	$.messager.progress(); 
						acjAjax({
							 type:'POST',
							 cache:false,
					 		 async: false,
						     url:'<%=path%>'+"/add_TbSysrGroup.do?addContentStr="+tbSysrGroup_list.buildJsonAddParams(),
							 success:function(data){
							        $.messager.progress('close');
									data = $.parseJSON(data);
									if(data.error){
									    $.messager.alert("操作提示",data.message);
									    return;
									}else{
									    $.messager.alert("操作提示",data.message);
										$('#dialog_holder').dialog('close');
								        $("#dg_tbSysrGroup").datagrid("reload"); 
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
	//定义新增信息的参数(JSON格式)
    tbSysrGroup_list.buildJsonEditParams = function(){
		  	var editContent =	{
		  		//页面输入框部分
					group_id :$("input[name='tbSysrGroupDto.group_id']").val(), 
					group_name :$("input[name='tbSysrGroupDto.group_name']").val(), 
					netno :$("input[name='tbSysrGroupDto.netno']").val(), 
					createtime :$("input[name='tbSysrGroupDto.createtime']").val(), 
					updatetime :$("input[name='tbSysrGroupDto.updatetime']").val(), 
					create_user_id :$("input[name='tbSysrGroupDto.create_user_id']").val(), 
					update_user_id :$("input[name='tbSysrGroupDto.update_user_id']").val(), 
		    };
			var editContentStr  =JSON.stringify(editContent);
			//传到到后台的URL 必须先编码化
			return encodeURI(editContentStr);
	 };
	/*
	 * 点击编辑按钮弹出编辑信息框
	 pkid:主键
	 */
	tbSysrGroup_list.updateFormSubmit = function(pkid){
	    var edit_form_id ='#editTbSysrGroupFrom';
		$('<div id="dialog_holder"></div>').dialog({
		    title: 'TbSysrGroup',
		    width: 800,
		    height: 150,
		    href: path+"/page/authority/tbSysrGroup/editTbSysrGroupPage.jsp?pkid="+pkid,
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
			      		acjAjax({
							type:'POST',
							cache:false,
					 		async: false,
						    url:'<%=path%>'+"/edit_TbSysrGroup.do?editContentStr="+tbSysrGroup_list.buildJsonEditParams(),
							success:function(data){
							        $.messager.progress('close');
									data = $.parseJSON(data);
									if(data.error){
									    $.messager.alert("操作提示",data.message);
									    return;
									}else{
									    $.messager.alert("操作提示",data.message);
										$('#dialog_holder').dialog('close');
								        $("#dg_tbSysrGroup").datagrid("reload"); 
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
		     			acjAjax({
						 		type:'POST',
						 		url:path+"/del_TbSysrGroup.do?pkid="+pkid,    
						 		success:function(data){
						 		 	data = $.parseJSON(data);
						 		 	if(data.error){
									    $.messager.alert("操作提示",data.message);
									    return;
						 		 	}else{
									    $.messager.alert("操作提示",data.message);
							 			$("#dialog_holder").dialog("destroy");
							 		    $("#dialog_holder").dialog("close");
							 		    $("#dg_tbSysrGroup").datagrid("reload"); 
						 		 	}		 		 		
						 		}
						 	});
						   } ,
						   id:'del_cancel'}
						   ]
						});
	} ;
	
	//详细
	tbSysrGroup_list.detailFormSubmit = function(pkid){
		$('<div id="dialog_holder"></div>').dialog({
		    title: '详细TbSysrGroup',
		    width: 800,
		    height: 300,
		    href: path+"/page/authority/tbSysrGroup/detailTbSysrGroupPage.jsp?pkid="+pkid, 
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
			        $("#dg_tbSysrGroup").datagrid("reload"); 
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