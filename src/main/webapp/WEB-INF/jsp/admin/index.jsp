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
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!--360浏览器优先以webkit内核解析-->
    <title>主页</title>

    <link rel="shortcut icon" href="favicon.ico"> <link href="./css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="./css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="./css/animate.css" rel="stylesheet">
    <link href="./css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content">
        <div class="row">
            <div class="col-sm-10">
                <div class="row">
                    <div class="col-sm-4">
                        <div class="row row-sm text-center">
                            <div class="col-xs-6">
                                <div class="panel padder-v item bg-primary">
                                    <div class="h1 text-fff font-thin h1">${commSum}</div>
                                    <span class="text-muted text-xs">校内社团数</span>
                                    <div class="top text-right w-full">
                                        <i class="fa fa-caret-down text-warning m-r-sm"></i>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xs-6">
                                <div class="panel padder-v item">
                                    <div class="font-thin h1">${memberSum}</div>
                                    <span class="text-muted text-xs">会员数</span>
                                    <div class="bottom text-left">
                                        <i class="fa fa-caret-up text-warning m-l-sm"></i>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xs-6">
                                <div class="panel padder-v item">
                                    <div class="h1 text-info font-thin h1">${activitySum0}</div>
                                    <span class="text-muted text-xs">未审批活动数</span>
                                    <div class="top text-right w-full">
                                        <i class="fa fa-caret-down text-warning m-r-sm"></i>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xs-6">
                                <div class="panel padder-v item">
                                    <div class="h1 text-info font-thin h1">${activitySum1}</div>
                                    <span class="text-muted text-xs">已审批活动数</span>
                                    <div class="top text-right w-full">
                                        <i class="fa fa-caret-down text-warning m-r-sm"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-8">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title" style="border-bottom:none;background:#fff;">
                                <h5>服务器状态</h5>
                            </div>
                            <div class="ibox-content" style="border-top:none;">
                                <div id="flot-line-chart-moving" style="height:217px;">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12">
                        <div class="ibox">
                            <div class="ibox-title">
                                <h5>待审批项目</h5>
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
									            <span>${activity.theme} </span>

                                            </td>
                                            <td>
                                                <span>${activity.comName}</span>
                                            </td>
                                            <td>
									            <span> <fmt:formatDate value="${activity.date}" pattern="yyyy-MM-dd HH:mm:ss"/> </span>
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
            <div class="col-sm-2">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>社团一览</h5>
                    </div>
                    <div class="ibox-content">
                        <ul class="todo-list m-t small-list ui-sortable">
                            <c:forEach var="comm" items="${commList}" varStatus="status">
                               <li>
                                   <a href="/admin_Index_ChaKanComm?commId=${comm.id}" class="check-link">go</a>
                               <%-- <a href="/admin_Index_ChaKanComm" class="check-link">go</a>--%>
                                <span class="m-l-xs ">${comm.name}</span>
                            </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- 全局js -->
    <script src="./js/jquery.min.js?v=2.1.4"></script>
    <script src="./js/bootstrap.min.js?v=3.3.6"></script>
    <script src="./js/plugins/layer/layer.min.js"></script>
    <!-- Flot -->
    <script src="./js/plugins/flot/jquery.flot.js"></script>
    <script src="./js/plugins/flot/jquery.flot.tooltip.min.js"></script>
    <script src="./js/plugins/flot/jquery.flot.resize.js"></script>
    <script src="./js/plugins/flot/jquery.flot.pie.js"></script>
    <!-- 自定义js -->
    <script src="./js/content.js"></script>
    <!--flotdemo-->
    <script type="text/javascript">
        $(function() {
            var container = $("#flot-line-chart-moving");
            var maximum = container.outerWidth() / 2 || 300;
            var data = [];

            function getRandomData() {
                if (data.length) {
                    data = data.slice(1);
                }
                while (data.length < maximum) {
                    var previous = data.length ? data[data.length - 1] : 50;
                    var y = previous + Math.random() * 10 - 5;
                    data.push(y < 0 ? 0 : y > 100 ? 100 : y);
                }
                var res = [];
                for (var i = 0; i < data.length; ++i) {
                    res.push([i, data[i]])
                }
                return res;
            }
            series = [{
                data: getRandomData(),
                lines: {
                    fill: true
                }
            }];
            var plot = $.plot(container, series, {
                grid: {

                    color: "#999999",
                    tickColor: "#f7f9fb",
                    borderWidth:0,
                    minBorderMargin: 20,
                    labelMargin: 10,
                    backgroundColor: {
                        colors: ["#ffffff", "#ffffff"]
                    },
                    margin: {
                        top: 8,
                        bottom: 20,
                        left: 20
                    },
                    markings: function(axes) {
                        var markings = [];
                        var xaxis = axes.xaxis;
                        for (var x = Math.floor(xaxis.min); x < xaxis.max; x += xaxis.tickSize * 2) {
                            markings.push({
                                xaxis: {
                                    from: x,
                                    to: x + xaxis.tickSize
                                },
                                color: "#fff"
                            });
                        }
                        return markings;
                    }
                },
                colors: ["#4fc5ea"],
                xaxis: {
                    tickFormatter: function() {
                        return "";
                    }
                },
                yaxis: {
                    min: 0,
                    max: 110
                },
                legend: {
                    show: true
                }
            });

            // Update the random dataset at 25FPS for a smoothly-animating chart

            setInterval(function updateRandom() {
                series[0].data = getRandomData();
                plot.setData(series);
                plot.draw();
            }, 40);
        });
        $(function() {
            var oilprices = [
                [1167692400000, 61.05],
                [1167778800000, 58.32],
                [1167865200000, 57.35],
                [1167951600000, 56.31],
            	[1220306400000, 109.71],
                [1220392800000, 109.35],
                [1220565600000, 106.23],
                [1220824800000, 106.34]
            ];
            var exchangerates = [
              	[1220479200000],
                [1220565600000],
                [1220652000000],
                [1220738400000],
                [1220824800000],
                [1220911200000]
            ];
});
    </script>
</body>

</html>
