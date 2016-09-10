<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="description" content="">
    <meta name="author" content="">

    <title>${product.id==null?"添加新品":"修改新品"} - ${site.title}</title>
    <%@include file="../include/head.jsp"%>
    <link href="/static/css/form.css" rel="stylesheet">
    <script src="/static/libs/ckeditor/ckeditor.js"></script>
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
                        ${product.id==null?"添加新品":"修改新品"}
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-12">
                                <form id="inputForm" role="form" action="save.html" method="post">
                                    <input type="hidden" name="id" value="${product.id}">
                                    <div class="form-group col-lg-4">
                                        <label>新品名称</label>
                                        <input type="text" class="form-control" name="name" placeholder="请输入名称" value="${product.name}">
                                    </div>
                                   <%--  <div class="form-group col-lg-4">
                                        <label>优惠信息</label>
                                        <input type="text" class="form-control" name="illustrate" placeholder="请输入优惠信息" value="${product.illustrate}">
                                    </div> --%>
                                    <div class="form-group col-lg-4">
                                        <label>所属系列</label>
                                        <select name="seriesId" class="form-control">
                                            <c:forEach items="${series}" var="ser">
                                                <option value="${ser.id}" ${ser.id.equals(product.seriesId)?'selected="selected"':''}>${ser.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group col-lg-4">
                                        <label>所属类目</label>
                                        <select name="categoryId" class="form-control">
                                        	<option value="0">请选择</option>
                                            <c:forEach items="${categories}" var="category">
                                                <option value="${category.id}" ${category.id.equals(product.categoryId)?'selected="selected"':''}>${category.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <%-- <div class="form-group col-lg-4">
                                        <label>是否推荐</label><br>
                                        <div>
                                        <input type="checkbox" name="recommend" value="true" ${product.isRecommend?'checked="checked"':'' } >
                                        </div>
                                    </div> --%>
                                    <div class="form-group col-lg-4">
                                        <label>是否上架</label><br>
                                        <div>
                                        <input type="checkbox" name="sale" value="true" ${product.isSale?'checked="checked"':'' } >
                                        </div>
                                    </div>
                                    <div class="form-group col-lg-4">
                                        <label>排序</label>
                                        <input type="text" class="form-control" name="sort" placeholder="请输入排序" value="${product.sort}">
                                    </div>
                                    <c:if test="${!independent && supplierBeans!=null && fn:length(supplierBeans)>0}">
                                    <div class="form-group col-lg-12">
                                        <label>供应商</label>
                                       	<div class="form-group">
                                      		<c:forEach items="${supplierBeans}" var="supplier">
	                                       		 <label class="checkbox-inline">
		                                               <input type="checkbox" name="supplierIds" value="${supplier.id}" ${(product.id == supplier.productId && !(empty supplier.productId))?"checked=checked":'' }>${supplier.name}
		                                         </label>
                                       		</c:forEach>
                                        </div>
                                    </div>
                                    </c:if>
                                    <%-- <div class="col-lg-12">
                                    	<label>发货方式</label><br>
                                    	<table class="table table-striped" style="margin-bottom:0px;">
										   <thead>
										      <tr>
										         <th>发货方式</th>
										         <th>自提联系人</th>
										         <th>自提联系电话</th>
										         <th>提货时间</th>
										         <th>自提联系地址</th>
										         <th>删除</th>
										      </tr>
										   </thead>
										   <tbody id="shipmentTbody">
										   	  <c:forEach items="${product.shipmentModeList}" var="sm">
										   	  		 <tr>
												        <td>
												         	 <input type="hidden" name="shipmentModeIds" value="${sm.id}">
												         	 <select class="form-control" name="shipmentMode">
												         	 	<option value="1" ${sm.shiType==1?'selected="selected"':''}>自提</option>
												         	 	<option value="2" ${sm.shiType==2?'selected="selected"':''}>快递</option>
												         	 </select>
												         </td>
												         <td><input type="text" class="form-control" name="contactPerson" value="${sm.contactPerson}"></td>
												         <td><input type="text" class="form-control" name="contactPhone" value="${sm.contactPhone}"></td>
												         <td><input type="text" class="form-control" name="remarkDate" value="${sm.remarkDate}"></td>
												         <td><input type="text" class="form-control" name="description" value="${sm.description}"></td>
												         <td><input type="button" class="form-control" value="删除" onclick="deleteShipment(this)"></td>
												      </tr>
										   	  </c:forEach>
										   </tbody>
										</table>
										<input type="button" onclick="shipmentTbody()" value="增加">
                                    </div> --%>
                                    <div class="form-group col-lg-12">
                                        <label>产品简介</label>
                                        <textarea name="synopsis" rows="5" class="form-control">${product.synopsis}</textarea>
                                    </div>
                                    <div class="form-group col-lg-12" style="">
                                        <label>图片简介</label><br>
                                        <img src="${product.synopsisImg}" width="30%">
                                        <input type="text" class="form-control" id="synopsisImg" name="synopsisImg" placeholder="请选择图片简介" value="${product.synopsisImg}">
                                        <input class="imgFileUpload" type="file">
                                    </div>
                                    <div class="form-group col-lg-12">
                                        <label>产品详情</label>
                                        <div>
                                            <textarea name="detail" id="detail" rows="30" cols="80">${product.detail}
                                            </textarea>
                                            <script>
                                                CKEDITOR.replace( 'detail' );
                                            </script>
                                        </div>
                                    </div>
                                    <%-- <div class="form-group col-lg-12">
                                        <label>购买须知</label>
                                        <div>
                                            <textarea name="purchaseNotes" id="purchaseNotes" rows="30" cols="80">${product.purchaseNotes}
                                            </textarea>
                                            <script>
                                                CKEDITOR.replace( 'purchaseNotes' );
                                            </script>
                                        </div>
                                    </div> --%>
                                    <div class="form-group col-lg-12" style="">
                                        <label>主图</label><br>
                                        <img src="${product.image}" width="30%">
                                        <input type="text" class="form-control" id="mainImage" name="image" placeholder="请选择主图文件" value="${product.image}">
                                        <input class="imgFileUpload" type="file">
                                    </div>
                                    <div class="form-group col-lg-12">
                                        <label>宝贝图片</label>
                                        <div id="lunboImg">
                                            <c:forEach items="${product.imagesList}" var="image">
                                                <div style="display: table;padding: 10px;width: 100%">
                                                 	 <div style="display: table-cell;width: 20%;vertical-align:middle;">
                                                     	<img src="${image.imagesAddress }" width="100%">
                                                     </div>
                                                     <div style="display: table-cell;width: 70%;vertical-align:top;padding-left: 10px">
                                                    	 <input type="text" class="form-control" style="width: 50%;display: none;"  name="images" placeholder="请选择宝贝图片" value="${image.imagesAddress}" onchange="javascript:this.parentNode.parentNode.querySelector('img').src=this.value">
                                               	                      <%--   排序：<input style="width:10%" name="sorts" value="${image.sort}"> --%>
                                               	         <br>
                                               	       	  <%-- 设为首图<input type="radio" name="mainImgRad" ${image.imagesAddress==product.image?'checked="checked"':""} value="${image.imagesAddress}" onclick="javascript:$('#mainImage').val(this.value)"><br> --%>
                                               	         <br>
                                               	         <input type="button" value="上移" onclick="moveUp(this)">&nbsp;
                                               	         <input type="button" value="下移" onclick="moveDown(this)">&nbsp;
                                               	         <input type="button" value="删除" onclick="javascript:this.parentNode.parentNode.parentNode.removeChild(this.parentNode.parentNode)">
                                                 	 </div>
                                                 </div>
                                              </c:forEach>
                                         </div>
                                         <input class="multiImgFileUpload" style="margin-top: 20px" type="file">
                                    </div>
                                    <div class="form-group col-lg-12">${error}</div>
                                    <div class="form-group col-lg-12">
	                                    <c:choose>
	                                        <c:when test="${product.id==null}">
	                                        	<shiro:hasPermission name="product/insert">
		                                            <button type="submit" class="btn btn-success">确认添加</button>
		                                            <button type="reset" class="btn btn-info">重置表单</button>
	                                            </shiro:hasPermission>
	                                        </c:when>
	                                        <c:otherwise>
	                                        	<shiro:hasPermission name="product/update">
	                                            	<button type="submit" class="btn btn-success">确认修改</button>
	                                            </shiro:hasPermission>
	                                            <shiro:hasPermission name="product/delete">
	                                           		<button type="reset" class="btn btn-warning" data-toggle="modal" data-target="#myModal">删除产品</button>
	                                            </shiro:hasPermission>
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
<script type="application/javascript">
    $("#btnDelete").click(function(){
        $("#inputForm").attr("action", "delete.html");
        $("#inputForm").submit();
    });
    $("#btnCancel").click(function(){
        $("#inputForm").attr("action", "save.html");
    });
    
    function shipmentTbody(){
    	var html='<tr>'+
					'<td>'+
				    	 '<input type="hidden" name="shipmentModeIds">'+
				    	 '<select class="form-control" name="shipmentMode">'+
				    	 	'<option value="1">自提</option>'+
				    	 	'<option value="2">快递</option>'+
				    	 '</select>'+
				    '</td>'+
				    '<td><input type="text" class="form-control" name="contactPerson" value="${sm.contactPerson}"></td>'+
				    '<td><input type="text" class="form-control" name="contactPhone" value="${sm.contactPhone}"></td>'+
				    '<td><input type="text" class="form-control" name="remarkDate" value="${sm.remarkDate}"></td>'+
				    '<td><input type="text" class="form-control" name="description" value="${sm.description}"></td>'+
				    '<td><input type="button" class="form-control" value="删除" onclick="deleteShipment(this)"></td>'+
				 '</tr>';
    	$("#shipmentTbody").append(html);
    }
    function deleteShipment(self){
    	self.parentNode.parentNode.parentNode.removeChild(self.parentNode.parentNode);
    }
  
</script>
</body>
</html>