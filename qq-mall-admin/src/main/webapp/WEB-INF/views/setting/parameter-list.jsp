<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../include/taglib.jsp"%>
<!DOCTYPE html>
<html lang="cn">
<head>
    <meta name="desc" content="">
    <meta name="author" content="">
    <title>系统参数管理 - ${site.title}</title>
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
                        系统参数管理<a a href="parameter/add.html" class="btn btn-primary btn-xs pull-right" role="button">新增记录</a>
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="table-responsive">
                            <table class="table table-striped table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th style="width: 60px">序号</th>
                                    <th style="width: 100px">参数名称</th>
                                    <%--<th>参数类型</th>--%>
                                    <%--<th>参数代码</th>--%>
                                    <th >参数值</th>
                                    <th style="width: 120px">描述</th>
                                    <th style="width: 160px">创建时间</th>
                                    <%--<th>创建人</th>--%>
                                    <th style="width: 160px">更新时间</th>
                                    <%--<th>更新人</th>--%>
                                    <th style="width: 80px">操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${page.list}" var="item">
                                    <tr>
                                        <td style="width: 60px">${item.id}</td>
                                        <td style="width: 120px">${item.name}</td>
                                        <%--<td>${item.type}</td>--%>
                                        <%--<td>${item.code}</td>--%>
                                        <td style="word-break:break-all;">${item.value}</td>
                                        <td style="width: 120px">${item.remark}</td>
                                        <td style="width: 100px"><fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                        <%--<td>${item.createUser}</td>--%>
                                        <td><fmt:formatDate value="${item.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                        <%--<td>${item.updateUser}</td>--%>
                                        <td style="width: 80px"><a href="${basePath }/system/parameter/modify.html?id=${item.id}">编辑</a></td>
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