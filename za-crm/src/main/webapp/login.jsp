<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
<%@ include file="/page/common/commonhead.jsp"%>
<title>easonCRM-登录</title>
<link type="text/css" rel="stylesheet" href="<%=cssPath%>/login.css" />
<script type="text/javascript" src="<%=jsPath%>/jquery/jquery.min.js"></script>
<script type='text/javascript' src='<%=jsPath%>/jquery/jquery.easyui.min.js'></script>
<script type="text/javascript" src="<%=jsPath%>/cookie.js"></script>
<script type="text/javascript" src="<%=jsPath%>/json/basedata.json"></script>
<script type='text/javascript' src='<%=jsPath%>/easyui.validator.ext.js'></script>
<script type="text/javascript" src="<%=jsPath%>/json/json2.min.js"></script>
<script type='text/javascript' src='<%=jsPath%>/ajaxProcessUtil.js'></script>
<script type='text/javascript' src='<%=jsPath%>/progress.js'></script>
<script type='text/javascript' src='<%=jsPath%>/privCity.js'></script>
<script type="text/javascript" src="<%=jsPath%>/json/basedata.json"></script>
<script type='text/javascript' src='<%=jsPath%>/datagrid-detailview.js'></script>
<script type="text/javascript" src="<%=jsPath%>/easyui-lang-zh_CN.js"></script>
<script type='text/javascript' src='<%=jsPath%>/tools/md5.js'></script>

</head>

<body>
<div style="background-image:url('<%=imgPath%>/page/login.jpg');background-size:cover;">
<header id="header">
	<div class="header-bd clearfix">
		<h1 class="login-logo">easonCRM</h1>
		<div class="login-top-text">easonCRM</div>
	</div>
</header>

<div class="content">
	<div class="login-wrapper">
		<div id="login_msg" style="display:none;"></div>
		<form name="ld_login_form" method="post">
			<dl class="login-form-item">
				<dt>用户名</dt>
				<dd><input type="text" name="tSysChanAcctDto.acct_code" class="input-text" /></dd>
			</dl>
			<dl class="login-form-item">
				<dt>密码</dt>
				<dd><input type="password" name="tSysChanAcctDto.password" class="input-text" /></dd>
			</dl>
			<div class="login-btn-area">
				<input type="submit" name="ld_login_btn" class="input-btn" value="登 录" />
				 
					<a href="#" style="color:#15c;">忘记密码?</a>
				 
			</div>
		</form>
	</div>
</div>
</div>
<script>

var ld_login = {
	setDefault: true,
	checkValid: function(){
		var uVal = $.trim(this.USER_NAME.value),
		pVal = this.PASS_WORD.value;
		if(uVal==""){
			return {field:this.USER_NAME}
		}
		if(pVal==""){
			return {field:this.PASS_WORD}
		}
		return true;
	},
	login: function(option){
		var result = this.checkValid();
		if(result !== true){
			if(typeof option.fail == "function"){
				option.fail.call(this,result.field);
			}else{
				this.setError("请填写必要信息");	
				result.field.focus();
			}
		}else{
			if(typeof option.success == "function"){
				option.success.call(this);
			}
		}
		return false
	},
	setValue: function(){
		if(this.setDefault){
			var saveDuration = new Date();
			var bSecure = false;
			var val = $.trim(this.USER_NAME.value)
			if(window.location.protocol.indexOf( "https") != -1){
				bSecure = true;
			}
			saveDuration.setTime(saveDuration.getTime() + 604800000);
			setCookie("ld_user_id", val, saveDuration, null, null, bSecure);	
		}
	},
	setError: function(msg){
		var timeout;
		this.MSGDIV.style.color = "#ff0000";
		this.MSGDIV.style.display = "block";
		this.MSGDIV.innerHTML = msg;
		if(timeout){
			clearTimeout(timeout);	
		}
		timeout = setTimeout(function(){
			ld_login.MSGDIV.style.display = 'none';
		},3000);
	},
	setDisabled: function(flag){
		if(flag){
			ld_login.LOGIN_BTN.disabled = true;
			ld_login.LOGIN_BTN.value = "提交中...";
		}else{
			ld_login.LOGIN_BTN.disabled = false;
			ld_login.LOGIN_BTN.value = "登 录";
		}
	},
	shake: function(el){
		var color_group = ["#B80000","#fff","#B80000","#fff","#B80000","#fff"],
		count = 0,
		len = color_group.length,
		time,
		run = function(){
			var color = color_group[count];
			el.style.backgroundColor = color;
			count++;
			if(count == len){
				clearTimeout(time);
				return;
			}
			time = setTimeout(arguments.callee,200);
		};
		run();
	},
	setDefaultValue: function(){
		if(this.setDefault){
			var cookieVal = getCookie("ld_user_id");
			if(cookieVal != null){
				this.USER_NAME.value = cookieVal;
				this.PASS_WORD.focus();
			}else{
				this.USER_NAME.focus();
			}
		}else{
			if(this.USER_NAME.value != ""){
				this.USER_NAME.focus();
			}
		}
	},
	init: function(){
		this.MSGDIV = document.getElementById("login_msg");
		this.FORM = document.forms["ld_login_form"];
		this.USER_NAME = this.FORM['tSysChanAcctDto.acct_code'];
		this.PASS_WORD = this.FORM['tSysChanAcctDto.password'];
		this.LOGIN_BTN = this.FORM['ld_login_btn'];
		
		this.setDefaultValue();
		
		this.FORM.onsubmit = function(e){
		//获取浏览器名称版本
		var browser = getBrowserInfo() ;
		if(browser != "Firefox"){
	    	if(confirm("请使用火狐浏览器!")){
	    		window.open("http://download.firefox.com.cn/releases-sha2/stub/official/zh-CN/Firefox-latest.exe");
	    		return ; 
	    	}else{
	    		return ;
	        }
	    }
		
			return ld_login.login({
				fail: function( field ){
					field.focus();
					ld_login.shake(field);
				},
				success: function(){
					ld_login.setDisabled(true);
					var pswd = ld_login['PASS_WORD'].value;
					pswd = hex_md5(pswd);
					$.ajax({
						type:'post',
						dataType:'json',
						data:{
							"user_cd": ld_login['USER_NAME'].value,
							"password": pswd
						},
						url:"<%=path%>/login.do",
						success: function(data){
							if(data.status){
								window.location.href = "<%=path%>/index.do";
							}else{
								ld_login.setDisabled(false);
								ld_login.setError(data.message);
							}
						},
						error: function(){
							ld_login.setDisabled(false);
							ld_login.setError("登录失败，请检查网络！");
						}
					});
				}
			});

		}
	}
};

jQuery(function($){
	ld_login.init();
	<%
	String errorInfo = request.getParameter("errorInfo") ;
	if(errorInfo == null){
		errorInfo = "";
	}else{
		errorInfo = new String(errorInfo.getBytes("ISO8859-1"),"UTF-8");
	}
%>
var errorInfo = '<%=errorInfo%>';
ld_login.setError(errorInfo);
});


function getBrowserInfo()
{
var OsObject = "";  
   if(navigator.userAgent.indexOf("MSIE")>0) {  
        return "MSIE";  
   }  
   if(isFirefox=navigator.userAgent.indexOf("Firefox")>0){  
        return "Firefox";  
   }  
   if(isSafari=navigator.userAgent.indexOf("Safari")>0) {  
        return "Safari";  
   }   
   if(isCamino=navigator.userAgent.indexOf("Camino")>0){  
        return "Camino";  
   }  
   if(isMozilla=navigator.userAgent.indexOf("Gecko/")>0){  
        return "Gecko";  
   }  
}

</script>

<%@ include file="page/common/footer.jsp"%>
</body>
</html>
