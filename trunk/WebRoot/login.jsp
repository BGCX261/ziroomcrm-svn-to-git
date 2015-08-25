<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>自如有家客户关系管理系统</title>
	    
        <!-- Meta data for SEO -->
        <meta name="description" content="">
        <meta name="keywords" content="">

        <!-- Template stylesheet -->
        <link href="css/blue/screen.css" rel="stylesheet" type="text/css" media="all">
        <link href="css/datepicker.css" rel="stylesheet" type="text/css" media="all">
        <link href="js/visualize/visualize.jQuery.css" rel="stylesheet" type="text/css" media="all">
        <link href="js/jwysiwyg/jquery.wysiwyg.css" rel="stylesheet" type="text/css" media="all">
        <link href="js/fancybox/jquery.fancybox-1.3.4.css" rel="stylesheet" type="text/css" media="all">

        <!--[if IE]>
            <link href="css/ie.css" rel="stylesheet" type="text/css" media="all">
            <meta http-equiv="X-UA-Compatible" content="IE=7" />
        <![endif]-->

        <!-- Jquery and plugins -->
        <script type="text/javascript" src="js/jquery-1.7.2.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.20.customer.min.js"></script>
        <script type="text/javascript" src="js/jquery.img.preload.js"></script>
        <script type="text/javascript" src="js/hint.js"></script>
        <script type="text/javascript" src="js/visualize/visualize.jQuery.js"></script>
        <script type="text/javascript" src="js/jwysiwyg/jquery.wysiwyg.js"></script>
        <script type="text/javascript" src="js/fancybox/jquery.fancybox-1.3.4.js"></script>
        <script type="text/javascript" charset="utf-8">
            $(function(){
                // find all the input elements with title attributes
                $('input[title!=""]').hint();
                $('#login_info').click(function(){
                    $(this).fadeOut('fast');
                });

                $("#remember").toggle(function(){
                    $("#login_info").show();
                },function(){
                    $("#login_info").hide();
                });
            });
        </script>
    </head>

    <body class="login" screen_capture_injected="true" duitang_screen_capture_injected="true">

	<!-- Begin login window -->
	<div id="login_wrapper">
	    <div id="login_info" class="alert_warning noshadow" style="width: 350px; margin: auto; display: none; ">
			<p>请选择主题的颜色</p>
			<p>
				<span style="float:left;width:20px;height:20px;display:block;background:#000000;cursor:pointer;margin-right:5px" onclick="location.href=&#39;login_black.html&#39;"></span>
				<span style="float:left;width:20px;height:20px;display:block;background:#BF2317;cursor:pointer;margin-right:5px" onclick="location.href=&#39;login_red.html&#39;"></span>
				<span style="float:left;width:20px;height:20px;display:block;background:#67CF00;cursor:pointer;margin-right:5px" onclick="location.href=&#39;login_green.html&#39;"></span>
			</p>
			<br class="clear"><br>
		</div>

		<br class="clear">
		<div id="login_top_window">
			<img src="images/top_login_window.png" alt="top window">
		</div>
		
		<!-- Begin content -->
		<div id="login_body_window">
			<div class="inner">
                <h3 style="color: #F93">自如友家客户关系管理系统</h3>
				<form action="http://www.gallyapp.com/tf_themes/weadmin/dashboard_blue.html" method="get" id="form_login" name="form_login">
					<p>
						<input type="text" id="username" name="username" style="width:285px" title="Username" class="blur">
					</p>
					<p>
						<input type="password" id="password" name="password" style="width:285px" title="******" class="blur">
					</p>
					<p style="margin-top:50px">
						<input type="submit" id="submit" name="submit" value="Login" class="Login" style="margin-right:5px">
						<input type="checkbox" id="remember" name="remember">请记住我
					</p>
				</form>
			</div>
		</div>
		<!-- End content -->
		
		<div id="login_footer_window">
			<img src="images/footer_login_window.png" alt="footer window">
		</div>
		<div id="login_reflect">
			<img src="images/reflect.png" alt="window reflect">
		</div>
	</div>
	<!-- End login window -->

    <div id="fancybox-tmp"></div>
    <div id="fancybox-loading">
        <div></div>
    </div>

    </body>
</html>