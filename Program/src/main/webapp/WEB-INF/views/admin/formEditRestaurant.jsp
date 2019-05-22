<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Món ăn</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link href="/Project/resources/css/admin/bootstrap.min.css" rel="stylesheet">
<link href="/Project/resources/css/admin/metisMenu.min.css" rel="stylesheet">
<link href="/Project/resources/css/admin/startmin.css" rel="stylesheet">
<link href="/Project/resources/css/admin/morris.css" rel="stylesheet">
<link href="/Project/resources/css/admin/dataTables/dataTables.bootstrap.css" rel="stylesheet">
<link href="/Project/resources/css/admin/dataTables/dataTables.responsive.css" rel="stylesheet">
<!-- <link href="resources/css/admin/font-awesome.min.css" rel="stylesheet" type="text/css"> -->
<!-- <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"> -->
<link href="/Project/webjars/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
	<div id="wrapper">

    <!-- Navigation -->
    <%@ include file="nav_admin.jsp" %>

    <div id="page-wrapper">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">Thông tin quán ăn</h1>
                        </div>
                        <!-- /.col-lg-12 -->
                    </div>
                    <!-- /.row -->
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    Sửa thông tin quán ăn
                                </div>
                                <div class="panel-body">
			                <div class="row">
			                    <div class="col-lg-8">
			                        <form:form role="form" action="/Project/admin/restaurant/saveRestaurant" enctype="multipart/form-data" method = "post">
			                            <div class="form-group"  >
			                                <form:hidden path="id_rest"/>
			                            </div>
			                             <div class="form-group"  >
			                                <form:hidden path="id_user"/>
			                            </div>
			                             <div class="form-group"  >
			                                <form:hidden path="status_rest"/>
			                            </div>
			                            <div class="form-group"  >
			                                <label>Tên quán ăn:</label>
			                                <form:input type="text" path="name_rest" class="form-control" placeholder="Nhập tên quán ăn"/>
			                            </div>
			                            <div class="form-group">
			                                <label>Địa chỉ</label>
			                                <form:input type="text" path="addres_rest" class="form-control" placeholder="Nhập địa chỉ" />
			                            </div>
			                            <div class="form-group">
			                                <label>Thời gian mở cửa</label>
			                                <form:input type="text" path="time_open" class="form-control" placeholder="Nhập thời gian mở cửa"/>
			                            </div>
			                            <div class="form-group">
			                                <label>Giá trung bình:</label>
			                                <form:input type="text" path="cost_rest" class="form-control" placeholder="Nhập giá trung bình"/>
			                            </div>
			                            <div class="form-group">
			                                <label>Loại món ăn:</label>
			                                <form:input type="text" path="kind_rest" class="form-control" placeholder="Nhập giá loại món ăn"/>
			                            </div>
			                            <div class="form-group">
			                                <label>Ảnh quán ăn</label>
			                                <!-- <input type="file" name="file" id="fileToUpload" onchange="readURL(this)">  onchange="readURL(this)" -->
			                                <img alt="" src="${pageContext.request.contextPath}/image/${image_rest}">
			                                <form:hidden path="image_rest"/>
			                            </div>
			                            <button type="submit" class="btn btn-primary" style="float: right">Lưu thông tin quán ăn</button>
			                        </form:form>
			                    </div>
			                    
			                    <div class="col-lg-4">
			                     </div>
			                    	<img id="blah" src="" alt="" style="padding-top:30%" />
			                    </div>
			                    
			                </div>
			                <!-- /.row (nested) -->
                                
                            </div>
                            <!-- /.panel -->
                        </div>
                        <!-- /.col-lg-12 -->
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
	<script>
            $(document).ready(function() {
                $('#dataTables-example').DataTable({
                        responsive: true
                });
            });
        </script>
</body>
</html>