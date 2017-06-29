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
			<form id="editTbSysrResourceFrom" name="editTbSysrResourceFrom" method='post'>
				<div class="search-panel-bd">
							<input type="hidden" id="resource_id" name="tbSysrResourceDto.resource_id" value="${tbSysrResourceDto.resource_id}" />
					<table class="search-table">
								 <tr>
									<th class="wd-20"><label>资源名称</label></th>
									<td>
										<input type="text" id="resource_name" name="tbSysrResourceDto.resource_name"   class="easyui-validatebox" data-options="required:true,invalidMessage:'资源名称不能为空',missingMessage:'资源名称不能为空'" style="color:black;width:180px;height:30px;border:solid 1px #B2DFEE"/>
									</td>
									<th class="wd-20"><label>资源地址</label></th>
									<td>
										<input type="text" id="resource_addr" name="tbSysrResourceDto.resource_addr"   class="easyui-validatebox" data-options="required:true,invalidMessage:'资源地址不能为空',missingMessage:'资源地址不能为空'" style="color:black;width:180px;height:30px;border:solid 1px #B2DFEE"/>
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
		url:'<%=path%>'+"/editDetail_TbSysrResource.do?pkid="+'<%=pkid%>',    
		success:function(data){
		 	data = $.parseJSON(data);
		 	var message = data.message;
				$("#resource_id").val(message.resource_id); 
				$("#resource_name").val(message.resource_name); 
				$("#resource_addr").val(message.resource_addr); 
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