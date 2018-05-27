<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="description" content="">
    <meta name="author" content="">
    <title>${item.id>0?'修改':'添加' }商品子类型 - ${site.title}</title>
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
                        	${item.id>0?'修改':'添加' }商品子类型
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-6">
                                <form role="form" id="form" action="subSave.html" method="post">
                                	<input type="hidden" name="id" value="${item.id }">
                                    <div class="form-group">
                                        <label>标题</label>
                                        <input class="form-control" name="name" value="${item.name }" placeholder="请输入商品子类型">
                                    </div>
                                    <div class="form-group">
                                        <label style="display:block;">类型</label>
                                        <select id="goodsType" name="goodsType">
                                            <c:forEach items="${goodsTypes}" var="goodsType" >
                                                <option value="${goodsType.id}" ${item.goodsType == goodsType.id?"selected=selected":""} >${goodsType.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>推荐</label>
                                        <select class="form-control" name="rec">
                                            <option  ${item.rec==false?'selected=selected':'' } value="false">不推荐</option>
                                            <option  ${item.rec==true?'selected=selected':'' }  value="true">推荐</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>可用</label>
                                        <select class="form-control" name="sale">
                                            <option  ${item.sale==false?'selected=selected':'' } value="false">不可用</option>
                                            <option  ${item.sale==true?'selected=selected':'' }  value="true">可用</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>图片</label>
                                        <div>
                                            <img src="${item.img }" width="30%">
                                            <input class="form-control" name="img" value="${item.img }" placeholder="请输入图片">
                                            <input type="file" class="imgFileUpload" id="imagefile2">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label>排序</label>
                                        <input class="form-control" name="sort" value="${item.sort }" placeholder="请输入排序">
                                    </div>
                                    <c:if test="${item.id>0 }">
	                                    <button type="submit" class="btn btn-success">确认${item.id>0?'修改':'添加' }</button>
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
                                                         <button id="btnUpdate" type="button" class="btn btn-danger deleteBtn">删除</button>
                                                         <button id="btnCancel" type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                                     </div>
                                                 </div>
                                                 <!-- /.modal-content -->
                                             </div>
                                             <!-- /.modal-dialog -->
                                         </div>
                                    </c:if>
                                    <c:if test="${item.id==0 || item.id==null }">
                                    	<button type="submit" class="btn btn-success">确认${item.id>0?'修改':'添加' }</button>
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
	
	$('.deleteBtn').click(function(){
		$("#form").attr('action','delete.html');
		$("#form").submit();
	});
    $('#goodsType').multiselect({
        enableClickableOptGroups: true,
        enableCollapsibleOptGroups: true,
        enableFiltering: true,
        //includeSelectAllOption: true,
        buttonWidth: '50%',/* 宽度 */
        maxHeight: 400,/* 最高高度，高出最搞下拉滑动 */
        dropLeft: true,/*下拉位置 */
        numberDisplayed: 5,/*框内显示选中项  */
        delimiterText: ';',/*框内选中项分隔符  */
        optionClass: function(element) {//选项样式
            var value = $(element).val();
            if (value%2 == 0) {
                return 'even';
            }
            else {
                return 'odd';
            }
        },
        onChange: function(options, checked) {
        },
        onDropdownShow: function(event) {//显示事件
        },
        onDropdownHide: function(event) {//隐藏事件
        },
        buttonText: function(options, select) {
            if (options.length === 0) {
                return '请选择类型';
            }else{
                var labels = [];
                options.each(function() {
                    if ($(this).attr('label') !== undefined) {
                        labels.push($(this).attr('label'));
                    }
                    else {
                        var html = $(this).html();
                        html = html.split('|')[0];
                        labels.push(html);
                    }
                });
                return labels.join('; ') + '';
            }
        }
    });
    $('#goodsType').multiselect("refresh");
</script>
</body>
</html>