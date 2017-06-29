<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path_ = request.getScheme() + "://" + request.getServerName()
			+ ":" + request.getServerPort() + request.getContextPath();
%>
<header id="header">
	<div class="header-gradient-bg"></div>
	<div class="header-bd clearfix">
		<h1 class="site-logo" id="site-logo"><a href="#">eason科技</a></h1>
		<nav class="head-menu ui-menu">
			<ul class="head-menu-list clearfix">
				<ri:CheckRight resCode="RS001001">
					<li class="head-menu-item">
						<a href="javascript:;" class="head-menu-hd"><span class="text">日常维护</span><i class="icon-angle"></i></a>
						<div class="dropdown-menu">
							<ul>
								<ri:CheckRight resCode="RS001001001">
									<li class="dropdown-menu-item">
										<a href="javascript:;" ><span class="text">权限管理</span><i class="icon-more"></i></a>
										<div class="dropdown-menu">
											<ul>
												<ri:CheckRight resCode="RS001001001001">
													<li class="dropdown-menu-item">
														<a href="<%=path_%>/searchTResourceAction.action">资源配置</a>
													</li>
												</ri:CheckRight>
												
												<ri:CheckRight resCode="RS001001001002">
													<li class="dropdown-menu-item">
														<a href="<%=path_%>/searchTRoleAction.action">角色管理</a>
													</li>
												</ri:CheckRight>
												
												<ri:CheckRight resCode="RS001001001003">
													<li class="dropdown-menu-item">
														<a href="<%=path_%>/searchTEmpUserAction.action">员工管理</a>
													</li>
												</ri:CheckRight>
											</ul>
										</div>
									</li>
								</ri:CheckRight>
								<!-- 
								<ri:CheckRight resCode="RS001001002">
									<li>
										<span>
											<a href="<%=path_%>/process/allRollback!skipPage.action">日初恢复</a>
										</span>
									</li>
								</ri:CheckRight>
								 -->
								
								
								<ri:CheckRight resCode="RS001001004">
									<li class="dropdown-menu-item">
										<a href="<%=path_%>/jsp/voucher/createVoucher.jsp">手工凭证</a>
									</li>
								</ri:CheckRight>
								<ri:CheckRight resCode="RS001001005">
									<li class="dropdown-menu-item">
										<a href="<%=path_%>/jsp/sfDetail/searchQsSfDetailPage.jsp">清算日期调整</a>
									</li>
								</ri:CheckRight>
								<ri:CheckRight resCode="RS001001006">
									<li class="dropdown-menu-item">
										<a href="<%=path_%>/jsp/compressFile/compressFile.jsp">手工压缩文件</a>
									</li>
								</ri:CheckRight>
								<ri:CheckRight resCode="RS001001007">
									<li class="dropdown-menu-item">
										<a href="<%=path_%>/jsp/receiveFileAction!toReceiveFilePage.action">自动接收交易文件</a>
									</li>
								</ri:CheckRight>
								<ri:CheckRight resCode="RS001001003">
									<li class="dropdown-menu-item">
										<a href="<%=path_%>/process/partRollback!skipPage.action">恢复(划款指令数据准备之前)</a>
									</li>
								</ri:CheckRight>
								<ri:CheckRight resCode="RS001001">
									<li class="dropdown-menu-item">
										<a href="<%=path_%>/sysInitProcessGoBackAction!sysInitProcessGoBack.action">恢复(清算日初始化之前)</a>
									</li>
								</ri:CheckRight>
							</ul>
						</div>
					</li>
				</ri:CheckRight>
				<ri:CheckRight resCode="RS001002">
					<li class="head-menu-item">
						<a href="<%=path_%>/jsp/basicParam/basicParam.jsp" class="head-menu-hd"><span class="text">参数维护</span></a>
					</li>
				</ri:CheckRight>
				<ri:CheckRight resCode="RS001003">
					<li class="head-menu-item">
						<a href="<%=path_%>/process/processViewAction!toProcessViewAction.action" class="head-menu-hd"><span class="text">清算流程</span></i></a>
					</li>
				</ri:CheckRight>
				<ri:CheckRight resCode="RS001004">
					<li class="head-menu-item">
						<a href="javascript:;" class="head-menu-hd"><span class="text">查询</span><i class="icon-angle"></i></a>
						<div class="dropdown-menu">
							<ul>
								<ri:CheckRight resCode="RS001004001">
									<li>
										<span>
											<a href="<%=path_%>/jsp/select/ZXQueryOfOriginalData.jsp">指令正向查询</a>
										</span>
									</li>
								</ri:CheckRight>
								<ri:CheckRight resCode="RS001004002">
									<li class="dropdown-menu-item">
										<a href="<%=path_%>/jsp/select/importdata/searchQsPayOrderSuitePage.jsp">指令逆向查询</a>
									</li>
								</ri:CheckRight>
								<ri:CheckRight resCode="RS001004002">
									<li class="dropdown-menu-item">
										<a href="<%=path_%>/getListData!getListData.action">凭证查询</a>
									</li>
								</ri:CheckRight>
									<li class="dropdown-menu-item">
										<a href="<%=path_%>/jsp/voucher/searchStatementAction!queryTotalStatementBalance.action">对账</a>
									</li>
							</ul>
						</div>
					</li>
				</ri:CheckRight>
				<%-- <ri:CheckRight resCode="RS001005">
					<li class="head-menu-item">
						<a href="javascript:;" class="head-menu-hd"><span class="text">报表</span></a>
					</li>
				</ri:CheckRight> --%>
				
				<li class="head-menu-item">
					<span>
						<a href="<%=path_%>/struts_ld_qsDownPaymentBatch/searchQsDownPaymentBatchAction.action" class="head-menu-hd"><span class="text">下行划款批次数据生成</span></a>
					</span>
				</li>
				
			</ul>
		</nav>
		<div class="head-user-util">
			<span>
				<i class="icon-remark"></i>当前工作日：${currentWorkDay}
			</span>
			<span>
				<i class="icon-remark"></i>下一工作日：${nextWorkDay}
			</span>
			&nbsp;&nbsp;&nbsp;
			<span class="logined-user">
				<i class="icon-user"></i>登录人：${loginUser.user_name}
			</span>
			<a id="changePass" href="javascript:;"><i class="icon-modify"></i>密码修改</a>
			<a href="<%=path_ %>/struts_ld_login/logoutAction.action"><i class="icon-logout"></i>退出</a>
		</div>
		
		<script type="text/javascript">
			//新增
                $('#changePass').click(function(){
                    $('<div id="dialog_changePass"></div>').dialog({
                        title: '密码修改',
                        width: 800,
                        height: 300,
                        top:100,
                        href: 'changePassPage.action',
                        modal: true,
                        method: "POST",
                        onClose: function(){
                            $(this).dialog("destroy");
                        },
                        buttons: [
                            {
                                text: "修 改",
                                handler: function(e){
                               	  var changePassForm = $('#changePassForm');
	                               	  	 changePassForm.form({
	                                        url:'changePassAction.action',
	                                        onSubmit: function(){
	                                        },
	                                        success:function(data){
	                                        	data = JSON.parse(data);
	                                        	if(data.status){
	                                        		$.messager.alert("提示信息","密码修改成功","info");
	                                        		$('#dialog_changePass').dialog('close');
												}else{
													$.messager.alert("提示信息",data.message,"info");
												}
	                                        }
	                                    });
	                                if(changePassForm.form("validate")){
	                                	changePassForm.submit();
	                                }
                                }
                            },
                            {
                                text: "取 消",
                                handler: function(e){
                                    $(this).dialog("close");
                                }
                            }
                        ]
                    });
                });
		</script>
	</div>
</header>
