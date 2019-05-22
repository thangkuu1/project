<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Chi tiết hóa đơn</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link href="/Project/resources/css/admin/bootstrap.min.css" rel="stylesheet">
<link href="/Project/resources/css/admin/metisMenu.min.css" rel="stylesheet">
<link href="/Project/resources/css/admin/startmin.css" rel="stylesheet">
<link href="/Project/resources/css/admin/morris.css" rel="stylesheet">
<link href="/Project/resources/css/admin/dataTables/dataTables.bootstrap.css" rel="stylesheet">
<link href="/Project/resources/css/admin/dataTables/dataTables.responsive.css" rel="stylesheet">
<link href="/Project/resources/css/admin/transaction_detail.css" rel="stylesheet">
<!-- <link href="resources/css/admin/font-awesome.min.css" rel="stylesheet" type="text/css"> -->
<!-- <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"> -->
<link href="/Project/webjars/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<script src="/Project/resources/js/admin/jquery.min.js"></script>
<script src="https://apis.google.com/js/api.js" type="text/javascript"></script>


</head>
<body>
	<div id="wrapper">

    <!-- Navigation -->
    <%@include file="nav_admin.jsp" %>

    <div id="page-wrapper">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">Chi tiết hóa đơn</h1>
                        </div>
                        <!-- /.col-lg-12 -->
                    </div>
                    <!-- /.row -->
                    <div class="row">
                        <div class="col-lg-8">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    Đơn hàng
                                </div>
                                <!-- /.panel-heading -->
                                <div class="panel-body">
                                	<div style="width: 350px; margin:auto">
                                		<table class="table table-striped table-bordered table-hover" id="dataTables-example">
				                               
				                               <tbody>
				                               		<tr >
				                               			<td style="">Tên khách hàng:</td>
				                               			<td style="text-align: center">${user_trans.username }</td>
				                               			
				                               		</tr>       
				                               		<tr>
				                               			<td style="">Số điện thoại:</td>
				                               			<td style="text-align: center">${user_trans.phone }</td>
				                               		</tr>      
				                               		<tr>
				                               			<td style="">Địa chỉ nhận:</td>
				                               			<td style="text-align: center" id="address">${address_trans }</td>
				                               		</tr> 
				                               </tbody>
				                           </table>
                                	</div>
                                    <div class="table-responsive">
                                        <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                            <thead>
                                                <tr >
                                                    <th style="text-align: center">Mã</th>
                                                    <th style="text-align: center">Món ăn</th>
                                                    <th style="text-align: center">Số lượng</th>
                                                    <th style="text-align: center">Tiến trình</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                            	<c:forEach items="${LIST_TRANSACTION_DETAIL }" var="item">
                                            		<tr class="odd gradeX">
                                            			<td style="text-align: center" id="transaction_id">${item.transaction_id }</td>
                                            			<td style="text-align: center" id="name_food">${item.name_food }</td>
                                            			<td style="text-align: center"><fmt:formatNumber>${item.quantum }</fmt:formatNumber> </td>
                                            			<td style="text-align: center">
                                            				<c:if test="${item.trans_stat == 0 && status_trans.equals('Đặt hàng')}">
                                            					<button type="button" id="doing1" class="btn btn-success" disabled onclick="Doing(${item.id_food },${item.name_food })">Đang làm món ăn</button>
                                            				</c:if>
                                            				<c:if test="${item.trans_stat == 0 && !status_trans.equals('Đặt hàng')}">
                                            					<button type="button" id="doing1" class="btn btn-success" onclick="Doing(${item.id_food },'${item.name_food }')">Đang làm món ăn</button>
                                            				</c:if>
                                            				<c:if test="${item.trans_stat == 1 }">
                                            					<button type="button" id="doing1" class="btn btn-success" disabled onclick="">Đang làm món ăn</button>
                                            				</c:if>
                                            				
                                            			</td>
                                            		</tr>
                                            	</c:forEach>                          
                                            </tbody>
                                        </table>
                                        <div style="text-align: center">
                                        	<button type="button" id="working" class="btn btn-success" onclick="Working()">Đang làm </button>
                                        	<button type="button" id="shipping" class="btn btn-success" onclick="Ship()">Đang giao hàng</button>
                                        	<button type="button" id="success" class="btn btn-success" onclick="Success()">Thành công</button>
                                        	<a href="/Project/admin/exportBill"  target="_blank"><button type="button" id="" class="btn btn-success" ">In hoá đơn</button></a>
                                        	<button type="button" id="cancel" class="btn btn-danger" onclick="Cancel()">Hủy đơn hàng</button>
                                        	<input type="hidden" id="id_receive" value =${sessionScope.id_receive}/>
                                        	<input type="hidden" id="id_send" value =${sessionScope.user_id_rest}/>
                                        	<input type="hidden" id="trans_stat" value = "${status_trans }"/>
                                        	<input type="hidden" id="distance" value = ""/>
                                        	<input type="hidden" id="time_ship" value = ""/>
                                        	<input type="hidden" id="address_rest" value="${address_rest }">
                                        </div>
                                    </div>
                                    <!-- /.table-responsive -->
                                   
                                </div>
                                <!-- /.panel-body -->
                            </div>
                            <!-- /.panel -->
                        </div>
                        <!-- /.col-lg-8 -->
                        <div class="col-lg-4" style="border: 1px solid #f2f8f9">
                        	<div class ="name-chat">Phản hồi khách hàng</div>
                        	
                        	<div class="mesgs">
					          <div class="msg_history"> 
					          	<c:forEach items="${list_mess }" var="mess">
				            		<c:if test="${mess.check_mess == 2  }">
				            			<div class="outgoing_msg">
							              <div class="sent_msg">
							                <p>${mess.message_chat }</p>
							                <span class="time_date"> ${mess.time_chat }</span> </div>
							            </div>
				            		</c:if>
				            		<c:if test="${mess.check_mess == 1 }">
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
                    <!--end-row-->
                    
                </div>
                <!-- /.container-fluid -->
            </div>
            <!-- /#page-wrapper -->

</div>
	
	<script src="/Project/resources/js/admin/jquery.min.js"></script>
	<script src="/Project/resources/js/admin/bootstrap.min.js"></script>
	<script src="/Project/resources/js/admin/metisMenu.min.js"></script>
	<script src="/Project/resources/js/admin/dataTables/jquery.dataTables.min.js"></script>
	<script src="/Project/resources/js/admin/dataTables/dataTables.bootstrap.min.js"></script>
	<script src="/Project/resources/js/admin/startmin.js"></script>
	<script type="text/javascript">
            $(document).ready(function() {
                /* $('#dataTables-example').DataTable({
                        responsive: true
                }); */
            	   console.log("sdfsdf");
            	 //1,1: get distance in 2 place using google map api
            	  	var end = $('#address').text();
            	  	console.log('end: ' + end);
            	 
            	    var start = $('#address_rest').val();
            	    console.log('start: ' + start);
            	    $.ajax({
            			
            			//url: 'https://maps.googleapis.com/maps/api/distancematrix/json?origins='+start +'&destinations=' + end +'&departure_time=now&key=AIzaSyBBfOsyFLL66XcGm6vH5ZTPobC15E76Now&fbclid=IwAR2_awBKuNM_Pcbp_y-XpaSaAv8mSc2lOjqTjVDkPExZtNZWd0fpV0tTjpc',
            			url: 'https://maps.googleapis.com/maps/api/distancematrix/json?origins='+start +'&destinations=' + end +'&key=AIzaSyBBfOsyFLL66XcGm6vH5ZTPobC15E76Now&fbclid=IwAR0N3Tadv_KjCCH534TEu0dZVeFwVC9YdNdcBMTp7pwgfaCnHJUEPKrRlC8',
            			get: 'post',
            			//dataType: 'jsonp',
            	        //cache: false,
            	        contentType: 'application/x-www-form-urlencoded',
            			success: function(result) {
            				console.log(result);
            				console.log(result.rows[0].elements[0].distance.text);
            				//$('#dist').val(result.rows[0].elements[0].distance.text);
            				distance = result.rows[0].elements[0].distance.text;
            				time_ship = result.rows[0].elements[0].duration.text;
            				console.log(distance);
            				$('#distance').val(distance);
            				$('#time_ship').val(time_ship);
            			}
            		  });  
       	  	      
                 });
            //websocket = new WebSocket("ws://localhost:8080/Project/chatRoomServer/" + $('#id_send').val().replace("/", "") +"/" + $('#id_receive').val().replace("/", ""));
            websocket = new WebSocket("ws://localhost:8080/Project/chatRoomServer/" + $('#id_send').val() + $('#id_receive').val());
            console.log("ws://localhost:8080/Project/chatRoomServer/" + $('#id_send').val() + $('#id_receive').val());
            websocket.onopen = function(message) {processOpen(message);};
           // websocket.send("thang");
            websocket.onmessage = function(message) {processMessage(message);};
            websocket.onclose = function(message) {processClose(message);};
            websocket.onerror = function(message) {processError(message);};
            function processOpen(message) {
    	        //textAreaMessage.value += "Server connect... \n";
    	      }
    	      function processMessage(message) {
    	        console.log(message);
    	       // var data = message.data.split(",");
    	        
    	       // textAreaMessage.value += message.data + " \n";
    	       var data = message.data;
    	       var check_mess = data.substring(0,2);
    	       console.log("cjesd: " + check_mess);
    	       var array_chat = data.split("|");
    	       console.log('indexOf: ' +check_mess.indexOf('me'));
    	       if(check_mess == 'me'){
    	    	   console.log($('#transaction_id').text());
    	    	   var transaction_id = $('#transaction_id').text();
    	    	   var array = data.split('|');
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
    	    		   $('.color_noti').css("color", "red");
    			    	$('.notify').append(
   			    			 '<a href="/Project/hoa-don/100"><div><i class="fa fa-comment fa-fw ">Tin nhắn mới</i></div></a>' 
    			    			 );
    	    	   }else{
    	    		   console.log('123123');
    	    	   }
    	    	   
    	       }else{
    	    	   console.log('vao day');
    	       }
    	       console.log('data: ' + data);
    	       
    	      }
    	      function processClose(message) {
    	       // textAreaMessage.value += "Server Disconnect... \n";
    	      }
    	      function processError(message) {
    	       // textAreaMessage.value += "Error... " + message +" \n";
    	      }
    	      var param1 = new Date();
              var param2 =  param1.getDate() + '/' + (param1.getMonth() + 1) + '/' + param1.getFullYear() + ' ' + param1.getHours() + ':' + param1.getMinutes() + ':' + param1.getSeconds();
    	      function Working(){
    	    	
      	          console.log("value o day: " + $('#distance').val());
    	    	  //1.1 send data ussing websocket
    	    	  if (typeof websocket != 'undefined' && websocket.readyState == WebSocket.OPEN) {
    	              //websocket.send("Đang làm món ăn"); 
    	              var  json3 =JSON.stringify({"id_progress" : $('#transaction_id').text(),
    	        	        "progress" : "progress-bar-info",
    	        	        "name_progress": "Đang làm món ăn",
    	        	        "width" : "25%",
    	        	        "step_progress": "1",
    	        	        "time" : param2,
    	        	        "distance" : " ",
    	        	        "time_expect": '10p'
    	        	});
    	          websocket.send('progress-bar-info;Đang làm món ăn;25%;' + param2 + ';10p');
    	          console.log(json3);
    	          
    	          //insert data to table progress using ajax
    	          $.ajax({
    	         	 url: '/Project/saveProgress',
    	         	 type: 'post',
    	         	 data : {data: json3},
		    	  	success: function(result){
		    	  		console.log("working ajax");
	    				window.location.href = '/Project/admin/transaction'; 
	    			}
    	          });
    	         }
    	      }
    	      var distance = '';
    	      function Ship(){
    	    	  
    	      	  //1.2 send data using websocket
    	    	  if (typeof websocket != 'undefined' && websocket.readyState == WebSocket.OPEN) {
    	    		  var  json1 =JSON.stringify({"id_progress" : $('#transaction_id').text(),
  	        	        "progress" : "progress-bar-warning",
  	        	        "name_progress": "Đang giao hàng",
  	        	        "width" : "25%",
  	        	        "step_progress": "2",
  	        	        "time" : param2,
  	        	        "distance": $('#distance').val(),
  	        	        "time_expect": $('#time_ship').val()
  	        			});
    	    	  }
  	         	 websocket.send('progress-bar-warning;Đang giao hàng;25%;' + param2 + ';' + $('#distance').val() + ';' + $('#time_ship').val());
  	          	//1.3: insert data in table Progress
	  	        $.ajax({
	  	        	 url: '/Project/saveProgress',
	  	        	 type: 'post',
	  	        	 data : {data: json1},
	  	        	 
	  	        	 success: function(result){
	  	        		 console.log("ship ajax");
	    			 window.location.href = '/Project/admin/transaction'; 
	    			}
	  	         });
    	            
    	      }
    	      function Success(){
    	    	  //1.1: send data using websocket
    	    	  if (typeof websocket != 'undefined' && websocket.readyState == WebSocket.OPEN) {
    	    		  var  json2 =JSON.stringify({"id_progress" :  $('#transaction_id').text() ,
    	        	        "progress" : "progress-bar-success",
    	        	        "name_progress": "Hoàn thành",
    	        	        "width" : "25%",
    	        	        "step_progress": "3",
    	        	        "time" : param2
    	        	});
    	          websocket.send('progress-bar-success;Hoàn thành;25%;' + param2);
    	          //1.2: insert in table progress using ajax
    	          $.ajax({
    	         	 url: '/Project/saveProgress',
    	         	 type: 'post',
    	         	 data : {data: json2},
    	         	success: function(result){
    	         		console.log('success ajax');
	    				window.location.href = '/Project/admin/transaction'; 
	    			}
    	          });
    	         }
    	      }
    	      
    	      function Cancel(){
    	    	 //1.1 update trans_stat in table progress
    	          $.ajax({
    	         	 url: '/Project/admin/cancelBill',
    	         	 type: 'post',
    	         	 data : {data:  $('#transaction_id').text()},
    	         	success: function(result){
	    				window.location.href = '/Project/admin/transaction'; 
	    			}
    	          });
    	            
    	      }
    	      
    	      //function doing(id)
    	      function Doing(id_food,name_food) {
				console.log("vao day roi");
				console.log("name food:" + name_food);
				$.ajax({
					url: '/Project/admin/Transaction/updateTransactionDetail',
					type: 'post',
					data: {transaction_id: $('#transaction_id').text(), id_food: id_food, name_food: name_food},
					success: function(result){
	    				window.location.href = '/Project/admin/transaction'; 
	    			}
				});
				websocket.send('s1;' + name_food +" Đang làm");
			}
    	      
    	      //function send message chat
    	      
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
		    	 var message_id_transaction = $('#transaction_id').text();
		    	 message += message_id_transaction +"|";
		    	 
		    	 websocket.send(message);
		    	 //1.5 set value insert in table chat_progress
		    	 //1.5.1 create value json 
		    	 var json = JSON.stringify({"id_chat" : $('#transaction_id').text(),
	     	        "message_chat" : message_content,
	    	        "count_mess": "0",
	    	        "time_chat": time,
	    	        "check_mess" : "2"
	    	        
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
		    	 
		    	 //1.5.3 show message user send
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
    	      
    	      var trans_stat = $('#trans_stat').val();
    	      console.log(trans_stat);
    	      if(trans_stat == 'Đặt hàng'){
    	    	  $('#shipping').attr("disabled", true);
    	    	  $('#success').attr("disabled", true);
    	    	 // $('#doing1').attr("disabled", true);
    	    	       	    	      	    	  
    	      }
    	      if(trans_stat == 'Đang làm món ăn'){
    	    	$('#working').attr("disabled", true);
    	    	$('#success').attr("disabled", true);
    	    	//$('#doing').attr("disabled", false);
    	      }
    	      
    	      if(trans_stat == 'Đang giao hàng'){
    	    	  $('#working').attr("disabled", true);
    	    	  $('#shipping').attr("disabled", true);
    	      }
    	      if(trans_stat == 'Hoàn thành'){
    	    	  $('#working').attr("disabled", true);
    	    	  $('#shipping').attr("disabled", true);
    	    	  $('#success').attr("disabled", true);
    	      }
    	      if(trans_stat == 'Hủy đơn'){
    	    	  $('#working').attr("disabled", true);
    	    	  $('#shipping').attr("disabled", true);
    	    	  $('#success').attr("disabled", true);
    	    	  $('#cancel').attr("disabled", true);
    	      }
    	      
    	      
    	      
        </script>
</body>
</html>