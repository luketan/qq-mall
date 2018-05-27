<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="description" content="">
    <meta name="author" content="">
    <title>${item.id>0?'修改':'添加' }活动 - ${site.title}</title>
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
                        	${item.id>0?'修改':'添加' }活动
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-6">
                                <form role="form" id="form" action="save.html" method="post">
                                	<input type="hidden" name="id" value="${item.id }">
                                    <div class="form-group">
                                        <label>名称</label>
                                        <input class="form-control" name="name" value="${item.name }" placeholder="请输入名称">
                                    </div>
                                    <div class="form-group">
                                        <label>类型</label>
                                        <select class="form-control" name="type">
                                        	<option ${item.type==1?"selected=selected":"" } value="1">打折</option>
                                        	<option ${item.type==2?"selected=selected":"" } value="2">包邮</option>
                                        	<option ${item.type==3?"selected=selected":"" } value="3">赠送</option>
                                            <option ${item.type==4?"selected=selected":"" } value="4">满减</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>条件</label>
                                        <input class="form-control" name="max" value="${item.max }" placeholder="请输入条件">
                                    </div>
                                    <div class="form-group">
                                        <label>值</label>
                                        <input class="form-control" name="value" value="${item.value }" placeholder="请输入值">
                                    </div>
                                    <div class="form-group">
                                        <label>链接地址</label>
                                        <input class="form-control" name="url" value="${item.url }" placeholder="请输入链接地址">
                                    </div>
                                    <div class="form-group">
                                        <label>详情</label>
                                        <textarea class="form-control" name="detail">${item.detail}</textarea>
                                    </div>
                                    <div class="form-group">
                                        <label>时效性</label>
                                        <select class="form-control" name="available">
                                            <option ${item.available==1?"selected=selected":"" } value="1">有</option>
                                            <option ${item.available==0?"selected=selected":"" } value="0">无</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-lg-6">
                                        <label>开始时间</label>
                                        <input class="form-control Wdate" name="startTimeTime" value="<fmt:formatDate value="${item.startTime}"
                                            pattern="yyyy-MM-dd HH:mm:ss"/>" onFocus="WdatePicker({isShowClear:false,readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" placeholder="请输入开始时间">
                                    </div>
                                    <div class="form-group col-lg-6">
                                        <label>结束时间</label>
                                        <input class="form-control Wdate" name="endTimeTime" value="<fmt:formatDate value="${item.endTime}"
                                            pattern="yyyy-MM-dd HH:mm:ss"/>" onFocus="WdatePicker({isShowClear:false,readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" placeholder="请输入结束时间">
                                    </div>
                                    <div class="form-group">
                                        <label>状态</label>
                                        <select class="form-control" name="sale">
                                            <option ${item.sale==true?"selected=selected":"" } value="true">正常</option>
                                            <option ${item.sale==false?"selected=selected":"" } value="false">下架</option>
                                        </select>
                                    </div>
                                    <button type="submit" class="btn btn-success">确认${item.id>0?'修改':'添加' }</button>
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
	
	$('.deleteBtn').click(function(){
		$("#form").attr('action','delete.html');
		$("#form").submit();
	});
</script>
</body>
</html>