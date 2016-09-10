<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../include/taglib.jsp"%>
<!DOCTYPE html>
<html lang="cn">
<head>
    <meta name="desc" content="">
    <meta name="author" content="">
    <title>自提地址列表 - ${site.title}</title>
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
                        自提地址列表<a a="" href="address/add.html" class="btn btn-primary btn-xs pull-right" role="button">新增记录</a>
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="table-responsive">
                            <table class="table table-striped table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>联系人</th>
                                    <th>联系电话</th>
                                    <th>自提地址</th>
                                    <th>提货备注</th>
                                    <th>更新时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${page.list}" var="item">
                                    <tr>
                                        <td>${item.id}</td>
                                        <td>${item.userName}</td>
                                        <td>${item.telephone}</td>
                                        <td>${item.detail}</td>
                                        <td>${item.illustrate}</td>
                                        <td><fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
                                        <td><a href="/system/address/modify.html?id=${item.id}">编辑</a></td>
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