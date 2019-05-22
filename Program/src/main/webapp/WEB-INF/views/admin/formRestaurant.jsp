<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Thêm nhà hàng</title>
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
    <%-- <%@ include file="nav_admin.jsp" %> --%>

    <!-- Page Content -->
    <div id="page-wrapper">
        <div class="container-fluid">

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Thêm cửa hàng mới</h1>
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
			                        <form:form role="form" action="/Project/admin/save-restaurant" enctype="multipart/form-data" method = "post" id="check_form_rest">
			                            <div class="form-group"  >
			                                <label>Tên cửa hàng:</label>
			                                <form:input type="text" id="name_rest" path="name_rest" class="form-control" placeholder="Nhập tên cửa hàng"/>
			                                <span class="error_form" id="name_rest_mess" style="color: red"></span>
			                            </div>
			                            <div class="form-group">
			                                <label>Địa chỉ của hàng:</label>
			                                <form:input type="text" id="addres_rest" path="addres_rest" class="form-control" placeholder="Nhập địa chỉ của hàng"/>
			                                <span class="error_form" id="address_rest_mess" style="color: red"></span>
			                            </div>
			                            
			                            <div class="form-group">
			                                <label>Thời gian mở cửa:</label>
			                                <input type="text" name="time_open" id="time_open" class="form-control" placeholder="Nhập thời gian mở cửa"/>
			                                <span class="error_form" id="timeopen_rest_mess" style="color: red"></span>
			                            </div>
			                            <div class="form-group">
			                                <label>Thời gian đóng cửa:</label>
			                                <input type="text" id="time_close" name="time_close" class="form-control" placeholder="Nhập thời gian đóng cửa"/>
			                                <span class="error_form" id="timeclose_rest_mess" style="color: red"></span>
			                            </div>
			                            <div class="form-group">
			                                <label>Loại cửa hàng:</label>
			                                <form:input type="text" id="kind_rest" path="kind_rest" class="form-control" placeholder="Nhập loại cửa hàng"/>
			                                <span class="error_form" id="kind_rest_mess" style="color: red"></span>
			                            </div>
			                            <div class="form-group">
			                                <label>Giá rẻ nhất:</label>
			                                <input type="text" id="cost_min" name="cost_min" class="form-control" placeholder="Nhập giá rẻ nhất cửa hàng" />
			                                <span class="error_form" id="cost_min_rest_mess" style="color: red"></span>
			                            </div>
			                            <div class="form-group">
			                                <label>Giá đắt nhất:</label>
			                                <input type="text" id="cost_max" name="cost_max" class="form-control" placeholder="Nhập giá đắt nhất cửa hàng" />
			                                <span class="error_form" id="cost_max_rest_mess" style="color: red"></span>
			                            </div>
			                            <div class="form-group">
			                                <label>Ảnh cửa hàng</label>
			                                <span class="error_form" id="img_mess" style="color: red"></span>
			                                <input type="file" name="file" id="fileToUpload" onchange="readURL(this)"/>  <!-- onchange="readURL(this)" -->
			                            </div>
			                            <input type="submit" id= "saveRestaurant"  value="Lưu quán ăn" class="btn btn-primary disabled"/>
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
			var error_address = false;
			var error_time_open = false;
			var error_time_close = false;
			var error_kind = false;
			var error_cost_min = false;
			var error_cost_max = false;
			var error_img = false;
			
			$('#name_rest_mess').hide();
			
			$('#name_rest').focusout(function(){
				console.log('vao day');
				$('#saveRestaurant').removeClass("btn btn-primary disabled").addClass("btn btn-primary");
				check_name_rest();
			});
			
			function check_name_rest(){
				var name_rest = $('#name_rest').val();
				console.log(name_rest);
				if(name_rest.indexOf('<') != -1){
					$('#name_rest_mess').html("Chứa ký tự đặc biệt vui lòng không điền dạng '<' alert>");
					$('#name_rest_mess').show();
					error_name = true;
				}else if(name_rest.length < 1){
					$('#name_rest_mess').html("Không được bỏ trống mục này");
					$('#name_rest_mess').show();
					error_name = true;
				}else{
					$('#name_rest_mess').hide();
				}
			}
			
			$('#addres_rest').focusout(function(){
				check_address();
			});
			function check_address(){
				var address = $('#addres_rest').val();
				if(address.indexOf('<') != -1){
					$('#address_rest_mess').html("Chứa ký tự đặc biệt vui lòng không điền dạng '<' alert>");
					$('#address_rest_mess').show();
					error_address = true;
				}else if(address.length < 1){
					$('#address_rest_mess').html("Không được bỏ trống mục này");
					$('#address_rest_mess').show();
					error_address = true;
				}else{
					$('#address_rest_mess').hide();					
				}
			}
			
			$('#time_open').focusout(function(){
				var time = $('#time_open').val();
				check_time();
			});
			
			
			function check_time(){
				var time =$('#time_open').val();
				var intRegex = /[0-9 -()+]+$/;		
				if(time.indexOf('<') != -1){
					$('#timeopen_rest_mess').html("Chứa ký tự đặc biệt vui lòng không điền dạng '<' alert>");
					$('#timeopen_rest_mess').show();
					error_time_open = true;
				}else if(time.length < 1){
					$('#timeopen_rest_mess').html("Không được bỏ trống mục này");
					$('#timeopen_rest_mess').show();
					error_time_open = true;
				}else{
					$('#timeopen_rest_mess').hide();
				}
			}
			$('#time_close').focusout(function(){
				check_time_close();
			});
			
			function check_time_close(){
				var intRegex = /[0-9 -()+]+$/;		
				var time = $("#time_close").val();
				if(time.indexOf('<') != -1){
					$('#timeclose_rest_mess').html("Chứa ký tự đặc biệt vui lòng không điền dạng '<' alert>");
					$('#timeclose_rest_mess').show();
					error_time_open = true;
				}else if(time.length < 1){
					$('#timeclose_rest_mess').html("Không được bỏ trống mục này");
					$('#timeclose_rest_mess').show();
					error_time_open = true;
				}else{
					$('#timeclose_rest_mess').hide();
				}
			}
			
			$('#kind_rest').focusout(function(){
				check_kind();
			});
			
			function check_kind(){
				var kind = $("#kind_rest").val();
				if(kind.indexOf('<') != -1){
					$('#kind_rest_mess').html("Chứa ký tự đặc biệt vui lòng không điền dạng '<' alert>");
					$('#kind_rest_mess').show();
					error_kind = true;
				}else if(kind.length < 1){
					$('#kind_rest_mess').html("Không được bỏ trống mục này");
					$('#kind_rest_mess').show();
					error_kind = true;
				}else{
					$('#kind_rest_mess').hide();
				}
			}
			
			$('#cost_min').focusout(function(){
				check_price();
			});
			
			function check_price(){
				var price = $('#cost_min').val();
				var intRegex = /[0-9 -()+]+$/;		
				if(price.indexOf('<') != -1){
					$('#cost_min_rest_mess').html("Chứa ký tự đặc biệt vui lòng không điền dạng '<' alert>");
					$('#cost_min_rest_mess').show();
					error_cost_min = true;
				}else if(price.length < 1){
					$('#cost_min_rest_mess').html("Không được bỏ trống mục này");
					$('#cost_min_rest_mess').show();
					error_cost_min = true;
				}else if(!intRegex.test(price)){
					$('#cost_min_rest_mess').html("Vui lòng nhập số tiền theo mẫu: 20000");
					$('#cost_min_rest_mess').show();
					error_cost_min = true;
				}else{
					$('#cost_min_rest_mess').hide();
				}
			}
			$("#cost_max").focusout(function(){
				check_price_max();
			});
			
			function check_price_max(){
				var price = $('#cost_max').val();
				var intRegex = /[0-9 -()+]+$/;		
				if(price.indexOf('<') != -1){
					$('#cost_max_rest_mess').html("Chứa ký tự đặc biệt vui lòng không điền dạng '<' alert>");
					$('#cost_max_rest_mess').show();
					error_cost_max = true;
				}else if(price.length < 1){
					$('#cost_max_rest_mess').html("Không được bỏ trống mục này");
					$('#cost_max_rest_mess').show();
					error_cost_max = true;
				}else if(!intRegex.test(price)){
					$('#cost_max_rest_mess').html("Vui lòng nhập số tiền theo mẫu: 20000");
					$('#cost_max_rest_mess').show();
					error_cost_max = true;
				}else{
					$('#cost_max_rest_mess').hide();
				}
			}
			
			$('#check_form_rest').submit(function(){
				
				error_name = false;
				 error_address = false;
				 error_time_open = false;
				 error_time_close = false;
				 error_kind = false;
				 error_cost_min = false;
				 error_cost_max = false;
				 
				 
				 check_name_rest();
				 check_address();
				 check_time();
				 check_time_close();
				 check_kind();
				 check_price();
				 check_price_max();
				 /*
				var file = $("#fileToUpload");
				//var name_file = file[0].files.length;
				var item = file[0].files;
				var name_file = item[0].name;
				console.log("name file: " + name_file);
				if(name_file.indexOf('jpg') != -1){
					console.log("img ngon");
				}else{
					console.log("img failed");
					$('#img_mess').html("Nhập đúng định dạng hình ảnh .jpg");
					$('#img_mess').show();
					error_img = true;
				}
				*/
			
				console.log(error_name, error_address, error_time_open, error_time_close, error_kind,
					 error_cost_min, error_cost_max, error_img);
				if(error_name == false && error_address == false && error_time_open == false && 
					error_time_close == false && error_kind == false && error_cost_min == false &&
					error_cost_max == false && error_img == false){
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