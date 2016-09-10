<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../include/taglib.jsp"%>
<!DOCTYPE html>
<html lang="cn">
<head>
    <meta name="desc" content="">
    <meta name="author" content="">
    <title>待发货列表 - ${site.title}</title>
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
                     	   待发货列表
                     	 <form id="inputForm" action="/shipOrder/shipList.html" method="post" class="row">
                            <div class="col-lg-12 form-inline pull-left">
                            	<input name="key" type="text" class="form-control input-sm" value="${key}" placeholder="输入用户名/电话号码关键字查询">
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <button type="button" class="btn btn-warning" onclick="submitSearch()">查询</button>
                                <button type="button" class="btn btn-primary" onclick="exportShipOrder()">导出</button>
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
                                    <th class="col-lg-2">已完成数量</th>
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
                                                <td class="col-lg-2">${item.orderComplateNum==null?0:item.orderComplateNum}</td>
                                                <td class="col-lg-1"><a href="shipDetail.html?userId=${item.userId}">查看详情</a></td>
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
                        <div class="form-group col-lg-12" style="margin-bottom:0px;padding-left:0px">
                      		<shiro:hasPermission name="shipOrder/insert">
								<button type="button" class="btn btn-warning" onclick="addUser()">添加待发货</button>
							</shiro:hasPermission>
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
    $("#inputForm").attr("action","/shipOrder/shipList.html");
    $("#inputForm").submit();
}
function exportShipOrder() {
    $("#inputForm").attr("action","/shipOrder/export.html");
    $("#inputForm").submit();
}
function searchUser(){
	var url = "/user/searchPhone.html";
	var phone = $("#searchPhone").val();
	var data = {"phone":phone};
    $.ajax({
        type: "POST",
        url: url,
        timeout: 400000,
        data:data,  
        dataType: "json",
        success: function (result) {
            if (result.ResultInt == 0) {
            	console.log("fileload_ajax-suc-[]->" + JSON.stringify(result));
            	var html="<option value='"+result.result.user.id+"'>"+result.result.user.userName+"/"+result.result.user.telephone+"</option>";
            	$("#multiple-selected-user").empty();
                $("#multiple-selected-user").append(html)
                
                var addressHtml = "";
                for(var i=0;i<result.result.addressList.length;i++){
                	var address = result.result.addressList[i];
                	if(address.type==2){
                		addressHtml+=("<option value='"+address.id+"'>"+"["+(address.type==1?'自提':'快递')+"]"+(address.path+address.detail)+"("+(address.userName+"/"+address.telephone )+")"+"</option>");
                	}
                }
                $("#multiple-selected-address").empty();
                if(addressHtml){
                	$("#multiple-selected-address").append(addressHtml);
                }else{
                	$("#multiple-selected-address").append("<option disabled='disabled'>没有可选的快递地址</option>");
                }
                
               
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
function addUser(){
	var title = '添加待发货';
	var message =  '<div><label>电话号码</label><input type="text" id="searchPhone"><button type="button" class="btn btn-warning" onclick="searchUser()">查询</button></div>'+
				   '<select id="multiple-selected-user" multiple="multiple" style="width:100%;height:40px">'+
				   '</select>'+
				   ' <label>地址</label><br><select id="multiple-selected-address" multiple="multiple" style="width:100%;height:100px">'+
				   '</select>'+
				   '<div><label>订单号</label><input type="text" placeholder="请输入订单号（没有可以不用输入）" class="form-control" id="order-no"></div>';
	BootstrapDialog.confirm({
		title: title,
		message:message,
		type: BootstrapDialog.TYPE_WART, // <-- Default value is BootstrapDialog.TYPE_PRIMARY
        closable: false, // <-- Default value is false
        draggable: true, // <-- Default value is false
        btnCancelLabel: '取消', // <-- Default value is 'Cancel',
        btnOKLabel: '确认', // <-- Default value is 'OK',
        btnOKClass: 'btn-warning', // <-- If you didn't specify it, dialog type will be used,
        callback: function(result) {
            if(result) {
            	var userId = $('#multiple-selected-user').val();
            	if(!userId || userId.length<0){
            		alert("请选择用户");
            		return false;
            	}
            	var addressIds = $('#multiple-selected-address').val();
            	if(!addressIds || addressIds.length<0){
            		alert("请选择地址");
            		return false;
            	}
            	
            	window.location.href = "addItem.html?orderId="+$('#order-no').val()+"&type=2&addressId="+addressIds+"&userId="+userId;
            }else {
            }
        }
	});
}
</script>
</body>
</html>