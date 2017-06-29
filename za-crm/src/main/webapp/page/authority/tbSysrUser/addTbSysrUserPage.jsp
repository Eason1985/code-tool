<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ include file="/page/common/easyui_head.jsp"%>
<title></title>
</head>
<body>
<div class="content-body" id="addTbSysrUser">
	<div class="search-panel toggle-panel">
		<div class="search-panel-content">
			<form id="addTbSysrUserFrom" name="addTbSysrUserFrom" method="post">
				<div class="search-panel-bd">
				 <table class="search-table">
						 <tr>
							<th class="wd-20"><label>登录名称</label></th>
							<td>
								<input type="text" id="tbSysrUserDto.user_code" name="tbSysrUserDto.user_code" class="easyui-validatebox" data-options="required:true,invalidMessage:'登录名称不能为空',missingMessage:'登录名称不能为空'" maxlength="32" style="color:black;width:180px;height:30px;border:solid 1px #B2DFEE"/>
							</td>
						   
							<th class="wd-20"><label>用户姓名</label></th>
							<td>
								<input type="text" id="tbSysrUserDto.user_name" name="tbSysrUserDto.user_name" class="easyui-validatebox" data-options="required:true,invalidMessage:'用户姓名不能为空',missingMessage:'用户姓名不能为空'" maxlength="8" style="color:black;width:180px;height:30px;border:solid 1px #B2DFEE"/>
							</td>
						   </tr>
						 <tr> 
							<th class="wd-20"><label>初始密码</label></th>
							<td>
								<input type="text" id="tbSysrUserDto.password" name="tbSysrUserDto.password" class="easyui-validatebox" data-options="required:true,invalidMessage:'初始密码不能为空',missingMessage:'初始密码不能为空'" maxlength="10"  style="color:black;width:180px;height:30px;border:solid 1px #B2DFEE"/>
							</td>
							<th class="wd-20"><label>确认密码</label></th>
							<td>
								<input type="text" id="tbSysrUserDto.password2" name="tbSysrUserDto.password2" class="easyui-validatebox" data-options="required:true,invalidMessage:'初始密码不能为空',missingMessage:'初始密码不能为空'" maxlength="10"  style="color:black;width:180px;height:30px;border:solid 1px #B2DFEE"/>
							</td>
						  </tr>
						 <tr> 
							 <th class="wd-20"><label>手机号</label></th>
							<td>
								<input type="text" id="tbSysrUserDto.mobile" name="tbSysrUserDto.mobile" class="easyui-validatebox" data-options="required:true,digits:true,invalidMessage:'手机号不能为空',missingMessage:'手机号必须为数字'" maxlength="11" style="color:black;width:180px;height:30px;border:solid 1px #B2DFEE"/>
							</td>
							<th class="wd-20"><label>用户状态</label></th>
							<td>
									<select id="tbSysrUserDto.user_state" class="easyui-combobox" editable="false" name="tbSysrUserDto.user_state"  style="color:black;width:180px;height:30px;border:solid 1px #B2DFEE">
											<option value="0">正常</option>
											<option value="1">密码锁定</option>
											<option value="2">无效</option>
									</select>
							</td>
						</tr>
						 <tr> 
							<th class="wd-20"><label>电子邮箱</label></th>
							<td colspan='3'>
								<input type="text" id="tbSysrUserDto.email" name="tbSysrUserDto.email" maxlength="20" style="color:black;width:180px;height:30px;border:solid 1px #B2DFEE"/>
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