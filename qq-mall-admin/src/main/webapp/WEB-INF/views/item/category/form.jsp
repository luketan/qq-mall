<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../../include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="description" content="">
    <meta name="author" content="">
    <title>${productItemCategory.id==null?"添加":"修改"}单品类别 - ${site.title}</title>
    <%@include file="../../include/head.jsp"%>
</head>

<body>
<div id="wrapper">
    <!-- Navigation -->
    <%@include file="../../include/nav.jsp"%>

    <div id="page-wrapper">
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        ${productItemCategory.id==null?"添加":"修改"}产品类别
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-6">
                                <form id="inputForm" role="form" action="save.html" method="post">
                                    <input type="hidden" name="id" value="${productItemCategory.id}">
                                    <div class="form-group">
                                        <label>识别码</label>
                                        <input type="text" name="code" value="${productItemCategory.code}" class="form-control" placeholder="请输入类别识别码">
                                    </div>
                                    <div class="form-group">
                                        <label>类别名称</label>
                                        <input type="text" name="name" value="${productItemCategory.name}" class="form-control" placeholder="请输入类别的名称">
                                    </div>
                                    <div class="form-group">
                                        <label>图片地址</label><br>
                                        <img src="${productItemCategory.image }" style="width: 80px">
                                        <input class="form-control" name="image" value="${productItemCategory.image }" placeholder="请输入类别图片地址">
                                        <input type="file" class="imgFileUpload" id="imagefile">
                                    </div>
                                    <div class="form-group">
                                        <label>排序编号</label>
                                        <input type="text" name="sort" value="${productItemCategory.sort}" class="form-control" placeholder="请设置该系列的排序编号">
                                    </div>
                                    <c:choose>
                                        <c:when test="${productItemCategory.id==null}">
                                            <button type="submit" class="btn btn-success">确认添加</button>
                                            <button type="reset" class="btn btn-info">重置表单</button>
                                        </c:when>
                                        <c:otherwise>
                                            <button type="submit" class="btn btn-success">确认修改</button>
                                            <button type="reset" class="btn btn-warning" data-toggle="modal" data-target="#myModal">删除类别</button>
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

<%@include file="../../include/footer.jsp"%>
<script type="application/javascript">
    $("#btnDelete").click(function(){
        $("#inputForm").attr("action", "delete.html");
        $("#inputForm").submit();
    });
    $("#btnCancel").click(function(){
        $("#inputForm").attr("action", "save.html");
    });
</script>
</body>
</html>