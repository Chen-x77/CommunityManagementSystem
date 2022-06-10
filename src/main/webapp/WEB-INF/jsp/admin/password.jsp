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


    <title>密码修改</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico"> <link href="./css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="./css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="./css/animate.css" rel="stylesheet">
    <link href="./css/style.css?v=4.1.0" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="./webuploader/webuploader.css">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>密码修改</h5>
                    </div>
                    <div class="ibox-content">
                        <form class="form-horizontal m-t" action="/passwordFrom" id="passwordForm" name="passwordForm" method="post">
                            <input  id="flag" type="hidden" value="${msg}">
                            <div class="form-group">
                                <label class="col-sm-1 control-label">原密码：</label>
                                <div class="col-sm-2">
                                    <input id="oldpassword" name="oldpassword" class="form-control" type="password">
                                    <span class="help-block m-b-none"></span>
                                </div>
                            </div>

                            <div class="form-group">
                                <label  class="col-sm-1 control-label">新密码：</label>	
							    <div class="col-sm-2">	
                                    <input id="newpassword" name="newpassword" class="form-control" type="password">
                                    <span class="help-block m-b-none"></span>
                                </div>
                            </div>

                            <div class="form-group">
                                <label  class="col-sm-1 control-label">再次输入新密码：</label>	
							    <div class="col-sm-2">	
                                    <input id="rnewpassword" name="rnewpassword" class="form-control" type="password">
                                    <span class="help-block m-b-none"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-4" style="text-align: center;">
                                    <input type="button" class="btn btn-primary" name="save" id="save"  value="提交">
                                </div>
                            </div>
                        </form>

                    </div>
                </div>
            </div>
        </div>

    </div>
    <script src="./js/plugins/layer/laydate/laydate.js"></script>
    <script>
        var msg=document.getElementById("flag").value;
        if (msg.length > 0) alert(msg);
    </script>

    <!-- 全局js -->
    <script src="./js/jquery.min.js?v=2.1.4"></script>
    <script src="./js/bootstrap.min.js?v=3.3.6"></script>
    <script type="text/javascript"  src="./js/pwdmodify.js"></script>
    <!-- layerDate plugin javascript -->
</body>

</html>
