<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link href="/Project/webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<script src="/Project/webjars/jquery/2.1.4/jquery.min.js"></script>
<script src="/Project/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="resources/css/signup.css">
</head>
<body>
	<!--post modal-->
		<div id="postModal" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
		  <div class="modal-dialog">
		  <div class="modal-content">
			  <div class="modal-header">
				  <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					Chia sẻ món ăn
			  </div>
			  <div class="modal-body">
				  <form class="form center-block">
					<div class="form-group">
					  <textarea class="form-control input-lg" autofocus="" placeholder="Bạn muốn chia sẻ" id="content_food"></textarea>
					</div>
					<div class="form-group">
						<form:form method='post' action='/Project/saveFood' enctype="multipart/form-data">
				          	Select file : <input type='file' name='file' id='file' class='form-control' ><br>
				          	<button type="submit" class="btn btn-primary btn-block">Dang</button>
				        </form:form>
				        
						<!-- <form class="form-horizontal" id="myForm" method="POST" enctype="multipart/form-data">
							<input type="file" onchange="readURL(this);" name="file" id="file" >
							<img id="blah" src="" alt="" />
						</form> -->
					</div>
					
				  </form>
			  </div>
			  <!-- <div class="modal-footer">
			  				  <div>
			  					<button class="btn btn-primary btn-sm" data-dismiss="modal" onclick="SaveFood()" aria-hidden="true">Đăng
			  				  </div>	
			  </div> -->
		  </div>
		  </div>
		</div>

<script src="/Project/webjars/jquery/2.1.4/jquery.min.js"></script>
<script src="/Project/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>