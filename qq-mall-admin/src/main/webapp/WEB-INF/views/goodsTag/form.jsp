<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="description" content="">
    <meta name="author" content="">
    <title>${advertisement.id>0?'修改':'添加' }标签 - ${site.title}</title>
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
                        	${advertisement.id>0?'修改':'添加' }标签
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-6">
                                <form role="form" id="form" action="save.html" method="post">
                                	<input type="hidden" name="id" value="${item.id }">
                                    <div class="form-group">
                                        <label>标题</label>
                                        <input class="form-control" name="name" value="${item.name }" placeholder="请输入标题">
                                    </div>
                                    <div class="form-group">
                                        <label>图片地址</label>
                                        <div>
	                                        <img src="${item.img }" style="width:200px;">
	                                        <input class="form-control" name="image" value="${item.img }" placeholder="请输入图片地址">
                                        	<input type="file" class="imgFileUpload" id="imagefile">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label>子标题</label>
                                        <input class="form-control" name="subtitle" value="${item.subtitle }" placeholder="请输入的子标题">
                                    </div>
                                    <div class="form-group">
                                        <label>是否线上首页</label>
                                        <select class="form-control" name="showMain">
                                            <option ${item.status==0?"selected=selected":"" } value="1">否</option>
                                            <option ${item.status==1?"selected=selected":"" } value="2">是</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>状态</label>
                                        <select class="form-control" name="type">
                                        	<option ${item.status==1?"selected=selected":"" } value="1">正常</option>
                                        	<option ${item.status==2?"selected=selected":"" } value="2">删除</option>
                                        </select>
                                    </div>
                                    <button type="submit" class="btn btn-success">确认${item.id>0?'修改':'添加' }</button>
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