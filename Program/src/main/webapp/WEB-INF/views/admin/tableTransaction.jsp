<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Hóa đơn</title>
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
    <%@include file="nav_admin.jsp" %>

    <div id="page-wrapper">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">Món ăn</h1>
                        </div>
                        <!-- /.col-lg-12 -->
                    </div>
                    <!-- /.row -->
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    Đơn hàng
                                </div>
                                <!-- /.panel-heading -->
                                <ul class="nav nav-tabs" style="padding-left: 50px">
				            		<li class="active"><a data-toggle="tab" href="#doing">Hoá đơn đang xử lý</a></li>
								    <li ><a data-toggle="tab" href="#done">Hóa đơn hoàn thành</a></li>
							  	</ul>
							  	<div class="tab-content">
							  		<div id="doing" class="tab-pane fade in active">
		                                <div class="panel-body">
		                                    <div class="table-responsive">
		                                        <table class="table table-striped table-bordered table-hover" id="dataTables-example">
		                                            <thead>
		                                                <tr >
		                                                    <th style="text-align: center" class = "sorting_desc" aria-sort="descending">Mã</th>
		                                                    <th style="text-align: center">Tên khách hàng</th>
		                                                    <th style="text-align: center">Địa chỉ</th>
		                                                    <th style="text-align: center">Giá</th>
		                                                    <th style="text-align: center">Trạng thái</th>
		                                                    <th style="text-align: center">Chi tiết</th>
		                                                </tr>
		                                            </thead>
		                                            <tbody>
		                                            	<c:forEach items="${LIST_TRANSACTION }" var="item">
		                                            		<tr class="odd gradeX">
		                                            			<td style="text-align: center">${item.id_transaction }</td>
		                                            			<td style="text-align: center">${item.name_user }</td>
		                                            			<td style="text-align: center">${item.address }</td>
		                                            			<td style="text-align: center"><fmt:formatNumber>${item.price }</fmt:formatNumber> </td>
		                                            			<td style="text-align: center">${item.tran_stat }</td>
		                                            			<td style="text-align: center">
		                                            				<a href="/Project/admin/transaction/${item.id_transaction }" class="btn btn-primary" style="font-size: 20px"><i class="fa fa-edit" style="font-size: 24px;"></i></a>
		                                            			</td>
		                                            		</tr>
		                                            	</c:forEach>                          
		                                            </tbody>
		                                        </table>
		                                    </div>
		                                    <!-- /.table-responsive -->
		                                   
		                                </div>
		                                <!-- /.panel-body -->
	                             	</div>
	                             	
	                             	
	                             	<div id="done" class="tab-pane fade">
		                                <div class="panel-body">
		                                    <div class="table-responsive">
		                                        <table class="table table-striped table-bordered table-hover" id="dataTables-example">
		                                            <thead>
		                                                <tr >
		                                                    <th style="text-align: center" class = "sorting_desc" aria-sort="descending">Mã</th>
		                                                    <th style="text-align: center">Tên khách hàng</th>
		                                                    <th style="text-align: center">Địa chỉ</th>
		                                                    <th style="text-align: center">Giá</th>
		                                                    <th style="text-align: center">Trạng thái</th>
		                                                    <th style="text-align: center">Chi tiết</th>
		                                                </tr>
		                                            </thead>
		                                            <tbody>
		                                            	<c:forEach items="${LIST_TRANSACTION_SUCCESS }" var="item">
		                                            		<tr class="odd gradeX">
		                                            			<td style="text-align: center">${item.id_transaction }</td>
		                                            			<td style="text-align: center">${item.name_user }</td>
		                                            			<td style="text-align: center">${item.address }</td>
		                                            			<td style="text-align: center"><fmt:formatNumber>${item.price }</fmt:formatNumber> </td>
		                                            			<td style="text-align: center">${item.tran_stat }</td>
		                                            			<td style="text-align: center">
		                                            				<a href="/Project/admin/transaction/${item.id_transaction }" class="btn btn-primary" style="font-size: 20px"><i class="fa fa-edit" style="font-size: 24px;"></i></a>
		                                            			</td>
		                                            		</tr>
		                                            	</c:forEach>                          
		                                            </tbody>
		                                        </table>
		                                    </div>
		                                    <!-- /.table-responsive -->
		                                   
		                                </div>
		                                <!-- /.panel-body -->
	                             	</div>
	                             	
	                             	
                             	</div>
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