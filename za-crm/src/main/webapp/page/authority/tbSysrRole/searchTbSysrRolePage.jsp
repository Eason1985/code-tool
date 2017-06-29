<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getScheme() + "://" + request.getServerName()
+ ":" + request.getServerPort() + request.getContextPath();
	String basePath = path + "/";
	String cssPath = path + "/css";
	String jsPath = path + "/js";
	String jspPath = path + "/jsp";
	String imgPath = path + "/images";
%>
<!DOCTYPE html>
<html>
<head>
<title></title>

<link rel="stylesheet" type="text/css" href="<%=cssPath%>/baseUI.css">
<link rel="stylesheet" type="text/css" href="<%=cssPath%>/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=cssPath%>/themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=cssPath%>/easyui/demo.css">
<link rel="stylesheet" type="text/css" href="<%=cssPath%>/progress.css">

<script type='text/javascript' src='<%=basePath%>js/acj-ajax.js'></script>
<script type='text/javascript' src='<%=basePath%>js/jquery/jquery.min.js'></script>
<script type='text/javascript' src='<%=basePath%>js/jquery/jquery.easyui.mobile.js'></script>
<script type='text/javascript' src='<%=basePath%>js/jquery/jquery.easyui.min.js'></script>
<script type='text/javascript' src='<%=basePath%>js/jquery/easyui.validator.ext.js'></script>
<script type="text/javascript" src="<%=basePath%>js/jquery/easyui-lang-zh_CN.js"></script>
<script type='text/javascript' src='<%=basePath%>js/jquery/datagrid-detailview.js'></script>
<script type="text/javascript" src="<%=jsPath%>/ui.lib.js"></script>
<script type="text/javascript" src="<%=basePath%>js/json/json2.min.js"></script>
<script type='text/javascript' src='<%=basePath%>js/ajaxProcessUtil.js'></script>
<script type='text/javascript' src='<%=basePath%>js/progress.js'></script>
<script type='text/javascript' src='<%=basePath%>js/privCity.js'></script>
<script type="text/javascript" src="<%=basePath%>js/json/basedata.json"></script>
<script type="text/javascript" src="<%=basePath%>js/tools/checkUtils.js"></script>

<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8" src="<%=basePath%>utf8-jsp/lang/zh-cn/zh-cn.js"></script>

 
</head>
<body>
<!--内容-->
<div id="div_tbSysrRole_list" class="container">
<!-- 	<div class="page-toolbar clearfix">
		<ul class="page-toolbar-list">
			<li><a href="javascript:;" id="add_btn"><i class="icon-add"></i>新增</a></li>
		</ul>
	</div> -->
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
										<th class="wd-20"><label>角色名</label></th>
										<td>
											<input type="text"  name="search_role_name"  data-options="required:true"  style="color:black;width:180px;height:30px;border:solid 1px #B2DFEE" />
										</td>
										<th class="wd-20"><label>角色组</label></th>
										<td>
											<input type="text"  name="search_role_group"  data-options="required:true"  style="color:black;width:180px;height:30px;border:solid 1px #B2DFEE" />
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
				<table  id="dg_tbSysrRole" class="easyui-datagrid" title="角色列表" style="width:auto;height:300px"
					data-options="rownumbers:false,singleSelect:true,collapsible:true,sortName:'',sortOrder:'desc',pagination:'true',url:'<%=path%>/search_tbSysrRole_getListData.do',method:'post',onLoadSuccess:function(dataObj){redirectToLogin(dataObj);}">
					<thead>
						<tr>
						 	<th data-options="field:'detail',width:50,align:'center'">明细</th>
							<th data-options="field:'edit',width:50,align:'center'">编辑</th>
							<th data-options="field:'resource_config',width:50,align:'center'">资源配置</th>
<!-- 							<th data-options="field:'user_config',width:50,align:'center'">用户配置</th> -->
							<th data-options="field:'sysr_role_id',width:120,sortable:'true',align:'right'">角色编号</th>
							<th data-options="field:'role_name',width:120,sortable:'true',align:'right'">角色名</th>
							<th data-options="field:'role_group',width:120,sortable:'true',align:'right'">角色组</th>
						</tr>
					</thead>
				</table>
			</div>
			<!--搜索栏结果end-->
		</div>
	</article>
</div>

<script>
var tbSysrRole_list ={};
jQuery(function($){
	var path = '<%=path%>';
    //定义一览页面查询的参数(JSON格式)
    tbSysrRole_list.buildJsonQueryParams = function(){
		  	var searchContent =	{
		  		//标准查询部分
			 	pageNumber:$('div#div_tbSysrRole_list #dg_tbSysrRole').datagrid('options').pageNumber,
		  		//页面查询框部分
					sysr_role_id :$("input[name='search_sysr_role_id']").val(), 
					role_name :$("input[name='search_role_name']").val(), 
					role_group :$("input[name='search_role_group']").val(), 
					description :$("input[name='search_description']").val(), 
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
    tbSysrRole_list.buildJsonAddParams = function(){
		  	var addContent =	{
		  		//页面输入框部分
					sysr_role_id :$("input[name='tbSysrRoleDto.sysr_role_id']").val(), 
					role_name :$("input[name='tbSysrRoleDto.role_name']").val(), 
					role_group :$("input[name='tbSysrRoleDto.role_group']").val(), 
					description :$("input[name='tbSysrRoleDto.description']").val(), 
					netno :$("input[name='tbSysrRoleDto.netno']").val(), 
					createtime :$("input[name='tbSysrRoleDto.createtime']").val(), 
					updatetime :$("input[name='tbSysrRoleDto.updatetime']").val(), 
					create_user_id :$("input[name='tbSysrRoleDto.create_user_id']").val(), 
					update_user_id :$("input[name='tbSysrRoleDto.update_user_id']").val(), 
		    };
			var addContentStr  =JSON.stringify(addContent);
			//传到到后台的URL 必须先编码化
			return encodeURI(addContentStr);
	 };
	
	//重新按照条件刷新查询一览内容
	$('div#div_tbSysrRole_list #search_btn').click(function(){
		var searchContentStr = tbSysrRole_list.buildJsonQueryParams();		
		var url = path+"/search_tbSysrRole_getListData.do?searchContentStr="+searchContentStr; 
		//重新赋值url 属性
        $("#dg_tbSysrRole").datagrid("options").url=url;
        $("#dg_tbSysrRole").datagrid("reload"); 
	});
	
	//重置查询条件并刷新内容
	$('div#div_tbSysrRole_list #clear_btn').click(function(){
		//清空查询条件
			$("input[name='search_sysr_role_id']").val("");
			$("input[name='search_role_name']").val("");
			$("input[name='search_role_group']").val("");
			$("input[name='search_description']").val("");
			$("input[name='search_netno']").val("");
			$("input[name='search_createtime']").val("");
			$("input[name='search_updatetime']").val("");
			$("input[name='search_create_user_id']").val("");
			$("input[name='search_update_user_id']").val("");
		var form = $(searchForm);
	    form.find("select.easyui-combobox").combobox("setValue","");
	    form.find("input.easyui-datebox").datebox("clear");
	    form.find(":input[name]").not(":hidden").val("");
		var searchContentStr = tbSysrRole_list.buildQueryParams();
		var url = path+"/search_tbSysrRole_getListData.do?searchContentStr="+searchContentStr; 
	    $("#dg_tbSysrRole").datagrid("options").url=url;
	    $("#dg_tbSysrRole").datagrid("reload"); 
	});
	
	/*
	 * 点击新增按钮打开新增信息弹框
	 */
	$('div#div_tbSysrRole_list #add_btn').click(function(){
		var add_form_id ='#addTbSysrRoleFrom';
		$('<div id="dialog_holder"></div>').dialog({
		    title: '新增TB_SYSR_ROLE',
		    width: 800,
		    height: 200,
		    href: path+'/page/authority/tbSysrRole/addTbSysrRolePage.jsp',
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
						     url:'<%=path%>'+"/add_TbSysrRole.do?addContentStr="+tbSysrRole_list.buildJsonAddParams(),
							 success:function(data){
							        $.messager.progress('close');
									data = $.parseJSON(data);
									if(data.error){
									    $.messager.alert("操作提示",data.message);
									    return;
									}else{
									    $.messager.alert("操作提示",data.message);
										$('#dialog_holder').dialog('close');
								        $("#dg_tbSysrRole").datagrid("reload"); 
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
    tbSysrRole_list.buildJsonEditParams = function(){
		  	var editContent =	{
		  		//页面输入框部分
					sysr_role_id :$("input[name='tbSysrRoleDto.sysr_role_id']").val(), 
					role_name :$("input[name='tbSysrRoleDto.role_name']").val(), 
					role_group :$("input[name='tbSysrRoleDto.role_group']").val(), 
					description :$("input[name='tbSysrRoleDto.description']").val(), 
					netno :$("input[name='tbSysrRoleDto.netno']").val(), 
					createtime :$("input[name='tbSysrRoleDto.createtime']").val(), 
					updatetime :$("input[name='tbSysrRoleDto.updatetime']").val(), 
					create_user_id :$("input[name='tbSysrRoleDto.create_user_id']").val(), 
					update_user_id :$("input[name='tbSysrRoleDto.update_user_id']").val(), 
		    };
			var editContentStr  =JSON.stringify(editContent);
			//传到到后台的URL 必须先编码化
			return encodeURI(editContentStr);
	 };
	 
	/*
	 * 点击编辑按钮弹出编辑信息框
	 pkid:主键
	 */
	tbSysrRole_list.updateFormSubmit = function(pkid){
	    var edit_form_id ='#editTbSysrRoleFrom';
		$('<div id="dialog_holder"></div>').dialog({
		    title: 'TbSysrRole',
		    width: 800,
		    height: 200,
		    href: path+"/page/authority/tbSysrRole/editTbSysrRolePage.jsp?pkid="+pkid,
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
						    url:'<%=path%>'+"/edit_TbSysrRole.do?editContentStr="+tbSysrRole_list.buildJsonEditParams(),
							success:function(data){
							        $.messager.progress('close');
									data = $.parseJSON(data);
									if(data.error){
									    $.messager.alert("操作提示",data.message);
									    return;
									}else{
									    $.messager.alert("操作提示",data.message);
										$('#dialog_holder').dialog('close');
								        $("#dg_tbSysrRole").datagrid("reload"); 
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
						 		url:path+"/del_TbSysrRole.do?pkid="+pkid,    
						 		success:function(data){
						 		 	data = $.parseJSON(data);
						 		 	if(data.error){
									    $.messager.alert("操作提示",data.message);
									    return;
						 		 	}else{
									    $.messager.alert("操作提示",data.message);
							 			$("#dialog_holder").dialog("destroy");
							 		    $("#dialog_holder").dialog("close");
							 		    $("#dg_tbSysrRole").datagrid("reload"); 
						 		 	}		 		 		
						 		}
						 	});
						   } ,
						   id:'del_cancel'}
						   ]
						});
	} ;
	
	//详细
	tbSysrRole_list.detailFormSubmit = function(pkid){
		$('<div id="dialog_holder"></div>').dialog({
		    title: '详细TbSysrRole',
		    width: 800,
		    height: 200,
		    href: path+"/page/authority/tbSysrRole/detailTbSysrRolePage.jsp?pkid="+pkid, 
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
			        $("#dg_tbSysrRole").datagrid("reload"); 
				}
		     },buttons: [{
		    	text: "关闭",
		    	handler: function(){
		    		$("#dialog_holder").dialog('close');
		    	}
		    }]
		});
	};
	
	 //角色分配权限
      tbSysrRole_list.allotResourceFormSubmit = function(pkid,roleName,roleGroup){
          $('<div id="dialog_allot_holder"></div>').dialog({
              title: roleName + '资源分配',
              width: 800,
              height: 400,
              href: path+"/page/authority/tbSysrRole/configresource/addTRoleResRelaPage.jsp?pkid="+pkid, 
              modal: true,
              method: "POST",
              params:{"pkid":pkid},
              onClose: function(){
                  $(this).dialog("destroy");
              },
              buttons: [{
		    	text: "保存设置",
		    	handler: function(e){
		    		var treeNode = $('#resource_panel_tree');
		    		var nodes = treeNode.tree('getChecked',['checked','indeterminate']);
		    		var resource_group = [];
		    		for(var i = 0; i<nodes.length;i++){
		    			resource_group.push(nodes[i].id);
		    		}
		    		showProgress();
		    		$.post(path+"/configResourceToRole.do",
		    		  {
		    		  	"pkid": pkid,
		    			"res_id": resource_group.join(",")	   
					  },
					  function(data){
						  closeProgress();
						  treeNode.tree('reload');
						 
					  });
		    	}
		    },{
                  text: "关闭",
                  handler: function(e){
                	  $("#dialog_allot_holder").dialog("destroy");
                      $("#dialog_allot_holder").dialog("close");
                  }
              }]
          });
      };
	
	  //角色分配员工
      tbSysrRole_list.allotUserFormSubmit = function(pkid,roleName,roleGroup){
          $('<div id="dialog_holder"></div>').dialog({
              title: roleName + '角色员工分配',
              width: 800,
              height: 510,
              href: 'configUserToRolePage.action',
              modal: true,
              method: "POST",
              onLoad: function(){
				$("#div_roleUser_list #role_id").val(pkid);
				$("#div_roleUser_list #role_name").val(roleName);
				tConfig_list.trigger();
			  },
              onClose: function(){
                  $(this).dialog("destroy");
              },
              buttons: [{
                  text: "关闭",
                  handler: function(e){
                      $(this).dialog("close");
                  }
              }]
          });
      }
});

</script>
<%@ include file="/page/common/footer.jsp"%>
</body>
</html>