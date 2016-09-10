<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../include/taglib.jsp"%>
<!DOCTYPE html>
<html lang="cn">
<head>
    <meta name="desc" content="">
    <meta name="author" content="">
    <title>订单列表 - ${site.title}</title>
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
                     	   待审核列表
                     	 <form id="inputForm" action="/packOrder/packList.html" method="post" class="row">
                            <div class="col-lg-12 form-inline pull-left">
                            	<input name="key" type="text" class="form-control input-sm" value="${key}" placeholder="输入用户名/电话号码关键字查询">
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <button type="button" class="btn btn-warning" onclick="submitSearch()">查询</button>
                                <button type="button" class="btn btn-primary" onclick="exportPackOrder()">导出</button>
                            </div>
                         </form>
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="table-responsive">
                            <table class="table table-striped table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th class="col-lg-2">用户编号</th>
                                    <th class="col-lg-2">用户名称</th>
                                    <th class="col-lg-2">电话</th>
                                    <th class="col-lg-2">待发货数量</th>
                                    <th class="col-lg-2">包裹数量</th>
                                    <th class="col-lg-1">操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:choose>
                                    <c:when test="${not empty page.list}">
                                        <c:forEach items="${page.list}" var="item">
                                            <tr>
                                                <td class="col-lg-2">${item.userId}</td>
                                                <td class="col-lg-2">${item.userName}</td>
                                                <td class="col-lg-2">${item.telephone}</td>
                                                <td class="col-lg-2">${item.waitShipNum==null?0:item.waitShipNum}</td>
                                                <td class="col-lg-2">${item.packNum==null?0:item.packNum}</td>
                                                <td class="col-lg-1"><a href="packDetail.html?userId=${item.userId}">查看详情</a></td>
                                            </tr>
                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise>
                                        <tr>
                                            <td colspan="6" class="text-center">没有数据</td>
                                        </tr>
                                    </c:otherwise>
                                </c:choose>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.table-responsive -->
                        ${page}
                        <%-- <div class="col-sm-2">
                            <a href="export.html?status=${status}&type=${type}&pickup=${pickup}&key=${key}" class="btn btn-success btn-sm" style="margin-top: 20px" role="button">导出当前记录</a>
                        </div> --%>
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
<script>
function submitSearch() {
    $("#inputForm").attr("action","/packOrder/packList.html");
    $("#inputForm").submit();
}
function exportPackOrder() {
    $("#inputForm").attr("action","/packOrder/export.html");
    $("#inputForm").submit();
}
</script>
</body>
</html>