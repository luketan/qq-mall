<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../include/taglib.jsp"%>
<!DOCTYPE html>
<html lang="cn">
<head>
    <meta name="desc" content="">
    <meta name="author" content="">

    <title>新品列表 - ${site.title}</title>
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
            	<form id="inputForm" action="list.html" method="post">
                <div class="panel panel-default">
                    <div class="panel-heading">
                       	 新品列表
                         <div class="row">
                    		<div class="col-lg-12 form-inline pull-left">
                                <input name="key" type="text" class="form-control input-sm" value="${key}" placeholder="输入关键字,回车键搜索">
                         		&nbsp;&nbsp;
                         		<label>是否在售</label>
                                <select name="sale" class="form-control input-sm" >
                                    <option value="">全部方式</option>
                                    <option value="1" ${sale==1?'selected':''}>在售</option>
                                    <option value="0" ${sale==0?'selected':''}>下架</option>
                                </select>
                                &nbsp;&nbsp;
                                <button type="button" onclick="submitSearch()" class="btn btn-sm btn-info">查询</button>
                            </div>
                          </div>
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="table-responsive">
                            <table class="table table-striped table-bordered table-hover" style="margin-bottom:0px;">
                                <thead>
                                <tr>
                                    <th style="width:20px;"></th>
                                    <th>图片</th>
                                    <th>名称</th>
                                    <th>系列名称</th>
                                    <th>类别名称</th>
                                    <th>排序</th>
                                    <th>是否上架</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${page.list}" var="product">
                                    <tr>
                                        <td><%-- ${item.id} --%><input name="ids" type="checkbox" value="${product.id}"></td>
                                        <td style="padding:0;text-align:center;vertical-align:middle;"><a href="${product.image}" class="lightbox" title="${product.name}"><img src="${product.image}" style="width:22px;"></a></td>
                                        <td>${product.name}</td>
                                        <td>${product.seriesName}</td>
                                        <td>${product.categoryName}</td>
                                        <td>${product.sort}</td>
                                        <td>${product.isSale?"是":"否"}</td>
                                        <td><a href="/product/modify.html?id=${product.id}">编辑</a></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            <shiro:hasPermission name="productItem/update">
                            	<input type="hidden" name="saleVal" id="saleVal">
	                            <button type="button" class="btn btn-sm btn-info" onclick="javascript:$('input[type=checkbox]').each(function(){this.checked = true;})">全选</button><button type="button" class="btn btn-sm btn-info" onclick="javascript:$('input[type=checkbox]').each(function(){this.checked = false;})">全不选</button>&nbsp;&nbsp;
	                            <button type="button" onclick="updateSale(true)" class="btn btn-sm btn-info">上线</button><button type="button" onclick="updateSale(false)" class="btn btn-sm btn-info">下架</button>
                        	</shiro:hasPermission>
                        </div>
                        <!-- /.table-responsive -->
                        ${page}
                    </div>
                    <!-- /.panel-body -->
                </div>
                </form>
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
function enterKeydown(val, e) {
    var keyPressed = -1;
    if (window.event) {
        keyPressed = window.event.keyCode; // IE
    } else {
        keyPressed = e.which; // Firefox
    }
    if (keyPressed == 13) {
        if (val != null) {
            submitSearch()
        } else {

        }
    }
}

function submitSearch() {
	$("#inputForm").attr("action","list.html");
    $("#inputForm").submit();
}

function updateSale(tag) {
	var isSelected = false
	$('input[type=checkbox]').each(function(){
		if(this.checked == true){
			isSelected = true;
		}
	})
	if(!isSelected){
		BootstrapDialog.show({
			title:"错误",
			type: BootstrapDialog.TYPE_DANGER,
			message:"请选择单品！",
			btnCancelLabel: '确定', 
			});
		return;
	}
	$("#saleVal").val(tag);
	BootstrapDialog.show({
		title:'修改 ',
		message:'确认'+(tag?"上架":"下架")+'当前选中的记录吗?',
		type: BootstrapDialog.TYPE_DANGER, // <-- Default value is BootstrapDialog.TYPE_PRIMARY
        closable: true, // <-- Default value is false
        draggable: true, // <-- Default value is false
        btnCancelLabel: '取消', // <-- Default value is 'Cancel',
        buttons: [{
            id: 'btn-1',
            label: '确认',
            action: function(dialog){
                var $button = this;
                $button.disable();
                $button.spin();
                dialog.setClosable(false);
                $.ajax({
    			    type: "POST",
    			    url: "batchUpdateSale.html?"+$("#inputForm").serialize(),
    			    timeout: 400000,
    			    data:null ,
    			    cache: false,
    	            contentType: false,
    	            processData: false,
    	            success:function(result){
    	            	dialog.close();
    	            	
    	            	result = JSON.parse(result);
    	            	if(result.code==0){
    	            		window.location.reload();
    	            	}else{
    	            		BootstrapDialog.alert(result.msg);
    	            	}
    	            	
    	            },
    	            error:function(xhr, errmsg){
    	            	dialog.close();
    			    	console.log("ajax-err-[]->"+JSON.stringify(errmsg)+"|"+xhr);
    			    	BootstrapDialog.alert('error');
    			    }
    			}); 
            }
        }]
	});
	
}
</script>
</body>
</html>