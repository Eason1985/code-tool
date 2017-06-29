<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ include file="/page/common/easyui_head.jsp"%>
<title></title>
</head>
<body>
<div class="content-body">
	<div class="search-panel toggle-panel">
		<div class="search-panel-content">
			<form id="editTbSysrRelationResSelfFrom" name="editTbSysrRelationResSelfFrom" method='post'>
				<div class="search-panel-bd">
							<input type="hidden" id="edit_relation_res_self_id" name="edit_relation_res_self_id"   />
					<table class="search-table">
								 <tr>
									<th class="wd-20"><label>父资源</label></th>
									<td>
											<select id="edit_parent_res_id" name="edit_parent_res_id" class="easyui-combobox" editable="false" style="color:black;width:180px;height:30px;border:solid 1px #B2DFEE">
											</select>
									</td>
								  </tr>
								 <tr>
									<th class="wd-20"><label>优先级</label></th>
									<td>
										<input type="text" id="edit_priority" name="edit_priority"   class="easyui-validatebox" data-options="required:true,validType:'number[2,16]',invalidMessage:'优先级必须为数字',missingMessage:'优先级必须为数字'" style="color:black;width:180px;height:30px;border:solid 1px #B2DFEE"/>
									</td>
								  </tr>
								 <tr>
									<th class="wd-20"><label>子资源</label></th>
									<td>
											<select id="edit_child_res_id" name="edit_child_res_id" class="easyui-combobox" editable="false" style="color:black;width:180px;height:30px;border:solid 1px #B2DFEE">
											</select>
									</td>
								  </tr>
								 <tr>
									<th class="wd-20"><label>网点号</label></th>
									<td>
											<input type="text" id="edit_netno" name="edit_netno" class="easyui-validatebox"   data-options="required:true,invalidMessage:'网点号不能为空',missingMessage:'网点号不能为空'"  style="color:black;width:180px;height:30px;border:solid 1px #B2DFEE" />
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
						$("#edit_parent_res_id").combobox({	
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
						$("#edit_child_res_id").combobox({	
					    			data:data.rows,
					    			valueField:'id', 
					    			textField:'text' ,
					    		});
				}
		});	


	<%String pkid=request.getParameter("pkid"); %>
	acjAjax({
		type:'POST',
		url:'<%=path%>'+"/editDetail_TbSysrRelationResSelf.do?pkid="+'<%=pkid%>',    
		success:function(data){
		 	data = $.parseJSON(data);
		 	var message = data.message;
					$("#edit_relation_res_self_id").val(message.relation_res_self_id); 
		 			$("#edit_parent_res_id").combobox('select', message.parent_res_id);
					$("#edit_priority").val(message.priority); 
		 			$("#edit_child_res_id").combobox('select', message.child_res_id);
					$("#edit_netno").val(message.netno); 
					$("#edit_createtime").val(message.createtime); 
					$("#edit_updatetime").val(message.updatetime); 
					$("#edit_create_user_id").val(message.create_user_id); 
					$("#edit_update_user_id").val(message.update_user_id); 
		}
	});	
}); 
</script>
</body>
</html>