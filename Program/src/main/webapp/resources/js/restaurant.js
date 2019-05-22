var data = '';
$(document).ready(function() {
	load();
	console.log("owiejrowierjowijr");
});

load = function() {
	$.ajax({
		url: '/Project/nha-hang/load-order',
		get: 'post',
		
		success: function(result) {
			data = result.data;
			console.log(data);
			$('.food-order').remove();
			var total_price_order = 0;
			const formatter = new Intl.NumberFormat('en-US', {
				  style: 'currency',
				  currency: 'VND',
				  minimumFractionDigits: 2
				})
			if(data.length == 0){
				total_price_order = 0;				
			}else{
				for(var j = 0; j < data.length; j++){
    				
    				total_price_order += data[j].price * data[j].count_food;
    			}
			}
			
			formatter.format(total_price_order);
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
			 
//			 $('.price1').remove();
//			 $('.price-order').append('<div class="price1">' + total_price_order + '</div>');
		}
		
	});
}

Order = function() {
	
    	  if (typeof websocket != 'undefined' && websocket.readyState == WebSocket.OPEN) {
              websocket.send("Đặt hàng");
             //websocket.send("thang");
//              textMessage.value = "";
            }
    	  var currentDate = new Date();

    	  var param1 = new Date();
          var param2 = param1.getDate() + '/' + (param1.getMonth() + 1) + '/' + param1.getFullYear() + ' ' + param1.getHours() + ':' + param1.getMinutes() + ':' + param1.getSeconds();
    	  var  json =JSON.stringify({"id_progress" : "0",
  	        "progress" : "progress-bar-danger",
  	        "name_progress": "Đang chờ",
  	        "width" : "25%",
  	        "step_progress": "1",
  	        "time" : param2,
  	        "distance"  : "0"
    	  });
	
	
	$.ajax({
		url:'/Project/transaction',
		type: 'post',
		data: {address: $('#address').val(), data_progress: json},
		success: function(result){
			$('#address').val('');
			window.location.href = '/Project/hoa-don'; 
		}
	});
}

updateOrder = function(i){
	console.log("value id food in updateOrder: " + i);
	$.ajax({
		url: '/Project/order-update',
		type: 'post',
		data:{id_food: i},
		success: function(result){
			data = result.data1;
			console.log( data);
			var total_price_order = 0;
			for(var i = 0; i < data.length; i++){
				total_price_order += data[i].price * data[i].count_food;
			}
			console.log("price:" + total_price_order );
			const formatter = new Intl.NumberFormat('en-US', {
				  style: 'currency',
				  currency: 'VND',
				  minimumFractionDigits: 2
				})
			$('.price-order').remove();
			$('.order-panel').append(
					 '<div class="price-order" style="padding-top:10px">'
						+'<span> Giá tiền: </span>'
						+'<span style="float:right ;color:red" >'+ formatter.format(total_price_order) + '</span>'
						+'</div>'
			 );
		}
	});
	
	
}


updateSubOrder = function(i){
	$.ajax({
		url: '/Project/order-update-sub',
		type: 'post',
		data:{id_food: i},
		success: function(result){
			data = result.data1;
			console.log( data);
			var total_price_order = 0;
			if(data.length < 1){
				total_price_order = 0;
				$('.number-spinner').remove();
				const formatter = new Intl.NumberFormat('en-US', {
				  style: 'currency',
				  currency: 'VND',
				  minimumFractionDigits: 2
				})
			$('.price-order').remove();
			$('.order-panel').append(
					 '<div class="price-order" style="padding-top:10px">'
						+'<span> Giá tiền: </span>'
						+'<span style="float:right ;color:red" >'+ formatter.format(total_price_order) + '</span>'
						+'</div>'
			 );
			}else{
				$('.number-spinner').remove();

				$('.price-order').remove();
				for(var i = 0; i < data.length; i++){
					total_price_order += data[i].price * data[i].count_food;
				}

				load();
			}
			console.log("price:" + total_price_order );
//			const formatter = new Intl.NumberFormat('en-US', {
//				  style: 'currency',
//				  currency: 'VND',
//				  minimumFractionDigits: 2
//				})
//			$('.price-order').remove();
//			$('.order-panel').append(
//					 '<div class="price-order" style="padding-top:10px">'
//						+'<span> Giá tiền: </span>'
//						+'<span style="float:right ;color:red" >'+ formatter.format(total_price_order) + '</span>'
//						+'</div>'
//			 );
		}
	});
	
}