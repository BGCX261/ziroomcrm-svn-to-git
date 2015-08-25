<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"  prefix="decorator" %>
<%
	String path=request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!-- Website Title -->
	    <title>自如友家 - <decorator:title default="客户关系管理系统"/></title>
		
	    <!-- Meta data for SEO -->
	    <meta name="description" content="">
	    <meta name="keywords" content="">
	
	    <!-- Template stylesheet -->
	    <link href="css/blue/screen.css" 	rel="stylesheet" type="text/css" media="all">
	    <link href="css/blue/datepicker.css" rel="stylesheet" type="text/css" media="all">
	    <link href="css/tipsy.css" 			rel="stylesheet" type="text/css" media="all">
	    <link href="js/visualize/visualize.jQuery.css" 		rel="stylesheet" type="text/css" media="all">
	    <link href="js/jwysiwyg/jquery.wysiwyg.css" 			rel="stylesheet" type="text/css" media="all">
	    <link href="js/fancybox/jquery.fancybox-1.3.4.css" 	rel="stylesheet" type="text/css" media="all">
	
	    <!--[if IE]>
	    <link href="css/ie.css" rel="stylesheet" type="text/css" media="all">
	    <script type="text/javascript" src="js/excanvas.js"></script>
	    <![endif]-->
	
	    <!-- Jquery and plugins -->
	    <script type="text/javascript" src="js/jquery-1.7.2.js"></script>
	    <script type="text/javascript" src="js/jquery-ui-1.8.20.custom.min.js"></script>
	    <script type="text/javascript" src="js/jquery.img.preload.js"></script>
	    <script type="text/javascript" src="js/hint.js"></script>
	    <script type="text/javascript" src="js/visualize/visualize.jQuery.js"></script>
	    <script type="text/javascript" src="js/jwysiwyg/jquery.wysiwyg.js"></script>
	    <script type="text/javascript" src="js/fancybox/jquery.mousewheel-3.0.4.pack.js"></script>
	    <script type="text/javascript" src="js/fancybox/jquery.fancybox-1.3.4.js"></script>
	    <script type="text/javascript" src="js/jquery.tipsy.js"></script>
	    <script type="text/javascript" src="js/custom_blue.js"></script>
	</head>
	
	<body>
		<div class="content_wrapper">

			<!-- 添加头部的页面 -->
	    	<jsp:include page="header.jsp"/>

			<!-- 添加左侧的页面 -->
        	<jsp:include page="left.jsp"/>


	        <!-- Begin content -->
	        <div id="content">
	            <div class="inner">
		            <decorator:body></decorator:body>
	            </div>
	
	            <br class="clear"/>
	            <br class="clear"/>
	
	
	            <jsp:include page="footer.jsp" flush="true"/>
	        </div>
	        <!-- End content -->
	    </div>
	</body>
</html>