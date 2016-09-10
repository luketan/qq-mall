<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="description" content="">
    <meta name="author" content="">
    <title>${item.id==null?"添加":"修改"}系统参数 - ${site.title}</title>
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
                        ${item.id==null?"添加":"修改"}系统参数
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-6">
                                <form id="inputForm" role="form" action="save.html" method="post">
                                    <input type="hidden" name="id" value="${item.id}">
                                    <div class="form-group">
                                        <label>参数名称</label>
                                        <input type="text" name="name" value="${item.name}" class="form-control" placeholder="请输入系统参数的名称">
                                    </div>
                                    <div class="form-group">
                                        <label>参数类型</label>
                                        <input type="number" name="type" value="${item.type}" class="form-control" readonly="readonly">
                                    </div>
                                    <div class="form-group">
                                        <label>参数代码</label>
                                        <input type="text" name="code" value="${item.code}" class="form-control" readonly="readonly">
                                    </div>
                                    <div class="form-group">
                                        <label>参数值</label>
                                       <%--  <input type="text" name="value" value="${item.value}" class="form-control" placeholder="请输入系统参数的值"> --%>
                                        <textarea name="value" class="form-control" style="height:120px;">${item.value}</textarea>
                                    </div>
                                    <div class="form-group">
                                        <label>备注说明</label>
                                        <textarea name="remark" class="form-control">${item.remark}</textarea>
                                    </div>
                                    <c:choose>
                                        <c:when test="${item.id==null}">
                                            <button type="submit" class="btn btn-success">确认添加</button>
                                            <button type="reset" class="btn btn-info">重置表单</button>
                                        </c:when>
                                        <c:otherwise>
                                            <button type="submit" class="btn btn-success">确认修改</button>
                                            <button type="reset" class="btn btn-warning" data-toggle="modal" data-target="#myModal">删除参数</button>
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
                                                            <button id="btnDelete" type="button" class="btn btn-danger">删除</button>
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
        alert("暂时不允许删除参数");
        //$("#inputForm").attr("action", "delete.html");
        //$("#inputForm").submit();
    });
    $("#btnCancel").click(function(){
        $("#inputForm").attr("action", "save.html");
    });
</script>
</body>
</html>