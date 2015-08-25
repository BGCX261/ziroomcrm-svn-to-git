<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
<link rel="stylesheet" type="text/css" href="css/style.css" media="screen">
<script type="text/javascript" src="js/jquery-1.6.min.js"></script>
<script>
	function switchSysBar() {
		var ssrc = $("#img1").attr("src");
		if (ssrc == "images/main_55.gif") {
			$("#img1").attr("src", "images/main_55_1.gif");
			$("#frmTitle").hide();
		} else {
			$("#img1").attr("src", "images/main_55.gif");
			$("#frmTitle").show();
		}
	}
</script>

</head>

<body style="background-color: #016aa9;">
	<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" style="table-layout: fixed;">
		<tr>
			<td width="171" id="frmTitle" align="center" valign="top">
				<table width="171" height="100%" border="0" cellpadding="0" cellspacing="0" style="table-layout: fixed;">
					<tr>
						<td bgcolor="#1873aa" style="width: 6px;">&nbsp;</td>
						<td width="165">
							<iframe name="I1" height="100%" width="165" src="" frameborder="0" scrolling="no"> 浏览器不支持嵌入式框架，或被配置为不显示嵌入式框架。</iframe>
						</td>
					</tr>
				</table>
			</td>
			<td width="6" style="width: 6px;" valign="middle" bgcolor="1873aa" onclick="switchSysBar()">
				<SPAN class=navPoint id=switchPoint title="关闭/打开左栏">
					<img src="images/main_55.gif" width="6" height="40" id="img1">
				</SPAN>
			</td>
			<td width="100%" align="center" valign="top">
				<iframe name="I2" height="100%" width="99%" style="background-color: white;" frameborder="0" src="" scrolling="yes"> 浏览器不支持嵌入式框架，或被配置为不显示嵌入式框架。</iframe>
			</td>
		</tr>
	</table>
</body>
</html>
