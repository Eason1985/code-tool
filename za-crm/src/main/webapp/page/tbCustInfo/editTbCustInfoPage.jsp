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
			<form id="editTbCustInfoFrom" name="editTbCustInfoFrom" method='post'>
				<div class="search-panel-bd">
							<input type="hidden" id="edit_id" name="edit_id"   />
					<table class="search-table">
								 <tr>
									<th class="wd-20"><label>客户名称</label></th>
									<td>
											<input type="text" id="edit_cust_name" name="edit_cust_name" class="easyui-validatebox"   data-options="required:true,invalidMessage:'客户名称不能为空',missingMessage:'客户名称不能为空'"  style="width:200px;" />
									</td>
									<th class="wd-20"><label>BD对接人</label></th>
									<td>
											<select id="edit_bd_on_access" name="edit_bd_on_access" class="easyui-combobox"  style="width:200px;">
											</select>
									</td>
								  </tr>
								 <tr>
									<th class="wd-20"><label>地点</label></th>
									<td>
											<input type="text" id="edit_address" name="edit_address" class="easyui-validatebox"   data-options="required:true,invalidMessage:'地点不能为空',missingMessage:'地点不能为空'"  style="width:200px;" />
									</td>
									<th class="wd-20"><label>产品对接人</label></th>
									<td>
											<select id="edit_product_on_access" name="edit_product_on_access" class="easyui-combobox"  style="width:200px;">
											</select>
									</td>
								  </tr>
								 <tr>
									<th class="wd-20"><label>状态</label></th>
									<td colspan='3'>
											<select id="edit_status" name="edit_status" class="easyui-combobox"  style="width:200px;">
												<option value="">未选择</option>
													<option value="0">0-接触</option>
													<option value="1">1-搁置</option>
													<option value="2">2-合作</option>
													<option value="3">3-中断合作</option>
											</select>
									</td>
								</tr>
								 <tr>
									<th class="wd-20"><label>商务条件</label></th>
									<td colspan='3'>
											<textarea  id="edit_business_condition" name="edit_business_condition"  ></textarea>
									</td>
								  </tr>
								 <tr>
									<th class="wd-20"><label>备注</label></th>
									<td colspan='3'>
											<textarea  id="edit_memo" name="edit_memo"  ></textarea>
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
		     url:'<%=path%>'+"/obtainTbSysrUserBD.do",
			 success:function(data){
						data = $.parseJSON(data);
						$("#edit_bd_on_access").combobox({	
					    			data:data.rows,
					    			valueField:'id', 
					    			textField:'text' ,
					    		});
				}
		});	
			$.ajax({
			 type:'POST',
			 cache:false,
			 async: false,
		     url:'<%=path%>'+"/obtainTbSysrUserProduct.do",
			 success:function(data){
						data = $.parseJSON(data);
						$("#edit_product_on_access").combobox({	
					    			data:data.rows,
					    			valueField:'id', 
					    			textField:'text' ,
					    		});
				}
		});	


	<%String pkid=request.getParameter("pkid"); %>
	$.ajax({
		type:'POST',
		url:'<%=path%>'+"/editDetail_TbCustInfo.do?pkid="+'<%=pkid%>',    
		success:function(data){
		 	data = $.parseJSON(data);
		 	var message = data.message;
					$("#edit_id").val(message.id); 
					$("#edit_cust_name").val(message.cust_name); 
		 			$("#edit_bd_on_access").combobox('select', message.bd_on_access);
					$("#edit_address").val(message.address); 
		 			$("#edit_product_on_access").combobox('select', message.product_on_access);
		 			$("#edit_status").combobox('select', message.status);
					$("#edit_business_condition").val(message.business_condition); 
					$("#edit_memo").val(message.memo); 
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