<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../include/taglib.jsp"%>
<!DOCTYPE html>
<html lang="cn">
<head>
    <meta name="desc" content="">
    <meta name="author" content="">

    <title>版本信息 - ${site.title}</title>

    <%@include file="../include/head.jsp"%>
</head>

<body>
<div id="wrapper">

    <!-- Navigation -->
    <%@include file="../include/nav.jsp"%>

    <div id="page-wrapper">
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        版本控制列表<a a href="/versionInfo/version/toAdd.html" class="btn btn-primary btn-xs pull-right" role="button">新增记录</a>
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="table-responsive">
                            <table class="table table-striped table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>最低版本</th>
                                    <th>本次版本</th>
                                    <th>系统</th>
                                    <th>所属平台</th>
                                    <th>是否强制更新</th>
                                    <td>状态</td>
                                    <td>修改时间</td>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${page.list }" var="item">
                                <tr>
                                    <td>${item.id }</td>
                                    <td>${item.lowestVersion }</td>
                                    <td>${item.latestVersion }</td>
                                    <td>${item.osType}</td>
                                    <td>${item.type == "platform"?"平台":"" }
                                    ${item.type == "company"?"商户":"" }</td>
                                    <td>${item.enforce==true?"强制更新":"非强制更新"}</td>
                                    <td>${item.status==1?"活跃":"未激活"}</td>
                                    <td><fmt:formatDate value="${item.updateTime}" pattern="yyyy-MM-dd hh:mm:ss"></fmt:formatDate></td>
                                    <td><a href="/versionInfo/version/modify.html?id=${item.id }">编辑</a></td>
                                </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.table-responsive -->
                        ${page}
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
    </div>
    <!-- /#page-wrapper -->
</div>

<%@include file="../include/footer.jsp"%>
</body>
</html>