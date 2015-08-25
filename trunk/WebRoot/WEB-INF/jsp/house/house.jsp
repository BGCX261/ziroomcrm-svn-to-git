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
												<td width="95%" class="STYLE1"><span class="STYLE3">你当前的位置</span>：[房源信息]</td>
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
							<s:form action="" id="houseForm">
							<input type="hidden" name="vo.houseId" id="houseId" />
							<input type="hidden" name="vo.roomId" id="roomId" />
							<s:hidden name="vo.pageBean.currentPage" id="vpc"/>
							<s:token />
							<table cellpadding="0" cellspacing="1" class="tableList">
								<tr>
									<th style="font-size:12">房源编号：<s:textfield name="vo.argumentsBeans[0].values[0]" cssStyle="width:100px;"/></th>
									<th style="font-size:12">部门：
										<s:action name="searchDeptByCodeAndLevel" id="searchDeptByCodeAndLevel" executeResult="true">
											<s:param name="deptVo.deptCode" value="'A18109'"/>
											<s:param name="deptVo.deptLevel" value="7"/>
										</s:action>
										<s:select list="#searchDeptByCodeAndLevel.deptVo.deptVoes" 
												name="vo.argumentsBeans[1].values[0]" 
												id="dept" 
												onchange="selectBussiness(this.value);"
												headerKey=""
												headerValue="请选择"
												listKey="deptCode"
												listValue="departName" value="vo.argumentsBeans[1].values[0]" cssStyle="width:80px">
										</s:select>
									&nbsp;<select name="vo.argumentsBeans[2].values[0]" id="bussiness" style="width:80px"><option value="">请选择</option></select></th>
									<th style="font-size:12">主管：
										<s:action name="searchUserByDeptCode" id="leader" executeResult="true">
											<s:param name="userVo.deptCode" value="'A18109'"/>
											<s:param name="userVo.setidJobcode" value="'主管'"/>
										</s:action>
										<s:select list="#leader.userVo.userVoes" 
											name="vo.argumentsBeans[3].values[0]" 
											id="leader"
											headerKey=""
											headerValue="请选择"
											listKey="deptCode"
											listValue="staffName" value="vo.argumentsBeans[3].values[0]">
										</s:select>
									</th>
									<th style="font-size:12">管家名称：
										<s:action name="searchUserByDeptCode" id="steward" executeResult="true">
											<s:param name="userVo.deptCode" value="'A18109'"/>
											<s:param name="userVo.setidJobcode" value="'专员'"/>
										</s:action>
										<s:select list="#steward.userVo.userVoes" 
											name="vo.argumentsBeans[4].values[0]" 
											id="steward"
											headerKey=""
											headerValue="请选择"
											listKey="staffid"
											listValue="staffName" value="vo.argumentsBeans[4].values[0]">
										</s:select>
									</th>
									<th style="font-size:12">是否发布：
										<s:select list="#{'Y':'是','N':'否'}"
											name="vo.argumentsBeans[5].values[0]" 
											headerKey=""
											headerValue="请选择"
											listKey="key"
											listValue="value" value="vo.argumentsBeans[5].values[0]">
										</s:select>
									</th>
									<th style="font-size:12">是否优先：
										<s:select list="#{'Y':'是','N':'否'}"
											name="vo.argumentsBeans[6].values[0]" 
											headerKey=""
											headerValue="请选择"
											listKey="key"
											listValue="value" value="vo.argumentsBeans[6].values[0]">
										</s:select>
									</th>
									<th style="font-size:12">是否推荐：
										<s:select list="#{'Y':'是','N':'否'}"
											name="vo.argumentsBeans[7].values[0]" 
											headerKey=""
											headerValue="请选择"
											listKey="key"
											listValue="value" value="vo.argumentsBeans[7].values[0]">
										</s:select>
									</th>
									<td><input type="button" value="查询" onclick="searchHouse();"></td>
								</tr>
							</table>
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
											<div>房源名称</div>
										</td>
										<td>
											<div>房源编号</div>
										</td>
										<td>
											<div>所在区域</div>
										</td>
										<td>
											<div>出租价格</div>
										</td>
										<td>
											<div>剩余间数</div>
										</td>
										<td>
											<div>管家名称</div>
										</td>
										<td>
											<div>房源产品</div>
										</td>
										<td>
											<div>房屋状态</div>
										</td>
										<td>
											<div>基本操作</div>
										</td>
									</tr>
								</thead>
								<tbody>
									<s:set name="pageBean" value="vo.pageBean"/>
									<s:set name="seq" value="#pageBean.pageSize*(#pageBean.currentPage-1)"/>
									<s:iterator id="v" value="vo.houses">
									<s:set name="seq" value="#seq+1"/>
									<tr height="20">
										<td>
											<div align="left"><img src="images/plus.gif" style="curse:hand" onclick="showRoom(this, <s:property value="#seq"/>, <s:property value="#v.sysHouseId"/>)"/></div>
										</td>
										<td>
											<div align="left"><s:property value="#seq"/></div>
										</td>
										<td>
											<div align="left"><s:property value="#v.title"/></div>
										</td>
										<td>
											<div align="left"><s:property value="#v.houseCode"/></div>
										</td>
										<td>
											<div align="left">
												<s:property value="%{@com.ziroom.common.manager.DictManager@getName('T_DISTRICT', #v.counties)}"/><s:property value="%{@com.ziroom.common.manager.DictManager@getName('T_BUSINESS', #v.shopping)}"/>
											</div>
										</td>
										<td>
											<div align="left"><s:property value="#v.payment"/></div>
										</td>
										<td>
											<div align="left"><s:property value="#v.rentNum"/></div>
										</td>
										<td>
											<div align="left"><s:property value="#v.stewardName"/></div>
										</td>
										<td>
											<div align="left">
												<s:property value="%{@com.ziroom.common.manager.DictManager@getName('HOUSE_PRODUCT', #v.houseProduct)}"/>
											</div>
										</td>
										<td>
											<div align="left">
												<s:property value="%{@com.ziroom.common.manager.DictManager@getName('HOUSE_STATUS', #v.rentStatus)}"/>
											</div>
										</td>
										<td>
											<div align="center">
												<a href="javascript:void(0)" onclick="pubHouse(<s:property value="#v.houseId"/>, '<s:property value="#v.houseStatus"/>', '<s:property value="#v.isShow"/>')">
												<s:if test='#v.isShow=="N"'>
												[发布]
												</s:if>
												<s:else>
												[已发布]	
												</s:else>	
												</a>
												<a href="viewHouse.do?vo.houseId=<s:property value="#v.houseId"/>">[查看]</a>
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
															<div>房间名称</div>
														</td>
														<td>
															<div>房间编号</div>
														</td>
														<td>
															<div>房间类型</div>
														</td>
														<td>
															<div>出租价格</div>
														</td>
														<td>
															<div>房间状态</div>
														</td>
														<td>
															<div>基本操作</div>
														</td>
													</tr>
												</thead>
												<tbody>
													<s:iterator id="r" value="#v.rooms">
													<tr height="20">
														<td>
															<div align="left"><s:property value="#r.roomName"/></div>
														</td>
														<td>
															<div align="left"><s:property value="#v.houseCode"/>-<s:property value="#r.roomCode"/></div>
														</td>
														<td>
															<div align="left">
																<s:property value="%{@com.ziroom.common.manager.DictManager@getName('ROOM_TYPE', #r.roomType)}"/>
															</div>
														</td>
														<td>
															<div align="left"><s:property value="#r.rentFee"/></div>
														</td>
														<td>
															<div align="left">
																<s:property value="%{@com.ziroom.common.manager.DictManager@getName('ROOM_STATUS', #r.roomStatus)}"/>
															</div>
														</td>
														<td>
															<div align="center">
																<a href="javascript:void(0)" onclick="pubRoom(<s:property value="#r.roomId"/>, '<s:property value="#r.roomStatus"/>', '<s:property value="#r.isShow"/>')">
																	<s:if test='#r.isShow=="N"'>
																	[发布]
																	</s:if>
																	<s:else>
																	[已发布]
																	</s:else>
																</a>
																<s:if test='#r.isShow=="Y"'>
																	<s:if test='#r.isPromotions=="N"'>
																		<a href="javascript:void(0)" onclick="showPrior(<s:property value="#r.roomId"/>);">[优先展示]</a>
																	</s:if>
																	<s:else>
																		<a href="javascript:void(0)" onclick="showPrior(<s:property value="#r.roomId"/>);">[已优先]</a>
																	</s:else>
																	<s:if test='#r.isTop=="N"'>
																		<a href="javascript:void(0)" onclick="showTop(<s:property value="#r.roomId"/>);">[推荐]</a>
																	</s:if>
																	<s:else>
																		<a href="javascript:void(0)" onclick="showTop(<s:property value="#r.roomId"/>);">[已推荐]</a>
																	</s:else>
																</s:if>
																<a href="downRoomPackage.do?vo.roomId=<s:property value="#r.roomId"/>" >
																	[下载]
																</a>
															</div>
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
									<td class="STYLE1">&nbsp;&nbsp;共有 <s:property value="vo.pageBean.totalSize"/>条记录，当前第 <s:property value="vo.pageBean.currentPage"/>/<s:property value="vo.pageBean.totalPage"/>页</td>
									<td>
										<s:form action="searchHouse.do" id="searchHouseForm">
											<s:hidden name="vo.pageBean.currentPage" id="pageBean_currentPage"/>
											<ziroom:search preffiex="vo" searchBean="vo"/>
											<table border="0" align="right" cellpadding="0" cellspacing="0">
												<tr>
													<td width="40"><img src="images/first.gif" width="37" height="15" onclick="first(1,'searchHouseForm', 'pageBean_currentPage');"/></td>
													<td width="45"><img src="images/back.gif" width="43" height="15" onclick="previousPage(<s:property value="vo.pageBean.currentPage"/>,'searchHouseForm', 'pageBean_currentPage');"/></td>
													<td width="45"><img src="images/next.gif" width="43" height="15" onclick="nextPage(<s:property value="vo.pageBean.currentPage"/>,'searchHouseForm', 'pageBean_currentPage', <s:property value="vo.pageBean.totalPage"/>);"/></td>
													<td width="40"><img src="images/last.gif" width="37" height="15" onclick="last(<s:property value="vo.pageBean.totalPage"/>,'searchHouseForm', 'pageBean_currentPage');"/></td>
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
		/** 展示房屋中的房间信息 */
		function showRoom(o, id, sysHouseId) {
			var s = $(o).attr("src");
			if(s == "images/plus.gif") {
				$(o).attr("src", "images/minus.gif");
				$("#room"+id).show();
			} else {
				$(o).attr("src", "images/plus.gif");
				$("#room"+id).hide();
			}
		}
		/** 房屋发布 */
		function pubHouse(houseId, houseStatus, isShow) {
			if((houseStatus == 'km' || houseStatus == 'yxd') && isShow=='N') {
				$("#houseId").val(houseId);
				$("#houseForm").attr("action", "pubHousePage.do");
				$("#houseForm").submit();
			} else {
				$("#houseId").val(houseId);
				$("#houseForm").attr("action", "pubHouse.do");
				$("#houseForm").submit();
			}
		}
		/** 房间发布 */
		function pubRoom(roomId, roomStatus, isShow) {
			if((roomStatus == 'ycz') && isShow == 'N') {
				$("#roomId").val(roomId);
				$("#houseForm").attr("action", "pubRoomPage.do");
				$("#houseForm").submit();
			} else {
				$("#roomId").val(roomId);
				$("#houseForm").attr("action", "pubRoom.do");
				$("#houseForm").submit();
			}
		}
		/** 房间优先展示 */
		function showPrior(roomId) {
			$("#roomId").val(roomId);
			$("#houseForm").attr("action", "showPriorRoom.do");
			$("#houseForm").submit();
		}
		/** 房间推荐 */
		function showTop(roomId) {
			$("#roomId").val(roomId);
			$("#houseForm").attr("action", "showTopRoom.do");
			$("#houseForm").submit();
		}
		/** 房间房源包下载 */
		function downRoomPackage(roomId) {
			$("#roomId").val(roomId);
			$("#houseForm").attr("action", "downRoomPackage.do");
			$("#houseForm").submit();
		}
		/** 房屋查询 */
		function searchHouse() {
			$("#vpc").val(1);
			$("#houseForm").attr("action", "searchHouse.do");
			$("#houseForm").submit();
		}
		/** 业务组二级联动 */
		function selectBussiness(value, v) {
			$("#bussiness").empty();
			$("#bussiness").append("<option value=''>请选择</option>");
			if(value != "") {
				$.post("ajaxDept.do",{"deptVo.deptCode":value, "deptVo.deptLevel":"8"},function(json) {
					$.each(json, function() {
						if(v && v == this.deptCode) {
							$("#bussiness").append("<option value='" + this.deptCode + "' selected='selected'>" + this.departName + "</option>");
						} else {
							$("#bussiness").append("<option value='" + this.deptCode + "'>" + this.departName + "</option>");
						}
						
					
					});
				}, "json");
			}
		}
		
		/** 初始化houe界面内容 */
		$(function(){
			var deptCode = '<s:property value="vo.argumentsBeans[1].values[0]"/>';
			var value = '<s:property value="vo.argumentsBeans[2].values[0]"/>';
			if(deptCode != "") {
				selectBussiness(deptCode, value);
			}
		});
	</script>
</body>
</html>