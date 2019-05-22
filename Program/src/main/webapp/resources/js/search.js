$(document).ready(function() {
	console.log('test search');
      	/*$(function() {
      		$("#search").keyup(function () {
      			alert('th');	
      			console.log('asdasd');
      			
      		});
      	});*/
	$("#search").keyup(function () {
		$.ajax({
			type: "POST",
			url: "/Project/search",
			data:{key: $("#search").val()},
			beforeSend: function(){
				$("#search").css("background","#FFF/*  url(/Project/resources/img/loadIcon.gif) */ no-repeat 165px","width:10px;");
			},
			success: function(data){
				var data = data.list_rest;
				if($("#search").val().length == 0){
					data = null;
				}
				
//				$("#search-box").show();
				$(".search_div").remove();
				console.log(data);
				for(var i = 0; i < data.length; i++){
					var id_rest = data[i].id_rest;
					console.log("id_rest: " + id_rest);
					var name_rest = data[i].name_rest;
					var img = data[i].image_rest;
					$("#search-box").append('<div class="search_div" style="border: 1px solid #c4bb53">' +'<a href="/Project/nha-hang/'+id_rest+'">'+   '<img class ="hinh_anh" src="/Project/image/'+img+'" style="width:40px; height:40px; padding-top:3px; padding-bottom:3px"/>' +'<span>'  +name_rest  + '</span>' + '</a>'+ '</div>');
				}
				//$("#search-box").html(data);
				//$("#search-box").css("background","#FFF");
			}
			});
			
		});
      });