<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thống kê</title>
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
                            <h1 class="page-header">Thống kê</h1>
                        </div>
                        <!-- /.col-lg-12 -->
                    </div>
                    <!-- /.row -->
                    <div class="row">
                        <div class="col-lg-3 col-md-6">
                        	<div class="panel panel-primary">
                        		<div class="panel-heading">
                                    <div class="row">
                                        <div class="col-xs-3">
                                            <i class="fa fa-money fa-5x"></i>
                                        </div>
                                        <div class="col-xs-9 text-right">
                                            <div class="huge" style="font-size : 20px"><fmt:formatNumber>${price_trans }</fmt:formatNumber><span> đ</span> </div>
                                            <div>Tổng doanh thu</div>
                                        </div>
                                    </div>
                                </div>
                        	</div>
                        </div>
                        
                        <div class="col-lg-3 col-md-6">
                            <div class="panel panel-green">
                                <div class="panel-heading">
                                    <div class="row">
                                        <div class="col-xs-3">
                                            <i class="fa fa-money fa-5x"></i>
                                        </div>
                                        <div class="col-xs-9 text-right">
                                            <div class="huge" style="font-size : 20px"><fmt:formatNumber>${sum_trans_date }</fmt:formatNumber><span> đ</span> </div>
                                            <div>Doanh thu ngày</div>
                                        </div>
                                    </div>
                                </div>
                                
                            </div>
                        </div>
                        
                        <div class="col-lg-3 col-md-6">
                            <div class="panel panel-yellow">
                                <div class="panel-heading">
                                    <div class="row">
                                        <div class="col-xs-3">
                                            <i class="fa fa-shopping-cart fa-5x"></i>
                                        </div>
                                        <div class="col-xs-9 text-right">
                                            <div class="huge" style="font-size : 20px"><fmt:formatNumber>${count_trans_date }</fmt:formatNumber><span> </span> </div>
                                            <div>Hóa đơn trong ngày</div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="col-lg-3 col-md-6">
                            <div class="panel panel-red">
                                <div class="panel-heading">
                                    <div class="row">
                                        <div class="col-xs-3">
                                            <i class="fa fa-shopping-cart fa-5x"></i>
                                        </div>
                                        <div class="col-xs-9 text-right">
                                            <div class="huge" style="font-size : 20px"><fmt:formatNumber>${count_trans }</fmt:formatNumber><span> </span> </div>
                                            <div>Tổng hóa đơn</div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--end-row-->
                    <div class="row">
                    	<form action="/Project/admin/dashboardByDate">
	                    	<div class="col-lg-12">
	                            <h4 class="page-header">Thống kê hóa đơn</h4>
	                        </div>
	                    	<div class="col-lg-2 ">
	                    		<input type="date" id="start" name="start_date" value="2018-07-22"  min="2018-01-01" max="2050-12-31">
	                    	</div>
	                    	<div class="col-lg-2 ">
	                    		<input type="date" id="end" name="end_date" value="2018-07-22"  min="2018-01-01" max="2050-12-31">
	                    	</div>
	                    	<div class = "col-lg-2">
	                    		<!-- <button type="button" class="btn btn-primary" onclick="DashBoardFood()">Thống kê</button> -->
	                    		<input type="submit" class="btn btn-primary" value="Thống kê">
	                    	</div>
                    	</form>
                    	
                    </div>
                    <div class="table-responsive">
                           <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                               <thead>
                                   <tr >
                                       <th style="text-align: center">Mã</th>
                                       <th style="text-align: center">Món ăn </th>
                                       <th style="text-align: center">Số lượng đã bán</th>
                                   </tr>
                               </thead>
                               <tbody>
                               	<c:forEach items="${list_trans_1 }" var="item">
                               		<tr class="odd gradeX">
                               			<td style="text-align: center">${item.id_food }</td>
                               			<td style="text-align: center">${item.name_food }</td>
                               			<td style="text-align: center">${item.quantum }</td>
                               			
                               		</tr>
                               	</c:forEach>                          
                               </tbody>
                           </table>
                           <a href="/Project/admin/exportExcel"><button class="btn btn-primary"> In Excel  </button></a>
                       </div>
                </div>
                <!-- /.container-fluid -->
            </div>
            <!-- /#page-wrapper -->
		
	</div>
</body>
	<script src="/Project/resources/js/admin/jquery.min.js"></script>
	<script src="/Project/resources/js/admin/bootstrap.min.js"></script>
	<script src="/Project/resources/js/admin/metisMenu.min.js"></script>
	<script src="/Project/resources/js/admin/dataTables/jquery.dataTables.min.js"></script>
	<script src="/Project/resources/js/admin/dataTables/dataTables.bootstrap.min.js"></script>
	<script src="/Project/resources/js/admin/startmin.js"></script>
	<script type="text/javascript">
		var today = new Date();
		var dd = String(today.getDate()).padStart(2,'0');
		var mm = String(today.getMonth() + 1).padStart(2, '0');
		var yyyy = today.getFullYear();
		today = yyyy + '-' + mm + '-' + dd;
		$('#start').val(today);
		$('#end').val(today);
	</script>
</html>