<%@include file="../include/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="description" content="">
    <meta name="author" content="">

    <title>${item.id==null?"添加商品":"修改商品"} - ${site.title}</title>
    <%@include file="../include/head.jsp"%>
	<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap-select/2.0.0-beta1/css/bootstrap-select.min.css">
    <link href="${basePath }/static/css/form.css" rel="stylesheet">
    <script src="${basePath }/static/libs/ckeditor/ckeditor.js"></script>
    <style>
		.zbgj-input-clear td{
			padding-left: 0px !important;
			padding-right: 0px !important;
		}
		.zbgj-input-clear .form-control{
			padding:0 !important;
		}
		.formatBodyClass button{
			float:right;
		}
		.formatBodyClass tr{
			background-color:#fff !important;
		}
		.formatHeadClass td{
			background-color:#ccc !important;
		}
		.formatBodyClass input{
			max-width:90px;display:inline;margin-right:0px;
		}
		.formatBodyClass select{
			max-width:90px;display:inline;margin-right:0px;
		}
		.formatHeadClass span{
			font-weight:700;
		}
		.formatHeadClass input{
			max-width:90px;display:inline;margin-right:8px;
		}
		.formatHeadClass select{
			max-width:90px;display:inline;margin-right:8px;
		}
    </style>
</head>

<body>
<div id="wrapper">
    <!-- Navigation -->
    <%@include file="../include/nav.jsp"%>

    <div id="page-wrapper" style="margin-bottom:20px;">
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        ${item.id==null?"添加商品":"修改商品"}
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-12">
                                <form id="inputForm" role="form" action="save.html" method="post">
                                    <input type="hidden" name="id" value="${item.id>0?item.id:0}">
                                    <div class="form-group col-lg-6">
                                        <label>商品名称</label>
                                        <input type="text" class="form-control" name="name" placeholder="请输入商品名称" value="${item.name}">
                                    </div>
									<div class="form-group col-lg-6">
										<label>子标题</label>
										<input type="text" class="form-control" name="subName" placeholder="请输入商品名称" value="${item.subName}">
									</div>
                                    <div class="form-group col-lg-6">
                                        <label>品牌</label>
                                        <select name="brandId" class="form-control">
                                        	<option value="0">请选择</option>
                                        	<c:forEach items="${brands }" var="brand">
                                        		<option value="${brand.id }" ${brand.id == item.brandId?'selected="selected"':''}>${brand.name}</option>
                                        	</c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group col-lg-6">
                                    	<div class="row">
                                    		<div class="form-group col-lg-4">
		                                        <label>出售价格</label>
		                                        <input type="text" class="form-control" name="price" onkeyup="value=value.replace(/[^\d\.]/g,'')" placeholder="请输入价格" value="${item.price}">
	                                        </div>
	                                        <div class="form-group col-lg-4">
		                                        <label>成本价</label>
		                                        <input type="text" class="form-control" name="formerPrice" onkeyup="value=value.replace(/[^\d\.]/g,'')" placeholder="请输入原价" value="${item.formerPrice}">
	                                        </div>
											<div class="form-group col-lg-4">
												<label>市场价</label>
												<input type="text" class="form-control" name="markPrice" onkeyup="value=value.replace(/[^\d\.]/g,'')" placeholder="请输入市场价" value="${item.markPrice}">
											</div>
                                    	</div>
                                    </div>
									<div class="form-group col-lg-6">
                                        <label style="display:block;">商品类型</label>
										<select id="typeId" name="typeId" class="form-control" >
                                            <c:forEach items="${types}" var="type" >
                                                <optgroup label="${type.name}">
                                                    <c:forEach items="${type.goodsTypeSubList}" var="goodsTypeSub" >
                                                        <option value="${goodsTypeSub.id}" ${item.typeSubId == goodsTypeSub.id?"selected=selected":""} >${goodsTypeSub.name}</option>
                                                    </c:forEach>
                                                </optgroup>
                                            </c:forEach>
										</select>
                                    </div>
									<div class="form-group col-lg-6">
										<div class="row">
											<div class="form-group col-lg-6">
												<label>是否热卖</label>
												<select name="hotIs" class="form-control">
													<option value="0" >否</option>
													<option value="1" ${item.hotIs == 1?'selected="selected"':''}>是</option>
												</select>
											</div>
											<div class="form-group col-lg-6">
												<label>是否精品</label>
												<select name="giftsIs" class="form-control">
													<option value="0" >否</option>
													<option value="1" ${item.giftsIs == 1?'selected="selected"':''}>是</option>
												</select>
											</div>
										</div>
									</div>
									<div class="form-group col-lg-6">
										<label>状态</label>
										<select name="status" class="form-control">
											<c:forEach items="${goodsStatusList }" var="goodsStatus">
												<option value="${goodsStatus.code}" ${item.status == goodsStatus.code?'selected="selected"':''}>${goodsStatus.value}</option>
											</c:forEach>
										</select>
									</div>
                                    <div class="form-group col-lg-6">
                                        <label>排序</label>
                                        <input type="number" class="form-control" name="sort" placeholder="请输入排序" value="${item.sort}">
                                    </div>
                                    <c:if test="${fn:length(tags)>0}">
                                        <div class="form-group col-lg-12">
                                            <label>分组</label>
                                            <div>
                                                <c:forEach items="${tags}" var="tag">
                                                    <label class="checkbox-inline">
                                                        <input type="checkbox" name="tagIds" value="${tag.id}" ${(item.id == tag.goodsId && !(empty tag.goodsId))?"checked=checked":'' }>${tag.name}
                                                    </label>
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </c:if>
                                    <c:if test="${fn:length(activitys)>0}">
                                        <div class="form-group col-lg-12">
                                            <label>活动</label>
                                            <div>
                                                <c:forEach items="${activitys}" var="activity">
                                                    <label class="checkbox-inline">
                                                        <input type="checkbox" name="activityIds" value="${activity.id}" ${(item.id == activity.goodsId && !(empty activity.goodsId))?"checked=checked":'' }>${activity.name}
                                                    </label>
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </c:if>
									<div class="col-lg-12" style="">
										<label>规格 <span style="color:red;font-size:18px;float:left;line-height:14px">*</span> </label>
										<table class="table table-striped table-bordered table-hover" style="margin-bottom:0;"padding-bottom:0px;">
										<thead>
										<tr>
											<th>单项名称</th>
											<th>价格</th>
											<th>Vip价格</th>
											<th>是否可选</th>
											<th>关联</th>
											<th>操作</th>
										</tr>
										</thead>
										<tbody class="formatBodyClass" >
										<c:set var="formatIndex" value="0"/>
										<c:forEach items="${item.formatList }" var="format" varStatus="formatStatus">
											<tr class="formatHeadClass">
												<td colspan="10">
													<input type="hidden" name="formatFlagIds" value="${formatStatus.index}">
													<input type="hidden" class="formatIds" name="formatIds_${formatStatus.index}" value="${format.id}">
													<span>规格名称</span>
													<input type="text" name="formatName_${formatStatus.index}" placeholder="规格名称" class="form-control" value="${format.name }">
													<span>需要价格</span>
													<select name="needValue_${formatStatus.index}" class="form-control">
														<option value="0" ${format.needPrice==0?'selected="selected"':'' }>否</option>
														<option value="1" ${format.needPrice==1?'selected="selected"':'' }>是</option>
													</select>
													<button type="button" class="btn btn-danger btn-sm" onclick="deleteFormat(this)">删除规格</button>
													<button type="button" class="btn btn-primary btn-sm" onclick="addFormatSub(this,${formatStatus.index})">添加单项</button>
												</td>
											</tr>
											<c:forEach items="${format.formatSubBeanList }" var="formatSub" varStatus="formatSubStatus">
												<c:set var="formatIndex" value="${formatIndex+1 }"/>
												<tr class="formatSubClass">
													<td style="text-align:right;">
														<c:set var="formatSubFlagId" value="${formatIndex}"></c:set>
														<input type="hidden" name="formatSubFlagId_${formatStatus.index}" value="${formatSubFlagId}" class="formatSubFlagIdClass">
														<input type="hidden" name="formatSubIds_${formatStatus.index}_${formatSubFlagId}" value="${formatSub.id}" class="formatSubIdClass">
														<input type="text" name="formatSubName_${formatStatus.index}_${formatSubFlagId}" placeholder="单项名称" value="${formatSub.name}" class="form-control formatSubNameClass"></td>
													<td><input type="text" name="price_${formatStatus.index}_${formatSubFlagId}" placeholder="价格" class="form-control formatSubPriceClass" value="${formatSub.price}"></td>
													<td><input type="text" name="vipPrice_${formatStatus.index}_${formatSubFlagId}" placeholder="Vip价格" class="form-control formatSubVipPriceClass" value="${formatSub.vipPrice}"></td>
													<td><select name="select_${formatStatus.index}_${formatSubFlagId}" class="form-control" style="">
														<option ${formatSub.select == 1?'selected="selected"':'' } value="1">可选</option>
														<option ${formatSub.select == 0?'selected="selected"':'' } value="0">不可选</option>
													</select></td>
													<td><select name="relyFormatSubId_${formatStatus.index}_${formatSubFlagId}" class="selectpicker show-tick form-control formatSelect" multiple data-size="5" data-live-search="false">
													</select>
													</td>
													<td><button type="button" class="btn btn-danger btn-sm" onclick="deleteFormatSub(this)">删除</button></td>
												</tr>
											</c:forEach>
											<c:set var="formatSubIndex" value="${formatSubIndex+fn:length(format.formatSubBeanList)}"></c:set>
										</c:forEach>

										</tbody>
										</table>
									</div>
									<div class="col-lg-12" style="padding-top:0px;margin-top:0px;text-align: left;padding-bottom:20px;">
										<button type="button" class="btn btn-primary btn-sm" onclick="addFormat()">添加规格</button>
									</div>
                                    <div class="form-group col-lg-12">
                                        <label>商品详情</label>
                                        <div>
                                            <textarea name="description" class="form-control" id="detail" style="width: 100%;height:80px">${item.detail}</textarea>
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
											<div id="collapseOne" class="panel-collapse collapse ${item.id!=null && item.id>0?'out':'in'}">
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
										<div class="panel panel-default" style="margin-bottom:0px;">
											<div class="panel-heading">
												<h4 class="panel-title">
													<a data-toggle="collapse" data-parent="#accordion" href="#collapseImg">
														图片&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													</a>
												</h4>
											</div>
											<div id="collapseImg" class="panel-collapse collapse ${item.id!=null && item.id>0?'out':'in'}">
												<div class="panel-body" style="padding-left:0px; padding-right:0px;">
													<div class="form-group col-lg-12" style="">
														<label>主图文件</label>
														<div>
															<img src="${item.imgUrl}" style="width: 200px;">
															<input type="text" class="form-control" id="mainImage" name="imgUrl" placeholder="请选择主图文件" value="${item.imgUrl}">
															<input class="imgFileUpload" type="file">
														</div>
													</div>
													<div class="form-group col-lg-12">
														<label>宝贝图片</label>
														<div id="lunboImg">
															<c:forEach items="${item.picList}" var="image">
																<div style="display: table;padding: 10px;width: 100%">
																	<div style="display: table-cell;width: 200px;vertical-align:middle;">
																		<img src="${image.picUrl }" width="200px">
																	</div>
																	<div style="display: table-cell;width: 70%;vertical-align:top;padding-left: 10px">
																		<input type="text" class="form-control" style="width: 50%;display: none;"  name="picUrl" placeholder="请选择宝贝图片" value="${image.picUrl}" onchange="javascript:this.parentNode.parentNode.querySelector('img').src=this.value">
																			<%--   排序：<input style="width:10%" name="sorts" value="${image.sort}"> --%>
																		<br>
																			<%--  设为首图<input type="radio" name="mainImgRad" ${image.images==item.image?'checked="checked"':""} value="${image.images}" onclick="javascript:$('#mainImage').val(this.value)"><br>
                                                                         <br> --%>
																		<input type="button" value="上移" onclick="moveUp(this)">&nbsp;
																		<input type="button" value="下移" onclick="moveDown(this)">&nbsp;
																		<input type="button" value="删除" onclick="javascript:this.parentNode.parentNode.parentNode.removeChild(this.parentNode.parentNode)">
																	</div>
																</div>
															</c:forEach>
														</div>
														<input class="multiImgFileUpload" style="margin-top: 20px" type="file">
													</div>
												</div>
											</div>
										</div>
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
	<div class="form-group col-lg-12" style="position:fixed;bottom:0px;right:0;text-align: right;padding:14px 20px 0 0;margin:0px;height:60px;">
		<c:choose>
			<c:when test="${item.id==null}">
				<shiro:hasPermission name="goods">
					<button type="button" class="btn btn-success" id="btnSave">确认添加</button>
					<button type="reset" class="btn btn-info">重置表单</button>
				</shiro:hasPermission>
			</c:when>
			<c:otherwise>
				<shiro:hasPermission name="goods">
					<button type="button" class="btn btn-success" id="btnSave">确认修改</button>
				</shiro:hasPermission>
				<shiro:hasPermission name="goods">
					<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#myModal">删除产品</button>
				</shiro:hasPermission>
				<div class="modal fade" id="myModal" tabindex="-1" role="" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
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
    <!-- /#page-wrapper -->
</div>
	                                            
<%@include file="../include/footer.jsp"%>
<script src="//cdn.bootcss.com/bootstrap-select/2.0.0-beta1/js/bootstrap-select.min.js"></script>
<script type="application/javascript">
	$('#typeId').multiselect({
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
				return '请选择商品类';
			}else {
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
    $('#typeId').multiselect("refresh");

    $("#btnDelete").click(function(){
		$("#inputForm").attr("action", "${basePath }/goods/delete.html");
		$("#inputForm").submit();
		BootstrapDialog.confirm({
			title:'删除 ',
			message:'确认删除当前选中的记录吗?',
			type: BootstrapDialog.TYPE_DANGER,
			closable: true, //
			draggable: true, //
			btnCancelLabel: '取消', //
			btnOKLabel: '确认', //
			btnOKClass: 'btn-warning', //
			callback: function(result) {
				if(result) {
					var spId = $(self.parentNode.parentNode).find('.formatSubIdClass').val();
					if(spId && spId>0){
						$.ajax({
							type: "POST",
							url: "${basePath }/goods/deleteFormatSub.html?id="+spId,
							timeout: 400000,
							data: null,
							cache: false,
							contentType: false,
							processData: false,
							success:function(result){

								result = JSON.parse(result);
								if(result.code==0){
									self.parentNode.parentNode.parentNode.removeChild(self.parentNode.parentNode);
								}else{
									alert(result.msg);
								}

							},
							error:function(xhr, errmsg){
								console.log("ajax-err-[]->"+JSON.stringify(errmsg)+"|"+xhr);
								alert('error');
							}
						});
					}else{
						self.parentNode.parentNode.parentNode.removeChild(self.parentNode.parentNode);
					}
				}else {
				}
			}
		});
    });
    $("#btnSave").click(function(){
		zbgj.ajax({
			url: "${basePath }/goods/save.html",
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
    });

	//规格处理.....................................................................、
	//关联处理........
	var selectpickerOption="";
	$('.formatSubClass').each(function(){
		var formatSubName = $(this).find('.formatSubNameClass');
		var formatSubId = $(this).find('.formatSubIdClass');
		var formatSubFlagId = $(this).find('.formatSubFlagIdClass');
		selectpickerOption+='<option value="'+formatSubFlagId.val()+'">'+
				(formatSubName.val())+
				'</option>'
	});
	$('.formatSelect').each(function(){
		var so = selectpickerOption;
		var self = $(this).parent().parent();
		var formatSubFlag = self.find(".formatSubFlagIdClass");
		var regExp = new RegExp('<option value=\"'+formatSubFlag.val()+'\">.*?<\/option>')
		so = so.replace(regExp,'');
		so = selectNext(self, so);
		so = selectPrev(self, so);
		$(this).html(so);
	});
	function selectNext(self,selectpickerOptions){
		var obj = $(self).next();
		if(!obj || obj.hasClass("formatHeadClass")){
			return selectpickerOptions;
		}else{
			var formatSubFlag = obj.find(".formatSubFlagIdClass");
			if(!formatSubFlag || !formatSubFlag.val()){
				return selectpickerOptions;
			}
			var regExp = new RegExp('<option value=\"'+formatSubFlag.val()+'\">.*?<\/option>');
			console.log("next:"+regExp);
			selectpickerOptions = selectpickerOptions.replace(regExp,'');
			return selectNext(obj, selectpickerOptions);
		}
	}
	function selectPrev(self, selectpickerOptions){
		var obj = $(self).prev();
		if(!obj || obj.hasClass("formatHeadClass")){
			return selectpickerOptions;
		}else{
			var formatSubFlag = obj.find(".formatSubFlagIdClass");
			if(!formatSubFlag || !formatSubFlag.val()){
				return selectpickerOptions;
			}
			var regExp = new RegExp('<option value=\"'+formatSubFlag.val()+'\">.*?<\/option>');
			console.log("prev:"+regExp);
			selectpickerOptions = selectpickerOptions.replace(regExp,'');
			return selectPrev(obj, selectpickerOptions);
		}
	}
	$('.formatSelect').selectpicker({
		noneSelectedText: '可选依赖',//没有值的时候button显示值
	});
	//初始化数据
	var foramtList = ("${item.formatList}")?("${item.formatList}"):''+[];
	if(foramtList && foramtList.length>0){
		for(var i=0; i<foramtList.length; i++){
			var format = foramtList[i];
			if(format.formatSubBeanList && format.formatSubBeanList.length>0){
				for(var j=0;j<format.formatSubBeanList.length;j++){
					var relyIds = format.formatSubBeanList[j].relyFormatSubIds;
					if(relyIds && relyIds.length>0){
						//获取依赖规格ID
						var formatSubFlagIndex = [];
						for(var k=0; k<relyIds.length; k++){
							var regExp = new RegExp('<input type=\"hidden\" name=\"formatSubIds.*?value=\"'+relyIds[k]+'\" class=\"formatSubIdClass\">')
							var formatSubs = $(".formatSubClass");
							formatSubs.each(function(){
								if(regExp.exec($(this).html())){
									formatSubFlagIndex.push(parseInt($($(this).find('.formatSubFlagIdClass')).val()));
								}
							});
						}
						//获取依赖规格ID 结束
						var regExp = new RegExp('<input type=\"hidden\" name=\"formatSubIds.*?value=\"'+format.formatSubBeanList[j].id+'\" class=\"formatSubIdClass\">')
						var formatSubs = $(".formatSubClass");
						formatSubs.each(function(){
							if(regExp.exec($(this).html())){
								$($(this).find('.formatSelect')).selectpicker('val', formatSubFlagIndex);
								$($(this).find('.formatSelect')).selectpicker('refresh');
								console.log($($(this).find('.formatSelect')).val());
							}
						});
					}
				}
			}
		}
	}
	$('.formatSelect').on('show.bs.select',function(e){
		console.log('.show.bs.select.................');
	})
	$('.formatSelect').on('shown.bs.select',function(e){
		console.log('.shown.bs.select.................');
	})
	//关联处理结束.................

	var formatIndex = parseInt(${formatIndex}+''?${formatIndex}+'':0);
	var formatSubIndex = parseInt(${formatSubIndex}+''?${formatSubIndex}+'':0);
	function addFormat(){//款式添加
		formatIndex = formatIndex+1;
		var html='<tr class="formatHeadClass">'+
				'<td colspan="10">'+
				'<input type="hidden" class="formatIds" name="formatIds" value="">'+
				'<input type="hidden" name="formatFlagIds" value="'+formatIndex+'">'+
				'<span>规格名称</span>'+
				'<input type="text" name="formatName_'+formatIndex+'" placeholder="规格名称" class="form-control" value="${format.name }">'+
				'<span>需要价格</span>'+
				'<select name="needValue_'+formatIndex+'" class="form-control">'+
				'<option value="0">否</option>'+
				'<option value="1">是</option>'+
				'</select>'+
				'<button type="button" class="btn btn-danger btn-sm" onclick="deleteFormat(this)">删除规格</button>'+
				'<button type="button" class="btn btn-primary btn-sm" onclick="addFormatSub(this,'+formatIndex+')">添加单项</button>'+
				'</td>'+
				'</tr>';
		$(".formatBodyClass").append(html);
	}
	function addFormatSub(self,fIndex){//添加
		formatSubIndex = formatSubIndex+1;
		var html='<tr class="formatSubClass">'+
				'<td style="text-align:right;">'+
				'<input type="hidden" name="formatSubFlagId_'+fIndex+'" value="'+formatSubIndex+'" class="formatSubFlagIdClass">'+
				'<input type="hidden" name="formatSubIds_'+fIndex+'_'+formatSubIndex+'" value="" class="formatSubIdClass">'+
				'<input type="text" name="formatSubName_'+fIndex+'_'+formatSubIndex+'" placeholder="单项名称" class="form-control formatSubNameClass"></td>'+
				'<td><input type="text" name="price_'+fIndex+'_'+formatSubIndex+'" placeholder="价格" class="form-control formatSubPriceClass"></td>'+
				'<td><input type="text" name="vipPrice_'+fIndex+'_'+formatSubIndex+'" placeholder="Vip价格" class="form-control formatSubVipPriceClass"></td>'+
				'<td><select name="select_'+fIndex+'_'+formatSubIndex+'" class="form-control" >'+
				'<option value="1">可选</option>'+
				'<option value="0">不可选</option>'+
				'</select></td>'+
				'<td>'+
				'<select name="relyFormatSubId_'+fIndex+'_'+formatSubIndex+'" class="selectpicker show-tick formatSelect form-control" multiple data-live-search="false" ">'+
				'</select>'+
				'</td>'+
				'<td><button type="button" class="btn btn-danger btn-sm" onclick="deleteFormatSub(this)">删除</button></td>'+
				'</tr>';
		$('.formatHeadClass').each(function(index){
			if(this==self.parentNode.parentNode){
				if((index+1)>($('.formatHeadClass').length-1)){
					$(".formatBodyClass").append(html);
				}else{
					$($('.formatHeadClass')[index+1]).before(html)
				}
				return false;
			}
			if(($('.formatHeadClass').length-1)==index){
				$(".formatBodyClass").append(html);
			}
		})
		$('.formatSelect').selectpicker({
			noneSelectedText: '可选依赖',//没有值的时候button显示值
		});
	}
	/***/
	function deleteFormatSub(self){//删除
		BootstrapDialog.confirm({
			title:'删除 ',
			message:'确认删除当前选中的记录吗?',
			type: BootstrapDialog.TYPE_DANGER,
			closable: true, //
			draggable: true, //
			btnCancelLabel: '取消', //
			btnOKLabel: '确认', //
			btnOKClass: 'btn-warning', //
			callback: function(result) {
				if(result) {
					var spId = $(self.parentNode.parentNode).find('.formatSubIdClass').val();
					if(spId && spId>0){
						$.ajax({
							type: "POST",
							url: "${basePath }/goods/deleteFormatSub.html?id="+spId,
							timeout: 400000,
							data: null,
							cache: false,
							contentType: false,
							processData: false,
							success:function(result){

								result = JSON.parse(result);
								if(result.code==0){
									self.parentNode.parentNode.parentNode.removeChild(self.parentNode.parentNode);
								}else{
									alert(result.msg);
								}

							},
							error:function(xhr, errmsg){
								console.log("ajax-err-[]->"+JSON.stringify(errmsg)+"|"+xhr);
								alert('error');
							}
						});
					}else{
						self.parentNode.parentNode.parentNode.removeChild(self.parentNode.parentNode);
					}
				}else {
				}
			}
		});
	}
	/***/
	function deleteFormat(self){//款式删除
		BootstrapDialog.confirm({
			title:'删除 ',
			message:'确认删除当前选中的记录吗?',
			type: BootstrapDialog.TYPE_DANGER,
			closable: true, //
			draggable: true, //
			btnCancelLabel: '取消', //
			btnOKLabel: '确认', //
			btnOKClass: 'btn-warning', //
			callback: function(result) {
				if(result) {
					var spId = $(self.parentNode.parentNode).find('.formatIds').val();
					if(spId && spId>0){
						$.ajax({
							type: "POST",
							url: "${basePath }/goods/deleteFormat.html?id="+spId,
							timeout: 400000,
							data: null,
							cache: false,
							contentType: false,
							processData: false,
							success:function(result){

								result = JSON.parse(result);
								if(result.code==0){
									var nextEle = self.parentNode.parentNode.nextElementSibling;
									$(self.parentNode.parentNode).remove();
									while (nextEle && !$(nextEle).hasClass('formatHeadClass')) {
										var nextEleNext = nextEle.nextElementSibling;
										$(nextEle).remove();
										nextEle = nextEleNext;
									}
								}else{
									alert(result.msg);
								}

							},
							error:function(xhr, errmsg){
								console.log("ajax-err-[]->"+JSON.stringify(errmsg)+"|"+xhr);
								alert('error');
							}
						});
					}else{
						var nextEle = self.parentNode.parentNode.nextElementSibling;
						$(self.parentNode.parentNode).remove();
						while (nextEle && !$(nextEle).hasClass('formatHeadClass')) {
							var nextEleNext = nextEle.nextElementSibling;
							$(nextEle).remove();
							nextEle = nextEleNext;
						}
					}
				}else {
				}
			}
		});
	}
  
</script>
</body>
</html>