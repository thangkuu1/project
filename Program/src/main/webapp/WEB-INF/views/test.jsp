<!DOCTYPE html>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<title>Demo websocket</title>
<link rel="stylesheet" href="/Project/resources/css/animate-3.7.0.css">
    <link rel="stylesheet" href="/Project/webjars/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="/Project/webjars/jquery/2.1.4/jquery.min.js"></script>
    <link href="/Project/webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/Project/webjars/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>  
    <h1>Demo WebSocket</h1>
    Send: <input type="text" id="id_send" name="port"/>
    Receive:<input type="text" id="id_receive" name="port"/>
    <button onclick ="connect()">connect</button>
    <input id="textMessage" type="text" />
    <div class="ws"></div>
    <input onclick="sendMessage()" value="Send Message" type="button" /> <br/><br/>
    <div class="progress" id="test">
        <div  class="progress-bar progress-bar-danger ws_process" role="progressbar" aria-valuenow="80"
            aria-valuemin="0" aria-valuemax="100" style="width: 20%" >
            <span class="sr-only">80%</span>
        </div>
     </div>
     <div class="progress">
         <div id="test2" class="progress-bar progress-bar-danger ws_process" role="progressbar" aria-valuenow="80"
             aria-valuemin="0" aria-valuemax="100" style="width: 80%" >
             <span class="sr-only">80%</span>
         </div>
     </div>
    <textarea id="textAreaMessage" rows="10" cols="50"></textarea>
    <script type="text/javascript">
    var websocket;
    
    /* if(test == test1){
    	console.log('vao day');
    	$(test2).html("123123");
    	$(test2).width(message.data);
    } */
    console.log(test);
    function connect(){
    	websocket = new WebSocket("ws://localhost:8080/Project/chatRoomServer/" + id_send.value + "/" + id_receive.value);
        websocket.onopen = function(message) {processOpen(message);};
       // websocket.send("thang");
        websocket.onmessage = function(message) {processMessage(message);};
        websocket.onclose = function(message) {processClose(message);};
        websocket.onerror = function(message) {processError(message);};
    }
      	
      function processOpen(message) {
        textAreaMessage.value += "Server connect... \n";
      }
      function processMessage(message) {
        
        textAreaMessage.value += message.data + " \n";
       // $('.ws_process').width(message.data);
       // $('.sr-only').html(message.data.content);
        /*
        console.log(message.data)
         
        console.log(mes.id);
        var test = $('.progress').attr('id');
        var test1 = mes.id;
        var test2 = '#test';
        if(test == test1){
        	console.log('vao day');
        	//$(test2).html(message.data.content);
        	//$(test2).width(message.data);
        	$(test2).append(
        			'<div  class="progress-bar '+ mes.progress + '  ws_process" role="progressbar" aria-valuenow="80"'+
        	            'aria-valuemin="0" aria-valuemax="100" style="width:'+ mes.width +'" >'+ mes.name_progress +
        	            '<span class="sr-only">30%</span>'+
        	        '</div>'		
        	);
        }else{
        	console.log('loi o day');
        }*/
      }
      function processClose(message) {
        textAreaMessage.value += "Server Disconnect... \n";
      }
      function processError(message) {
        textAreaMessage.value += "Error... " + message +" \n";
      }
      function sendMessage() {
        if (typeof websocket != 'undefined' && websocket.readyState == WebSocket.OPEN) {
        	var  json =JSON.stringify({"id_progress" : "21",
        	        "progress" : "progress-bar-success",
        	        "name_progress": "Đang thực hiện",
        	        "width" : "30%",
        	        "step_progress": "1"
        	});
          websocket.send("texxt");
         //websocket.send("thang");
         
          textMessage.value = "";
        }
      }
    </script>
</body>
</html>