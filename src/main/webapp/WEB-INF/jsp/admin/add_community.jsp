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
                        <h5>新增社团</h5>
                    </div>
                    <div class="ibox-content">
                        <form class="form-horizontal m-t"  action="/addcommFrom" method="post" id="employForm">
                            <div class="form-group">
                                <label class="col-sm-1 control-label">社团名称：</label>
                                <div class="col-sm-1">
                                    <input type="text" class="form-control" id="name" name="name">
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-1 control-label">学院：</label>
                                <div class="col-sm-2">
                                    <select class="form-control" id="college" name="college">
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
                                <label  class="col-sm-1 control-label">指导老师：</label>	
							    <div class="col-sm-1">
							    	<input type="text" class="form-control" id="teacher" name="teacher">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-1 control-label">成立时间：</label>
                                <div class="col-sm-4">
                                    <input placeholder="选择日期" class="form-control layer-date" name="date" id="date">
                                </div>
                            </div>

                            <div class="form-group">
                                <label  class="col-sm-1 control-label">社团负责人账号：</label>
                                <div class="col-sm-1">
                                    <input type="text" class="form-control" name="peoUserName">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-1 control-label">会员总数：</label>
                                <div class="col-sm-5">
                                    <input type="text" class="form-control" id="sum" name="sum">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-1 control-label">社团简介：</label>
                                <div class="col-sm-6">
                                    <textarea style="resize: none;" id="intro" name="intro" cols="40" rows="5" class="form-control"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-1 control-label">社团类型：</label>
                                <div class="col-sm-7">
                                    <select class="form-control" id="type" name="type">
                                        <option value="1">科技学术类</option>
                                        <option value="2">文艺体育类</option>
                                        <option value="3">理论学习类</option>
                                        <option value="4">公益服务类</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-sm-8 col-sm-offset-3">
                                    <button class="btn btn-lg" type="submit" >注册</button>
                                </div>
                            </div>
                        </form>
                        <input id="flag" type="hidden" value="${msg}">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="./js/jquery.min.js?v=2.1.4"></script>
    <script src="./js/bootstrap.min.js?v=3.3.6"></script>
    <script src="./js/plugins/layer/laydate/laydate.js"></script>
    <script>
        $(function () {
            var msg=document.getElementById("flag").value;
            if (msg.length > 0) alert(msg);
        });
        var date= {
            elem: '#date',
            format: 'YYYY-MM-DD',
            value: laydate.now(), //设定最小日期为当前日期
            max: '2099-06-16', //最大日期
        };
        laydate(date)
    </script>
</body>

</html>
