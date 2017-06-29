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
<body class="easyui-layout" style="overflow-y: hidden" scroll="no">
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
        
        	<article id="content" class="content">
		<div class="content-body">
			<!--搜索栏开始-->
			&nbsp;
			<table>
				 <tr>
					<td>
						<input type="text" name="search_content" style="color:black;width:300px;height:30px;border:solid 1px #B2DFEE" placeholder="商品编码、商品名称、适用车型、商品品牌及备注信息"/>&nbsp;&nbsp;&nbsp;
						<input id="search_btn" type="button" value="查 询" />&nbsp;&nbsp;&nbsp;</a>
					</td>
				  </tr>
			</table>
			<!--搜索栏结束-->
			&nbsp;
			<!--搜索结果开始-->
			<div class="result-content">
				<table  id="dg_tbkWarehourse" class="easyui-datagrid" title="仓库配件列表" style="width:auto;height:360px"
					data-options="rownumbers:false,singleSelect:true,collapsible:true,sortName:'',sortOrder:'desc',pagination:'true',url:'<%=path%>/search_tbkWarehourse_getListData.do',method:'post',onLoadSuccess:function(dataObj){redirectToLogin(dataObj);}">
					<thead>
						<tr>
<!-- 						<th data-options="field:'detail',width:50,align:'center'">明细</th>-->
							<th data-options="field:'simple_name',width:120,sortable:'true',align:'center'">配件编码</th>
							<th data-options="field:'parts_name',width:160,sortable:'true',align:'left'">配件名称</th>
							<th data-options="field:'car_model_name',width:160,sortable:'true',align:'left'">适用车型</th>
							<th data-options="field:'parts_brand',width:120,sortable:'true',align:'left'">品牌</th>
							<th data-options="field:'size',width:120,sortable:'true',align:'left'">规格</th>
							<th data-options="field:'unit',width:120,sortable:'true',align:'left'">单位</th>
							<th data-options="field:'parts_num',width:120,sortable:'true',align:'left'">数量</th>
							<th data-options="field:'warn_num',width:120,sortable:'true',align:'left'">预警数</th>
							<th data-options="field:'parts_price',width:80,sortable:'true',align:'left'">上次采购价</th>
							<th data-options="field:'price_factor',width:80,sortable:'true',align:'left'">定价系数</th>
							<th data-options="field:'out_parts_price',width:80,sortable:'true',align:'left'">销售价</th>
							<th data-options="field:'memo',width:120,sortable:'true',align:'right'">备注</th>
							<th data-options="field:'edit',width:50,align:'center'">编辑</th> 
						</tr>
					</thead>
				</table>
			</div>
			<!--搜索栏结果end-->
		</div>
	</article>
        
        
        
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
	
//仓库相关
var tbkWarehourse_list ={};
jQuery(function($){
	var path = '<%=path%>';
	
    //定义一览页面查询的参数(JSON格式)
    tbkWarehourse_list.buildJsonQueryParams = function(){
		  	var searchContent =	{
		  		//标准查询部分
			 	pageNumber:$('div#mainPanle #dg_tbkWarehourse').datagrid('options').pageNumber,
		  		//页面查询框部分
					search_content :$("input[name='search_content']").val(), 

		    };
			var searchContentStr  =JSON.stringify(searchContent);
			//传到到后台的URL 必须先编码化
			return encodeURI(searchContentStr);
	 };
	 
	
	//重新按照条件刷新查询一览内容
	$('div#mainPanle #search_btn').click(function(){
		var searchContentStr = tbkWarehourse_list.buildJsonQueryParams();		
		var url = path+"/search_tbkWarehourse_getListData.do?searchContentStr="+searchContentStr; 
		//重新赋值url 属性
        $("#dg_tbkWarehourse").datagrid("options").url=url;
        $("#dg_tbkWarehourse").datagrid("reload"); 
	});
	
	//定义修改信息的参数(JSON格式)
    tbkWarehourse_list.buildJsonEditParams = function(){
		  	var editContent =	{
		  		//页面输入框部分
				ware_parts_id :$("input[name='edit_ware_parts_id']").val(), 
				simple_name :$("input[name='edit_simple_name']").val(), 
				price_factor :$("input[name='edit_price_factor']").val(), 
				parts_price :$("input[name='edit_parts_price']").val(), 
				out_parts_price :$("input[name='edit_out_parts_price']").val(), 
				parts_num :$("input[name='edit_parts_num']").val(), 
				unit :$("input[name='edit_unit']").val(), 
				warn_num :$("input[name='edit_warn_num']").val(), 
				memo :$("input[name='edit_memo']").val(), 
		    };
			var editContentStr  =JSON.stringify(editContent);
			//传到到后台的URL 必须先编码化
			return encodeURI(editContentStr);
	 };
	 
	/*
	 * 点击编辑按钮弹出编辑信息框
	 pkid:主键
	 */
	tbkWarehourse_list.updateFormSubmit = function(pkid){
	    var edit_form_id ='#editTbkWarehourseFrom';
		$('<div id="dialog_holder"></div>').dialog({
		    title: '库存编辑',
		    width: 800,
		    height: 380,
		    href: path+"/page/warehourse/tbkWarehourse/editTbkWarehoursePage.jsp?pkid="+pkid,
		    modal: true,
		    method: "POST",
		    async: false,
			onClose: function(){
				$(this).dialog("destroy");
			},
		    buttons: [{
		    	text: "保 存",
		    	handler: function(e){
		    		var edit_warn_num = $("input[name='edit_warn_num']").val();
		    		if(isEmpty(edit_warn_num)){
		    			if(!isPInt(edit_warn_num)){
		    				$.messager.alert("操作提示","库存预警数输入有误，请重新输入！");
		    				return;
		    			}
		    		}
				    //验证不能为空的信息是否都填充
				    if($(edit_form_id).form("validate")==true){
					  	$.messager.progress(); 
			      		$.ajax({
							type:'POST',
							cache:false,
					 		async: false,
						    url:'<%=path%>'+"/edit_TbkWarehourse.do?editContentStr="+tbkWarehourse_list.buildJsonEditParams(),
							success:function(data){
							        $.messager.progress('close');
									data = $.parseJSON(data);
									if(data.error){
									    $.messager.alert("操作提示",data.message);
									    return;
									}else{
									    $.messager.alert("操作提示",data.message);
										$('#dialog_holder').dialog('close');
								        $("#dg_tbkWarehourse").datagrid("reload"); 
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
						 		url:path+"/del_TbkWarehourse.do?pkid="+pkid,    
						 		success:function(data){
						 		 	data = $.parseJSON(data);
						 		 	if(data.error){
									    $.messager.alert("操作提示",data.message);
									    return;
						 		 	}else{
									    $.messager.alert("操作提示",data.message);
							 			$("#dialog_holder").dialog("destroy");
							 		    $("#dialog_holder").dialog("close");
							 		    $("#dg_tbkWarehourse").datagrid("reload"); 
						 		 	}		 		 		
						 		}
						 	});
						   } ,
						   id:'del_cancel'}
						   ]
						});
	} ;
	
	//详细
	tbkWarehourse_list.detailFormSubmit = function(pkid){
		$('<div id="dialog_holder"></div>').dialog({
		    title: '库存明细',
		    width: 800,
		    height: 350,
		    href: path+"/page/warehourse/tbkWarehourse/detailTbkWarehoursePage.jsp?pkid="+pkid, 
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
			        $("#dg_tbkWarehourse").datagrid("reload"); 
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
		     url:'<%=path%>'+"/obtainTbSysrUserDto.do",
			 success:function(data){
						data = $.parseJSON(data);
					    $("#search_person_in_charge").combobox({	
					    			data:data.rows,
					    			valueField:'id', 
					    			textField:'text' ,
					    		});
				}
		});	
		
		
			/*
	 * 充值金额输入后
	 */
	$('div#addTbkWarehourseOrder #add_give_pay').keyup(function(){		
		 var give_pay = this.value;	
		 var ought_pay = $("input[name='add_ought_pay']").val(); 
		 if(checkIsNum(give_pay)&&checkIsNum(ought_pay)){
		 	var real_pay = parseFloat(ought_pay)- parseFloat(give_pay);
		 	if(real_pay<0){
		 		$.messager.alert("操作提示","应付金额不能小于0！");
		 	}else{
				$("input[name='add_real_pay']").val(real_pay);
		 	}
		 }
		 
			
	});
	
});	
	
	</script>
</body>
</html>
