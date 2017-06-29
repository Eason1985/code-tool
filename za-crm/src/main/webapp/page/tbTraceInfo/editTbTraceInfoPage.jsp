<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ include file="/page/common/easyui_head.jsp"%>
<title>模板内容页</title>
</head>
<body>
<div class="content-body">
	<div class="search-panel toggle-panel">
		<div class="search-panel-content">
			<form id="editTbTraceInfoFrom" name="editTbTraceInfoFrom" method='post'>
				<div class="search-panel-bd">
							<input type="hidden" id="edit_id" name="edit_id"   />
					<table class="search-table">
								 <tr>
									<th class="wd-20"><label>渠道信息</label></th>
									<td>
											<input type="text" id="edit_channel_info" name="edit_channel_info" class="easyui-validatebox"   data-options="required:true,invalidMessage:'渠道信息不能为空',missingMessage:'渠道信息不能为空'"  style="width:200px;" />
									</td>
									<th class="wd-20"><label>合作业务</label></th>
									<td>
											<input type="text" id="edit_business" name="edit_business" class="easyui-validatebox"   data-options="required:true,invalidMessage:'合作业务不能为空',missingMessage:'合作业务不能为空'"  style="width:200px;" />
									</td>
								  </tr>
								 <tr>
									<th class="wd-20"><label>跟踪描述d</label></th>
									<td colspan='3'>
										<textarea class="textarea easyui-validatebox" rows="3" cols="20" id="edit_trace_describe" name="edit_trace_describe" ></textarea>
									</td>
								 </tr>
					</table>
				</div>
			</form>
		</div>
	</div>
</div>

<script type="text/javascript">
$(document).ready(function(){ 
	
			$.ajax({
			 type:'POST',
			 cache:false,
			 async: false,
		     url:'<%=path%>'+"/obtainTbCustInfo.do",
			 success:function(data){
						data = $.parseJSON(data);
						$("#edit_cust_id").combobox({	
					    			data:data.rows,
					    			valueField:'id', 
					    			textField:'text' ,
					    		});
				}
		});	


	<%String pkid=request.getParameter("pkid"); %>
	$.ajax({
		type:'POST',
		url:'<%=path%>'+"/editDetail_TbTraceInfo.do?pkid="+'<%=pkid%>',    
		success:function(data){
		 	data = $.parseJSON(data);
		 	var message = data.message;
					$("#edit_id").val(message.id); 
		 			$("#edit_cust_id").combobox('select', message.cust_id);
		 			$("#edit_is_new").combobox('select', message.is_new);
					$("#edit_channel_info").val(message.channel_info); 
					$("#edit_business").val(message.business); 
					$("#edit_trace_describe").val(message.trace_describe); 
					$("#edit_gmt_created").val(message.gmt_created); 
					$("#edit_gmt_modified").val(message.gmt_modified); 
					$("#edit_creator").val(message.creator); 
					$("#edit_modifier").val(message.modifier); 
					$("#edit_is_deleted").val(message.is_deleted); 
		}
	});	
}); 
</script>
</body>
</html>