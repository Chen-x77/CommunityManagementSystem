<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">

    <title>学生社团｜管理端</title>

    <meta name="keywords" content="">
    <meta name="description" content="">

    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.jsp" />
    <![endif]-->

    <link rel="shortcut icon" href="favicon.ico"> <link href="./css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="./css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="./css/animate.css" rel="stylesheet">
    <link href="./css/style.css?v=4.1.0" rel="stylesheet">
</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
<div id="wrapper">
    <!--左侧导航开始-->
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="nav-close"><i class="fa fa-times-circle"></i>
        </div>
        <div class="sidebar-collapse">
            <ul class="nav" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                                    <span class="block m-t-xs" style="font-size:20px;">
                                        <i class="fa fa-area-chart"></i>
                                        <strong class="font-bold">${comm.name}</strong>
                                    </span>
                                </span>
                        </a>
                    </div>
                    <div class="logo-element">${comm.name}
                    </div>
                </li>
                <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                    <span class="ng-scope">概况</span>
                </li>
                <li>
                    <a class="J_menuItem" href="/centen_index">
                        <i class="fa fa-home"></i>
                        <span class="nav-label">信息主页</span>
                    </a>
                </li>
                <li>
                    <a class="J_menuItem" href="/com_Info">
                        <i class="fa fa-bicycle"></i>
                        <span class="nav-label">社团概况</span>
                    </a>
                </li>
                <li class="line dk"></li>
                <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                    <span class="ng-scope">社团管理</span>
                </li>
                <li>
                    <a href="#"><i class="fa fa-paste"></i> <span class="nav-label">活动管理</span></a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="/centen_act_new">申请活动</a>
                        </li>
                        <li><a class="J_menuItem" href="/centen_findActivity">活动记录</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a ><i class="fa fa-asterisk"></i> <span class="nav-label">会员管理</span></a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="/centen_add_stu">添加会员</a>
                        </li>
                        <li><a class="J_menuItem" href="/centen_find_stu">查看会员</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a ><i class="fa fa-asterisk"></i> <span class="nav-label">部门管理</span></a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="/centen_add_office">添加部门</a>
                        </li>
                        <li><a class="J_menuItem" href="/centen_find_office">查看部门</a>
                        </li>
                    </ul>
                </li>



                <li class="line dk"></li>
                <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                    <span class="ng-scope">个人管理</span>
                </li>

                <li>
                    <a class="J_menuItem" href="/centenInfo_modify"><i class="fa fa-archive"></i> <span class="nav-label">信息修改</span></a>
                    <a class="J_menuItem" href="/centen_password"><i class="fa fa-compass"></i> <span class="nav-label">密码修改</span></a>
                </li>

                <li class="line dk"></li>
                <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                    <span class="ng-scope">文件管理</span>
                </li>
                <li>
                    <a class="J_menuItem" href="/centen_comm_file"><i class="fa fa-fire"></i> <span class="nav-label">文件查看</span></a>
                    <a class="J_menuItem" href="/commFilesUpload"><i class="fa fa-fire"></i> <span class="nav-label">文件上传</span></a>
                </li>
            </ul>
        </div>
    </nav>
    <!--左侧导航结束-->
    <!--右侧部分开始-->
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row J_mainContent" id="content-main">
            <iframe id="J_iframe" width="100%" height="100%" src="/centen_index" frameborder="0" data-id="/cen_index" seamless></iframe>
        </div>
    </div>
    <!--右侧部分结束-->
</div>

<!-- 全局js -->
<script src="./js/jquery.min.js?v=2.1.4"></script>
<script src="./js/bootstrap.min.js?v=3.3.6"></script>
<script src="./js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="./js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="./js/plugins/layer/layer.min.js"></script>

<!-- 自定义js -->
<script src="./js/hAdmin.js?v=4.1.0"></script>
<script type="text/javascript" src="./js/index.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<script src="./js/swal.js"></script>

<!-- 第三方插件 -->
<script src="./js/plugins/pace/pace.min.js"></script>
</body>

</html>
