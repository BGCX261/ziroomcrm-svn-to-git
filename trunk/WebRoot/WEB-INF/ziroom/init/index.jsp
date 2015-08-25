<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title></title>
	</head>
	<frameset rows="98,*,8" frameborder="no" border="0" framespacing="0">
		<frame src="top.do" name="topFrame" scrolling="No" noresize="noresize"
			id="topFrame" />
		<frameset cols="165,6,*" frameborder="no" border="0" framespacing="0">
			<frame src="left.do" name="leftFrame" id="leftFrame" scrolling="yes"/>
			<frame src="center.do" name="centerFrame" id="centerFrame" scrolling="yes"/>
			<frame src="" name="mainFrame" id="mainFrame" scrolling="yes"/>
		</frameset>
		<frame src="bottom.do" name="bottomFrame" scrolling="No"
			noresize="noresize" id="bottomFrame" />
	</frameset>
	<noframes>
		<body>
		</body>
	</noframes>
</html>
