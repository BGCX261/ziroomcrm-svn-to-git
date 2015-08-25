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
<script type="text/javascript" src="js/ziroom/menu.js"></script>
<script type="text/javascript" src="js/ziroom/page.js"></script>
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/struts/jquery-validator-rule.js"></script>
<script type="text/javascript" src="js/struts/struts-validator.js"></script>
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
										<table border="0" align="right" cellpadding="0" cellspacing="0">
											<tr>
												<td width="60">
													
												</td>
												<td width="60">
													
												</td>
												<td width="60">
													
												</td>
												<td width="52">
													
												</td>
											</tr>
										</table>
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
							<s:form action="saveAppointment.do" id="appointmentForm">
							<s:token />
							<s:hidden name="appointmentVo.pageBean.currentPage"/>
							<s:hidden name="appointmentVo.id"/>
							<ziroom:search preffiex="appointmentVo" searchBean="appointmentVo"/>
							<table cellpadding="0" cellspacing="1" width="100%">
								<tr height="20">
									<td>&nbsp;</td>
								</tr>
								<tr>
									<td align="center">
										<table cellpadding="0" cellspacing="1" class="tableForm" width="80%">
											<thead>
												<tr>
													<th colspan="10">带看单信息</th>
												</tr>
											</thead>
											<tbody>
											<tr height="20">
												<th>订单号：</th>
												<td>
													<s:property value="appointmentVo.id"/>
												</td>
												<td colspan="4">
													<s:property value="appointmentVo.roomName"/>
												</td>
												<th>租金：</th>
												<td>
													<s:property value="appointmentVo.rentFee"/>
												</td>
											</tr>
											<tr height="20">
												<th>房间编号：</th>
												<td>
													<s:property value="appointmentVo.roomCode"/>
												</td>
												<th>预约时间：</th>
												<td>
													<s:date name="appointmentVo.choosetime" format="yyyy年MM月dd日 h:mm"/>
												</td>
												<th>是否待看：</th>
												<td colspan="3">
													<s:select list="#{'N':'未待看','Y':'已待看'}"
													name="appointmentVo.release" 
													listKey="key"
													listValue="value" value="appointmentVo.release">
													</s:select>
												</td>
											</tr>
											<tr height="20">
												<th>客户电话：</th>
												<td colspan="7">
													<s:property value="appointmentVo.userAppointmentVo.userMobile"/>
												</td>
											</tr>
											<tr height="20">
												<th>客户姓名：</th>
												<td>
													<s:textfield name="appointmentVo.userAppointmentVo.userName"/>
												</td>
												<th>年龄：</th>
												<td>
													<s:textfield name="appointmentVo.userAppointmentVo.userAge"/>
												</td>
												<th>性别：</th>
												<td>
													<s:textfield name="appointmentVo.userAppointmentVo.userGender"/>
												</td>
												<th>期望价位：</th>
												<td>
													<s:textfield name="appointmentVo.userAppointmentVo.userPrice"/>
												</td>
											</tr>
											<tr height="20">
												<th>入住时间：</th>
												<td>
													<s:textfield name="appointmentVo.userAppointmentVo.userRentDate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'});" format="yyyy-MM-dd"/>
												</td>
												<th>职业：</th>
												<td>
													<s:textfield name="appointmentVo.userAppointmentVo.userOccupation"/>
												</td>
												<th>租房原因：</th>
												<td>
													<s:textfield name="appointmentVo.userAppointmentVo.userCause"/>
												</td>
												<th>爱好：</th>
												<td>
													<s:textfield name="appointmentVo.userAppointmentVo.userHobby"/>
												</td>
											</tr>
											<tr height="20">
												<th>客户IM：</th>
												<td colspan="7">
													<s:textfield name="appointmentVo.userAppointmentVo.userImType"/>&nbsp;<s:textfield name="appointmentVo.userAppointmentVo.userImNum"/>
												</td>
											</tr>
											<tr height="20">
												<th>备注信息：</th>
												<td colspan="7">
													<s:textarea name="appointmentVo.userAppointmentVo.userNotes" rows="5" cols="80"></s:textarea>
												</td>
											</tr>
											</tbody>
											<tr>
												<td align="center" colspan="10"><input type="button" value="确认" onclick="doSubmit();" /></td>
											</tr>
											<tr height="20">
												<td align="center" colspan="10">&nbsp;</td>
											</tr>
										</table>
									</td>
								</tr>
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
							&nbsp;
						</td>
						<td width="16"><img src="images/tab_20.gif" width="16" height="35" /></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<script type="text/javascript">
		function doSubmit() {
			//if(strutsValidator("","sowingForm",[])) {
				$("#appointmentForm").submit();
			//}
		}
		/** 显示查询条件 */
		function showHouseCode(value) {
			if(value=="10000002") {
				$("#_houseCode").show();
			} else {
				$("#_houseCode").hide();
			}
		}
	</script>
</body>
</html>