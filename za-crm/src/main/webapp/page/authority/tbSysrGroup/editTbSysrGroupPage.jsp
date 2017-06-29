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
			<form id="editTbSysrGroupFrom" name="editTbSysrGroupFrom" method='post'>
				<div class="search-panel-bd">
							<input type="hidden" id="group_id" name="tbSysrGroupDto.group_id" value="${tbSysrGroupDto.group_id}" />
					<table class="search-table">
								 <tr>
									<th class="wd-20"><label>组名</label></th>
									<td>
										<input type="text" id="group_name" name="tbSysrGroupDto.group_name"   class="easyui-validatebox" data-options="required:true,invalidMessage:'组名不能为空',missingMessage:'组名不能为空'" style="color:black;width:180px;height:30px;border:solid 1px #B2DFEE"/>
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
		url:'<%=path%>'+"/editDetail_TbSysrGroup.do?pkid="+'<%=pkid%>',    
		success:function(data){
		 	data = $.parseJSON(data);
		 	var message = data.message;
				$("#group_id").val(message.group_id); 
				$("#group_name").val(message.group_name); 
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