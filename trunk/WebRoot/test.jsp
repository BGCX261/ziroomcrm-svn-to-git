<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title></title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	</head>

	<body>
		提交订单接口：<br>
		<form action="http://172.16.18.57/index.php?ctrl=createpay&act=toCreatepay" method="post">
			承租合同号:<input type="text" name="contract" value="BJC12800065"/><br>
			单笔金额:<input type="text" name="price" value="1700"/><br>
			总金额:<input type="text" name="total_price" value="1700"/><br>
			用户编号:<input type="text" name="uid" value="9006510"/><br>
			用户名称:<input type="text" name="user_name" value="田园"/><br>
			支付宝账号：<input type="text" name="pay_number" value=""/><br>
			订单数量:<input type="text" name="total_fee" value=""/><br>
			房屋房间名称:<input type="text" name="house_name" value="朝阳区朝阳门1号线华纺易城4居室"/><br>
			房屋编号：<input type="text" name="house_code" value="00404530"/><br>
			房间编号:<input type="text" name="room_code" value="05"/><br>
			付款期数:<input type="text" name="pay_plan" value="2"/><br>
			<input type="submit" value="提交"/><br>
		</form>
		查询订单状态：<br>
		<a href='http://172.16.18.57/index.php?ctrl=createpay&act=selectPay&json={"contract":"BJC12800065","price":"1700","total_price":"1700","pay_plan":"2","sign_info":"967C4D337188E114D916DD849FF3B266"}'>查询订单状态</a>
	</body>
</html>