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
												<td width="95%" class="STYLE1"><span class="STYLE3">你当前的位置</span>：[销售机会]</td>
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
													<a href="forwardSalesPage.do">添加机会</a>
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
							<table cellpadding="0" cellspacing="1" width="100%">
								<tr>
									<th style="font-size:12"></th>
									<th style="font-size:12"></th>
									<th style="font-size:12"></th>
									<th style="font-size:12"></th>
									<th style="font-size:12">
									</th>
									<th style="font-size:12">
									</th>
									<td colspan="2" style="font-size:12" align="right"><input type="button" value="查询" onclick="searchSales();"></td>
								</tr>
							</table>
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
											<div>成交几率</div>
										</td>
										<td>
											<div>客户名称</div>
										</td>
										<td>
											<div>销售类型</div>
										</td>
										<td>
											<div>操作</div>
										</td>
									</tr>
								</thead>
								<tbody>
									<s:set name="pageBean" value="salesVo.pageBean"/>
									<s:set name="seq" value="#pageBean.pageSize*(#pageBean.currentPage-1)"/>
									<s:iterator id="v" value="salesVo.salesVoes">
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
											<div align="left"><s:property value="#v.chance"/></div>
										</td>
										<td>
											<div align="left">
												<s:property value="#v.custName"/>
											</div>
										</td>
										<td>
											<div align="left">
												<s:property value="#v.type"/>
											</div>
										</td>
										<td>
											<div align="center">
												<a href="followSalesPage.do?salesVo.salesId=<s:property value="#v.salesId"/>&salesVo.type=<s:property value="#v.type"/>">[跟踪]</a>
												<a href="salesHistory.do?salesVo.salesId=<s:property value="#v.salesId"/>">[跟踪历史]</a>
											</div>
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
									<s:if test="salesVo.salesVoes.size() > 0">
										<td class="STYLE1">&nbsp;&nbsp;共有 <s:property value="salesVo.pageBean.totalSize"/>条记录，当前第 <s:property value="salesVo.pageBean.currentPage"/>/<s:property value="salesVo.pageBean.totalPage"/>页</td>
										<td>
											<s:form action="searchSales.do" id="searchSalesForm">
												<s:hidden name="salesVo.pageBean.currentPage" id="pageBean_currentPage"/>
												<ziroom:search preffiex="salesVo" searchBean="salesVo"/>
												<table border="0" align="right" cellpadding="0" cellspacing="0">
													<tr>
														<td width="40"><img src="images/first.gif" width="37" height="15" onclick="first(1,'searchSalesForm', 'pageBean_currentPage');"/></td>
														<td width="45"><img src="images/back.gif" width="43" height="15" onclick="previousPage(<s:property value="salesVo.pageBean.currentPage"/>,'searchSalesForm', 'pageBean_currentPage');"/></td>
														<td width="45"><img src="images/next.gif" width="43" height="15" onclick="nextPage(<s:property value="salesVo.pageBean.currentPage"/>,'searchSalesForm', 'pageBean_currentPage', <s:property value="salesVo.pageBean.totalPage"/>);"/></td>
														<td width="40"><img src="images/last.gif" width="37" height="15" onclick="last(<s:property value="salesVo.pageBean.totalPage"/>,'searchSalesForm', 'pageBean_currentPage');"/></td>
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
									</s:if>
									<s:else>
										<td class="STYLE1" colspan="2">没有发现记录</td>
									</s:else>
								</tr>
							</table>
						</td>
						<td width="16"><img src="images/tab_20.gif" width="16" height="35" /></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>