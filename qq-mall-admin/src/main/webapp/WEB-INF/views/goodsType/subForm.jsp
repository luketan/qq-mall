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
                            <form role="form" id="form" action="subSave.html" method="post">
                                <div class="col-lg-6">
                                    <input type="hidden" name="id" value="${item.id }">
                                    <div class="form-group  ">
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
                                </div>
                                <div class="form-group col-lg-12" style="">
                                    <div class="panel panel-default" style="margin-bottom:0px;">
                                        <div class="panel-heading">
                                            <h4 class="panel-title">
                                                <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                                                    参数
                                                </a>
                                            </h4>
                                        </div>
                                        <%-- ${item.id!=null && item.id>0?'out':'in'}--%>
                                        <div id="collapseOne" class="panel-collapse collapse in">
                                            <div class="panel-body" style="padding-left:0px; padding-right:0px;">
                                                <div class="form-group col-lg-3">
                                                    <label>型号</label>
                                                    <input type="text" class="form-control" name="goodsPhone.model"  value="${item.goodsPhone!=null?item.goodsPhone.model:''}">
                                                </div>
                                                <div class="form-group col-lg-3">
                                                    <label>IMEI</label>
                                                    <input type="text" class="form-control" name="goodsPhone.imei"  value="${item.goodsPhone!=null?item.goodsPhone.imei:''}">
                                                </div>
                                                <div class="form-group col-lg-3">
                                                    <label>维修次数</label>
                                                    <input type="text" class="form-control" name="goodsPhone.repair"  value="${item.goodsPhone!=null?item.goodsPhone.repair:''}">
                                                </div>
                                                <div class="form-group col-lg-3">
                                                    <label>内存</label>
                                                    <input type="text" class="form-control" name="goodsPhone.ram"  value="${item.goodsPhone!=null?item.goodsPhone.ram:''}">
                                                </div>
                                                <div class="form-group col-lg-3">
                                                    <label>前摄像头</label>
                                                    <input type="text" class="form-control" name="goodsPhone.frontCamera"  value="${item.goodsPhone!=null?item.goodsPhone.frontCamera:''}">
                                                </div>
                                                <div class="form-group col-lg-3">
                                                    <label>后摄像头</label>
                                                    <input type="text" class="form-control" name="goodsPhone.afterCamera"  value="${item.goodsPhone!=null?item.goodsPhone.afterCamera:''}">
                                                </div>
                                                <div class="form-group col-lg-3">
                                                    <label>电池容量</label>
                                                    <input type="text" class="form-control" name="goodsPhone.battery"  value="${item.goodsPhone!=null?item.goodsPhone.battery:''}">
                                                </div>
                                                <div class="form-group col-lg-3">
                                                    <label>电池效率</label>
                                                    <input type="text" class="form-control" name="goodsPhone.batteryEffe"  value="${item.goodsPhone!=null?item.goodsPhone.batteryEffe:''}">
                                                </div>
                                                <div class="form-group col-lg-3">
                                                    <label>充电次数</label>
                                                    <input type="text" class="form-control" name="goodsPhone.batteryNum"  value="${item.goodsPhone!=null?item.goodsPhone.batteryNum:''}">
                                                </div>
                                                <div class="form-group col-lg-3">
                                                    <label>cpu</label>
                                                    <input type="text" class="form-control" name="goodsPhone.cpu"  value="${item.goodsPhone!=null?item.goodsPhone.cpu:''}">
                                                </div>
                                                <div class="form-group col-lg-3">
                                                    <label>cpu频率</label>
                                                    <input type="text" class="form-control" name="goodsPhone.cpuFreq"  value="${item.goodsPhone!=null?item.goodsPhone.cpuFreq:''}">
                                                </div>
                                                <div class="form-group col-lg-3">
                                                    <label>颜色</label>
                                                    <input type="text" class="form-control" name="goodsPhone.color"  value="${item.goodsPhone!=null?item.goodsPhone.color:''}">
                                                </div>
                                                <div class="form-group col-lg-3">
                                                    <label>成色</label>
                                                    <input type="text" class="form-control" name="goodsPhone.quality"  value="${item.goodsPhone!=null?item.goodsPhone.quality:''}">
                                                </div>
                                                <div class="form-group col-lg-3">
                                                    <label>版本</label>
                                                    <input type="text" class="form-control" name="goodsPhone.version"  value="${item.goodsPhone!=null?item.goodsPhone.version:''}">
                                                </div>
                                                <div class="form-group col-lg-3">
                                                    <label>系统版本</label>
                                                    <input type="text" class="form-control" name="goodsPhone.systemVersion"  value="${item.goodsPhone!=null?item.goodsPhone.systemVersion:''}">
                                                </div>
                                                <div class="form-group col-lg-3">
                                                    <label>网络</label>
                                                    <input type="text" class="form-control" name="goodsPhone.net"  value="${item.goodsPhone!=null?item.goodsPhone.net:''}">
                                                </div>
                                                <div class="form-group col-lg-3">
                                                    <label>sim卡规格</label>
                                                    <input type="text" class="form-control" name="goodsPhone.sim"  value="${item.goodsPhone!=null?item.goodsPhone.sim:''}">
                                                </div>
                                                <div class="form-group col-lg-3">
                                                    <label>屏幕尺寸</label>
                                                    <input type="text" class="form-control" name="goodsPhone.screenSize"  value="${item.goodsPhone!=null?item.goodsPhone.screenSize:''}">
                                                </div>
                                                <div class="form-group col-lg-3">
                                                    <label>尺寸</label>
                                                    <input type="text" class="form-control" name="goodsPhone.size"  value="${item.goodsPhone!=null?item.goodsPhone.size:''}">
                                                </div>
                                                <div class="form-group col-lg-3">
                                                    <label>分辨率</label>
                                                    <input type="text" class="form-control" name="goodsPhone.resolution"  value="${item.goodsPhone!=null?item.goodsPhone.resolution:''}">
                                                </div>
                                                <div class="form-group col-lg-3">
                                                    <label>生产时间</label>
                                                    <c:if test="${item.goodsPhone != null && item.goodsPhone.generateTime != null}">
                                                        <input type="text" class="form-control" name="goodsPhoneGenerateTime"  value="<fmt:formatDate value="${item.goodsPhone.generateTime}" pattern="yyyy-MM-dd"/>">
                                                    </c:if>
                                                    <c:if test="${item.goodsPhone == null || item.goodsPhone.generateTime == null}">
                                                        <input type="text" class="form-control" name="goodsPhoneGenerateTime"  value="">
                                                    </c:if>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group col-lg-12" style="">
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
                                </div>
                            </form>
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