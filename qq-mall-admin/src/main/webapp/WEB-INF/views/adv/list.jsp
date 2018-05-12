<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../include/taglib.jsp"%>
<!DOCTYPE html>
<html lang="cn">
<head>
    <meta name="desc" content="">
    <meta name="author" content="">
    <title>广告列表 - ${site.title}</title>

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
                        广告列表
                        <a a href="add.html" class="btn btn-primary btn-xs pull-right"
                           role="button">新增广告</a>
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="table-responsive">
                            <table class="table table-striped table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>标题</th>
                                    <th>图片</th>
                                    <th>地址</th>
                                    <th>类型</th>
                                    <th>排序(降序)</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${page.list }" var="item">
                                	 <tr>
	                                    <td>${item.id }</td>
	                                    <td>${item.title }</td>
	                                    <td><img src="${item.image }" style="width: 40px"></td>
	                                    <td>${item.url}</td>
                                         <td>${item.styleType=='home'?"首页":""}${item.styleType=='search'?"搜索":""}</td>
	                                    <td>${item.sort}</td>
	                                    <td><a href="modify.html?id=${item.id }">编辑</a></td>
	                                </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.table-responsive -->
                        ${page }
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
