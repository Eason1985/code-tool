<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ include file="/page/common/easyui_head.jsp"%>
<title>模板内容页</title>
</head>
<body>
<div class="content-body" id="addTbSceneOprationInfo">
	<div class="search-panel toggle-panel">
		<div class="search-panel-content">
			<form id="addTbSceneOprationInfoFrom" name="addTbSceneOprationInfoFrom" method="post">
				<div class="search-panel-bd">
				 <table class="search-table">
						 <tr>
							<th class="wd-20"><label>场景</label></th>
							<td>
									<select id="add_scene_id" name="add_scene_id" class="easyui-combobox"  style="width:200px;">
									</select>
							</td>
							<th class="wd-20"><label>开始日期</label></th>
							<td>
									<input type="text" id="add_begain_date" name="add_begain_date" class="easyui-validatebox"   data-options="required:true,invalidMessage:'格式为:YYYYMMDD',missingMessage:'格式为:YYYYMMDD'"  style="width:200px;" />
							</td>
						  </tr>
						 <tr>
							<th class="wd-20"><label>结束日期</label></th>
							<td>
									<input type="text" id="add_end_date" name="add_end_date" class="easyui-validatebox"   data-options="required:true,invalidMessage:'格式为:YYYYMMDD',missingMessage:'格式为:YYYYMMDD'"  style="width:200px;" />
							</td>
							<th class="wd-20"><label>时间区间简称(如:1月,1季度等)</label></th>
							<td>
									<input type="text" id="add_time_intervar_simle_name" name="add_time_intervar_simle_name" class="easyui-validatebox"   data-options="required:true,invalidMessage:'time_intervar_simle_name不能为空',missingMessage:'time_intervar_simle_name不能为空'"  style="width:200px;" />
							</td>
						  </tr>
						 <tr>
							<th class="wd-20"><label>预计资产规模</label></th>
							<td>
								<input type="text" id="add_plan_asset_size" name="add_plan_asset_size" class="easyui-validatebox"  data-options="required:true,validType:'number[2,16]',invalidMessage:'plan_asset_size必须为数字',missingMessage:'plan_asset_size必须为数字'" style="width:200px;"/>
							</td>
							<th class="wd-20"><label>实际资产规模</label></th>
							<td>
								<input type="text" id="add_reality_asset_size" name="add_reality_asset_size" class="easyui-validatebox"  data-options="required:true,validType:'number[2,16]',invalidMessage:'reality_asset_size必须为数字',missingMessage:'reality_asset_size必须为数字'" style="width:200px;"/>
							</td>
						  </tr>
						 <tr>
							<th class="wd-20"><label>预计保费</label></th>
							<td>
								<input type="text" id="add_plan_premium" name="add_plan_premium" class="easyui-validatebox"  data-options="required:true,validType:'number[2,16]',invalidMessage:'plan_premium必须为数字',missingMessage:'plan_premium必须为数字'" style="width:200px;"/>
							</td>
							<th class="wd-20"><label>实际保费</label></th>
							<td>
								<input type="text" id="add_reality_premium" name="add_reality_premium" class="easyui-validatebox"  data-options="required:true,validType:'number[2,16]',invalidMessage:'reality_premium必须为数字',missingMessage:'reality_premium必须为数字'" style="width:200px;"/>
							</td>
						  </tr>
						 <tr>
							<th class="wd-20"><label>用户数(对应预计业务规模发生额)</label></th>
							<td>
								<input type="text" id="add_occur_cust_num" name="add_occur_cust_num" class="easyui-validatebox"  data-options="required:true,validType:'number[2,16]',invalidMessage:'occur_cust_num必须为数字',missingMessage:'occur_cust_num必须为数字'" style="width:200px;"/>
							</td>
							<th class="wd-20"><label>用户数(对应预计业务规模余额)</label></th>
							<td>
								<input type="text" id="add_balance_cust_num" name="add_balance_cust_num" class="easyui-validatebox"  data-options="required:true,validType:'number[2,16]',invalidMessage:'balance_cust_num必须为数字',missingMessage:'balance_cust_num必须为数字'" style="width:200px;"/>
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
						$("#add_scene_id").combobox({	
					    			data:data.rows,
					    			valueField:'id', 
					    			textField:'text' ,
					    		});
				}
		});	
}); 
</script>
</body>
</html>