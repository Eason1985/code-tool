<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ include file="/page/common/easyui_head.jsp"%>
<title>模板内容页</title>
</head>
<body>
<div class="content-body" id="addTbProductInfo">
	<div class="search-panel toggle-panel">
		<div class="search-panel-content">
			<form id="addTbProductInfoFrom" name="addTbProductInfoFrom" method="post">
				<div class="search-panel-bd">
				 <table class="search-table">
						 <tr>
							<th class="wd-20"><label>产品名称</label></th>
							<td>
									<input type="text" id="add_product_name" name="add_product_name" class="easyui-validatebox"   data-options="required:true,invalidMessage:'product_name不能为空',missingMessage:'product_name不能为空'"  style="width:200px;" />
							</td>
							<th class="wd-20"><label>场景说明</label></th>
							<td>
									<input type="text" id="add_scene_explain" name="add_scene_explain" class="easyui-validatebox"   data-options="required:true,invalidMessage:'scene_explain不能为空',missingMessage:'scene_explain不能为空'"  style="width:200px;" />
							</td>
						  </tr>
						 <tr>
							<th class="wd-20"><label>渠道ID</label></th>
							<td>
									<input type="text" id="add_channel_id" name="add_channel_id" class="easyui-validatebox"   data-options="required:true,invalidMessage:'channel_id不能为空',missingMessage:'channel_id不能为空'"  style="width:200px;" />
							</td>
							<th class="wd-20"><label>立项时间</label></th>
							<td>
								<input type="text" id="add_project_time" name="add_project_time" class="easyui-datebox" data-options="required:true,invalidMessage:'project_time格式必须为yyyy-mm-dd',missingMessage:'project_time格式必须为yyyy-mm-dd'"  style="width:200px;"/>
							</td>
						 </tr>
						 <tr>
							<th class="wd-20"><label>业务类型</label></th>
							<td>
									<select id="add_bis_type" class="easyui-combobox" name="add_bis_type" style="width:200px;">
											<option value="0">0-对公业务</option>
											<option value="1">1-交通金融</option>
											<option value="2">2-投资产品业务</option>
											<option value="3">3-消费金融</option>
									</select>
							</td>
							<th class="wd-20"><label>项目管理人</label></th>
							<td>
									<input type="text" id="add_project_manager" name="add_project_manager" class="easyui-validatebox"   data-options="required:true,invalidMessage:'project_manager不能为空',missingMessage:'project_manager不能为空'"  style="width:200px;" />
							</td>
						  </tr>
						 <tr>
							<th class="wd-20"><label>产品经理</label></th>
							<td>
									<input type="text" id="add_product_manager" name="add_product_manager" class="easyui-validatebox"   data-options="required:true,invalidMessage:'product_manager不能为空',missingMessage:'product_manager不能为空'"  style="width:200px;" />
							</td>
							<th class="wd-20"><label>商务条件说明</label></th>
							<td>
									<input type="text" id="add_business_condition_explain" name="add_business_condition_explain" class="easyui-validatebox"   data-options="required:true,invalidMessage:'business_condition_explain不能为空',missingMessage:'business_condition_explain不能为空'"  style="width:200px;" />
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
}); 
</script>
</body>
</html>