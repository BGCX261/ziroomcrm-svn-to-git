<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="common" uri="/common-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
<link rel="stylesheet" type="text/css" href="css/style.css" media="screen">
<link rel="stylesheet" type="text/css" href="css/jquery.Jcrop.css" media="screen">
<script type="text/javascript" src="js/jquery-1.6.min.js"></script>
<script type="text/javascript" src="js/ziroom/table.js"></script>
<script type="text/javascript" src="js/ziroom/menu.js"></script>
<script type="text/javascript" src="js/ziroom/page.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/struts/jquery-validator-rule.js"></script>
<script type="text/javascript" src="js/struts/struts-validator.js"></script>
<script type="text/javascript" src="js/jcrop/jquery.Jcrop.js"></script>
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
												<td width="95%" class="STYLE1"><span class="STYLE3">你当前的位置</span>：[专题页]</td>
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
							<s:form action="searchHouseByHouseCode.do" id="searchHouseByHouseCodeForm">
								<table cellpadding="0" cellspacing="1" class="tableList">
									<tr height="20">
										<td>房源编号：<s:textfield name="vo.houseCode" /></td>
										<td><input type="button" value="查询" onclick="doSearchHouse();" /></td>
									</tr>
								</table>
							</s:form>
							<s:if test='vo.houseCode != null'>
							<table cellpadding="0" cellspacing="1"  width="100%">
								<tr height="20">
									<s:set name="cols" value="0"/>
									<s:set name="total" value="vo.houseVo.rooms.size()"/>
									<s:iterator id="r" value="vo.houseVo.rooms">
										<td id="x<s:property value="#cols"/>" align="center" <s:if test="#cols==0">style="background-color:red;"</s:if> onclick="showLable(this,<s:property value="#cols"/>, <s:property value="#total"/>)"><s:property value="%{@com.ziroom.common.manager.DictManager@getName('WINDOW_FACE', #r.roomPosition)}"/><s:property value="#r.roomCode"/></td>
										<s:set name="cols" value="#cols+1"/>
									</s:iterator>
									<td width='80%'></td>
									<s:set name="cols" value="#cols+1"/>
								</tr>
								<s:set name="seq" value="0"/>
								<s:iterator id="r" value="vo.houseVo.rooms">
								<tr>
									<td align="center" colspan="<s:property value="#cols"/>" <s:if test="#seq==0">style="display:block;"</s:if><s:else>style="display:none"</s:else> id="d<s:property value="#seq"/>">
										<table cellpadding="0" cellspacing="1" class="tableForm" width="100%">
											<thead>
												<tr>
													<th colspan="10">专题信息</th>
												</tr>
											</thead>
											<tbody>
											<tr height="20">
												<th>房间面积：</th>
												<td>
													<div id="<s:property value="#r.roomId"/>"><s:property value="#r.roomArea"/></div>
												</td>
												<th>房间朝向：</th>
												<td>
													<div id="<s:property value="#r.roomId"/>"><s:property value="%{@com.ziroom.common.manager.DictManager@getName('WINDOW_FACE', #r.roomPosition)}"/></div>
												</td>
												<th>出房价格：</th>
												<td>
													<div id="<s:property value="#r.roomId"/>"><s:property value="#r.rentFee"/></div>
												</td>
												<th>保洁费：</th>
												<td>
													<div id="<s:property value="#r.roomId"/>">30</div>
													<div id="i<s:property value="#r.roomId"/>" style="display:none"><s:property value="#r.roomId"/></div>
												</td>
												<th>发布类型：</th>
												<td>
													<div>
														<select id="s<s:property value="#r.roomId"/>">
															<option value="">请选择</option>
															<option value="11000001">经典</option>
															<option value="11000002">原创</option>
															<option value="11000003">闺宿</option>
														</select>
													</div>
												</td>
											</tr>
											<tr>
												<td colspan="10">
													<table cellpadding="0" cellspacing="0" width="100%">
														<tr>
															<s:set name="cp" value="#r.roomPictures.size()"/>
															<s:iterator id="rp" value="#r.roomPictures">												
															<td align="center">
																<div>
																<img id="rp<s:property value="#rp.hpimageid"/>" src="http://pic.ziroom.com.cn/web/<s:property value="#rp.imagepath"/>" width="88" height="66"/>
																</div>
																<input type="radio" name="a" value="<s:property value="#rp.hpimageid"/>" onclick="displayImage(this, <s:property value="#rp.hpimageid"/>, <s:property value="#r.roomId"/>)"/>
															</td>
															</s:iterator>
														</tr>
														<tr>
															<s:set name="cp" value="#cp-1"/>
															<td colspan="<s:property value="#cp"/>">
																<img src="" id="img<s:property value="#r.roomId"/>" name="slt" _name="slt<s:property value="#r.roomId"/>"/>
															</td>
															<td>
																<div style="width:292px;height:219px;overflow:hidden;">																
																	<img src="" id="_img<s:property value="#r.roomId"/>" name="_slt"/>
																</div>
															</td>
														</tr>
													</table>
												</td>
											</tr>
											</tbody>
											<tr>
												<td align="center" colspan="10"><input type="button" value="确认" onclick="doSubmit(<s:property value="#r.roomId"/>);" /></td>
											</tr>
											<tr height="20">
												<td align="center" colspan="10">&nbsp;</td>
											</tr>
										</table>
									</td>
								</tr>
								<s:set name="seq" value="#seq+1"/>
								</s:iterator>
							</table>
							<s:form action="saveSpecail.do" id="saveSpecailForm">
								<input type="hidden" name="vo.roomId" id="roomId"/>
								<input type="hidden" name="vo.houseCode" value="<s:property value="vo.houseVo.houseCode"/>"/>
								<input type="hidden" name="vo.roomName" value="<s:property value="vo.houseVo.title"/>"/>
								<input type="hidden" name="vo.specialType" id="specialType"/>
								<input type="hidden" name="vo.imageId" id="imageId"/>
								<input type="hidden" name="vo.x1" id="_cx1"/>
								<input type="hidden" name="vo.y1" id="_cy1"/>
								<input type="hidden" name="vo.x2" id="cx2"/>
								<input type="hidden" name="vo.y2" id="cy2"/>
								<input type="hidden" name="vo.width" id="cw"/>
								<input type="hidden" name="vo.height" id="ch"/>
							</s:form>
							</s:if>
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
		var jcrop;
		var _jcrop;
		/** 房间查询 */
		function doSearchHouse() {
			$("#searchHouseByHouseCodeForm").submit();
		}
		/** 提交 */
		function doSubmit(id) {
			var roomId = $("#i" + id).text();
			$("#roomId").val(roomId);
			var s = $("#s" + id).val();
			$("#specialType").val(s);
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
			// 
			$("x1").val("");
			$("y1").val("");
			$("x2").val("");
			$("y2").val("");
			$("w").val("");
			$("h").val("");
			$("#imageId").val("");
			var o = $("input[name='a']");
			$.each(o, function() {
				if(this.checked) {
					this.checked = false;
				}
			});
			var i = $("img[name='slt']");
			$.each(i, function() {
				$(this).attr("src", "");
			});
			var j = $("img[name='_slt']");
			$.each(j, function() {
				$(this).attr("src", "");
			});
			jcrop.destroy();
		}
		/** 显示图片进行切图 */
		function displayImage(o, id, rid) {
			if(jcrop != null) {
				jcrop.destroy();
			}
			if(o.checked) {
				var s = $("#rp" + id).attr("src");
				$("#img" + rid).attr("src", s);
				$("#_img" + rid).attr("src", s);
			}
			jcrop = $.Jcrop("#img" + rid, {
				// aspectRatio: 1,
				setSelect: [0, 0, 584, 438],
				onChange: function(coords) {
					showPreview(coords, rid);
				},
				onSelect: function(coords) {
					showPreview(coords, rid);
				}
			});
			$("#imageId").val(id);
		}
		/** 显示切图 */
		function showPreview(coords, id) {
			if (parseInt(coords.w) > 0) {
				var rx = 292 / coords.w;
				var ry = 219 / coords.h;
				var o = $("#img" + id);
				var _w = (o.css("width")).replace("px", "");
				var _h = (o.css("height")).replace("px", "");
				var x = Math.round(rx * parseInt(_w));
				var y = Math.round(ry * parseInt(_h));
				//alert(x);
				$("#_img" + id).css({
					width: x + 'px',
					height: y + 'px',
					marginLeft: '-' + Math.round(rx * coords.x) + 'px',
					marginTop: '-' + Math.round(ry * coords.y) + 'px'
				});
				// 赋值
				$("#_cx1").val(coords.x);
				$("#_cy1").val(coords.y);
				$("#cx2").val(coords.x2);
				$("#cy2").val(coords.y2);
				$("#cw").val(coords.w);
				$("#ch").val(coords.h);
			}
		}
	</script>
	<common:validator actionName="saveSpecail" formId="saveSpecailForm" spring="true"/>
</body>
</html>