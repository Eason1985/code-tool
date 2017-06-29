<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ include file="/page/common/easyui_head.jsp"%>
<title></title>
</head>
<body>
<div class="content-body" id="addTbSysrRole">
	<div class="search-panel toggle-panel">
		<div class="search-panel-content">
			<form id="addTbSysrRoleFrom" name="addTbSysrRoleFrom" method="post">
				<div class="search-panel-bd">
				 <table class="search-table">
						 <tr>
							<th class="wd-20"><label>角色名</label></th>
							<td>
								<input type="text" id="tbSysrRoleDto.role_name" name="tbSysrRoleDto.role_name" class="easyui-validatebox" data-options="required:true,invalidMessage:'角色名不能为空',missingMessage:'角色名不能为空'" maxlength="10"  style="color:black;width:180px;height:30px;border:solid 1px #B2DFEE"/>
							</td>
						 	<th class="wd-20"><label>角色组</label></th>
							<td>
								<input type="text" id="tbSysrRoleDto.role_group" name="tbSysrRoleDto.role_group" class="easyui-validatebox" maxlength="20" placeholder="" style="color:black;width:180px;height:30px;border:solid 1px #B2DFEE"/>
							</td>
							</tr>
							<tr>
								<th class="wd-20"><label>角色描述</label></th>
								<td rowspan='2'>
									<input type="text" id="tbSysrRoleDto.description" name="tbSysrRoleDto.description" class="easyui-validatebox" maxlength="100"  style="width:400px;"/>
								</td>
						  </tr>
				  </table>
				</div>
			</form>
		</div>
	</div>
</div>
</body>
</html>