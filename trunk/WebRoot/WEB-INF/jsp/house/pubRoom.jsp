<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="common" uri="/common-tags"%>
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
		var checkInTime = $("#checkInTime").val();
		if(checkInTime=="") {
			alert("请输入入住时间");
		} else {
			$("#pubRoomForm").submit();
		}
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
												<td width="95%" class="STYLE1"><span class="STYLE3">你当前的位置</span>：[房间发布]</td>
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
							<s:form action="pubRoom.do" id="pubRoomForm">
							<s:token/>
							<s:hidden name="vo.pageBean.currentPage"/>
							<s:hidden name="vo.roomId"/>
							<table cellpadding="0" cellspacing="1" width="100%">
								<tr height="20">
									<td>&nbsp;</td>
								</tr>
								<tr>
									<td align="center">
										<table cellpadding="0" cellspacing="1" class="tableForm" width="80%">
											<thead>
												<tr>
													<th colspan="10">房间信息</th>
												</tr>
											</thead>
											<tbody>
											<tr height="20">
												<th>房间名称：</th>
												<td><s:property value="vo.roomName"/></td>
												<th>房间编号：</th>
												<td><s:property value="vo.houseVo.houseCode"/>-<s:property value="vo.roomCode"/></td>
												<th>所在区域：</th>
												<td><s:property value="%{@com.ziroom.common.manager.DictManager@getName('T_DISTRICT', vo.houseVo.counties)}"/><s:property value="%{@com.ziroom.common.manager.DictManager@getName('T_BUSINESS', vo.houseVo.shopping)}"/></td>
											</tr>
											<tr height="20">
												<th>环线(方位)：</th>
												<td><s:property value="%{@com.ziroom.common.manager.DictManager@getName('T_DISTRICT', vo.houseVo.cycle)}"/><s:property value="%{@com.ziroom.common.manager.DictManager@getName('T_DISTRICT', vo.houseVo.cycleFace)}"/></td>
												<th>地铁线及站点：</th>
												<td colspan="3"><s:property value="%{@com.ziroom.common.manager.DictManager@getName('T_SUBWAY', vo.houseVo.subwayLine)}"/>/<s:property value="%{@com.ziroom.common.manager.DictManager@getName('T_SUBWAYSTATION', vo.houseVo.subwayStations)}"/></td>
											</tr>
											<tr height="20">
												<th>楼层：</th>
												<td><s:property value="vo.floor"/>/<s:property value="vo.houseVo.totalFloor"/></td>
												<th>建筑类型：</th>
												<td><s:property value="%{@com.ziroom.common.manager.DictManager@getName('T_SUBWAY', vo.houseVo.buildType)}"/></td>
												<th>地址：</th>
												<td><s:property value="vo.building"/><s:property value="vo.houseVo.unit"/></td>
											</tr>
											<tr height="20">
												<th>房间朝向：</th>
												<td><s:property value="%{@com.ziroom.common.manager.DictManager@getName('HOUSE_FACE', vo.houseVo.houseFace)}"/></td>
												<th>房间面积：</th>
												<td><s:property value="vo.roomArea"/></td>
												<th>供暖方式：</th>
												<td><s:property value="%{@com.ziroom.common.manager.DictManager@getName('HEATING_TYPE', vo.houseVo.heating)}"/></td>
											</tr>
											<tr height="20">
												<th>房屋居室：</th>
												<td><s:property value="vo.houseVo.decorateBedroomNum"/>室<s:property value="vo.houseVo.decorateLivingNum"/>厅<s:property value="vo.houseVo.decorateKitchenNum"/>卫</td>
												<th>房间价格：</th>
												<td><s:property value="vo.rentFee"/></td>
												<th>出租类型：</th>
												<td colspan="3"><s:property value="%{@com.ziroom.common.manager.DictManager@getName('RENT_TYPE', vo.houseVo.rentType)}"/></td>
											</tr>
											<tr height="20">
												<th>管家：</th>
												<td><s:property value="vo.houseVo.stewardName"/></td>
												<th>管家电话：</th>
												<td colspan="3"><s:property value="vo.houseVo.stewardPhone"/></td>
											</tr>
											<tr height="20">
												<th>经济人：</th>
												<td><s:property value="vo.houseVo.agentName"/></td>
												<th>经纪人电话：</th>
												<td colspan="3"><s:property value="vo.houseVo.agentPhone"/></td>
											</tr>
											<tr height="20">
												<th>房间状态：</th>
												<td colspan="2"><s:property value="%{@com.ziroom.common.manager.DictManager@getName('HOUSE_STATUS', vo.houseStatus)}"/></td>
												<th>可入住时间：</th>
												<td colspan="2"><s:textfield name="vo.checkInTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" readonly="true" cssClass="Wdate" id="checkInTime"/></td>
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