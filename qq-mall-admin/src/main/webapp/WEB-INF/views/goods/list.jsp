<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="desc" content="">
    <meta name="author" content="">

    <title>管理员列表列表 - ${site.title}</title>
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
                        商品列表列表<a a href="add.html" class="btn btn-primary btn-xs pull-right" role="button">新增新增</a>
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="col-lg-12">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th>序号</th>
                                        <td>图片</td>
                                        <th>名称</th>
                                        <th>价格</th>
                                        <th>状态</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${page.list}" var="item">
                                        <tr>
                                            <td>${item.id}</td>
                                           <%-- <td><img src="${item.imgUrl}" alt="" style="width:40px;"></td>--%>
                                            <td style="padding:0;text-align:center;vertical-align:middle;"><a href="${item.imgUrl}" class="lightbox" title="${item.name}"><img src="${item.imgUrl}" style="width:22px;"></a></td>
                                            <td>${item.name}</td>
                                            <td>${item.price}</td>
                                            <td>
                                                <c:forEach items="${goodsStatusList }" var="goodsStatus">
                                                    <c:if test="${goodsStatus.code == item.status}">
                                                        ${goodsStatus.value}
                                                    </c:if>
                                                </c:forEach>
                                            </td>
                                            <td><a href="modify.html?id=${item.id}">编辑</a></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.table-responsive -->
                            ${page}
                        </div>
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