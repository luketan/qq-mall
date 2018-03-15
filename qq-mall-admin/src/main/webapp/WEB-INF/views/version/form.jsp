<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="description" content="">
    <meta name="author" content="">

    <title>${item!=null?'修改':'添加'}版本信息 - ${site.title}</title>

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
                       	 ${item!=null?'修改':'添加'}版本号
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-6">
                                <form role="form" id="inputForm" action="save.html" method="post">
                                    <div class="form-group">
                                        <label>版本标题</label>
                                        <input name="title" class="form-control" value="${item.title}">
                                    </div>
                                    <div class="form-group">
                                        <label>版本信息</label>
                                        <textarea class="form-control" style="height:150px;" name="updateInfo" placeholder="请输入版本信息" >${item.updateInfo}</textarea>
                                    </div>
                                    <div class="form-group">
                                        <label>版本备注</label>
                                        <textarea class="form-control" style="height:150px;" name="remark" placeholder="请输入版本信息" >${item.remark}</textarea>
                                    </div>
                                    <div class="form-group">
                                    	<input type="hidden" name="id" value="${item.id }">
                                        <label>最低版本<span style="color:red">*构建版本号</span></label>
                                        <input class="form-control" name="lowestVersion" value="${item.lowestVersion }" placeholder="请输入最低版本号">
                                    </div>
                                    <div class="form-group">
                                        <label>排本次版本</label>
                                        <input class="form-control" name="latestVersion" value="${item.latestVersion }" placeholder="请设置本次版本号">
                                    </div>
                                    <div class="form-group">
                                        <label>SHA-1</label>
                                        <input name="sha" class="form-control" value="${item.sha}">
                                    </div>
                                    <div class="form-group">
                                        <label>下载地址</label>
                                        <input class="form-control" name="updateUrl" value="${item.updateUrl }" placeholder="请设置下载地址">
                                    </div>
                                    <div class="form-group">
                                        <label>平台类型</label>
                                        <select name="type" class="form-control">
                                            <option value="company" ${item.osType=="ios"?"selected":""} >商户版</option>.
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>系统类型</label>
                                        <select name="osType" class="form-control">
                                            <option value="ios" ${item.osType=="ios"?"selected":""} >ios</option>.
                                            <option value="android" ${item.osType=="android"?"selected":""}>android</option>.
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>是否强制更新</label>
                                        <select name="enforce" class="form-control">
                                            <option value="true" ${item.enforce=="true"?"selected":""} >是</option>.
                                            <option value="false" ${item.enforce=="false"?"selected":""}>否</option>.
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>状态</label>
                                        <select name="status" class="form-control">
                                            <option value="1" ${item.status=="1"?"selected":""} >活跃</option>.
                                            <option value="0" ${item.status=="0"?"selected":""}>未激活</option>.
                                        </select>
                                    </div>
                                    <div class="form-group col-lg-12">
	                                    <c:choose>
	                                        <c:when test="${item.id==null}">
	                                            <button type="submit" class="btn btn-success">确认添加</button>
	                                            <button type="reset" class="btn btn-info">重置表单</button>
	                                        </c:when>
	                                        <c:otherwise>
	                                            <button type="submit" class="btn btn-success">确认修改</button>
	                                           <%-- <button type="reset" class="btn btn-warning" data-toggle="modal" data-target="#myModal">删除产品</button>
	                                            --%><div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
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

<%@include file="../include/footer.jsp"%>
<script>
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