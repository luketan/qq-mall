<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../include/taglib.jsp" %>
<!DOCTYPE html>
<html lang="cn">
<head>
    <meta name="desc" content="">
    <meta name="author" content="">

    <title>单品列表 - ${site.title}</title>
    <%@include file="../include/head.jsp" %>
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
                 	       单品列表
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                    	<div class="row">
	                   		<div class="form-group col-lg-6 col-md-6 col-sm-6">
	                   			<c:choose>
	                   				<c:when test="${type==1 }">
	                   					<a class="btn btn-info" href="detail.html?orderId=${orderId }">返回</a>&nbsp;&nbsp;&nbsp;&nbsp;
	                   				</c:when>
	                   				<c:when test="${type==2 }">
	                   					<a class="btn btn-info" href="shipDetail.html?userId=${userId }">返回</a>&nbsp;&nbsp;&nbsp;&nbsp;
	                   				</c:when>
	                   			</c:choose>
								<a class="btn btn-warning" href="#" onclick="addItem()">提交</a>
							</div>
							<div class="form-group col-lg-6 col-md-6 col-sm-6" style="text-align: right;">
								
							</div>
						</div>
						<form id="searchForm" action="addItem.html" method="post">
							<input type="hidden" name="orderId" value="${orderId }">
	                    	<input type="hidden" name="type" value="${type }">
	                    	<input type="hidden" name="userId" value="${userId }">
						<div class="row form-group">
							<div class="col-lg-3 form-inline pull-left">
                               <label>关键词</label><input name="key" type="text" class="form-control input-sm" value="${key}" onkeydown="enterKeydown(this.value)" placeholder="输入关键字,回车键搜索">
                            </div>
						</div>
						</form>
                    	<div>
                    		<form id="orderAddForm" action="orderAddItem.html" method="post">
                    		<input type="hidden" name="orderId" value="${orderId }">
                    		<input type="hidden" name="type" value="${type }">
                    		<input type="hidden" name="userId" value="${userId }">
                    		<input type="hidden" name="addressId" value="${addressId }">
                    		<table class="table table-striped table-bordered" style="min-width: 200px;">
                    			<tbody>
                    				<tr>
                    				<c:forEach items="${page.list}" var="item" varStatus="status">
                    					<td style="width: 20%;max-width:200px;padding: 0;">
										    <div>
										      <img src="${item.image}" style="width: 100%" alt="...">
										      <div class="caption" style="padding: 0px">
										        <p style="overflow: hidden;white-space: nowrap;text-overflow: ellipsis;margin-bottom: 0px;"><label>系列名称</label>：${item.newProductName}</p>
										        <p style="overflow: hidden;white-space: nowrap;text-overflow: ellipsis;margin-bottom: 0px;"><label>单品名称</label>：${item.name}</p>
										        <p style="margin-bottom: 0px;"><input type="checkbox" name="itemIds" value="${item.id}"></p>
										        <p style="margin-bottom: 0px;"><label>规格</label>
									        	<select name="specId_${item.id}">
									        		<c:forEach items="${item.specificationList}" var="speList">
									        			<option value='${speList.id}'>${speList.prefix }${speList.startValue}${speList.speShowUnit}
									        			</option>
									        		</c:forEach>
									        	</select>
									        	</p>
										       
										        <c:forEach items="${item.proItemFormatList }" var="format">
										         	<c:if test="${fn:length(format.formatList)>0}">
											        	<p style="margin-bottom: 0px;"><label>${format.name }</label>
											        	<select name="syles_${item.id}">
											        		<c:forEach items="${format.formatList}" var="fList">
											        			<%-- <option value='{"id":${format.id },"styleName":"${format.name }","name":"${fList.name }"}'>${fList.name } --%>
											        			<option value='${format.name } ${fList.name }'>${fList.name }
											        			</option>
											        		</c:forEach>
											        	</select>
											        	</p>
										        	</c:if>
										        </c:forEach>
										        <p style="margin-bottom: 0px;" class=""><label>数量</label><input type="number" name="number_${item.id}" class="input-sm" value="10">
									        	</p>
										      </div>
										    </div>
                    					</td>
                    					<c:if test="${(status.index+1)%5==0 }">
                    						</tr><tr>
                    					</c:if>
                    				</c:forEach>
                    				</tr>
                    			</tbody>
                    		</table>
                    	<%-- 	<c:forEach items="${page.list}" var="item">
                    			<div class="col-sm-4 col-md-2">
								    <div class="thumbnail">
								      <img src="${item.image}" alt="...">
								      <div class="caption" style="padding: 0px">
								        <p style="overflow: hidden;white-space: nowrap;text-overflow: ellipsis;margin-bottom: 0px;"><label>系列名称</label>：${item.newProductName}</p>
								        <p style="overflow: hidden;white-space: nowrap;text-overflow: ellipsis;margin-bottom: 0px;"><label>单品名称</label>：${item.name}</p>
								        <p style="margin-bottom: 0px;"><input type="checkbox" name="itemIds" value="${item.id}"></p>
								        <c:if test="${fn:length(item.specificationList)>0}">
									        <p style="margin-bottom: 0px;"><label>规格</label>
								        	<select name="specId_${item.id}">
								        		<c:forEach items="${item.specificationList}" var="speList">
								        			<option value='${speList.id}'>${speList.prefix }${speList.startValue}${speList.speShowUnit}
								        			</option>
								        		</c:forEach>
								        	</select>
								        	</p>
								        </c:if>
								       
								        <c:forEach items="${item.proItemFormatList }" var="format">
								        	<p style="margin-bottom: 0px;"><label>${format.name }</label>
								        	<select name="syles_${item.id}">
								        		<c:forEach items="${format.formatList}" var="fList">
								        			<option value='{"id":${format.id },"styleName":"${format.name }","name":"${fList.name }"}'>${fList.name }
								        			<option value='${format.name } ${fList.name }'>${fList.name }
								        			</option>
								        		</c:forEach>
								        	</select>
								        	</p>
								        </c:forEach>
								        <p style="margin-bottom: 0px;" class=""><label>数量</label><input type="number" name="number_${item.id}" class="input-sm" value="10">
							        	</p>
								      </div>
								    </div>
								 </div>
                             </c:forEach> --%>
                             </form>
						</div>
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

<%@include file="../include/footer.jsp" %>
<script>
function enterKeydown(val, e) {
    var keyPressed = -1;
    if (window.event) {
        keyPressed = window.event.keyCode; // IE
    } else {
        keyPressed = e.which; // Firefox
    }
    if (keyPressed == 13) {
        if (val != null) {
        	 $("#searchForm").submit();
        } else {

        }
    }
}
function addItem(){
	
	var itemIds = $("input[name=itemIds]");
	var i=0;
	for(;i<itemIds.length;i++){
		if($(itemIds[i]).is(':checked')){
			break
		}
	}
	if(i==itemIds.length){
		BootstrapDialog.alert({
			title: '错误',
			message: '请选择你要添加单品',
			type: BootstrapDialog.TYPE_WART, // <-- Default value is BootstrapDialog.TYPE_PRIMARY
	        closable: true, // <-- Default value is false
	        draggable: true, // <-- Default value is false
	        btnOKLabel: '确认', // <-- Default value is 'OK',
	        btnOKClass: 'btn-warning', // <-- If you didn't specify it, dialog type will be used,
	        callback: function(result) {
	            if(result) {
	            }else {
	            }
	        }
		});	
		return;
	}
	console.log(itemIds);
	BootstrapDialog.confirm({
		title: '添加单品',
		message: '你确认添加单品吗？',
		type: BootstrapDialog.TYPE_WART, // <-- Default value is BootstrapDialog.TYPE_PRIMARY
        closable: true, // <-- Default value is false
        draggable: true, // <-- Default value is false
        btnCancelLabel: '取消', // <-- Default value is 'Cancel',
        btnOKLabel: '确认', // <-- Default value is 'OK',
        btnOKClass: 'btn-warning', // <-- If you didn't specify it, dialog type will be used,
        callback: function(result) {
            if(result) {
            	$("#orderAddForm").submit();
            }else {
            }
        }
	});	
	
}
</script>
</body>
</html>