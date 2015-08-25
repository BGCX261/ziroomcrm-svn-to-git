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
									<th style="font-size:12">姓名：<s:textfield name="customerVo.argumentsBeans[0].values[0]" cssStyle="width:100px;"/></th>
									<th style="font-size:12">证件号：<s:textfield name="customerVo.argumentsBeans[1].values[0]" cssStyle="width:100px;"/></th>
									<th style="font-size:12">手机号：<s:textfield name="customerVo.argumentsBeans[2].values[0]" cssStyle="width:100px;"/></th>
									<th style="font-size:12">管家名称：
										<s:action name="searchUserByDeptCode" id="steward" executeResult="true">
											<s:param name="userVo.deptCode" value="'A18109'"/>
											<s:param name="userVo.setidJobcode" value="'专员'"/>
										</s:action>
										<s:select list="#steward.userVo.userVoes" 
											name="customerVo.argumentsBeans[3].values[0]" 
											id="steward"
											headerKey=""
											headerValue="请选择"
											listKey="staffid"
											listValue="staffName" value="customerVo.argumentsBeans[3].values[0]">
										</s:select>
									</th>
									<th style="font-size:12">区域：
										<s:action name="searchDistrict" id="steward" executeResult="true" />
										<s:select list="#steward.vo" 
											name="customerVo.argumentsBeans[4].values[0]" 
											id="steward"
											onchange="selectBussiness(this.value);"
											headerKey=""
											headerValue="请选择"
											listKey="key"
											listValue="value" value="customerVo.argumentsBeans[4].values[0]">
										</s:select>
										<select name="customerVo.argumentsBeans[5].values[0]" id="bussiness" style="width:80px"><option value="">请选择</option></select>
									</th>
									<td colspan="2" style="font-size:12"><input type="button" value="查询" onclick="searchHouse();"></td>
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
											<div>编号</div>
										</td>
										<td>
											<div>姓名</div>
										</td>
										<td>
											<div>电话</div>
										</td>
										<td>
											<div>证件类型</div>
										</td>
										<td>
											<div>证件号码</div>
										</td>
										<td>
											<div>客户来源</div>
										</td>
										<td>
											<div>缴费状态</div>
										</td>
									</tr>
								</thead>
								<tbody>
									<s:set name="pageBean" value="customerVo.pageBean"/>
									<s:set name="seq" value="#pageBean.pageSize*(#pageBean.currentPage-1)"/>
									<s:iterator id="v" value="customerVo.customerVoes">
									<s:set name="seq" value="#seq+1"/>
									<tr height="20">
										<td>
											<div align="left"><img src="images/plus.gif" style="curse:hand" onclick="showView(this, <s:property value="#seq"/>)"/></div>
										</td>
										<td>
											<div align="left"><s:property value="#seq"/></div>
										</td>
										<td>
											<div align="left"><s:property value="#v.custCode"/></div>
										</td>
										<td>
											<div align="left"><s:property value="#v.custName"/></div>
										</td>
										<td>
											<div align="left">
												<s:property value="#v.phone"/>
											</div>
										</td>
										<td>
											<div align="left"><s:property value="#v.certificateType"/></div>
										</td>
										<td>
											<div align="left"><s:property value="#v.certNum"/></div>
										</td>
										<td>
											<div align="left"><s:property value="%{@com.ziroom.common.manager.DictManager@getName('CUSTOMER_SOURCE', #v.origin)}"/></div>
										</td>
										<td>
											<div align="left">
												
											</div>
										</td>
									</tr>
									<tr style="display:none;" id="view<s:property value="#seq"/>" >
										<td colspan="2">&nbsp;</td>
										<td colspan="9">
											<table width="100%" cellpadding="0" cellspacing="1" class="tableList">
												<thead>
													<tr>
														<td>
															<div>应收周期</div>
														</td>
														<td>
															<div>租金</div>
														</td>
														<td>
															<div>期数</div>
														</td>
														<td>
															<div>应收日期</div>
														</td>
														<td>
															<div>租住期间</div>
														</td>
														<td>
															<div>房屋租金</div>
														</td>
														<td>
															<div>佣金</div>
														</td>
														<td>
															<div>押金</div>
														</td>
														<td>
															<div>保洁费</div>
														</td>
														<td>
															<div>电视费</div>
														</td>
														<td>
															<div>计划应收</div>
														</td>
														<td>
															<div>收款状态</div>
														</td>
														<td>
															<div>基本操作</div>
														</td>
													</tr>
												</thead>
												<tbody>
													<s:iterator id="r" value="#v.payPlanVoes">
													<tr height="20">
														<td>
															<div align="left"><s:property value="#r.receivableCycle"/></div>
														</td>
														<td>
															<div align="left"><s:property value="#r.periods"/></div>
														</td>
														<td>
															<div align="left"><s:property value="#r.monthRent"/></div>
														</td>
														<td>
															<div align="left"><s:date name="#r.receivableDate" format="yyyy-MM-dd"/></div>
														</td>
														<td>
															<div align="left"><s:property value="#r.rentDate"/></div>
														</td>
														<td>
															<div align="left"><s:property value="#r.rent"/></div>
														</td>
														<td>
															<div align="left"><s:property value="#r.commission"/></div>
														</td>
														<td>
															<div align="left"><s:property value="#r.cashPledge"/></div>
														</td>
														<td>
															<div align="left"><s:property value="#r.baoJieFei"/></div>
														</td>
														<td>
															<div align="left"><s:property value="#r.televisionRent"/></div>
														</td>
														<td>
															<div align="left"><s:property value="#r.receivableMoney"/></div>
														</td>
														<td>
															<div align="left">
																<s:property value="#r.status"/>
															</div>
														</td>
														<td>
															<div align="center">
																<a href="searchBills.do?payPlanVo.sysPayPlanId=<s:property value="#r.sysPayPlanId"/>">查看</a>
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
									<td class="STYLE1">&nbsp;&nbsp;共有 <s:property value="customerVo.pageBean.totalSize"/>条记录，当前第 <s:property value="customerVo.pageBean.currentPage"/>/<s:property value="customerVo.pageBean.totalPage"/>页</td>
									<td>
										<s:form action="searchCustomerAndPayPlan.do" id="searchOutContractForm">
											<s:hidden name="customerVo.pageBean.currentPage" id="pageBean_currentPage"/>
											<ziroom:search preffiex="customerVo" searchBean="customerVo"/>
											<table border="0" align="right" cellpadding="0" cellspacing="0">
												<tr>
													<td width="40"><img src="images/first.gif" width="37" height="15" onclick="first(1,'searchOutContractForm', 'pageBean_currentPage');"/></td>
													<td width="45"><img src="images/back.gif" width="43" height="15" onclick="previousPage(<s:property value="customerVo.pageBean.currentPage"/>,'searchOutContractForm', 'pageBean_currentPage');"/></td>
													<td width="45"><img src="images/next.gif" width="43" height="15" onclick="nextPage(<s:property value="customerVo.pageBean.currentPage"/>,'searchOutContractForm', 'pageBean_currentPage', <s:property value="customerVo.pageBean.totalPage"/>);"/></td>
													<td width="40"><img src="images/last.gif" width="37" height="15" onclick="last(<s:property value="customerVo.pageBean.totalPage"/>,'searchOutContractForm', 'pageBean_currentPage');"/></td>
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
			$("#houseForm").attr("action", "searchCustomerAndPayPlan.do");
			$("#houseForm").submit();
		}
		/** 业务组二级联动 */
		function selectBussiness(value, v) {
			$("#bussiness").empty();
			$("#bussiness").append("<option value=''>请选择</option>");
			if(value != "") {
				$.post("ajaxBusiness.do",{"districtCode":value},function(json) {
					$.each(json, function() {
						if(v && v == this.code) {
							$("#bussiness").append("<option value='" + this.code + "' selected='selected'>" + this.value + "</option>");
						} else {
							$("#bussiness").append("<option value='" + this.code + "'>" + this.value + "</option>");
						}
						
					
					});
				}, "json");
			}
		}
		
		/** 初始化houe界面内容 */
		$(function(){
			var deptCode = '<s:property value="customerVo.argumentsBeans[4].values[0]"/>';
			var value = '<s:property value="customerVo.argumentsBeans[5].values[0]"/>';
			if(deptCode != "") {
				selectBussiness(deptCode, value);
			}
		});
	</script>
</body>
</html>