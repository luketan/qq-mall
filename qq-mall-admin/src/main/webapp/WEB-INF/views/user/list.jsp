<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="desc" content="">
    <meta name="author" content="">

    <title>用户列表 - ${site.title}</title>
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
                                                                 用户列表
                        <c:choose>
                       		<c:when test="${userServiceName == 'UserThirdServiceImpl' }">
                       			<a href="#" onclick="userAuth(0,true)" class="btn btn-primary btn-xs pull-right" role="button">授权新用户</a>
                       		</c:when>
                       		<c:otherwise>
                       			<a href="add.html" class="btn btn-primary btn-xs pull-right" role="button">新增用户</a>
                       		</c:otherwise>
                       	</c:choose>
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="col-lg-12">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th>序号</th>
                                        <th>登录名</th>
                                        <th>用户名</th>
                                        <th>状态</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${page.list}" var="item">
                                        <tr>
                                            <td>${item.id}</td>
                                            <td>${(empty item.loginName)?item.telephone:item.loginName}</td>
                                            <td>${item.userName}</td>
                                            <td>${(empty item.active)?"未知":(item.active?"活跃":"拉黑")}</td>
                                            <td>
                                            	<c:choose>
                                            		<c:when test="${userServiceName == 'UserThirdServiceImpl' }">
                                            			<a onclick="userAuth(${item.id},false)">取消授权</a>
                                            		</c:when>
                                            		<c:otherwise>
                                            			<a href="modify.html?id=${item.id}">编辑</a>
                                            		</c:otherwise>
                                            	</c:choose>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.table-responsive -->
                            ${page}
                        </div>
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
function userAuth(id,active){
	var tilte = active?"添加授权":"取消授权";
	var message1 = "你确定"+(active?"添加授权":"取消授权");
	
	var message2 =  '<div><label>电话号码</label><input type="text" id="searchPhone"><button type="button" class="btn btn-warning" onclick="searchUser()">查询</button></div>'+
	   '<select id="multiple-selected-user" multiple="multiple" style="width:100%;height:40px">'+
	   '</select>';
	   
	BootstrapDialog.confirm({
		title: tilte,
		message:active?message2:message1,
		type: BootstrapDialog.TYPE_WART, // <-- Default value is BootstrapDialog.TYPE_PRIMARY
        closable: true, // <-- Default value is false
        draggable: true, // <-- Default value is false
        btnCancelLabel: '取消', // <-- Default value is 'Cancel',
        btnOKLabel: '确认', // <-- Default value is 'OK',
        btnOKClass: 'btn-warning', // <-- If you didn't specify it, dialog type will be used,
        callback: function(result) {
            if(result) {
            	if(active){
            		id = $('#multiple-selected-user').val();
            	}
            	if(id){
            		window.location.href = "updateUserAuthInfo.html?id="+id+"&active="+active;
            	}else{
            		alert('请选择用户ID');
            	}
            }else {
            }
        }
	});
}
</script>
</body>
</html>