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
								<th class="wd-20"><label>开始日期</label></th>
								<td>
									<input type="text" id="detail_begain_date" name="detail_begain_date"   style="width:200px;border-width: 0" readonly="true" />
								</td>
							  </tr>
							 <tr>
								<th class="wd-20"><label>结束日期</label></th>
								<td>
									<input type="text" id="detail_end_date" name="detail_end_date"   style="width:200px;border-width: 0" readonly="true" />
								</td>
								<th class="wd-20"><label>时间区间简称(如:1月,1季度等)</label></th>
								<td>
									<input type="text" id="detail_time_intervar_simle_name" name="detail_time_intervar_simle_name"   style="width:200px;border-width: 0" readonly="true" />
								</td>
							  </tr>
							 <tr>
								<th class="wd-20"><label>预计资产规模</label></th>
								<td>
									<input type="text" id="detail_plan_asset_size" name="detail_plan_asset_size"   style="width:200px;border-width: 0" readonly="true" />
								</td>
							   
								<th class="wd-20"><label>实际资产规模</label></th>
								<td>
									<input type="text" id="detail_reality_asset_size" name="detail_reality_asset_size"   style="width:200px;border-width: 0" readonly="true" />
								</td>
							  </tr>
							 <tr>
								<th class="wd-20"><label>预计保费</label></th>
								<td>
									<input type="text" id="detail_plan_premium" name="detail_plan_premium"   style="width:200px;border-width: 0" readonly="true" />
								</td>
							   
								<th class="wd-20"><label>实际保费</label></th>
								<td>
									<input type="text" id="detail_reality_premium" name="detail_reality_premium"   style="width:200px;border-width: 0" readonly="true" />
								</td>
							  </tr>
							 <tr>
								<th class="wd-20"><label>用户数(对应预计业务规模发生额)</label></th>
								<td>
									<input type="text" id="detail_occur_cust_num" name="detail_occur_cust_num"   style="width:200px;border-width: 0" readonly="true" />
								</td>
							   
								<th class="wd-20"><label>用户数(对应预计业务规模余额)</label></th>
								<td>
									<input type="text" id="detail_balance_cust_num" name="detail_balance_cust_num"   style="width:200px;border-width: 0" readonly="true" />
								</td>
							  </tr>
							<tr>
								<th class="wd-20"><label>创建时间</label></th>
								<td>
									<input type="text" id="detail_gmt_created" name="detail_gmt_created" style="width:200px;border-width: 0" readonly="true" />
								</td>
							  
								<th class="wd-20"><label>修改时间</label></th>
								<td>
									<input type="text" id="detail_gmt_modified" name="detail_gmt_modified" style="width:200px;border-width: 0" readonly="true" />
								</td>
							 </tr>
							 <tr>
								<th class="wd-20"><label>创建人</label></th>
								<td>
									<input type="text" id="detail_creator" name="detail_creator"   style="width:200px;border-width: 0" readonly="true" />
								</td>
							   
								<th class="wd-20"><label>修改人</label></th>
								<td>
									<input type="text" id="detail_modifier" name="detail_modifier"   style="width:200px;border-width: 0" readonly="true" />
								</td>
							  </tr>
							 <tr>
								<th class="wd-20"><label>是否删除</label></th>
								<td>
									<input type="text" id="detail_is_deleted" name="detail_is_deleted"   style="width:200px;border-width: 0" readonly="true" />
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
		url:'<%=path%>'+"/detail_TbSceneOprationInfo.do?pkid="+'<%=pkid%>',    
		success:function(data){
		 	data = $.parseJSON(data);
		 	var message = data.message;
				$("#detail_id").val(message.id); 
				$("#detail_scene_id").val(message.scene_id); 
				$("#detail_begain_date").val(message.begain_date); 
				$("#detail_end_date").val(message.end_date); 
				$("#detail_time_intervar_simle_name").val(message.time_intervar_simle_name); 
				$("#detail_plan_asset_size").val(message.plan_asset_size); 
				$("#detail_reality_asset_size").val(message.reality_asset_size); 
				$("#detail_plan_premium").val(message.plan_premium); 
				$("#detail_reality_premium").val(message.reality_premium); 
				$("#detail_occur_cust_num").val(message.occur_cust_num); 
				$("#detail_balance_cust_num").val(message.balance_cust_num); 
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