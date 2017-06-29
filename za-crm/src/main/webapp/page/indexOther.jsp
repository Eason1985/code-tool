<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/page/common/easyui_head.jsp"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>"> 
<title>eason科技</title>
<link href="css/default.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="css/themes/icon.css">
<script type='text/javascript' src='<%=basePath%>js/common.js'></script>
</head>

<body class="easyui-layout" style="overflow-y: hidden" scroll="no" onbeforeunload="RunOnBeforeUnload()" onunload="RunOnUnload()">  
    <div data-options="region:'north',border:false,split:true" style="overflow: hidden; height: 60px;width:auto;
        background: url(images/page/daohang.jpg) #7f99be repeat-x center 100%;
        background-size:100% 100%;
        line-height: 30px; color: #fff; font-family: Verdana, 微软雅黑,黑体">
         <span style="padding-left: 10px;
                font-size: 16px; float: left;"><!-- eason科技CRM系统 -->
         </span>
         <span style="padding-right: 10px; font-size: 16px; float: right; ">
         		<ul><label style="font-size:15px;line-height:10px;color:white" id="userName"></label><label style="font-size:15px;line-height:10px;color:white" id="welcomstr" ></label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         		<a href="#" onclick="logout()">
         			<label style="font-size:15px;line-height:10px;color:white">退出</label>
         		</a>&nbsp;&nbsp;&nbsp;&nbsp;</ul>
         </span> 
    </div>
    <div data-options="region:'south',split:true" style="height: 5px; background: #D2E0F2;">
        <div class="footer">
         </div>
    </div>
    <div data-options="region:'west',split:true"  title="导航菜单" style="width: 180px;" id="west">
        <div id='wnav' class="easyui-accordion" data-options="fit:true,border:false" >
				<c:forEach  var="ctree" items="${menuTree.children}">
					<c:if test="${ ctree.isLeaf == false  }">
						<div title="${ctree.text}" data-options="iconCls:'icon-set'" style="overflow:auto;padding:10px;">
							<ul class="easyui-tree" >
								<c:set var="menuTree" value="${ctree}" scope="request" />
								<c:import url="./indexmenu.jsp" />
							</ul>
						</div>
					</c:if>
					<c:if test="${ctree.isLeaf == true }">
						<li data-options="iconCls:'icon-nav'">
							<a href="#" onclick="addTab('${ctree.text}','<%=basePath%>${ctree.resource_addr}')">${ctree.text}</a>
						</li>
					</c:if>
				</c:forEach>
		</div>
    </div>
    
    
    <div id="mainPanle" data-options="region:'center'" style="background: #eee; overflow-y: hidden;">
        <div id="tabs"  class="easyui-tabs" data-options="fit:true,border:false"  >
        	
        <div title="首页" style="background-image:url('./images/page/beijing01.jpg');">
        
        <div id="div_tbrLatentProject_list" class="container">
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
										<th class="wd-10"><label>汽车牌照</label></th>
										<td>
												<input type="text" name="search_license_plate"  data-options="required:true"  style="color:black;width:180px;height:30px;border:solid 1px #B2DFEE"/>
										</td>
										<th class="wd-10"><label>客户姓名</label></th>
										<td>
												<input type="text" name="search_cust_name"  data-options="required:true"  style="color:black;width:180px;height:30px;border:solid 1px #B2DFEE"/>
										</td>
										<th class="wd-10"><label>手机号码</label></th>
										<td>
												<input type="text" name="search_telephone"  data-options="required:true"  style="color:black;width:180px;height:30px;border:solid 1px #B2DFEE"/>
										</td>
									  </tr>
									 <tr>
										<th class="wd-10"><label>潜在项目类型</label></th>
										<td>
												<select name="search_latent_project_type"  class="easyui-combobox" editable="false"  editable="false" 　 style="color:black;width:180px;height:30px;border:solid 1px #B2DFEE">
													<option value="">未选择</option>
														<option value="0">维修</option>
														<option value="1">美容</option>
														<option value="2">喷漆</option>
														<option value="3">保养</option>
														<option value="4">代办</option>
														<option value="5">全车检查</option>
														<option value="6">其他</option>
												</select>
										</td>
										<th class="wd-10"><label>意向程度</label></th>
										<td>
												<select name="search_intention_type"  class="easyui-combobox" editable="false" 　 style="color:black;width:180px;height:30px;border:solid 1px #B2DFEE">
													<option value="">未选择</option>
														<option value="1">低</option>
														<option value="2">中</option>
														<option value="3">高</option>
												</select>
										</td>
										<th class="wd-10"><label>状态</label></th>
										<td>
												<select name="search_latent_project_status"  class="easyui-combobox" editable="false" 　 style="color:black;width:180px;height:30px;border:solid 1px #B2DFEE">
													<option value="">未选择</option>
														<option value="0">未到店</option>
														<option value="1">已回访</option>
														<option value="2">已到店</option>
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
				<table  id="dg_tbrLatentProject" class="easyui-datagrid" title="潜在项目列表" style="width:auto;height:300px"
					data-options="rownumbers:false,singleSelect:true,collapsible:true,sortName:'',sortOrder:'desc',pagination:'true',url:'<%=path%>/search_tbrLatentProject_getListData.do',method:'post'">
					<thead>
						<tr>
						 	<th data-options="field:'detail',width:50,align:'center'">明细</th>
							<th data-options="field:'edit',width:50,align:'center'">编辑</th>
							<th data-options="field:'license_plate',width:70,sortable:'true',align:'center'">汽车牌照</th>
							<th data-options="field:'cust_name',width:90,sortable:'true',align:'left'">客户姓名</th>
							<th data-options="field:'telephone',width:90,sortable:'true',align:'center'">手机号码</th>
							<th data-options="field:'latent_project_type',width:80,sortable:'true',align:'center'">潜在项目类型</th>
							<th data-options="field:'latent_project_name',width:120,sortable:'true',align:'left'">潜在项目名称</th>
							<th data-options="field:'intention_type',width:60,sortable:'true',align:'center'">意向程度</th>
							<th data-options="field:'offer',width:100,sortable:'true',align:'left'">报价</th>
							<th data-options="field:'expected_time',width:80,sortable:'true',align:'center'">预计到店时间</th>
							<th data-options="field:'latent_project_status',width:60,sortable:'true',align:'center'">状态</th>
							<th data-options="field:'memo',width:160,sortable:'true',align:'left'">备注</th>
							<th data-options="field:'user_name',width:120,sortable:'true',align:'center'">创建人</th>
							<th data-options="field:'createtime',width:120,sortable:'true',align:'center'">创建时间</th>
							<th data-options="field:'updatetime',width:120,sortable:'true',align:'center'">修改时间</th>
						</tr>
					</thead>
				</table>
			</div>
			<!--搜索栏结果end-->
		</div>
	</article>
</div>
        
        
        <!-- <img src="./images/page/logo.png"></img> -->
        	
	        
			<div><div>&nbsp;</div>
				
			</div>
		</div>
					
        </div>
    </div>
   <script type="text/javascript">
	 var forwardPath = '<%=path%>';
	$(document).ready(function(){ 

	acjAjax({
		 type:'POST',
		 cache:false,
		 async: false,
	     url:'<%=path%>'+"/searchRemindInsurCount.do",
		 success:function(data){
			data = $.parseJSON(data);
			document.getElementById('insur').innerHTML=data.insur;
			document.getElementById('routine').innerHTML=data.routine;
			document.getElementById('yearLimit').innerHTML=data.yearLimit;
			document.getElementById('statu0').innerHTML=data.statu0;
			document.getElementById('statu1').innerHTML=data.statu1;  
			document.getElementById('statu2').innerHTML=data.statu2;
			document.getElementById('userName').innerHTML=data.userName; 
			document.getElementById('welcomstr').innerHTML='，您好！';    
			
			sessionStorage.setItem("netname",data.netname);
			sessionStorage.setItem("address",data.address);
			sessionStorage.setItem("boss_phone",data.boss_phone);  
		}
	}); 
	
}); 

	function createFrame(url) {
	    var s = '<iframe scrolling="auto" frameborder="0"  src="' + url + '" style="width:100%;height:100%;"></iframe>';
	    return s;
	}
	
	/**
	 * 添加tab页
	*/
	function addTab(subtitle, url) {
	    if (!$('#tabs').tabs('exists', subtitle)) {
	        $('#tabs').tabs('add', {
	            title: subtitle,
	            content: createFrame(url),
	            closable: true,
	            icon: 'icon icon-nav'
	        });
	    } else {
	    	var currentTab = $('#tabs').tabs('getTab',subtitle);
	        $('#tabs').tabs('update',{
	        tab:currentTab,
	        options:{title:subtitle,
	        		content:createFrame(url),
	        		}
	        });
			$('#tabs').tabs('select',subtitle);
	    }
	}
	
	function addTab1(subtitle, url) {
	    $.messager.alert("操作提示","程序猿正在努力开发中...");
	}
	
	function logout(){
		window.location.href = "<%=path%>/logout.do";
	}	

//潜在项目相关
var forwardPath = '<%=path%>';
var tbrLatentProject_list ={};
jQuery(function($){
	var path = '<%=path%>';
	
    //定义一览页面查询的参数(JSON格式)
    tbrLatentProject_list.buildJsonQueryParams = function(){
		  	var searchContent =	{
		  		//标准查询部分
			 	pageNumber:$('div#div_tbrLatentProject_list #dg_tbrLatentProject').datagrid('options').pageNumber,
		  		//页面查询框部分
					latent_project_id :$("input[name='search_latent_project_id']").val(), 
					netno :$("input[name='search_netno']").val(), 
					license_plate :$("input[name='search_license_plate']").val(), 
					repair_car_info_id :$("input[name='search_repair_car_info_id']").val(), 
					cust_name :$("input[name='search_cust_name']").val(), 
					telephone :$("input[name='search_telephone']").val(), 
					latent_project_type :$("input[name='search_latent_project_type']").val(), 
					latent_project_name :$("input[name='search_latent_project_name']").val(), 
					intention_type :$("input[name='search_intention_type']").val(), 
					offer :$("input[name='search_offer']").val(), 
					expected_time :$("input[name='search_expected_time']").val(), 
					memo :$("input[name='search_memo']").val(), 
					latent_project_status :$("input[name='search_latent_project_status']").val(), 
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
    tbrLatentProject_list.buildJsonAddParams = function(){
		  	var addContent =	{
		  		//页面输入框部分
					latent_project_id :$("input[name='add_latent_project_id']").val(), 
					netno :$("input[name='add_netno']").val(), 
					license_plate :$("input[name='add_license_plate']").val(), 
					repair_car_info_id :$("input[name='add_repair_car_info_id']").val(), 
					cust_name :$("input[name='add_cust_name']").val(), 
					telephone :$("input[name='add_telephone']").val(), 
					latent_project_type :$("input[name='add_latent_project_type']").val(), 
					latent_project_name :$("input[name='add_latent_project_name']").val(), 
					intention_type :$("input[name='add_intention_type']").val(), 
					offer :$("input[name='add_offer']").val(), 
					expected_time :$("input[name='add_expected_time']").val(), 
					memo :$("input[name='add_memo']").val(), 
					latent_project_status :$("input[name='add_latent_project_status']").val(), 
					createtime :$("input[name='add_createtime']").val(), 
					updatetime :$("input[name='add_updatetime']").val(), 
					create_user_id :$("input[name='add_create_user_id']").val(), 
					update_user_id :$("input[name='add_update_user_id']").val(), 
		    };
			var addContentStr  =JSON.stringify(addContent);
			//传到到后台的URL 必须先编码化
			return encodeURI(addContentStr);
	 };
	
	//重新按照条件刷新查询一览内容
	$('div#div_tbrLatentProject_list #search_btn').click(function(){
		var searchContentStr = tbrLatentProject_list.buildJsonQueryParams();		
		var url = path+"/search_tbrLatentProject_getListData.do?searchContentStr="+searchContentStr; 
		//重新赋值url 属性
        $("#dg_tbrLatentProject").datagrid("options").url=url;
        $("#dg_tbrLatentProject").datagrid("reload"); 
	});
	
	//重置查询条件并刷新内容
	$('div#div_tbrLatentProject_list #clear_btn').click(function(){
		//清空查询条件
			$("input[name='search_latent_project_id']").val("");
			$("input[name='search_netno']").val("");
			$("input[name='search_license_plate']").val("");
			$("input[name='search_repair_car_info_id']").val("");
			$("input[name='search_cust_name']").val("");
			$("input[name='search_telephone']").val("");
			$("input[name='search_latent_project_type']").val("");
			$("input[name='search_latent_project_name']").val("");
			$("input[name='search_intention_type']").val("");
			$("input[name='search_offer']").val("");
			$("input[name='search_expected_time']").val("");
			$("input[name='search_memo']").val("");
			$("input[name='search_latent_project_status']").val("");
			$("input[name='search_createtime']").val("");
			$("input[name='search_updatetime']").val("");
			$("input[name='search_create_user_id']").val("");
			$("input[name='search_update_user_id']").val("");
		var form = $(searchForm);
	    form.find("select.easyui-combobox").combobox("setValue","");
	    form.find("input.easyui-datebox").datebox("clear");
	    form.find(":input[name]").not(":hidden").val("");
		var searchContentStr = tbrLatentProject_list.buildQueryParams();
		var url = path+"/search_tbrLatentProject_getListData.do?searchContentStr="+searchContentStr; 
	    $("#dg_tbrLatentProject").datagrid("options").url=url;
	    $("#dg_tbrLatentProject").datagrid("reload"); 
	});
	
	/*
	 * 点击新增按钮打开新增信息弹框
	 */
	$('div#div_tbrLatentProject_list #add_btn').click(function(){
		var add_form_id ='#addTbrLatentProjectFrom';
		$('<div id="dialog_holder"></div>').dialog({
		    title: '新增潜在项目',
		    width: 800,
		    height: 360,
		    href: path+'/page/business/repair/tbrLatentProject/addTbrLatentProjectPage.jsp',
		    modal: true,
		    method: "POST",
			onClose: function(){
				$(this).dialog("destroy");
			},
		    buttons: [{
		    	text: "保存",
		    	handler: function(){
		    		if($(add_form_id).form("validate")==true){
		    		
		    			var license_plate=$("input[name='add_license_plate']").val();
					 	if(license_plate.length!=7){
					 		$.messager.alert("提示信息","车牌号位数为7位!");
					 		return false;
					 	}
				   		
				  		var reg=/^[A-Z|a-z|\u4e00-\u9fa5]*$/;
				   		var cust_name=$("input[name='add_cust_name']").val();
				   		if(!reg.test(cust_name)){
				   			 $.messager.alert("提示信息","客户姓名只能输入中文或字母!");
				   			 return false;
				   		}
				   		
				   		var add_offer=$("input[name='add_offer']").val();
						if(add_offer<0){
							$.messager.alert("提示信息","报价不能小于0!");
							return false;
						}
				   		
				   		var mobphone=$("input[name='add_telephone']").val();
				   		if(mobphone.length!=11){
				   			$.messager.alert("提示信息","手机号码只能输入11位!");
				   			return false;
				   		}
				   		
						$.messager.progress(); 
						acjAjax({
							 type:'POST',
							 cache:false,
					 		 async: false,
						     url:'<%=path%>'+"/add_TbrLatentProject.do?addContentStr="+tbrLatentProject_list.buildJsonAddParams(),
							 success:function(data){
							        $.messager.progress('close');
									data = $.parseJSON(data);
									if(data.error){
									    $.messager.alert("操作提示",data.message);
									    return;
									}else{
									    $.messager.alert("操作提示",data.message);
										$('#dialog_holder').dialog('close');
								        $("#dg_tbrLatentProject").datagrid("reload"); 
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
    tbrLatentProject_list.buildJsonEditParams = function(){
		  	var editContent =	{
		  		//页面输入框部分
					latent_project_id :$("input[name='edit_latent_project_id']").val(), 
					netno :$("input[name='edit_netno']").val(), 
					license_plate :$("input[name='edit_license_plate']").val(), 
					repair_car_info_id :$("input[name='edit_repair_car_info_id']").val(), 
					cust_name :$("input[name='edit_cust_name']").val(), 
					telephone :$("input[name='edit_telephone']").val(), 
					latent_project_type :$("input[name='edit_latent_project_type']").val(), 
					latent_project_name :$("input[name='edit_latent_project_name']").val(), 
					intention_type :$("input[name='edit_intention_type']").val(), 
					offer :$("input[name='edit_offer']").val(), 
					expected_time :$("input[name='edit_expected_time']").val(), 
					memo :$("input[name='edit_memo']").val(), 
					latent_project_status :$("input[name='edit_latent_project_status']").val(), 
					createtime :$("input[name='edit_createtime']").val(), 
					updatetime :$("input[name='edit_updatetime']").val(), 
					create_user_id :$("input[name='edit_create_user_id']").val(), 
					update_user_id :$("input[name='edit_update_user_id']").val(), 
		    };
			var editContentStr  =JSON.stringify(editContent);
			//传到到后台的URL 必须先编码化
			return encodeURI(editContentStr);
	 };
	 
	/*
	 * 点击编辑按钮弹出编辑信息框
	 pkid:主键
	 */
	tbrLatentProject_list.updateFormSubmit = function(pkid){
	    var edit_form_id ='#editTbrLatentProjectFrom';
		$('<div id="dialog_holder"></div>').dialog({
		    title: '潜在项目修改',
		    width: 800,
		    height: 360,
		    href: path+"/page/business/repair/tbrLatentProject/editTbrLatentProjectPage.jsp?pkid="+pkid,
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
				    	var license_plate=$("input[name='edit_license_plate']").val();
					 	if(license_plate.length!=7){
					 		$.messager.alert("提示信息","车牌号位数为7位!");
					 		return false;
					 	}
				   		
				  		var reg=/^[A-Z|a-z|\u4e00-\u9fa5]*$/;
				   		var cust_name=$("input[name='edit_cust_name']").val();
				   		if(!reg.test(cust_name)){
				   			 $.messager.alert("提示信息","客户姓名只能输入中文或字母!");
				   			 return false;
				   		}
				   		
				   		var edit_offer=$("input[name='edit_offer']").val();
						if(edit_offer<0){
							$.messager.alert("提示信息","报价不能小于0!");
							return false;
						}
				   		
				   		var mobphone=$("input[name='edit_telephone']").val();
				   		if(mobphone.length!=11){
				   			$.messager.alert("提示信息","手机号码只能输入11位!");
				   			return false;
				   		}
				   		
					  	$.messager.progress(); 
			      		acjAjax({
							type:'POST',
							cache:false,
					 		async: false,
						    url:'<%=path%>'+"/edit_TbrLatentProject.do?editContentStr="+tbrLatentProject_list.buildJsonEditParams(),
							success:function(data){
							        $.messager.progress('close');
									data = $.parseJSON(data);
									if(data.error){
									    $.messager.alert("操作提示",data.message);
									    return;
									}else{
									    $.messager.alert("操作提示",data.message);
										$('#dialog_holder').dialog('close');
								        $("#dg_tbrLatentProject").datagrid("reload"); 
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
						 		url:path+"/del_TbrLatentProject.do?pkid="+pkid,    
						 		success:function(data){
						 		 	data = $.parseJSON(data);
						 		 	if(data.error){
									    $.messager.alert("操作提示",data.message);
									    return;
						 		 	}else{
									    $.messager.alert("操作提示",data.message);
							 			$("#dialog_holder").dialog("destroy");
							 		    $("#dialog_holder").dialog("close");
							 		    $("#dg_tbrLatentProject").datagrid("reload"); 
						 		 	}		 		 		
						 		}
						 	});
						   } ,
						   id:'del_cancel'}
						   ]
						});
	} ;
	
	//详细
	tbrLatentProject_list.detailFormSubmit = function(pkid){
		$('<div id="dialog_holder"></div>').dialog({
		    title: '潜在项目详细信息',
		    width: 800,
		    height: 360,
		    href: path+"/page/business/repair/tbrLatentProject/detailTbrLatentProjectPage.jsp?pkid="+pkid, 
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
			        $("#dg_tbrLatentProject").datagrid("reload"); 
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
</body>
</html>
