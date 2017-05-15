<%@include file="../include/taglib.jsp" %>
<%@include file="../include/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="description" content="">
    <meta name="author" content="">

    <title>${item.id==null?"添加单品":"修改单品"} - ${site.title}</title>
    <%@include file="../include/head.jsp"%>
    <link href="/static/css/form.css" rel="stylesheet">
    <script src="/static/libs/ckeditor/ckeditor.js"></script>
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

    <div id="page-wrapper">
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        ${item.id==null?"添加单品":"修改单品"}
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-12">
                                <form id="inputForm" role="form" action="save.html" method="post">
                                    <input type="hidden" name="id" value="${item.id>0?item.id:0}">
                                    <div class="form-group col-lg-6">
                                        <label>单品名称</label>
                                        <input type="text" class="form-control" name="name" placeholder="请输入单品名称" value="${item.name}">
                                    </div>
                                    <div class="form-group col-lg-6">
                                        <label>条形码</label>
                                        <input type="text" class="form-control" name="barcode" placeholder="请输条形码" value="${item.barcode}">
                                    </div>
                                    <div class="form-group col-lg-6">
                                        <label>所属新品</label>
                                        <select name="productId" class="form-control">
                                        	<option value="0">请选择</option>
                                        	<c:forEach items="${newProducts }" var="newProduct">
                                        		<option value="${newProduct.id }" ${item.productId == newProduct.id?'selected="selected"':''}>${newProduct.name}--${newProduct.seriesName}</option>
                                        	</c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group col-lg-6">
                                    	<div class="row">
                                    		<div class="form-group col-lg-6">
		                                        <label>工费</label>
		                                        <input type="text" class="form-control" name="fee" onkeyup="value=value.replace(/[^\d\.]/g,'')" placeholder="请输入工费" value="${item.fee}">
	                                        </div>
	                                        <div class="form-group col-lg-6">
		                                        <label>VIP工费</label>
		                                        <input type="text" class="form-control" name="vipFee" onkeyup="value=value.replace(/[^\d\.]/g,'')" placeholder="请输入VIP工费" value="${item.vipFee}">
	                                        </div>
                                    	</div>
                                    </div>
                                    <div class="form-group col-lg-6">
                                        <label>销售类型</label>
                                        <div>
                                            <label class="radio-inline">
                                                <input type="radio" name="saleType" onclick="saleTypeClick(1)" value="1" ${item.saleType=='1'?'checked="checked"':''}>按克计价
                                            </label>
                                            <label class="radio-inline">
                                                <input type="radio" name="saleType" onclick="saleTypeClick(2)" value="2" ${item.saleType=='2'?'checked="checked"':''}>按件计价
                                            </label>
                                        </div>
                                    </div>
                                    <div class="form-group col-lg-6">
                                        <div class="row">
                                    		<div class="form-group col-lg-6">
		                                        <label>是否上架</label>
		                                        <div>
		                                            <label class="radio-inline">
		                                                <input type="radio" name="sale" value="true" ${item.sale?'checked="checked"':''}>是
		                                            </label>
		                                            <label class="radio-inline">
		                                                <input type="radio" name="sale" value="false" ${!item.sale?'checked="checked"':''}>否
		                                            </label>
		                                        </div>
	                                        </div>
	                                        <div class="form-group col-lg-6">
		                                         <label>是否推荐</label>
		                                         <div>
		                                            <label class="radio-inline">
		                                                <input type="radio" name="isRecommend" value="true" ${item.isRecommend?'checked="checked"':''}>是
		                                            </label>
		                                            <label class="radio-inline">
		                                                <input type="radio" name="isRecommend" value="false" ${!item.isRecommend?'checked="checked"':''}>否
		                                            </label>
		                                         </div>
	                                        </div>
                                    	</div>
                                    </div>
                                    <div class="form-group col-lg-6">
                                        <label>单品类型</label>
                                        <select name="categoryId" class="form-control">
                                        	<option value="0">请选择</option>
                                        	<c:forEach items="${productItemCategorys}" var="productItemCategory">
                                        		<option value="${productItemCategory.id }" ${item.categoryId == productItemCategory.id?'selected="selected"':''}>${productItemCategory.name}</option>
                                        	</c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group col-lg-6">
                                        <label>排序</label>
                                        <input type="number" class="form-control" name="sort" placeholder="请输入排序" value="${item.sort}">
                                    </div>
                                    <div class="col-lg-12">
                                    	<label>规格</label><br>
                                    	<table class="table table-striped zbgj-input-clear" style="margin-bottom:0px;">
										   <thead>
										      <tr>
										         <th>名称</th>
										         <th>规格类型</th>
										         <th>前缀符号</th>
										      	 <th style="display: none">单价|克重</th>
										         <th>开始值</th>
										         <th>结束值</th>
										         <th>单位</th>
										         <th>是否可选</th>
										         <th>删除</th>
										      </tr>
										   </thead>
										   <tbody id="specificationBody">
										   	  <c:forEach items="${item.specificationList}" var="sp">
										   	  		 <tr>
												        <td style="width:8%;">
												         	<input type="hidden" name="spIds" value="${sp.id}">
												         	<input type="text" class="form-control" name='spName' value="${sp.name }">
												         </td>
												         <td >
												         	  <select name='spSpeType' class="form-control">
														      		<option ${sp.speType==1?'selected="selected"':'' } value="1">重量规格</option>
														      		<option ${sp.speType==2?'selected="selected"':'' } value="2">数量规格</option>
														      		<%-- <option ${sp.speType==3?'selected="selected"':'' } value="3">费用规格</option> --%>
														      </select>
												         </td>
												         <td style="width: 8%;"><input type="text"  name='spPrefix' class="form-control" value="${sp.prefix }"></td>
												         <td style="display: none"><input type="text" style="display: none" name='spUnitPrice' class="form-control" value="${sp.unitPrice }"></td>
												         <td ><input type="text" name='spStartValue'  onkeyup="value=value.replace(/[^\d\.]/g,'')" class="form-control" value="${sp.startValue}"></td>
												         <td ><input type="text" name='spEndValue'  onkeyup="value=value.replace(/[^\d\.]/g,'')" class="form-control" value="${sp.endValue}"></td>
												         <td style="width: 8%;"><input type="text" name='spSpeShowUnit' class="form-control" value="${sp.speShowUnit }"></td>
												         <td >
												         	  <select name='spSpeSelect' class="form-control">
														      		<option ${sp.isSelect?'selected="selected"':'' } value="1">是</option>
														      		<option ${!sp.isSelect?'selected="selected"':'' } value="2">否</option>
														      		<%-- <option ${sp.speType==3?'selected="selected"':'' } value="3">费用规格</option> --%>
														      </select>
												         </td>
												         <td ><input type="button" class="form-control" value="删除" onclick="deleteGuiGe(this)"></td>
												      </tr>
										   	  </c:forEach>
										   </tbody>
										</table>
										<div class="btn-group">
										  <button class="btn btn-default btn-sm dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
										    规格 <span class="caret"></span>
										  </button>
										 <ul class="dropdown-menu" style="">
											  <li style="text-align: center;" onclick="addSpecification('kg')">克重</li>
											  <li style="text-align: center;" onclick="addSpecification('')">件</li>
										  </ul>
										</div>
                                    </div>
                                    <div class="form-group col-lg-12">
                                        <label style="margin-bottom:-10px;margin-top: 10px">款式</label>
									    <div id="proItemFormatBody">
									        <c:set var="formatIndex" value="0"></c:set>
									   	    <c:forEach items="${item.proItemFormatList}" var="pif" varStatus="pStatus">
									   	    	<div class="row" style="padding-left:15px;margin-top:10px;">
										   	    		<div class="input-group" style="width: 80px;float:left;margin-right:10px;">
											   	    		<input name="proItemFormatIds" type="hidden" value="${pStatus.index+1}">
											   	    		<input placeholder="款式名称" style="padding-left:0;padding-right:0;" name="proItemFormatName${pStatus.index+1}" class="form-control" value="${pif.name }">
										   	    		</div>
										   	  			<c:forEach items="${pif.formatList}" var="format" varStatus="status">
										   	  				<div style="width: 260px;float:left;margin-right:10px;">
										   	  					<div class="input-group">
										   	  					  <input type="hidden" name="formatIds${pStatus.index+1}" value="${formatIndex+(status.index+1)}">
															      <input placeholder="名称" name="formatName${formatIndex+(status.index+1)}" class="form-control" style="width:20%;padding-left:0;padding-right:0;" type="text" value="${format.name}">
															      <input placeholder="工费" onkeyup="value=value.replace(/[^\d\.]/g,'')" name="formatFee${formatIndex+(status.index+1)}" class="form-control" style="width:20%;padding-left:0;padding-right:0;" type="text" value="${format.fee}">
															      <input placeholder="VIP工费" onkeyup="value=value.replace(/[^\d\.]/g,'')" name="formatVipFee${formatIndex+(status.index+1)}" class="form-control" style="width:20%;padding-left:0;padding-right:0;" type="text" value="${format.vipFee}">
															      <select name="formatSelect${formatIndex+(status.index+1)}" style="width:20%;padding-left:0;padding-right:0;" class="input-group-addon">
															      		<option value="true" ${format.select==true?'selected = "selected"':''}>可用</option>
															      		<option value="false" ${format.select==false?'selected = "selected"':''}>不可用</option>
															      </select>
															      <input type="button" onclick="formatDelete(this)" value="删除">
															    </div>
										   	  				</div>
										   	  			</c:forEach>
										   	  			<c:set var="formatIndexSize" value="${fn:length(pif.formatList)}"></c:set>
										   	  			<c:set var="formatIndex" value="${formatIndex+formatIndexSize }"></c:set>
										   	  			
										   	  			<div style="width:230px;float:left;margin-left:10px;">
										   	  				<label style="width:30px;float:left;display:block;height:34px;line-height:34px;">工费</label>
										   	  				<select style="width:90px;float:left;margin-right:10px;" style="padding-left:0;padding-right:0;" name="proItemFormatNeedFee${pStatus.index+1}" class="form-control">
											   	    			<option ${pif.needFee?'':'selected=selected' } value="false">不可用</option>
											   	    			<option ${!pif.needFee?'':'selected=selected' } value="true">可用</option>
											   	    		</select>
										   	  				<input type="button" onclick="formatAdd(this,${pStatus.index+1})" value="添加">
										   	  				<input type="button" onclick="proItemFormatDelete(this)" value="删除">
										   	  			</div>
									   	  		</div>
									   	  	</c:forEach>
									   	  	<c:set var="proItemFormatIndex" value="${fn:length(item.proItemFormatList)}"></c:set>
									    </div>
                                        <input type="button" onclick="proItemFormatAdd()" value="添加款式">
                                    </div>
                                    <div class="form-group col-lg-12">
                                        <label>特殊提醒</label>
                                        <textarea name="remind" style="width: 100%;height:80px" class="form-control">${item.remind}</textarea>
                                    </div>
                                    <div class="form-group col-lg-12">
                                        <label>单品描述</label>
                                        <div>
                                            <textarea name="description" class="form-control" id="detail" style="width: 100%;height:80px">${item.description}</textarea>
                                        </div>
                                    </div>
                                    <div class="form-group col-lg-12" style="">
                                        <label>主图文件</label>
                                        <div>
	                                        <img src="${item.image}" width="30%">
	                                        <input type="text" class="form-control" id="mainImage" name="image" placeholder="请选择主图文件" value="${item.image}">
	                                        <input class="imgFileUpload" type="file">
                                        </div>
                                    </div>
                                    <div class="form-group col-lg-12" style="">
                                        <label>搜索图文件</label>
                                        <div>
	                                        <img src="${item.imageSearch}" width="30%">
	                                        <input type="text" class="form-control" name="imageSearch" placeholder="请选择搜索图文件" value="${item.imageSearch}">
	                                        <input class="imgFileUpload" type="file">
                                        </div>
                                    </div>
                                    <div class="form-group col-lg-12">
                                        <label>宝贝图片</label>
                                        <div id="lunboImg">
                                            <%-- <c:forEach items="${item.productItemImagesList}" var="image">
                                                <div>
                                                    <img src="${image.images}" width="30%">
                                                    <input type="text" class="form-control"  name="images" placeholder="请选择轮播图片" value="${image.images}" onchange="javascript:this.parentNode.querySelector('img').src=this.value">
                                               	          排序：<input style="width:10%" name="sorts" value="${image.sort}"><input type="button" value="删除" onclick="javascript:this.parentNode.parentNode.removeChild(this.parentNode)">
                                                </div>
                                            </c:forEach> --%>
                                            <c:forEach items="${item.productItemImagesList}" var="image">
                                                <div style="display: table;padding: 10px;width: 100%">
                                                 	 <div style="display: table-cell;width: 20%;vertical-align:middle;">
                                                     	<img src="${image.images }" width="100%">
                                                     </div>
                                                     <div style="display: table-cell;width: 70%;vertical-align:top;padding-left: 10px">
                                                    	 <input type="text" class="form-control" style="width: 50%;display: none;"  name="images" placeholder="请选择宝贝图片" value="${image.images}" onchange="javascript:this.parentNode.parentNode.querySelector('img').src=this.value">
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
                                    <div class="form-group col-lg-12">
                                        <c:choose>
	                                        <c:when test="${item.id==null}">
	                                        	<shiro:hasPermission name="productItem/insert">
		                                            <button type="button" class="btn btn-success" id="btnSave">确认添加</button>
		                                            <button type="reset" class="btn btn-info">重置表单</button>
	                                            </shiro:hasPermission>
	                                        </c:when>
	                                        <c:otherwise>
	                                        	<shiro:hasPermission name="productItem/update">
	                                            	<button type="button" class="btn btn-success" id="btnSave">确认修改</button>
	                                            </shiro:hasPermission>
	                                            <shiro:hasPermission name="productItem/delete">
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
	function saleTypeClick(val){
		
	}
	function addSpecification(opt){
		var html = '<tr>'+
				         '<td style="width: 10%">'+
					     	'<input type="hidden" name="spIds" value="${sp.id}">'+
					     	'<input type="text" class="form-control" name="spName" value="'+(opt=='kg'?'克重':'件')+'">'+
					     '</td>'+
					     '<td>'+
					     	  '<select name="spSpeType" class="form-control">'+
						      		'<option value="1">重量规格</option>'+
						      		'<option value="2">数量规格</option>'+
						      		<%-- <option value="3">费用规格</option> --%>
						      '</select>'+
					     '</td>'+
					     '<td style="width: 10%"><input type="text"  name="spPrefix" class="form-control" value=""></td>'+
					     '<td style="display: none"><input type="text" name="spUnitPrice" class="form-control" value=""></td>'+
					     '<td><input type="text" name="spStartValue" onkeyup="value=value.replace(/[^\\d\\.]/g,\'\')" class="form-control" value=""></td>'+
					     '<td><input type="text" name="spEndValue" onkeyup="value=value.replace(/[^\\d\\.]/g,\'\')" class="form-control" value=""></td>'+
					     '<td style="width: 10%"><input type="text" name="spSpeShowUnit" class="form-control" value=""></td>'+
					     '<td>'+
					     	  '<select name="spSpeSelect" class="form-control">'+
						      		'<option value="1">是</option>'+
						      		'<option value="2">否</option>'+
						      		<%-- <option value="3">费用规格</option> --%>
						      '</select>'+
					     '</td>'+
					     '<td><input type="button" class="form-control" value="删除" onclick="deleteGuiGe(this)"></td>'+
					  '</tr>';
		$("#specificationBody").append(html); 
	}
	var baseUrl = window.location.href.substring(0,window.location.href.indexOf('productItem')+'productItem'.length);
    $("#btnDelete").click(function(){
        $("#inputForm").attr("action", baseUrl+"/item/delete.html");
        $("#inputForm").submit();
    });
    $("#btnSave").click(function(){
        $("#inputForm").attr("action", baseUrl+"/item/save.html");
        $("#inputForm").submit();
    });
    /**删除规格*/
    function deleteGuiGe(obj){
    	var self = obj;
    	BootstrapDialog.confirm({
    		title:'删除 ',
    		message:'确认删除当前选中的记录吗?',
    		type: BootstrapDialog.TYPE_DANGER, // <-- Default value is BootstrapDialog.TYPE_PRIMARY
            closable: true, // <-- Default value is false
            draggable: true, // <-- Default value is false
            btnCancelLabel: '取消', // <-- Default value is 'Cancel',
            btnOKLabel: '确认', // <-- Default value is 'OK',
            btnOKClass: 'btn-warning', // <-- If you didn't specify it, dialog type will be used,
            callback: function(result) {
                // result will be true if button was click, while it will be false if users close the dialog directly.
                if(result) {
                	var spId = $(self.parentNode.parentNode).find('input[name=spIds]').val();
	            	if(spId && spId>0){
	        			$.ajax({
	        			    type: "POST",
	        			    url: "/productItem/item/deleteSpe.html?id="+spId,
	        			    timeout: 400000,
	        			    data: null,
	        			    cache: false,
	        	            contentType: false,
	        	            processData: false,
	        	            success:function(result){
	        	            	
	        	            	$('#deleteSpeModal').modal('hide');
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
	        			$('#deleteSpeModal').modal('hide');
	        			obj.parentNode.parentNode.parentNode.removeChild(obj.parentNode.parentNode);
	        		}
                }else {
                }
            }
    	});
    	
    }
    
    var proItemFormatIndex = ${proItemFormatIndex},formatIndex = ${formatIndex}
    function proItemFormatDelete(self){//款式删除
 		self.parentNode.parentNode.parentNode.removeChild(self.parentNode.parentNode);
 	}
	function proItemFormatAdd(){//款式添加
		proItemFormatIndex = proItemFormatIndex+1;
		formatIndex = formatIndex+1;
		var html='<div class="row" style="padding-left:15px;margin-top:10px;">'+
		   	    	'<div style="width: 80px;float:left;margin-right:10px;">'+
				   		'<input name="proItemFormatIds" type="hidden" value="'+(proItemFormatIndex)+'">'+
				   		'<input placeholder="款式名称" name="proItemFormatName'+proItemFormatIndex+'" class="form-control" value="">'+
				   	'</div>'+
			 		'<div style="width: 260px;float:left;margin-right:10px;">'+
	  					'<div class="input-group">'+
	  					  '<input type="hidden" name="formatIds'+(proItemFormatIndex)+'" value="'+formatIndex+'">'+
					      '<input placeholder="名称" name="formatName'+formatIndex+'" class="form-control" style="width: 20%;padding-left:0;padding-right:0;" type="text">'+
					      '<input placeholder="工费" name="formatFee'+formatIndex+'" onkeyup="value=value.replace(/[^\\d\\.]/g,\'\')" class="form-control" style="width: 20%;padding-left:0;padding-right:0;" type="text">'+
					      '<input placeholder="VIP工费" name="formatVipFee'+formatIndex+'" onkeyup="value=value.replace(/[^\\d\\.]/g,\'\')" class="form-control" style="width: 20%;padding-left:0;padding-right:0;" type="text">'+
					      '<select name="formatSelect'+formatIndex+'" style="width:20%;padding-left:0;padding-right:0;" class="input-group-addon" >'+
					      		'<option value="true">可用</option>'+
					      		'<option value="false">不可用</option>'+
					      '</select>'+
					      '<input type="button" onclick="formatDelete(this)" value="删除">'+
					    '</div>'+
	  				'</div>'+
	  				'<div style="width:230px;float:left;margin-left:10px;">'+
	   	  				'<label style="width:30px;float:left;display:block;height:34px;line-height:34px;">工费</label>'+
	   	  				'<select style="width:90px;float:left;margin-right:10px;" name="proItemFormatNeedFee'+(proItemFormatIndex)+'" class="form-control">'+
		   	    			'<option selected="selected" value="false">不可用</option>'+
		   	    			'<option value="true">可用</option>'+
		   	    		'</select>'+
	   	  				'<input type="button" onclick="formatAdd(this,'+(proItemFormatIndex)+')" value="添加">'+
	   	  				'<input type="button" onclick="proItemFormatDelete(this)" value="删除">'+
	   	  			'</div>'
				'</div>';
 		$("#proItemFormatBody").append(html);
 	}
	
	function formatDelete(self){//删除
		self.parentNode.parentNode.parentNode.removeChild(self.parentNode.parentNode);
 	}
	function formatAdd(self,pFIndex){//添加
		formatIndex = formatIndex+1;
 		var html =  '<div style="width: 260px;float:left;margin-right:10px;">'+
 						'<div class="input-group">'+
						  '<input type="hidden" name="formatIds'+(pFIndex)+'" value="'+formatIndex+'">'+
					      '<input placeholder="名称" name="formatName'+formatIndex+'" class="form-control" style="width:20%;padding-left:0;padding-right:0;" type="text" value="">'+
					      '<input placeholder="工费" name="formatFee'+formatIndex+'" class="form-control" style="width:20%;padding-left:0;padding-right:0;" type="text">'+
					      '<input placeholder="VIP工费" name="formatVipFee'+formatIndex+'" class="form-control" style="width:20%;padding-left:0;padding-right:0;" type="text">'+
					      '<select name="formatSelect'+formatIndex+'" style="width:20%;padding-left:0;padding-right:0;" class="input-group-addon">'+
					      		'<option value="true">可用</option>'+
					      		'<option value="false">不可用</option>'+
					      '</select>'+
					      '<input type="button" onclick="formatDelete(this)" value="删除">'+
					    '</div>'+
				   '</div>';
		$(self.parentNode).before(html);
 	}
  
</script>
</body>
</html>