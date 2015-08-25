<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
<link rel="stylesheet" type="text/css" href="css/style.css" media="screen">
<script type="text/javascript" src="js/jquery-1.6.min.js"></script>
<script type="text/javascript" src="js/ziroom/table.js"></script>
<script type="text/javascript" src="js/ziroom/menu.js"></script>
<script type="text/javascript" src="js/ziroom/page.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	function doSubmit() {
		salesForm.submit();
	}
</script>
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
												<td width="95%" class="STYLE1"><span class="STYLE3">你当前的位置</span>：[销售机会]</td>
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
							<s:form action="saveSales.do" id="salesForm">
							<table cellpadding="0" cellspacing="1" width="100%">
								<tr height="20">
									<td>&nbsp;</td>
								</tr>
								<tr>
									<td align="center">
										<table cellpadding="0" cellspacing="1" class="tableForm" width="80%">
											<thead>
												<tr>
													<th colspan="10">销售机会</th>
												</tr>
											</thead>
											<tbody>
											<tr height="20">
												<th>客户姓名：</th>
												<td><s:textfield name="salesVo.custName"/></td>
												<th>联系电话：</th>
												<td><s:textfield name="salesVo.telphone"/></td>
												<th>机会类型：</th>
												<td>
													<s:select name="salesVo.type" list="#{'00004':'求租','00003':'出租'}" headerKey=""
														headerValue="请选择"
														listKey="key"
														listValue="value" value="salesVo.type">
													</s:select>
												</td>
											</tr>
											<tr height="20">
												<th>机会名称：</th>
												<td><s:textfield name="salesVo.salesName"/></td>
												<th>类型：</th>
												<td><s:textfield name="salesVo.salesType"/></td>
												<th>来源：</th>
												<td><s:textfield name="salesVo.origin"/></td>
											</tr>
											<tr height="20">
												<th>阶段：</th>
												<td><s:textfield name="salesVo.stage"/></td>
												<th colspan="3">成交几率：</th>
												<td><s:textfield name="salesVo.chance"/></td>
											</tr>
											<tr height="20">
												<th>阶段描述：</th>
												<td colspan="5"><s:textfield name="salesVo.stageDesc"/></td>
											</tr>
											<tr height="20">
												<th>户型结构：</th>
												<td><s:textfield name="salesVo.family"/></td>
												<th>区域范围：</th>
												<td><s:textfield name="salesVo.region"/></td>
												<th>装修程度：</th>
												<td><s:textfield name="salesVo.decorate"/></td>
											</tr>
											<tr height="20">
												<th>房屋类型：</th>
												<td><s:textfield name="salesVo.houseType"/></td>
												<th>租住方式：</th>
												<td><s:textfield name="salesVo.watfor"/></td>
												<th>面积：</th>
												<td><s:textfield name="salesVo.area"/></td>
											</tr>
											<tr height="20">
												<th>数量：</th>
												<td><s:textfield name="salesVo.houseType"/></td>
												<th colspan="3">价格范围：</th>
												<td><s:textfield name="salesVo.watfor"/></td>
											</tr>
											<tr height="20">
												<th>基础设施：</th>
												<td colspan="5"><s:textfield name="salesVo.infrastructure"/></td>
											</tr>
											<tr height="20">
												<th>配套设施：</th>
												<td colspan="5"><s:textfield name="salesVo.facilities"/></td>
											</tr>
											<tr height="20">
												<th>其它描述：</th>
												<td colspan="5"><s:textfield name="salesVo.otherDesc"/></td>
											</tr>
											
											<tr height="20">
												<th>建筑年代：</th>
												<td><s:textfield name="salesVo.buildingYear"/></td>
												<th colspan="3">小区名称：</th>
												<td></td>
											</tr>
											<tr height="20">
												<th>楼号：</th>
												<td><s:textfield name="salesVo.floorNo"/></td>
												<th>单元号：</th>
												<td><s:textfield name="salesVo.unit"/></td>
												<th>门牌号：</th>
												<td><s:textfield name="salesVo.apartment"/></td>
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
</body>
</html>