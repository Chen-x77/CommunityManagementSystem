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
	<title>查看会员</title>
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
				<div class="ibox-title" style="marker-mid: none">
					<h5>社团查看</h5>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">社团名称</div>
					<div class="panel-body">
						${comm.name}
					</div>
				</div>

				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">隶属学院</h3>
					</div>
					<div class="panel-body">
						${comm.collegeName}
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">负责人/联系方式</h3>
					</div>
					<div class="panel-body">
						${people.name}/${people.phone}
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">指导老师</h3>
					</div>
					<div class="panel-body">
						${comm.teacher}
					</div>
				</div>

				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">成立时间</h3>
					</div>
					<div class="panel-body">
						<span> <fmt:formatDate value="${comm.date}" pattern="yyyy-MM-dd"/> </span>
					</div>
				</div>

				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">会员总数</h3>
					</div>
					<div class="panel-body">
						${comm.sum}
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">社团简介</h3>
					</div>
					<div class="panel-body">
						${comm.intro}
					</div>
				</div>

				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">社团类型</h3>
					</div>
					<div class="panel-body">
						<c:if test="${comm.type==1}">科技学术类</c:if>
						<c:if test="${comm.type==2}">文艺体育类</c:if>
						<c:if test="${comm.type==3}">理论学习类</c:if>
						<c:if test="${comm.type==4}">公益服务类</c:if>
					</div>
				</div>
				<%--<a href="/com_index" type="submit" class="btn btn-primary mb-2">返回 </a>--%>
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
