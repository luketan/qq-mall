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
                        <form id="inputForm" action="list.html" method="post" class="row">
                            <div class="col-lg-12 form-inline pull-left">
                                <input name="keyword" type="text" class="form-control input-sm" value="${keyword}" placeholder="输入关键字查询">
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <label>状态</label>
                                <select name="status" class="form-control input-sm">
                                    <option value="0" ${status==0?'selected':''}>全部状态</option>
                                    <option value="1" ${status==1?'selected':''}>正常</option>
                                    <option value="2" ${status==2?'selected':''}>锁定</option>
                                    <option value="3" ${status==3?'selected':''}>拉黑</option>
                                </select>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <label>类型</label>
                                <select name="type" class="form-control input-sm" >
                                    <option value="0" ${type==0?'selected':''}>全部类型</option>
                                    <option value="1" ${type==1?'selected':''}>普通</option>
                                    <option value="2" ${type==2?'selected':''}>小编</option>
                                </select>
                                <button type="submit" class="btn btn-warning">查询</button>
                            </div>
                        </form>
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="col-lg-12">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th>序号</th>
                                        <th>昵称</th>
                                        <th>账号</th>
                                        <th>电话</th>
                                        <th>邮箱</th>
                                        <th>类型</th>
                                        <th>状态</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${page.list}" var="item">
                                        <tr>
                                            <td>${item.id}</td>
                                            <td>${item.nickName}</td>
                                            <td>${item.account}</td>
                                            <td>${item.phone}</td>
                                            <td>${item.email}</td>
                                            <td>${item.type == 1 ? "普通" : ""}${item.type == 2 ? "小编" : ""}</td>
                                            <td>${item.status == 1 ? "正常" : ""}${item.status == 2 ? "锁定" : ""}${item.status == 3 ? "封号" : ""}</td>
                                            <td class="col-lg-1"><a href="modify.html?id=${item.id}">查看详情</a></td>
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