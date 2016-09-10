<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="description" content="">
    <meta name="author" content="">
    <title>${supplier.id>0?'修改':'添加' }供应商 - ${site.title}</title>
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
                        	${supplier.id>0?'修改':'添加' }供应商
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-6">
                                <form role="form" id="form" action="save.html" method="post">
                                	<input type="hidden" name="id" value="${supplier.id }">
                                    <div class="form-group">
                                        <label>名称</label>
                                        <input class="form-control" name="name" value="${supplier.name }" placeholder="请输入供应商的名称">
                                    </div>
                                    <div class="form-group">
                                        <label>电话</label>
                                        <input class="form-control" name="phone" value="${supplier.phone }" placeholder="请输入供应商的电脑">
                                    </div>
                                    <div class="form-group">
                                        <label>logo</label>
                                        <input class="form-control" name="logo" value="${supplier.logo }" placeholder="请输入供应商图片地址">
                                        <input type="file" class="imgFileUpload" id="imagefile">
                                    </div>
                                    <div class="form-group">
                                        <label>支付方式</label>
                                        <input class="form-control" name="paymentMethod" value="${supplier.paymentMethod }" placeholder="请输入支付方式">
                                    </div>
                                    <c:if test="${supplier.id>0 }">
	                                    <button type="submit" class="btn btn-success">确认${supplier.id>0?'修改':'添加' }</button>
	                                    <button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal">删除</button>
	                                    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
                                             <div class="modal-dialog">
                                                 <div class="modal-content">
                                                     <div class="modal-header">
                                                         <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                                         <h4 class="modal-title" id="myModalLabel">删除确认</h4>
                                                     </div>
                                                     <div class="modal-body">
                                                        	 确认要删除记录吗?
                                                     </div>
                                                     <div class="modal-footer">
                                                         <button id="btnUpdate" type="button" class="btn btn-danger deleteBtn">删除</button>
                                                         <button id="btnCancel" type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                                     </div>
                                                 </div>
                                                 <!-- /.modal-content -->
                                             </div>
                                             <!-- /.modal-dialog -->
                                         </div>
                                    </c:if>
                                    <c:if test="${supplier.id==0 || supplier.id==null }">
                                    	<button type="submit" class="btn btn-success">确认${supplier.id>0?'修改':'添加' }</button>
	                                    <button type="reset" class="btn btn-info" >重置</button>
                                    </c:if>
                                </form>
                            </div>
                            <!-- /.col-lg-6 (nested) -->
                        </div>
                        <!-- /.row (nested) -->
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
	
	$('.deleteBtn').click(function(){
		$("#form").attr('action','delete.html');
		$("#form").submit();
	});
</script>
</body>
</html>