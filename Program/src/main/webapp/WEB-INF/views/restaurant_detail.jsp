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
    <title>${restaurant.name_rest }</title>

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
    <script src="/Project/resources/js/restaurant.js" type="text/javascript"></script>
    <script src="/Project/resources/js/comment.js" type="text/javascript"></script>
    <script type="text/javascript" src="http://maps.google.com/maps/api/js?key=AIzaSyBBfOsyFLL66XcGm6vH5ZTPobC15E76Now"></script>

    
    
</head>
<body >
	<!-- Preloader Starts -->
    <%@include file="nav.jsp" %>
    <!-- Header Area End -->

    

    <!-- Food Area starts -->
    <section class="food-area section-padding">
        <div class="container">
            <div class="row">
                <div class="main-img col-lg-4">
                    <div class="img " >
                         <img src="${pageContext.request.contextPath}/image/${restaurant.image_rest}" class="img-fluid" alt="" style="height: 235px; width: 360px">
                    </div>
                </div>
                <div class="main-information col-lg-8" style="height: 235px;  padding-right = 0px;">
                    <div class="res-common">
                        <div class="res-common-info">
                            <div class="main-info-titel">
                                <div class="name-food" style="color: #464646">${restaurant.name_rest }</div>
                            </div>
                            <div class="address ">
                                <div class="res-common-add">
                                    <div class="fa fa-location-arrow address_restaurant"><span style="padding-left: 15px; color: #464646">${restaurant.addres_rest }</span></div>
                                </div>
                            </div>
                            <div class="time">
                                <div class="res-common-time">
                                    <div class="fa fa-clock-o"><span style="padding-left: 15px; color: #32900"><span style="color: #329900">Giờ mở cửa: </span> <span style="color: red">${restaurant.time_open }</span></span></div>
                                </div>
                            </div>
                            <div class="price-food">
                                <div class="res-common-price">
                                    <div class="fa fa-money"><span style="padding-left: 15px"><span style="color: #329900">Giá tiền: </span><span style="color: red"><fmt:formatNumber>${restaurant.cost_min }</fmt:formatNumber>đ - <fmt:formatNumber>${restaurant.cost_max }</fmt:formatNumber>đ</span></span></div>
                                </div>
                            </div>
                            <div class="rate">
                                    <div class="star-rating">
                                        <span class="fa fa-star-o" data-rating="1"></span>
                                        <span class="fa fa-star-o" data-rating="2"></span>
                                        <span class="fa fa-star-o" data-rating="3"></span>
                                        <span class="fa fa-star-o" data-rating="4"></span>
                                        <span class="fa fa-star-o" data-rating="5"></span>
                                        <input type="hidden" name="whatever1" class="rating-value" value="${rate_avg }" id = "rate_count">
                                        <input type="hidden" id = "id_rest_rate" value="${restaurant.id_rest }"/>
                                    </div>
                            </div>  
                        </div>
                    </div>
                </div>
            </div>
            <div class="row bootstrap snippets comment">
            	<div class="col-md-3 col-sm-3"  style="border: 1px solid #bce8f1; background: white;">
            		<h4 style="color: red; text-align: center">Đánh giá </h4>
            		<div class="row rating-desc" style="padding-top: 20px">
                       <div class="col-xs-3 col-md-3 text-right">
                           <span class="glyphicon glyphicon-star" style="color:yellow; padding-right:5px"></span> 5
                       </div>
                       <div class="col-xs-8 col-md-9">
                           <div class="progress progress-striped">
                               <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="20"
                                   aria-valuemin="0" aria-valuemax="100" style="width: ${per_rate_five}%">
                                   <span class="sr-only">${per_rate_five}%</span>
                               </div>
                           </div>
                       </div>
                       <!-- end 5 -->
                       <div class="col-xs-3 col-md-3 text-right">
                           <span class="glyphicon glyphicon-star" style="color:yellow; padding-right:5px"></span>4
                       </div>
                       <div class="col-xs-8 col-md-9">
                           <div class="progress">
                               <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="20"
                                   aria-valuemin="0" aria-valuemax="100" style="width: ${per_rate_four}%">
                                   <span class="sr-only">${per_rate_four}%</span>
                               </div>
                           </div>
                       </div>
                       <!-- end 4 -->
                       <div class="col-xs-3 col-md-3 text-right">
                           <span class="glyphicon glyphicon-star" style="color:yellow; padding-right:5px"></span>3
                       </div>
                       <div class="col-xs-8 col-md-9">
                           <div class="progress">
                               <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20"
                                   aria-valuemin="0" aria-valuemax="100" style="width: ${per_rate_three}%">
                                   <span class="sr-only">${per_rate_three}%</span>
                               </div>
                           </div>
                       </div>
                       <!-- end 3 -->
                       <div class="col-xs-3 col-md-3 text-right">
                           <span class="glyphicon glyphicon-star" style="color:yellow; padding-right:5px"></span>2
                       </div>
                       <div class="col-xs-8 col-md-9">
                           <div class="progress">
                               <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="20"
                                   aria-valuemin="0" aria-valuemax="100" style="width: ${per_rate_two}%">
                                   <span class="sr-only">${per_rate_two}%</span>
                               </div>
                           </div>
                       </div>
                       <!-- end 2 -->
                       <div class="col-xs-3 col-md-3 text-right">
                           <span class="glyphicon glyphicon-star" style="color:yellow; padding-right:5px"></span>1
                       </div>
                       <div class="col-xs-8 col-md-9">
                           <div class="progress">
                               <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80"
                                   aria-valuemin="0" aria-valuemax="100" style="width: ${per_rate_one}%">
                                   <span class="sr-only">${per_rate_one}%</span>
                               </div>
                           </div>
                       </div>
                       <!-- end 1 -->
                   </div>
                   <!-- end row -->
            	</div>
                <div class="col-md-6 col-sm-6">
                    <div class="comment-wrapper">
                        <div class="panel panel-info">
                            <div class="panel-body">
                                
                                <div class="clearfix">Các món ăn</div>
                                <hr>
                                <ul class="media-list" style="padding-bottom:20px,">
                                	<c:forEach items="${LIST_FOOD }" var="item">
                                		<li class="media" style="position: relative">
	                                        <a href="#" class="pull-left">
	                                            <img src="${pageContext.request.contextPath}/image/${item.image_food}" alt="" style="width:55px; height:50px">
	                                        </a>
	                                        <div class="media-body">
	                                        	<strong class="text-success">${item.name_food}</strong>
	                                        	<span style="position: absolute; top: 20px; left:60px">Hoàn thành dự kiến: ${item.time_work } phút</span>
	                                        	<div class = "" style="float:right; padding-left:40px" >
	                                        		<button class="btn btn-danger btn-order "  value="${item.id_food }">Chọn món
	                                        		</button>
	                                        	</div>
	                                        	<div style="float:right">
	                                        		<%-- <fmt:formatNumber>${item.id_price }</fmt:formatNumber>đ --%>
	                                        		<c:if test="${item.id_discount > 0 }">
	                                        			<span style="text-decoration: line-through;"><fmt:formatNumber>${item.id_price }</fmt:formatNumber>đ</span>
	                                        		</c:if>
	                                        		<c:if test="${item.id_discount == 0 }">
	                                        			<span ><fmt:formatNumber>${item.id_price }</fmt:formatNumber>đ</span>
	                                        		</c:if>
	                                        	</div>
	                                        	
	                                        </div>
	                                        <c:if test="${item.id_discount > 0 }">
	                                        	<div class="discount-content" style="position: absolute; top: 15px; right: 135px">
	                                        		<strong class="text-discount" style="color: red"><fmt:formatNumber> ${item.id_price - (item.id_price * item.id_discount)/100 }</fmt:formatNumber> đ</strong>
	                                        	</div>
	                                        </c:if>
                                    	</li>
                                	</c:forEach>
                                	
                                    <li class="media">
                                    </li>
                                    
                                </ul>
                                <div class="clearfix">Chỉ số của quán ăn</div>
                                <hr>
                                <div class="infor-feedback">
                                	<div >
                                		<span>Bình luân:</span> <span>${count_cmt }</span>
                                	</div>
                                	
                                </div>
                                
                                <div>
                                <div class="clearfix">Bình Luận</div>
                                <hr>
                                <textarea class="form-control" placeholder="Bạn viết bình luận" rows="3" id="content-cmt"></textarea>
	                                <input type="hidden" id="id-rest" value="${restaurant.id_rest }">
	                                <span class="error_form" id="cmt_mess" style="color: red"></span>
	                                <br>
	                                <button type="button" class="btn btn-info pull-right" onclick="btnComment()">Đăng</button>
                                <ul class="media-list comment-list" style="padding-bottom:20px;padding-top: 55px;">
                                
                                </ul>
                                </div>
                                
                            </div>
                        </div>
                    </div>

                </div>
                <!-- Don hang -->
                <div class="col-md-3 col-sm-3" style="border: 1px solid #bce8f1; background: white;">
                	<div style="border-bottom: 1px solid #bce8f1; ">
	                	<h4 style="text-align: center; color: red">Giỏ hàng</h4>
						<div class="order-panel" >
							
							
						</div>
	                	<div class="price-order"></div>
	                	<div class="form-group" style="padding-top: 20px">
						    <label for="exampleInputEmail1">Địa chỉ</label>
						    <input type="text" class="form-control" id="address" aria-describedby="emailHelp" placeholder="Nhập địa chỉ">
						    <span class="error_form" id="address_mess" style="color: red"></span>
						 </div>
	                	<div style="text-align: center; padding-bottom: 20px">
	                		<button id="order" class="btn btn-danger " id="order-ws" disabled = "disabled"  onclick="Order()">Đặt món</button>
	                	</div>
	                	<%-- <input type ="hidden" id="user_id_all" value="${sessionScope.user_id } ">  --%>
	                </div>
                	<div class="map-restaurant" style="padding:0px;margin: 0px">
						<div class="info-map" style="font-size: 20px; text-align: center; font-weight: bold;padding-top:20px;padding-bottom: 10px"> Địa chỉ quán ăn</div>
						<div class ="map-restaurant" id="googleMap" style="width: 275px; height: 300px" ></div>
                	</div>	
                </div>
				<!-- end don hang -->
					
                	
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
    <script src="/Project/resources/js/map_restaurant.js"></script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBBfOsyFLL66XcGm6vH5ZTPobC15E76Now&callback=myMap"></script>
    <script type="text/javascript">
	    websocket = new WebSocket("ws://localhost:8080/Project/chatRoomServer/" + $('#user_id_all').val().trim() + "/" + $('#id-rest').val() + "R");
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
		    			 '<a href="/Project/hoa-don"><div><i class="fa fa-comment fa-fw ">'+array[1] + '</i></div></a>' 
		    			 );
	      }
	      function processClose(message) {
	       // textAreaMessage.value += "Server Disconnect... \n";
	      }
	      function processError(message) {
	       // textAreaMessage.value += "Error... " + message +" \n";
	      }
	      var error_address = true;
	      $('#address').focusout(function(){
	    	 check_address(); 
	      });
	      
	      function check_address(){
	    	  var address = $('#address').val();
	    	  if(address.indexOf('<') != -1){
	    		  $('#address_mess').html("Chứa ký tự đặc biệt vui lòng không điền dạng '<' alert>");
	    		  $('#address_mess').show();
	    		  $('#order').attr("disabled", true);
	    		  error_address = true;
	    	  }else if(address.length == 0){
	    		  $('#address_mess').html("Bạn không được để trống phần này");
	    		  $('#address_mess').show();
	    		  $('#order').attr("disabled", true);
	    		  error_address = true;
	    	  }else{
	    		  $('#address_mess').hide();
	    		  error_address = false;
	    		  $('#order').attr("disabled", false);
	    	  }
	      }
	      
   	 $('.btn-order').click(function() {
	    	var id_food = $(this).val();
	    	console.log(id_food);
	    	$.ajax({
	    		url: '/Project/nha-hang/order',
	    		get: 'post',
	    		data: {id_food_order: id_food},
	    		
	    		success: function(result) {
	    			data = result.data;
	    			console.log(data);
	    			$('.number-spinner').remove();
	    			$('.price-order').remove();
	    			var total_price_order = 0;
	    			const formatter = new Intl.NumberFormat('en-US', {
	  				  style: 'currency',
	  				  currency: 'VND',
	  				  minimumFractionDigits: 2
	  				})
	    			if(data.length < 1){
	    				total_price_order = 0;				
	    			}else{
	    				for(var j = 0; j < data.length; j++){
	        				total_price_order += data[j].price * data[j].count_food;
	        			}
	    			}
	    			if(data.length == 0){
	    				$('.number-spinner').remove();
	    			}else{
	    				for(var i = 0; i <= data.length -1; i++){
	    					var image_food = data[i].image_food;
	    					var name_food = data[i].name_food;
	    					var count_food = data[i].count_food;
	    					var id_food = data[i].id_food;
	    					var price = data[i].price;
	    					$('.order-panel').append(
	    							'<div class="number-spinner" style="border-bottom: 1px solid #ebebeb">'
	    							+'<i class="fa fa-plus-square fa-1 btn" data-dir="up" style="color: #329900" onclick=updateOrder('+id_food+')></i>'
	    							
	    							+'<span class="number-oder">'+ count_food +'</span>'
	    							+'<i class="fa  fa-minus-square fa-1 btn" data-dir="dwn" style="color: #464646" onclick=updateSubOrder('+id_food+')></i>'
	    							+'<span>' +name_food +'</span>'		
	    							+'</div>'
	    							
	    					);

	    				} 
	    			}
	    			 
	    			 $('.order-panel').append(
	    					 '<div class="price-order" style="padding-top:10px">'
	    						+'<span> Giá tiền: </span>'
								+'<span style="float:right ;color:red" >'+ formatter.format(total_price_order) + '</span>'
	    						+'</div>'
	    			 );
	    		}
	    		
	    	});
	    });
    
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
		  console.log($('#id_rest_rate').val());
		  console.log($('#rate_count').val())
		  //thangnd code insert rate in datatable rate
		  $.ajax({
			  url: '/Project/insertrate',
			  type: 'post',
			  data: { count_rate: $('#rate_count').val(), id_rest_rate: $('#id_rest_rate').val()} //
		  });
		  return SetRatingStar();
		});
		
		SetRatingStar();
		/* $(document).ready(function() {
		
		}); */
		
		$(document).on('click', '.number-spinner i', function () {    
			var btn = $(this),
				oldValue = btn.closest('.number-spinner').find('.number-oder').text();
				newVal = 0;
			
			if (btn.attr('data-dir') == 'up') {
				newVal = parseInt(oldValue) + 1;
			} else {
				if (oldValue > 1) {
					newVal = parseInt(oldValue) - 1;
				} else {
					newVal = 1;
				}
			}
			btn.closest('.number-spinner').find('.number-oder').text(newVal);
		});
    </script>
</body>

</html>