<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Thêm món ăn</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link href="/Project/resources/css/admin/bootstrap.min.css" rel="stylesheet">
<link href="/Project/resources/css/admin/metisMenu.min.css" rel="stylesheet">
<link href="/Project/resources/css/admin/timeline.css" rel="stylesheet">
<link href="/Project/resources/css/admin/startmin.css" rel="stylesheet">
<link href="/Project/resources/css/admin/morris.css" rel="stylesheet">

<!-- cdn -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/metisMenu/3.0.4/metisMenu.css" rel="stylesheet">
<!-- <link href="resources/css/admin/font-awesome.min.css" rel="stylesheet" type="text/css"> -->
<!-- <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"> -->
<link href="/Project/webjars/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
	<div id="wrapper">

    <!-- Navigation -->
    <%@include file="nav_admin.jsp" %>

    <!-- Page Content -->
    <div id="page-wrapper">
        <div class="container-fluid">

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Thêm món ăn</h1>
                </div>
            </div>
			<div class="row">
			    <div class="col-lg-12">
			        <div class="panel panel-default">
			            <div class="panel-heading">
			                
			            </div>
			            <div class="panel-body">
			                <div class="row">
			                    <div class="col-lg-8">
			                        <form:form role="form" action ="/Project/admin/saveFood" enctype="multipart/form-data" method = "post" id="check-form"><!-- action="/Project/admin/saveFood"  -->
			                            <div class="form-group"  >
			                                <label>Tên món ăn:</label>
			                                <form:input type="text" id = "name_food" path="name_food" class="form-control" placeholder="Nhập tên món ăn"/>
			                                <span class="error_form" id="name_food_mess" style="color: red"></span>
			                            </div>
			                            
			                            <div class="form-group">
			                                <label>Giá</label>
			                                <form:input type="text" id="price_food" path="id_price" class="form-control" placeholder="Nhập giá" />
			                                <span class="error_form" id="price_food_mess" style="color: red"></span>
			                            </div>
			                            <div class="form-group">
			                                <label>Giảm giá</label>
			                                <form:input type="text" id="discount_food" path="id_discount" class="form-control" placeholder="Nhập % giảm giả"/>
			                                <span class="error_form" id="discount_food_mess" style="color: red"></span>
			                            </div>
			                            <div class="form-group">
			                                <label>Thời gian hoàn thành món ăn</label>
			                                <form:input type="text" id="time_work" path="time_work" class="form-control" placeholder="Nhập thời gian dự kiến hoàn thành món "/>
			                                <span class="error_form" id="" style="color: red"></span>
			                            </div>
			                            <div class="form-group">
			                                <label>Ảnh món ăn</label>
			                                <span class="error_form" id="img_mess" style="color: red"></span>
			                                <input type="file" name="file" id="fileToUpload" multiple onchange="readURL(this)">  <!-- onchange="readURL(this)" -->
			                            </div>
			                            <input type="submit" id= "saveFood"  value="Lưu món ăn" class="btn btn-primary disabled"/>
			                        </form:form>
			                    </div>
			                    
			                    <div class="col-lg-4">
			                     </div>
			                    	<img id="blah" src="" alt="" style="padding-top:30%" />
			                    </div>
			                    
			                </div>
			                <!-- /.row (nested) -->
			            </div>
			            <!-- /.panel-body -->
			        </div>
			        <!-- /.panel -->
			    </div>
			    <!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->

        </div>
    </div>


	
	<script src="/Project/resources/js/admin/jquery.min.js"></script>
	<script src="/Project/resources/js/admin/bootstrap.min.js"></script>
	<script src="/Project/resources/js/admin/metisMenu.min.js"></script>
	<script src="/Project/resources/js/admin/startmin.js"></script>
	<script type="text/javascript">
		function readURL(input) {
	        if (input.files && input.files[0]) {
	            var reader = new FileReader();
	
	            reader.onload = function (e) {
	                $('#blah')
	                    .attr('src', e.target.result)
	                    .width(250)
	                    .height(250);
	            };
				console.log("qwoeqe");
	            reader.readAsDataURL(input.files[0]);
	        }
	    }
		
		$(function(){
			var error_name = false;
			var error_price = false;
			var error_discount = false;
			var error_img = false;
			$('#name_food_mess').hide();
			$('#price_food_mess').hide();
			$('#discount_food_mess').hide();
			$('#img_mess').hide();
			
			$('#name_food').focusout(function(){
				$('#saveFood').removeClass("btn btn-primary disabled").addClass("btn btn-primary");
				check_name_food();
			});
			$('#price_food').focusout(function () {
				check_price();
			});
			$('#discount_food').focusout(function(){
				check_discount();
			});
			
			
			function check_name_food(){
				var name_food = $('#name_food').val();
				if(name_food.indexOf('<') != -1){
					$('#name_food_mess').html("Chứa ký tự đặc biệt vui lòng không điền dạng '<' alert>");
					$('#name_food_mess').show();
					error_name = true;
				}else if(name_food.length < 1){
					$("#name_food_mess").html("Vui lòng điền đủ thông tin");
					$('#name_food_mess').show();
					error_name = true;
				}
				else{
					$('#name_food_mess').hide();
				}
			}
			
			
			function check_price(){
				var price_food = $('#price_food').val();
				var intRegex = /[0-9 -()+]+$/;
				if(price_food.indexOf('<') != -1){
					$('#price_food_mess').html("Chứa ký tự đặc biệt vui lòng không điền dạng '<' alert>");
					$('#price_food_mess').show();
					error_price = true;
				}else if(price_food.length < 1){
					$("#price_food_mess").html("Vui lòng điền đủ thông tin");
					$('#price_food_mess').show();
					error_price = true;
				}else if((!intRegex.test(price_food))){
					$("#price_food_mess").html("Vui lòng nhập số");
					$('#price_food_mess').show();
					error_price = true;
				}
				else{
					$('#price_food_mess').hide();
				}
			}
			
			function check_discount(){
				var discount_food = $('#discount_food').val();
				var intRegex = /[0-9 -()+]+$/;
				if(discount_food.indexOf('<') != -1){
					$('#discount_food_mess').html("Chứa ký tự đặc biệt vui lòng không điền dạng '<' alert>");
					$('#discount_food_mess').show();
					error_discount = true;
				}else if(discount_food.length < 1){
					$("#discount_food_mess").html("Vui lòng điền đủ thông tin");
					$('#discount_food_mess').show();
					error_discount = true;
				}else if((!intRegex.test(discount_food))){
					$("#discount_food_mess").html("Vui lòng nhập số");
					$('#discount_food_mess').show();
					error_discount = true;
				}
				else{
					$('#price_food_mess').hide();
				}
			}
			
			$('#check-form').submit(function(){
				error_name = false;
				error_price = false;
				error_discount = false;
				error_img = false;
				check_name_food();
				check_price();
				check_discount();
				var file = $("#fileToUpload");
				//var name_file = file[0].files.length;
				var item = file[0].files;
				var lg = file.length;
				console.log(lg);
				if(lg < 1){
					$('#img_mess').html("Nhập đúng định dạng hình ảnh .jpg");
					$('#img_mess').show();
					error_img = true;
					return false;
				}else{
					var name_file = item[0].name;
					console.log("name file: " + name_file);
					if(name_file.indexOf('jpg') != -1){
						console.log("img ngon");
					}else if(name_file == null){
						error_img = true;
					}else{
						console.log("img failed");
						$('#img_mess').html("Nhập đúng định dạng hình ảnh .jpg");
						$('#img_mess').show();
						error_img = true;
					}
				}
				
				console.log(error_name, error_price, error_discount, error_img);
				if(error_name == false && error_price == false && error_discount == false && error_img == false){
					return true;
					alert("o day");
					console.log("123123");
				}else{
					return false;
					alert("lỗi");
					console.log("rưqerqwer");
				}
			})
			
		});
		
	</script>
</body>
</html>