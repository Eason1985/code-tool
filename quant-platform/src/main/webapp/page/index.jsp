<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head >
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>众矿系统</title>
    <link rel="stylesheet" type="text/css" href="css/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="css/themes/icon.css" />
    <link rel="stylesheet" type="text/css" href="css/default.css" />
    <script type="text/javascript" src="js/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery/jquery.easyui.min.js"></script>
    <script type='text/javascript' src='<%=basePath%>js/acj-ajax.js'></script>
    <style type="text/css">
    	.rightcorner {
			height:40px; width:520px;float: right; padding-right:5px; text-align:right; line-height:40px;
		    color:#FFF;
		}
    </style>
</head>
<body class="easyui-layout" style="overflow-y: hidden" scroll="no" onbeforeunload="RunOnBeforeUnload()" onunload="RunOnUnload()">  
    <div data-options="region:'north',border:false,split:true" style="overflow: hidden; height: 60px;width:auto;
        background: url(images/page/daohang.jpg) #7f99be repeat-x center 100%;
        background-size:100% 100%;
        line-height: 30px; color: #fff; font-family: Verdana, 微软雅黑,黑体">
         <span style="padding-left: 10px;
                font-size: 16px; float: left;"><!-- 众矿系统 -->
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
        
        <table cellSpacing=10px cellPadding=10px width=1300 border=0 >
        
        <tr>
        <td colspan="6">
        <label style="font-size:18px;line-height:10px">&nbsp;&nbsp;工作提醒</label>
        </td>
        </tr>
        <tr>
        <td ><label style="font-size:15px;line-height:10px">&nbsp;&nbsp;保险提醒：</label><a href="#" id="0001"
						_status="" onclick="addTab('保险提醒','<%=basePath%>/page/business/repair/tbrRepairCarInfo/searchRepairCarInsur.jsp');"><label id="insur"></label></a>
        </td>
        <td ><label style="font-size:15px;line-height:10px">&nbsp;&nbsp;保养提醒：</label><a href="#" id="0001"
						_status="" onclick="addTab('保养提醒','<%=basePath%>/page/business/repair/tbrRepairCarInfo/searchRepairCarRoutine.jsp');"><label id="routine"></label></a>
        </td>
        <td ><label style="font-size:15px;line-height:10px">&nbsp;&nbsp;年审提醒：</label><a href="#" id="0001"
						_status="" onclick="addTab('年审提醒','<%=basePath%>/page/business/repair/tbrRepairCarInfo/searchRepairCarYearLimit.jsp');"><label id="yearLimit"></label></a>
        </td><td></td><td></td><td></td>
        </tr>
        <tr>
        <td colspan="6"><label style="font-size:18px;line-height:10px">&nbsp;&nbsp;快捷方式</label>
        </td>
        </tr>
        <tr>
		<td colspan="6"><table>
				<tr>
				 	<td style="width:150px;"><a href="#" id="0001"
						_status="" onclick="addTab('接待开单','<%=basePath%>/page/business/repair/manageBill/searchCustinfoForBill.jsp')"><img src="./images/page/repair_start.png" style="width:60px;height:60px;"></img></a>
			        </td>
			        <td style="width:150px;"><a href="#" id="0001"
						_status="" onclick="addTab('管理工单','<%=basePath%>/page/business/repair/repairmanage/searchTbrRepairOrderPage.jsp');"><img src="./images/page/pay_start.png" style="width:60px;height:60px;"></img></a>
			        </td>
			        <td style="width:150px;"><a href="#" id="0001"
						_status="" onclick="addTab('会员办卡','<%=basePath%>/page/business/repair/custManager/buyVipBankCard.jsp');"><img src="./images/page/buy_card.png"  style="width:60px;height:60px;"></img></a>
			        </td>
			        <td style="width:150px;"><a href="#" id="0001"
						_status="" onclick="addTab('会员报表','<%=basePath%>/page/business/repair/custManager/vipCardAll.jsp')"><img src="./images/page/card_info.png" style="width:60px;height:60px;"></img></a>
			        </td>
			        <td style="width:150px;"><a href="#" id="0001"
						_status="" onclick="addTab('客户资料','<%=basePath%>/page/business/repair/custManager/repairCustList.jsp');"><img src="./images/page/cust_info.png" style="width:60px;height:60px;"></img></a>
			        </td>
			        <td style="width:150px;"><a href="#" id="0001"
						_status="" onclick="addTab('经营报表','<%=basePath%>/statistics/managementAnalysis.jsp');"><img src="./images/page/jingyingbaobiao.png" style="width:60px;height:60px;"></img></a>
			        </td>
			        <td style="width:150px;"><a href="#" id="0001"
						_status="" onclick="addTab('微信互动','<%=basePath%>/page/business/repair/tbrBespeakOrderInfo/searchTbrBespeakOrderInfoPage.jsp');"><img src="./images/page/weixinhudong.png" style="width:60px;height:60px;"></img></a>
			        </td>
				</tr>
			</table>
			<table>
				<tr>
				 	<td style="width:150px;">&nbsp;接待开单</td>
			        <td style="width:150px;">&nbsp;管理工单</td>
			        <td style="width:150px;">&nbsp;会员办卡</td>
			        <td style="width:150px;">&nbsp;会员报表</td>
			        <td style="width:150px;">&nbsp;客户资料</td>
			        <td style="width:150px;">&nbsp;经营报表</td>
			        <td style="width:150px;">&nbsp;&nbsp;微信互动</td>
				</tr>
			</table>
        </td>
        </tr><tr>
        <td colspan="6"><label style="font-size:18px;line-height:10px">&nbsp;&nbsp;消息中心</label>
        </td>
        </tr>
        <tr>
         <td ><label style="font-size:15px;line-height:10px">&nbsp;&nbsp;未处理消息：</label><a href="#" id="0001"
						_status="" onclick="addTab('预约未处理消息','<%=basePath%>/page/business/repair/tbrBespeakOrderInfo/searchTbrBespeakOrderInfoOne.jsp');"><label id="statu0"></label></a>
        </td>
        <td ><label style="font-size:15px;line-height:10px">&nbsp;&nbsp;预约成功消息：</label><a href="#" id="0001"
						_status="" onclick="addTab('预约已处理消息','<%=basePath%>/page/business/repair/tbrBespeakOrderInfo/searchTbrBespeakOrderInfoTwo.jsp');"><label id="statu1"></label></a>
        </td>
        <td ><label style="font-size:15px;line-height:10px">&nbsp;&nbsp;预约失败消息：</label><a href="#" id="0001"
						_status="" onclick="addTab('预约失败消息','<%=basePath%>/page/business/repair/tbrBespeakOrderInfo/searchTbrBespeakOrderInfoThree.jsp');"><label id="statu2"></label></a>
        </td><td></td><td></td><td></td>
        </tr>
	    <tr >
		    <td colspan="6">
		     	<table  id="" class="easyui-datagrid" title="最近工单" style="width:1250px;height:300px"
									data-options="rownumbers:false,singleSelect:true,collapsible:true,sortName:'',sortOrder:'desc',pagination:'true',url:'<%=path%>/search_tbrRepairOrder_getListData.do',method:'post',onLoadSuccess:function(dataObj){redirectToLogin(dataObj);}">
							<thead>
								<tr>
									<th data-options="field:'order_state',width:120,sortable:'true',align:'right'">订单状态</th>
									<th data-options="field:'order_type',width:120,sortable:'true',align:'right'">业务类型</th>
									<th data-options="field:'cust_name',width:120,sortable:'true',align:'right'">客户姓名</th>
									<th data-options="field:'send_updater',width:120,sortable:'true',align:'right'">送修人姓名</th>
									<th data-options="field:'rescue',width:120,sortable:'true',align:'right'">施救费</th>
									<th data-options="field:'parts_price',width:120,sortable:'true',align:'right'">配件费用</th>
									<th data-options="field:'work_price',width:120,sortable:'true',align:'right'">工时费用</th>
									<th data-options="field:'end_time',width:120,sortable:'true',align:'right'">预计交车时间</th>
									<th data-options="field:'send_time',width:120,sortable:'true',align:'right'">送修时间</th>
									<th data-options="field:'memo',width:220,sortable:'true',align:'right'">备注</th>
								</tr>
							</thead>
						</table>
		        </td>
	        </tr>
        </table>
        
        
        
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

</script>
</body>
</html>
