<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ include file="/page/common/easyui_head.jsp"%>
<title></title>
<script type='text/javascript' src='<%=basePath%>js/common.js'></script>
</head>
<body>
<div class="content-body">
	<div class="search-panel toggle-panel">
		<div class="search-panel-content">
				<div class="search-panel-bd">
					<table class="search-table">
					   		<tr>
								<th class="wd-20"><label>登录账号</label></th>
								<td>
									<input type="text" id="detail_user_code" name="detail_user_code"   style="width:200px;border-width: 0" readonly="true" />
								</td>
								<th class="wd-20"><label>用户姓名</label></th>
								<td>
									<input type="text" id="detail_user_name" name="detail_user_name"   style="width:200px;border-width: 0" readonly="true" />
								</td>
							  </tr>
							 <tr>
								<th class="wd-20"><label>登录密码</label></th>
								<td>
									<input type="text" id="detail_password" name="detail_password"   style="width:200px;border-width: 0" readonly="true" />
								</td>
								<th class="wd-20"><label>手机号</label></th>
								<td>
									<input type="text" id="detail_mobile" name="detail_mobile"   style="width:200px;border-width: 0" readonly="true" />
								</td>
							  </tr>
							 <tr>
								<th class="wd-20"><label>电子邮箱</label></th>
								<td>
									<input type="text" id="detail_email" name="detail_email"   style="width:200px;border-width: 0" readonly="true" />
								</td>
								<th class="wd-20"><label>上次登录时间</label></th>
								<td>
									<input type="text" id="detail_last_login_time" name="detail_last_login_time" style="width:200px;border-width: 0" readonly="true" />
								</td>
							 </tr>
							 <tr>
								<th class="wd-20"><label>登录次数</label></th>
								<td>
									<input type="text" id="detail_login_count" name="detail_login_count"   style="width:200px;border-width: 0" readonly="true" />
								</td>
								<th class="wd-20"><label>每次登录密码错误次数</label></th>
								<td>
									<input type="text" id="detail_pass_error_num" name="detail_pass_error_num"   style="width:200px;border-width: 0" readonly="true" />
								</td>
							  </tr>
							 <tr>
								<th class="wd-20"><label>用户状态</label></th>
								<td>
									<input type="text" id="detail_user_state" name="detail_user_state"   style="width:200px;border-width: 0" readonly="true" />
								</td>
								<th class="wd-20"><label>初始密码是否修改</label></th>
								<td>
									<input type="text" id="detail_init_pass_update" name="detail_init_pass_update"   style="width:200px;border-width: 0" readonly="true" />
								</td>
							  </tr>
							<!-- <tr>
								<th class="wd-20"><label>密码创建时间</label></th>
								<td>
									<input type="text" id="detail_create_pass_time" name="detail_create_pass_time" style="width:200px;border-width: 0" readonly="true" />
								</td>
								<th class="wd-20"><label>网点号</label></th>
								<td>
									<input type="text" id="detail_netno" name="detail_netno"   style="width:200px;border-width: 0" readonly="true" />
								</td>
							  </tr>
							<tr>
								<th class="wd-20"><label>创建时间</label></th>
								<td>
									<input type="text" id="detail_createtime" name="detail_createtime" style="width:200px;border-width: 0" readonly="true" />
								</td>
								<th class="wd-20"><label>修改时间</label></th>
								<td>
									<input type="text" id="detail_updatetime" name="detail_updatetime" style="width:200px;border-width: 0" readonly="true" />
								</td>
							 </tr>
							 <tr>
								<th class="wd-20"><label>创建人</label></th>
								<td>
									<input type="text" id="detail_create_user_id" name="detail_create_user_id"   style="width:200px;border-width: 0" readonly="true" />
								</td>
								<th class="wd-20"><label>更新人</label></th>
								<td>
									<input type="text" id="detail_update_user_id" name="detail_update_user_id"   style="width:200px;border-width: 0" readonly="true" />
								</td>
							  </tr> -->
					</table>
				</div>
			</form>
		</div>
	</div>
</div>

<script type="text/javascript">
var forwardPath = '<%=path%>';
$(document).ready(function(){ 
	//页面加载时带出相关信息
	<%String pkid=request.getParameter("pkid"); %>
	acjAjax({
		type:'POST',
		url:'<%=path%>'+"/detail_TbSysrUser.do?pkid="+'<%=pkid%>',    
		success:function(data){
		 	data = $.parseJSON(data);
		 	var message = data.message;
				$("#detail_sysr_user_id").val(message.sysr_user_id); 
				$("#detail_user_code").val(message.user_code); 
				$("#detail_user_name").val(message.user_name); 
				$("#detail_password").val(message.password); 
				$("#detail_mobile").val(message.mobile); 
				$("#detail_email").val(message.email); 
				$("#detail_last_login_time").val(message.last_login_time); 
				$("#detail_login_count").val(message.login_count); 
				$("#detail_pass_error_num").val(message.pass_error_num); 
				$("#detail_user_state").val(message.user_state); 
				$("#detail_init_pass_update").val(message.init_pass_update); 
				$("#detail_create_pass_time").val(message.create_pass_time); 
				$("#detail_netno").val(message.netno); 
				$("#detail_createtime").val(message.createtime); 
				$("#detail_updatetime").val(message.updatetime); 
				$("#detail_create_user_id").val(message.create_user_id); 
				$("#detail_update_user_id").val(message.update_user_id); 
		}
	});
}); 
</script>
</body>
</html>