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
    <title>社团文件</title>
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
                    <h5>社团文件</h5>
                </div>
                <div class="ibox-content">
                    <div class="row m-b-sm m-t-sm">

                        <div class="col-md-4" style="float: left;">
                            <div class="input-group" >
                                <form class="form-inline" action="/queryFilesFrom" method="get">
                                    <div class="form-group mx-sm-3 mb-2">
                                        <input type="text" class="form-control" name="fileName" placeholder="请输入文件名称">
                                    </div>
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
                                <th>序号</th>
                                <th>文件名称</th>
                                <th>上传人</th>
                                <th>上传日期</th>

                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="files" items="${filesList}" varStatus="status">
                                <td>
                                    <span>${files.count}</span>
                                </td>
                                <td>
                                    <span>${files.name}</span>
                                </td>
                                <td>
                                    <span>${files.peoName}</span>
                                </td>
                                <td>
									<span>
                                        <span> <fmt:formatDate value="${files.date}" pattern="yyyy-MM-dd HH:mm:ss"/> </span>

                                    </span>
                                </td>
                                <td>
                                    <a href="/dowFiles_centen?files_id=${files.id}" class="btn btn-primary btn-sm"><i class="fa fa-pencil"></i>下载</a>
                                    <a href="/delFiles_centen?files_id=${files.id}" class="btn btn-primary btn-sm" > <i class="fa fa-remove"></i>删除</a>
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
