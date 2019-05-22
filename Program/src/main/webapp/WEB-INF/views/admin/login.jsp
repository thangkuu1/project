<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/Project/webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<link href="/Project/webjars/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<!-- <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"> -->
<script src="/Project/webjars/jquery/2.1.4/jquery.min.js"></script>
<script src="/Project/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Đăng nhập</title>
</head>
<body>
	<div class="container">
		<div class="loginform" style="background-color: #ECF0F1;margin: 10px auto;width: 300px;padding: 20px;border-radius: 11px;">
			<h2 style="text-align: center; font-weight: bold; margin-bottom: 30px;">Đăng nhập</h2>
			<h4 style='color:red;'>${status}</h4>
				<form action="/Project/admin/login" method='post' id='form'>
					<h4>Tên đăng nhập</h4>
					<input type='text' placeholder='Nhập vào tên đăng nhập'class='form-control' name="username" >
					<h4>Mật khẩu</h4>
					<input type='password' placeholder='Nhập vào mật khẩu' class='form-control' name="password" >
					<input type='submit' id='loginsubmit' class='btn btn-primary' value='Đăng nhập' style='margin-bottom: 16px; margin-top: 15px; margin-left: 75px;'>
					
				</form>
		</div>
	</div>
</body>
</html>