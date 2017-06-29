function CheckEmpty( strInput )
{
    return strInput.length > 0;

}

function CheckLength( strInput, nLen )
{
    return strInput.length == nLen;

}

function CheckAlphabetDigit( strInput )
{
    var nLen = strInput.length;
    var i = 0;
    if ( nLen <= 0 )
        return false;


    for ( i = 0; i < nLen; i++ )
    {
        if ( !((strInput.charAt(i).toLowerCase() >= 'a' && strInput.charAt(i).toLowerCase() <= 'z') || (strInput.charAt(i) >= '0' && strInput.charAt(i) <= '9')) )
            return false;
    }
    return true;
}

function CheckAlphabet( strInput )
{
    var nLen = strInput.length;
    var i = 0;
    if ( nLen <= 0 )
        return false;


    for ( i = 0; i < nLen; i++ )
    {
        if ( strInput.charAt(i).toLowerCase() < 'a' || strInput.charAt(i).toLowerCase() > 'z' )
            return false;
    }
    return true;
}

function CheckChar( strInput, strChar )
{
    var nLen = strInput.length;
    var i = 0;
    if ( nLen <= 0 )
        return false;

    for ( i = 0; i < nLen; i++ )
    {
        if ( strInput.charAt(i) == strChar )
            return true;
    }
    return false;
}

function CheckDigit( strInput )
{
    var nLen = strInput.length;
    var i = 0;
    if ( nLen <= 0 )
        return false;


    for ( i = 0; i < nLen; i++ )
    {
        if ( strInput.charAt(i) < '0' || strInput.charAt(i) > '9' )
            return false;
    }
    return true;
}
function ConfirmSubmit()
{
    return confirm(" 确定提交? ");
}
//判断用户输入是否是数字,
function isDigital( strInput )
{
    var s = strInput;
    //整数和正浮点数的正则表达式
    var patrn = /^(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*))$/;
    return patrn.exec(s);
}

/**
 * 数字字符串判别.
 * @param s 需要判别的字符串.
 * @return 当s为数字字符串时返回true, 返之返回false.
 */
function isNumberStr( s )
{
    var n = "0123456789.";
    var i;
    var isF = false;
    var fnum = 0;
    var maxF = 2;//小数位数最大值
    var j = 0;
    if ( (s == null) || (s.length == 0 ) )
    {
        return false;
    }

    for ( i = 0; i < s.length; i++ )
    {
        if ( s.charAt(i) == "." )
        {
            isF = true;
            j++;
        }
        if ( isF )
        {
            fnum++;
        }
        var c = s.charAt(i);
        if ( ( n.indexOf(c) == -1) || (j > 1) || (fnum - 1 > maxF) )
        {
            return false;
        }
    }
    return true;
}

// 得到.的位置
function GetDotPos( value )
{
    var i,nPos;

    nPos = -1;
    for ( i = 0; i < value.length; i++ )
    {
        if ( value.charAt(i) == "." )
        {
            nPos = i;
            break;
        }
    }
    return nPos;
}

// 得到对应数字的大写
function GetNumUpper( value )
{
    var strNum = "";
    switch ( value )
        //选择数字
            {
        case "1":strNum = "壹";break;
        case "2":strNum = "贰";break;
        case "3":strNum = "叁";break;
        case "4":strNum = "肆";break;
        case "5":strNum = "伍";break;
        case "6":strNum = "陆";break;
        case "7":strNum = "柒";break;
        case "8":strNum = "捌";break;
        case "9":strNum = "玖";break;
        case "0":strNum = "零";break;
    }
    return strNum;
}

// 得到整数位数对应的大写单位
function GetIntPosUnit( type, postion )
{
    var strDW = "";

    if ( type == 0 )
    {// 10000以内
        switch ( postion )
            //选择单位
                {
            case 1:strDW = "";break;    // 个
            case 2:strDW = "拾";break;  // 十
            case 3:strDW = "佰";break;  // 百
            case 4:strDW = "仟";break;  // 千
            default: strDW = "";break;
        }
    }
    else if ( type == 1 )
    {// 10000的倍数 //TODO:再大就不知道怎么处理了
        switch ( postion )
            //选择单位
                {
            case 1:strDW = "";break;
            case 2:strDW = "万";break;
            case 3:strDW = "亿";break;
            case 4:strDW = "兆";break;
            default: strDW = "";break;
        }
    }

    return strDW;
}

function GetDecFracPosUnit( postion )
{
    var strDW = "";

    switch ( postion )
            {
        case 1:strDW = "角";break;
        case 2:strDW = "分";break;
        case 3:strDW = "厘";break;
        default: strDW = "";break;
    }

    return strDW;
}

//数字金额转货币大写（js）
function ChangeValueToUpper( value )
{
    var iPos;
    var strArr,strErr;
    var isNegative = false;
    // 为空
    value += "";
    if ( !CheckEmpty(value) )
    {
        return "";
    }

    if ( value.indexOf("-") == 0 )
    {
        value = value.substring(1, value.length);
        isNegative = true;
    }

    // 非数字
    if ( !isNumberStr(value) )   //数据非法时提示，并返回空串
    {
        strErr = value + "不是有效数字！";
        return strErr;
    }

    iPos = GetDotPos(value);
    if ( iPos < 0 )
    {
        // 完全整数
        if ( isNegative )
            return '负' + ChangeIntToUpper(value) + "元整";
        else
            return ChangeIntToUpper(value) + "元整";
    }
    else if ( iPos == 0 )
    {
        //就是小数
        if ( isNegative )
            return '负' + ChangeValueFracToUpper(value.substring(1));
        else
            return ChangeValueFracToUpper(value.substring(1));
    }
    else
    {
        //整数小数混合
        var numA, numB;

        strArr = value.split(".");
        numA = strArr[0];
        numB = strArr[1];

        if ( numA.length > 12 )   //数据大于等于一万亿时提示无法处理
        {
            strErr = value + "过大，无法处理！";
            return strErr;
        }

        if ( isNegative )
            return '负' + ChangeIntToUpper(numA) + "元" + ChangeValueFracToUpper(numB);
        else
            return ChangeIntToUpper(numA) + "元" + ChangeValueFracToUpper(numB);
    }
}

//数字份额转大写（js）
function ChangeShareToUpper( value )
{
    var iPos;
    var strArr,strErr;
    var isNegative = false;
    // 为空
    value += "";
    if ( !CheckEmpty(value) )
    {
        return "";
    }

    if ( value.indexOf("-") == 0 )
    {
        value = value.substring(1, value.length);
        isNegative = true;
    }

    // 非数字
    if ( !isNumberStr(value) )   //数据非法时提示，并返回空串
    {
        strErr = value + "不是有效数字！";
        return strErr;
    }

    iPos = GetDotPos(value);
    if ( iPos < 0 )
    {
        // 完全整数
        if ( isNegative )
            return '负' + ChangeIntToUpper(value) + "份";
        else
            return ChangeIntToUpper(value) + "份";
    }
    else if ( iPos == 0 )
    {
        //就是小数
        if ( isNegative )
            return '负' + ChangeValueShareToUpper(value.substring(1));
        else
            return ChangeValueShareToUpper(value.substring(1));
    }
    else
    {
        //整数小数混合
        var numA, numB;

        strArr = value.split(".");
        numA = strArr[0];
        numB = strArr[1];

        if ( numA.length > 12 )   //数据大于等于一万亿时提示无法处理
        {
            strErr = value + "过大，无法处理！";
            return strErr;
        }

        if ( isNegative )
            return '负' + ChangeIntToUpper(numA) + '点' + ChangeValueShareToUpper(numB) + "份";
        else
            return ChangeIntToUpper(numA) + '点' + ChangeValueShareToUpper(numB) + "份";
    }
}

// 将整数部分，转换成大写
function ChangeIntToUpper( inputNum )
{
    //alert(inputNum);
    if ( parseInt(inputNum) == 0 )
        return GetNumUpper('0');

    var subsNum = Math.ceil(inputNum.length / 4);
    var beforNum = inputNum.length % 4;

    var substr = new Array(subsNum);

    var i = 0,j = 0;
    var iPos = 0;
    var sOut = "";
    var isZero = false;
    for ( i = 0; i < subsNum; i++ )
    {
        if ( i == 0 && beforNum != 0 )
        {
            substr[i] = inputNum.substr(0, beforNum);
            iPos += beforNum;
        }
        else
        {
            substr[i] = inputNum.substr(iPos, 4);
            iPos += 4;
        }

        // alert("第"+i+ "次(" +subsNum+")" + substr[i]);
        var subStrLen = substr[i].length;
        for ( j = 0; j < subStrLen; j++ )
        {
            if ( substr[i].charAt(j) != '0' )
            {
                if ( isZero )
                {
                    isZero = false;
                    sOut += GetNumUpper('0');
                }
                sOut += GetNumUpper(substr[i].charAt(j)) + GetIntPosUnit(0, subStrLen - j);
            }
            else
                isZero = true;

        }

        if ( parseInt(substr[i]) != 0 )
            sOut += GetIntPosUnit(1, subsNum - i);
        //alert("第"+i+ "次(" +subsNum+")" + sOut);
    }

    return sOut;
}

// 将金额小数部分转换为大写
function ChangeValueFracToUpper( inputNum )
{
    var iLen,i;
    var isZero = false;
    var sOut = "";

    //alert(inputNum);
    iLen = inputNum.length;
    for ( i = 0; i < iLen; i++ )
    {
        if ( inputNum.charAt(i) != "0" )
        {
            if ( isZero )
            {
                isZero = false;
                sOut += GetNumUpper('0');
            }
            sOut += GetNumUpper(inputNum.charAt(i)) + GetDecFracPosUnit(i + 1);
        }
        else
            isZero = true;
    }
    return sOut;
}

// 将份额小数部分转换为大写
function ChangeValueShareToUpper( inputNum )
{
    var iLen,i;
    var isZero = false;
    var sOut = "";

    //alert(inputNum);
    iLen = inputNum.length;
    for ( i = 0; i < iLen; i++ )
    {
        if ( inputNum.charAt(i) != "0" )
        {
            if ( isZero )
            {
                isZero = false;
                sOut += GetNumUpper('0');
            }
            sOut += GetNumUpper(inputNum.charAt(i));
        }
        else
            isZero = true;
    }
    return sOut;
}

function ChangeShareFracToUpper( inputNum )
{
    // 过滤连续为零的情况
    var sInputNum = "";

    var iLen,i;
    var isZero = true;
    iLen = inputNum.length;
    for ( i = iLen; i > 0; i-- )
    {
        if ( inputNum.charAt(i - 1) == '0' )
        {
            if ( !isZero )
            {
                sInputNum = inputNum.charAt(i - 1) + sInputNum;
            }
        }
        else
        {
            sInputNum = inputNum.charAt(i - 1) + sInputNum;
            isZero = false;
        }
    }

    if ( sInputNum.length == 0 )
    {
        return "";
    }

    var sOut = "";

    iLen = sInputNum.length;
    for ( i = 0; i < iLen; i++ )
    {
        sOut += GetNumUpper(sInputNum.charAt(i));
    }
    return sOut;
}