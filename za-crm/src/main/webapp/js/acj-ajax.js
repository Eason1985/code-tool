
/**
 * 
 * 处理错误信息框架
 */
var forwardPath;
function acjAjax(jsonObj){
	if(!forwardPath){
		forwardPath = getRootPath_web();
	}
	var succF = jsonObj.success ; 
	function acjSuccFunction (data){		
		var dataObj = $.parseJSON(data);
		redirectToLogin(dataObj);
		try{
			succF(data); 
		}catch(exception) {
			
		}
	}
	jsonObj.success = acjSuccFunction ; 
	$.ajax(jsonObj);
	
}

function redirectToLogin(dataObj){
	if(dataObj.error){
		if(dataObj.errorCode == '00000001'){
			if(!forwardPath){
				forwardPath = getRootPath_web();
			}
			window.location.replace(forwardPath+"/page/common/error.jsp?message="+dataObj.message);
			return ;
		}
	}
}


function getRootPath_web() {
    //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
    var curWwwPath = window.document.location.href;
    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
    var pathName = window.document.location.pathname;
    var pos = curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8083
    var localhostPaht = curWwwPath.substring(0, pos);
    //获取带"/"的项目名，如：/uimcardprj
    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
    return (localhostPaht + projectName);
}
/**
 * 
 * @param 
 * @param 
 * 
 * 调用：
 * 		
 */

