<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ include file="/page/common/easyui_head.jsp"%>
<title>模板内容页</title>
</head>
<body>
<div class="content-body" id="addTbTraceInfo">
	<div class="search-panel toggle-panel">
		<div class="search-panel-content">
			<form id="addTbTraceInfoFrom" name="addTbTraceInfoFrom" method="post">
				<div class="search-panel-bd">
				 <table class="search-table">
						 <tr>
							<th class="wd-20"><label>渠道信息</label></th>
							<td>
									<input type="text" id="add_channel_info" name="add_channel_info" class="easyui-validatebox"   data-options="required:true,invalidMessage:'channel_info不能为空',missingMessage:'channel_info不能为空'"  style="width:200px;" />
							</td>
							<th class="wd-20"><label>合作业务</label></th>
							<td>
									<input type="text" id="add_business" name="add_business" class="easyui-validatebox"   data-options="required:true,invalidMessage:'business不能为空',missingMessage:'business不能为空'"  style="width:200px;" />
							</td>
						  </tr>
						 <tr>
							<th class="wd-20"><label>跟踪描述</label></th>
							<td colspan='3'>
									<textarea   rows="3" cols="20" id="add_trace_describe"></textarea>
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
		     url:'<%=path%>'+"/obtainTbCustInfo.do",
			 success:function(data){
						data = $.parseJSON(data);
						$("#add_cust_id").combobox({	
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