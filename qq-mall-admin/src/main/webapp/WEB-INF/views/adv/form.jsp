<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../include/taglib.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta name="description" content="">
    <meta name="author" content="">
    <title>${advertisement.id>0?'修改':'添加' }广告 - ${site.title}</title>
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
                        	${advertisement.id>0?'修改':'添加' }广告
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-6">
                                <form role="form" id="inputForm" action="" method="post">
                                	<input type="hidden" name="id" value="${item.id }">
                                    <div class="form-group">
                                        <label>标题</label>
                                        <input class="form-control" name="title" value="${item.title }" placeholder="请输入广告的标题">
                                    </div>
                                    <div class="form-group">
                                        <label>图片地址</label>
                                        <input class="form-control" name="image" value="${item.image }" placeholder="请输入广告图片地址">
                                        <input type="file" id="imagefile" class="imgFileUpload">
                                    </div>
                                    <div class="form-group">
                                        <label>类型</label>
                                        <select name="type" class="form-control">
                                            <c:forEach items="${typeList }" var="type">
                                                <option value="${type.key}" ${type.key==item.type?"selected='selected'":""} >${type.value}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>跳转地址</label>
                                        <input class="form-control" name="url" value="${item.url }" placeholder="请输入广告的跳转地址">
                                        <%--<input type="file" id="longImageFile" class="longImgFileUpload">--%>
                                    </div>
                                    <div class="form-group">
                                        <label>排序</label>
                                        <input class="form-control" name="sort" value="${item.sort }" placeholder="请输入排序">
                                    </div>
                                    <div class="form-group">
                                        <label>应用类型</label>
                                        <select name="styleType" class="form-control">
                                            <c:forEach items="${styleTypeList }" var="styleType">
                                                <option value="${styleType.key}" ${styleType.key==item.styleType?"selected='selected'":""} >${styleType.value}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <c:if test="${item.id>0 }">
	                                    <button type="button" id="btnSave" class="btn btn-success">确认${item.id>0?'修改':'添加' }</button>
	                                    <button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal">删除</button>
	                                    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
                                             <div class="modal-dialog">
                                                 <div class="modal-content">
                                                     <div class="modal-header">
                                                         <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                                         <h4 class="modal-title" id="myModalLabel">删除确认</h4>
                                                     </div>
                                                     <div class="modal-body">
                                                        	 确认要删除记录吗?
                                                     </div>
                                                     <div class="modal-footer">
                                                         <button id="btnDelete" type="button" class="btn btn-danger deleteBtn">删除</button>
                                                         <button id="btnCancel" type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                                     </div>
                                                 </div>
                                                 <!-- /.modal-content -->
                                             </div>
                                             <!-- /.modal-dialog -->
                                         </div>
                                    </c:if>
                                    <c:if test="${item.id==0 || item.id == null}">
                                    	<button type="button"  id="btnSave" class="btn btn-success">确认${item.id>0?'修改':'添加' }</button>
	                                    <button type="reset" class="btn btn-info" >重置</button>
                                    </c:if>
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
	$("#btnSave").click(function(){
        zbgj.ajax({
            url: "save.html",
            formData:$("#inputForm"),
            contentType: "application/x-www-form-urlencoded",   // http content type
            callback:function(data){
                var id = $("#inputForm").find("input[name='id']").val();
                if(id && id>0){
                    zbgj.promptMessage("修改成功！");
                }else{
                    zbgj.promptMessage("保存成功！");
                    setTimeout(function(){
                        window.location.href = 'modify.html?id=' + data.id;
                    },1000);
                }
            }
        });
    })
	$('#btnDelete').click(function(){
        $("#myModal").modal('hide');
        var id = $("#inputForm").find("input[name='id']").val();
        if(!id && id<=0){
            zbgj.promptError("id不存在不能删除！");
        }
        var id = $("#inputForm").find("input[name='id']").val();
        zbgj.ajax({
            url: "delete.html",
            jsonData:{"id":id},
            contentType: "application/x-www-form-urlencoded",   // http content type
            callback:function(data){
                zbgj.promptMessage("修改成功！");
                setTimeout(function(){
                    window.location.href = 'list.html';
                },1000);
            }
        });
	});
</script>
</body>
</html>
