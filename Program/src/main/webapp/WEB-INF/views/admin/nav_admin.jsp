<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Food Admin</a>
        </div>

        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>

        <!-- Top Navigation: Left Menu -->
        

        <!-- Top Navigation: Right Menu -->
        <ul class="nav navbar-right navbar-top-links">
            <li class="dropdown navbar-inverse">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-bell fa-fw color_noti"></i> <b class="caret"></b>
                </a>
                <ul class="dropdown-menu dropdown-alerts">
                    <li>
                        <a href="#">
                            <div class="notify">
                               
                            </div>
                        </a>
                    </li>
                    
                </ul>
            </li>
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-user fa-fw"></i> ${sessionScope.user_name } <b class="caret"></b>
                </a>
                <ul class="dropdown-menu dropdown-user">
                    <li><a href="/Project/admin/logout">Logout</a></li>
                </ul>
            </li>
        </ul>

        <!-- Sidebar -->
        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse">

                <ul class="nav" id="side-menu">
                    <li class="sidebar-search">
                        <div class="input-group custom-search-form">
                            <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                    <button class="btn btn-primary" type="button">
                                        <i class="fa fa-search"></i>
                                    </button>
                                </span>
                        </div>
                    </li>
                    
                    <li>
                        <a href="/Project/admin/food" ><i class="fa fa-edit fa-fw"></i> Món ăn<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                             <li>
                                 <a href="/Project/admin/loadFood">Thêm món ăn</a>
                             </li>
                             <li>
                                 <a href="/Project/admin/food">Danh sách món ăn</a>
                             </li>
                         </ul>
                    </li>
                    <li>
                        <a href="/Project/admin/transaction" class="active"><i class="fa fa-shopping-cart fa-fw"></i> Hóa đơn</a>
                    </li>
                    <li>
                        <a href="/Project/admin/restaurant/list" class="active"><i class="fa fa-shopping-cart fa-fw"></i> Thông tin quán ăn</a>
                    </li>
                    <li>
                        <a href="/Project/admin/dashboard" class="active"><i class="fa fa-dashboard fa-fw"></i> Thống kê</a>
                    </li>
                </ul>

            </div>
        </div>
    </nav>
</body>
</html>