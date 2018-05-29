<%@include file="../include/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="description" content="">
    <meta name="author" content="">

    <title>${item.id==null?"添加商品":"修改商品"} - ${site.title}</title>
    <%@include file="../include/head.jsp"%>
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
                                    <div class="form-group col-lg-12">
                                        <label style="margin-bottom:-10px;margin-top: 10px">款式</label>
									    <div id="formatBody">
									        <c:set var="formatSubIndex" value="0"></c:set>
									   	    <c:forEach items="${item.formatBeanList}" var="format" varStatus="pStatus">
									   	    	<div class="row" style="padding-left:15px;margin-top:10px;">
										   	    		<div class="input-group" style="width: 80px;float:left;margin-right:10px;">
											   	    		<input name="formartIds" type="hidden" value="${pStatus.index+1}">
											   	    		<input placeholder="款式名称" style="padding-left:0;padding-right:0;" name="formatName_${pStatus.index+1}" class="form-control" value="${format.name }">
										   	    		</div>
										   	  			<c:forEach items="${format.formatSubBeanList}" var="formatSub" varStatus="status">
                                                            <c:set var="formatSubIndex" value="${formatSubIndex+1 }"/>
										   	  				<div style="width: 260px;float:left;margin-right:10px;">
										   	  					<div class="input-group">
										   	  					  <input type="hidden" name="formatSubIds_${pStatus.index+1}" value="${formatSubIndex+(status.index+1)}">
															      <input placeholder="名称" name="formatSubName_${formatSubIndex+(status.index+1)}" class="form-control" style="width:20%;padding-left:0;padding-right:0;" type="text" value="${formatSub.name}">
															      <input placeholder="价格" onkeyup="value=value.replace(/[^\d\.]/g,'')" name="formatPrice_${formatSubIndex+(status.index+1)}" class="form-control" style="width:20%;padding-left:0;padding-right:0;" type="text" value="${formatSub.price}">
															      <select name="formatSubSelect_${formatSubIndex+(status.index+1)}" style="width:20%;padding-left:0;padding-right:0;" class="input-group-addon">
															      		<option value="true" ${formatSub.select==1?'selected = "selected"':''}>可用</option>
															      		<option value="false" ${formatSub.select==0?'selected = "selected"':''}>不可用</option>
															      </select>
															      <input type="button" onclick="formatSubDelete(this)" value="删除">
															    </div>
										   	  				</div>
										   	  			</c:forEach>
										   	  			<div style="width:230px;float:left;margin-left:10px;">
										   	  				<label style="width:30px;float:left;display:block;height:34px;line-height:34px;">工费</label>
										   	  				<select style="width:90px;float:left;margin-right:10px;" style="padding-left:0;padding-right:0;" name="formatNeedPrice_${pStatus.index+1}" class="form-control">
											   	    			<option ${format.needPrice?'':'selected=selected' } value="false">不可用</option>
											   	    			<option ${!format.needPrice?'':'selected=selected' } value="true">可用</option>
											   	    		</select>
										   	  				<input type="button" onclick="formatSubAdd(this,${pStatus.index+1})" value="添加">
										   	  				<input type="button" onclick="formatDelete(this)" value="删除">
										   	  			</div>
									   	  		</div>
									   	  	</c:forEach>
									   	  	<c:set var="formatIndex" value="${fn:length(item.formatBeanList)}"></c:set>
									    </div>
                                        <input type="button" onclick="formatAdd()" value="添加款式">
                                    </div>
                                    <div class="form-group col-lg-12">
                                        <label>商品详情</label>
                                        <div>
                                            <textarea name="description" class="form-control" id="detail" style="width: 100%;height:80px">${item.detail}</textarea>
                                        </div>
                                    </div>
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
                                                 	 <div style="display: table-cell;width: 20%;vertical-align:middle;">
                                                     	<img src="${image.picUrl }" width="100%">
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
<div class="modal fade" id="deleteSpeModal" tabindex="-1" role="" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" id="title">删除确认</h4>
            </div>
            <div class="modal-body">
            	    确认要删除这条规格吗?
            </div>
            <div class="modal-footer">
                <button id="deleteSpeOK" type="button" class="btn btn-danger">删除</button>
                <button id="btnCancel" type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
	                                            
<%@include file="../include/footer.jsp"%>
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

    var formatIndex = ${formatIndex},formatSubIndex = ${formatSubIndex}
    function formatDelete(self){//款式删除
 		self.parentNode.parentNode.parentNode.removeChild(self.parentNode.parentNode);
 	}
	function formatAdd(){//款式添加
        formatIndex = formatIndex+1;
        formatSubIndex = formatSubIndex+1;
		var html='<div class="row" style="padding-left:15px;margin-top:10px;">'+
		   	    	'<div style="width: 80px;float:left;margin-right:10px;">'+
				   		'<input name="formatIds" type="hidden" value="'+(formatIndex)+'">'+
				   		'<input placeholder="款式名称" name="formatName_'+formatIndex+'" class="form-control" value="">'+
				   	'</div>'+
			 		'<div style="width: 260px;float:left;margin-right:10px;">'+
	  					'<div class="input-group">'+
	  					  '<input type="hidden" name="formatSubIds_'+(formatSubIndex)+'" value="'+formatSubIndex+'">'+
					      '<input placeholder="名称" name="formatSubName_'+formatSubIndex+'" class="form-control" style="width: 20%;padding-left:0;padding-right:0;" type="text">'+
					      '<input placeholder="工费" name="formatSubPrice_'+formatSubIndex+'" onkeyup="value=value.replace(/[^\\d\\.]/g,\'\')" class="form-control" style="width: 20%;padding-left:0;padding-right:0;" type="text">'+
					      '<select name="formatSubSelect_'+formatSubIndex+'" style="width:20%;padding-left:0;padding-right:0;" class="input-group-addon" >'+
					      		'<option value="true">可用</option>'+
					      		'<option value="false">不可用</option>'+
					      '</select>'+
					      '<input type="button" onclick="formatDelete(this)" value="删除">'+
					    '</div>'+
	  				'</div>'+
	  				'<div style="width:230px;float:left;margin-left:10px;">'+
	   	  				'<label style="width:30px;float:left;display:block;height:34px;line-height:34px;">工费</label>'+
	   	  				'<select style="width:90px;float:left;margin-right:10px;" name="formatNeedPrice_'+(formatIndex)+'" class="form-control">'+
		   	    			'<option selected="selected" value="false">不可用</option>'+
		   	    			'<option value="true">可用</option>'+
		   	    		'</select>'+
	   	  				'<input type="button" onclick="formatSubAdd(this)" value="添加">'+
	   	  				'<input type="button" onclick="formatDelete(this)" value="删除">'+
	   	  			'</div>'
				'</div>';
 		$("#formatBody").append(html);
 	}
	
	function formatSubDelete(self){//删除
		self.parentNode.parentNode.parentNode.removeChild(self.parentNode.parentNode);
 	}
	function formatSubAdd(self){//添加
        formatSubIndex = formatSubIndex+1;
 		var html =  '<div style="width: 260px;float:left;margin-right:10px;">'+
 						'<div class="input-group">'+
						  '<input type="hidden" name="formatIds_'+(formatIndex)+'" value="'+formatIndex+'">'+
					      '<input placeholder="名称" name="formatSubName_'+formatIndex+'" class="form-control" style="width:20%;padding-left:0;padding-right:0;" type="text" value="">'+
					      '<input placeholder="价格" name="formatSubPrice_'+formatIndex+'" class="form-control" style="width:20%;padding-left:0;padding-right:0;" type="text">'+
					      '<select name="formatSubSelect_'+formatIndex+'" style="width:20%;padding-left:0;padding-right:0;" class="input-group-addon">'+
					      		'<option value="true">可用</option>'+
					      		'<option value="false">不可用</option>'+
					      '</select>'+
					      '<input type="button" onclick="formatSubDelete(this)" value="删除">'+
					    '</div>'+
				   '</div>';
		$(self.parentNode).before(html);
 	}
  
</script>
</body>
</html>