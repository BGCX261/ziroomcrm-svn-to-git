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
												<td width="95%" class="STYLE1"><span class="STYLE3">你当前的位置</span>：[收付款单]</td>
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
													<th colspan="10">收付款单信息</th>
												</tr>
											</thead>
											<tbody>
											<tr height="20">
												<th>单据号：</th>
												<td>
													<s:property value="payPlanVo.billsVo.orderCode"/>
												</td>
												<th>流水号：</th>
												<td>
													<s:property value="payPlanVo.billsVo.serialNumber"/>
												</td>
												<th>应收款：</th>
												<td>
													<s:property value="payPlanVo.billsVo.receivables"/>
												</td>
												<th>实收款：</th>
												<td colspan="3">
													<s:property value="payPlanVo.billsVo.realCollection"/>
												</td>
											</tr>
											<tr height="20">
												<th>租金：</th>
												<td>
													<s:property value="payPlanVo.billsVo.rent"/>
												</td>
												<th>保洁费：</th>
												<td>
													<s:property value="payPlanVo.billsVo.cleaning"/>
												</td>
												<th>有线电视费：</th>
												<td>
													<s:property value="payPlanVo.billsVo.wired"/>
												</td>
												<th>佣金：</th>
												<td>
													<s:property value="payPlanVo.billsVo.commission"/>
												</td>
												<th>押金：</th>
												<td>
													<s:property value="payPlanVo.billsVo.deposit"/>
												</td>
											</tr>
											<tr height="20">
												<th>水费：</th>
												<td>
													<s:property value="payPlanVo.billsVo.water"/>
												</td>
												<th>供暖费：</th>
												<td>
													<s:property value="payPlanVo.billsVo.heatingFee"/>
												</td>
												<th>电费：</th>
												<td>
													<s:property value="payPlanVo.billsVo.electricity"/>
												</td>
												<th>燃气费：</th>
												<td>
													<s:property value="payPlanVo.billsVo.gasFee"/>
												</td>
												<th>其它费用：</th>
												<td>
													<s:property value="payPlanVo.billsVo.otherFee"/>
												</td>
											</tr>
											</tbody>
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
</body>
</html>