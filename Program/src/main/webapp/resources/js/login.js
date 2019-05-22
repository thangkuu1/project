checkLogin = function(){
	$.ajax({
		url: "/Project/login",
		type: "post",
		data:{usename: $("#usename").val(), password: $("#password").val()},
		success: function(respone){
			var status = respone.status;
			if(status == 1){
				console.log("thanh cong");
				
				alert("thanhcong");
			}
			else{
				console.log("fail coming to");
				alert("that bai");
			}
		}
	});
}