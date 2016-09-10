<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="description" content="">
    <meta name="author" content="">
    <title>${item.id==null?"添加":"修改"}自提地址 - ${site.title}</title>
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
                        ${item.id==null?"添加":"修改"}自提地址
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-6">
                                <form id="inputForm" role="form" action="save.html" method="post">
                                    <input type="hidden" name="id" value="${item.id}">
                                    <div class="form-group">
                                        <label>联系人</label>
                                        <input type="text" name="userName" value="${item.userName}" class="form-control" placeholder="请设置该系列的排序编号">
                                    </div>
                                    <div class="form-group">
                                        <label>联系电话</label>
                                        <input type="text" name="telephone" value="${item.telephone}" class="form-control" placeholder="请设置该系列的排序编号">
                                    </div>
                                    <div class="form-group">
                                        <label>提货地址</label>
                                        <input type="text" name="path" value="${item.path}" class="form-control" placeholder="请输入系列的名称">
                                    </div>
                                    <div class="form-group">
                                        <label>地址詳情</label>
                                        <input type="text" name="detail" value="${item.detail}" class="form-control" placeholder="请输入系列的名称">
                                    </div>
                                    <div class="form-group">
                                        <label>提货备注</label>
                                        <input type="text" name="illustrate" value="${item.illustrate}" class="form-control" placeholder="请设置该系列的排序编号">
                                    </div>
                                    <c:choose>
                                        <c:when test="${item.id==null}">
                                            <button type="button" onclick="submitModify()" class="btn btn-success">确认添加</button>
                                            <button type="reset" class="btn btn-info">重置表单</button>
                                        </c:when>
                                        <c:otherwise>
                                            <button type="button" class="btn btn-success" onclick="submitModify()">确认修改</button>
                                            <button type="reset" class="btn btn-warning" data-toggle="modal" data-target="#myModal">删除地址</button>
                                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
                                                <div class="modal-dialog">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                                            <h4 class="modal-title" id="myModalLabel">删除确认</h4>
                                                        </div>
                                                        <div class="modal-body">
                                                           	 确认要删除改记录吗?
                                                        </div>
                                                        <div class="modal-footer">
                                                            <a type="role" href="delete.html?id=${item.id}" class="btn btn-danger">删除</a>
                                                            <button id="btnCancel" type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                                        </div>
                                                    </div>
                                                    <!-- /.modal-content -->
                                                </div>
                                                <!-- /.modal-dialog -->
                                            </div>
                                        </c:otherwise>
                                    </c:choose>
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

    <div class="modal fade bs-example-modal-sm" id="formModal" tabindex="-1" role="dialog"
         aria-labelledby="formModalLabel" aria-hidden="false">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    正在提交...
                </div>
            </div>
        </div>
    </div>
    <!-- /#page-wrapper -->
</div>

<%@include file="../include/footer.jsp"%>
<!-- <script type="text/javascript" src="../../../static/js/order/pickup-form.js"></script> -->
<script>
function submitModify(){
    var person = $("input[name='userName']").val();
    var phone = $("input[name='telephone']").val();
    var desc = $("input[name='detail']").val();
    var date = $("input[name='illustrate']").val();
    var formModal = $("#formModal");

    if(person == null || person == ''){
        formModal.find("div .modal-body").html("联系人姓名不能为空!");
        formModal.modal();
        return;
    }
    if(phone == null || phone == ''){
        formModal.find("div .modal-body").html("联系电话不能为空!");
        formModal.modal();
        return;
    }
    if(desc == null || desc == ''){
        formModal.find("div .modal-body").html("自提地址不能为空!");
        formModal.modal();
        return;
    }
    if(date == null || date == ''){
        formModal.find("div .modal-body").html("自提备注说明不能为空!");
        formModal.modal();
        return;
    }
    $("#inputForm").submit();
}
function submitSave(){
    var person = $("input[name='userName']").val();
    var phone = $("input[name='telephone']").val();
    var desc = $("input[name='detail']").val();
    var date = $("input[name='illustrate']").val();
    var formModal = $("#formModal");

    if(person == null || person == ''){
        formModal.find("div .modal-body").html("联系人姓名不能为空!");
        formModal.modal();
        return;
    }
    if(phone == null || phone == ''){
        formModal.find("div .modal-body").html("联系电话不能为空!");
        formModal.modal();
        return;
    }
    if(desc == null || desc == ''){
        formModal.find("div .modal-body").html("自提地址不能为空!");
        formModal.modal();
        return;
    }
    if(date == null || date == ''){
        formModal.find("div .modal-body").html("自提备注说明不能为空!");
        formModal.modal();
        return;
    }
    $("#inputForm").submit();
}
</script>
</body>
</html>