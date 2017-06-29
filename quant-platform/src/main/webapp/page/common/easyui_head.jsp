<!--THIS IS COMMON HEAD CODE-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="expires" content="0">
<!--------------------------------------------------------------->
<%
String path = request.getScheme() + "://" + request.getServerName()
+ ":" + request.getServerPort() + request.getContextPath();
	String basePath = path + "/";
	String cssPath = path + "/css";
	String jsPath = path + "/js";
	String jspPath = path + "/jsp";
	String imgPath = path + "/images";
%>
<!--------------------------------------------------------------->

<link rel="stylesheet" type="text/css" href="<%=cssPath%>/baseUI.css">
<link rel="stylesheet" type="text/css" href="<%=cssPath%>/progress.css">
<link rel="stylesheet" type="text/css" href="<%=cssPath%>/default.css">
<link rel="stylesheet" type="text/css" href="<%=cssPath%>/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=cssPath%>/themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=cssPath%>/easyui/demo.css">
<link rel="stylesheet" type="text/css" href="<%=cssPath%>/easyui/portal.css">
<link rel="stylesheet" type="text/css" href="<%=cssPath%>/progress.css">
<link rel="stylesheet" type="text/css" href="<%=cssPath%>/zTreeStyle.css">
<style>
    .datagrid-header-row td{background-color:;color:black;font-size:13px;}
</style>
<script type='text/javascript' src='<%=basePath%>js/acj-ajax.js'></script>
<script type='text/javascript' src='<%=basePath%>js/set.js'></script>
<script type='text/javascript' src='<%=basePath%>js/jquery/jquery.js'></script>
<script type='text/javascript' src='<%=basePath%>js/jquery/jquery.ztree.core.js'></script>
<script type='text/javascript' src='<%=basePath%>js/jquery/jquery.ztree.excheck.js'></script>
<script type='text/javascript' src='<%=basePath%>js/jquery/jquery.ztree.exedit.js'></script>
<script type='text/javascript' src='<%=basePath%>js/jquery/jquery.easyui.min.js'></script>
<script type='text/javascript' src='<%=basePath%>js/easyui.validator.ext.js'></script>
<script type="text/javascript" src="<%=jsPath%>/ui.lib.js"></script>
<script type="text/javascript" src="<%=basePath%>js/json/json2.min.js"></script>
<script type='text/javascript' src='<%=basePath%>js/ajaxProcessUtil.js'></script>
<script type='text/javascript' src='<%=basePath%>js/progress.js'></script>
<script type='text/javascript' src='<%=basePath%>js/privCity.js'></script>
<script type="text/javascript" src="<%=basePath%>js/json/basedata.json"></script>
<script type='text/javascript' src='<%=basePath%>js/datagrid-detailview.js'></script>
<script type="text/javascript" src="<%=basePath%>js/easyui-lang-zh_CN.js"></script>

<script type="text/javascript" src="<%=basePath%>js/tools/checkUtils.js"></script>
<script type='text/javascript' src='<%=basePath%>js/tools/inputchk.js'></script>
<script type='text/javascript' src='<%=basePath%>js/tools/md5.js'></script>
<script type='text/javascript' src='<%=basePath%>js/common.js'></script>
<script type="text/javascript">

//获取当前日期
function getCurrentDate(){
	var currDate = '';
   	var curr_time = new Date();
	currDate = curr_time.getFullYear()+"-";
	var month = curr_time.getMonth()+1;
	if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
	currDate += month+"-";
	var strDate = curr_time.getDate();
	if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
	currDate += strDate;
	return currDate;
}

//获取当前时间
function getCurrentTime(){
	var myDate = new Date();
	return myDate.toLocaleString( );        //获取日期与时间;
}
</script>


<style type="text/css">
.l-btn-text{
	line-height:18px;
}
</style>