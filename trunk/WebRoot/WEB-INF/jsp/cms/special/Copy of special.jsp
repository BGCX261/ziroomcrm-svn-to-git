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
												<td width="95%" class="STYLE1"><span class="STYLE3">你当前的位置</span>：[专题页]</td>
											</tr>
										</table>
									</td>
									<td width="54%">
										<table border="0" align="right" cellpadding="0" cellspacing="0">
											<tr>
												<td width="60">
													<table width="90%" border="0" cellpadding="0" cellspacing="0">
														<tr>
															<td class="STYLE1">
																<div align="center">
																	<img src="images/22.gif" width="14" height="14" />
																</div>
															</td>
															<td class="STYLE1"><div align="center"><a href="javascript:void(0)" onclick="findSpecial();">新增</a></div></td>
														</tr>
													</table>
												</td>
												<td width="80">
													<table width="90%" border="0" cellpadding="0" cellspacing="0">
														<tr>
															<td class="STYLE1">
																<div align="center">
																	<img src="images/22.gif" width="14" height="14" />
																</div>
															</td>
															<td class="STYLE1"><div align="center"><a href="#" onclick="pubSpecial();">专题发布</a></div></td>
														</tr>
													</table>
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
							<s:form action="" id="specialForm">
							<input type="hidden" name="vo.id" id="specialId" />
							<input type="hidden" name="vo.operation" id="operator" />
							<s:hidden name="vo.pageBean.currentPage"/>
							<s:token />
							<table cellpadding="0" cellspacing="1" class="tableList">
								<tr>
									<td>
										专题：
										<s:select  list="#{'11000001':'经典','11000002':'原创','11000003':'闺宿'}" 
											name="vo.argumentsBeans[0].values[0]" 
											headerKey=""
											headerValue="请选择"
											listKey="key"
											id="specialType"
											listValue="value" value="vo.argumentsBeans[0].values[0]" cssStyle="width:120px" onchange="searchSpecial();">
										</s:select>
									</td>
								</tr>
							</table>
							<table cellpadding="0" cellspacing="1" class="tableList">
								<thead>
									<tr>
										<td width="50">
											<div>序号</div>
										</td>
										<td>
											<div>房源名称</div>
										</td>
										<td width="80">
											<div>房间图片</div>
										</td>
										<td>
											<div>房间朝向</div>
										</td>
										<td>
											<div>房间价格</div>
										</td>
										<td>
											<div>卧室类型</div>
										</td>
										<td>
											<div>房源编号</div>
										</td>
										<td>
											<div>专题类型</div>
										</td>
										<td>
											<div>基本操作</div>
										</td>
									</tr>
								</thead>
								<tbody>
									<s:set name="pageBean" value="vo.pageBean"/>
									<s:set name="seq" value="#pageBean.pageSize*(#pageBean.currentPage-1)"/>
									<s:iterator id="v" value="vo.specialVoes">
									<s:set name="seq" value="#seq+1"/>
									<tr height="20">
										<td>
											<div align="left"><s:property value="#seq"/></div>
										</td>
										<td>
											<div align="left">
												<s:property value="#v.roomName"/>
											</div>
										</td>
										<td width="50">
											<div align="left">
												<img src='<s:property value="#v.imagePath"/>' width="30" height="30"/>
											</div>
										</td>
										<td>
											<div align="left">
												<s:property value="#v.roomPosition"/>
											</div>
										</td>
										<td>
											<div align="left"><s:property value="#v.rentFee"/></div>
										</td>
										<td>
											<div align="left"><s:property value="#v.roomType"/></div>
										</td>
										<td>
											<div align="left"><s:property value="#v.houseCode"/></div>
										</td>
										<td>
											<div align="left">
												<s:if test='#v.specialType=="11000001"'>
												经典
												</s:if>
												<s:elseif test='#v.specialType=="11000002"'>
												原创
												</s:elseif>
												<s:elseif test='#v.specialType=="11000003"'>
												闺宿
												</s:elseif>
											</div>
										</td>
										<td>
											<div align="center">
												<a href="javascript:void(0);" onclick="deleteSpecial(<s:property value="#v.id"/>)">[删除]</a>
												<s:if test="vo.specialVoes.size() == 1">
													[上移][下移]
												</s:if>
												<s:else>													
													<s:if test="#seq==1">
														<a href="javascript:void(0);" onclick="upOrDownSpecial(<s:property value="#v.id"/>, 'next')">[下移]</a>
														[上移]
													</s:if>
													<s:elseif test="#seq==vo.specialVoes.size()">
														[下移]
														<a href="javascript:void(0);" onclick="upOrDownSpecial(<s:property value="#v.id"/>, 'previson')">[上移]</a>
													</s:elseif>
													<s:else>
														<a href="javascript:void(0);" onclick="upOrDownSpecial(<s:property value="#v.id"/>, 'next')">[下移]</a>
														<a href="javascript:void(0);" onclick="upOrDownSpecial(<s:property value="#v.id"/>, 'previson')">[上移]</a>
													</s:else>
												</s:else>
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
									<td class="STYLE1">&nbsp;&nbsp;</td>
									<td>
										&nbsp;
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
		function findSpecial() {
			var specialType = $("#specialType").val();
			if(specialType=="") {
				alert("请选择专题");
				return;
			}
			$("#specialForm").attr("action", "findSpecail.do");
			$("#specialForm").submit();
		}
		/** 删除专题 */
		function deleteSpecial(id) {
			$("#specialId").val(id);
			$("#specialForm").attr("action", "deleteSpecail.do");
			$("#specialForm").submit();
		}
		/** 上移下移操作 */
		function upOrDownSpecial(id, operation) {
			$("#specialId").val(id);
			$("#operator").val(operation);
			$("#specialForm").attr("action", "upOrDownSpecial.do");
			$("#specialForm").submit();
		}
		/** 查询 */
		function searchSpecial() {
			$("#specialForm").attr("action", "searchSpecial.do");
			$("#specialForm").submit();
		}
		/** 发布专题 */
		function pubSpecial() {
			var specialType = $("#specialType").val();
			if(specialType=="") {
				alert("请选择发布专题");
				return;
			}
			$.post("pubSpecial.do",{"vo.specialType":specialType}, function(data) {
				if(data=="success") {
					alert("发布成功");
				}
			});
		}
	</script>
</body>
</html>