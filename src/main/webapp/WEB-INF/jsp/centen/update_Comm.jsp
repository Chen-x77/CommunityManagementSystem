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
                    <h5>修改社团信息</h5>
                </div>
                <div class="ibox-content">

                    <form class="form-horizontal m-t"  action="/centen_setCommFrom" method="post">
                        <%--取出id提交表单--%>
                        <input name="id" id="id" type="hidden" value="${comm.id}">
                            <div class="form-group">
                                <label class="col-sm-1 control-label">社团简介：</label>
                                <div class="col-sm-6">
                                     <textarea style="resize: none;" id="intro" name="intro" cols="40" rows="5" class="form-control" > ${comm.intro} </textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-1 control-label">社团人数</label>
                                <div class="col-sm-1">
                                    <input value="${comm.sum}" type="text" class="form-control" id="sum" name="sum">
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
<script src="./js/plugins/iCheck/icheck.min.js"></script>
<!-- layerDate plugin javascript -->
<script src="./js/plugins/layer/laydate/laydate.js"></script>
<script>

    var date = {
        elem: '#date',
        format: 'YYYY/MM/DD hh:mm:ss',
        min: laydate.now(), //设定最小日期为当前日期
        max: '2099-06-16 23:59:59', //最大日期
        istime: true,
        istoday: false,
        choose: function (datas) {
            end.min = datas; //开始日选好后，重置结束日的最小日期
            end.start = datas //将结束日的初始值设定为开始日
        }
    };
    laydate(date)


</script>


</body>

</html>
