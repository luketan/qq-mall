<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="description" content="">
    <meta name="author" content="">
    <title>${item.id>0?'修改':'添加' }商品类型 - ${site.title}</title>
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
                        	${item.id>0?'修改':'添加' }商品类型
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-6">
                                <form role="form" id="form" action="save.html" method="post">
                                	<input type="hidden" name="id" value="${item.id }">
                                    <div class="form-group">
                                        <label>名称</label>
                                        <input class="form-control" name="name" value="${item.name }" placeholder="请输入名称">
                                    </div>
                                    <div class="form-group">
                                        <label>推荐</label>
                                        <select class="form-control" name="rec">
                                            <option  ${item.rec==false?'selected=selected':'' } value="false">不推荐</option>
                                            <option  ${item.rec==true?'selected=selected':'' }  value="true">推荐</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>可用</label>
                                        <select class="form-control" name="sale">
                                            <option  ${item.sale==false?'selected=selected':'' } value="false">不可用</option>
                                            <option  ${item.sale==true?'selected=selected':'' }  value="true">可用</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>图标</label>
                                        <div>
                                            <img src="${item.ico }" style="width:40px;">
                                            <input class="form-control" name="ico" value="${item.ico }" placeholder="请输入图标">
                                            <input type="file" class="imgFileUpload" id="imagefile1">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label>图片</label>
                                        <div>
	                                        <img src="${item.img }" width="30%">
	                                        <input class="form-control" name="img" value="${item.img }" placeholder="请输入图片">
                                        	<input type="file" class="imgFileUpload" id="imagefile2">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label>参数</label>
                                        <textarea name="search" class="form-control">${item.search}</textarea>
                                    </div>
                                    <div class="form-group">
                                        <label>详情</label>
                                        <textarea name="summary" class="form-control">${item.summary}</textarea>
                                    </div>
                                    <div class="form-group">
                                        <label>排序</label>
                                        <input class="form-control" name="sort" value="${item.sort }" placeholder="请输入排序">
                                    </div>
                                    <button type="submit" class="btn btn-success">确认${advertisement.id>0?'修改':'添加' }</button>
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