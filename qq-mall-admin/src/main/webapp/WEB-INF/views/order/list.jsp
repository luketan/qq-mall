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
                     	  订单列表
                    	<form id="inputForm" action="list.html" method="post" class="row">
                            <div class="col-lg-12 form-inline pull-left">
                            	<input name="keyword" type="text" class="form-control input-sm" value="${keyword}" placeholder="输入关键字查询">
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <label>订单状态</label>
                                <select name="status" class="form-control input-sm">
                                    <option value="0" ${status==0?'selected':''}>全部状态</option>
                                    <c:forEach items="${orderStatusList}" var="orderStatus">
                                        <option value="${orderStatus.code}" ${status==orderStatus.code?'selected':''}>${orderStatus.value}</option>
                                    </c:forEach>
                                </select>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <label>支付状态</label>
                                <select name="payStatus" class="form-control input-sm" >
                                    <option value="0" ${payStatus==0?'selected':''}>全部方式</option>
                                    <c:forEach items="${orderPayStatusList}" var="orderPayStatus">
                                        <option value="${orderPayStatus.code}" ${payStatus==orderPayStatus.code?'selected':''}>${orderPayStatus.value}</option>
                                    </c:forEach>
                                </select>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <label>支付方式</label>
                                <select name="paymentId" class="form-control input-sm" >
                                    <option value="0" ${paymentId==0?'selected':''}>全部方式</option>
                                    <c:forEach items="${paymentTypeList}" var="paymentType">
                                        <option value="${paymentType.code}" ${paymentId==paymentType.code?'selected':''}>${paymentType.value}</option>
                                    </c:forEach>
                                </select>
                                <button type="button" class="btn btn-warning" onclick="submitSearch()">查询</button>
                                <button type="button" class="btn btn-primary" onclick="exportOrder()">导出</button>
                            </div>
                        </form>
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="table-responsive">
                            <table class="table table-striped table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th class="col-lg-1">订单编号</th>
                                    <th class="col-lg-1">用户</th>
                                    <th class="col-lg-1">电话号码</th>
                                    <th class="col-lg-1">订单金额</th>
                                    <th class="col-lg-1">支付方式</th>
                                    <th class="col-lg-1">状态</th>
                                    <th class="col-lg-1">支付状态</th>
                                    <th class="col-lg-1">创建时间</th>
                                    <th class="col-lg-1">操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:choose>
                                    <c:when test="${not empty page.list}">
                                        <c:forEach items="${page.list}" var="item">
                                            <tr>
                                                <td class="col-lg-1">${item.orderCode}</td>
                                                <td class="col-lg-1">${item.userName}</td>
                                                <td class="col-lg-1">${item.userPhone}</td>
                                                <td class="col-lg-1">${item.totalMoney}</td>
                                                <td class="col-lg-1"><c:forEach items="${paymentTypeList}" var="paymentType"><c:if test="${paymentType.code == item.paymentId}">${paymentType.value}</c:if></c:forEach></td>
                                                <td class="col-lg-1"><c:forEach items="${orderStatusList}" var="orderStatus"><c:if test="${orderStatus.code == item.status}">${orderStatus.value}</c:if></c:forEach></td>
                                                <td class="col-lg-1"><c:forEach items="${orderPayStatusList}" var="orderPayStatus"><c:if test="${orderPayStatus.code == item.payStatus}">${orderPayStatus.value}</c:if></c:forEach></td>
                                                <td class="col-lg-1"><fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
                                                <td class="col-lg-1"><a href="detail.html?orderId=${item.id}">查看详情</a></td>
                                            </tr>
                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise>
                                        <tr>
                                            <td colspan="10" class="text-center">没有数据</td>
                                        </tr>
                                    </c:otherwise>
                                </c:choose>
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
<script>
function exportOrder(){
	window.location.href = "export.html?"+$("#inputForm").serialize();
}
function submitSearch() {
    $("#inputForm").submit();
}
</script>
</body>
</html>