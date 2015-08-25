<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="common" uri="/common-tags"%>
<%@ taglib prefix="ziroom" uri="/ziroom-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
<link rel="stylesheet" type="text/css" href="css/style.css" media="screen">
<script type="text/javascript" src="js/jquery-1.6.min.js"></script>
<script type="text/javascript" src="js/ziroom/table.js"></script>
<script type="text/javascript" src="js/ziroom/page.js"></script>
<ziroom:msg/>
</head>

<body>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="30" background="images/tab_05.gif">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="12" height="30"><img src="images/tab_03.gif" width="12" height="30" /></td>
						<td>
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="46%" valign="middle">
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td width="5%">
													<div align="center">
														<img src="images/tb.gif" width="16" height="16" />
													</div>
												</td>
												<td width="95%" class="STYLE1"><span class="STYLE3">你当前的位置</span>：[客户资料]</td>
											</tr>
										</table>
									</td>
									<td width="54%">
										&nbsp;
									</td>
								</tr>
							</table>
						</td>
						<td width="16"><img src="images/tab_07.gif" width="16" height="30" /></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="8" background="images/tab_12.gif">&nbsp;</td>
						<td>
							<s:form action="" id="userAppointmentForm">
							<input type="hidden" name="userAppointmentVo.userId" id="usreId">
							<s:hidden name="userAppointmentVo.pageBean.currentPage" id="vpc"/>
							<s:token />
							<table cellpadding="0" cellspacing="1" class="tableList">
								<thead>
									<tr>
										<td width="3%">
											<div></div>
										</td>
										<td width="3%">
											<div>序号</div>
										</td>
										<td>
											<div>客户姓名</div>
										</td>
										<td>
											<div>电话</div>
										</td>
										<td>
											<div>待看次数</div>
										</td>
										<td>
											<div>基本操作</div>
										</td>
									</tr>
								</thead>
								<tbody>
									<s:set name="pageBean" value="userAppointmentVo.pageBean"/>
									<s:set name="seq" value="#pageBean.pageSize*(#pageBean.currentPage-1)"/>
									<s:iterator id="v" value="userAppointmentVo.userAppointmentVoes">
									<s:set name="seq" value="#seq+1"/>
									<tr height="20">
										<td>
											<div align="left"><img src="images/plus.gif" style="curse:hand" onclick="showAppointment(this, <s:property value="#seq"/>)"/></div>
										</td>
										<td>
											<div align="left"><s:property value="#seq"/></div>
										</td>
										<td>
											<div align="left"><s:property value="#v.userName"/></div>
										</td>
										<td>
											<div align="left"><s:property value="#v.userMobile"/></div>
										</td>
										<td>
											<div align="left">
												<s:property value="#v.lookCount"/>
											</div>
										</td>
										<td>
											<div align="center">
												<a href="javascript:void(0)" onclick="findUserAppiontment(<s:property value="#v.userId"/>);">[修改]</a>
											</div>
										</td>
									</tr>
									<tr style="display:none;" id="room<s:property value="#seq"/>" >
										<td colspan="2">&nbsp;</td>
										<td colspan="9">
											<table width="100%" cellpadding="0" cellspacing="1" class="tableList">
												<thead>
													<tr>
														<td>
															<div>预约单号</div>
														</td>
														<td>
															<div>房间编号</div>
														</td>
														<td>
															<div>房间名称</div>
														</td>
														<td>
															<div>预约时间</div>
														</td>
													</tr>
												</thead>
												<tbody>
													<s:iterator id="r" value="#v.appointmentVoes">
													<tr height="20">
														<td>
															<div align="left"><s:property value="#r.id"/></div>
														</td>
														<td>
															<div align="left"><s:property value="#r.roomCode"/></div>
														</td>
														<td>
															<div align="left">
																<s:property value="#r.roomName"/>
															</div>
														</td>
														<td>
															<div align="left"><s:date name="#r.choosetime" format="yyyy-MM-dd hh:mm:ss"/></div>
														</td>
													</tr>
													</s:iterator>
												</tbody>
											</table>
										</td>
									</tr>
									</s:iterator>
								</tbody>
							</table>
							</s:form>
						</td>
						<td width="8" background="images/tab_15.gif">&nbsp;</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td height="35" background="images/tab_19.gif">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="12" height="35"><img src="images/tab_18.gif" width="12" height="35" /></td>
						<td>
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td class="STYLE1">&nbsp;&nbsp;共有 <s:property value="userAppointmentVo.pageBean.totalSize"/>条记录，当前第 <s:property value="userAppointmentVo.pageBean.currentPage"/>/<s:property value="userAppointmentVo.pageBean.totalPage"/>页</td>
									<td>
										<s:form action="searchUserAppointment.do" id="searchUserAppointmentForm">
											<s:hidden name="userAppointmentVo.pageBean.currentPage" id="pageBean_currentPage"/>
											<ziroom:search preffiex="userAppointmentVo" searchBean="userAppointmentVo"/>
											<table border="0" align="right" cellpadding="0" cellspacing="0">
												<tr>
													<td width="40"><img src="images/first.gif" width="37" height="15" onclick="first(1,'searchUserAppointmentForm', 'pageBean_currentPage');"/></td>
													<td width="45"><img src="images/back.gif" width="43" height="15" onclick="previousPage(<s:property value="userAppointmentVo.pageBean.currentPage"/>,'searchUserAppointmentForm', 'pageBean_currentPage');"/></td>
													<td width="45"><img src="images/next.gif" width="43" height="15" onclick="nextPage(<s:property value="userAppointmentVo.pageBean.currentPage"/>,'searchUserAppointmentForm', 'pageBean_currentPage', <s:property value="userAppointmentVo.pageBean.totalPage"/>);"/></td>
													<td width="40"><img src="images/last.gif" width="37" height="15" onclick="last(<s:property value="userAppointmentVo.pageBean.totalPage"/>,'searchUserAppointmentForm', 'pageBean_currentPage');"/></td>
													<td width="100">
														<div align="center">
															<!-- 
															<span class="STYLE1">转到第 <input name="textfield" type="text" size="4" style="height: 12px; width: 20px; border: 1px solid #999999;" /> 页 </span>
															 -->
														</div>
													</td>
													<td width="40"><!-- <img src="images/go.gif" width="37" height="15" /> --></td>
												</tr>
											</table>
										</s:form>
									</td>
								</tr>
							</table>
						</td>
						<td width="16"><img src="images/tab_20.gif" width="16" height="35" /></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<script type="text/javascript">
		/** 查找 */
		function findUserAppiontment(id) {
			$("#usreId").val(id);
			$("#userAppointmentForm").attr("action", "findUserAppointment.do");
			$("#userAppointmentForm").submit();
		}
		/** 显示 */
		function showAppointment(o, id, appiontmentid) {
			var s = $(o).attr("src");
			if(s == "images/plus.gif") {
				$(o).attr("src", "images/minus.gif");
				$("#room"+id).show();
			} else {
				$(o).attr("src", "images/plus.gif");
				$("#room"+id).hide();
			}
		}
	</script>
</body>
</html>