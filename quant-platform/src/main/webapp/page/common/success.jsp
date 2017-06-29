<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ include file="./easyui_head.jsp"%>
<title>无标题文档</title>
<link type="text/css" rel="stylesheet" href="<%=cssPath%>/page-messager.css" />
</head>

<body>
<div class="message-wrapper">
	<div class="message-content">
		<i class="icon icon-success"></i>
		<span class="message-text">执行成功！</span>
		<div style="text-align:center" >
		 <input id='backbutton' type="button" value="返回(3s)" style="background:;color:red;" />
		</div>
	</div>
	
</div>
<script type="text/javascript">
var success_list = {}; 
$(document).ready(function(){ 		
	success_list.backRepairlBill = function (){		
		var toPage = sessionStorage.getItem("toSuccessPageFromPage") ;
		if("manageBillForSpa" === toPage){
			window.location.replace('<%=path%>'+'/page/business/repair/manageBillForSpa/searchCustinfoForBill.jsp');
		}else if("manageBill" === toPage){
			window.location.replace('<%=path%>'+'/page/business/repair/manageBill/searchCustinfoForBill.jsp');
		}
	};
	
	$("#backbutton").click(function(){
		success_list.backRepairlBill();
	});
});
var i = 2 ; 
setInterval("forInterval()", 1000);       //第二个参数是时间，单位毫秒	
function forInterval(){
	if(i == 0){
		success_list.backRepairlBill() ; 
		return ; 
	}
	$('#backbutton').val("返回("+i+"s)");
	i-- ; 
};
</script>
</body>
</html>
