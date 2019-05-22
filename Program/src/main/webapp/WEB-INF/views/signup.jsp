<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng ký thành viên</title>
<link rel="shortcut icon" href="/Project/resources/img/logo.jpg" type="image/x-icon">
<link href="/Project/webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<script src="/Project/webjars/jquery/2.1.4/jquery.min.js"></script>
<script src="/Project/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="resources/css/signup.css">
</head>
<body>
	<div class="login-form">
		<form:form action="/Project/saveUser" method="post" enctype="multipart/form-data">
			<h2 class="text-center">Sign up</h2>       
		        <div class="form-group">
		        <p>Tên đăng nhập</p>
	            <form:input type="text" path="username" class="form-control" placeholder="Username" required="required"/>  
	        </div>
	        
	        <div class="form-group">
	        	<p>Mật khẩu</p>
	            <form:input type="password" path="password" class="form-control" placeholder="Password" required="required"/>
	        </div>
	        <div class="form-group">
	        	<p>Email</p>
	            <form:input type="text" class="form-control" path ="email" placeholder="email" required="required"/>
	        </div>
	        <div class="form-group">
	        	<p>Số điện thoại</p>
	            <form:input type="text" class="form-control" path="phone" placeholder="Điện thoại" required="required"/>
	        </div>
	        <input type="file" name="file" id="fileToUpload">
	        <hr/>
	        <div class="form-group">
	            <button type="submit" class="btn btn-primary btn-block">Đăng ký</button>
	        </div>
	               
	    </form:form>
	</div>

<script src="/Project/webjars/jquery/2.1.4/jquery.min.js"></script>
<script src="/Project/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script> 
</body>
</html>