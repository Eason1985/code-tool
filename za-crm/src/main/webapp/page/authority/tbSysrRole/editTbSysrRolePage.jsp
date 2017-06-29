<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ include file="/page/common/easyui_head.jsp"%>
<title></title>
</head>
<body>
<div class="content-body">
	<div class="search-panel toggle-panel">
		<div class="search-panel-content">
			<form id="editTbSysrRoleFrom" name="editTbSysrRoleFrom" method='post'>
				<div class="search-panel-bd">
							<input type="hidden" id="sysr_role_id" name="tbSysrRoleDto.sysr_role_id" value="${tbSysrRoleDto.sysr_role_id}" />
					<table class="search-table">
								 <tr>
									<th class="wd-20"><label>角色名</label></th>
									<td>
										<input type="text" id="role_name" name="tbSysrRoleDto.role_name"   class="easyui-validatebox" data-options="required:true,invalidMessage:'角色名不能为空',missingMessage:'角色名不能为空'" style="color:black;width:180px;height:30px;border:solid 1px #B2DFEE"/>
									</td>
									<th class="wd-20"><label>角色组</label></th>
									<td>
										<input type="text" id="role_group" name="tbSysrRoleDto.role_group"   class="easyui-validatebox" data-options="required:true,invalidMessage:'角色描述不能为空',missingMessage:'角色描述不能为空'" style="color:black;width:180px;height:30px;border:solid 1px #B2DFEE"/>
									</td>
								</tr>
								<tr rowspan="2">
									<th class="wd-20"><label>角色描述</label></th>
									<td>
										<input type="text" id="description" name="tbSysrRoleDto.description"   class="easyui-validatebox" data-options="required:true,invalidMessage:'角色描述不能为空',missingMessage:'角色描述不能为空'" style="color:black;width:180px;height:30px;border:solid 1px #B2DFEE"/>
									</td>
								  </tr>
					</table>
				</div>
			</form>
		</div>
	</div>
</div>

<script type="text/javascript">
var forwardPath = '<%=path%>';
$(document).ready(function(){ 
	<%String pkid=request.getParameter("pkid"); %>
	acjAjax({
		type:'POST',
		url:'<%=path%>'+"/editDetail_TbSysrRole.do?pkid="+'<%=pkid%>',    
		success:function(data){
		 	data = $.parseJSON(data);
		 	var message = data.message;
				$("#sysr_role_id").val(message.sysr_role_id); 
				$("#role_name").val(message.role_name); 
				$("#description").val(message.description); 
				$("#role_group").val(message.role_group); 
				$("#netno").val(message.netno); 
				$("#createtime").val(message.createtime); 
				$("#updatetime").val(message.updatetime); 
				$("#create_user_id").val(message.create_user_id); 
				$("#update_user_id").val(message.update_user_id); 
		}
	});	
}); 
</script>
</body>
</html>