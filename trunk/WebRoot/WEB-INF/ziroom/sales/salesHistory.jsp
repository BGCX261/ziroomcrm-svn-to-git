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
												<td width="95%" class="STYLE1"><span class="STYLE3">你当前的位置</span>：[机会跟踪历史]</td>
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
							<s:form action="" id="salesForm">
							<s:hidden name="salesVo.pageBean.currentPage" id="vpc"/>
							<s:token />
							<table cellpadding="0" cellspacing="1" class="tableList">
								<thead>
									<tr>
										<td width="3%">
											<div>序号</div>
										</td>
										<td>
											<div>机会名称</div>
										</td>
										<td>
											<div>类型</div>
										</td>
										<td>
											<div>来源</div>
										</td>
										<td>
											<div>阶段</div>
										</td>
										<td>
											<div>阶段描述</div>
										</td>
										<td>
											<div>成交几率</div>
										</td>
									</tr>
								</thead>
								<tbody>
									<s:set name="pageBean" value="salesVo.pageBean"/>
									<s:set name="seq" value="#pageBean.pageSize*(#pageBean.currentPage-1)"/>
									<s:iterator id="v" value="salesVo.trackingHistoryVoes">
									<s:set name="seq" value="#seq+1"/>
									<tr height="20">
										<td>
											<div align="left"><s:property value="#seq"/></div>
										</td>
										<td>
											<div align="left"><s:property value="#v.salesName"/></div>
										</td>
										<td>
											<div align="left"><s:property value="#v.salesType"/></div>
										</td>
										<td>
											<div align="left"><s:property value="#v.origin" /></div>
										</td>
										<td>
											<div align="left"><s:property value="#v.stage"/></div>
										</td>
										<td>
											<div align="left"><s:property value="#v.stageDesc"/></div>
										</td>
										<td>
											<div align="left"><s:property value="#v.chance"/></div>
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