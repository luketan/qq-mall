<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="description" content="">
    <meta name="author" content="">

    <title>${item.id==null?"添加":"修改"}系统权限 - ${site.title}</title>

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
                        ${item.id==null?"添加":"修改"}系统权限
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-6">
                                <form id="inputForm" role="form" action="save.html" method="post">
                                    <input type="hidden" name="id" value="${item.id}">
                                    <div class="form-group">
                                        <label>上级节点</label>
                                        <select name="parentId" class="form-control">
                                            <c:forEach items="${securitys}" var="security" >
                                            	<option ${item.parentId==security.id?'selected=selected':'' } value="${security.id}">${security.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>关联系统</label>
                                        <select name="type" class="form-control">
                                            <option value="1">管理大后台</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>权限名称</label>
                                        <input type="text" name="name" value="${item.name}" class="form-control" placeholder="请输入权限的名称">
                                    </div>
                                    <div class="form-group">
                                        <label>权限编码</label>
                                        <input type="text" name="code" value="${item.code}" class="form-control" placeholder="请输入权限的名称">
                                    </div>
                                    <div class="form-group">
                                        <label>权限说明</label>
                                        <input type="text" name="desc" value="${item.desc}" class="form-control" placeholder="请输入权限的名称">
                                    </div>
                                    <c:choose>
                                        <c:when test="${item.id==null}">
                                            <button type="submit" class="btn btn-success">确认添加</button>
                                            <button type="reset" class="btn btn-info">重置表单</button>
                                        </c:when>
                                        <c:otherwise>
                                            <button type="submit" class="btn btn-success">确认修改</button>
                                            <button type="reset" class="btn btn-warning" data-toggle="modal" data-target="#myModal">删除权限</button>
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
                                                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
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
</body>
</html>