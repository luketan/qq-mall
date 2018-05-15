<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="description" content="">
    <meta name="author" content="">
    <title>${item.id>0?'修改':'添加' }优惠券 - ${site.title}</title>
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
                        	${item.id>0?'修改':'添加' }优惠券
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-6">
                                <form role="form" id="form" action="save.html" method="post">
                                	<input type="hidden" name="id" value="${item.id }">
                                    <div class="form-group">
                                        <label>名称</label>
                                        <input class="form-control" name="name" value="${item.name }" placeholder="请输入优惠券的标题">
                                    </div>
                                    <div class="form-group">
                                        <label>条件</label>
                                        <input class="form-control" name="condition" value="${item.condition }" placeholder="请输入优惠券的条件">
                                    </div>
                                    <div class="form-group">
                                        <label>详情</label>
                                        <textarea class="form-control" name="detail" placeholder="请输入优惠券的条件">${item.detail}</textarea>
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
                                        <label>满足最大值</label>
                                        <input class="form-control" name="max" value="${item.max }" type="number" placeholder="请输入优惠券的满足最大值">
                                    </div>
                                    <div class="form-group">
                                        <label>值</label>
                                        <input class="form-control" name="value" value="${item.value }" type="number" placeholder="请输入优惠券的值">
                                    </div>
                                    <div class="form-group">
                                        <label>开始时间</label>
                                        <input class="form-control Wdate" name="startTimeTime" value='<fmt:formatDate value="${item.startDate}" pattern="yyyy-MM-dd hh:mm:ss"/>' onFocus="WdatePicker({isShowClear:false,readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" placeholder="请输入优惠券的开始时间">
                                    </div>
                                    <div class="form-group">
                                        <label>结束时间</label>
                                        <input class="form-control Wdate" name="endTimeTime" value='<fmt:formatDate value="${item.endDate}" pattern="yyyy-MM-dd hh:mm:ss"/>' onFocus="WdatePicker({isShowClear:false,readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" placeholder="请输入优惠券的结束时间">
                                    </div>
                                    <div class="form-group">
                                        <label>状态</label>
                                        <select class="form-control" name="status">
                                            <option ${item.status==1?"selected=selected":"" } value="1">正常</option>
                                            <option ${item.status==2?"selected=selected":"" } value="2">无效</option>
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