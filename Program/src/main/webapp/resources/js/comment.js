var data = '';
var error_cmt = true;
$(document).ready(function() {
	load_cmt();
	console.log("owiejrowierjowijr");
	
	
//	$('#cmt_mess').hide();
	$('#content-cmt').focusout(function(){
		console.log("vao dya cmt");
		check_cmt();
	});
	
});

function check_cmt(){
	var content_cmt = $('#content-cmt').val();
	if(content_cmt.indexOf('<') != -1){
		console.log("loi o dya");
		$('#cmt_mess').html("Chứa ký tự đặc biệt vui lòng không điền dạng '<' alert>");
		$('#dmt_mess').show();
		error_cmt = true;
	}
	else if(content_cmt.length == 0 ){
		$('#cmt_mess').html("Vui lòng không nhập comment rỗng");
		$('#dmt_mess').show();
		error_cmt = true;
	}else{
		$('#cmt_mess').hide();
		error_cmt = false;
	}
}

btnComment = function() {
	if(error_cmt == false){
		$.ajax({
			url:'/Project/comment',
			type: 'post',
			data: {content_cmt: $('#content-cmt').val(), id_rest: $('#id-rest').val() },
			success: function(result) {
				data = result.data;
				$('.comment_rest').remove();
				for(var i = data.length - 1; i >= 0 ; i--){
					var id_comment = data[i].id_cmt;
					var content_cmt = data[i].content_cmt;
					var date = data[i].date;
					var id_food = data[i].id_food;
					var id_user = data[i].id_user;
					var image_user = data[i].image_user;
					var username = data[i].username;
					$(".comment-list").append(
							'<li class="media comment_rest" >'+
	                        '<a href="#" class="pull-left">'+
	                            '<img src="/Project/image/' +image_user + '" alt="" class="img-circle" style="with:10px; height:60px" >'
	                        + '</a>'
	                        + '<div class="media-body"> '
	                        +    '<span class="text-muted pull-right">'
	                        + '       <small class="text-muted">'+ date + '</small>'
	                        +'    </span>'
	                        +'    <strong class="text-success">'+username +'</strong>'
	                        + '    <p>'
	                        +	content_cmt
	                        +'    </p>'
	                        +'</div>'
	                        +'</li>'
					);
				}
				$('#content-cmt').val(' ');
				console.log(data);
			}
		});
	}
}

load_cmt = function() {
	$.ajax({
		url:'/Project/loadcomment',
		type:'GET',
		data: { id_rest: $('#id-rest').val()},
		success: function(result) {
			data = result.data;
			//$('.comment').remove();
			for(var i = data.length - 1; i >= 0 ; i--){
				var id_comment = data[i].id_cmt;
				var content_cmt = data[i].content_cmt;
				var date = data[i].date;
				var id_food = data[i].id_food;
				var id_user = data[i].id_user;
				var image_user = data[i].image_user;
				var username = data[i].username;
				$(".comment-list").append(
						'<li class="media comment_rest" >'+
                        '<a href="#" class="pull-left">'+
                            '<img src="/Project/image/' +image_user + '" alt="" class="img-circle" style="with:10px; height:60px" >'
                        + '</a>'
                        + '<div class="media-body"> '
                        +    '<span class="text-muted pull-right">'
                        + '       <small class="text-muted">'+ date + '</small>'
                        +'    </span>'
                        +'    <strong class="text-success">'+username +'</strong>'
                        + '    <p>'
                        +	content_cmt
                        +'    </p>'
                        +'</div>'
                        +'</li>'
				);
			}
		}
	});
	
	
	
}