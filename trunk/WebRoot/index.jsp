<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<script type="text/javascript">
			/** 系统登录界面 */
			function init() {
				//window.location.href = "forward.do";
				w = screen.width;
			    sh = screen.availHeight - 39;
			    version = window.navigator.appVersion;
			    pos = version.lastIndexOf("Windows NT 5.1");
			    if (pos == -1) {
			        sh = sh + 9;
			    }
			    if (w < 1024) {
			        window.open("forward.do","","width=800,height=" + sh + ",resizable=1,scrollbars=1,top=0,left=0");
			    }else{
			        window.open("forward.do","","width=1024,height=" + sh + ",resizable=1,scrollbars=1,top=0,left=0");
			    }
			    if(document.all){
			        window.opener=true;
			    }
			    window.close(); 
			}
			
			function jump(){
				window.location="forward.do";
			}
		</script>
	</head>
	<body onload="jump();">
		
	</body>
</html>
