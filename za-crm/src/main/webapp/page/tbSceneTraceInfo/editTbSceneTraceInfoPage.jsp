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
			<form id="editTbSceneTraceInfoFrom" name="editTbSceneTraceInfoFrom" method='post'>
				<div class="search-panel-bd">
							<input type="hidden" id="edit_id" name="edit_id"   />
					<table class="search-table">
								 <tr>
									<th class="wd-20"><label>场景</label></th>
									<td>
											<select id="edit_scene_id" name="edit_scene_id" class="easyui-combobox"  style="width:200px;">
											</select>
									</td>
									<th class="wd-20"><label>跟踪时间</label></th>
									<td>
										<input type="text" id="edit_trace_time" name="edit_trace_time"   class="easyui-datebox" data-options="required:true,invalidMessage:'跟踪时间格式必须为yyyy-mm-dd',missingMessage:'跟踪时间格式必须为yyyy-mm-dd'"  style="width:200px;"/>
									</td>
								 </tr>
								 <tr>
									<th class="wd-20"><label>跟踪人</label></th>
									<td>
											<input type="text" id="edit_tracer" name="edit_tracer" class="easyui-validatebox"   data-options="required:true,invalidMessage:'跟踪人不能为空',missingMessage:'跟踪人不能为空'"  style="width:200px;" />
									</td>
									<th class="wd-20"><label>跟踪描述</label></th>
									<td>
											<input type="text" id="edit_trace_describe" name="edit_trace_describe" class="easyui-validatebox"   data-options="required:true,invalidMessage:'跟踪描述不能为空',missingMessage:'跟踪描述不能为空'"  style="width:200px;" />
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
		     url:'<%=path%>'+"/obtainTbSceneInfo.do",
			 success:function(data){
						data = $.parseJSON(data);
						$("#edit_scene_id").combobox({	
					    			data:data.rows,
					    			valueField:'id', 
					    			textField:'text' ,
					    		});
				}
		});	


	<%String pkid=request.getParameter("pkid"); %>
	$.ajax({
		type:'POST',
		url:'<%=path%>'+"/editDetail_TbSceneTraceInfo.do?pkid="+'<%=pkid%>',    
		success:function(data){
		 	data = $.parseJSON(data);
		 	var message = data.message;
					$("#edit_id").val(message.id); 
		 			$("#edit_scene_id").combobox('select', message.scene_id);
					$("#edit_trace_time").val(message.trace_time); 
					$("#edit_tracer").val(message.tracer); 
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