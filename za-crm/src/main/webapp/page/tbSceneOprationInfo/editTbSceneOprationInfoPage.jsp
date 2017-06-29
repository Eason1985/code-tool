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
			<form id="editTbSceneOprationInfoFrom" name="editTbSceneOprationInfoFrom" method='post'>
				<div class="search-panel-bd">
							<input type="hidden" id="edit_id" name="edit_id"   />
					<table class="search-table">
								 <tr>
									<th class="wd-20"><label>场景</label></th>
									<td>
											<select id="edit_scene_id" name="edit_scene_id" class="easyui-combobox"  style="width:200px;">
											</select>
									</td>
								  </tr>
								 <tr>
									<th class="wd-20"><label>开始日期</label></th>
									<td>
											<input type="text" id="edit_begain_date" name="edit_begain_date" class="easyui-validatebox"   data-options="required:true,invalidMessage:'格式为:YYYYMMDD',missingMessage:'格式为:YYYYMMDD'"  style="width:200px;" />
									</td>
								  </tr>
								 <tr>
									<th class="wd-20"><label>结束日期</label></th>
									<td>
											<input type="text" id="edit_end_date" name="edit_end_date" class="easyui-validatebox"   data-options="required:true,invalidMessage:'格式为:YYYYMMDD',missingMessage:'格式为:YYYYMMDD'"  style="width:200px;" />
									</td>
								  </tr>
								 <tr>
									<th class="wd-20"><label>时间区间简称(如:1月,1季度等)</label></th>
									<td>
											<input type="text" id="edit_time_intervar_simle_name" name="edit_time_intervar_simle_name" class="easyui-validatebox"   data-options="required:true,invalidMessage:'时间区间简称(如:1月,1季度等)不能为空',missingMessage:'时间区间简称(如:1月,1季度等)不能为空'"  style="width:200px;" />
									</td>
								  </tr>
								 <tr>
									<th class="wd-20"><label>预计资产规模</label></th>
									<td>
										<input type="text" id="edit_plan_asset_size" name="edit_plan_asset_size"   class="easyui-validatebox" data-options="required:true,validType:'number[2,16]',invalidMessage:'预计资产规模必须为数字',missingMessage:'预计资产规模必须为数字'" style="width:200px;"/>
									</td>
								  </tr>
								 <tr>
									<th class="wd-20"><label>实际资产规模</label></th>
									<td>
										<input type="text" id="edit_reality_asset_size" name="edit_reality_asset_size"   class="easyui-validatebox" data-options="required:true,validType:'number[2,16]',invalidMessage:'实际资产规模必须为数字',missingMessage:'实际资产规模必须为数字'" style="width:200px;"/>
									</td>
								  </tr>
								 <tr>
									<th class="wd-20"><label>预计保费</label></th>
									<td>
										<input type="text" id="edit_plan_premium" name="edit_plan_premium"   class="easyui-validatebox" data-options="required:true,validType:'number[2,16]',invalidMessage:'预计保费必须为数字',missingMessage:'预计保费必须为数字'" style="width:200px;"/>
									</td>
								  </tr>
								 <tr>
									<th class="wd-20"><label>实际保费</label></th>
									<td>
										<input type="text" id="edit_reality_premium" name="edit_reality_premium"   class="easyui-validatebox" data-options="required:true,validType:'number[2,16]',invalidMessage:'实际保费必须为数字',missingMessage:'实际保费必须为数字'" style="width:200px;"/>
									</td>
								  </tr>
								 <tr>
									<th class="wd-20"><label>用户数(对应预计业务规模发生额)</label></th>
									<td>
										<input type="text" id="edit_occur_cust_num" name="edit_occur_cust_num"   class="easyui-validatebox" data-options="required:true,validType:'number[2,16]',invalidMessage:'用户数(对应预计业务规模发生额)必须为数字',missingMessage:'用户数(对应预计业务规模发生额)必须为数字'" style="width:200px;"/>
									</td>
								  </tr>
								 <tr>
									<th class="wd-20"><label>用户数(对应预计业务规模余额)</label></th>
									<td>
										<input type="text" id="edit_balance_cust_num" name="edit_balance_cust_num"   class="easyui-validatebox" data-options="required:true,validType:'number[2,16]',invalidMessage:'用户数(对应预计业务规模余额)必须为数字',missingMessage:'用户数(对应预计业务规模余额)必须为数字'" style="width:200px;"/>
									</td>
								  </tr>
								<tr>
									<th class="wd-20"><label>创建时间</label></th>
									<td>
										<input type="text" id="edit_gmt_created" name="edit_gmt_created"   class="easyui-datebox" data-options="required:true,invalidMessage:'创建时间格式必须为yyyy-mm-dd',missingMessage:'创建时间格式必须为yyyy-mm-dd'"  style="width:200px;"/>
									</td>
								 </tr>
								<tr>
									<th class="wd-20"><label>修改时间</label></th>
									<td>
										<input type="text" id="edit_gmt_modified" name="edit_gmt_modified"   class="easyui-datebox" data-options="required:true,invalidMessage:'修改时间格式必须为yyyy-mm-dd',missingMessage:'修改时间格式必须为yyyy-mm-dd'"  style="width:200px;"/>
									</td>
								 </tr>
								 <tr>
									<th class="wd-20"><label>创建人</label></th>
									<td>
											<input type="text" id="edit_creator" name="edit_creator" class="easyui-validatebox"   data-options="required:true,invalidMessage:'创建人不能为空',missingMessage:'创建人不能为空'"  style="width:200px;" />
									</td>
								  </tr>
								 <tr>
									<th class="wd-20"><label>修改人</label></th>
									<td>
											<input type="text" id="edit_modifier" name="edit_modifier" class="easyui-validatebox"   data-options="required:true,invalidMessage:'修改人不能为空',missingMessage:'修改人不能为空'"  style="width:200px;" />
									</td>
								  </tr>
								 <tr>
									<th class="wd-20"><label>是否删除</label></th>
									<td>
											<input type="text" id="edit_is_deleted" name="edit_is_deleted" class="easyui-validatebox"   data-options="required:true,invalidMessage:'是否删除不能为空',missingMessage:'是否删除不能为空'"  style="width:200px;" />
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
		url:'<%=path%>'+"/editDetail_TbSceneOprationInfo.do?pkid="+'<%=pkid%>',    
		success:function(data){
		 	data = $.parseJSON(data);
		 	var message = data.message;
					$("#edit_id").val(message.id); 
		 			$("#edit_scene_id").combobox('select', message.scene_id);
					$("#edit_begain_date").val(message.begain_date); 
					$("#edit_end_date").val(message.end_date); 
					$("#edit_time_intervar_simle_name").val(message.time_intervar_simle_name); 
					$("#edit_plan_asset_size").val(message.plan_asset_size); 
					$("#edit_reality_asset_size").val(message.reality_asset_size); 
					$("#edit_plan_premium").val(message.plan_premium); 
					$("#edit_reality_premium").val(message.reality_premium); 
					$("#edit_occur_cust_num").val(message.occur_cust_num); 
					$("#edit_balance_cust_num").val(message.balance_cust_num); 
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