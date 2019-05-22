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
    <title>Tiến trình</title>

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
    <link rel="stylesheet" href="/Project/resources/css/order_detail_id.css">
    
</head>
<body>
	
	<%@include file="nav.jsp" %>
    <!-- Header Area End -->


    <!-- Food Area starts -->
    <section class="food-area section-padding" style="background: white">
        <div class="container">
            <div class="row">
            	<h4 style="style: text-align: center; color: black">Tiến trình</h4>
                <div class="progress" >
                		<c:forEach items="${listprogress }" var = "list">
					         <div id="test2" class="progress-bar ${list.progress } ws_process progress-bar-striped" role="progressbar" aria-valuenow="80"
					             aria-valuemin="0" aria-valuemax="100" style="width: ${list.width}" > ${list.name_progress}
					             <span class="sr-only">${list.width }</span>
					         </div>
					     
                		</c:forEach>
                </div>
                <div class = "col-md-3">
                	<div class="name_progress_time"> Các mốc thời gian</div>
                	<div class="text-element content-element circles-list">
                		
						<ol class="step_id">
							<c:forEach items="${listprogress }" var = "item">
								
								<c:if test="${item.name_progress == 'Đang chờ' }">
								<li><span>Trạng thái: </span><span style="font-weight: bold; color: red"> ${item.name_progress }</br></span>Thời gian:<span style="font-weight: bold; color: red">${item.time }</span></br> </li>
							
								</c:if>
								<c:if test="${item.name_progress == 'Đang làm món ăn' }">
									<li><span>Trạng thái: </span><span style="font-weight: bold; color: red">${item.name_progress }</span></br>Thời gian: <span style="font-weight: bold; color: red"> ${item.time }</span></br>Thời gian dự kiến: <span style="font-weight: bold; color: red"> ${item.time_expect} </span> </br>${item.notes }</li>
									
								</c:if>
								<c:if test="${item.name_progress == 'Đang giao hàng' }">
									<li><span>Trạng thái: </span> <span style="font-weight: bold; color: red">${item.name_progress }</span></br>Thời gian: <span style="font-weight: bold; color: red">${item.time }</span>  </br> Khoảng cách: <span style="font-weight: bold; color: red">${item.distance }</span></br> Thời gian giao hàng: <span style="font-weight: bold; color: red">${item.time_expect }</span></li>
									
								</c:if>
								<c:if test="${item.name_progress == 'Hoàn thành' }">
									<li><span>Trạng thái: </span><span style="font-weight: bold; color: red">${item.name_progress }</span> </br>Thời gian: <span style="font-weight: bold; color: red">${item.time }</span></li>
 	    		    				<li><span style="color: red">Hóa đơn hoàn thành. Cảm ơn bạn đã đặt món tại của hàng</span> </li>
									
								</c:if>
								
							</c:forEach>
							
						</ol>
					</div>
                </div>
                <div class="col-md-5">
					<h4 style="text-align: center; color: black">Các món ăn đã chọn</h4>
	                <input type="hidden" id="id_send" value ="${sessionScope.user_id }"/>
	                <!-- <div class="col-md-2"></div> -->
	                <div class="">
		                <table class="table">
		                	<thead>
		                		<tr>
		                			<th style="text-align: center">Mã hóa đơn</th>
		                			<th style="text-align: center">Tên món ăn</th>
		                			<th style="text-align: center">Số lượng</th>
		                			<th style="text-align: center">Số tiền</th>
		                		</tr>
		                	</thead>
		                	<tbody>
				                <c:forEach items="${listtrans }" var ="item">
				                		<tr>
				                			<td style="text-align: center">${item.transaction_id }</td>
				                			<td style="text-align: center">${item.name_food }</td>
				                			<td style="text-align: center">${item.quantum }</td>
				                			<td style="text-align: center; color: red"><fmt:formatNumber> ${item.price_food } </fmt:formatNumber> đ</td>
				                		</tr>
				                </c:forEach>
			                </tbody>
		                </table>
		                <div class="total_price" style="float: right ">
		                	<div class="price"><span>Tổng tiền: </span> <span style="font-weight: bold; color: red"> <fmt:formatNumber>${transaction.price }</fmt:formatNumber>đ </span></div>
		                </div>
		                <div class="address_receive">
		                	<div class="address"><span>Địa điểm nhận: <span style="font-weight: bold"> ${transaction.address } </span></span></div> 
		                </div>
		                <div class="restaurant_info">
		                	<div class="infor_rest">Thông tin quán ăn</div>
		                	<table class="table">
		                		<tr>
		                			<td>Tên quán ăn</td>
		                			<td style="font-weight: bold">${restaurant.name_rest }</td>
		                		</tr>
		                		<tr>
		                			<td>Địa chỉ</td>
		                			<td style="font-weight: bold">${restaurant.addres_rest }</td>
		                		</tr>
		                		<tr>
		                			<td>Thời gian mở cửa</td>
		                			<td style="font-weight: bold">${restaurant.time_open }</td>
		                		</tr>
		                		
		                	</table>
		                	<input type="hidden" id="id_receive" value="${restaurant.id_user }R">
		                	<%-- <div class="name_restaurant"><span>Tên quán ăn: ${restaurant.name_rest }</span></div> 
		                	<div class = "address_restaurant"><span>Địa chỉ: ${restaurant.addres_rest }</span></div>
		                	<div class="time_open"><span>Thời gian mở cửa: ${restaurant.time_open }</span></div> --%>
		                </div>
		                <div class="thank_cus">
		                	<span>Cảm ơn quý khách đã đặt món tại quán ăn: </span><a href="/Project/nha-hang/${restaurant.id_rest }"><span style="color: blue">${restaurant.name_rest }</span></a> 
		                </div>
                </div>
            </div><!-- end col-5 -->
            <div class="col-md-4" style="border: 1px solid #f2f8f9">
            	<div class ="name-chat">Phản hồi khách hàng</div>
                   <input type="hidden" id="infor_id_transaction" value="${transaction.id_transaction }">
                   <input type="hidden" id="information_rest" value="${information_rest }">     	
	              <div class="mesgs">
	              	<div>
			          <div class="msg_history">
			            	<c:forEach items="${list_mess }" var="mess">
			            		<c:if test="${mess.check_mess == 1  }">
			            			<div class="outgoing_msg">
						              <div class="sent_msg">
						                <p>${mess.message_chat }</p>
						                <span class="time_date"> ${mess.time_chat }</span> </div>
						            </div>
			            		</c:if>
			            		<c:if test="${mess.check_mess == 2 }">
			            			<div class="incoming_msg">
						              <div class="received_msg">
						                <div class="received_withd_msg">
						                  <p>${mess.message_chat }</p>
						                  <span class="time_date"> ${mess.time_chat }</span> </div>
						              </div>
						            </div>
			            		</c:if>
			            	</c:forEach>
			           	</div> 
			           </div>
			          <div class="type_msg">
			            <div class="input_msg_write">
			              <input type="text" class="write_msg" placeholder="Bạn muốn phản hồi gì" />
			              <button class="msg_send_btn" onclick="send_mess()" type="button"><i class="fa fa-paper-plane-o" aria-hidden="true"></i></button>
			            </div>
			          </div>
			        <!-- </div> -->
	              </div>
            </div>
        </div>
    </section>
    <!-- Food Area End -->

  
    <!-- Javascript -->
    <script src="/Project/webjars/jquery/2.1.4/jquery.min.js"></script>
	<script src="/Project/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script src="/Project/resources/js/wow.min.js"></script>
    <script src="/Project/resources/js/owl-carousel.min.js"></script>
    <!-- <script src="/Project/resources/js/jquery.datetimepicker.full.min.js"></script> -->
    <script src="/Project/resources/js/jquery.nice-select.min.js"></script>
    <!-- <script src="/Project/resources/js/main.js"></script> -->
    <script type="text/javascript">
	    websocket = new WebSocket("ws://localhost:8080/Project/chatRoomServer/" + $('#id_send').val() + "/" + $('#id_receive').val());
	    console.log("ws://localhost:8080/Project/chatRoomServer/" + $('#id_send').val() + "/" + $('#id_receive').val());
	    websocket.onopen = function(message) {processOpen(message);};
	   // websocket.send("thang");
	    websocket.onmessage = function(message) {processMessage(message);};
	    websocket.onclose = function(message) {processClose(message);};
	    websocket.onerror = function(message) {processError(message);};
	    function processOpen(message) {
	        //textAreaMessage.value += "Server connect... \n";
	      }
	     function processMessage(message) {
	    	// var mes = JSON.parse(message.data);
	        console.log(message);
	        console.log("data:" + message.data);
	        check_data = message.data;
	        check_mess = check_data.substring(0,2);
	        console.log("123123: " + check_mess);
	        console.log("indexOf: " + check_mess.indexOf('me'));
	        if(check_mess == 'me'){
	        	var transaction_id = $('#infor_id_transaction').val();
	        	var array = check_data.split('|');
 	    	   	console.log('array[3]: ' + array[3]);
 	    	   	if(array[3] == transaction_id){
 	    		   $('.msg_history').append(
	   	    			 '<div class="incoming_msg">'+
				              
				              '<div class="received_msg">'+
				                '<div class="received_withd_msg">'+
				                  '<p>'+ array[2] +'</p>'+
				                  '<span class="time_date">' + array[1] + '</span>'+
				                 '</div>'+
				              '</div>'+
				            '</div>'	   
   	    	    	  );  
 	    	   	}else{
 	    		   console.log('123123');
 	    	   }
	        }else if(check_mess== "s1"){
	        	console.log('hay thuc hien');
	        	var array = check_data.split(";");
	        	$("li").last().append("</br>" + array[1]);
	        }
	        
	        else{
	        	data = message.data;
		        var array = data.split(';');
		    	 $('.progress').append(
	       			'<div  class="progress-bar '+ array[0] + '  ws_process progress-bar-striped" role="progressbar" aria-valuenow="80"'+
	       	            'aria-valuemin="0" aria-valuemax="100" style="width:'+ array[2] +'" >'+ array[1] +
	       	            '<span class="sr-only">30%</span>'+
	       	        '</div>'		
		        );
		    	 if(array[1].indexOf('Đang làm món ăn') != -1){
		    		 console.log('dang lam mon an vao day');
		    		 $('.step_id').append(
		    		    		'<li><span>Trạng thái: </span> <span style="font-weight: bold; color: red">'+ array[1] + '</span></br>Thời gian: <span style="font-weight: bold; color: red">' + array[3]  + '</span></br> Thời gian dự kiến: <span style="font-weight: bold; color: red">' + array[4] +'</span> </li>'	 
		    		    	 );
		    	 }else if(array[1].indexOf('Đang giao hàng') != -1){
		    		 $('.step_id').append(
		    		    		'<li><span>Trạng thái: </span> <span style="font-weight: bold; color: red">'+ array[1] + '</span></br>Thời gian: <span style="font-weight: bold; color: red">' + array[3]  + '</span></br> Khoảng cách: <span style="font-weight: bold; color: red">' + array[4] + '</span></br> Thời gian dự kiến: <span style="font-weight: bold; color: red">' + array[5] + '</span> </li>'	 
		    		    	 );
		    	 }else if(array[1].indexOf('Hoàn thành') != -1){
		    		 $('.step_id').append(
		    		    		'<li><span>Trạng thái: </span> <span style="font-weight: bold; color: red">'+ array[1] + '</span></br>Thời gian: <span style="font-weight: bold; color: red">' + array[3]  + '</span> </li>' + 
	 	    		    		'<li><span style="font-weight: bold; color: red">Trạng thái: Hóa đơn hoàn thành. Cảm ơn bạn đã đặt món tại của hàng</span> </li>'
		    		    	 );
		    	 }else{
		    		 console.log('dang lam mon an khong vao day');
		    	 }
		    	 
		    	 $('.color_noti').css("color", "red");
		    	 $('.notify').append(
		    			 '<a href="/Project/hoa-don"><div><i class="fa fa-comment fa-fw ">'+array[1] + '</i></div></a>' 
		    			 );
	        }
	        
	      }
	     function processClose(message) {
	       // textAreaMessage.value += "Server Disconnect... \n";
	      }
	     function processError(message) {
	       // textAreaMessage.value += "Error... " + message +" \n";
	      }
	     var param1 = new Date();
         var param2 =  param1.getDate() + '/' + (param1.getMonth() + 1) + '/' + param1.getFullYear() + ' ' + param1.getHours() + ':' + param1.getMinutes() + ':' + param1.getSeconds();
	     function send_mess(){
	    	 //1.1 declare method message, send message to server
	    	 var  message = 'message|';
	    	 //1.2 add value time in message
	    	 var  time = param2;
	    	 message += time + '|';
	    	 //1.3 add value message content in message 
	    	 var message_content = $('.write_msg').val();
	    	 message += message_content + '|';
	    	 //1.4 add id_transaction
	    	 var message_id_transaction = $('#infor_id_transaction').val();
	    	 message += message_id_transaction +"|";
	    	 
	    	 websocket.send(message);
	    	 //1.5 set value insert in table chat_progress
	    	 //1.5.1 create value json 
	    	 var json = JSON.stringify({"id_chat" : $('#infor_id_transaction').val(),
     	        "message_chat" : message_content,
    	        "count_mess": "0",
    	        "time_chat": time,
    	        "check_mess" : "1"
    	        
    			});
	    	 //1.5.2 insert data using ajax to controller
	    	 $.ajax({
	    		url: '/Project/insertchat',
	    		type: 'post',
	    		data:{data_mess: json},
	    		success: function(result){
	    	  		console.log("working ajax");
    				
    			}
	    	 });
	    	 
	    	 //1.5.3 show mess
	    	 $('.msg_history').append(
	    			 '<div class="outgoing_msg">'+
			              
			                '<div class="sent_msg">'+
			                  '<p>'+ message_content +'</p>'+
			                  '<span class="time_date">' + time + '</span>'+
			                 '</div>'+
			              '</div>'+
			            '</div>'	   
	    	  );
	    	 $('.write_msg').val("");
	     }
	     
	     
    </script>
</body>

</html>