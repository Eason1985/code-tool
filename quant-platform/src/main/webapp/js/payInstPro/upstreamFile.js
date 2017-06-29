$(function() {
	// 初始化table
	$("#dg").datagrid(
	{
		url : 'qryUpSettleSt.do',
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
					title : '资金方式',
					width : 80,
					hidden : true
				},
				{
					field : 'orgname',
					title : '资金方式',
					width : 80,
					align : 'center'
				},
				{
					field : 'checkday',
					title : '结算日期',
					width : 90,
					align : 'center'
				},
				{
					field : 'numbers',
					title : '划款笔数',
					width : 80,
					align : 'center'
				},
				{
					field : 'amount',
					title : '划款金额',
					width : 80,
					align : 'right',
					pattern:'#0.00'
				},
				{
					field : 'lotno',
					title : '批次号',
					width : 60,
					height : 100,
					align : 'center'
				},
				{
					field : 'filestatus',
					title : '文件状态',
					width : 80,
					height : 100,
					align : 'center',
					formatter : function(value, row,
							index) {
						if (value == '0') {
							return "未生成";
						} else if (value == '1') {
							return "生成失败";
						} else if (value == '2'){
							return "生成成功";
						}
					}
				},
				{
					field : 'sendstatus',
					title : '发送状态(网关)',
					width : 80,
					height : 100,
					align : 'center',
					formatter : function(value, row,
							index) {
						if (value == '0') {
							return "未发送";
						} else if (value == '1') {
							return "发送失败";
						} else if (value == '2'){
							return "发送成功";
						}
					}
				},
				{
					field : 'itemid',
					title : '操作',
					width : 200,
					height : 1000,
					formatter : function(value, row,
							index) {
						return '<a class="_dglinkbutton" href="#" onclick="qrydetail('+row.orgcode+','+row.checkday+')" iconCls="icon-search">详情</a>&nbsp;&nbsp;<a class="_dglinkbutton" href="#" onclick="propost('+row.orgcode+','+row.checkday+')"  iconCls="icon-undo">生成结算文件</a>&nbsp;&nbsp;<a class="_dglinkbutton" onclick="downloadFile('+row.orgcode+','+row.checkday+')" href="#" iconCls="icon-save">下载</a>';
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
	
});
/**
 * 显示结果
 */
function result(obj) {
	
	$.ajax({
		type : 'post',
		url : 'queryUpResult.do?capitalmode='+obj,
		success : function(data) {
			data = $.parseJSON(data);
			if (!data.status) {
				alert("显示结果失败");
			}else{
				//刷新主数据窗口
				$('#dg').datagrid('reload');
			}
		}
	});
}
/**
 * 生成文件并发送
 */
function propost(capitalmode,checkday) {
	
	
	$.ajax({
		type : 'post',
		url : 'sendUpFile.do?capitalmode='+capitalmode+"&checkday="+checkday,
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
				alert("生成文件失败");
			}else{
				//刷新主数据窗口
				$('#dg').datagrid('reload');
			}
		},
		error: function (data, status, e)
		{
			$.messager.progress('close');
			alert("生成文件失败");
		}
	});
}
/**
 * 查询上行详细信息
 */
function qrydetail(capitalmode,checkday) {
	
	$("#detailDg").datagrid({
		url :"prepareUpData.do?capitalmode="+capitalmode+"&checkday="+checkday,
		fit:true,
		fitColums:true,
		rownumbers:true,
	    striped:true,
	    singleSelect:true,
	    columns:[[//CAPITALMODE=3, BALANCE=5212.01, NAMEINBANK=李四, REQUESTDATE=20150917, BANKNO=003, IDENTITYTYPE=0, TRADEACCO=999800007569, BUSINCODE=022, CUSTNO=000000007834, REQUESTNO=2015111700000822, BANKNAME=农行-单笔5万单日10万, FUNDCODE=620003, IDENTITYNO=321322197008124027, SHARETYPE=A, BANKACCO=6228480987654321789, FUNDTYPE=0}, {CAPITALMODE=3, BALANCE=30000.01, NAMEINBANK=李四, REQUESTDATE=20150917, BANKNO=003, IDENTITYTYPE=0, TRADEACCO=999800007569, BUSINCODE=022, CUSTNO=000000007834, REQUESTNO=2015111600000802, BANKNAME=农行-单笔5万单日10万, FUNDCODE=620003, IDENTITYNO=321322197008124027, SHARETYPE=A, BANKACCO=6228480987654321789, FUNDTYPE=0
	        {field:'requestno',title:'申请单号',width:100,align:'center'},
	        {field:'tradeacco',title:'交易帐号',width:100,align:'center'},
	        {field:'capitalmode',title:'渠道实例',width:100,align:'center'},
	        {field:'busincode',title:'业务代码',width:100,align:'center'},
	        {field:'fundcode',title:'基金代码',width:100,align:'center'},
	        {field:'sharetype',title:'份额类别',width:100},
	        {field:'balance',title:'扣款金额',width:100,align:'center',pattern:'#0.00'},
	        {field:'requestdate',title:'申请日期',width:100,align:'center'},
	        {field:'custno',title:'客户编号',width:100,align:'center'},
	        {field:'bankname',title:'银行名称',width:100,align:'center'},
	        {field:'bankno',title:'银行编码',width:100,align:'center'},
	        {field:'bankacco',title:'银行卡号',width:130,align:'center'},
	        {field:'agreementno',title:'托收协议号',width:100,align:'center'},
	        {field:'nameinbank',title:'银行客户姓名',width:100,align:'center'},
	        {field:'identityno',title:'证件号码',width:130,align:'center'},
	        {field:'identitytype',title:'证件类型',width:100,align:'center'},
	        {field:'fundtype',title:'基金类型',width:100,align:'center'},
	        {field:'updateday',title:'生成日期',width:100,align:'center'}
	    ]],
	    pagination:true,
		pageNumber:1
	}); 
	
	$('#qrydetail').dialog('setTitle','上行款文件详细信息').dialog('open');
}
/**
 * 数据导入
 */
function dataImport(obj){
	var requestdate = $.trim($("#checkDay").datebox('getValue'));
	var capitalmode = $.trim($('#capitalmode').combobox('getValue'));
	if(capitalmode == null || capitalmode.length < 1){
		alert("资金渠道空不能为空");
     // $.messager.alert('提示','资金渠道空不能为空','info');
	 /* $.messager.show({
			title:'提示',
			msg:'资金渠道空不能为空。',
			timeout:5000,
			showType:'slide'
		});*/
	  return;
	}
	if(requestdate == null || requestdate.length < 1){
	  alert("结算日期不能为空");
	  return;
	}
	$.ajax({
		type : 'post',
		url : 'initUpData.do?capitalmode='+capitalmode+'&requestdate='+requestdate,
		success : function(data) {
			data = $.parseJSON(data);
			if (!data.status) {
				alert("数据导入失败");
			}else{
				//刷新主数据窗口
				$('#dg').datagrid('reload');
				alert("数据导入成功");
			
			}
		}
	});
}
/**
 * 下载
 */
function downloadFile(capitalmode,checkday){
	var result = true;
	$.ajax({
		type : 'post',
		async:false,
		url : 'checkOkFile.do?capitalmode='+capitalmode+'&checkday='+checkday,
		success : function(data) {
			data = $.parseJSON(data);
			if (!data.status) {
				alert(data.mess);
				result = false;
			}
		}
	});
	if(!result)
		return;
	
	location.href="downloadFile.do?capitalmode="+capitalmode+"&checkday="+checkday;
}