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
<link rel="stylesheet" type="text/css" href="fancybox/jquery.fancybox.css" media="screen" />
<script type="text/javascript" src="fancybox/jquery.fancybox-1.2.1.js"></script>
<script type="text/javascript" src="fancybox/jquery.fancybox-1.2.1.pack.js"></script>
<script type="text/javascript">
	function doSubmit() {
		var checkInTime = $("#checkInTime").val();
		if(checkInTime=="") {
			alert("请输入入住时间");
		} else {
			$("#pubHouseForm").submit();
		}
		
	}
	$(function(){
		$("a.preview").fancybox();
	});
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
												<td width="95%" class="STYLE1"><span class="STYLE3">你当前的位置</span>：[房源详情]</td>
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
							<table cellpadding="0" cellspacing="1" width="100%">
								<tr height="20">
									<td>&nbsp;</td>
								</tr>
								<tr>
									<td align="center">
										<table cellpadding="0" cellspacing="1" class="tableForm" width="80%">
											<thead>
												<tr>
													<th colspan="10">房源信息</th>
												</tr>
											</thead>
											<tbody>
											<tr height="20">
												<th>房源名称：</th>
												<td style="font-size:12"><s:property value="vo.title"/></td>
												<th>房源编号：</th>
												<td style="font-size:12"><s:property value="vo.houseCode"/></td>
												<th>所在区域：</th>
												<td style="font-size:12"><s:property value="%{@com.ziroom.common.manager.DictManager@getName('T_DISTRICT', vo.counties)}"/><s:property value="%{@com.ziroom.common.manager.DictManager@getName('T_BUSINESS', vo.shopping)}"/></td>
											</tr>
											<tr height="20">
												<th>环线(方位)：</th>
												<td style="font-size:12"><s:property value="%{@com.ziroom.common.manager.DictManager@getName('T_DISTRICT', vo.cycle)}"/><s:property value="%{@com.ziroom.common.manager.DictManager@getName('T_DISTRICT', vo.cycleFace)}"/></td>
												<th>地铁线及站点：</th>
												<td colspan="3" style="font-size:12"><s:property value="%{@com.ziroom.common.manager.DictManager@getName('T_SUBWAY', vo.subwayLine)}"/>/<s:property value="%{@com.ziroom.common.manager.DictManager@getName('T_SUBWAYSTATION', vo.subwayStations)}"/></td>
											</tr>
											<tr height="20">
												<th>楼层：</th>
												<td style="font-size:12"><s:property value="vo.floor"/>/<s:property value="vo.totalFloor"/></td>
												<th>建筑类型：</th>
												<td style="font-size:12"><s:property value="%{@com.ziroom.common.manager.DictManager@getName('T_SUBWAY', vo.buildType)}"/></td>
												<th>地址：</th>
												<td style="font-size:12"><s:property value="vo.building"/><s:property value="vo.unit"/></td>
											</tr>
											<tr height="20">
												<th>朝向：</th>
												<td style="font-size:12"><s:property value="%{@com.ziroom.common.manager.DictManager@getName('HOUSE_FACE', vo.houseFace)}"/></td>
												<th>面积：</th>
												<td style="font-size:12"><s:property value="vo.houseArea"/></td>
												<th>供暖方式：</th>
												<td style="font-size:12"><s:property value="%{@com.ziroom.common.manager.DictManager@getName('HEATING_TYPE', vo.heating)}"/></td>
											</tr>
											<tr height="20">
												<th>居室：</th>
												<td style="font-size:12"><s:property value="vo.decorateBedroomNum"/>室<s:property value="vo.decorateLivingNum"/>厅<s:property value="vo.decorateKitchenNum"/>卫</td>
												<th>出租价格：</th>
												<td style="font-size:12"><s:property value="vo.payment"/></td>
												<th>出租类型：</th>
												<td style="font-size:12" colspan="3"><s:property value="%{@com.ziroom.common.manager.DictManager@getName('RENT_TYPE', vo.rentType)}"/></td>
											</tr>
											<tr height="20">
												<th>管家：</th>
												<td style="font-size:12"><s:property value="vo.stewardName"/></td>
												<th>管家电话：</th>
												<td style="font-size:12" colspan="3"><s:property value="vo.stewardPhone"/></td>
											</tr>
											<tr height="20">
												<th>经济人：</th>
												<td style="font-size:12"><s:property value="vo.agentName"/></td>
												<th>经纪人电话：</th>
												<td style="font-size:12"><s:property value="vo.agentPhone"/></td>
												<th>房源状态：</th>
												<td style="font-size:12"><s:property value="%{@com.ziroom.common.manager.DictManager@getName('HOUSE_STATUS', vo.houseStatus)}"/></td>
											</tr>
											<s:iterator id="r" value="vo.rooms">
												<tr height="40">
													<td colspan="6">
														<table cellpadding="0" cellspacing="1" width="100%">
															<tr height="30">
																<td style="font-size:12" colspan="8">
																	<s:if test='#r.roomType=="KITCHEN"'>
																		公共区域
																	</s:if>
																	<s:else>
																		<s:property value="#r.roomName"/>
																	</s:else>
																</td>
															</tr>
															<s:if test='#r.roomType=="KITCHEN"'>
																<tr height="30">
																	<th>客厅面积：</th>
																	<td style="font-size:12">
																		长：<s:property value="#r.saloonLength"/>宽：<s:property value="#r.saloonWidth"/>高：<s:property value="#r.saloonHeight"/>
																	</td>
																	<th>地面材料：</th>
																	<td style="font-size:12">
																		<s:property value="%{@com.ziroom.common.manager.DictManager@getName('FLOOR_MATERIAL', #r.saloonMaterial)}"/>
																	</td>
																	<th>主色调：</th>
																	<td style="font-size:12">
																		<s:property value="#r.saloonMaster"/>
																	</td>
																	<th>朝向：</th>
																	<td style="font-size:12">
																		<s:property value="#r.saloonPosition"/>
																	</td>
																</tr>
																<tr height="30">
																	<th>客厅特色：</th>
																	<td style="font-size:12">
																		<s:property value="#r.saloonDesc"/>
																	</td>
																</tr>
																<tr height="30">
																	<th>厨房面积：</th>
																	<td style="font-size:12">
																		长：<s:property value="#r.kitchenLength"/>宽：<s:property value="#r.kitchenWidth"/>高：<s:property value="#r.kitchenHeight"/>
																	</td>
																	<th>燃气灶类型：</th>
																	<td style="font-size:12">
																		<s:property value="%{@com.ziroom.common.manager.DictManager@getName('GAS_STOVE_TYPE', #r.kitchenStove)}"/>
																	</td>
																	<th>燃气接入类型：</th>
																	<td style="font-size:12">
																		<s:property value="%{@com.ziroom.common.manager.DictManager@getName('GAS_INTERFACE_TYPE', #r.kitchenGastype)}"/>
																	</td>
																	<th></th>
																	<td style="font-size:12">
																		
																	</td>
																</tr>		
																<tr height="30">
																	<th>厨房特色：</th>
																	<td style="font-size:12">
																		<s:property value="#r.kitchenDesc"/>
																	</td>
																</tr>
															</s:if>
															<s:else>
																<tr height="30">
																	<th>房间面积：</th>
																	<td style="font-size:12">
																		长：<s:property value="#r.roomLength"/>宽：<s:property value="#r.roomWidth"/>高：<s:property value="#r.roomHeight"/>总面积：<s:property value="#r.roomArea"/>
																	</td>
																	<th>房间朝向：</th>
																	<td style="font-size:12">
																		<s:property value="%{@com.ziroom.common.manager.DictManager@getName('HOUSE_FACE', #r.roomPosition)}"/>
																	</td>
																	<th>出租价格：</th>
																	<td style="font-size:12">
																		<s:property value="#r.rentFee"/>
																	</td>
																	<th>付款方式：</th>
																	<td style="font-size:12">
																		<s:property value="#r.payWay"/>
																	</td>
																</tr>
																<tr height="30">
																	<th>房间特色：</th>
																	<td style="font-size:12" colspan="7">
																		<s:property value="#r.roomComment"/>
																	</td>
																</tr>
															</s:else>
															<s:if test='#r.tolietExist=="Y"'>
																<tr height="30">
																	<th>卫生间面积：</th>
																	<td style="font-size:12">
																		长：<s:property value="#r.toiletLength"/>宽：<s:property value="#r.toiletWidth"/>高：<s:property value="#r.toiletHeight"/>
																	</td>
																	<th>是否有窗户：</th>
																	<td style="font-size:12">
																		<s:if test='#r.toiletWindow=="0"'>
																			有
																		</s:if>
																		<s:else>
																			没有
																		</s:else>
																	</td>
																	<th>是否有窗帘：</th>
																	<td style="font-size:12">
																		<s:if test='#r.toiletCurtain=="0"'>
																			有
																		</s:if>
																		<s:else>
																			没有
																		</s:else>
																	</td>
																	<th>是否有排气扇：</th>
																	<td style="font-size:12">
																		<s:if test='#r.toiletFan=="0"'>
																			有
																		</s:if>
																		<s:else>
																			没有
																		</s:else>
																	</td>
																</tr>
																<tr height="30">
																	<th>卫生间特色：</th>
																	<td style="font-size:12" colspan="7">
																		<s:property value="#r.toiletDesc"/>
																	</td>
																</tr>
															</s:if>
															<s:if test='#r.balconyExist=="Y"'>
																<tr height="30">
																	<th>阳台面积：</th>
																	<td style="font-size:12">
																		长：<s:property value="#r.balconyLength"/>宽：<s:property value="#r.balconyWidth"/>高：<s:property value="#r.balconyHeight"/>
																	</td>
																	<th>阳台形状：</th>
																	<td style="font-size:12">
																		<s:property value="#r.balconyType"/>
																	</td>
																	<th></th>
																	<td style="font-size:12"></td>
																	<th></th>
																	<td style="font-size:12"></td>
																</tr>
																<tr height="30">
																	<th>阳台特色：</th>
																	<td style="font-size:12" colspan="7">
																		<s:property value="#r.balconyDesc"/>
																	</td>
																</tr>
															</s:if>
															<s:if test='#r.garderExist=="Y"'>
																<tr height="30">
																	<th>花园面积：</th>
																	<td style="font-size:12">
																		长：<s:property value="#r.garderLength"/>宽：<s:property value="#r.garderWidth"/>高：<s:property value="#r.garderHeight"/>
																	</td>
																	<th>花园类型：</th>
																	<td style="font-size:12">
																		<s:property value="#r.garderType"/>
																	</td>
																	<th>天然泥土</th>
																	<td style="font-size:12">
																		<s:property value="#r.garderClay"/>
																	</td>
																	<th></th>
																	<td style="font-size:12"></td>
																</tr>
																<tr height="30">
																	<th>花园特色：</th>
																	<td style="font-size:12" colspan="7">
																		<s:property value="#r.garderDesc"/>
																	</td>
																</tr>
															</s:if>
															<s:if test='#r.terraceExist=="Y"'>
																<tr height="30">
																	<th>露台面积：</th>
																	<td style="font-size:12">
																		长：<s:property value="#r.terraceLength"/>宽：<s:property value="#r.terraceWidth"/>高：<s:property value="#r.terraceHeight"/>
																	</td>
																	<th></th>
																	<td style="font-size:12"></td>
																	<th></th>
																	<td style="font-size:12"></td>
																	<th></th>
																	<td style="font-size:12"></td>
																</tr>
																<tr height="30">
																	<th>露台特色：</th>
																	<td style="font-size:12" colspan="7">
																		<s:property value="#r.garderDesc"/>
																	</td>
																</tr>
															</s:if>
																<tr>
																	<td colspan="4" align="center">
																		<table>
																			<tr>
																				<td colspan="5" style="font-size:12">配置物品</td>
																			</tr>
																			<tr>
																				<td style="font-size:12">物品名称</td>
																				<td style="font-size:12">品牌</td>
																				<td style="font-size:12">数量</td>
																				<td style="font-size:12">使用年限</td>
																				<td style="font-size:12">规格</td>
																				<td style="font-size:12">查看</td>
																			</tr>
																			<s:iterator id="c" value="#r.configVoes">
																			<tr>
																				<td style="font-size:12"><s:property value="#c.itemName"/></td>
																				<td style="font-size:12"><s:property value="#c.itemBrand"/></td>
																				<td style="font-size:12"><s:property value="#c.itemNum"/></td>
																				<td style="font-size:12"><s:property value="#c.itemUseYears"/></td>
																				<td style="font-size:12"><s:property value="#c.itemSpac"/></td>
																				<td style="font-size:12">
																				<s:if test='#c.pictUrl!="" && #c.pictUrl!=null'>
																					<a href="http://pic.ziroom.com.cn<s:property value="#c.pictUrl"/>" class='preview'>查看</a>
																				</s:if>
																				</td>
																			</tr>
																			</s:iterator>
																		</table>
																	</td>
																	<td colspan="4" align="center">
																		<table>
																			<tr>
																				<td colspan="2" style="font-size:12">图片</td>
																			</tr>
																			<tr>
																				<td style="font-size:12">图片类型</td>
																				<td style="font-size:12">查看图片</td>
																			</tr>
																			<s:iterator id="c" value="#r.roomPictures">
																			<tr>
																				<td style="font-size:12"><s:property value="#c.imagetype"/></td>
																				<td style="font-size:12">
																					<a href="http://pic.ziroom.com.cn/web/<s:property value="#c.imagepath"/>" class='preview'>查看</a>
																				</td>
																			</tr>
																			</s:iterator>
																		</table>
																	</td>
																</tr>
														</table>
													</td>
												</tr>
											</s:iterator>
											</tbody>
											<tr height="20">
												<td align="center" colspan="10">&nbsp;</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
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