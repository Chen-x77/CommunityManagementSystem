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

    <title>社团管理员端</title>

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
                                        <strong class="font-bold">系统管理员端</strong>
                                    </span>
                                </span>
                            </a>
                        </div>
                        <div class="logo-element">系统管理员端
                        </div>
                    </li>
                    <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                        <span class="ng-scope">概况</span>
                    </li>
                    <li>
                        <a class="J_menuItem" href="/com_index">
                            <i class="fa fa-home"></i>
                            <span class="nav-label">信息主页</span>
                        </a>
                    </li>


                    <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                        <span class="ng-scope">管理</span>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-paste"></i> <span class="nav-label">社团管理</span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="/com_add_com">添加社团</a>
                            </li>
                            <li><a class="J_menuItem" href="/com_record">社团查看</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="/com_fin_stu">会员查看</a>
                            </li>

                        </ul>
                    </li>


                    <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                        <span class="ng-scope">审批</span>
                    </li>
					<li>
					    <a href="#"><i class="fa fa-cc-discover"></i> <span class="nav-label">活动审批</span></a>
						<ul class="nav nav-second-level">		
							</li>
					        <li><a class="J_menuItem" href="/admin_fin_act_W">待处理</a>
					        </li>
					        <li><a class="J_menuItem" href="/admin_fin_act">已处理</a>
					        </li>
					    </ul>    
					</li>
					<li>
						<a class="J_menuItem" href="/admin_password"><i class="fa fa-compass"></i> <span class="nav-label">密码修改</span></a>
                    </li>

					<li class="line dk"></li>
					<li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
					    <span class="ng-scope">文件管理</span>
					</li>
					<li>
					   <a class="J_menuItem" href="/com_pub_files"><i class="fa fa-book"></i> <span class="nav-label">公共文件</span></a>
					</li>

                </ul>
            </div>
        </nav>
        <!--左侧导航结束-->
        <!--右侧部分开始-->
        <div id="page-wrapper" class="gray-bg dashbard-1">
            <div class="row J_mainContent" id="content-main">
                <iframe id="J_iframe" width="100%" height="100%" src="/com_index" frameborder="0" seamless></iframe>
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

    <!-- 第三方插件 -->
    <script src="./js/plugins/pace/pace.min.js"></script>

</body>

</html>
