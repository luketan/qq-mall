<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../include/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="desc" content="">
    <meta name="author" content="">

    <title>角色成员列表 - ${site.title}</title>
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
                        角色成员列表
                        <button type="button" class="btn btn-primary btn-xs pull-right" data-toggle="modal"
                                data-target="#myModal" onclick="deleteAdded()">新增记录
                        </button>
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="table-responsive">
                            <table class="table table-striped table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>成员名称</th>
                                    <th>联系手机</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${result.list}" var="item">
                                    <tr>
                                        <td class="row">${item.id}</td>
                                        <td>${item.userName}</td>
                                        <td>${item.telephone}</td>
                                        <td>
                                            <a href="member/delete.html?userId=${item.id}&roleId=${id}">删除</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.table-responsive -->
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
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel" aria-hidden="true"
         style="display: none;">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                            aria-hidden="true">×
                    </button>
                    <h4 class="modal-title" id="myModalLabel">添加成员</h4>
                </div>
                <div class="modal-body">
                    请在下面选择您要添加的人!
                    <select class="form-control">
                        <c:forEach items="${result.all}" var="item">
                            <option value="${item.id}">${item.userName}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger" onclick="submitAdd(${id})">添加</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="../include/footer.jsp" %>
<script type="application/javascript">
    function deleteAdded() {
        var list = $("#myModal .modal-dialog .modal-body select option");
        var users = $("table tbody tr td.row");
        for (var i = 0; i < users.length; i++) {
            var userId = users[i].innerText;
            list.remove("[value='" + userId + "']");
        }
    }

    function submitAdd(id) {
        var userId = $("#myModal .modal-dialog .modal-body select option:selected").val();
        if (userId == null) {
            return;
        }
        window.location.href = "member/add.html?userId=" + userId + "&roleId=" + id;
    }
</script>
</body>
</html>