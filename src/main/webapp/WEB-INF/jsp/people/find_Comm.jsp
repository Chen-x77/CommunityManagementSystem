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
		<title>查看社团</title>
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
		                    <h5>社团查看</h5>
		                </div>
		                <div class="ibox-content">
		                    <div class="row m-b-sm m-t-sm">
								<div class="col-md-4" style="float: left;">
									<div class="input-group" >
										<form class="form-inline" action="/queryCommFrom_people" method="get">
											<div class="form-group mx-sm-3 mb-2">
												<input type="text" class="form-control" name="commName"placeholder="请输入社团名称">
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
							                <th class="table-th-css">名称</th>
							                <th class="table-th-css">学院</th>
							                <th class="table-th-css">指导老师</th>
											<th class="table-th-css">会员总数</th>
							                <th class="table-th-css">社团类型</th>
											<!-- <th class="table-th-css">操作</th> -->
							            </tr>
							        </thead>
		                            <tbody>
											<c:forEach var="comm" items="${commList}" varStatus="status">

											<td>
												<span>${comm.name}</span>
											</td>
											<td>
												<span>
													<c:if test="${comm.college==1}">计算机学院</c:if>
													<c:if test="${comm.college==2}">艺术学院</c:if>
													<c:if test="${comm.college==3}">体育学院</c:if>
													<c:if test="${comm.college==4}">政治与公共管理学院<</c:if>
													<c:if test="${comm.college==5}">社会学院</c:if>
													<c:if test="${comm.college==6}">外国语学院</c:if>
													<c:if test="${comm.college==7}">电气信息工程学院学院</c:if>
												</span>
											</td>
											<td>
												<span>${comm.teacher}</span>
											</td>
											<td>
												<span>${comm.sum}</span>
											</td>
											<td>
												<span>
													<c:if test="${comm.type==1}">科技学术类</c:if>
													<c:if test="${comm.type==2}">文艺体育类</c:if>
													<c:if test="${comm.type==3}">理论学习类</c:if>
													<c:if test="${comm.type==4}">公益服务类</c:if>
												</span>
											</td>
											<td>
											    <a href="/getComm_people?commId=${comm.id}" class="btn btn-primary btn-sm"><i class="fa fa-pencil"></i>查看</a>
												<a href="/applyComm_people?commId=${comm.id}" class="btn btn-primary btn-sm"><i class="fa fa-pencil"></i>加入</a>
											</td>
		                                </tr>
											</c:forEach>
		                            </tbody>
		                        </table>
								<input type="hidden" id="flag" value="${msg}">
		                    </div>
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
    	<script src="./js/swal.js"></script>
	</body>
</html>
