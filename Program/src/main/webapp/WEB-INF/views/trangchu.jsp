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
    <title>Trang chủ</title>

    <!-- Favicon -->
    <link rel="shortcut icon" href="/Project/resources/img/logo.jpg" type="image/x-icon">

    <!-- CSS Files -->
    <link rel="stylesheet" href="/Project/resources/css/animate-3.7.0.css">
    <link rel="stylesheet" href="/Project/webjars/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="/Project/webjars/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="/Project/webjars/jquery/2.1.4/jquery.min.js"></script>
    <link rel="stylesheet" href="/Project/resources/css/owl-carousel.min.css">
    <link rel="stylesheet" href="/Project/resources/css/style.css">
    <link rel="stylesheet" href="/Project/resources/css/home_page.css">
    <script src="/Project/resources/js/trangchu.js" type="text/javascript"></script>
    <script src="/Project/resources/js/search.js" type="text/javascript"></script>
</head>
<body>
    

    <!-- Header Area Starts -->
	<nav class="navbar navbar-expand-md navbar-dark bg-dark navbar-inverse navbar-fixed-top" style="background-color: #273268">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#">FoodFage</a>
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
	    	<c:if test="${sessionScope.user_name != null }">
			    <ul class="nav navbar-nav">
			      <li ><a href="/Project/hoa-don">Hóa đơn</a></li>
			    </ul>
	    	</c:if>
	    	<c:if test="${sessionScope.user_name == null }">
	    		<ul class="nav navbar-nav">
			      <li ><a href="/Project/load-login">Đăng nhập</a></li>
			    </ul>
	    	</c:if>
	    	<c:if test="${sessionScope.user_name != null }">
		    	<li class="dropdown navbar-inverse">
	                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
	                    <i class="fa fa-bell fa-fw color_noti"></i> <b class="caret"></b>
	                     <input type ="hidden" id="user_id_all" value="${sessionScope.user_id } "> 
	                </a>
	                <ul class="dropdown-menu dropdown-alerts">
	                    <li>
	                        <a href="#">
	                            <div class="notify">
	                               <!--  <i class="fa fa-comment fa-fw "></i>  -->
	                            </div>
	                        </a>
	                    </li>
	                    
	                </ul>
	            </li>
	    		<li class="dropdown">
	                <a class="dropdown-toggle check_user" data-toggle="dropdown" href="#">
	                    <i class="fa fa-user fa-fw"></i> ${sessionScope.user_name } <b class="caret"></b>
	                </a>
	                <ul class="dropdown-menu dropdown-user">
	                    <li><a href="/Project/logout">Đăng xuất</a></li>
	                </ul>
	            </li>
	    	</c:if>
	    	
	      
	    </ul>
	  </div>
	</nav>
    <!-- Header Area End -->

    

    <!-- Food Area starts -->
    
    <section class="food-area section-padding">
        <div class="container">
            <div class="row">
            	<ul class="nav nav-tabs" style="padding-left: 50px">
            		<!-- <li><a data-toggle="tab" href="#discount">Khuyến mãi</a></li> -->
            		<li class="active"><a data-toggle="tab" href="#home">Tất cả</a></li>
				    <li ><a data-toggle="tab" href="#rate">Đánh giá cao</a></li>
				    <li><a data-toggle="tab" href="#food">Đồ ăn</a></li>
				    <li><a data-toggle="tab" href="#drink">Đồ uống</a></li>
				    <li><a data-toggle="tab" href="#snacks">Ăn vặt</a></li>
				    <li><a data-toggle="tab" href="#time_ten">Móm làm < 10 phút</a></li>
				    <li ><a data-toggle="tab" href="#time10-20">Món làm 10-20 phút</a></li>
				    <li><a data-toggle="tab" href="#time20-30"> Món làm từ 20-30 phút</a></li>
				    <li><a data-toggle="tab" href="#time-30">Món làm > 30 phút</a></li>
			  	</ul>
			  	<div class="tab-content">
			  		<div id="discount" class="tab-pane fade ">
		            	<c:forEach items="${list_restaurant_by_discount }" var="item">
		            		<div class="col-md-3 col-sm-4" style="border: 1px solid #f5f5f5;">
			                    <div class="single-food">
			                    	<a href="/Project/nha-hang/${item.id_rest }">
				                        <div class="food-img" >
				                            <img src="${pageContext.request.contextPath}/image/${item.image_rest}" class="img-fluid" alt="${item.name_rest }" title="${item.name_rest }" style="width: 265px; height: 175px">
				                        </div>
				                        <div class="food-content">
				                            <div class="d-flex justify-content-between">
				                                <h5 style="text-overflow: ellipsis; overflow: hidden; white-space: nowrap;" title="${item.name_rest }">${item.name_rest }</h5>
				                                <div style="text-overflow: ellipsis; overflow: hidden; white-space: nowrap; width: 250px; height: 20px" title="${item.address_rest }">${item.address_rest }</div>
				                                <div class="food-rate-cmt">
													<div class="rate food-rate">
						                                 <div class="star-rating">
						                                      <c:if test="${item.rate_rest > 1 }">
							                                    	<c:forEach begin="0" end="${item.rate_rest - 1 }" varStatus="loop" >
							                                    		<span class="fa fa-star" data-rating="1"></span>
							                                    		<input type="hidden" value="i">
							                                    	</c:forEach>
								                                    <c:forEach begin="${item.rate_rest  }" end="4" varStatus="loop" >
					                                    				<span class="fa fa-star-o" data-rating="1"></span>
					                                    			</c:forEach>
							                                    </c:if>
							                                    
							                                    <c:if test="${item.rate_rest == 1 }">
							                                    	<span class="fa fa-star" data-rating="1"></span>
							                                    	<c:forEach begin="${item.rate_rest  }" end="4" varStatus="loop" >
						                                    			<span class="fa fa-star-o" data-rating="1"></span>
						                                    		</c:forEach>
							                                    	
							                                    </c:if>
							                                    
							                                    <c:if test="${item.rate_rest == 0 }">
							                                    	<c:forEach begin="0" end="4" varStatus="loop" >
							                                    		<span class="fa fa-star-o" data-rating="1"></span>
							                                    	</c:forEach>
							                                    </c:if>
							                                    
							                                   <%--  <span style="font-size: 15px; padding-left: 2px"><fmt:formatNumber>${item.rate_rest }</fmt:formatNumber> <span class="fa fa-star" data-rating="1"></span></span> --%>
						                                  </div>
						                            </div> 
						                            <div class="food-rate food-cmt">
						                            	<div><i class="fa fa-comments fa-4" style="font-size: 20px; color: #7d7979" aria-hidden="true"></i><span style="padding-left:3px">${item.count_cmt } </span></div>
						                            </div> 
												</div>
				                            </div>
				                            <c:if test="${item.sum_discount > 0 }">
				                            	<div class="food-discount"></i><label style="color: white">Khuyến mãi</label></div>
				                            </c:if>
				                            
				                        </div>
				                     </a>
			                    </div>
		                	</div>
		            	</c:forEach>
	                </div>
			  	
			  	
				  	<div id="home" class="tab-pane fade in active">
		            	<c:forEach items="${LIST_RESTAURANT }" var="item">
		            		<div class="col-md-3 col-sm-4" style="border: 1px solid #f5f5f5;">
			                    <div class="single-food">
			                    	<a href="/Project/nha-hang/${item.id_rest }">
				                        <div class="food-img" >
				                            <img src="${pageContext.request.contextPath}/image/${item.image_rest}" class="img-fluid" alt="${item.name_rest }" title="${item.name_rest }" style="width: 265px; height: 175px">
				                        </div>
				                        <div class="food-content">
				                            <div class="d-flex justify-content-between">
				                                <h5 style="text-overflow: ellipsis; overflow: hidden; white-space: nowrap;" title="${item.name_rest }">${item.name_rest }</h5>
				                                <div style="text-overflow: ellipsis; overflow: hidden; white-space: nowrap; width: 250px; height: 20px" title="${item.address_rest }">${item.address_rest }</div>
				                                <div class="food-rate-cmt">
													<div class="rate food-rate">
						                                 <div class="star-rating">
						                                      <c:if test="${item.rate_rest > 1 }">
							                                    	<c:forEach begin="0" end="${item.rate_rest - 1 }" varStatus="loop" >
							                                    		<span class="fa fa-star" data-rating="1"></span>
							                                    		<input type="hidden" value="i">
							                                    	</c:forEach>
								                                    <c:forEach begin="${item.rate_rest  }" end="4" varStatus="loop" >
					                                    				<span class="fa fa-star-o" data-rating="1"></span>
					                                    			</c:forEach>
							                                    </c:if>
							                                    
							                                    <c:if test="${item.rate_rest == 1 }">
							                                    	<span class="fa fa-star" data-rating="1"></span>
							                                    	<c:forEach begin="${item.rate_rest  }" end="4" varStatus="loop" >
						                                    			<span class="fa fa-star-o" data-rating="1"></span>
						                                    		</c:forEach>
							                                    	
							                                    </c:if>
							                                    
							                                    <c:if test="${item.rate_rest == 0 }">
							                                    	<c:forEach begin="0" end="4" varStatus="loop" >
							                                    		<span class="fa fa-star-o" data-rating="1"></span>
							                                    	</c:forEach>
							                                    </c:if>
							                                    
							                                   <%--  <span style="font-size: 15px; padding-left: 2px"><fmt:formatNumber>${item.rate_rest }</fmt:formatNumber> <span class="fa fa-star" data-rating="1"></span></span> --%>
						                                  </div>
						                            </div> 
						                            <div class="food-rate food-cmt">
						                            	<div><i class="fa fa-comments fa-4" style="font-size: 20px; color: #7d7979" aria-hidden="true"></i><span style="padding-left:3px">${item.count_cmt } </span></div>
						                            </div> 
												</div>
				                            </div>
				                            <c:if test="${item.sum_discount > 0 }">
				                            	<div class="food-discount"></i><label style="color: white">Khuyến mãi</label></div>
				                            </c:if>
				                            
				                        </div>
				                     </a>
			                    </div>
		                	</div>
		            	</c:forEach>
	                </div>
	                
	                <!--  list restaurant by rate -->
	                <div id="rate" class="tab-pane fade ">
	                	<c:forEach items="${list_rest_by_rate }" var="item">
		            		<div class="col-md-3 col-sm-4" style="border: 1px solid #f5f5f5;">
			                    <div class="single-food">
			                    	<a href="/Project/nha-hang/${item.id_rest }">
				                        <div class="food-img" >
				                            <img src="${pageContext.request.contextPath}/image/${item.image_rest}" class="img-fluid" alt="${item.name_rest }" title="${item.name_rest }" style="width: 265px; height: 175px">
				                        </div>
				                        <div class="food-content">
				                            <div class="d-flex justify-content-between">
				                                <h5 style="text-overflow: ellipsis; overflow: hidden; white-space: nowrap;" title="${item.name_rest }">${item.name_rest }</h5>
				                                <div style="text-overflow: ellipsis; overflow: hidden; white-space: nowrap; width: 250px; height: 20px" title="${item.address_rest }">${item.address_rest }</div>
				                                <div class="food-rate-cmt">
													<div class="rate food-rate">
						                                 <div class="star-rating">
						                                      <c:if test="${item.rate_rest > 1 }">
							                                    	<c:forEach begin="0" end="${item.rate_rest - 1 }" varStatus="loop" >
							                                    		<span class="fa fa-star" data-rating="1"></span>
							                                    		<input type="hidden" value="i">
							                                    	</c:forEach>
								                                    <c:forEach begin="${item.rate_rest  }" end="4" varStatus="loop" >
					                                    				<span class="fa fa-star-o" data-rating="1"></span>
					                                    			</c:forEach>
							                                    </c:if>
							                                    
							                                    <c:if test="${item.rate_rest == 1 }">
							                                    	<span class="fa fa-star" data-rating="1"></span>
							                                    	<c:forEach begin="${item.rate_rest  }" end="4" varStatus="loop" >
						                                    			<span class="fa fa-star-o" data-rating="1"></span>
						                                    		</c:forEach>
							                                    	
							                                    </c:if>
							                                    
							                                    <c:if test="${item.rate_rest == 0 }">
							                                    	<c:forEach begin="0" end="4" varStatus="loop" >
							                                    		<span class="fa fa-star-o" data-rating="1"></span>
							                                    	</c:forEach>
							                                    </c:if>
							                                    
							                                    <span style="font-size: 15px; padding-left: 2px"><fmt:formatNumber>${item.rate_rest }</fmt:formatNumber> <span class="fa fa-star" data-rating="1"></span></span>
						                                  </div>
						                            </div> 
						                            <div class="food-rate food-cmt">
						                            	<div><i class="fa fa-comments fa-4" style="font-size: 20px; color: #7d7979" aria-hidden="true"></i><span style="padding-left:3px">${item.count_cmt } </span></div>
						                            </div> 
												</div>
				                            </div>
				                            <!-- <div class="food-discount"></i><label style="color: white">Khuyến mãi</label></div> -->
				                            <c:if test="${item.sum_discount > 0 }">
				                            	<div class="food-discount"></i><label style="color: white">Khuyến mãi</label></div>
				                         	</c:if>
				                        </div>
				                        
				                     </a>
			                    </div>
		                	</div>
		            	</c:forEach>
	                </div>
                	<!-- list restaurant by drink -->
                	<div id="drink" class="tab-pane fade">
		            	<c:forEach items="${list_restaurant_by_drink }" var="item">
		            		<div class="col-md-3 col-sm-4" style="border: 1px solid #f5f5f5;">
			                    <div class="single-food">
			                    	<a href="/Project/nha-hang/${item.id_rest }">
				                        <div class="food-img" >
				                            <img src="${pageContext.request.contextPath}/image/${item.image_rest}" class="img-fluid" alt="${item.name_rest }" title="${item.name_rest }" style="width: 265px; height: 175px">
				                        </div>
				                        <div class="food-content">
				                            <div class="d-flex justify-content-between">
				                                <h5 style="text-overflow: ellipsis; overflow: hidden; white-space: nowrap;" title="${item.name_rest }">${item.name_rest }</h5>
				                                <div style="text-overflow: ellipsis; overflow: hidden; white-space: nowrap; width: 250px; height: 20px" title="${item.address_rest }">${item.address_rest }</div>
				                                <div class="food-rate-cmt">
													<div class="rate food-rate">
						                                 <div class="star-rating">
						                                      <c:if test="${item.rate_rest > 1 }">
							                                    	<c:forEach begin="0" end="${item.rate_rest - 1 }" varStatus="loop" >
							                                    		<span class="fa fa-star" data-rating="1"></span>
							                                    		<input type="hidden" value="i">
							                                    	</c:forEach>
								                                    <c:forEach begin="${item.rate_rest  }" end="4" varStatus="loop" >
					                                    				<span class="fa fa-star-o" data-rating="1"></span>
					                                    			</c:forEach>
							                                    </c:if>
							                                    
							                                    <c:if test="${item.rate_rest == 1 }">
							                                    	<span class="fa fa-star" data-rating="1"></span>
							                                    	<c:forEach begin="${item.rate_rest  }" end="4" varStatus="loop" >
						                                    			<span class="fa fa-star-o" data-rating="1"></span>
						                                    		</c:forEach>
							                                    	
							                                    </c:if>
							                                    
							                                    <c:if test="${item.rate_rest == 0 }">
							                                    	<c:forEach begin="0" end="4" varStatus="loop" >
							                                    		<span class="fa fa-star-o" data-rating="1"></span>
							                                    	</c:forEach>
							                                    </c:if>
							                                    
							                                    <span style="font-size: 15px; padding-left: 2px"><fmt:formatNumber>${item.rate_rest }</fmt:formatNumber> <span class="fa fa-star" data-rating="1"></span></span>
						                                  </div>
						                            </div> 
						                            <div class="food-rate food-cmt">
						                            	<div><i class="fa fa-comments fa-4" style="font-size: 20px; color: #7d7979" aria-hidden="true"></i><span style="padding-left:3px">${item.count_cmt } </span></div>
						                            </div> 
												</div>
				                            </div>
				                            <c:if test="${item.sum_discount > 0 }">
				                            	<div class="food-discount"></i><label style="color: white">Khuyến mãi</label></div>
				                         	</c:if>
				                        </div>
				                     </a>
			                    </div>
		                	</div>
		            	</c:forEach>
	                </div>
	                
	                <!-- list restaurant by food -->
	                <div id="food" class="tab-pane fade">
		            	<c:forEach items="${list_restaurant_by_food }" var="item">
		            		<div class="col-md-3 col-sm-4" style="border: 1px solid #f5f5f5;">
			                    <div class="single-food">
			                    	<a href="/Project/nha-hang/${item.id_rest }">
				                        <div class="food-img" >
				                            <img src="${pageContext.request.contextPath}/image/${item.image_rest}" class="img-fluid" alt="${item.name_rest }" title="${item.name_rest }" style="width: 265px; height: 175px">
				                        </div>
				                        <div class="food-content">
				                            <div class="d-flex justify-content-between">
				                                <h5 style="text-overflow: ellipsis; overflow: hidden; white-space: nowrap;" title="${item.name_rest }">${item.name_rest }</h5>
				                                <div style="text-overflow: ellipsis; overflow: hidden; white-space: nowrap; width: 250px; height: 20px" title="${item.address_rest }">${item.address_rest }</div>
				                                <div class="food-rate-cmt">
													<div class="rate food-rate">
						                                 <div class="star-rating">
						                                      <c:if test="${item.rate_rest > 1 }">
							                                    	<c:forEach begin="0" end="${item.rate_rest - 1 }" varStatus="loop" >
							                                    		<span class="fa fa-star" data-rating="1"></span>
							                                    		<input type="hidden" value="i">
							                                    	</c:forEach>
								                                    <c:forEach begin="${item.rate_rest  }" end="4" varStatus="loop" >
					                                    				<span class="fa fa-star-o" data-rating="1"></span>
					                                    			</c:forEach>
							                                    </c:if>
							                                    
							                                    <c:if test="${item.rate_rest == 1 }">
							                                    	<span class="fa fa-star" data-rating="1"></span>
							                                    	<c:forEach begin="${item.rate_rest  }" end="4" varStatus="loop" >
						                                    			<span class="fa fa-star-o" data-rating="1"></span>
						                                    		</c:forEach>
							                                    	
							                                    </c:if>
							                                    
							                                    <c:if test="${item.rate_rest == 0 }">
							                                    	<c:forEach begin="0" end="4" varStatus="loop" >
							                                    		<span class="fa fa-star-o" data-rating="1"></span>
							                                    	</c:forEach>
							                                    </c:if>
							                                    
							                                    <span style="font-size: 15px; padding-left: 2px"><fmt:formatNumber>${item.rate_rest }</fmt:formatNumber> <span class="fa fa-star" data-rating="1"></span></span>
						                                  </div>
						                            </div> 
						                            <div class="food-rate food-cmt">
						                            	<div><i class="fa fa-comments fa-4" style="font-size: 20px; color: #7d7979" aria-hidden="true"></i><span style="padding-left:3px">${item.count_cmt } </span></div>
						                            </div> 
												</div>
				                            </div>
				                            <c:if test="${item.sum_discount > 0 }">
				                            	<div class="food-discount"></i><label style="color: white">Khuyến mãi</label></div>
				                         	</c:if>
				                        </div>
				                     </a>
			                    </div>
		                	</div>
		            	</c:forEach>
	                </div>
	                
	                <!-- list restaurant by snacks -->
	                <div id="snacks" class="tab-pane fade">
		            	<c:forEach items="${list_restaurant_by_snacks }" var="item">
		            		<div class="col-md-3 col-sm-4" style="border: 1px solid #f5f5f5;">
			                    <div class="single-food">
			                    	<a href="/Project/nha-hang/${item.id_rest }">
				                        <div class="food-img" >
				                            <img src="${pageContext.request.contextPath}/image/${item.image_rest}" class="img-fluid" alt="${item.name_rest }" title="${item.name_rest }" style="width: 265px; height: 175px">
				                        </div>
				                        <div class="food-content">
				                            <div class="d-flex justify-content-between">
				                                <h5 style="text-overflow: ellipsis; overflow: hidden; white-space: nowrap;" title="${item.name_rest }">${item.name_rest }</h5>
				                                <div style="text-overflow: ellipsis; overflow: hidden; white-space: nowrap; width: 250px; height: 20px" title="${item.address_rest }">${item.address_rest }</div>
				                                <div class="food-rate-cmt">
													<div class="rate food-rate">
						                                 <div class="star-rating">
						                                      <c:if test="${item.rate_rest > 1 }">
							                                    	<c:forEach begin="0" end="${item.rate_rest - 1 }" varStatus="loop" >
							                                    		<span class="fa fa-star" data-rating="1"></span>
							                                    		<input type="hidden" value="i">
							                                    	</c:forEach>
								                                    <c:forEach begin="${item.rate_rest  }" end="4" varStatus="loop" >
					                                    				<span class="fa fa-star-o" data-rating="1"></span>
					                                    			</c:forEach>
							                                    </c:if>
							                                    
							                                    <c:if test="${item.rate_rest == 1 }">
							                                    	<span class="fa fa-star" data-rating="1"></span>
							                                    	<c:forEach begin="${item.rate_rest  }" end="4" varStatus="loop" >
						                                    			<span class="fa fa-star-o" data-rating="1"></span>
						                                    		</c:forEach>
							                                    	
							                                    </c:if>
							                                    
							                                    <c:if test="${item.rate_rest == 0 }">
							                                    	<c:forEach begin="0" end="4" varStatus="loop" >
							                                    		<span class="fa fa-star-o" data-rating="1"></span>
							                                    	</c:forEach>
							                                    </c:if>
							                                    
							                                    <span style="font-size: 15px; padding-left: 2px"><fmt:formatNumber>${item.rate_rest }</fmt:formatNumber> <span class="fa fa-star" data-rating="1"></span></span>
						                                  </div>
						                            </div> 
						                            <div class="food-rate food-cmt">
						                            	<div><i class="fa fa-comments fa-4" style="font-size: 20px; color: #7d7979" aria-hidden="true"></i><span style="padding-left:3px">${item.count_cmt } </span></div>
						                            </div> 
												</div>
				                            </div>
				                        </div>
				                     </a>
			                    </div>
		                	</div>
		            	</c:forEach>
	                </div>
	                
	                <!-- begin -->
	                <div id="time_ten" class="tab-pane fade in active">
		            	<c:forEach items="${list_restaurant_by_time_ten }" var="item">
		            		<div class="col-md-3 col-sm-4" style="border: 1px solid #f5f5f5;">
			                    <div class="single-food">
			                    	<a href="/Project/nha-hang/${item.id_rest }">
				                        <div class="food-img" >
				                            <img src="${pageContext.request.contextPath}/image/${item.image_rest}" class="img-fluid" alt="${item.name_rest }" title="${item.name_rest }" style="width: 265px; height: 175px">
				                        </div>
				                        <div class="food-content">
				                            <div class="d-flex justify-content-between">
				                                <h5 style="text-overflow: ellipsis; overflow: hidden; white-space: nowrap;" title="${item.name_rest }">${item.name_rest }</h5>
				                                <div style="text-overflow: ellipsis; overflow: hidden; white-space: nowrap; width: 250px; height: 20px" title="${item.address_rest }">${item.address_rest }</div>
				                                <div class="food-rate-cmt">
													<div class="rate food-rate">
						                                 <div class="star-rating">
						                                      <c:if test="${item.rate_rest > 1 }">
							                                    	<c:forEach begin="0" end="${item.rate_rest - 1 }" varStatus="loop" >
							                                    		<span class="fa fa-star" data-rating="1"></span>
							                                    		<input type="hidden" value="i">
							                                    	</c:forEach>
								                                    <c:forEach begin="${item.rate_rest  }" end="4" varStatus="loop" >
					                                    				<span class="fa fa-star-o" data-rating="1"></span>
					                                    			</c:forEach>
							                                    </c:if>
							                                    
							                                    <c:if test="${item.rate_rest == 1 }">
							                                    	<span class="fa fa-star" data-rating="1"></span>
							                                    	<c:forEach begin="${item.rate_rest  }" end="4" varStatus="loop" >
						                                    			<span class="fa fa-star-o" data-rating="1"></span>
						                                    		</c:forEach>
							                                    	
							                                    </c:if>
							                                    
							                                    <c:if test="${item.rate_rest == 0 }">
							                                    	<c:forEach begin="0" end="4" varStatus="loop" >
							                                    		<span class="fa fa-star-o" data-rating="1"></span>
							                                    	</c:forEach>
							                                    </c:if>
							                                    
							                                   <%--  <span style="font-size: 15px; padding-left: 2px"><fmt:formatNumber>${item.rate_rest }</fmt:formatNumber> <span class="fa fa-star" data-rating="1"></span></span> --%>
						                                  </div>
						                            </div> 
						                            <div class="food-rate food-cmt">
						                            	<div><i class="fa fa-comments fa-4" style="font-size: 20px; color: #7d7979" aria-hidden="true"></i><span style="padding-left:3px">${item.count_cmt } </span></div>
						                            </div> 
												</div>
				                            </div>
				                            <c:if test="${item.sum_discount > 0 }">
				                            	<div class="food-discount"></i><label style="color: white">Khuyến mãi</label></div>
				                            </c:if>
				                            
				                        </div>
				                     </a>
			                    </div>
		                	</div>
		            	</c:forEach>
	                </div>
			  		<!-- end time ten -->
			  		<div id="time10-20" class="tab-pane fade">
		            	<c:forEach items="${list_restaurant_by_time_ten_twenty }" var="item">
		            		<div class="col-md-3 col-sm-4" style="border: 1px solid #f5f5f5;">
			                    <div class="single-food">
			                    	<a href="/Project/nha-hang/${item.id_rest }">
				                        <div class="food-img" >
				                            <img src="${pageContext.request.contextPath}/image/${item.image_rest}" class="img-fluid" alt="${item.name_rest }" title="${item.name_rest }" style="width: 265px; height: 175px">
				                        </div>
				                        <div class="food-content">
				                            <div class="d-flex justify-content-between">
				                                <h5 style="text-overflow: ellipsis; overflow: hidden; white-space: nowrap;" title="${item.name_rest }">${item.name_rest }</h5>
				                                <div style="text-overflow: ellipsis; overflow: hidden; white-space: nowrap; width: 250px; height: 20px" title="${item.address_rest }">${item.address_rest }</div>
				                                <div class="food-rate-cmt">
													<div class="rate food-rate">
						                                 <div class="star-rating">
						                                      <c:if test="${item.rate_rest > 1 }">
							                                    	<c:forEach begin="0" end="${item.rate_rest - 1 }" varStatus="loop" >
							                                    		<span class="fa fa-star" data-rating="1"></span>
							                                    		<input type="hidden" value="i">
							                                    	</c:forEach>
								                                    <c:forEach begin="${item.rate_rest  }" end="4" varStatus="loop" >
					                                    				<span class="fa fa-star-o" data-rating="1"></span>
					                                    			</c:forEach>
							                                    </c:if>
							                                    
							                                    <c:if test="${item.rate_rest == 1 }">
							                                    	<span class="fa fa-star" data-rating="1"></span>
							                                    	<c:forEach begin="${item.rate_rest  }" end="4" varStatus="loop" >
						                                    			<span class="fa fa-star-o" data-rating="1"></span>
						                                    		</c:forEach>
							                                    	
							                                    </c:if>
							                                    
							                                    <c:if test="${item.rate_rest == 0 }">
							                                    	<c:forEach begin="0" end="4" varStatus="loop" >
							                                    		<span class="fa fa-star-o" data-rating="1"></span>
							                                    	</c:forEach>
							                                    </c:if>
							                                    
							                                   <%--  <span style="font-size: 15px; padding-left: 2px"><fmt:formatNumber>${item.rate_rest }</fmt:formatNumber> <span class="fa fa-star" data-rating="1"></span></span> --%>
						                                  </div>
						                            </div> 
						                            <div class="food-rate food-cmt">
						                            	<div><i class="fa fa-comments fa-4" style="font-size: 20px; color: #7d7979" aria-hidden="true"></i><span style="padding-left:3px">${item.count_cmt } </span></div>
						                            </div> 
												</div>
				                            </div>
				                            <c:if test="${item.sum_discount > 0 }">
				                            	<div class="food-discount"></i><label style="color: white">Khuyến mãi</label></div>
				                            </c:if>
				                            
				                        </div>
				                     </a>
			                    </div>
		                	</div>
		            	</c:forEach>
	                </div>
	                <!-- end time 10-20 -->
	                <div id="time20-30" class="tab-pane fade">
		            	<c:forEach items="${list_restaurant_by_time_twenty_thirty }" var="item">
		            		<div class="col-md-3 col-sm-4" style="border: 1px solid #f5f5f5;">
			                    <div class="single-food">
			                    	<a href="/Project/nha-hang/${item.id_rest }">
				                        <div class="food-img" >
				                            <img src="${pageContext.request.contextPath}/image/${item.image_rest}" class="img-fluid" alt="${item.name_rest }" title="${item.name_rest }" style="width: 265px; height: 175px">
				                        </div>
				                        <div class="food-content">
				                            <div class="d-flex justify-content-between">
				                                <h5 style="text-overflow: ellipsis; overflow: hidden; white-space: nowrap;" title="${item.name_rest }">${item.name_rest }</h5>
				                                <div style="text-overflow: ellipsis; overflow: hidden; white-space: nowrap; width: 250px; height: 20px" title="${item.address_rest }">${item.address_rest }</div>
				                                <div class="food-rate-cmt">
													<div class="rate food-rate">
						                                 <div class="star-rating">
						                                      <c:if test="${item.rate_rest > 1 }">
							                                    	<c:forEach begin="0" end="${item.rate_rest - 1 }" varStatus="loop" >
							                                    		<span class="fa fa-star" data-rating="1"></span>
							                                    		<input type="hidden" value="i">
							                                    	</c:forEach>
								                                    <c:forEach begin="${item.rate_rest  }" end="4" varStatus="loop" >
					                                    				<span class="fa fa-star-o" data-rating="1"></span>
					                                    			</c:forEach>
							                                    </c:if>
							                                    
							                                    <c:if test="${item.rate_rest == 1 }">
							                                    	<span class="fa fa-star" data-rating="1"></span>
							                                    	<c:forEach begin="${item.rate_rest  }" end="4" varStatus="loop" >
						                                    			<span class="fa fa-star-o" data-rating="1"></span>
						                                    		</c:forEach>
							                                    	
							                                    </c:if>
							                                    
							                                    <c:if test="${item.rate_rest == 0 }">
							                                    	<c:forEach begin="0" end="4" varStatus="loop" >
							                                    		<span class="fa fa-star-o" data-rating="1"></span>
							                                    	</c:forEach>
							                                    </c:if>
							                                    
							                                   <%--  <span style="font-size: 15px; padding-left: 2px"><fmt:formatNumber>${item.rate_rest }</fmt:formatNumber> <span class="fa fa-star" data-rating="1"></span></span> --%>
						                                  </div>
						                            </div> 
						                            <div class="food-rate food-cmt">
						                            	<div><i class="fa fa-comments fa-4" style="font-size: 20px; color: #7d7979" aria-hidden="true"></i><span style="padding-left:3px">${item.count_cmt } </span></div>
						                            </div> 
												</div>
				                            </div>
				                            <c:if test="${item.sum_discount > 0 }">
				                            	<div class="food-discount"></i><label style="color: white">Khuyến mãi</label></div>
				                            </c:if>
				                            
				                        </div>
				                     </a>
			                    </div>
		                	</div>
		            	</c:forEach>
	                </div>
	                <!-- end time 20-30 -->
	                <div id="time-30" class="tab-pane fade">
		            	<c:forEach items="${list_restaurant_by_time_thirty_large }" var="item">
		            		<div class="col-md-3 col-sm-4" style="border: 1px solid #f5f5f5;">
			                    <div class="single-food">
			                    	<a href="/Project/nha-hang/${item.id_rest }">
				                        <div class="food-img" >
				                            <img src="${pageContext.request.contextPath}/image/${item.image_rest}" class="img-fluid" alt="${item.name_rest }" title="${item.name_rest }" style="width: 265px; height: 175px">
				                        </div>
				                        <div class="food-content">
				                            <div class="d-flex justify-content-between">
				                                <h5 style="text-overflow: ellipsis; overflow: hidden; white-space: nowrap;" title="${item.name_rest }">${item.name_rest }</h5>
				                                <div style="text-overflow: ellipsis; overflow: hidden; white-space: nowrap; width: 250px; height: 20px" title="${item.address_rest }">${item.address_rest }</div>
				                                <div class="food-rate-cmt">
													<div class="rate food-rate">
						                                 <div class="star-rating">
						                                      <c:if test="${item.rate_rest > 1 }">
							                                    	<c:forEach begin="0" end="${item.rate_rest - 1 }" varStatus="loop" >
							                                    		<span class="fa fa-star" data-rating="1"></span>
							                                    		<input type="hidden" value="i">
							                                    	</c:forEach>
								                                    <c:forEach begin="${item.rate_rest  }" end="4" varStatus="loop" >
					                                    				<span class="fa fa-star-o" data-rating="1"></span>
					                                    			</c:forEach>
							                                    </c:if>
							                                    
							                                    <c:if test="${item.rate_rest == 1 }">
							                                    	<span class="fa fa-star" data-rating="1"></span>
							                                    	<c:forEach begin="${item.rate_rest  }" end="4" varStatus="loop" >
						                                    			<span class="fa fa-star-o" data-rating="1"></span>
						                                    		</c:forEach>
							                                    	
							                                    </c:if>
							                                    
							                                    <c:if test="${item.rate_rest == 0 }">
							                                    	<c:forEach begin="0" end="4" varStatus="loop" >
							                                    		<span class="fa fa-star-o" data-rating="1"></span>
							                                    	</c:forEach>
							                                    </c:if>
							                                    
							                                   <%--  <span style="font-size: 15px; padding-left: 2px"><fmt:formatNumber>${item.rate_rest }</fmt:formatNumber> <span class="fa fa-star" data-rating="1"></span></span> --%>
						                                  </div>
						                            </div> 
						                            <div class="food-rate food-cmt">
						                            	<div><i class="fa fa-comments fa-4" style="font-size: 20px; color: #7d7979" aria-hidden="true"></i><span style="padding-left:3px">${item.count_cmt } </span></div>
						                            </div> 
												</div>
				                            </div>
				                            <c:if test="${item.sum_discount > 0 }">
				                            	<div class="food-discount"></i><label style="color: white">Khuyến mãi</label></div>
				                            </c:if>
				                            
				                        </div>
				                     </a>
			                    </div>
		                	</div>
		            	</c:forEach>
	                </div>
                </div>
            </div>
            <!-- Row 2 -->
            
    </section>
    <!-- Food Area End -->

    <!-- Table Area Starts -->
    <%@include file="footer.jsp" %>
    <!-- Table Area End -->

    


    <!-- Javascript -->
    <script src="/Project/webjars/jquery/2.1.4/jquery.min.js"></script>
	<script src="/Project/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script src="/Project/resources/js/wow.min.js"></script>
    <script src="/Project/resources/js/owl-carousel.min.js"></script>
    <!-- <script src="/Project/resources/js/jquery.datetimepicker.full.min.js"></script> -->
    <script src="/Project/resources/js/jquery.nice-select.min.js"></script>
    <script src="/Project/resources/js/main.js"></script>
    <script src="/Project/resources/js/trangchu.js" type="text/javascript">
    	
    </script>
    <script type="text/javascript">
    if($('#user_id_all').val().length > 0){
	    websocket = new WebSocket("ws://localhost:8080/Project/chatRoomServer/" + $('#user_id_all').val().trim() + "/0" );
	    console.log("1212" +websocket);
	    websocket.onopen = function(message) {processOpen(message);};
	   // websocket.send("thang");
	   
	    websocket.onmessage = function(message) {processMessage(message);};
	    websocket.onclose = function(message) {processClose(message);};
	    websocket.onerror = function(message) {processError(message);};
	    
	    function processOpen(message) {
	        //textAreaMessage.value += "Server connect... \n";
	      }
	      function processMessage(message) {
	    	  var data = message.data;
	    	  var array = data.split(',');
	    	  $('.color_noti').css("color", "red");
		    	 $('.notify').append(
		    			 '<a href="/Project/hoa-don"><div><i class="fa fa-comment fa-fw ">'+ array[1] + '</i></div></a>' 
		    			 );
	      }
	      function processClose(message) {
	       // textAreaMessage.value += "Server Disconnect... \n";
	      }
	      function processError(message) {
	       // textAreaMessage.value += "Error... " + message +" \n";
	      }
	      
	      //rate restaurent
	      
    }   
      
    </script>
</body>
</html>
