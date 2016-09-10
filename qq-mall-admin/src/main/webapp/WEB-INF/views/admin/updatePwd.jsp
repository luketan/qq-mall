<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="description" content="">
    <meta name="author" content="">

    <title>修改密码 - ${site.title}</title>

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
                    	 修改 密码
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-6">
                                <form id="inputForm" role="form" action="updatePwd.html" method="post">
                                   	<div class="form-group">
                                        <label>密码</label>
                                        <input type="password" name="pwd" class="form-control" placeholder="请输入密码">
                                	</div>
                                	<div class="form-group">
                                        <label>新密码</label>
                                        <input type="password" name="newPwd" class="form-control" placeholder="请输入密码">
                                	</div>
                                	<div class="form-group">
                                        <label>重复密码</label>
                                        <input type="password" name="newPwds" class="form-control" placeholder="请输入密码">
                                	</div>
                                    <div>
                                    	 <button type="button" onclick="saveOrUpdate()" class="btn btn-success">确认 ${item.id==null?"添加":"修改"}</button>
                                    </div>                                
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
<form id="resetPwd" action="resetPwd.html" method="post">
<input type="hidden" name="id" value="${item.id}">
</form>
<%@include file="../include/footer.jsp"%>
<script>
function saveOrUpdate(){
	$("#inputForm").submit();
}
</script>
</body>
</html>