<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/page/common/easyui_head.jsp"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>"> 
<title></title>
<link href="css/default.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="css/themes/icon.css">
<script type='text/javascript' src='<%=basePath%>js/common.js'></script>
<script type='text/javascript' src='<%=basePath%>js/checkUtils.js'></script>
</head>
<body>
<!--内容-->
<div id="div_password_list" class="container">
	<article id="content" class="content">
		<div class="content-body">
			<!--搜索栏开始-->
			<div class="search-panel toggle-panel">
				<div class="panel-header" data-role="toggle-handle">
					<h2 class="panel-title">密码修改</h2>
				</div>
				<div class="search-panel-content">
					<form id="searchForm" name="searchForm" method="post" >
						<div class="search-panel-bd">
							<table class="search-table">
									 <tr>
										<th class="wd-20"><label>原密码</label></th>
										<td>
											<input type="password"  name="oldpassword"  data-options="required:true"  style="color:black;width:180px;height:30px;border:solid 1px #B2DFEE" />
										</td>
									</tr>
									<tr>
										<th class="wd-20"><label>新密码</label></th>
										<td>
											<input type="password"  name="password"  data-options="required:true"  style="color:black;width:180px;height:30px;border:solid 1px #B2DFEE" />
										</td>
									</tr>
									<tr>
										<th class="wd-20"><label>重复新密码</label></th>
										<td>
											<input type="password"  name="password2"  data-options="required:true"  style="color:black;width:180px;height:30px;border:solid 1px #B2DFEE" />
										</td>
									</tr>
									  
							</table>
						</div>
						<div class="search-btn-area">
							<input id="save" type="button" value="保存" />
						</div>
					</form>
				</div>
			</div>
			<!--搜索栏结束-->
		</div>
	</article>
</div>

<script>
jQuery(function($){
	var path = '<%=path%>';
    //定义一览页面查询的参数(JSON格式)
    function buildJsonParams( ){
    		var oldpasswrd = hex_md5($("input[name='oldpassword']").val()); 
    		var passwrd = hex_md5($("input[name='password']").val()); 
		  	var searchContent =	{
				oldpassword :oldpasswrd, 
				password :passwrd, 
		    };
			var searchContentStr  =JSON.stringify(searchContent);
			//传到到后台的URL 必须先编码化
			return encodeURI(searchContentStr);
	 };
	 
	//重新按照条件刷新查询一览内容
	$('div#div_password_list #save').click(function(){
		var oldpassword  = $("input[name='oldpassword']").val()  ; 
		var password = $("input[name='password']").val()  ; 
		var password2 = $("input[name='password2']").val()  ; 
		
		if(password !=password2  ){
			$.messager.alert("操作提示","两次密码不一致");
			return false; 
		}
		if(oldpassword == password){
			$.messager.alert("操作提示","新密码不能与原密码一样");
			return false; 
		}
		var reg3=/^[\u4E00-\u9FFF]+$/;
        //var password=$("input[name='tbSysrUserDto.user_name']").val();		           
        if(reg3.test(password)){
       		$.messager.alert("提示信息","用户密码不能为中文,请重新输入!");
  			return false;	
        }
        if(password.length  <6 ){
       		$.messager.alert("提示信息","密码长度应该大于6位");
  			return false;	
        }
  
		var searchContentStr = buildJsonParams(  );
				
		acjAjax({
			type:'POST',
			cache:false,
	 		async: false,
		    url:'<%=path%>'+"/updatePassword.do?searchContentStr="+searchContentStr,
			success:function(data){
				data = $.parseJSON(data);
				$.messager.alert("操作提示",data.message);
			}
		}); 
	});
});

</script>
</body>
</html>