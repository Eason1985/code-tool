<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ include file="/page/common/easyui_head.jsp"%>
<title>模板内容页</title>
</head>
<body>
<div class="content-body" id="addTbCustInfo">
	<div class="search-panel toggle-panel">
		<div class="search-panel-content">
			<form id="addTbCustInfoFrom" name="addTbCustInfoFrom" method="post">
				<div class="search-panel-bd">
				 <table class="search-table">
						 <tr>
							<th class="wd-20"><label>客户名称</label></th>
							<td>
									<input type="text" id="add_cust_name" name="add_cust_name" class="easyui-validatebox"   data-options="required:true,invalidMessage:'cust_name不能为空',missingMessage:'cust_name不能为空'"  style="width:200px;" />
							</td>
							<th class="wd-20"><label>BD对接人</label></th>
							<td>
									<select id="add_bd_on_access" name="add_bd_on_access" class="easyui-combobox"  style="width:200px;">
									</select>
							</td>
						  </tr>
						 <tr>
							<th class="wd-20"><label>地点</label></th>
							<td>
									<input type="text" id="add_address" name="add_address" class="easyui-validatebox"   data-options="required:true,invalidMessage:'address不能为空',missingMessage:'address不能为空'"  style="width:200px;" />
							</td>
							<th class="wd-20"><label>产品对接人</label></th>
							<td>
									<select id="add_product_on_access" name="add_product_on_access" class="easyui-combobox"  style="width:200px;">
									</select>
							</td>
						  </tr>
						 <tr>
							<th class="wd-20"><label>状态</label></th>
							<td>
									<select id="add_status" class="easyui-combobox" name="add_status" style="width:200px;">
											<option value="0">0-接触</option>
											<option value="1">1-搁置</option>
											<option value="2">2-合作</option>
											<option value="3">3-中断合作</option>
									</select>
							</td>
							<th class="wd-20"><label>商务条件</label></th>
							<td>
									<input type="text" id="add_business_condition" name="add_business_condition" class="easyui-validatebox"   data-options="required:true,invalidMessage:'business_condition不能为空',missingMessage:'business_condition不能为空'"  style="width:200px;" />
							</td>
						  </tr>
						 <tr rowspan='3'>
							<th class="wd-20"><label>备注</label></th>
							<td>
									<input type="text" id="add_memo" name="add_memo" class="easyui-validatebox"   data-options="required:true,invalidMessage:'memo不能为空',missingMessage:'memo不能为空'"  style="width:200px;" />
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
						$("#add_bd_on_access").combobox({	
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
						$("#add_product_on_access").combobox({	
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