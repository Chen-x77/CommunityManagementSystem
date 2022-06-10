<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>活动批复</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="./css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="./css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="./css/animate.css" rel="stylesheet">
    <link href="./css/style.css?v=4.1.0" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="./webuploader/webuploader.css">
    <link rel="stylesheet" href="./css/plugins/iCheck/custom.css">
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>活动批复</h5>
                </div>
                <div class="ibox-content">

                    <form class="form-horizontal m-t" action="/replyActivityFrom" method="post">
                        <input type="hidden" value="${activity_id}" name="activity_id" id="activity_id">
                        <div class="form-group">
                            <label class="col-sm-1 control-label">批复意见：</label>
                            <div class="col-sm-4">
                                <textarea placeholder="请填写你的批复意见" style="resize: none;" name="reply" cols="40"
                                          rows="5"></textarea>
                            </div>
                        </div>


                            <button class="btn btn-primary mb-2" type="submit">回复</button>

                    </form>
                    <a href="/admin_fin_act_W" type="submit" class="btn btn-primary mb-2">返回</a>
                </div>
            </div>
        </div>
    </div>

</div>

<!-- 全局js -->
<script src="./js/jquery.min.js?v=2.1.4"></script>
<script src="./js/bootstrap.min.js?v=3.3.6"></script>
<!-- 自定义js -->
<script src="./js/content.js?v=1.0.0"></script>
<!-- jQuery Validation plugin javascript-->
<script src="./js/plugins/validate/jquery.validate.min.js"></script>
<script src="./js/plugins/validate/messages_zh.min.js"></script>
<script type="text/javascript" src="./webuploader/webuploader.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<script src="./js/swal.js"></script>
<script src="./js/plugins/iCheck/icheck.min.js"></script>
<!-- layerDate plugin javascript -->
<script src="./js/plugins/layer/laydate/laydate.js"></script>
</body>

</html>
