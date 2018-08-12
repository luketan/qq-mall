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
                                        <select id="postId" name="postId" class="form-control" ${WaitShip == order.status?"":"disabled"}>
                                            <option value="">请选择</option>
                                            <c:forEach items="${postCompanyList}" var="postCompany">
                                                <option ${order.postId == postCompany.id?'selected':''} value="${postCompany.id}">${postCompany.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group col-lg-3">
                                        <label>快递编号
                                            <c:if test="${order.postId > 0 && !empty order.postCode}">
                                                <span onclick="getPostDetail(${order.postId}, '${order.postCode}')" style="color: #2aabd2">查看快递</span>
                                            </c:if>
                                        </label>
                                        <input  id="postCode" name="postCode" type="text" class="form-control" value="${order.postCode}" ${WaitShip == order.status?"":"disabled"}>
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
	                                        	<c:when test="${order.status==waitPayment}">
													<button type="button" onclick="cancelOrder()" class="btn btn-success">取消订单</button>
                                                    <button type="button" onclick="updateOrder()" class="btn btn-success">修改订单</button>
	                                    		</c:when>
	                                    		<c:when test="${order.status==WaitShip}">
	                                    			 <button type="button" onclick="shipOrder()" class="btn btn-success">发货</button>
	                                    		</c:when>
                                                <c:when test="${order.status==Send}">
                                                    <button type="button" onclick="complateOrder()" class="btn btn-success">完成</button>
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
    <!-- /#page-wrapper -->
</div>
<%@include file="../include/footer.jsp" %>
<script type="text/javascript" src="${basePath }/static/js/print.js"></script>
<script>
$(document).ready(function() {

});
function updateOrder(){
	var title = '确认';
	var message = '确定要修改订单吗?';
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
                document.forms[0].action = 'updateOrder.html';
            	document.forms[0].submit();
            }else {
            }
        }
	});
}

function complateOrder(){
    var title = '取消订单';
    var message =  '你确认完成订单吗，一经完成不得取消！';

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
                document.forms[0].action = 'completeOrder.html';
                document.forms[0].submit();
            }else {
            }
        }
    });
}

function shipOrder(){
    var postCode = $("#postCode").val();
    var postId = $("#postId").val();

    if(!postId){
        alert('请选择快递公司！');
        return;
    }
    if(!postCode){
        alert('快递单号不能为空');
        return;
    }
    var title = '取消订单';
    var message =  '你确认发货吗，一经发货不得取消！';

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
                document.forms[0].action = 'shipOrder.html';
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
                document.forms[0].action = 'cancelOrder.html';
                document.forms[0].submit();
            }else {
            }
        }
	});
}
function getPostDetail(companyId, postCode){
    var data = {"companyId":companyId, "postCode":postCode};
    $.ajax({url:"getPostDetail.html",
        type:"post",
        data:JSON.stringify(data),
        dataType: "json",
        contentType: "application/json",
        success:function(result){
            var title = "快递跟踪";
            var htmlContent = '<ul>';
            if(result.result.length<=0){
                htmlContent+="<li>"+result.msg+"</li>";
            }else{
                for(var i=0; i<result.result.length; i++){
                    var expDate = new Date(result.result[i].timeNode);
                    var expTime = expDate.getFullYear()+"-"+(expDate.getMonth()+1)+"-"+expDate.getDate()+" "+expDate.getHours()+":"+expDate.getMinutes()+":"+expDate.getSeconds();
                    htmlContent+="<li>["+expTime+"]"+result.result[i].context+"</li>";
                }
            }
            htmlContent += '</ul>';
            BootstrapDialog.show({
                title: title,
                message: htmlContent
            });
        },
        error:function(xhr,status,error){
            alert(xhr);
        }
    });

}
</script>

</body>
</html>