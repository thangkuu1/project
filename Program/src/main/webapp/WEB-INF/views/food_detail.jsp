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
    <title>Menu</title>

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
    
    <script src="/Project/resources/js/detail_food.js" type="text/javascript"></script>
</head>
<body>
	<!-- Preloader Starts -->
    <div class="preloader">
        <div class="spinner"></div>
    </div>
    <!-- Preloader End -->

    <!-- Header Area Starts -->
	<header class="header-area header-area2">
        <div class="container">
            <div class="row">
                <div class="col-lg-2">
                    <div class="logo-area">
                        <a href="index.html"><img src="assets/images/logo/logo2.png" alt="logo"></a>
                    </div>
                </div>
                <div class="col-lg-10">
                    <div class="custom-navbar">
                        <span></span>
                        <span></span>
                        <span></span>
                    </div>  
                    <div class="main-menu main-menu2">
                        <ul>
                            <!-- <li class="active"><a href="index.html">home</a></li>
                            <li><a href="about.html">about</a></li>
                            <li><a href="menu.html">menu</a></li>
                            <li><a href="#">blog</a>
                                <ul class="sub-menu">
                                    <li><a href="blog-home.html">Blog Home</a></li>
                                    <li><a href="blog-details.html">Blog Details</a></li>
                                </ul>
                            </li>
                            <li><a href="contact-us.html">contact</a></li>
                            <li><a href="elements.html">Elements</a></li> -->
                            
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <!-- Header Area End -->

    <!-- Banner Area Starts -->
    <section class="banner-area banner-area2 menu-bg text-center">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <h1><i></i></h1>
                    <p class="pt-2"><i></i></p>
                </div>
            </div>
        </div>
    </section>
    <!-- Banner Area End -->

    <!-- Food Area starts -->
    <section class="food-area section-padding">
        <div class="container">
            <div class="row">
                <div class="main-img col-lg-4">
                    <div class="img " >
                         <img src="${pageContext.request.contextPath}/image/${food.image_food}" class="img-fluid" alt="" style="height: 235px; width: 360px">
                    </div>
                </div>
                <div class="main-information col-lg-8" style="height: 235px;  padding-right = 0px;">
                    <div class="res-common">
                        <div class="res-common-info">
                            <div class="main-info-titel">
                                <div class="name-food">${food.name_food }</div>
                            </div>
                            <div class="address ">
                                <div class="res-common-add">
                                  <%--   <div class="fa fa-location-arrow"><span style="padding-left: 15px">${food.address_detail }</span></div> --%>
                                </div>
                            </div>
                            <div class="time">
                                <div class="res-common-time">
                                    <div class="fa fa-clock-o"><span style="padding-left: 15px">${food.open_time_food }</span></div>
                                </div>
                            </div>
                            <div class="price-food">
                                <div class="res-common-price">
                                    <div class="fa fa-money"><span style="padding-left: 15px"><fmt:formatNumber>${food.price }</fmt:formatNumber>đ</span></div>
                                </div>
                            </div>
                            <div class="btn" style="float: right; margin-top: 40px">
                                <button type="button" class="btn btn-primary"> Đặt món</button>
                            </div>
                            <div class="rate">
                                    <div class="star-rating">
                                        <span class="fa fa-star-o" data-rating="1"></span>
                                        <span class="fa fa-star-o" data-rating="2"></span>
                                        <span class="fa fa-star-o" data-rating="3"></span>
                                        <span class="fa fa-star-o" data-rating="4"></span>
                                        <span class="fa fa-star-o" data-rating="5"></span>
                                        <input type="hidden" name="whatever1" class="rating-value" value="2.56" id = "rate_count">
                                        <input type="hidden" id = "id_food_rate" value="${food.id_food }"/>
                                    </div>
                            </div>  
                        </div>
                    </div>
                </div>
            </div>
            <div class="row bootstrap snippets comment">
                <div class="col-md-12 col-sm-12">
                    <div class="comment-wrapper">
                        <div class="panel panel-info">
                            <div class="panel-body">
                                
                                <div class="clearfix"></div>
                                <hr>
                                <ul class="media-list" style="padding-bottom:20px">
                                    <li class="media">
                                    </li>
                                    <!-- <li class="media">
                                        <a href="#" class="pull-left">
                                            <img src="https://bootdey.com/img/Content/user_3.jpg" alt="" class="img-circle">
                                        </a>
                                        <div class="media-body">
                                            <span class="text-muted pull-right">
                                                <small class="text-muted">30 min ago</small>
                                            </span>
                                            <strong class="text-success">@JohnNida</strong>
                                            <p>
                                                Lorem ipsum dolor <a href="#">#sitamet</a> sit amet, consectetur adipiscing elit.
                                            </p>
                                        </div>
                                    </li> -->
                                </ul>
                                <textarea class="form-control" placeholder="write a comment..." rows="3" id="content-cmt"></textarea>
                                <input type="hidden" id="id-food" value="${food.id_food }">
                                <br>
                                <button type="button" class="btn btn-info pull-right" onclick="btnComment()">Đăng</button>
                            </div>
                        </div>
                    </div>

                </div>
                

            </div>
        </div>
    </section>
    <!-- Food Area End -->

    <!-- Table Area Starts -->
    <section class="table-area section-padding">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="section-top2 text-center">
                        <h3>Book <span>your</span> table</h3>
                        <p><i>Beast kind form divide night above let moveth bearing darkness.</i></p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-8 offset-lg-2">
                    <form action="#">
                        
                    </form>
                </div>
            </div>
        </div>
    </section>
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
        var $star_rating = $('.star-rating .fa');

        var SetRatingStar = function() {
       	return $star_rating.each(function() {
		if (parseInt($star_rating.siblings('input.rating-value').val()) >= parseInt($(this).data('rating'))) {
		      return $(this).removeClass('fa-star-o').addClass('fa-star');
		    } else {
		      return $(this).removeClass('fa-star').addClass('fa-star-o');
		    }
		  });
		};
		
		$star_rating.on('click', function() {
		  $star_rating.siblings('input.rating-value').val($(this).data('rating'));
		  console.log($('#id_food_rate').val());
		  console.log($('#rate_count').val())
		  //thangnd code insert rate in datatable rate
		  $.ajax({
			  url: '/Project/insertrate',
			  type: 'post',
			  data: { count_rate: $('#rate_count').val(), id_food: $('#id_food_rate').val()} //
		  });
		  return SetRatingStar();
		});
		
		SetRatingStar();
		/* $(document).ready(function() {
		
		}); */
    </script>
</body>

    <script src="/Project/resources/js/detail_food.js" type="text/javascript"></script>
</html>