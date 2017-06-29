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
<div id="div_authority"  >
	 <div title="组管理">
	 	 组管理
	 </div>
	 <div title="角色管理">
	 	 角色管理
	 </div>
	 <div title="资源管理">
	 	资源管理
	 </div>
	 
	 
</div>
  
  <script>
  $(function(){
  	$("#div_authority").tabs({
  		plain:true ,
  		fit:true,
  	
  	
  	}); 
  	
  	
  
  
  
  
  }) ; 
  
  
  </script>
<%@ include file="/page/common/footer.jsp"%>
</body>
</html>