<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="description" content="">
    <meta name="author" content="">
    <title>${advertisement.id>0?'修改':'添加' }广告 - ${site.title}</title>
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
                        	${advertisement.id>0?'修改':'添加' }广告
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-6">
                                <form role="form" id="form" action="save.html" method="post">
                                	<input type="hidden" name="id" value="${advertisement.id }">
                                    <div class="form-group">
                                        <label>标题</label>
                                        <input class="form-control" name="title" value="${advertisement.title }" placeholder="请输入广告的标题">
                                    </div>
                                    <div class="form-group">
                                        <label>图片地址</label>
                                        <div>
	                                        <img src="http://resources.honglinktech.com/mall/product/1470883946067.png" width="30%">
	                                        <input class="form-control" name="image" value="${advertisement.image }" placeholder="请输入广告图片地址">
                                        	<input type="file" class="imgFileUpload" id="imagefile">
                                        </div>
                                        
                                    </div>
                                    <div class="form-group">
                                        <label>值</label>
                                        <input class="form-control" name="value" value="${advertisement.value }" placeholder="请输入广告的跳转地址">
                                    </div>
                                    <div class="form-group">
                                        <label>类型</label>
                                        <select class="form-control" name="type">
                                        	<option ${advertisement.type==1?"selected=selected":"" } value="1">网页地址</option>
                                        	<option ${advertisement.type==2?"selected=selected":"" } value="2">系列</option>       
                                        	<option ${advertisement.type==3?"selected=selected":"" } value="3">新品</option>                                             	
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>排序</label>
                                        <input class="form-control" name="sort" value="${advertisement.sort }" placeholder="请输入排序">
                                    </div>
                                    <c:if test="${advertisement.id>0 }">
	                                    <button type="submit" class="btn btn-success">确认${advertisement.id>0?'修改':'添加' }</button>
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
                                    <c:if test="${advertisement.id==0 || advertisement.id==null }">
                                    	<button type="submit" class="btn btn-success">确认${advertisement.id>0?'修改':'添加' }</button>
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