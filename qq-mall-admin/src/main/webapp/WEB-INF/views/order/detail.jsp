<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../include/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="description" content="">
    <meta name="author" content="">

    <title>详情 - ${site.title}</title>
    <%@include file="../include/head.jsp" %>
    <link href="${basePath }/static/css/form.css" rel="stylesheet">
    <script src="${basePath }/static/libs/ckeditor/ckeditor.js"></script>
</head>

<body>
<div id="wrapper">
    <!-- Navigation -->
    <%@include file="../include/nav.jsp" %>
	<form action="commitOrder.html" method="post">
    <div id="page-wrapper">
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                       	 审核订单
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-12">
                                    <input type="hidden" name="id" value="${order.id}">
                                    <div class="form-group col-lg-3">
                                        <label>订单编号</label>
                                        <input name="orderCode" type="text" class="form-control" value="${order.orderCode}" readonly="readonly">
                                    </div>
                                   <div class="form-group col-lg-3">
                                        <label>用户姓名</label>
                                        <input type="text" name="userName" class="form-control" value="${order.userName}" >
                                    </div>
                                    <div class="form-group col-lg-3">
                                        <label>用户电话</label>
                                        <input type="text" name="userPhone" class="form-control" value="${order.userPhone}" >
                                    </div>
                                    <div class="form-group col-lg-3">
                                        <label>地址</label>
                                        <input type="text" name="address" class="form-control" value="${order.address}" >
                                    </div>
                                    <div class="form-group col-lg-3">
                                        <label>订单状态</label>
                                        <input type="hidden" name="status" class="form-control" value="${order.status}" readonly="readonly">
                                        <c:forEach items="${orderStatusList}" var="orderStatus">
                                            <c:if test="${orderStatus.code == order.status}">
                                                <input type="text" class="form-control" value="${orderStatus.value}" disabled>
                                            </c:if>
                                        </c:forEach>
                                    </div>
                                    <div class="form-group col-lg-3">
                                        <label>支付类型</label>
                                        <input type="hidden" name="paymentId" class="form-control" value="${order.paymentId}" readonly="readonly">
                                        <c:forEach items="${paymentTypeList}" var="paymentType">
                                            <c:if test="${paymentType.code == order.paymentId}">
                                                <input type="text" class="form-control" value="${paymentType.value}" disabled>
                                            </c:if>
                                        </c:forEach>
                                    </div>
                                    <div class="form-group col-lg-3">
                                        <label>支付状态</label>
                                        <input type="hidden" name="payStatus" class="form-control" value="${order.payStatus}" readonly="readonly">
                                        <c:forEach items="${orderPayStatusList}" var="orderPayStatus">
                                            <c:if test="${orderPayStatus.code == order.payStatus}">
                                                <input type="text" class="form-control" value="${orderPayStatus.value}" disabled>
                                            </c:if>
                                        </c:forEach>
                                    </div>
                                    <div class="form-group col-lg-3">
                                        <label>支付失败原因</label>
                                        <input type="text" class="form-control" value="${order.payReason}" disabled>
                                    </div>
                                    <div class="form-group col-lg-3">
                                        <label>商品总价</label>
                                        <input type="text" class="form-control" value="${order.money}" disabled>
                                    </div>
                                    <div class="form-group col-lg-3">
                                        <label>订单总价</label>
                                        <input type="text" class="form-control" value="${order.totalMoney}" disabled>
                                    </div>
                                    <div class="form-group col-lg-3">
                                        <label>邮费</label>
                                        <input type="text" class="form-control" value="${order.postMoney}" disabled>
                                    </div>
                                    <div class="form-group col-lg-3">
                                        <label>活动优惠金额</label>
                                        <input type="text" class="form-control" value="${order.lostActivityMoney}" disabled>
                                    </div>
                                    <div class="form-group col-lg-3">
                                        <label>优惠券优惠金额</label>
                                        <input type="text" class="form-control" value="${order.lostCouponMoney}" disabled>
                                    </div>
                                    <div class="form-group col-lg-3">
                                        <label>其他优惠金额，积分，红包</label>
                                        <input type="text" class="form-control" value="${order.lostMoney}" disabled>
                                    </div>
                                    <div class="form-group col-lg-3">
                                        <label>是否需要发票</label>
                                        <input type="text" class="form-control" value="${order.invoiceIs==0?'否':'是'}" disabled>
                                    </div>
                                    <div class="form-group col-lg-3">
                                        <label>发票抬头</label>
                                        <input type="text" class="form-control" value="${order.invoiceHead}" disabled>
                                    </div>
                                    <div class="form-group col-lg-3">
                                        <label>快递公司</label>
                                        <input type="text" class="form-control" value="" disabled>
                                    </div>
                                    <div class="form-group col-lg-3">
                                        <label>快递编号</label>
                                        <input type="text" class="form-control" value="${order.postCode}" disabled>
                                    </div>
                                    <div class="form-group col-lg-3">
                                        <label>来自</label>
                                        <input type="text" class="form-control" value="${order.form}" disabled>
                                    </div>
                                    <div class="form-group col-lg-3">
                                        <label>创建时间</label>
                                        <input type="text" class="form-control" value="<fmt:formatDate value="${order.createTime}" pattern="yyyy-MM-dd hh:mm:ss"/>" disabled>
                                    </div>
                                    <div class="form-group col-lg-12">
                                        <label>购买的产品列表</label>
                                        <table class="table table-bordered" style="margin-bottom: 0px;">
                                        	<thead>
                                        		<td>图片</td><td>名称</td><td>规格</td><td>价格</td><td>数量</td>
                                        	</thead>
                                            <tbody>
                                           		<c:forEach items="${order.orderItemBeanList}" var="orderItem">
                                           			<tr>
	                                           			<td style="width:120px"><a href="${orderItem.goodsImg}" class="lightbox" rel="orderItem${orderItem.id}"><img src="${orderItem.goodsImg}" style="width: 20px"></a></td>
	                                           			<td><a href="${basePath }/goods/modify.html?id=${orderItem.goodsId}">${orderItem.goodsName}</a></td>
	                                           			<td style="width:740px">
                                                            <c:forEach items="${orderItem.formats}" var="format">
                                                                【${format.formatName}：${format.name}】
                                                            </c:forEach>
                                                        </td>
	                                           			<td style="width:140px">${orderItem.price}</td>
	                                           			<td style="width:60px">${orderItem.num}</td>
                                           			</tr>
                                                    <c:forEach items="${orderItem.activitys}" var="activity">
                                                        <tr>
                                                            <td style="width:120px;"></td>
                                                            <td colspan="4"><a href="${basePath }goodsActivity/modify.html?id=${activity.id}"><span style="font-weight:bold;" colspan="3">【活动】</span>${activity.typeName}${empty(activity.typeName)?"":"--"}${activity.name}</a></td>
                                                        </tr>
                                                    </c:forEach>
                                           		</c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                    <c:if test="${order.couponUserBean != null}">
                                        <div class="form-group col-lg-12">
                                            <label>优惠券信息</label>
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
                                                        <th>值</th>
                                                        <th>创建时间</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td>${order.couponUserBean.id }</td>
                                                        <td>${order.couponUserBean.userName }</td>
                                                        <td>${order.couponUserBean.phone }</td>
                                                        <td>${order.couponUserBean.couponName}</td>
                                                        <td>${order.couponUserBean.typeName}</td>
                                                        <td><fmt:formatDate value="${order.couponUserBean.startDate}" pattern="yyyy-MM-dd"/></td>
                                                        <td><fmt:formatDate value="${order.couponUserBean.endDate}" pattern="yyyy-MM-dd"/></td>
                                                        <td>${order.couponUserBean.status == 0?"未使用":"已使用"}</td>
                                                        <td>${order.couponUserBean.value}</td>
                                                        <td><fmt:formatDate value="${order.couponUserBean.createTime}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </c:if>
									<div class="form-group col-lg-6">
										<label>订单说明</label>
										<textarea id="explain" name="explain" class="form-control">${order.explain}</textarea>
									</div>
									<div class="form-group col-lg-6">
                                        <label>客户备注</label>
                                        <textarea id="remark" name="remark" class="form-control" readonly>${order.remark}</textarea>
                                    </div>
                                    <div class="form-group col-lg-6">
                                    	<shiro:hasPermission name="order:update">
	                                        <c:choose>
	                                        	<c:when test="${order.status==1}">
	                                    			 <button type="button" onclick="submitOrder(${order.status})" class="btn btn-success">待发货</button>
													<button type="button" onclick="cancelOrder()" class="btn btn-success">取消订单</button>
	                                    		</c:when>
	                                    		<c:when test="${order.status==2}">
	                                    			 <button type="button" onclick="submitOrder(${order.status})" class="btn btn-success">运送中</button>
	                                    		</c:when>
	                                    	</c:choose>
                                    	</shiro:hasPermission>
                                    </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </form>
    <form id="addOrderAddress" action="orderAddress.html" method="post">
    	<input type="hidden" name="userId" value="${order.userId}">
    	<input type="hidden" name="id" value="${order.id}">
    </form>
    <form id="deleteOrderAddress" action="deleteOrderAddress.html" method="post">
    	<input type="hidden" name="userId" value="${order.userId}">
        <input type="hidden" name="id" value="${order.id}">
    </form>
    <form id="deleteOrderItem" action="deleteOrderItem.html" method="post">
    	<input type="hidden" name="userId" value="${order.userId}">
        <input type="hidden" name="id" value="${order.id}">
    </form>
    <form id="cancelOrder" action="cancelOrder.html" method="post">
    	<input type="hidden" name="userId" value="${order.userId}">
        <input type="hidden" name="id" value="${order.id}">
    </form>
    <!-- /#page-wrapper -->
</div>
<%@include file="../include/footer.jsp" %>
<script type="text/javascript" src="../../../static/js/print.js"></script>
<script>
$(document).ready(function() {

});
function submitOrder(orderStatus){
	var title = '确认';
	var message = '确定要提交订单吗?';
	if(orderStatus && orderStatus == 3){
		message = '确定要完成订单吗?';
		document.forms[0].action = 'complateOrder.html';
	}else if(orderStatus && orderStatus == 1){
		message = '确定要提交订单吗?';
		document.forms[0].action = 'commitOrder.html';
	}else{
		message = '确定要保存订单吗?';
		document.forms[0].action = 'saveOrder.html';
	}
	BootstrapDialog.confirm({
		title: title,
		message:message,
		type: BootstrapDialog.TYPE_WART, // <-- Default value is BootstrapDialog.TYPE_PRIMARY
        closable: true, // <-- Default value is false
        draggable: true, // <-- Default value is false
        btnCancelLabel: '取消', // <-- Default value is 'Cancel',
        btnOKLabel: '确认', // <-- Default value is 'OK',
        btnOKClass: 'btn-warning', // <-- If you didn't specify it, dialog type will be used,
        callback: function(result) {
            if(result) {
            	document.forms[0].submit();
            }else {
            }
        }
	});
}

function cancelOrder(){
	var title = '取消订单';
	var message =  '你确认取消订单吗，一经取消不得恢复！';
	
	BootstrapDialog.confirm({
		title: title,
		message:message,
		type: BootstrapDialog.TYPE_WART, // <-- Default value is BootstrapDialog.TYPE_PRIMARY
        closable: true, // <-- Default value is false
        draggable: true, // <-- Default value is false
        btnCancelLabel: '取消', // <-- Default value is 'Cancel',
        btnOKLabel: '确认', // <-- Default value is 'OK',
        btnOKClass: 'btn-warning', // <-- If you didn't specify it, dialog type will be used,
        callback: function(result) {
            if(result) {
            	$('#cancelOrder').submit();
            }else {
            }
        }
	});
}
</script>

</body>
</html>