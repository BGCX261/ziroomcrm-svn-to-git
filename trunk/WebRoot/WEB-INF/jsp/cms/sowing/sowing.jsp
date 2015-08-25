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
<link rel="stylesheet" type="text/css" href="fancybox/jquery.fancybox.css" media="screen" />
<script type="text/javascript" src="fancybox/jquery.fancybox-1.2.1.js"></script>
<script type="text/javascript" src="fancybox/jquery.fancybox-1.2.1.pack.js"></script>
<ziroom:msg/>
<script type="text/javascript">
	$(function(){
		$("a.preview").fancybox();
	});
</script>
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
												<td width="95%" class="STYLE1"><span class="STYLE3">你当前的位置</span>：[首页轮播图]</td>
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
															<td class="STYLE1"><div align="center"><a href="#" onclick="findSowing();">新增</a></div></td>
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
															<td class="STYLE1"><div align="center"><a href="publishSowing.do">专题发布</a></div></td>
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
							<s:form action="" id="sowingForm">
							<input type="hidden" name="vo.id" id="sowingId" />
							<input type="hidden" name="vo.operator" id="operator" />
							<s:hidden name="vo.pageBean.currentPage"/>
							<s:token />
							<table cellpadding="0" cellspacing="1" class="tableList">
								<tr>
									<th style="font-size:12" align="left">专题类型：
										<s:select  list="#{'10000001':'内容专题','10000002':'房源推荐'}" 
											name="vo.argumentsBeans[1].values[0]" 
											headerKey=""
											headerValue="请选择"
											listKey="key"
											listValue="value" value="vo.argumentsBeans[1].values[0]" cssStyle="width:120px" onchange="showHouseCode(this.value);">
										</s:select>
									</th>
									<th  align="left" style="font-size:12" id="_houseCode" style="display:none">房源编号：<s:textfield name="vo.argumentsBeans[0].values[0]"  /></th>
									<th  align="left" style="font-size:12" colspan="2"><input type="button" value="查询" onclick="searchHouse();"></th>
								</tr>
							</table>
							<table cellpadding="0" cellspacing="1" class="tableList">
								<thead>
									<tr>
										<td width="35">
											<div>序号</div>
										</td>
										<td>
											<div>大图</div>
										</td>
										<td width="50">
											<div>缩略图</div>
										</td>
										<td>
											<div>文字描述</div>
										</td>
										<td>
											<div>专题页地址</div>
										</td>
										<td>
											<div>发布状态</div>
										</td>
										<td>
											<div>基本操作</div>
										</td>
									</tr>
								</thead>
								<tbody>
									<s:set name="pageBean" value="vo.pageBean"/>
									<s:set name="seq" value="#pageBean.pageSize*(#pageBean.currentPage-1)"/>
									<s:iterator id="v" value="vo.sowingVoes">
									<s:set name="seq" value="#seq+1"/>
									<tr height="20">
										<td width="30">
											<div align="left"><s:property value="#seq"/></div>
										</td>
										<td width="30">
											<div align="left">
												<a class="preview" href="<s:property value="#v.bigPicturePath"/>">												
													<img src='<s:property value="#v.bigPicturePath"/>' width="30" height="30"/>
												</a>
											</div>
										</td>
										<td width="50">
											<div align="left">
												<a class="preview" href="<s:property value="#v.smallPicturePath"/>">												
													<img src='<s:property value="#v.smallPicturePath"/>' width="30" height="30"/>
												</a>
											</div>
										</td>
										<td>
											<div align="left" >
												<s:property value="textDescription" escape="html"/>
											</div>
										</td>
										<td>
											<div align="left"><s:property value="#v.url"/></div>
										</td>
										<td>
											<div align="left">
												<s:if test='#v.isShow=="Y"'>
													已发布
												</s:if>
												<s:else>
													未发布
												</s:else>
											</div>
										</td>
										<td>
											<div align="center">
												<s:if test='#v.isShow=="Y"'>
													<a href="javascript:void(0);" onclick="pubSowing(<s:property value="#v.id"/>)">[已发布]</a>
												</s:if>
												<s:else>
													<a href="javascript:void(0);" onclick="pubSowing(<s:property value="#v.id"/>)">[发布]</a>
												</s:else>
												<a href="javascript:void(0);" onclick="deleteSowing(<s:property value="#v.id"/>, '<s:property value="#v.isShow"/>')">[删除]</a>
												<s:if test="vo.sowingVoes.size() == 1">
													[上移][下移]
												</s:if>
												<s:else>													
													<s:if test="#seq==1">
														<a href="javascript:void(0);" onclick="upOrDownSowing(<s:property value="#v.id"/>, 'next')">[下移]</a>
														[上移]
													</s:if>
													<s:elseif test="#seq==vo.sowingVoes.size()">
														[下移]
														<a href="javascript:void(0);" onclick="upOrDownSowing(<s:property value="#v.id"/>, 'previson')">[上移]</a>
													</s:elseif>
													<s:else>
														<a href="javascript:void(0);" onclick="upOrDownSowing(<s:property value="#v.id"/>, 'next')">[下移]</a>
														<a href="javascript:void(0);" onclick="upOrDownSowing(<s:property value="#v.id"/>, 'previson')">[上移]</a>
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
		/***/
		function findSowing() {
			$("#sowingForm").attr("action", "findSowing.do");
			$("#sowingForm").submit();
		}
		/** 查询 */
		function searchHouse() {
			$("#sowingForm").attr("action", "searchSowing.do");
			$("#sowingForm").submit();
		}
		/** 发布 */
		function pubSowing(id) {
			$("#sowingId").val(id);
			$("#sowingForm").attr("action", "pubSowing.do");
			$("#sowingForm").submit();
		}
		/** 删除 */
		function deleteSowing(id, status) {
			if(status == 'Y') {
				alert('该信息已发布，不能删除！');
				return;
			}
			$("#sowingId").val(id);
			$("#sowingForm").attr("action", "deleteSowing.do");
			$("#sowingForm").submit();
		}
		/** 数据移动操作 */
		function upOrDownSowing(id, operation) {
			$("#sowingId").val(id);
			$("#operator").val(operation);
			$("#sowingForm").attr("action", "upOrDownSowing.do");
			$("#sowingForm").submit();
		}
		/** 显示查询条件 */
		function showHouseCode(value) {
			if(value=="10000002") {
				$("#_houseCode").show();
			} else {
				$("#_houseCode").hide();
			}
		}
		var s = "<s:property value='vo.argumentsBeans[1].values[0]'/>";
		showHouseCode(s);
	</script>
</body>
</html>