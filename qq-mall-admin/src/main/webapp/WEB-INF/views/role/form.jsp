<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="description" content="">
    <meta name="author" content="">

    <title>${item.id==null?"添加":"修改"}系统角色 - ${site.title}</title>

    <%@include file="../include/head.jsp" %>
    <link rel="stylesheet" href="/static/libs/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
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
                        ${item.id==null?"添加":"修改"}系统角色
                    </div>
                    <div class="panel-body">
                        <div class="col-lg-6">
                            <div class="col-lg-12">
                                <form id="inputForm" role="form" action="save.html" method="post">
                                    <input type="hidden" name="id" value="${item.id}">
                                    <div class="form-group col-lg-6">
                                        <label>角色名称</label>
                                        <input type="text" name="name" value="${item.name}" class="form-control"
                                               placeholder="请输入角色的名称">
                                    </div>
                                    <div class="form-group col-lg-6">
                                        <label>关联系统</label>
                                        <select name="type" class="form-control">
                                            <option value="1">管理大后台</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-lg-12">
                                        <label>角色说明</label>
                                        <textarea name="desc" class="form-control">${item.desc}</textarea>
                                    </div>
                                    <div class="form-group col-lg-12">
                                        <c:choose>
                                            <c:when test="${item.id==null}">
                                                <button type="button" class="btn btn-success" onclick="submitSave(1)">确认添加</button>
                                                <button type="reset" class="btn btn-info">重置表单</button>
                                                <button class="btn btn-primary" onclick="window.history.back()">返回列表</button>
                                            </c:when>
                                            <c:otherwise>
                                                <button type="button" class="btn btn-success" onclick="submitSave(2)">确认修改</button>
                                                <button type="reset" class="btn btn-warning" data-toggle="modal" data-target="#myModal">删除角色
                                                </button>
                                                <button class="btn btn-primary" onclick="window.history.back()">返回列表</button>
                                                <div class="modal fade" id="myModal" tabindex="-1" role="dialog"
                                                     aria-labelledby="myModalLabel" aria-hidden="true"
                                                     style="display: none;">
                                                    <div class="modal-dialog">
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <button type="button" class="close" data-dismiss="modal"
                                                                        aria-hidden="true">×
                                                                </button>
                                                                <h4 class="modal-title" id="myModalLabel">删除确认</h4>
                                                            </div>
                                                            <div class="modal-body">
                                                                确认要删除改记录吗?
                                                            </div>
                                                            <div class="modal-footer">
                                                                <button type="button" class="btn btn-danger">删除</button>
                                                                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <label for="securityTree">关联权限</label>
                            <ul id="securityTree" class="ztree"></ul>
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
</div>

<%@include file="../include/footer.jsp" %>
<script type="text/javascript" src="/static/libs/ztree/js/jquery.ztree.core.min.js"></script>
<script type="text/javascript" src="/static/libs/ztree/js/jquery.ztree.excheck.min.js"></script>
<script type="text/javascript" src="../../../static/js/system/role.js"></script>
<script type="application/javascript">
    var zNodes = ${tree};
    var zRoles = ${role};
</script>
</body>
</html>