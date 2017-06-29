var curModule = "";

var log = function(s) {  
    if (document.readyState !== "complete") {  
        log.buffer.push(s);  
    } else {  
        if ( s != null )
        {
        	//格式化 推送信息
			var resultArr=s.split("|");
			var mtype=resultArr[0];
			var mcontext=resultArr[1];
			console(mtype,mcontext);
        }
    }  
};  
log.buffer = []; 

/**
 * 控制台输出
 * @param mtype
 * @param mcontext
 */
function console(mtype,mcontext){
	var _text = "";
	if(mtype == '0'){
		_text = "正常信息";
		$("#console").append("<tr><td align='left'><div style='float:left;text-align:center;background-color:white' id='current'>" +
				"<span>" + _text + "</span></div></td><td><span id='errorMsg' >" + mcontext + "</span></td></tr>");
	} else if(mtype == '1'){
		_text = "警告信息";
		$("#console").append("<tr><td align='left'><div style='float:left;text-align:center;background-color:yellow' id='current'>" +
				"<span>" + _text + "</span></div></td><td><span id='errorMsg' style='color:blue'>" + mcontext + "</span></td></tr>");

	} else if(mtype == '2'){
		_text = "异常信息";
		$("#console").append("<tr><td align='left'><div style='float:left;text-align:center;background-color:red' id='current'>" +
				"<span>" + _text + "</span></div></td><td><span id='errorMsg' style='color:red'>" + mcontext + "</span></td></tr>");
	}
	
	document.getElementById("consoleDiv").scrollTop = document.getElementById("consoleDiv").scrollHeight;
}
