<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ include file="/page/common/easyui_head.jsp"%>
<title>模板内容页</title>
</head>
<body>
<div class="content-body" id="addTbSceneTraceInfo">
	<div class="search-panel toggle-panel">
		<div class="search-panel-content">
			<form id="addTbSceneTraceInfoFrom" name="addTbSceneTraceInfoFrom" method="post">
				<div class="search-panel-bd">
				 <table class="search-table">
						 <tr>
							<th class="wd-20"><label>场景</label></th>
							<td>
									<select id="add_scene_id" name="add_scene_id" class="easyui-combobox"  style="width:200px;">
									</select>
							</td>
							<th class="wd-20"><label>跟踪时间</label></th>
							<td>
								<input type="text" id="add_trace_time" name="add_trace_time" class="easyui-datebox" data-options="required:true,invalidMessage:'trace_time格式必须为yyyy-mm-dd',missingMessage:'trace_time格式必须为yyyy-mm-dd'"  style="width:200px;"/>
							</td>
						 </tr>
						 <tr>
							<th class="wd-20"><label>跟踪人</label></th>
							<td>
									<input type="text" id="add_tracer" name="add_tracer" class="easyui-validatebox"   data-options="required:true,invalidMessage:'tracer不能为空',missingMessage:'tracer不能为空'"  style="width:200px;" />
							</td>
							<th class="wd-20"><label>跟踪描述</label></th>
							<td>
									<input type="text" id="add_trace_describe" name="add_trace_describe" class="easyui-validatebox"   data-options="required:true,invalidMessage:'trace_describe不能为空',missingMessage:'trace_describe不能为空'"  style="width:200px;" />
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