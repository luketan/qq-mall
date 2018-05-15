<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="description" content="">
    <meta name="author" content="">
    <title>${item.id==null?"添加":"修改"}快递公司 - ${site.title}</title>
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
                        ${item.id==null?"添加":"修改"}快递公司
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-6">
                                <form id="inputForm" role="form" action="save.html" method="post">
                                    <input type="hidden" name="id" value="${item.id}">
                                    <div class="form-group">
                                        <label>公司名称</label>
                                        <input type="text" name="name" value="${item.name}" class="form-control" placeholder="请输入快递公司的名称">
                                    </div>
                                    <div class="form-group">
                                        <label>公司编码</label>
                                        <input type="text" name="code" value="${item.code}" class="form-control" placeholder="请输入快递公司编码(要跟快递100保持一致)">
                                    </div>
                                    <div class="form-group">
                                        <label>具体地址</label>
                                        <input type="text" name="address" value="${item.address}" class="form-control" placeholder="请输入快递公司的具体地址">
                                    </div>
                                    <div class="form-group">
                                        <label>负责人姓名</label>
                                        <input type="text" name="director" value="${item.director}" class="form-control" placeholder="请输入快递公司负责人姓名">
                                    </div>
                                    <div class="form-group">
                                        <label>联系电话</label>
                                        <input type="text" name="telephone" value="${item.telephone}" class="form-control" placeholder="请输入快递公司的联系电话">
                                    </div>
                                    <div class="form-group">
                                        <label>接口地址</label>
                                        <input type="text" name="apiURL" value="${item.apiURL}" class="form-control" placeholder="请输入快件查询接口地址">
                                    </div>
                                    <div class="form-group">
                                        <label>接口帐号</label>
                                        <input type="text" name="apiAccount" value="${item.apiAccount}" class="form-control" placeholder="请输入快件查询接口帐号">
                                    </div>
                                    <div class="form-group">
                                        <label>接口代码</label>
                                        <input type="text" name="apiCode" value="${item.apiCode}" class="form-control" placeholder="请输入快件查询接口代码">
                                    </div>
                                    <div class="form-group">
                                        <label>接口密码</label>
                                        <input type="password" name="apiPassword" value="${item.apiPassword}" class="form-control" placeholder="请输入快件查询接口密码">
                                    </div>
                                    <c:choose>
                                        <c:when test="${item.id==null}">
                                            <button type="submit" class="btn btn-success">确认添加</button>
                                            <button type="reset" class="btn btn-info">重置表单</button>
                                        </c:when>
                                        <c:otherwise>
                                            <button type="submit" class="btn btn-success">确认修改</button>
                                            <button type="reset" class="btn btn-warning" data-toggle="modal" data-target="#myModal">删除公司</button>
                                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
                                                <div class="modal-dialog">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                                            <h4 class="modal-title" id="myModalLabel">删除确认</h4>
                                                        </div>
                                                        <div class="modal-body">
                                                            确认要删除该记录吗?
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
    <!-- /#page-wrapper -->
</div>

<%@include file="../include/footer.jsp"%>
<script type="application/javascript">
    $("#btnDelete").click(function(){
        alert("暂时不允许删除");
        //$("#inputForm").attr("action", "delete.html");
        //$("#inputForm").submit();
    });
    $("#btnCancel").click(function(){
        $("#inputForm").attr("action", "save.html");
    });
</script>
</body>
</html>