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
								<th class="wd-20"><label>产品名称</label></th>
								<td>
									<input type="text" id="detail_product_name" name="detail_product_name"   style="width:200px;border-width: 0" readonly="true" />
								</td>
								<th class="wd-20"><label>场景说明</label></th>
								<td>
									<input type="text" id="detail_scene_explain" name="detail_scene_explain"   style="width:200px;border-width: 0" readonly="true" />
								</td>
							  </tr>
							 <tr>
								<th class="wd-20"><label>渠道ID</label></th>
								<td>
									<input type="text" id="detail_channel_id" name="detail_channel_id"   style="width:200px;border-width: 0" readonly="true" />
								</td>
								<th class="wd-20"><label>立项时间</label></th>
								<td>
									<input type="text" id="detail_project_time" name="detail_project_time" style="width:200px;border-width: 0" readonly="true" />
								</td>
							 </tr>
							 <tr>
								<th class="wd-20"><label>业务类型</label></th>
								<td>
									<input type="text" id="detail_bis_type" name="detail_bis_type"   style="width:200px;border-width: 0" readonly="true" />
								</td>
								<th class="wd-20"><label>项目管理人</label></th>
								<td>
									<input type="text" id="detail_project_manager" name="detail_project_manager"   style="width:200px;border-width: 0" readonly="true" />
								</td>
							  </tr>
							 <tr>
								<th class="wd-20"><label>产品经理</label></th>
								<td>
									<input type="text" id="detail_product_manager" name="detail_product_manager"   style="width:200px;border-width: 0" readonly="true" />
								</td>
								<th class="wd-20"><label>商务条件说明</label></th>
								<td>
									<input type="text" id="detail_business_condition_explain" name="detail_business_condition_explain"   style="width:200px;border-width: 0" readonly="true" />
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
		url:'<%=path%>'+"/detail_TbProductInfo.do?pkid="+'<%=pkid%>',    
		success:function(data){
		 	data = $.parseJSON(data);
		 	var message = data.message;
				$("#detail_id").val(message.id); 
				$("#detail_product_name").val(message.product_name); 
				$("#detail_scene_explain").val(message.scene_explain); 
				$("#detail_channel_id").val(message.channel_id); 
				$("#detail_project_time").val(message.project_time); 
				$("#detail_bis_type").val(message.bis_type); 
				$("#detail_project_manager").val(message.project_manager); 
				$("#detail_product_manager").val(message.product_manager); 
				$("#detail_business_condition_explain").val(message.business_condition_explain); 
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