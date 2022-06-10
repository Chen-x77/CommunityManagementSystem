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


    <title>活动申请</title>
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
                        <h5>活动申请表</h5>
                    </div>
                    <div class="ibox-content">
                        <form class="form-horizontal m-t" action="/addActivityForm" method="post">
                            <div class="form-group">
                                <label class="col-sm-1 control-label">活动名称：</label>
                                <div class="col-sm-4">
                                	<input class="form-control" type="text" name="name" >
                                </div>
                                
                            </div>

                            <div class="form-group">
                                <label class="col-sm-1 control-label">活动开始时间：</label>
                                <div class="col-sm-4">
                                	<input placeholder="开始日期"  class="form-control layer-date" id="date_start" name="date_start">
                                </div>
                                
                            </div>

                            <div class="form-group">
                                <label class="col-sm-1 control-label">活动结束时间：</label>
                                <div class="col-sm-4">
                                    <input placeholder="结束日期"  class="form-control layer-date" id="date_stop" name="date_stop">
                                </div>
                            </div>
                                    
                            <div class="form-group">
                                <label class="col-sm-1 control-label">活动地点：</label>
                                <div class="col-sm-2">
                                    <input class="form-control" type="text" name="location">
                                </div>
                            </div>


                            <div class="form-group">
                                <label class="col-sm-1 control-label">活动主题：</label>
                                <div class="col-sm-4">
                                    <input class="form-control" type="text" name="theme">
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <label class="col-sm-1 control-label">活动简介：</label>
                                <div class="col-sm-4" >
                                    <textarea style="resize: none;" name="intros" cols="40" rows="5"></textarea>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-sm-8 col-sm-offset-3">
                                    <button class="btn btn-lg" type="submit" >提交</button>
                                </div>
                            </div>
                        </form>
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

    <!-- layerDate plugin javascript -->
    <script src="./js/plugins/layer/laydate/laydate.js"></script>
    <script>

        //日期范围限制
        var start = {
            elem: '#date_start',
            format: 'YYYY-MM-DD hh:mm:ss',
            min: laydate.now(), //设定最小日期为当前日期
            max: '2099-06-16 23:59:59', //最大日期
            istime: true,
            istoday: false,
            choose: function (datas) {
                end.min = datas; //开始日选好后，重置结束日的最小日期
                end.start = datas //将结束日的初始值设定为开始日
            }
        };
        var end = {
            elem: '#date_stop',
            format: 'YYYY-MM-DD hh:mm:ss',
            min: laydate.now(),
            max: '2099-06-16 23:59:59',
            istime: true,
            istoday: false,
            choose: function (datas) {
                start.max = datas; //结束日选好后，重置开始日的最大日期
            }
        };
        laydate(start);
        laydate(end);
    </script>
</body>

</html>
