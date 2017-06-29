<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ include file="/page/common/easyui_head.jsp"%>
<title>模板内容页</title>
<script type='text/javascript' src='<%=basePath%>js/common.js'></script>
</head>
<body>
<div class="content-body">
	<div class="search-panel toggle-panel">
		<div class="search-panel-content">
				<div class="search-panel-bd">
					<table class="search-table">
					   		 <tr>
								<th class="wd-20"><label>场景</label></th>
								<td>
									<input type="text" id="detail_scene_id" name="detail_scene_id"   style="width:200px;border-width: 0" readonly="true" />
								</td>
								<th class="wd-20"><label>跟踪时间</label></th>
								<td>
									<input type="text" id="detail_trace_time" name="detail_trace_time" style="width:200px;border-width: 0" readonly="true" />
								</td>
							 </tr>
							 <tr>
								<th class="wd-20"><label>跟踪人</label></th>
								<td>
									<input type="text" id="detail_tracer" name="detail_tracer"   style="width:200px;border-width: 0" readonly="true" />
								</td>
								<th class="wd-20"><label>跟踪描述</label></th>
								<td>
									<input type="text" id="detail_trace_describe" name="detail_trace_describe"   style="width:200px;border-width: 0" readonly="true" />
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
	//页面加载时带出相关信息
	<%String pkid=request.getParameter("pkid"); %>
	$.ajax({
		type:'POST',
		url:'<%=path%>'+"/detail_TbSceneTraceInfo.do?pkid="+'<%=pkid%>',    
		success:function(data){
		 	data = $.parseJSON(data);
		 	var message = data.message;
				$("#detail_id").val(message.id); 
				$("#detail_scene_id").val(message.scene_id); 
				$("#detail_trace_time").val(message.trace_time); 
				$("#detail_tracer").val(message.tracer); 
				$("#detail_trace_describe").val(message.trace_describe); 
				$("#detail_gmt_created").val(message.gmt_created); 
				$("#detail_gmt_modified").val(message.gmt_modified); 
				$("#detail_creator").val(message.creator); 
				$("#detail_modifier").val(message.modifier); 
				$("#detail_is_deleted").val(message.is_deleted); 
		}
	});
}); 
</script>
</body>
</html>