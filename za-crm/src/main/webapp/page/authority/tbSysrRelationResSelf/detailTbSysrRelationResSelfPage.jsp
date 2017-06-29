<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ include file="/page/common/easyui_head.jsp"%>
<title></title>
<script type='text/javascript' src='<%=basePath%>js/common.js'></script>
</head>
<body>
<div class="content-body">
	<div class="search-panel toggle-panel">
		<div class="search-panel-content">
				<div class="search-panel-bd">
					<table class="search-table">
					   							 <tr>
								<th class="wd-20"><label>父资源</label></th>
								<td>
									<input type="text" id="detail_parent_res_id" name="detail_parent_res_id"   style="width:200px;border-width: 0" readonly="true" />
								</td>
							  </tr>
							 <tr>
								<th class="wd-20"><label>优先级</label></th>
								<td>
									<input type="text" id="detail_priority" name="detail_priority"   style="width:200px;border-width: 0" readonly="true" />
								</td>
							  </tr>
							 <tr>
								<th class="wd-20"><label>子资源</label></th>
								<td>
									<input type="text" id="detail_child_res_id" name="detail_child_res_id"   style="width:200px;border-width: 0" readonly="true" />
								</td>
							  </tr>
							 <tr>
								<th class="wd-20"><label>网点号</label></th>
								<td>
									<input type="text" id="detail_netno" name="detail_netno"   style="width:200px;border-width: 0" readonly="true" />
								</td>
							  </tr>
							<tr>
								<th class="wd-20"><label>创建时间</label></th>
								<td>
									<input type="text" id="detail_createtime" name="detail_createtime" style="width:200px;border-width: 0" readonly="true" />
								</td>
							 </tr>
							<tr>
								<th class="wd-20"><label>修改时间</label></th>
								<td>
									<input type="text" id="detail_updatetime" name="detail_updatetime" style="width:200px;border-width: 0" readonly="true" />
								</td>
							 </tr>
							 <tr>
								<th class="wd-20"><label>创建人</label></th>
								<td>
									<input type="text" id="detail_create_user_id" name="detail_create_user_id"   style="width:200px;border-width: 0" readonly="true" />
								</td>
							  </tr>
							 <tr>
								<th class="wd-20"><label>更新人</label></th>
								<td>
									<input type="text" id="detail_update_user_id" name="detail_update_user_id"   style="width:200px;border-width: 0" readonly="true" />
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
	//页面加载时带出相关信息
	<%String pkid=request.getParameter("pkid"); %>
	acjAjax({
		type:'POST',
		url:'<%=path%>'+"/detail_TbSysrRelationResSelf.do?pkid="+'<%=pkid%>',    
		success:function(data){
		 	data = $.parseJSON(data);
		 	var message = data.message;
				$("#detail_relation_res_self_id").val(message.relation_res_self_id); 
				$("#detail_parent_res_id").val(message.parent_res_id); 
				$("#detail_priority").val(message.priority); 
				$("#detail_child_res_id").val(message.child_res_id); 
				$("#detail_netno").val(message.netno); 
				$("#detail_createtime").val(message.createtime); 
				$("#detail_updatetime").val(message.updatetime); 
				$("#detail_create_user_id").val(message.create_user_id); 
				$("#detail_update_user_id").val(message.update_user_id); 
		}
	});
}); 
</script>
</body>
</html>