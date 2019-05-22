<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Thông tin quán ăn</title>
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

    <%@include file="nav_admin.jsp" %>

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
                                    Quán ăn
                                </div>
                                <!-- /.panel-heading -->
                                <div class="panel-body">
                                    <div class="table-responsive">
                                        <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                            
                                            <tbody>
                                           		<tr class="odd gradeX">
                                           			<td style="text-align: center"> Tên quán ăn</td>
                                           			<td style="text-align: center">${restaurant.name_rest }</td>
                                           		</tr>
                                           		<tr class="odd gradeX">
                                           			<td style="text-align: center"> Địa chỉ</td>
                                           			<td style="text-align: center">${restaurant.addres_rest }</td>
                                           		</tr>  
                                           		<tr class="odd gradeX">
                                           			<td style="text-align: center"> Thời gian mở cửa</td>
                                           			<td style="text-align: center">${restaurant.time_open }</td>
                                           		</tr>  
                                           		<tr class="odd gradeX">
                                           			<td style="text-align: center"> Giá </td>
                                           			<td style="text-align: center">${restaurant.cost_rest }</td>
                                           		</tr>
                                           		<tr class="odd gradeX">
                                           			<td style="text-align: center"> Loại quán ăn </td>
                                           			<td style="text-align: center">${restaurant.kind_rest }</td>
                                           		</tr>  
                                           		                         
                                            </tbody>
                                            
                                        </table>
                                        <div style="float: right; padding-top: 20px"><a href="/Project/admin/restaurant/edit" ><button class="btn btn-primary">Sửa thông tin  </button></a> </div>
                                    </div>
                                    <!-- /.table-responsive -->
                                   
                                </div>
                                <!-- /.panel-body -->
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