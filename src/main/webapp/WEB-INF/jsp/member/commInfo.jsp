<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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


    <title> - 表单验证 jQuery Validation</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico"> <link href="./css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="./css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="./css/animate.css" rel="stylesheet">
    <link href="./css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">

    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>社团简介</h5>
                    </div>
                    <div class="ibox-content" style="font-size: 16px;">
                        <p>
                       ${comm.intro}
                        </p>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>基本信息</h5>
                    </div>
                    <div class="ibox-content" style="font-size: 16px;">
                        <div class="form-group" style="height: 50px; font-size: 18px;">
                            <label class="col-sm-3 control-label">
                                成立时间：<fmt:formatDate value="${comm.date}" pattern="yyyy-MM-dd"/>
                            </label>
                            <label class="col-sm-3 control-label">所属学院：${comm.collegeName}</label>
                            <label class="col-sm-3 control-label">指导教师：${comm.teacher}</label>
                        </div>
                        <div class="form-group" style="height: 50px; font-size: 18px;">
                            <label class="col-sm-3 control-label">会员数：${comm.sum}</label>
                            <label class="col-sm-3 control-label">任职人数：${commOfficeSum}</label>
                            <label class="col-sm-3 control-label">活动总数：${activitySum}</label>
                        </div>
                        <div class="form-group" style="height: 50px; font-size: 18px;">
                            <label class="col-sm-3 control-label">会长/联系方式：${people.name}/${people.phone}</label>
                            <c:forEach var="office" items="${officeList}" varStatus="status">
                                <label class="col-sm-3 control-label">
                                    <td>
                                        <span>${office.name} ${office.position}：${office.peoName}/${office.peoPhone}</span>
                                    </td>
                                </label>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <input id="flag" type="hidden" value="${msg}">
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

    <script src="./js/demo/form-validate-demo.js"></script>

    
    

</body>

</html>
