<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../include/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="description" content="">
    <meta name="author" content="">

    <title>审核订单 - ${site.title}</title>
    <%@include file="../include/head.jsp" %>
    <link href="/static/css/form.css" rel="stylesheet">
    <script src="/static/libs/ckeditor/ckeditor.js"></script>
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
                                    <div class="form-group col-lg-3">
                                        <label>订单编号</label>
                                        <input name="id" type="text" class="form-control" value="${order.orderId}" readonly="readonly">
                                    </div>
                                    <div class="form-group col-lg-3">
                                        <label>用户姓名</label>
                                        <input type="text" class="form-control" value="${order.userName}"
                                               disabled>
                                    </div>
                                    <div class="form-group col-lg-3">
                                        <label>用户电话</label>
                                        <input type="text" class="form-control" value="${order.telephone}"
                                               disabled>
                                    </div>
                                    <div class="form-group col-lg-3">
                                        <label>订单状态</label>
                                        <input type="hidden" name="orderStatus" class="form-control" value="${order.orderStatus}" readonly="readonly">
                                        <input type="text" name="orderStatusName" class="form-control" value="${order.orderStatus>=4?'已完成':order.orderStatusName}" disabled>
                                    </div>
                                    <div class="form-group col-lg-12">
                                        <label>下单备注</label>
                                        <textarea class="form-control" name="remark" readonly="readonly">${order.remark}</textarea>
                                    </div>
                                    <div class="form-group has-warning col-lg-3">
                                        <label>原料重量</label>
                                        <div class="input-group">
                                            <input name="goldWeight" type="text" class="form-control" value="${order.goldWeight}">
                                            <div class="input-group-addon">g</div>
                                        </div>
                                    </div>
                                    <div class="form-group has-warning col-lg-3">
                                        <label>总工费</label>
                                        <input name="fee" type="text" class="form-control" value="${order.fee}">
                                    </div>
                                    <div class="form-group has-warning col-lg-3">
                                        <label>总价格</label>
                                        <input name="money" type="text" class="form-control" value="${order.money}">
                                    </div>
                                    
                                    <c:if test="${fn:length(order.orderImageList)>0}">
                                    <div class="form-group col-lg-12">
                                        <label>购买的图片列表</label>
                                        <div class="row col-lg-12">
                                        	<c:forEach items="${order.orderImageList}" var="orderImage">
                                        		<a href="${orderImage.image}" class="lightbox" rel="orderImage"><img src="${orderImage.image}" style="width: 120px" ></a> 
                                        	</c:forEach>
                                        </div>
                                    </div>
                                    </c:if>
                                    <div class="form-group col-lg-12">
                                        <label>购买的产品列表</label>
                                        <table class="table table-bordered" style="margin-bottom: 0px;">
                                        	<thead>
                                        		<td>图片</td><td>名称</td><td>规格</td><td>样式</td><td>工费</td><td>数量</td><td>来自</td>
                                        		<c:if test="${order.orderStatus<3}">
                                        		<td>操作</td>
                                        		</c:if>
                                        	</thead>
                                            <tbody>
                                           		<c:forEach items="${order.orderItemBeanList}" var="orderItemBean">
                                           			<tr>
	                                           			<td style="width:120px"><a href="${orderItemBean.image}" class="lightbox" rel="orderItem${orderItemBean.itemId}"><img src="${orderItemBean.image}" style="width: 20px"></a></td>
	                                           			<td><a href="/productItem/item/modify.html?id=${orderItemBean.itemId}">${orderItemBean.name}</a></td>
	                                           			<td style="width:140px">${orderItemBean.specName}${orderItemBean.specStartValue}${orderItemBean.specEndValue>0?'-':''}${orderItemBean.specEndValue>0?orderItemBean.specEndValue:''}</td>
	                                           			<td style="width:200px">${orderItemBean.styleName}</td>
	                                           			<td style="width:140px">${orderItemBean.fee}</td>
	                                           			<td style="width:60px">${orderItemBean.number}</td>
	                                           			<td style="width:60px">${orderItemBean.online?'线上':'线下'}</td>
	                                           			<c:if test="${order.orderStatus<3}">
	                                           			<td style="width:60px"><a onclick="deleteOrderItem(${orderItemBean.id})">删除</a></td>
	                                           			</c:if>
                                           			</tr>
                                           		</c:forEach>
                                            </tbody>
                                        </table>
                                        <shiro:hasPermission name="order/update">
                                        <a class="btn btn-warning" href="addItem.html?orderId=${order.orderId}&type=1">添加单品</a>
                                        </shiro:hasPermission>
                                    </div>
									<c:forEach items="${order.orderAddressBeanList}" var="addressBean">
									<input type="hidden" name="orderAddressIds" value="${addressBean.id }">
									<div class="panel-group col-lg-12" id="collapse-accordion${addressBean.id }" style="margin-bottom:0px;">
									    <div class="panel panel-success" style="overflow:visible;">
									        <div class="panel-heading">
									            <h4 class="panel-title" style="position: relative;">
									                <a data-toggle="collapse" data-parent="#collapse-accordion${addressBean.id }" href="#collapse-accordion-one${addressBean.id }">
									                   <span style="color: red">【${addressBean.type==1?'自提':'快递' }】</span>${addressBean.path }${addressBean.detail }(${addressBean.userName }/${addressBean.telephone })
									                </a>
									                <shiro:hasPermission name="order/update">
										                <c:if test="${order.orderStatus<3}">
										                	<button type="button" onclick="deleteAddress(${addressBean.id })" style="position:absolute;right: 5px;">删除地址</button>
										            	</c:if>
									            	</shiro:hasPermission>
									            </h4>
									        </div>
									        <div id="collapse-accordion-one${addressBean.id }" class="panel-collapse collapse">
									            <div class="panel-body">
									                 <select id="multiple-selected-${addressBean.id}" multiple="multiple">
									                 		<optgroup label="选择所有" class="group-1">
														    <c:forEach items="${order.orderItemBeanList}" var="orderItemBean">
														    	 <option value="${orderItemBean.id}" data-order-address="${addressBean.id}">${orderItemBean.name }|
														    	 (${orderItemBean.styleName}
														    	 /${orderItemBean.specName}${orderItemBean.specStartValue}
														    	 /${orderItemBean.number})</option>
														    </c:forEach>
														    </optgroup>
													</select>
									            </div>
									            <div class="panel-body">
										            <table class="table table-bordered" >
			                                        	<thead>
			                                        		<td>图片</td><td>名称</td><td>规格</td><td>样式</td><td>数量</td><td>来自</td>
			                                        	</thead>
			                                            <tbody id="multiple-table-body-${addressBean.id }">
			                                           		<c:forEach items="${addressBean.orderItemBeanList}" var="orderItemBean">
			                                           			<tr id="multiple-table-body-tr-${addressBean.id }-${orderItemBean.id}">
				                                           			<td  style="width:120px"><input type="hidden" name="orderItemId_${addressBean.id }" value="${orderItemBean.id}">
				                                           				<a href="${orderItemBean.image}" class="lightbox" rel="orderItemId_${orderItemBean.itemId}"><img src="${orderItemBean.image}" style="width: 20px"></a></td>
				                                           			<td><a href="/productItem/item/modify.html?id=${orderItemBean.itemId}">${orderItemBean.name}</a></td>
				                                           			<td style="width:140px">${orderItemBean.specName}${orderItemBean.specStartValue}${orderItemBean.specEndValue>0?'-':''}${orderItemBean.specEndValue>0?orderItemBean.specEndValue:''}</td>
				                                           			<td style="width:200px">${orderItemBean.styleName}</td>
				                                           			<td style="width:60px"><input style="width:50px" type="text" name="orderItemNum_${addressBean.id }_${orderItemBean.id}" value="${orderItemBean.anumber}"></td>
				                                           			<td style="width:60px">${orderItemBean.online?'线上':'线下'}</td>
			                                           			</tr>
			                                           		</c:forEach>
			                                            </tbody>
			                                        </table>
		                                        </div>
									        </div>
									    </div>
									</div>
									</c:forEach>
									<div class="form-group col-lg-12">
										<shiro:hasPermission name="order/update">
											<c:if test="${order.orderStatus<3}">
												<button type="button" class="btn btn-warning" onclick="addAddress()">添加地址</button>
	                                    	</c:if>
                                    	</shiro:hasPermission>
									</div>
									<div class="form-group col-lg-12">
                                        <label>订单说明</label>
                                        <textarea id="illustrate" name="illustrate" class="form-control">${order.illustrate}</textarea>
                                    </div>
                                    <div class="form-group col-lg-12">
                                    	<label>订单支付指引</label>
                                        
                                        <input type="hidden" name="payFileName" value="支付指引">
                                        <input type="text" class="form-control" id="payFilePath" name="payFilePath" value="${order.payFilePath}">
                                        <input type="hidden" id="payFileSize" name="payFileSize" value="${order.payFileSize}">
                                        <input onchange="fileUpload(this)" type="file">
                                    </div>
                                    <div class="form-group col-lg-6">
                                    	<shiro:hasPermission name="order/update">
	                                        <c:choose>
	                                        	<c:when test="${order.orderStatus==1}">
	                                        	 	 <button type="button" onclick="submitOrder(0)" class="btn btn-success">保存编辑</button>
	                                    			 <button type="button" onclick="submitOrder(${order.orderStatus})" class="btn btn-success">确认订单</button>
	                                    		</c:when>
	                                    		<c:when test="${order.orderStatus==3}">
	                                    			 <button type="button" onclick="submitOrder(${order.orderStatus})" class="btn btn-success">完成订单</button>
	                                    		</c:when>
	                                    		<c:when test="${order.orderStatus==4}">
	                                    		</c:when>
	                                    		<c:otherwise>
	                                    			 <button type="button" onclick="submitOrder(${order.orderStatus})" class="btn btn-success">提交订单</button>
	                                    		</c:otherwise>
	                                    	</c:choose>
	                                    	<c:if test="${order.orderStatus<4}">
	                                    			 <button type="button" onclick="cancelOrder()" class="btn btn-success">取消订单</button>
	                                    	</c:if>
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
    	<input type="hidden" name="orderId" value="${order.orderId}">
    </form>
    <form id="deleteOrderAddress" action="deleteOrderAddress.html" method="post">
    	<input type="hidden" name="userId" value="${order.userId}">
    	<input type="hidden" name="orderId" value="${order.orderId}">
    </form>
    <form id="deleteOrderItem" action="deleteOrderItem.html" method="post">
    	<input type="hidden" name="userId" value="${order.userId}">
    	<input type="hidden" name="orderId" value="${order.orderId}">
    </form>
    <form id="cancelOrder" action="cancelOrder.html" method="post">
    	<input type="hidden" name="userId" value="${order.userId}">
    	<input type="hidden" name="id" value="${order.orderId}">
    </form>
    <!-- /#page-wrapper -->
</div>
<%@include file="../include/footer.jsp" %>
<script type="text/javascript" src="../../../static/js/print.js"></script>
<script>
$(document).ready(function() {
	var orderAddressBeans = ${order.orderAddressBeanList};
	var orderItemBeans = ${order.orderItemBeanList};
	for(var i=0;i<orderAddressBeans.length;i++){
		$('#multiple-selected-'+orderAddressBeans[i].id).multiselect({
			  enableClickableOptGroups: true,
	          enableCollapsibleOptGroups: true,
	          enableFiltering: true,
	          //includeSelectAllOption: true,
	          buttonWidth: '50%',/* 宽度 */
	          maxHeight: 400,/* 最高高度，高出最搞下拉滑动 */
	          dropLeft: true,/*下拉位置 */
	          numberDisplayed: 5,/*框内显示选中项  */
	          delimiterText: ';',/*框内选中项分隔符  */
	          optionClass: function(element) {//选项样式
	             /*  var value = $(element).val();
	              if (value%2 == 0) {
	                  return 'even';
	              }
	              else {
	                  return 'odd';
	              } */
	          },
		      onChange: function(options, checked) {
		    	   /* $(option).val()  */
		           //alert(option.length + ' options ' + (checked ? 'selected' : 'deselected'));
		    	   for(var indx=0; indx<options.length; indx++){
		    		   var opt = options[indx];
		    		   if(!checked){//取消选择
			    		  deleteOrderAddressItem($(opt).attr('data-order-address'),$(opt).val());//删除关联
			    	   }else{//添加data-tag
			    		  addOrderAddressItem($(opt).attr('data-order-address'),$(opt).val());
			    	   }
		    	   }
		    	  
		    	   
		      },
		      onDropdownShow: function(event) {//显示事件
	          },
	          onDropdownHide: function(event) {//隐藏事件
	          },
	          buttonText: function(options, select) {
	              if (options.length === 0) {
	                  return '请选择地址对应单品';
	              }
	              else {
	                   var labels = [];
	                   options.each(function() {
	                       if ($(this).attr('label') !== undefined) {
	                           labels.push($(this).attr('label'));
	                       }
	                       else {
	                    	   var html = $(this).html();
	                    	   html = html.split('|')[0];
	                           labels.push(html);
	                       }
	                   });
	                   return labels.join('; ') + '';
	               }
	          }
	    });
		var ids = [];
		var otherOrderItemBeans  = orderAddressBeans[i].orderItemBeanList;
		for(var j=0;orderAddressBeans[i].orderItemBeanList && j<otherOrderItemBeans.length;j++){
			ids.push(otherOrderItemBeans[j].id);
		}
		$('#multiple-selected-'+orderAddressBeans[i].id).val(ids);
		$('#multiple-selected-'+orderAddressBeans[i].id).multiselect("refresh");
	}

	function addOrderAddressItem(orderAddressId,orderItemId){
		var tr = $('#multiple-table-body-tr-'+orderAddressId+'-'+orderItemId);
		if(!tr || tr.length==0){
			var orderItem={};
			for(var i=0; i<orderItemBeans.length; i++){
				if(orderItemBeans[i].id == orderItemId){
					orderItem = orderItemBeans[i];
					break;
				}
			}
			var html='<tr id="multiple-table-body-tr-'+orderAddressId+'-'+orderItemId+'">'+
			   			'<td><input type="hidden" name="orderItemId_'+orderAddressId+'" value="'+orderItemId+'">'+
							'<a href="'+orderItem.image+'" class="lightbox" rel="orderItemId_'+orderItemId+'"><img src="'+orderItem.image+'" style="width: 20px"></a></td>'+
						'<td>'+orderItem.name+'</td>'+
						'<td>'+(orderItem.specName+orderItem.specStartValue.toFixed(2)+(orderItem.specEndValue>0?('-'+orderItem.specEndValue.toFixed(2)):''))+'</td>'+
						'<td>'+(orderItem.styleName!='null'?orderItem.styleName:'')+'</td>'+
						'<td><input type="text" name="orderItemNum_'+orderAddressId+'_'+orderItemId+'" value="'+orderItem.number+'"></td>'+
						'<td>'+(orderItem.online=='true'?"线上":"线下")+'</td>'+
					'</tr>'
			$('#multiple-table-body-'+orderAddressId).append(html);
			
			lightbox();
		}
	}
	function deleteOrderAddressItem(orderAddressId,orderItemId){
		var tr = $('#multiple-table-body-tr-'+orderAddressId+'-'+orderItemId);
		if(tr){
			tr.remove();
		}
	}
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
function addAddress(){
	var addressList = ${addressList};
	var orderAddressBeans = ${order.orderAddressBeanList};
	
	var options = '';
	for(var i=0;i < addressList.length;i++){
		var tag = false;
		for(var j=0; j<orderAddressBeans.length;j++){
			if(addressList[i].id == orderAddressBeans[j].addressId){
				tag=true;
			}
		}
		if(!tag){
			options+='<option value="'+addressList[i].id+'" data-order-address="${addressBean.id}">'+'['+(addressList[i].type==1?'自提':'快递')+']'+addressList[i].path+' '+addressList[i].detail+'('+addressList[i].userName+'/'+addressList[i].telephone+')'+'</option>';
		}
	}
	var title = '添加地址';
	var message =  '<select id="multiple-selected-address" multiple="multiple" style="width:100%;height:200px">'+
					 	'<optgroup label="请选择" class="group-1">'+
					    	options+
					    '</optgroup>'+
					'</select>';
	
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
            	var orderAddressHtml = '';
            	for(var i = 0; i<addressIds.length; i++){
            		orderAddressHtml+='<input type="hidden" name="addressIds" value="'+addressIds[i]+'">'
            	}
            	$('#addOrderAddress').append(orderAddressHtml);
            	$('#addOrderAddress').submit();
            }else {
            }
        }
	});
}
function deleteAddress(addressId){
	

	var title = '删除地址';
	var message =  '你确认删除地址吗？';
	
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
            	
            	var orderAddressHtml = orderAddressHtml+='<input type="hidden" name="addressId" value="'+addressId+'">'
            	$('#deleteOrderAddress').append(orderAddressHtml);
            	$('#deleteOrderAddress').submit();
            }else {
            }
        }
	});
}

function deleteOrderItem(itemId){
	var title = '删除单品';
	var message =  '你确认删除单品吗？';
	
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
            	
            	var orderAddressHtml = orderAddressHtml+='<input type="hidden" name="itemId" value="'+itemId+'">'
            	$('#deleteOrderItem').append(orderAddressHtml);
            	$('#deleteOrderItem').submit();
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

function fileUpload(self){

	var url = "/upload/uploadFile.html";
    var data = new FormData();
    $.each($(self)[0].files, function (i, file) {
        data.append('file', file);
    });
    $.ajax({
        type: "POST",
        url: url,
        timeout: 400000,
        data: data,
        cache: false,
        contentType: false,
        processData: false,
        success: function (result) {
            result = JSON.parse(result);
            if (result.ResultInt == 0) {
               console.log(result);
               $('#payFileSize').val(result.result.size);
               $('#payFilePath').val(result.result.url);
            } else {
                alert(result.ResultString);
            }
        },
        error: function (xhr, errmsg) {
            console.log("ajax-err-[]->" + JSON.stringify(errmsg) + "|" + xhr);
            alert('error');
        },
        beforeSend: function (xhr) {

        },
    });
}

</script>

</body>
</html>