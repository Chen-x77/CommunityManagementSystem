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
	<title>活动信息</title>
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
					<h5>活动信息</h5>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">活动名称</div>
					<div class="panel-body">
						${activity.name}
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">申请社团</div>
					<div class="panel-body">
						${activity.comName}
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">申请人/联系方式</div>
					<div class="panel-body">
						${activity.peoName}/${activity.peoPhone}
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">活动开始时间</h3>
					</div>
					<div class="panel-body">
						<span> <fmt:formatDate value="${activity.date_start}" pattern="yyyy-mm-dd hh:mm:ss"/> </span>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">活动结束时间</h3>
					</div>
					<div class="panel-body">
						<span> <fmt:formatDate value="${activity.date_stop}" pattern="yyyy-mm-dd hh:mm:ss"/> </span>
					</div>
				</div>

				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">活动位置</h3>
					</div>
					<div class="panel-body">
						${activity.location}
					</div>
				</div>

				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">活动主题</h3>
					</div>
					<div class="panel-body">
						${activity.theme}
					</div>
				</div>

				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">活动简介</h3>
					</div>
					<div class="panel-body">
						${activity.intros}
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">申请时间</h3>
					</div>
					<div class="panel-body">
						<span> <fmt:formatDate value="${activity.date}" pattern="yyyy-MM-dd HH:mm:ss"/> </span>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">审批状态</h3>
					</div>
					<div class="panel-body">
						<c:if test="${activity.state==1}">已批复</c:if>
						<c:if test="${activity.state==0}">未批复</c:if>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">批复意见</h3>
					</div>
					<div class="panel-body">
						${activity.reply}
					</div>
				</div>
			<%--	<a href="/admin_fin_act_W" type="submit" class="btn btn-primary mb-2">返回未审批列表 </a>
				<a href="/admin_fin_act" type="submit" class="btn btn-primary mb-2">返回已审批列表 </a>--%>
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
