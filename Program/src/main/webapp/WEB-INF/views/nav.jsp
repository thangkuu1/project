<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/Project/resources/js/search.js" type="text/javascript"></script>
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-dark bg-dark navbar-inverse navbar-fixed-top" style="background-color: #273268">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="/Project/trang-chu.html">FoodFage</a>
	    </div>
	    
	    
	     <form class="navbar-form navbar-left" action="" style="block">
			 <div class="input-group">
			    <input id="search" type="text" class="form-control" placeholder="Nhập tên quán ăn bạn muốn tìm" style="width: 400px">
			    <div class="input-group-btn">
			      <button class="btn btn-default" type="submit"> 
			        <i class="glyphicon glyphicon-search" style="font-size: 15px"></i>
			      </button>
			    </div>
			 </div>
			<div  id="search-box" class="search-box" style="background: white; z-index: 4;position: absolute; margin-top: 10px; width: 400px; border: 1px solid #e3e3e3;"></div>
		</form>
	    <ul class="nav navbar-nav navbar-right">
	    
	    	<ul class="nav navbar-nav">
	      		<li ><a href="/Project/hoa-don">Hóa đơn</a></li>
	    	</ul>
	    	<li class="dropdown navbar-inverse">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-bell fa-fw color_noti"></i> <b class="caret"></b>
                </a>
                <ul class="dropdown-menu dropdown-alerts">
                    <li>
                        <a href="#">
                            <div class="notify">
                               <!--  <i class="fa fa-comment fa-fw "></i>  -->
                               <input type ="hidden" id="user_id_all" value="${sessionScope.user_id } "> 
                            </div>
                        </a>
                    </li>
                    
                </ul>
            </li>
	    
	      <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-user fa-fw"></i> ${sessionScope.user_name } <b class="caret"></b>
                   
                </a>
                <ul class="dropdown-menu dropdown-user">
                    <li><a href="/Project/logout">Đăng xuất</a></li>
                </ul>
            </li>
	    </ul>
	  </div>
	</nav>
</body>
</html>