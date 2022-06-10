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


    <title>新增社团</title>
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
                    <h5>修改个人信息</h5>
                </div>
                <div class="ibox-content">

                    <form class="form-horizontal m-t"  action="/setPeopleFrom" method="post">
                        <%--取出id提交表单--%>
                            <div class="form-group">
                                <label class="col-sm-1 control-label">姓名：</label>
                                <div class="col-sm-2">
                                    <input value="${people.name}" id="name" name="name" class="form-control" type="text">
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-1 control-label">学院：</label>
                                <div class="col-sm-2">
                                    <select value="${people.college}" class="form-control" name="college" id="college">
                                        <option value="1">计算机学院</option>
                                        <option value="2">艺术学院</option>
                                        <option value="3">体育学院</option>
                                        <option value="4">政治与公共管理学院</option>
                                        <option value="5">社会学院</option>
                                        <option value="6">外国语学院</option>
                                        <option value="7">电气信息工程学院学院</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-1 control-label">班级</label>
                                <div class="col-sm-2">
                                    <input value="${people.name_class}" id="name_class" name="name_class" class="form-control" type="text">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-1 control-label">联系电话：</label>
                                <div class="col-sm-2">
                                    <input value="${people.phone}" id="phone" name="phone" class="form-control" type="text" aria-required="true" aria-invalid="true" class="error">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-1 control-label">微信：</label>
                                <div class="col-sm-2">
                                    <input value="${people.wx}" id="WX" name="wx" class="form-control" type="text" aria-required="true" aria-invalid="true" class="error">
                                </div>
                            </div>
                        <div class="form-group">
                            <div class="col-sm-8 col-sm-offset-3">
<%--                                <input onclick="updataInfo()" class="btn btn-primary" type="submit" value="提交">--%>
                                <button class="btn btn-lg" type="submit" >提交</button>
                            </div>
                        </div>
                    </form>
                    <input id="flag" type="hidden" value="${msg}"></input>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    var msg=document.getElementById("flag").value;
    if (msg.length > 0) alert(msg);
</script>
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
