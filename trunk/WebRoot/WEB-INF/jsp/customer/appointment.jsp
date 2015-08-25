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
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
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
												<td width="95%" class="STYLE1"><span class="STYLE3">你当前的位置</span>：[带看单]</td>
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
							<s:form action="" id="appointmentForm">
							<input type="hidden" name="appointmentVo.id" id="appointmentId" />
							<input type="hidden" name="appointmentVo.roomId" id="roomId" />
							<s:hidden name="appointmentVo.pageBean.currentPage" id="apc"/>
							<s:token />
							<table cellpadding="0" cellspacing="1" class="tableList">
								<tr>
									<th style="font-size:12">待看单号：</th><td><s:textfield name="appointmentVo.argumentsBeans[0].values[0]" cssStyle="width:100px;"/></td>
									<th style="font-size:12">房间编号：</th><td><s:textfield name="appointmentVo.argumentsBeans[1].values[0]" cssStyle="width:100px;"/></td>
									<th style="font-size:12">提交日期：</th><td><s:textfield name="appointmentVo.argumentsBeans[2].values[0]" cssStyle="width:100px;" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" readonly="true" cssClass="Wdate"/></td>
									<th style="font-size:12">是否待看：</th><td>
										<s:select list="#{'Y':'已带看','N':'未带看'}" 
											name="appointmentVo.argumentsBeans[3].values[0]" 
											headerKey=""
											headerValue="请选择"
											listKey="key"
											listValue="value" value="appointmentVo.argumentsBeans[3].values[0]">
										</s:select>
									</td>
									<th style="font-size:12">客户电话：</th><td><s:textfield name="appointmentVo.searchBeans[0].argumentsBeans[0].values[0]" cssStyle="width:100px;"/></td>
									<th style="font-size:12">管家：</th><td>
										<s:action name="searchUserByDeptCode" id="steward" executeResult="true">
											<s:param name="userVo.deptCode" value="'A18109'"/>
											<s:param name="userVo.setidJobcode" value="'专员'"/>
										</s:action>
										<s:select list="#steward.userVo.userVoes" 
											name="appointmentVo.argumentsBeans[4].values[0]" 
											id="steward"
											headerKey=""
											headerValue="请选择"
											listKey="staffid"
											listValue="staffName" value="appointmentVo.argumentsBeans[4].values[0]">
										</s:select>
									</td>
									<th style="font-size:12">主管：</th><td>
										<s:action name="searchUserByDeptCode" id="leader" executeResult="true">
											<s:param name="userVo.deptCode" value="'A18109'"/>
											<s:param name="userVo.setidJobcode" value="'主管'"/>
										</s:action>
										<s:select list="#leader.userVo.userVoes" 
											name="appointmentVo.argumentsBeans[5].values[0]" 
											headerKey=""
											headerValue="请选择"
											listKey="deptCode"
											listValue="staffName" value="appointmentVo.argumentsBeans[5].values[0]">
										</s:select>
									</td>
								</tr>
								<tr>
									<th style="font-size:12">大区：</th><td><s:textfield name="appointmentVo1.argumentsBeans[6].values[0]" cssStyle="width:100px;"/></td>
									<th style="font-size:12">运营区域：</th><td><s:textfield name="appointmentVo1.argumentsBeans[7].values[0]" cssStyle="width:100px;"/></td>
									<th style="font-size:12">门店：</th><td><s:textfield name="appointmentVo1.argumentsBeans[8].values[0]" cssStyle="width:100px;"/></td>
									<th style="font-size:12">经济人：</th><td><s:textfield name="appointmentVo1.argumentsBeans[9].values[0]" cssStyle="width:100px;"/></td>
									<td colspan="6"><input type="button" value="查询" onclick="searchAppointment();"></td>
								</tr>
							</table>
							<table cellpadding="0" cellspacing="1" class="tableList">
								<thead>
									<tr>
										<td width="8%">
											<div>序号</div>
										</td>
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
											<div>管家</div>
										</td>
										<td>
											<div>经济人</div>
										</td>
										<td>
											<div>是否待看</div>
										</td>
										<td>
											<div>基本操作</div>
										</td>
									</tr>
								</thead>
								<tbody>
									<s:set name="pageBean" value="appointmentVo.pageBean"/>
									<s:set name="seq" value="#pageBean.pageSize*(#pageBean.currentPage-1)"/>
									<s:iterator id="v" value="appointmentVo.appointmentVoes">
									<s:set name="seq" value="#seq+1"/>
									<tr height="20">
										<td>
											<div align="left"><s:property value="#seq"/></div>
										</td>
										<td>
											<div align="left"><s:property value="#v.id"/></div>
										</td>
										<td>
											<div align="left"><s:property value="#v.roomCode"/></div>
										</td>
										<td>
											<div align="left"><s:property value="#v.roomName"/></div>
										</td>
										<td>
											<div align="left"><s:property value="#v.stewardName"/></div>
										</td>
										<td>
											<div align="left"><s:property value="#v.agentName"/></div>
										</td>
										<td>
											<div align="left">
												<s:if test='#v.release=="Y"'>
													已带看
												</s:if>
												<s:else>
													未带看
												</s:else>
											</div>
										</td>
										<td>
											<div align="center">
												<a href="javascript:void(0)" onclick="findAppointment(<s:property value="#v.id"/>)">
												<s:if test='#v.release=="Y"'>
													[已带看]
												</s:if>
												<s:else>
													[未带看]
												</s:else>
												</a>
												<a href="javascript:void(0)">[删除]</a>
											</div>
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
									<td class="STYLE1">&nbsp;&nbsp;共有 <s:property value="appointmentVo.pageBean.totalSize"/>条记录，当前第 <s:property value="appointmentVo.pageBean.currentPage"/>/<s:property value="appointmentVo.pageBean.totalPage"/>页</td>
									<td>
										<s:form action="searchAppointment.do" id="searchAppointmentForm">
											<s:hidden name="appointmentVo.pageBean.currentPage" id="pageBean_currentPage"/>
											<ziroom:search preffiex="appointmentVo" searchBean="appointmentVo"/>
											<table border="0" align="right" cellpadding="0" cellspacing="0">
												<tr>
													<td width="40"><img src="images/first.gif" width="37" height="15" onclick="first(1,'searchAppointmentForm', 'pageBean_currentPage');"/></td>
													<td width="45"><img src="images/back.gif" width="43" height="15" onclick="previousPage(<s:property value="appointmentVo.pageBean.currentPage"/>,'searchAppointmentForm', 'pageBean_currentPage');"/></td>
													<td width="45"><img src="images/next.gif" width="43" height="15" onclick="nextPage(<s:property value="appointmentVo.pageBean.currentPage"/>,'searchAppointmentForm', 'pageBean_currentPage', <s:property value="appointmentVo.pageBean.totalPage"/>);"/></td>
													<td width="40"><img src="images/last.gif" width="37" height="15" onclick="last(<s:property value="appointmentVo.pageBean.totalPage"/>,'searchAppointmentForm', 'pageBean_currentPage');"/></td>
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
		function findAppointment(id) {
			$("#appointmentId").val(id);
			$("#appointmentForm").attr("action", "findAppointment.do");
			$("#appointmentForm").submit();
		}
		function searchAppointment() {
			$("#apc").val(1);
			$("#appointmentForm").attr("action", "searchAppointment.do");
			$("#appointmentForm").submit();
		}
	</script>
</body>
</html>