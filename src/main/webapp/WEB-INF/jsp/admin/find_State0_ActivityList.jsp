<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>未审批活动</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="./css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="./css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="./css/animate.css" rel="stylesheet">
    <link href="./css/style.css?v=4.1.0" rel="stylesheet">
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox">
                <div class="ibox-title">
                    <h5>未审批列表</h5>
                </div>
                <div class="ibox-content">
                    <div class="row m-b-sm m-t-sm">

                        <div class="col-md-4" style="float: left;">
                            <div class="input-group" >
                                <form class="form-inline" action="/queryActivityName" method="get">
                                    <div class="form-group mx-sm-3 mb-2">
                                        <input type="text" class="form-control" name="activityName"placeholder="请输入活动名称">
                                    </div>
                                    <input type="hidden" value="0" name="flag">
                                    <button type="submit" class="btn btn-primary mb-2">搜索</button>
                                </form>
                            </div>
                        </div>
                        <div class="col-md-1" style="float: right">
                            <button type="button" id="loading-example-btn" class="btn btn-white btn-sm"><i class="fa fa-refresh"></i> 刷新</button>
                        </div>
                    </div>
                    <div class="project-list row">
                        <table class="table table-hover">
                            <thead class="table-header">
                            <tr>
                                <th class="table-th-css">活动名称</th>
                                <th class="table-th-css">活动地点</th>
                                <th class="table-th-css">活动主题</th>
                                <th class="table-th-css">申请社团</th>
                                <th class="table-th-css">申请时间</th>
                                <th class="table-th-css">审批进度</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="activity" items="${activityList}" varStatus="status">
                                <td>
                                    <span>${activity.name}</span>
                                </td>
                                <td>
                                    <span>${activity.location}</span>
                                </td>
                                <td>
									<span>
                                            ${activity.theme}
                                    </span>
                                </td>
                                <td>
                                    <span>${activity.comName}</span>
                                </td>
                                <td>
									<span>
                                        	<span> <fmt:formatDate value="${activity.date}" pattern="yyyy-MM-dd HH:mm:ss"/> </span>
                                    </span>
                                </td>
                                <td>
									<span>
											<c:if test="${activity.state==1}">已批复</c:if>
											<c:if test="${activity.state==0}">未批复</c:if>
									</span>
                                </td>
                                <td>
                                    <a href="/ChaKan_Activity_Admin?activity_id=${activity.id}" class="btn btn-white btn-sm"><i class="fa fa-folder"></i>查看</a>
                                    <a href="/ReplyActivity?activity_id=${activity.id}" class="btn btn-white btn-sm"><i class="fa fa-folder"></i>批复</a>
                                </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <input id="flag" type="hidden" value="${msg}">
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<script>
    var msg=document.getElementById("flag").value;
    if (msg.length > 0) alert(msg);
</script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<script src = "./js/jquery.min.js"></script>
<script src = "./js/jquery-form.js"></script>
<script src = "./js/bootstrap.min.js"></script>
<script src="./js/swal.js"></script>

</body>
</html>
