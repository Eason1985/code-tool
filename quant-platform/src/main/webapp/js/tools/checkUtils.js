/**
 * 根据传入id获取js对象
 * @param id 入参id
 * @returns
 */
function obj$(id){
    return document.getElementById(id);
};

/**
 * 根据传入id获取js对象的值
 * @param id 入参id
 * @returns
 */
function val$(id){
    var obj= document.getElementById(id);
    if(obj!==null){
        return obj.value();
    }else{
        return null;
    }
};

/**
 * 去掉字符串前后的空格
 * @param str 入参:要去掉空格的字符串
 * @returns
 */
function trimAll(str){
     return str.replace(/(^\s*)|(\s*$)/g, ''); 
 
};

/**
 * 去掉字符串前的空格
 * @param str 入参:要去掉空格的字符串
 * @returns
 */
function trimLeft(str){
     return str.replace(/^\s*/g,'');
     
};

/**
 * 去掉字符串后的空格
 * @param str 入参:要去掉空格的字符串
 * @returns
 */
function trimRight(str){
    return str.replace(/\s*$/,'');
}

/**
 * 判断字符串是否为空
 * @param str 传入的字符串
 * @returns
 */
function isEmpty(str){
	
    if(str != null && str.length > 0)
    {
        return true;
    }
    return false;
}
/**
 * 判断两个字符串子否相同
 * @param str1
 * @param str2
 * @returns {Boolean}
 */
function isEquals(str1,str2){
    if(str1==str2){
        return true;
    }
    return false;
}
/**
 * 忽略大小写判断字符串是否相同
 * @param str1
 * @param str2
 * @returns {Boolean}
 */
function isEqualsIgnorecase(str1,str2){
    if(str1.toUpperCase() == str2.toUpperCase())
    {
        return true;
    }
    return false;
}
/**
 * 判断js对象的长度
 * @param obj
 * @param min
 * @param max
 * @returns {Boolean}
 */
function checkLength(obj,min,max){
    if(obj.length < min || obj.length > max) {
        return false;
    } else {
        return true;
    }
}
/**
 * 判断是否是数字
 * @param value
 * @returns {Boolean}
 */
function isNum(value){
    if( value != null && value.length>0 && isNaN(value) == false){
        return true;
    }
    else{
        return false;
    }
 
}
/**
 * 判断是否是中文
 * @param str
 * @returns {Boolean}
 */
function isChine(str){
    var reg = /^([\u4E00-\u9FA5]|[\uFE30-\uFFA0])*$/;
    if(reg.test(str)){
        return false;
    }
    return true;
}
/**
 * 获取年
 * @returns
 */
function getYear(){
    var year = null;
    var dateTime = this.getDateTime();                      
    if(dateTime != null){
        year = dateTime.getFullYear();
    }else{
        year = this.curDateTime.getFullYear();
    }       
    return year;
}
/**
 * 获取月
 * @returns
 */
function getMonth(){
    var month = null;
    var dateTime = this.getDateTime();
    if(dateTime != null){
        month = dateTime.getMonth() + 1;        
    }else{
        month = this.curDateTime.getMonth() + 1;    
    }
    return month;
}
/**
 * 获取天
 * @returns
 */
function getDay(){
    var day = null;
    var dateTime = this.getDateTime();
    if(dateTime != null){
        day = dateTime.getDate();
    }else{
        day = this.curDateTime.getDate();   
    }
    return day;
 
}
/**
 * 获取小时
 * @returns
 */
function getHour(){
    var hour = null;
    var dateTime = this.getDateTime();
    if(dateTime != null){
        hour = dateTime.getHours();
    }else{
        hour = this.curDateTime.getHours(); 
    }
    return hour;
}
/**
 * 获取分钟
 * @returns
 */
function getMinute(){
    var minute = null;
    var dateTime = this.getDateTime();
    if(dateTime != null){
        minute = dateTime.getMinutes();
    }else{
        minute = this.curDateTime.getMinutes();
    }
    return minute;  
}
/**
 * 获取秒
 * @returns
 */
function getSecond(){
    var second = null;
    var dateTime = this.getDateTime();
    if(dateTime != null){
        second = dateTime.getSeconds();
    }else{
        second = this.curDateTime.getSeconds();
    }
    return second;
}
/**
 * 是否是闰年
 * @returns {Boolean}
 */
function isLeapYear(){
    var flag = false;
    if((this.getYear() % 4 == 0 && this.getYear() % 100 !=0)
            || (this.getYear() % 400 == 0)){
        flag = true;
    }       
    return flag;
}

function isEmail(email){
	var filter  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	if (filter.test(email)) return true;
	 else {
	 alert('您的电子邮件格式不正确');
	 return false;
	}
}

/**
 * 检查生日是否是当期日期之后
 */
function checkBirthday(birthday,focusId){
	var d=new Date(Date.parse(birthday.replace(/\-/g, "\/")));
	var curDate=new Date();
	if(d >curDate){	    
	    document.getElementById(focusId).focus();
	    return true;
	}
	
	
}

/**
 * 比较日期是否小于当前日期
 */
function checkDayAfterToday(date,focusId){
	var d=new Date(Date.parse(date.replace(/\-/g, "\/")));
	var curDate=new Date();
	if(d <curDate){	    
	    document.getElementById(focusId).focus();
	    return true;
	}		
}

/**
 * 比较两个日期大小
 */
function checkTwoday(one,two){
	var dayone=new Date(Date.parse(one.replace(/\-/g, "\/")));
	var daytwo=new Date(Date.parse(two.replace(/\-/g, "\/")));
	if(daytwo <dayone){	    
	    return true;
	}		
}


/**
 * 判断是否数字
 */
function checkIsNan(object){
	if(null == object || ''==object || isNaN(object)){
		
		return false;
	}else{
		return true;
	}
		
}

function checkIsNum(exp){
	
	if (typeof(exp)!="undefined"){
	    return true;
	}else{
		return false;
	}
}

function checkIsNumZero(exp){
	
	if (typeof(exp)!="undefined" && exp!=0){
	    return true;
	}else{
		return false;
	}
}

//正整数
function isPInt(str) {
    var g = /^[1-9]*[1-9][0-9]*$/;
    return g.test(str);
}

//整数
function isInt(str)
{
    var g=/^-?\d+$/;
    return g.test(str);
}
//easyUI校验框架
$.extend($.fn.validatebox.defaults.rules, {  
    //验证汉子  
    CHS: {  
        validator: function (value) {  
            return /^[\u0391-\uFFE5]+$/.test(value);  
        },  
        message: '只能输入汉字'  
    },  
    //移动手机号码验证  
    mobile: {//value值为文本框中的值  
        validator: function (value) {  
            var reg = /^1[3|4|5|8|9]\d{9}$/;  
            return reg.test(value);  
        },  
        message: '输入手机号码格式不准确.'  
    },  
    //国内邮编验证  
    zipcode: {  
        validator: function (value) {  
            var reg = /^[1-9]\d{5}$/;  
            return reg.test(value);  
        },  
        message: '邮编必须是非0开始的6位数字.'  
    },  
    money: {  
        validator: function (value) {  
            var reg = /^(([1-9]\d{0,9})|0)(\.\d{1,2})?$/;  
            return reg.test(value);  
        },  
        message: '请输入正确的金额数值.'  
    },numberValue: {  
        validator: function (value) {  
            var reg = /^\+?[1-9]\d*$/;  
            return reg.test(value);  
        },  
        message: '请输入正确的数目.'  
    }
});