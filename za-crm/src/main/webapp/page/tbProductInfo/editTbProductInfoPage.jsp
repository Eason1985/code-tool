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
			<form id="editTbProductInfoFrom" name="editTbProductInfoFrom" method='post'>
				<div class="search-panel-bd">
							<input type="hidden" id="edit_id" name="edit_id"   />
					<table class="search-table">
								 <tr>
									<th class="wd-20"><label>产品名称</label></th>
									<td>
											<input type="text" id="edit_product_name" name="edit_product_name" class="easyui-validatebox"   data-options="required:true,invalidMessage:'产品名称不能为空',missingMessage:'产品名称不能为空'"  style="width:200px;" />
									</td>
									<th class="wd-20"><label>场景说明</label></th>
									<td>
											<input type="text" id="edit_scene_explain" name="edit_scene_explain" class="easyui-validatebox"   data-options="required:true,invalidMessage:'场景说明不能为空',missingMessage:'场景说明不能为空'"  style="width:200px;" />
									</td>
								  </tr>
								 <tr>
									<th class="wd-20"><label>渠道ID</label></th>
									<td>
											<input type="text" id="edit_channel_id" name="edit_channel_id" class="easyui-validatebox"   data-options="required:true,invalidMessage:'渠道ID不能为空',missingMessage:'渠道ID不能为空'"  style="width:200px;" />
									</td>
									<th class="wd-20"><label>立项时间</label></th>
									<td>
										<input type="text" id="edit_project_time" name="edit_project_time"   class="easyui-datebox" data-options="required:true,invalidMessage:'立项时间格式必须为yyyy-mm-dd',missingMessage:'立项时间格式必须为yyyy-mm-dd'"  style="width:200px;"/>
									</td>
								 </tr>
								 <tr>
									<th class="wd-20"><label>业务类型</label></th>
									<td>
											<select id="edit_bis_type" name="edit_bis_type" class="easyui-combobox"  style="width:200px;">
												<option value="">未选择</option>
													<option value="0">0-对公业务</option>
													<option value="1">1-交通金融</option>
													<option value="2">2-投资产品业务</option>
													<option value="3">3-消费金融</option>
											</select>
									</td>
									<th class="wd-20"><label>项目管理人</label></th>
									<td>
											<input type="text" id="edit_project_manager" name="edit_project_manager" class="easyui-validatebox"   data-options="required:true,invalidMessage:'项目管理人不能为空',missingMessage:'项目管理人不能为空'"  style="width:200px;" />
									</td>
								  </tr>
								 <tr>
									<th class="wd-20"><label>产品经理</label></th>
									<td>
											<input type="text" id="edit_product_manager" name="edit_product_manager" class="easyui-validatebox"   data-options="required:true,invalidMessage:'产品经理不能为空',missingMessage:'产品经理不能为空'"  style="width:200px;" />
									</td>
									<th class="wd-20"><label>商务条件说明</label></th>
									<td>
											<input type="text" id="edit_business_condition_explain" name="edit_business_condition_explain" class="easyui-validatebox"   data-options="required:true,invalidMessage:'商务条件说明不能为空',missingMessage:'商务条件说明不能为空'"  style="width:200px;" />
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
	


	<%String pkid=request.getParameter("pkid"); %>
	$.ajax({
		type:'POST',
		url:'<%=path%>'+"/editDetail_TbProductInfo.do?pkid="+'<%=pkid%>',    
		success:function(data){
		 	data = $.parseJSON(data);
		 	var message = data.message;
					$("#edit_id").val(message.id); 
					$("#edit_product_name").val(message.product_name); 
					$("#edit_scene_explain").val(message.scene_explain); 
					$("#edit_channel_id").val(message.channel_id); 
					$("#edit_project_time").val(message.project_time); 
		 			$("#edit_bis_type").combobox('select', message.bis_type);
					$("#edit_project_manager").val(message.project_manager); 
					$("#edit_product_manager").val(message.product_manager); 
					$("#edit_business_condition_explain").val(message.business_condition_explain); 
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