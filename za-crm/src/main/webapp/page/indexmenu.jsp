<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<c:forEach  var="ctree" items="${menuTree.children}">
	<c:if test="${ ctree.isLeaf == false  }">
		<c:set var="menuTree" value="${ctree}" scope="request" />
		<ul class="easyui-tree" >
			<c:import url="./indexmenu.jsp" />
		</ul>
	</c:if>
	<c:if test="${ctree.isLeaf == true }">
		<li data-options="iconCls:''">
			<a href="#" onclick="addTab('${ctree.text}','<%=basePath%>${ctree.resource_addr}')">${ctree.text}</a>
		</li>
	</c:if>
</c:forEach>