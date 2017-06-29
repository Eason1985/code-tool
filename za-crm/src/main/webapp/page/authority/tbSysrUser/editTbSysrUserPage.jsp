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
			<form id="editTbSysrUserFrom" name="editTbSysrUserFrom" method='post'>
				<div class="search-panel-bd">
							<input type="hidden" id="sysr_user_id" name="tbSysrUserDto.sysr_user_id" value="${tbSysrUserDto.sysr_user_id}" />
					<table class="search-table">
								 <tr>
									<th class="wd-20"><label>登录名称</label></th>
									<td>
										<input type="text" id="user_code" name="tbSysrUserDto.user_code"   class="easyui-validatebox" data-options="invalidMessage:'登录名称不能为空',required:true,missingMessage:'登录名称不能为空'" style="color:black;width:180px;height:30px;border:solid 1px #B2DFEE"/>
									</td>
									<th class="wd-20"><label>用户姓名</label></th>
									<td>
										<input type="text" id="user_name" name="tbSysrUserDto.user_name"   class="easyui-validatebox" data-options="invalidMessage:'用户名称不能为空',required:true,missingMessage:'用户名称不能为空'" style="color:black;width:180px;height:30px;border:solid 1px #B2DFEE"/>
									</td>
								  </tr>
								 <tr>
									<th class="wd-20"><label>手机号</label></th>
									<td>
										<input type="text" id="mobile" name="tbSysrUserDto.mobile"   class="easyui-validatebox" data-options="invalidMessage:'手机号码不能为空',required:true,missingMessage:'手机号码不能为空'" style="color:black;width:180px;height:30px;border:solid 1px #B2DFEE"/>
									</td>
									<th class="wd-20"><label>用户状态</label></th>
									<td>
										<select id="user_state" name="tbSysrUserDto.user_state"  class="easyui-combobox" editable="false" style="color:black;width:180px;height:30px;border:solid 1px #B2DFEE">
											<option value="0">正常</option>
											<option value="1">密码锁定</option>
											<option value="2">无效</option>
										</select>
									</td>
									
								</tr>
								 <tr>
									<th class="wd-20"><label>密码输错次数</label></th>
									<td  >
										<input type="text" id="pass_error_num" name="tbSysrUserDto.pass_error_num"  class="easyui-validatebox" data-options="invalidMessage:'',required:false,missingMessage:''"   style="color:black;width:180px;height:30px;border:solid 1px #B2DFEE"/>
									</td>
									<th class="wd-20"><label>电子邮箱</label></th>
									<td >
										<input type="text" id="email" name="tbSysrUserDto.email"   class="easyui-validatebox" data-options="invalidMessage:'电子邮箱不能为空',required:false,missingMessage:'电子邮箱不能为空'" validType="email" style="color:black;width:180px;height:30px;border:solid 1px #B2DFEE"/>
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
		url:'<%=path%>'+"/editDetail_TbSysrUser.do?pkid="+'<%=pkid%>',    
		success:function(data){
		 	data = $.parseJSON(data);
		 	var message = data.message;
				$("#sysr_user_id").val(message.sysr_user_id); 
				$("#user_code").val(message.user_code); 
				$("#user_name").val(message.user_name); 
				$("#password").val(message.password); 
				$("#mobile").val(message.mobile); 
				$("#email").val(message.email); 
				$("#last_login_time").val(message.last_login_time); 
				$("#login_count").val(message.login_count); 
				$("#pass_error_num").val(message.pass_error_num); 
				$("#user_state").combobox('select', message.user_state);
				$("#init_pass_update").val(message.init_pass_update); 
				$("#create_pass_time").val(message.create_pass_time); 
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