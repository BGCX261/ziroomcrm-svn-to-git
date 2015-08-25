<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="common" uri="/common-tags"%>
<%@ taglib prefix="ziroom" uri="/ziroom-tags"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="css/style.css"
			media="screen">
		<link rel="stylesheet" type="text/css" href="css/crop/common.css"
			media="screen">
		<link rel="stylesheet" type="text/css" href="css/crop/member.css"
			media="screen">
		<link rel="stylesheet" type="text/css" href="css/crop/module.css"
			media="screen">
		<link rel="stylesheet" type="text/css" href="css/jquery.Jcrop.css"
			media="screen">
		<script type="text/javascript" src="js/jquery-1.6.min.js"></script>
		<script type="text/javascript" src="js/crop/jquery-1.2.6.js"></script>
		<script type="text/javascript" src="js/ziroom/table.js"></script>
		<script type="text/javascript" src="js/ziroom/menu.js"></script>
		<script type="text/javascript" src="js/ziroom/page.js"></script>
		<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript"
			src="js/struts/jquery-validator-rule.js"></script>
		<script type="text/javascript" src="js/struts/struts-validator.js"></script>
		<script type="text/javascript" src="js/jcrop/jquery.Jcrop.js"></script>
		<script type="text/javascript" src="js/crop/cutpic.js"></script>
		<script type="text/javascript" src="js/crop/ui.core.packed.js"></script>
		<script type="text/javascript" src="js/crop/ui.draggable.packed.js"></script>
		<style type="text/css">
img {
	vertical-align: top;
	border: none;
}

#bar {
	width: 250px;
	height: 18px;
	background-image: url("images/track1.gif");
	background-repeat: no-repeat;
	position: relative;
}

.child {
	width: 11px;
	height: 16px;
	background-image: url("images/grip.gif");
	background-repeat: no-repeat;
	left: 0;
	top: 2px;
	position: absolute;
	left: 100px;
	cursor: pointer;
}
</style>
	</head>

	<body>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="30" background="images/tab_05.gif">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="12" height="30">
								<img src="images/tab_03.gif" width="12" height="30" />
							</td>
							<td>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="46%" valign="middle">
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr>
													<td width="5%">
														<div align="center">
															<img src="images/tb.gif" width="16" height="16" />
														</div>
													</td>
													<td width="95%" class="STYLE1">
														<span class="STYLE3">你当前的位置</span>：[专题页]
													</td>
												</tr>
											</table>
										</td>
										<td width="54%">
											<table border="0" align="right" cellpadding="0"
												cellspacing="0">
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
							<td width="16">
								<img src="images/tab_07.gif" width="16" height="30" />
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="8" background="images/tab_12.gif">
								&nbsp;
							</td>
							<td>
								<s:set name="total" value="vo.houseVo.rooms.size()" />
								<s:if test='#total>0'>
									<table cellpadding="0" cellspacing="1" border="0" width="100%">
										<tr height="20">
											<s:set name="cols" value="0" />
											<s:iterator id="r" value="vo.houseVo.rooms">
												<td id="x<s:property value="#cols"/>" align="center"
													<s:if test="#cols==0">style="background-color:red;width:80px"</s:if>
													<s:else>style="width:80px"</s:else>
													onclick="showLable(this,<s:property value="#cols"/>, <s:property value="#total"/>)">
													<s:property
														value="%{@com.ziroom.common.manager.DictManager@getName('WINDOW_FACE', #r.roomPosition)}" />
													<s:property value="#r.roomCode" />
												</td>
												<s:set name="cols" value="#cols+1" />
											</s:iterator>
											<td></td>
											<s:set name="cols" value="#cols+1" />
										</tr>
										<s:set name="seq" value="0" />
										<s:iterator id="r" value="vo.houseVo.rooms">
											<tr>
												<td align="center" colspan="<s:property value="#cols"/>"
													<s:if test="#seq==0">style="display:none;"</s:if>
													<s:else>style="display:none"</s:else>
													id="d<s:property value="#seq"/>">
													<table cellpadding="0" border="0" cellspacing="1"
														class="tableForm" width="100%">
														<tbody>
															<tr height="20">
																<th>
																	房间面积：
																</th>
																<td>
																	<div id="<s:property value="#r.roomId"/>">
																		<s:property value="#r.roomArea" />
																	</div>
																</td>
																<th>
																	房间朝向：
																</th>
																<td>
																	<div id="<s:property value="#r.roomId"/>">
																		<s:property
																			value="%{@com.ziroom.common.manager.DictManager@getName('WINDOW_FACE', #r.roomPosition)}" />
																	</div>
																</td>
																<th>
																	出房价格：
																</th>
																<td>
																	<div id="<s:property value="#r.roomId"/>">
																		<s:property value="#r.rentFee" />
																	</div>
																</td>
																<th>
																	保洁费：
																</th>
																<td>
																	<div id="<s:property value="#r.roomId"/>">
																		30
																	</div>
																	<div id="i<s:property value="#r.roomId"/>"
																		style="display: none">
																		<input type="hidden" id="xx<s:property value="#r.roomId"/>" value="<s:property value="#r.roomId" />"/>
																	</div>
																</td>
																<th></th>
																<td>
																	<div>
																		<input type="hidden"
																			id="s<s:property value="#r.roomId"/>"
																			value="<s:property value='vo.argumentsBeans[0].values[0]'/>" />
																	</div>
																</td>
															</tr>
															<tr>
																<td colspan="10">
																	<table cellpadding="0" cellspacing="0" border="0"
																		width="100%">
																		<tr>
																			<s:set name="cp" value="#r.roomPictures.size()" />
																			<s:iterator id="rp" value="#r.roomPictures">
																				<td align="center" style="text-align: center;">
																					<div>
																						<img id="rp<s:property value="#rp.hpimageid"/>"
																							src="http://pic.ziroom.com.cn/web/<s:property value="#rp.imagepath"/>"
																							width="88" height="66" />
																					</div>
																					<input type="radio" name="a"
																						value="<s:property value="#rp.hpimageid"/>"
																						onclick="displayImage(this, <s:property value="#rp.hpimageid"/>, <s:property value="#r.roomId"/>)" />
																				</td>
																			</s:iterator>
																		</tr>
																	</table>
															</td>
															</tr>
														</tbody>
														<tr>
															<td align="center" colspan="10">
																<input type="button" value="确认"
																	onclick="doSubmit(<s:property value="#r.roomId"/>);" />
															</td>
														</tr>
														<tr height="20">
															<td align="center" colspan="10">
																&nbsp;
															</td>
														</tr>
													</table>
												</td>
											</tr>
											<s:set name="seq" value="#seq+1" />
										</s:iterator>
										<tr>
											<td colspan="<s:property value="#cols"/>">
												<div id="cut_div"
													style="border: 2px; solid #888888; width: 400px; height: 300px; overflow: hidden; position: relative; cursor: pointer;">
													<table id="Crop"
														style="border-collapse: collapse; z-index: 10; filter: alpha(opacity =   75); position: relative; left: 0px; top: 0px; width: 400px; height: 300px; opacity: 0.75;"
														cellspacing="0" cellpadding="0" border="0">
														<tr>
															<td style="background: #cccccc; height: 40px" colspan="3"></td>
														</tr>
														<tr>
															<td style="background: #cccccc; width: 55px"></td>
															<td
																style="width: 290px; height: 220px; border-width: 1px; border-style: solid; border-color: white;">
															</td>
															<td style="background: #cccccc; width: 55px"></td>
														</tr>
														<tr>
															<td style="background: #cccccc; height: 40px" colspan="3"></td>
														</tr>
													</table>
													<div id="IconContainer"
														style="position: relative; top: 0px; left: 0px;">
														<img id="cut_img" src="images/bgImg.gif"
															style="border-width: 0px; position: relative;" />
													</div>
												</div>
												<table cellspacing="0" cellpadding="0" id="scale">
													<tr>
														<td>
															<img id="shrink"
																style="margin-top: 5px; cursor: pointer;"
																src="images/touxiang_h.gif" alt="图片缩小" />
														</td>
														<td>
															<div id="bar">
																<div class="child" id="silder">
																</div>
															</div>
														</td>
														<td>
															<img id="zoom" style="margin-top: 5px; cursor: pointer;"
																src="images/touxiang_h2.gif" alt="图片放大" />
														</td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
									<s:form action="saveSpecail.do" id="saveSpecailForm">
										<input type="hidden" name="vo.roomId" id="roomId" />
										<input type="hidden" name="vo.houseCode" value="<s:property value="vo.houseCode"/>" />
										<input type="hidden" name="vo.houseCode1" value="<s:property value="vo.houseVo.houseCode"/>" />
										<input type="hidden" name="vo.roomName" value="<s:property value="vo.houseVo.title"/>" />
										<input type="hidden" name="vo.contractCode" value="<s:property value="vo.contractCode"/>" />
										<input type="hidden" name="vo.houseName" value="<s:property value="vo.houseName"/>" />
										<input type="hidden" name="vo.specialType" id="specialType" value="<s:property value="vo.houseVo.houseProduct"/>" />
										<input type="hidden" name="vo.imageId" id="imageId" />
										<input name="vo.txtZoom" type="hidden" id="txt_Zoom" />
										<input name="vo.txtTop" type="hidden" value="73" id="txt_top" />
										<input name="vo.txtLeft" type="hidden" value="82" id="txt_left" />
										<ziroom:search preffiex="vo" searchBean="vo" />
										<!--  
										<input type="hidden" name="vo.x1" id="_cx1" />
										<input type="hidden" name="vo.y1" id="_cy1" />
										<input type="hidden" name="vo.x2" id="cx2" />
										<input type="hidden" name="vo.y2" id="cy2" />
										<input type="hidden" name="vo.width" id="cw" />
										<input type="hidden" name="vo.height" id="ch" />
										-->
									</s:form>
								</s:if>
							</td>
							<td width="8" background="images/tab_15.gif">
								&nbsp;
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td height="35" background="images/tab_19.gif">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="12" height="35">
								<img src="images/tab_18.gif" width="12" height="35" />
							</td>
							<td>
								&nbsp;
							</td>
							<td width="16">
								<img src="images/tab_20.gif" width="16" height="35" />
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<script type="text/javascript">
			var jcrop;
			var _jcrop;
			/** 房间查询 */
			function doSearchHouse() {
				$("#searchHouseByHouseCodeForm").attr("action", "searchHouseByHouseCode.do");
				$("#searchHouseByHouseCodeForm").submit();
			}
			/** 提交 */
			function doSubmit(id) {
				var roomId = $("#xx" + id).val();
				$("#roomId").val(roomId);
				var s = $("#specialType").val();
				var d = "";
				if(s=='2000001') {
					d = '11000001';
				} else if(s=='2000002') {
					d = '11000002';
				} else if(s=='2000003') {
					d = '11000003';
				}
				$("#specialType").val(d);
				if(strutsValidator("","saveSpecailForm",[])) {
					$("#saveSpecailForm").submit();
				}
			}
			/** 显示标签 */
			function showLable(o,id, total) {
				for(var i=0; i<total; i++) {
					$("#d" + i).hide();
					$("#x" + i).css("background-color", "");
				}
				$("#d" + id).show();
				$("#x" + id).css("background-color", "red");
				$("#imageId").val("");
				var o = $("input[name='a']");
				$.each(o, function() {
					if(this.checked) {
						this.checked = false;
					}
				});
				$("#cut_img").attr("src", "images/bgImg.gif");
			}
			/** 显示图片进行切图 */
			function displayImage(o, id, rid) {
				if(o.checked) {
					var s = $("#rp" + id).attr("src");
					$("#cut_img").attr("src", s);
				}
				$("#imageId").val(id);
			}
			/** 取消 */
			function channelHouse() {
				$("#searchHouseByHouseCodeForm").attr("action", "searchSpecial.do");
				$("#searchHouseByHouseCodeForm").submit();
			}
			$("#d0").show();
		</script>
		<common:validator actionName="saveSpecail" formId="saveSpecailForm"
			spring="true" />
	</body>
</html>