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
			//$("#img1").attr("src", "images/main_55_1.gif");
			//$(parent.leftFrame).hide();
			//$("#frmTitle").hide();
		} else {
			//$("#img1").attr("src", "images/main_55.gif");
			//$("#frmTitle").show();
			//$(parent.leftFrame).show();
		}
	}
</script>
</head>

<body style="background-color: #016aa9;">
	<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" style="table-layout: fixed;">
		<tr>
			<td width="6" style="width: 6px;" valign="middle" bgcolor="1873aa" onclick="switchSysBar()">
				<span class=navPoint id="switchPoint">
					<img src="images/main_55.gif" width="6" height="40" id="img1">
				</span>
			</td>
		</tr>
	</table>
</body>
</html>
