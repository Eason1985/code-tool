<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ include file="/page/common/commonhead.jsp"%>
<title>无标题文档</title>
<link type="text/css" rel="stylesheet" href="<%=cssPath%>/page-messager.css" />
</head>
	<%String message=new String(request.getParameter("message").getBytes("ISO8859-1"),"UTF-8"); %>	
<body>
<div class="message-wrapper">
	<div class="message-content">
		<table>
		<tr><td>&nbsp;</td></tr>
		<tr><td><span class="message-text"><%=message%></span></td></tr>
		<tr><td>&nbsp;</td></tr>
		<tr><td align="center"><input id="add_btn" type="button" value="确定" onclick="logout()" style="background:LightBlue;color:red;width:50px"/></td></tr>
		<tr><td>&nbsp;</td></tr>
		</table>
	</div>
</div>
<script type="text/javascript">
	function logout(){
		top.location.href="<%=path%>"+"/login.jsp";
//		window.location.href = "<%=path%>"+"/login.jsp";
	}
</script>
</body>
</html>
