<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../include/taglib.jsp"%>
<!DOCTYPE html>
<html lang="cn">
<head>
    <meta name="desc" content="">
    <meta name="author" content="">
    <title>用户优惠券列表 - ${site.title}</title>

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
                        用户优惠券列表
                        <form id="inputForm" action="userConponList.html" method="post" class="row">
                            <div class="col-lg-12 form-inline pull-left">
                                <input name="keyword" type="text" class="form-control " value="${keyword}" placeholder="优惠券名称/用户名称/电话号码">
                                <label style="margin-left:10px">销售方式</label>
                                <select name="status" class="form-control input-sm">
                                    <option value="">全部</option>
                                    <option value="0" ${status==0?'selected':''}>未使用</option>
                                    <option value="1" ${status==1?'selected':''}>已使用</option>
                                </select>
                                <label style="margin-left:10px">是否在有效期内</label>
                                <select name="useTime" class="form-control input-sm">
                                    <option value="">全部</option>
                                    <option value="true" ${useTime=='true'?'selected':''}>是</option>
                                    <option value="false" ${useTime=='false'?'selected':''}>否</option>
                                </select>
                                <button type="submit" class="btn btn-warning">查询</button>
                            </div>
                        </form>
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="table-responsive">
                            <table class="table table-striped table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>用户姓名</th>
                                    <th>用户电话</th>
                                    <th>优惠券名称</th>
                                    <th>使用类型</th>
                                    <th>开始时间</th>
                                    <th>结束时间</th>
                                    <th>是否使用</th>
                                    <th>修改时间</th>
                                    <th>创建时间</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${page.list }" var="item">
                                	 <tr>
	                                     <td>${item.id }</td>
	                                     <td>${item.userName }</td>
                                         <td>${item.phone }</td>
                                         <td>${item.couponName}</td>
                                         <td>${item.typeName}</td>
                                         <td><fmt:formatDate value="${item.startDate}" pattern="yyyy-MM-dd"/></td>
                                         <td><fmt:formatDate value="${item.endDate}" pattern="yyyy-MM-dd"/></td>
                                         <td>${item.status == 0?"未使用":"已使用"}</td>
                                         <td><fmt:formatDate value="${item.updateTime}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
                                         <td><fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
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