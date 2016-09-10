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
                       	包裹詳情
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-12">
                                    <div class="form-group col-lg-3">
                                        <label>用户姓名</label>
                                        <input name="userName" type="text" class="form-control" value="${packUserBean.userName}" disabled>
                                    </div>
                                   <div class="form-group col-lg-3">
                                        <label>用户电话</label>
                                        <input name="telephone" type="text" class="form-control" value="${packUserBean.telephone}" disabled>
                                    </div>
                                    <div class="form-group col-lg-12" style="margin-bottom: 0px">
                                        <label>待发货产品列表</label>
                                    </div>
                                    <c:if test="${packUserBean.shipAddressBeanList!=null && fn:length(packUserBean.shipAddressBeanList)>0}">
	                                    <c:forEach items="${packUserBean.shipAddressBeanList}" var="shipAddressBean">
		                                    <c:if test="${shipAddressBean.shipItemBeanList!=null && fn:length(shipAddressBean.shipItemBeanList)>0 }">
		                                    	<div class="panel-group col-lg-12" style="margin-bottom: 0px" id="d_collapse-accordion${shipAddressBean.addressId }">
												    <div class="panel panel-success" style="overflow:visible;">
												        <div class="panel-heading">
												            <h4 class="panel-title" style="position: relative;">
												                <a style="margin-right: 50px;" data-toggle="collapse" data-parent="#d_collapse-accordion${shipAddressBean.addressId }" href="#d_collapse-accordion-one${shipAddressBean.addressId}">
												                   <span style="color: red">【${shipAddressBean.aType==1?'自提':'快递' }】</span>${shipAddressBean.address}(${shipAddressBean.userName }/${shipAddressBean.telephone })
												                </a>
												                <shiro:hasPermission name="packOrder/insert">
												             		<button type="button" onclick="addPackAll('${shipAddressBean.address}',${packUserBean.userId},${shipAddressBean.addressId})" style="position:absolute;right: 5px;">添加包裹</button>
												            	</shiro:hasPermission>
												            </h4>
												        </div>
												        <div id="d_collapse-accordion-one${shipAddressBean.addressId }" class="panel-collapse collapse ">
													            <div class="panel-body" style="padding: 0px;">
													            	<div id="addressAddPack_div_${shipAddressBean.addressId}">
														            	<form id="addressAddPack_${shipAddressBean.addressId}" action="addPackAll.html" method="post">
					                                           				<input type="hidden" name="userId" value="${packUserBean.userId}">
					                                           				<input type="hidden" name="addressId" value="${shipAddressBean.addressId}">
						                                           			<input type="hidden" name="deliveryCompanyId" value="0">
					                                           				<input type="hidden" name="expressNo">
																            <table class="table table-bordered" style="margin-bottom: 0px;">
									                                        	<thead>
									                                        		<td>订单号</td><td>图片</td><td>名称</td><td>规格</td><td>样式</td><td>数量</td><td>来自</td>
									                                        	</thead>
									                                            <tbody id="multiple-table-body-${shipAddressBean.addressId }">
									                                           		<c:forEach items="${shipAddressBean.shipItemBeanList}" var="shipItemBean">
									                                           			<input type="hidden" name="shipItemIds" value="${shipItemBean.id}">
									                                           			<tr id="multiple-table-body-tr-${shipAddressBean.addressId }-${shipItemBean.id}">
										                                           			<td style="width:180px">${shipItemBean.orderId}</td>
										                                           			<td style="width:120px"><a href="${shipItemBean.image}" class="lightbox" rel="shipImage${shipItemBean.id}"><img src="${shipItemBean.image}" style="width: 20px"></a></td>
										                                           			<td><a href="/productItem/item/modify.html?id=${shipItemBean.itemId}">${shipItemBean.itemName}</a></td>
										                                           			<td style="width:140px">${shipItemBean.specName}${shipItemBean.specStartValue}${shipItemBean.specEndValue>0?'-':''}${shipItemBean.specEndValue>0?shipItemBean.specEndValue:''}</td>
										                                           			<td style="width:200px">${shipItemBean.styleName}</td>
										                                           			<td style="width:60px"><input style="width:50px" type="text" name="shipItemNums" value="${shipItemBean.number}"></td>
										                                           			<td style="width:60px">${shipItemBean.online?'线上':'线下'}</td>
										                                           			<!-- <td><button type="button" onclick="addPack()">添加包裹</button></td> -->
									                                           			</tr>
									                                           		</c:forEach>
									                                            </tbody>
									                                        </table>
								                                        </form>
							                                        </div>
						                                        </div>
												        </div>
												    </div>
												</div>
		                                    </c:if>
										</c:forEach>
									</c:if>
									<c:if test="${packUserBean.shipAddressBeanList==null || fn:length(packUserBean.shipAddressBeanList)==0}">
								    	<div class="form-group col-lg-12" style="margin-bottom: 0px;margin-top: 0px;text-align: center;width: 100%">
	                                        <SPAN style="margin-top: 0;">沒有数据</SPAN>
	                                    </div>
								    </c:if>
									<div class="form-group col-lg-12" style="margin-bottom: 0px;margin-top: 15px">
                                        <label>包裹列表</label>
                                    </div>
                                    <c:if test="${packUserBean.packBeanPage.list!=null && fn:length(packUserBean.packBeanPage.list)>0}">
	                                    <c:forEach items="${packUserBean.packBeanPage.list}" var="packBean"  varStatus="status">
		                                    	<div class="panel-group col-lg-12" style="margin-bottom: 0px" id="d_collapse-accordion${packBean.id }">
												    <div class="panel panel-success" style="overflow:visible;">
												        <div class="panel-heading">
												            <h4 class="panel-title"  style="position: relative;">
												                <a data-toggle="collapse" data-parent="#d_collapse-accordion${packBean.id  }" href="#d_collapse-accordion-one${packBean.id }">
												                   <span style="color: red">【包裹|${packBean.deliveryCompanyName}-${packBean.expressNo }】</span>${packBean.address}(${packBean.addrUser }/${packBean.addrTelephone })
												                </a>
												                <a onclick="getExpressDetail('${packBean.deliveryCompanyCode }','${packBean.expressNo }')" style="color: red;position:absolute;right: 5px;">${packBean.statusName }</a>
												            </h4>
												        </div>
												        <div id="d_collapse-accordion-one${packBean.id  }" class="panel-collapse collapse">
												            <div class="panel-body" style="padding: 0px;">
													            <table class="table table-bordered" style="margin-bottom: 0px;">
						                                        	<thead>
						                                        		<td>订单号</td><td>图片</td><td>名称</td><td>规格</td><td>样式</td><td>数量</td><td>来自</td>
						                                        	</thead>
						                                            <tbody id="multiple-table-body-${packBean.id  }">
						                                           		<c:forEach items="${packBean.packItemList}" var="packItemBean">
						                                           			<tr id="multiple-table-body-tr-${packBean.id  }-${packItemBean.id}">
							                                           			<td style="width:180px">${packItemBean.orderId}</td>
							                                           			<td style="width:120px"><a href="${packItemBean.image}" class="lightbox"><img src="${packItemBean.image}" style="width: 20px"></a></td>
							                                           			<td><a href="/productItem/item/modify.html?id=${packItemBean.itemId}">${packItemBean.itemName}</a></td>
							                                           			<td style="width:140px">${packItemBean.specName}${packItemBean.specStartValue}${packItemBean.specEndValue>0?'-':''}${packItemBean.specEndValue>0?packItemBean.specEndValue:''}</td>
							                                           			<td style="width:200px">${packItemBean.styleName}</td>
							                                           			<td style="width:60px">${packItemBean.number}</td>
							                                           			<td style="width:60px">${packItemBean.online?'线上':'线下'}</td>
						                                           			</tr>
						                                           		</c:forEach>
						                                           		<c:if test="${fn:length(packBean.packItemList) > 0 && packBean.status!=2}">
						                                           			<tr>
						                                           				<td colspan="8" style="text-align: right;"><button type="button" onclick="updateExpressNo(${packBean.id},${packBean.deliveryCompanyId},'${packBean.expressNo }')" class="btn btn-warning">修改快递</button></td>
						                                           			</tr>
						                                           		</c:if>
						                                            </tbody>
						                                        </table>
					                                        </div>
												        </div>
												    </div>
												</div>
										</c:forEach>
									    ${packUserBean.packBeanPage }
								    </c:if>
								    <c:if test="${packUserBean.packBeanPage.list==null || fn:length(packUserBean.packBeanPage.list) == 0}">
								    	<div class="form-group col-lg-12" style="margin-bottom: 0px;margin-top: 0px;text-align: center;width: 100%">
	                                        <SPAN style="margin-top: 0;">沒有數據</SPAN>
	                                    </div>
								    </c:if>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- /#page-wrapper -->
    <form id="updateExpressNo" action="updateExpressNo.html">
    	<input type="hidden" name="userId" value="${packUserBean.userId}">
    </form>
</div>
<%@include file="../include/footer.jsp" %>
<script type="text/javascript" src="../../../static/js/print.js"></script>
<script>
function addPack(){
	//alert(1);
}
function updateExpressNo(id, deliveryCompanyId, expressNo){
	var title = "修改包裹快递";
	var deliveryCompanyList = ${deliveryCompanyList};
	var select = '<select id="deliveryCompanyId" name="deliveryCompanyId">';
	select+=('<option value="0">请选择</option>');
	for(var i=0;i<deliveryCompanyList.length;i++){
		if(deliveryCompanyList[i].id == deliveryCompanyId){
			select+=('<option selected="selected" value="'+deliveryCompanyList[i].id+'">'+deliveryCompanyList[i].name+'</option>');
		}else{
			select+=('<option value="'+deliveryCompanyList[i].id+'">'+deliveryCompanyList[i].name+'</option>');
		}
		
	}
	select+=("</select>");
	var htmlContent = select+'<div><label>快递单号</label><input type="text" placeholder="请输入快递单号" value="'+expressNo+'" class="form-control" id="expressNo" name="expressNo"></div>';

	BootstrapDialog.confirm({
		title: title,
		message:htmlContent,
		type: BootstrapDialog.TYPE_WART, // <-- Default value is BootstrapDialog.TYPE_PRIMARY
        closable: true, // <-- Default value is false
        draggable: true, // <-- Default value is false
        btnCancelLabel: '取消', // <-- Default value is 'Cancel',
        btnOKLabel: '确认', // <-- Default value is 'OK',
        btnOKClass: 'btn-warning', // <-- If you didn't specify it, dialog type will be used,
        callback: function(result) {
            if(result) {
            	if($('#deliveryCompanyId').val()===0){
            		alert('请选择快递公司');
            		return false;
            	}
            	if($('#expressNo').val()===''){
            		alert('请输入快递单号');
            		return false;
            	}
            	$("#updateExpressNo").append("<input type='hidden' name='id' value='"+id+"'>"+
            			"<input type='hidden' name='deliveryCompanyId' value='"+$('#deliveryCompanyId').val()+"'>"+
            			"<input type='hidden' name='expressNo' value='"+$('#expressNo').val()+"'>");
            	$("#updateExpressNo").submit();
            }else {
            }
        }
	});
}
function addPackAll(address,userId,addressId){
	var title = "添加包裹";
	var deliveryCompanyList = ${deliveryCompanyList};
	var select = '<select id="deliveryCompanyId" name="deliveryCompanyId">';
	select+=('<option value="0">请选择</option>');
	for(var i=0;i<deliveryCompanyList.length;i++){
		select+=('<option value="'+deliveryCompanyList[i].id+'">'+deliveryCompanyList[i].name+'</option>');
	}
	select+=("</select>");
	var htmlContent = '确定将【'+address+'】添加包裹？<br>'+
					select+' <input type="input" id="expressNo" name="expressNo" placeholder="请输入快递单号">';
	BootstrapDialog.confirm({
		title: title,
		message:htmlContent,
		type: BootstrapDialog.TYPE_WART, // <-- Default value is BootstrapDialog.TYPE_PRIMARY
        closable: true, // <-- Default value is false
        draggable: true, // <-- Default value is false
        btnCancelLabel: '取消', // <-- Default value is 'Cancel',
        btnOKLabel: '确认', // <-- Default value is 'OK',
        btnOKClass: 'btn-warning', // <-- If you didn't specify it, dialog type will be used,
        callback: function(result) {
            if(result) {
            	if($('#deliveryCompanyId').val()===0){
            		alert('请选择快递公司');
            		return false;
            	}
            	if($('#expressNo').val()===''){
            		alert('请输入快递单号');
            		return false;
            	}
            	$("#addressAddPack_div_"+addressId).find("input[name='deliveryCompanyId']").val($('#deliveryCompanyId').val());
            	$("#addressAddPack_div_"+addressId).find("input[name='expressNo']").val($('#expressNo').val());
            	$("#addressAddPack_"+addressId).submit();
            }else {
            }
        }
	});
}
function getExpressDetail(deliveryCompanyCode,expressNo){
	var data = {"company":deliveryCompanyCode,"expressNo":expressNo};
	$.ajax({url:"getExpressDetail.html",
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