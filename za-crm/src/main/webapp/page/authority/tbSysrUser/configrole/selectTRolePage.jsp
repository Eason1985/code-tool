<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/xml"  prefix = "x" %> 
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt"  prefix = "fmt" %> 
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql"  prefix = "sql" %> 
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions"  prefix = "fn" %> 
<%
	String pathUrl = request.getScheme() + "://" + request.getServerName()
			+ ":" + request.getServerPort() + request.getContextPath();
	String role_user_id = request.getParameter("role_user_id") ;
%>
<!--内容-->
<div id="div_selectRole_list">
	<article id="content" class="content" style="width:98%">
		<div class="content-body">
			<!--搜索栏开始-->
			<div class="search-panel toggle-panel">
				
				<div class="search-panel-content">
					<form id="configForm" name="configForm" method="post" >
						<!-- 
						<input type=""hidden"" id="role_res_id" name="role_res_id"  value="" style="color:black;width:180px;height:30px;border:solid 1px #B2DFEE"  />
						 -->
						<input type="hidden" id="role_user_id" name="role_user_id"  value="<%=role_user_id %>" style="color:black;width:180px;height:30px;border:solid 1px #B2DFEE"  />
						<div class="search-panel-bd">
							<table class="search-table">
								<tr>
									<th class="wd-20"><label>角色名称</label></th>
									<td>
										<input type="text" id="role_name" name="search_role_name"  value="" style="color:black;width:180px;height:30px;border:solid 1px #B2DFEE" data-options="required:true" />
									</td>
									<th class="wd-20"><label>角色分组</label></th>
									<td>
										<input type="text" id="role_group" name="search_role_group"  value="" style="color:black;width:180px;height:30px;border:solid 1px #B2DFEE" data-options="required:true" />
									</td>
								  </tr>
							</table>
						</div>
						<div class="search-btn-area">
							<input id="search_btn" type="button" value="查 询" />
						</div>
					</form>
				</div>
			</div>
			<!--搜索栏结束-->
			
			<!--搜索结果开始-->
			<div class="result-content">
				<table id="dg_select_tRole" style="width:auto;height:250px">
					<thead>
						<tr>
							<th data-options="field:'sysr_role_id',hidden:true">sysr_role_id</th>
							<th data-options="field:'chk',checkbox:true">sysr_role_id</th>
							<th data-options="field:'role_name',width:100,sortable:'true',align:'center'">角色名称</th>
							<th data-options="field:'role_group',width:200,sortable:'true',align:'center'">角色分组</th>
							<th data-options="field:'created_time',width:100,sortable:'true',align:'center'">创建日期</th>
							<th data-options="field:'create_user_id',width:100,sortable:'true',align:'center'">创建人</th>
							<th data-options="field:'description',width:200,sortable:'true',align:'center'">角色描述</th>
						</tr>
					</thead>
				</table>
			</div>
			<!--搜索栏结果end-->
		</div>
	</article>
</div>

<script>
var tSelectRole_list = {};
jQuery(function($){
	//定义构造查询
	tSelectRole_list.buildQueryParams=function(){
	    $('div#div_selectRole_list #dg_select_tRole').datagrid('options')
			.queryParams = {
				 'role_name':$("#div_selectRole_list input[name='search_role_name']").val(),
				 'role_group':$("#div_selectRole_list input[name='search_role_group']").val(),
				 'role_user_id':$("#role_user_id").val(),
			};
	};
	
	$("div#div_selectRole_list #dg_select_tRole").datagrid({
		sortName:'CREATED_DATE',
		sortOrder:'desc',
		pagination:'true',
		url:'<%=pathUrl%>/selectTRoleByUserId.do',
		method:'post',
		queryParams: {
			'role_name':$("#div_selectRole_list input[name='search_role_name']").val(),
			'role_group':$("#div_selectRole_list input[name='search_role_group']").val(),
			'role_user_id':$("#role_user_id").val(),
		}
	});
	 //重新按照条件刷新查询内容
	$('div#div_selectRole_list #search_btn').click(function(){
		tSelectRole_list.buildQueryParams();
		$('div#div_selectRole_list #dg_select_tRole').datagrid('reload');
	});
	
	
});

</script>