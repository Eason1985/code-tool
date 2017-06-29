<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
<%@ include file="/page/common/commonhead.jsp"%>
<title>eason科技CRM-登录</title>
<link type="text/css" rel="stylesheet" href="<%=cssPath%>/login.css" />
<script type="text/javascript" src="<%=jsPath%>/jquery/jquery.min.js"></script>
<script type='text/javascript' src='<%=jsPath%>/jquery/jquery.easyui.min.js'></script>
<script type="text/javascript" src="<%=jsPath%>/cookie.js"></script>
<script type="text/javascript" src="<%=jsPath%>/json/basedata.json"></script>
<script type='text/javascript' src='<%=jsPath%>/easyui.validator.ext.js'></script>
<script type="text/javascript" src="<%=jsPath%>/json/json2.min.js"></script>
<script type='text/javascript' src='<%=jsPath%>/ajaxProcessUtil.js'></script>
<script type='text/javascript' src='<%=jsPath%>/progress.js'></script>
<script type='text/javascript' src='<%=jsPath%>/privCity.js'></script>
<script type="text/javascript" src="<%=jsPath%>/json/basedata.json"></script>
<script type='text/javascript' src='<%=jsPath%>/datagrid-detailview.js'></script>
<script type="text/javascript" src="<%=jsPath%>/easyui-lang-zh_CN.js"></script>
<link type="text/css" rel="stylesheet" href="<%=cssPath%>/page-messager.css" />
</head>

<body>
<div class="message-wrapper">
	<div class="message-content">
		<i class="icon icon-error"></i>
		<span class="message-text">${error}</span>
		<div style="text-align:center" >
		 <input id='backbutton' type="button" value="返回(3s)" style="background:;color:red;" />
		</div>
	</div>
</div>
<script type="text/javascript">
var success_list = {}; 
$(document).ready(function(){ 		
	success_list.backRepairlBill = function (){		
		window.location.replace('<%=path%>'+'/login.jsp');
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
