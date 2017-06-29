<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ include file="/page/common/easyui_head.jsp"%>
<title></title>
</head>
<body>
<div class="content-body" id="addTbSysrResource">
	<div class="search-panel toggle-panel">
		<div class="search-panel-content">
			<form id="addTbSysrResourceFrom" name="addTbSysrResourceFrom" method="post">
				<div class="search-panel-bd">
				 <table class="search-table">
						 <tr>
							<th class="wd-20"><label>资源名称</label></th>
							<td>
								<input type="text" id="tbSysrResourceDto.resource_name" name="tbSysrResourceDto.resource_name" class="easyui-validatebox" data-options="required:true,invalidMessage:'资源名称不能为空',missingMessage:'资源名称不能为空'" style="color:black;width:180px;height:30px;border:solid 1px #B2DFEE"/>
							</td>
							<th class="wd-20"><label>资源地址</label></th>
							<td>
								<input type="text" id="tbSysrResourceDto.resource_addr" name="tbSysrResourceDto.resource_addr" class="easyui-validatebox" data-options="required:true,invalidMessage:'资源地址不能为空',missingMessage:'资源地址不能为空'" style="color:black;width:180px;height:30px;border:solid 1px #B2DFEE"/>
							</td>
						  </tr>
				  </table>
				</div>
			</form>
		</div>
	</div>
</div>
</body>
</html>