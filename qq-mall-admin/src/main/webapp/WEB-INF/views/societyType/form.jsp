<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="description" content="">
    <meta name="author" content="">
    <title>${item.id>0?'修改':'添加' }论坛类别 - ${site.title}</title>
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
                        	${item.id>0?'修改':'添加' }论坛类别
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
                                        <label>排序</label>
                                        <div>
                                            <input class="form-control" name="sort" value="${item.sort }" type="number" placeholder="请输入排序">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label>状态</label>
                                        <select name="status" class="form-control">
                                            <option value="0" ${item.status == 0?"selected = selected":""}>正常</option>
                                            <option value="1" ${item.status == 1?"selected = selected":""}>删除</option>
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