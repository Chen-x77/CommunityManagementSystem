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
	<title>添加部门</title>
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
					<h5>添加部门</h5>
				</div>
				<div class="ibox-content">
					<form class="form-horizontal m-t"  action="/addCommOfficeFrom" method="post">
						<div class="form-group">
							<label class="col-sm-1 control-label">部门名称</label>
							<div class="col-sm-1">
								<input type="text" class="form-control" id="name" name="name">
							</div>
						</div>
						<div class="form-group">
							<label  class="col-sm-1 control-label">职位名称</label>
							<div class="col-sm-1">
								<input type="text" class="form-control" id="position" name="position">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-1 control-label">负责人账号：</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="userName" name="userName">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-8 col-sm-offset-3">
								<button class="btn btn-lg" type="submit" >提交</button>
							</div>
						</div>
					</form>
					<input id="flag" type="hidden" value="${msg}">
					<input name="com_id" type="hidden" value="${com_id}">
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
