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
				<div class="ibox-title">
					<h5>会员查看</h5>
				</div>
				<div class="ibox-content">
					<div class="row m-b-sm m-t-sm">

						<div class="col-md-4" style="float: left;">
							<div class="input-group" >
								<form class="form-inline" action="/queryPeople" method="get">
									<div class="form-group mx-sm-3 mb-2">
										<input type="text" class="form-control" name="commName"placeholder="请输入社团名称">
									</div>
<%--									<div class="form-group mx-sm-3 mb-2">--%>
<%--										<input type="text" class="form-control" name="peopleName"placeholder="请输入学生姓名">--%>
<%--									</div>--%>
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
								<th class="table-th-css">账号</th>
								<th class="table-th-css">姓名</th>
								<th class="table-th-css">社团</th>
								<th class="table-th-css">学院</th>
								<th class="table-th-css">职位</th>
								<th class="table-th-css">联系电话</th>
							</tr>
							</thead>
							<tbody>
							<c:forEach var="people" items="${peopleList}" varStatus="status">
								<td>
									<span>${people.userName}</span>
								</td>
								<td>
									<span>${people.name}</span>
								</td>

								<td>
									<span>
											${people.comName}
									</span>
								</td>

								<td>
									<span>
											${people.collegeName}
									</span>
								</td>
								<td>
									<span>
											${people.flagName}
									</span>
								</td>
								<td>
									<span>
											${people.phone}
									</span>
								</td>
								<td>
									<a href="/ChaKanPeople?userName=${people.userName}" class="btn btn-primary btn-sm"><i class="fa fa-pencil"></i>查看</a>
									<a href="/delPeople?peopleId=${people.id}&peopleFlag=${people.flag}&comId=${people.com_id}" class="btn btn-primary btn-sm" > <i class="fa fa-remove"></i>删除</a>
								</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
					</div>
					<input id="flag" type="hidden" value="${msg}"></input>
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

<script>
	function delComm(obj){
		alert(obj.attr("commId"))
		$.ajax({
			type:"GET",
			url:"/delComm",
			data:{uid:obj.attr("commId")},
			dataType:"json",
			success:function(data){
				if(data.delResult == "true"){//删除成功：移除删除行
					cancleBtn();
					obj.parents("tr").remove();
				}else if(data.delResult == "false"){//删除失败
					changeDLGContent("对不起，删除用户【"+obj.attr("username")+"】失败");
				}else if(data.delResult == "notexist"){
					changeDLGContent("对不起，用户【"+obj.attr("username")+"】不存在");
				}
			},
			error:function(data){
				changeDLGContent("对不起，删除失败");
			}
		});
	}
	//查询按钮事件
	$('#search_btn').click(function(){
		$('#mytab').bootstrapTable('refresh', {url: '/commSearchfrom'});
	})
</script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<script src = "./js/jquery.min.js"></script>
<script src = "./js/jquery-form.js"></script>
<script src = "./js/bootstrap.min.js"></script>
<script src="./js/swal.js"></script>

</body>
</html>
