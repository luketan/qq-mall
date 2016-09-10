<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../include/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="description" content="">
    <meta name="author" content="">

    <title>待发货详情 - ${site.title}</title>
    <%@include file="../include/head.jsp" %>
    <link href="/static/css/form.css" rel="stylesheet">
    <script src="/static/libs/ckeditor/ckeditor.js"></script>
	
</head>

<body>
<div id="wrapper">
    <!-- Navigation -->
    <%@include file="../include/nav.jsp" %>
    <div id="page-wrapper">
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                       	 待发货
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-12">
                                    <div class="form-group col-lg-3">
                                        <label>用户姓名</label>
                                        <input name="id" type="text" class="form-control" value="${userData.userName}" disabled>
                                    </div>
                                   <div class="form-group col-lg-3">
                                        <label>用户电话</label>
                                        <input name="id" type="text" class="form-control" value="${userData.telephone}" disabled>
                                    </div>
                                    <div class="form-group col-lg-12" style="margin-bottom: 0px">
                                        <label>待发货产品列表</label>
                                    </div>
                                    <c:forEach items="${shipAddressBeanList}" var="shipAddressBean">
	                                    <c:if test="${shipAddressBean.shipItemBeanList!=null && fn:length(shipAddressBean.shipItemBeanList)>0 }">
	                                    	<div class="panel-group col-lg-12" style="margin-bottom: 0px" id="d_collapse-accordion${shipAddressBean.addressId }">
											    <div class="panel panel-success" style="overflow:visible;">
											        <div class="panel-heading">
											            <h4 class="panel-title" style="position: relative;">
											                <a data-toggle="collapse" data-parent="#d_collapse-accordion${shipAddressBean.addressId }" href="#d_collapse-accordion-one${shipAddressBean.addressId}">
											                   <span style="color: red">【${shipAddressBean.aType==1?'自提':'快递' }】</span>${shipAddressBean.address}(${shipAddressBean.userName }/${shipAddressBean.telephone })
											                </a>
											                <shiro:hasPermission name="shipOrder/update">
											                	<a onclick="addItem(${shipAddressBean.addressId })" style="position:absolute;right: 5px;">添加单品</a>
											                </shiro:hasPermission>
											            </h4>
											        </div>
											        <div id="d_collapse-accordion-one${shipAddressBean.addressId }" class="panel-collapse collapse">
											        	<form action="updateShipList.html?userId=${userData.id }" method="post">
											            <div class="panel-body" style="padding: 0px;">
												            <table class="table table-bordered" style="margin-bottom: 0px;">
					                                        	<thead>
					                                        		<td>图片</td><td>订单号</td><td>名称</td><td>规格</td><td>样式</td><td>数量</td><td>来自</td><td>操作</td>
					                                        	</thead>
					                                            <tbody id="multiple-table-body-${shipAddressBean.addressId }">
					                                           		<c:forEach items="${shipAddressBean.shipItemBeanList}" var="shipItemBean">
					                                           			<tr id="multiple-table-body-tr-${shipAddressBean.addressId }-${shipItemBean.id}">
						                                           			<td style="width:120px"><input type="hidden" name="id" value="${shipItemBean.id }"><a href="${shipItemBean.image}" class="lightbox" rel="shipItemImage${shipItemBean.id }"><img src="${shipItemBean.image}" style="width: 20px"></a></td>
						                                           			<td style="width:180px"><input type="text" name="orderId" value="${shipItemBean.orderId}" ${shipItemBean.online?'readonly="readonly"':''}></td>
						                                           			<td><a href="/productItem/item/modify.html?id=${shipItemBean.itemId}">${shipItemBean.itemName}</a></td>
						                                           			<td style="width:140px">${shipItemBean.specName}${shipItemBean.specStartValue}${shipItemBean.specEndValue>0?'-':''}${shipItemBean.specEndValue>0?shipItemBean.specEndValue:''}</td>
						                                           			<td style="width:200px">${shipItemBean.styleName}</td>
						                                           			<td style="width:60px"><input type="text" style="width:50px" name="number" value="${shipItemBean.number}"></td>
						                                           			<td style="width:60px">${shipItemBean.online?'线上':'线下'}</td>
						                                           			<td style="width:60px">
						                                           				<shiro:hasPermission name="shipOrder/delete">
						                                           				<c:choose>
						                                           					<c:when test="${shipItemBean.online}">
						                                           						<button type="button" class="btn btn-warning disabled" >删除</button></td>
						                                           					</c:when>
						                                           					<c:otherwise>
						                                           						<a href="deleteShip.html?id=${shipItemBean.id }&userId=${userData.id}" class="btn btn-warning " >删除</a>
						                                           					</c:otherwise>
						                                           				</c:choose>
						                                           				</shiro:hasPermission>
					                                           			</tr>
					                                           		</c:forEach>
					                                           		<c:if test="${fn:length(shipAddressBean.shipItemBeanList) > 0}">
					                                           			<tr>
					                                           				<td colspan="8" style="text-align: right;">
					                                           					<shiro:hasPermission name="shipOrder/update">
					                                           						<button type="button" onclick="updateShip(this.form)" class="btn btn-warning">保存</button>
					                                           					</shiro:hasPermission>
					                                           				</td>
					                                           			</tr>
					                                           		</c:if>
					                                            </tbody>
					                                        </table>
				                                        </div>
				                                        </form>
											        </div>
											    </div>
											</div>
	                                    </c:if>
									</c:forEach>
									<div class="form-group col-lg-12">
										<shiro:hasPermission name="shipOrder/insert">
											<button type="button" class="btn btn-warning" onclick="addAddress()">添加地址</button>
										</shiro:hasPermission>
									</div>
									<div class="form-group col-lg-12" style="margin-bottom: 0px;margin-top: 15px">
                                        <label>订单已完成产品列表</label>
                                    </div>
                                    <c:forEach items="${shipAddressBeanList}" var="shipAddressBean">
	                                    <c:if test="${shipAddressBean.orderComplateItemBeanList!=null && fn:length(shipAddressBean.orderComplateItemBeanList)>0 }">
	                                    	<div class="panel-group col-lg-12" style="margin-bottom: 0px" id="o_collapse-accordion${shipAddressBean.addressId }">
											    <div class="panel panel-success" style="overflow:visible;">
											        <div class="panel-heading">
											            <h4 class="panel-title">
											                <a data-toggle="collapse" data-parent="#o_collapse-accordion${shipAddressBean.addressId }" href="#o_collapse-accordion-one${shipAddressBean.addressId}">
											                   <span style="color: red">【${shipAddressBean.aType==1?'自提':'快递' }】</span>${shipAddressBean.address}(${shipAddressBean.userName }/${shipAddressBean.telephone })
											                </a>
											            </h4>
											        </div>
											        <div id="o_collapse-accordion-one${shipAddressBean.addressId }" class="panel-collapse collapse">
											            <div class="panel-body" style="padding: 0px;">
												            <table class="table table-bordered" style="margin-bottom: 0px;">
					                                        	<thead>
					                                        		<td>图片</td><td>订单号</td><td>名称</td><td>规格</td><td>样式</td><td>数量</td><td>来自</td><td>操作</td>
					                                        	</thead>
					                                            <tbody id="multiple-table-body-${shipAddressBean.addressId }">
					                                           		<c:forEach items="${shipAddressBean.orderComplateItemBeanList}" var="shipItemBean">
					                                           			<tr id="multiple-table-body-tr-${shipAddressBean.addressId }-${shipItemBean.id}">
						                                           			<td style="width:120px"><a href="${shipItemBean.image}" class="lightbox" rel="orderImage${shipItemBean.id }"><img src="${shipItemBean.image}" style="width:20px"></a></td>
						                                           			<td style="width:180px"><input type="text" name="orderId" value="${shipItemBean.orderId}" ${shipItemBean.online?'readonly="readonly"':''}></td>
						                                           			<td ><a href="/productItem/item/modify.html?id=${shipItemBean.itemId}">${shipItemBean.itemName}</a></td>
						                                           			<td style="width:140px">${shipItemBean.specName}${shipItemBean.specStartValue}${shipItemBean.specEndValue>0?'-':''}${shipItemBean.specEndValue>0?shipItemBean.specEndValue:''}</td>
						                                           			<td style="width:200px">${shipItemBean.styleName}</td>
						                                           			<td style="width:60px"><input style="width:50px" type="text" name="orderItemNum_${shipAddressBean.addressId }_${shipItemBean.id}" value="${shipItemBean.number}"></td>
						                                           			<td style="width:60px">${shipItemBean.online?'线上':'线下'}</td>
						                                           			<td style="width:88px;">
							                                           			<shiro:hasPermission name="shipOrder/insert">
							                                           			<a onclick='addship(this,"addShip.html?shipItemId=${shipItemBean.id}&userId=${userData.id}")' href="#">添加待发货</a>
							                                           			</shiro:hasPermission>
						                                           			</td>
					                                           			</tr>
					                                           		</c:forEach>
					                                            </tbody>
					                                        </table>
				                                        </div>
											        </div>
											    </div>
											</div>
	                                    </c:if>
									</c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <form id="addShipAddress" action="" method="post">
    </form>
    <!-- /#page-wrapper -->
</div>
<%@include file="../include/footer.jsp" %>
<script type="text/javascript" src="../../../static/js/print.js"></script>
<script>
function addship(obj,url){
	var num = $($(obj).parent().parent().find("input")[1]).val();
	window.location.href=url+"&num="+num;
}
function addItem(address){
	var title = '添加单品';
	var message =  '<div><label>订单号</label><input type="text" placeholder="请输入订单号（没有可以不用输入）" class="form-control" id="add-item-order-no"></div>';
	
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
            	window.location.href = "addItem.html?orderId="+$('#add-item-order-no').val()+"&type=2&addressId="+address+"&userId=${userData.id}";
            }else {
            }
        }
	});
}
function addAddress(){
	var addressList = ${addressList};
	var shipAddressBeanList = ${shipAddressBeanList};
	
	var options = '';
	for(var i=0;i < addressList.length;i++){
		var tag = false;
		for(var j=0; j<shipAddressBeanList.length;j++){
			
			if(shipAddressBeanList[j].shipItemBeanList.length>0 && addressList[i].id == shipAddressBeanList[j].addressId){
				tag=true;
			}
		}
		if(!tag && addressList[i].type==2){
			options+='<option value="'+addressList[i].id+'" data-order-address="${addressBean.id}">'+'['+(addressList[i].type==1?'自提':'快递')+']'+addressList[i].path+' '+addressList[i].detail+'('+addressList[i].userName+'/'+addressList[i].telephone+')'+'</option>';
		}
	}
	if(!options){
		options = "<option disabled='disabled'>没有可选的快递地址</option>";
	}
	var title = '添加地址';
	var message =  '<select id="multiple-selected-address" multiple="multiple" style="width:100%;height:200px">'+
					 	'<optgroup label="请选择" class="group-1">'+
					    	options+
					    '</optgroup>'+
					'</select>'+
					'<div><label>订单号</label><input type="text" placeholder="请输入订单号（没有可以不用输入）" class="form-control" id="order-no"></div>';
	
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
            	var addressIds = $('#multiple-selected-address').val();
            	if(!addressIds || addressIds.length<0)
            		return;
            	/* var orderAddressHtml = '';
            	for(var i = 0; i<addressIds.length; i++){
            		orderAddressHtml+='<input type="hidden" name="addressIds" value="'+addressIds[i]+'">'
            	}
            	$('#addShipAddress').append(orderAddressHtml);
            	$('#addShipAddress').submit(); */
            	
            	window.location.href = "addItem.html?orderId="+$('#order-no').val()+"&type=2&addressId="+addressIds+"&userId=${userData.id}";
            }else {
            }
        }
	});
}
function updateShip(from){
	var title = '修改列表';
	var message =  '你确定修改吗？';
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
            	from.submit();
            }else {
            }
        }
	});
}
</script>
</body>
</html>