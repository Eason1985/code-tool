$(function() {
	
	
	// 初始化table
	$("#dg").datagrid(
	{
		url : 'qryPayInstSt.do',
		fit : true,//如果设置为true，布局组件将自适应父容器。当使用'body'标签创建布局的时候，整个页面会自动最大。
		fitColums : true,//自动展开/收缩列的大小，以适应网格的宽度
		rownumbers : true,
		autoRowHeight : true,
		fitColumns : true,
		striped : true,//是否显示斑马线效果。
		checkOnSelect : true,
		columns : [ [
				{
					field : 'orgcode',
					title : '支付机构代码',
					width : 60,
					height : 100,
					align : 'center'
				},
				{
					field : 'orgname',
					title : '支付机构名称',
					width : 60,
					align : 'center'
				},
				{
					field : 'checkday',
					title : '对账日期',
					width : 65,
					align : 'center'
				},
				{
					field : 'numbers',
					title : '划款笔数',
					width : 65,
					align : 'center'
				},
				{
					field : 'amount',
					title : '划款金额',
					width : 65,
					align : 'right',
					pattern:'#0.00'
				},
				{
					field : 'checktype',
					title : '对账类型',
					width : 65,
					align : 'center',
					formatter : function(value, row,
							index) {
						if (value == '0') {
							return "资金对账";
						} else {
							return "";
						}
					}
				},
				{
					field : 'status',
					title : '对账状态',
					width : 65,
					align : 'center',
					formatter : function(value, row,
							index) {
						if (value == '0') {
							return "未对账";
						} else if (value == '1') {
							return "正在对账";
						} else if (value == '2') {
							return "已对账";
						} else {
							return "";
						}
					}
				},{
					field : 'checkresult',
					title : '对账结果',
					width : 90,
					align : 'center',
					formatter : function(value, row,
							index) {
						if (value == '0') {
							return "账平";
						} else if (value == '1') {
							return "对账失败";
						} else if (value == '2') {
							return "账不平";
						}  else {
							return "";
						}
					}
				},
				{
					field : 'itemid',
					title : '操作',
					width : 150,
					height : 1000,
					formatter : function(value, row,
							index) {
						if(row.machinetime==row.checkday){//row.machinetime==row.checkday
							return '<a class="_dglinkbutton" href="#" onclick="prepare('+row.orgcode+')" iconCls="icon-add">上传对账单</a>&nbsp;&nbsp;<a class="_dglinkbutton" href="#" onclick="checkacc('+row.orgcode+','+row.checkday+')"  iconCls="icon-redo">对账</a>&nbsp;&nbsp;<a class="_dglinkbutton" href="#" onclick="qrydetail('+row.status+','+row.orgcode+','+row.checkday+')" iconCls="icon-search">详细信息</a>';
						}else{
							return '<a class="_dglinkbutton" href="#" onclick="qrydetail('+row.status+','+row.orgcode+','+row.checkday+')" iconCls="icon-search">详细信息</a>';
						}
					}
				} ] ],
			onLoadSuccess : function(data) {
			$("._dglinkbutton").linkbutton();
		},
	    pagination:true,
		pageNumber:1
	});
	// 定义详细信息窗口
	$("#qrydetail").dialog({    
	    width: 800,    
	    height: 424,
	    closed: true,
	    modal: true,
		buttons:[
					{text:'退出', handler:function(){$("#qrydetail").dialog('close');},iconCls:'icon-cancel'}
				]
	});
	$("#datarepare").dialog({    
	    width: 400,    
	    height: 224,
	    closed: true,
	    modal: true,
		buttons:[
					{text:'确定', handler:submit_sc,iconCls:'icon-ok'},
					{text:'退出', handler:function(){$("#datarepare").dialog('close');},iconCls:'icon-cancel'}
				]
	});
	
});
/**
 * 数据准备
 */
function prepare(obj) {
	$("#orgcodehidden").val(obj);
	$('#datarepare').dialog('setTitle','上传文件').dialog('open');
}
/**
 * 对账
 */
function checkacc(orgCode,checkday) {
	$.ajax({
		type : 'post',
		url : 'capCheck.do?orgCode='+orgCode+'&checkday='+checkday,
		beforeSend:function(){ 
			$.messager.progress({
				title:'请稍后', 
				msg:'页面加载中...'
				}
			);
		},
		success : function(data) {
			$.messager.progress('close');
			data = $.parseJSON(data);
			if (!data.status) {
				if(data.mess!=null && data.mess!=undefined){
					alert(data.mess);
				}
				else {
					alert("对账失败");
				}
			}else{
				$('#dg').datagrid('reload');
				alert(data.mess);
			}
		}
	});
}
/**
 * 查询对账详细信息
 */
function qrydetail(status,capitalmode,checkday) {
	if(status != "2"){
		alert("未对账");
		return;
	}
	
	$("#detailDg").datagrid({
		url :"qrydetail.do?capitalmode="+capitalmode+"&checkday="+checkday,
		fit:true,
		fitColums:true,
		rownumbers:true,
	    striped:true,
	    singleSelect:true,
	    columns:[[//STATE=0, TRUSTREQUESTNO=2015091000000880, TRADEACCO=999800007569, AMOUNT=1000
	        {field:'TRUSTREQUESTNO',title:'委托单号',width:150,align:'center'},
	        {field:'TRADEACCO',title:'交易账号',width:120,align:'center'},
	        {field:'AMOUNT',title:'金额',width:100,align:'right',pattern:'#0.00'},
	        {field:'ANSWER',title:'支付机构返回码',width:100,align:'center'},
	        {field:'COMMENTS',title:'支付机构返回结果',width:120,align:'center'},
	        {field:'OCCURBALA',title:'委托单金额',width:100,align:'center'},
	        {field:'FUNDSERIALNO',title:'支付机构委托单号',width:120,align:'center'},
	        {field:'OTHERTIME',title:'资金渠道支付时间',width:120,align:'center'},
	        {field:'OTHERSERIALNO',title:'支付机构流水',width:100,align:'center'}
	    ]],
	    pagination:true,
		pageNumber:1
	}); 
	
	$('#qrydetail').dialog('setTitle','支付机构对账详细信息').dialog('open');
}
