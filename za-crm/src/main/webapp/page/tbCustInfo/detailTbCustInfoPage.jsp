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
								<th class="wd-20"><label>客户名称</label></th>
								<td>
									<input type="text" id="detail_cust_name" name="detail_cust_name"   style="width:200px;border-width: 0" readonly="true" />
								</td>
								<th class="wd-20"><label>BD对接人</label></th>
								<td>
									<input type="text" id="detail_bd_on_access" name="detail_bd_on_access"   style="width:200px;border-width: 0" readonly="true" />
								</td>
							  </tr>
							 <tr>
								<th class="wd-20"><label>地点</label></th>
								<td>
									<input type="text" id="detail_address" name="detail_address"   style="width:200px;border-width: 0" readonly="true" />
								</td>
								<th class="wd-20"><label>产品对接人</label></th>
								<td>
									<input type="text" id="detail_product_on_access" name="detail_product_on_access"   style="width:200px;border-width: 0" readonly="true" />
								</td>
							  </tr>
							 <tr>
								<th class="wd-20"><label>状态</label></th>
								<td>
									<input type="text" id="detail_status" name="detail_status"   style="width:200px;border-width: 0" readonly="true" />
								</td>
								<th class="wd-20"><label>商务条件</label></th>
								<td>
									<input type="text" id="detail_business_condition" name="detail_business_condition"   style="width:200px;border-width: 0" readonly="true" />
								</td>
							  </tr>
							 <tr>
								<th class="wd-20"><label>备注</label></th>
								<td  colspan='3'>
									<input type="text" id="detail_memo" name="detail_memo"   style="width:200px;border-width: 0" readonly="true" />
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
							 <tr >
							 	<th class="wd-20"><label>是否删除</label></th>
								<td colspan='3'>
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
		url:'<%=path%>'+"/detail_TbCustInfo.do?pkid="+'<%=pkid%>',    
		success:function(data){
		 	data = $.parseJSON(data);
		 	var message = data.message;
				$("#detail_id").val(message.id); 
				$("#detail_cust_name").val(message.cust_name); 
				$("#detail_bd_on_access").val(message.bd_on_access); 
				$("#detail_address").val(message.address); 
				$("#detail_product_on_access").val(message.product_on_access); 
				$("#detail_status").val(message.status); 
				$("#detail_business_condition").val(message.business_condition); 
				$("#detail_memo").val(message.memo); 
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