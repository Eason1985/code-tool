/********************* JS 公共方法***************************************************/
$(function(){
	$.messager.defaults = { ok: "确认", cancel: "取消" };
});

/**
* 关闭当前Tab 公共方法
*/
function refreshMainTab(){
	var index = parent.$('#tabs').tabs('getTabIndex',parent.$('#tabs').tabs('getSelected'));
	// 定位到主页 并刷新
	parent.$('#tabs').tabs('close',index);
}

/**
* 刷新主页面Tab 
*/
function closeTab(){
	 //刷新主页面
     var currTab = parent.$('#tabs').tabs('getSelected'); //获得当前tab
     parent.$('#tabs').tabs('update', {
       tab : currTab,
       options : {
          title:'日清算流程',
          content : createFrame('liquidateFlow.jsp')
       }
    }); 
}

/**
 * 创建frame
 * @param url
 * @returns {String}
 */
function createFrame(url) {
    var s = '<iframe scrolling="auto" frameborder = "0"  src="' + url + '" style="width:100%;height:100%;"></iframe>';
    return s;
}
/**
 * 右下角弹出框
 */
function alertMessage(title, msg, timeout) {
	var _t = title;
	var _m = msg;
	var _time = timeout;
	if (!_t) { // 如果没有传参数，那么值就是undefined
		_t = tips;
	}
	if (!_time) {
		_time = '3000';
	}
	$.messager.show({
		title : _t,
		msg : _m,
		timeout : _time,
		showType : 'show'
	});
}

/**
 * easyui-datebox选择时间
 * @param date
 * @returns {String}
 */
function ww3(date){  
    var y = date.getFullYear();  
    var m = date.getMonth()+1;  
    var d = date.getDate();  
    var h = date.getHours();  
    var min = date.getMinutes();  
    var sec = date.getSeconds();  
//     var str = y+'/'+(m<10?('0'+m):m)+'/'+(d<10?('0'+d):d)+'/'+' '+(h<10?('0'+h):h)+':'+(min<10?('0'+min):min)+':'+(sec<10?('0'+sec):sec);  
    var str = y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);  

    return str;  
}  
function w3(s){  
    if (!s) return new Date();  
    var y = s.substring(0,4);  
    var m =s.substring(5,7);  
    var d = s.substring(8,10);  
    var h = s.substring(11,14);  
    var min = s.substring(15,17);  
    var sec = s.substring(18,20);  
    if (!isNaN(y) && !isNaN(m) && !isNaN(d) && !isNaN(h) && !isNaN(min) && !isNaN(sec)){  
        return new Date(y,m-1,d,h,min,sec);  
    } else {  
        return new Date();  
    }  
} 