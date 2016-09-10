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
                            	<input name="key" type="text" class="form-control input-sm" value="${key}" placeholder="输入关键字查询">
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <label>订单状态</label>
                                <select name="status" class="form-control input-sm">
                                    <option value="0" ${status==0?'selected':''}>全部状态</option>
                                    <option value="1" ${status==1?'selected':''}>已提交</option>
                                    <option value="2" ${status==2?'selected':''}>待确认</option>
                                    <option value="3" ${status==3?'selected':''}>已确认</option>
                                    <option value="4" ${status==4?'selected':''}>已完成</option>
                             <%--   <option value="5" ${status==5?'selected':''}>待发货</option>
                                    <option value="7" ${status==7?'selected':''}>取消申请中</option>--%>
                                    <option value="8" ${status==8?'selected':''}>已取消</option> 
                                </select>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <label>取货方式</label>
                                <select name="addressType" class="form-control input-sm" >
                                    <option value="0" ${addressType==0?'selected':''}>全部方式</option>
                                    <option value="1" ${addressType==1?'selected':''}>自提</option>
                                    <option value="2" ${addressType==2?'selected':''}>快递</option>
                                </select>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <label>销售方式</label>
                                <select name="type" class="form-control input-sm" >
                                    <option value="0" ${type==0?'selected':''}>全部方式</option>
                                    <option value="1" ${type==1?'selected':''}>按克销售</option>
                                    <option value="2" ${type==2?'selected':''}>按件销售</option>
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
                                    <th class="col-lg-2">订单编号</th>
                                    <th class="col-lg-2">订单状态</th>
                                    <th class="col-lg-2">购买用户</th>
                                  <!--   <th class="col-lg-1">取货方式</th> -->
                                    <th class="col-lg-2">下单时间</th>
                                    <th class="col-lg-2">备注</th>
                                    <th class="col-lg-1">操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:choose>
                                    <c:when test="${not empty page.list}">
                                        <c:forEach items="${page.list}" var="item">
                                            <tr>
                                                <td class="col-lg-2">${item.id}</td>
                                                <td class="col-lg-2">${item.orderStatusName}</td>
                                             	<td class="col-lg-2">${item.userName}/${item.telephone}</td>
                                              <%--   <td class="col-lg-1">${item.pickupType==1?"自提":"快递"}</td> --%>
                                                <td class="col-lg-2"><fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                                <td class="col-lg-2">${item.remark}</td>
                                                <td class="col-lg-1"><%-- ${item.operateUrl} --%><a href="detail.html?orderId=${item.id}">查看详情</a></td>
                                            </tr>
                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise>
                                        <tr>
                                            <td colspan="7" class="text-center">没有数据</td>
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
<script type="text/javascript" src="../../../static/js/order/list.js"></script>
<script>
function exportOrder(){
	window.location.href = "export.html?"+$("#inputForm").serialize();
}
</script>
</body>
</html>