<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="common" uri="/common-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
<link rel="stylesheet" type="text/css" href="css/style.css" media="screen">
<script type="text/javascript" src="js/jquery-1.6.min.js"></script>
<script>
	function showsubmenu(sid) {
		whichEl = $("#submenu" + sid);
		imgmenu = $("#imgmenu" + sid);
		if (whichEl.css("display") == "none") {
			$("#submenu" + sid).show();
			imgmenu.css("background", "images/main_47.gif");
		} else {
			$("#submenu" + sid).hide();
			imgmenu.css("background", "images/main_48.gif");
		}
	}
</script>
</head>

<body style="background-color: #ffffff;">
	<table width="165" height="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td height="28" background="images/main_40.gif">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="19%">&nbsp;</td>
						<td width="81%" height="20"><span class="STYLE4">管理菜单</span></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td valign="top">
				<table width="151" border="0" align="center" cellpadding="0" cellspacing="0">
					<s:set name="seq" value="0"/>
					<s:iterator id="v" value="vo.menus">
					<s:set name="seq" value="#seq+1"/>
					<tr>
						<td>
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td height="23" background="images/main_47.gif" id="imgmenu<s:property value="#seq"/>" class="menu_title" onMouseOver="this.className='menu_title2';" onClick="showsubmenu(<s:property value="#seq"/>)" onMouseOut="this.className='menu_title';" style="cursor: hand">
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td width="18%">&nbsp;</td>
												<td width="82%" class="STYLE4"><s:property value="#v.menuName"/></td>
											</tr>
										</table>
									</td>
								</tr>
								<tr>
									<td background="images/main_51.gif" id="submenu<s:property value="#seq"/>">
										<div class="sec_menu">
											<table width="100%" border="0" cellspacing="0" cellpadding="0">
												<s:iterator id="m" value="#v.menus">
												<tr>
													<td>
														<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
															<tr>
																<td width="16%" height="25">
																	<div align="center">
																		<img src="images/left.gif" width="10" height="10" />
																	</div>
																</td>
																<td width="84%" height="23">
																	<table width="95%" border="0" cellspacing="0" cellpadding="0">
																		<tr>
																			<td height="20" style="cursor: hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; " onmouseout="this.style.borderStyle='none'">
																				<span class="STYLE3"><a href="<s:property value="#m.url"/>" target="I2"><s:property value="#m.menuName"/></a></span>
																			</td>
																		</tr>
																	</table>
																</td>
															</tr>
														</table>
													</td>
												</tr>
												</s:iterator>
												<tr>
													<td height="5"><img src="images/main_52.gif" width="151" height="5" /></td>
												</tr>
											</table>
										</div>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					</s:iterator>
				</table>
			</td>
		</tr>
		<tr>
			<td height="18" background="images/main_58.gif">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td height="18" valign="bottom">
							<div align="center" class="STYLE3">版本：2012V1.0</div>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>
