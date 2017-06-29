<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ include file="/page/common/easyui_head.jsp"%>
<title></title>
</head>
<body>
<div class="content-body" id="addTbSysrRelationResSelf">
	<div class="search-panel toggle-panel">
		<div class="search-panel-content">
			<form id="addTbSysrRelationResSelfFrom" name="addTbSysrRelationResSelfFrom" method="post">
				<div class="search-panel-bd">
				 <table class="search-table">
						 <tr>
							<th class="wd-20"><label>父资源</label></th>
							<td>
									<select id="add_parent_res_id" name="add_parent_res_id" class="easyui-combobox" editable="false" style="color:black;width:180px;height:30px;border:solid 1px #B2DFEE">
									</select>
							</td>
							<th class="wd-20"><label>子资源</label></th>
							<td>
									<select id="add_child_res_id" name="add_child_res_id" class="easyui-combobox" editable="false" style="color:black;width:180px;height:30px;border:solid 1px #B2DFEE">
									</select>
							</td>
						  </tr>
						 <tr>
							<th class="wd-20"><label>优先级</label></th>
							<td colspan="3">
								<input type="text" id="add_priority" name="add_priority" class="easyui-numberbox" data-options="required:true,invalidMessage:'优先级不能为空',missingMessage:'优先级不能为空'" maxlength="2" style="color:black;width:180px;height:30px;border:solid 1px #B2DFEE"/>
							</td>
						  </tr>
				  </table>
				</div>
			</form>
		</div>
	</div>
</div>

<script type="text/javascript">
var forwardPath = '<%=path%>';
$(document).ready(function(){ 
			acjAjax({
			 type:'POST',
			 cache:false,
			 async: false,
		     url:'<%=path%>'+"/obtainTbSysrResourceDto.do",
			 success:function(data){
						data = $.parseJSON(data);
						$("#add_parent_res_id").combobox({	
					    			data:data.rows,
					    			valueField:'id', 
					    			textField:'text' ,
					    		});
				}
		});	
			acjAjax({
			 type:'POST',
			 cache:false,
			 async: false,
		     url:'<%=path%>'+"/obtainTbSysrResourceDto.do",
			 success:function(data){
						data = $.parseJSON(data);
						$("#add_child_res_id").combobox({	
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