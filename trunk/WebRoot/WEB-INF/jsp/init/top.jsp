<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="common" uri="/common-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
<link rel="stylesheet" type="text/css" href="css/style.css" media="screen">
<script type="text/javascript" src="js/jquery-1.6.min.js"></script>
<script type="text/javascript" src="js/ziroom/menu.js"></script>
</head>

<body>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="70" background="images/main_05.gif">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td height="24">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="270" height="24" background="images/main_03.gif">&nbsp;</td>
									<td width="505" background="images/main_04.gif">&nbsp;</td>
									<td>&nbsp;</td>
									<td width="21"><img src="images/main_07.gif" width="21" height="24"></td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td height="38">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="270" height="38" background="images/main_09.gif">&nbsp;</td>
									<td>
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td width="77%" height="25" valign="bottom">
													<table width="100%" border="0" cellspacing="0" cellpadding="0">
														<tr>
															<td width="50">
																<div align="center">
																	<img src="images/main_20.gif" width="48" height="19" onclick="loginOut();">
																</div>
															</td>
															<td width="26">
																<div align="center">
																	<img src="images/main_21.gif" width="26" height="19">
																</div>
															</td>
															<td width="100">
																<div align="center">
																	<img src="images/main_22.gif" width="98" height="19">
																</div>
															</td>
															<td>&nbsp;</td>
														</tr>
													</table>
												</td>
												<td width="220" valign="bottom" nowrap="nowrap">
													<div align="right">
														<span class="STYLE4"><span class="STYLE4">■</span> 今天是：2008年5月12日 星期一</span>
													</div>
												</td>
											</tr>
										</table>
									</td>
									<td width="21"><img src="images/main_11.gif" width="21" height="38">
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td height="8" style="line-height: 8px;">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="270" background="images/main_29.gif" style="line-height: 8px;">&nbsp;</td>
									<td width="505" background="images/main_30.gif" style="line-height: 8px;">&nbsp;</td>
									<td style="line-height: 8px;">&nbsp;</td>
									<td width="21" style="line-height: 8px;"><img src="images/main_31.gif" width="21" height="8"></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td height="28" background="images/main_36.gif">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="177" height="28" background="images/main_32.gif">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="20%" height="22">&nbsp;</td>
									<td width="59%" valign="bottom">
										<div align="center" class="STYLE4">当前用户：<s:property value="#session.user.staffName"/></div>
									</td>
									<td width="21%">&nbsp;</td>
								</tr>
							</table>
						</td>
						<td><table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<s:set name="seq" value="0"/>
									<s:iterator id="v" value="vo.menus">
									<s:if test="#seq!=0">
										<td width="3"><img src="images/main_34.gif" width="3" height="28"></td>
									</s:if>
									<td width="65" height="28">
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td height="23" valign="bottom">
													<table width="58" border="0" align="center" cellpadding="0" cellspacing="0">
														<tr>
															<td height="20" style="cursor: hand" onmouseover="this.style.backgroundImage='url(images/bg.gif)';this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#a6d0e7';" onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'">
																<div align="center" class="STYLE3"><a href="<s:property value="#v.url"/>" target="I1" id="h_<s:property value="#seq"/>"><s:property value="#v.menuName"/></a></div>
															</td>
														</tr>
													</table>
												</td>
											</tr>
										</table>
									</td>
									<s:set name="seq" value="#seq+1"/>
									</s:iterator>
									
									<td>&nbsp;</td>
								</tr>
							</table>
						</td>
						<td width="21"><img src="images/main_37.gif" width="21" height="28"></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<script type="text/javascript">
		function loginOut() {
			parent.location.href = "loginOut.do";
		}
		function reloadFrame() {
			parent.location.reload(true);
		}
	</script>
</body>
</html>
