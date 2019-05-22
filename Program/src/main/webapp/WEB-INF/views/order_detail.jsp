<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">
<head>
    <!-- Required Meta Tags -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <!-- Page Title -->
    <title>Đơn hàng</title>

    <!-- Favicon -->
    <link rel="shortcut icon" href="/Project/resources/img/logo.jpg" type="image/x-icon">
	
    <!-- CSS Files -->
    <link rel="stylesheet" href="/Project/resources/css/animate-3.7.0.css">
    <link rel="stylesheet" href="/Project/webjars/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="/Project/webjars/jquery/2.1.4/jquery.min.js"></script>
    <link href="/Project/webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/Project/webjars/bootstrap/3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="/Project/resources/css/owl-carousel.min.css">
    <link rel="stylesheet" href="/Project/resources/css/style.css">
    
</head>
<body>
	

    <!-- Header Area Starts -->
	<%@include file="nav.jsp" %>
    <!-- Header Area End -->

   

    <!-- Food Area starts -->
    <section class="food-area section-padding">
        <div class="container">
            <div class="row">
            	<ul class="nav nav-tabs">
				    <li class="active"><a data-toggle="tab" href="#home">Món ăn đang đặt</a></li>
				    <li><a data-toggle="tab" href="#menu1">Món ăn đã đặt</a></li>
			  	</ul>
			  	<div class="tab-content">
				    <div id="home" class="tab-pane fade in active">
				      		<table class="table ">
			                	<thead>
			                		<tr>
			                			<th>Mã hóa đơn </th>
			                			<th>Tên cửa hàng </th>
			                			<th>Giá</th>
			                			<th>Trạng thái</th>
			                			<th>Xem tiến trình</th>
			                		</tr>
			                	</thead>
			                	<tbody>
			                		<c:forEach items="${LIST_TRANS }" var="item">
			                			<tr>
			                				<td>${item.id_transaction }</td>
			                				<td>${item.name_rest }</td>
			                				<td><fmt:formatNumber> ${item.price } </fmt:formatNumber></td>
			                				<td>${item.tran_stat }</td>
			                				<td>
			                					<a href="/Project/hoa-don/${item.id_transaction }" class = "btn btn-info">Chi tiết</a>
										     </td>
			                			</tr>
			                	
			                		</c:forEach>
			                	</tbody>
			                </table>
				    </div>
				    <div id="menu1" class="tab-pane fade">
				      	<table class="table ">
			                	<thead>
			                		<tr>
			                			<th>Mã hóa đơn </th>
			                			<th>Tên cửa hàng </th>
			                			<th>Giá</th>
			                			<th>Trạng thái</th>
			                			<th>Xem tiến trình</th>
			                		</tr>
			                	</thead>
			                	<tbody>
			                		<c:forEach items="${LIST_TRANS_SUCCESS }" var="item">
			                			<tr>
			                				<td>${item.id_transaction }</td>
			                				<td>${item.name_rest }</td>
			                				<td><fmt:formatNumber> ${item.price } </fmt:formatNumber></td>
			                				<td>${item.tran_stat }</td>
			                				<td>
			                					<a href="/Project/hoa-don/${item.id_transaction }" class = "btn btn-info">Chi tiết</a>
										     </td>
			                			</tr>
			                	
			                		</c:forEach>
			                	</tbody>
			                </table>
				    </div>
				    
				  </div>
                
                
            </div>
        </div>
    </section>
    <!-- Food Area End -->

    <!-- Table Area Starts -->
    
    <!-- Table Area End -->
  
    <!-- Javascript -->
    <script src="/Project/webjars/jquery/2.1.4/jquery.min.js"></script>
	<script src="/Project/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script src="/Project/resources/js/wow.min.js"></script>
    <script src="/Project/resources/js/owl-carousel.min.js"></script>
    <!-- <script src="/Project/resources/js/jquery.datetimepicker.full.min.js"></script> -->
    <script src="/Project/resources/js/jquery.nice-select.min.js"></script>
    <script src="/Project/resources/js/main.js"></script>
    <script type="text/javascript">
	    
    
    </script>
</body>

</html>