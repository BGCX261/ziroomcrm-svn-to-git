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
												<td width="95%" class="STYLE1"><span class="STYLE3">你当前的位置</span>：[对账单]</td>
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
							<s:hidden name="customerVo.pageBean.currentPage" id="vpc"/>
							<s:token />
							<table cellpadding="0" cellspacing="1" class="tableList">
								<tr>
									<th style="font-size:12">姓名：<s:textfield name="refereeVo.argumentsBeans[0].values[0]" cssStyle="width:100px;"/></th>
									<th style="font-size:12">证件号：<s:textfield name="refereeVo.argumentsBeans[1].values[0]" cssStyle="width:100px;"/></th>
									<th style="font-size:12">手机号：<s:textfield name="refereeVo.argumentsBeans[2].values[0]" cssStyle="width:100px;"/></th>
									</th>
									<td colspan="2" style="font-size:12"><input type="button" value="查询" onclick="searchHouse();"></td>
								</tr>
							</table>
							<table cellpadding="0" cellspacing="1" class="tableList">
								<thead>
									<tr>
										<td width="3%">
											<div>序号</div>
										</td>
										<td>
											<div>合同号</div>
										</td>
										<td>
											<div>姓名</div>
										</td>
										<td>
											<div>电话</div>
										</td>
										<td>
											<div>证件号码</div>
										</td>
									</tr>
								</thead>
								<tbody>
									<s:set name="pageBean" value="refereeVo.pageBean"/>
									<s:set name="seq" value="#pageBean.pageSize*(#pageBean.currentPage-1)"/>
									<s:iterator id="v" value="refereeVo.list">
									<s:set name="seq" value="#seq+1"/>
									<tr height="20">
										<td>
											<div align="left"><s:property value="#seq"/></div>
										</td>
										<td>
											<div align="left"><s:property value="#v.contractCode"/></div>
										</td>
										<td>
											<div align="left"><s:property value="#v.custName"/></div>
										</td>
										<td>
											<div align="left">
												<s:property value="#v.telphone"/>
											</div>
										</td>
										<td>
											<div align="left"><s:property value="#v.certNo"/></div>
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
									<td class="STYLE1">&nbsp;&nbsp;共有 <s:property value="refereeVo.pageBean.totalSize"/>条记录，当前第 <s:property value="refereeVo.pageBean.currentPage"/>/<s:property value="refereeVo.pageBean.totalPage"/>页</td>
									<td>
										<s:form action="searchReferee.do" id="searchOutContractForm">
											<s:hidden name="refereeVo.pageBean.currentPage" id="pageBean_currentPage"/>
											<ziroom:search preffiex="refereeVo" searchBean="refereeVo"/>
											<table border="0" align="right" cellpadding="0" cellspacing="0">
												<tr>
													<td width="40"><img src="images/first.gif" width="37" height="15" onclick="first(1,'searchOutContractForm', 'pageBean_currentPage');"/></td>
													<td width="45"><img src="images/back.gif" width="43" height="15" onclick="previousPage(<s:property value="refereeVo.pageBean.currentPage"/>,'searchOutContractForm', 'pageBean_currentPage');"/></td>
													<td width="45"><img src="images/next.gif" width="43" height="15" onclick="nextPage(<s:property value="refereeVo.pageBean.currentPage"/>,'searchOutContractForm', 'pageBean_currentPage', <s:property value="refereeVo.pageBean.totalPage"/>);"/></td>
													<td width="40"><img src="images/last.gif" width="37" height="15" onclick="last(<s:property value="refereeVo.pageBean.totalPage"/>,'searchOutContractForm', 'pageBean_currentPage');"/></td>
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
		function showView(o, id) {
			var s = $(o).attr("src");
			if(s == "images/plus.gif") {
				$(o).attr("src", "images/minus.gif");
				$("#view"+id).show();
			} else {
				$(o).attr("src", "images/plus.gif");
				$("#view"+id).hide();
			}
		}
		/** 合同查询 */
		function searchHouse() {
			$("#vpc").val(1);
			$("#houseForm").attr("action", "searchReferee.do");
			$("#houseForm").submit();
		}
	</script>
</body>
</html>