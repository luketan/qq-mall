<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="description" content="">
    <meta name="author" content="">
    <title>${item.id>0?'修改':'添加' }用户反馈信息 - ${site.title}</title>
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
                        	${item.id>0?'修改':'添加' }用户反馈信息
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-6">
                                <form role="form" id="form" action="update.html" method="post">
                                	<input type="hidden" name="id" value="${item.id }">
                                    <div class="form-group">
                                        <label>用户ID</label>
                                        <input class="form-control" name="userId" value="${item.userId }" readonly>
                                    </div>
                                    <div class="form-group">
                                        <label>详情</label>
                                        <textarea class="form-control" name="detail">${item.detail}</textarea>
                                    </div>
                                    <div class="form-group">
                                        <label>图片</label>
                                        <c:forEach items="${item.picBeanList}" var="pic">
                                            <img src="${pic.picUrl}" style="width: 200px"><br>
                                        </c:forEach>
                                    </div>
                                    <div class="form-group">
                                        <label>回复内容</label>
                                        <textarea class="form-control" name="reply">${item.reply}</textarea>
                                    </div>
                                    <div class="form-group">
                                        <label>客户是否已读</label>
                                        <input class="form-control" value='${item.readIs==0?"未读":"已读"}' readonly>
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