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
<script type="text/javascript" src="js/ziroom/menu.js"></script>
<script type="text/javascript" src="js/ziroom/page.js"></script>
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/struts/jquery-validator-rule.js"></script>
<script type="text/javascript" src="js/struts/struts-validator.js"></script>
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
							<s:form action="saveSowing.do" id="sowingForm" enctype="multipart/form-data">
							<s:token />
							<s:hidden name="vo.pageBean.currentPage"/>
							<s:hidden name="vo.id"/>
							<ziroom:search preffiex="vo" searchBean="vo"/>
							<table cellpadding="0" cellspacing="1" width="100%">
								<tr height="20">
									<td>&nbsp;</td>
								</tr>
								<tr>
									<td align="center">
										<table cellpadding="0" cellspacing="1" class="tableForm" width="80%">
											<thead>
												<tr>
													<th colspan="10">轮播图信息</th>
												</tr>
											</thead>
											<tbody>
											<tr height="20" id="_houseCode">
												<th>房源编号：</th>
												<td>
													<s:textfield name="vo.houseCode" />
												</td>
											</tr>
											<tr height="20">
												<th>主图：</th>
												<td>
													<input type="file" name="vo.big"/>
												</td>
											</tr>
											<tr height="20">
												<th>缩略图：</th>
												<td>
													<input type="file" name="vo.small"/>
												</td>
											</tr>
											<tr height="20">
												<th>专题页地址：</th>
												<td>
													<s:textfield name="vo.url"/>
												</td>
											</tr>
											<tr height="20">
												<th>专题类型：</th>
												<td>
													<s:select  list="#{'10000001':'内容专题','10000002':'房源推荐'}" 
														name="vo.projectType" 
														headerKey=""
														headerValue="请选择"
														listKey="key"
														listValue="value" value="vo.projectType" cssStyle="width:120px" onchange="showHouseCode(this.value);">
													</s:select>
												</td>
											</tr>
											<tr height="20">
												<th>文字描述：</th>
												<td>
													<input type="hidden" name="vo.textDescription" id="tdp">
													<textarea class="ckeditor" id="editor1" cols="80" rows="5"></textarea>
												</td>
											</tr>
											</tbody>
											<tr>
												<td align="center" colspan="10"><input type="button" value="确认" onclick="doSubmit();" /></td>
											</tr>
											<tr height="20">
												<td align="center" colspan="10">&nbsp;</td>
											</tr>
										</table>
									</td>
								</tr>
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
	<script type="text/javascript">
		function doSubmit() {
			var oEditor = CKEDITOR.instances.editor1;
			$("#tdp").val(oEditor.getData());
			if(strutsValidator("","sowingForm",[])) {
				$("#sowingForm").submit();
			}
		}
		/** 显示查询条件 */
		function showHouseCode(value) {
			if(value=="10000002") {
				$("#_houseCode").show();
			} else {
				$("#_houseCode").hide();
			}
		}
	</script>
	<common:validator actionName="saveSowing" formId="sowingForm" spring="true" />
</body>
</html>