var data = '';
$(document).ready(function() {
	load();
	console.log("owiejrowierjowijr");
});

btnComment = function() {
	$.ajax({
		url:'/Project/comment',
		type: 'post',
		data: {content_cmt: $('#content-cmt').val(), id_food: $('#id-food').val() },
		success: function(result) {
			data = result.data;
			$(".media").remove();
			for(var i = 0; i < data.length ; i++){
				var id_comment = data[i].id_cmt;
				var content_cmt = data[i].content_cmt;
				var date = data[i].date;
				var id_food = data[i].id_food;
				var id_user = data[i].id_user;
				var image_user = data[i].image_user;
				var username = data[i].username;
				$(".media-list").append(
						'<li class="media">'+
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
			console.log(data);
		}
	});
}

load = function() {
	$.ajax({
		url:'/Project/loadcomment',
		type:'GET',
		success: function(result) {
			data = result.data;
			for(var i = 0; i < data.length ; i++){
				var id_comment = data[i].id_cmt;
				var content_cmt = data[i].content_cmt;
				var date = data[i].date;
				var id_food = data[i].id_food;
				var id_user = data[i].id_user;
				var image_user = data[i].image_user;
				var username = data[i].username;
				$(".media-list").append(
						'<li class="media">'+
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