<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../include/taglib.jsp" %>
<!DOCTYPE html>
<html lang="cn">
<head>
    <meta name="desc" content="">
    <meta name="author" content="">

    <title>单品列表 - ${site.title}</title>
    <%@include file="../include/head.jsp" %>
</head>

<body>
<div id="wrapper">

    <!-- Navigation -->
    <%@include file="../include/nav.jsp" %>

    <div id="page-wrapper">
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
            	<form id="inputForm" action="item.html" method="post">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        单品列表
                        <div class="row">
                    		<div class="col-lg-12 form-inline pull-left">
                                <label>系列名称</label>
                                <input name="productName" type="text" class="form-control input-sm" value="${productName}" placeholder="输入新品名称">
                         		<label style="margin-left:10px">单品名称</label>
                                <input name="itemName" type="text" class="form-control input-sm" value="${itemName}" placeholder="输入单品名称">
                                <label style="margin-left:10px">销售方式</label>
                                <select name="saleType" class="form-control input-sm">
                                    <option value="0" ${saleType==0?'selected':''}>全部</option>
                                    <option value="1" ${saleType==1?'selected':''}>按克销售</option>
                                    <option value="2" ${saleType==2?'selected':''}>按件销售</option>
                                </select>
                                <label style="margin-left:10px">是否在售</label>
                                <select name="isSale" class="form-control input-sm">
                                    <option value="" >全部</option>
                                    <option value="true"  ${((!empty isSale) && isSale)&&isSale?'selected':''}>在售</option>
                                    <option value="false" ${((!empty isSale) && !isSale)?'selected':''}>下架</option>
                                </select>
                                <label style="margin-left:10px">是否推荐</label>
                                <select name="isRecommend" class="form-control input-sm">
                                    <option value="" >全部</option>
                                    <option value="true"  ${((!empty isRecommend) && isRecommend)?'selected=selected':''}>推荐</option>
                                    <option value="" ${((!empty isRecommend) && !isRecommend)?'selected=selected':''}>非推荐</option>
                                </select>
                                <button style="margin-left:10px" type="button" onclick="submitSearch()" class="btn btn-sm btn-info">查询</button>
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
                                    <th>单品名称</th>
                                    <th>系列名称</th>
                                    <th>销售方式</th>
                                    <!-- <th>单品描述</th> -->
                                    <th>是否在售</th>
                                    <th>是否推荐</th>
                                    <th>排序</th>
                                    <th>更新时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${page.list}" var="item">
                                    <tr>
                                        <td><%-- ${item.id} --%><input name="ids" type="checkbox" value="${item.id}"></td>
                                        <td style="padding:0;text-align:center;vertical-align:middle;"><a href="${item.image}" class="lightbox" title="${item.name}"><img src="${item.image}" style="width:22px;"></a></td>
                                        <td>${item.name}</td>
                                        <td>${item.newProductName}</td>
                                        <td>${item.saleType==0?"未设置":item.saleType==1?"按克销售":"按件销售"}</td>
                                       <%--  <td>${item.description}</td> --%>
                                        <td>${item.sale?"在售":"下架"}</td>
                                        <td>${item.isRecommend?"推荐":""}</td>
                                        <td>${item.sort}</td>
                                        <td><fmt:formatDate value="${item.updateTime}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
                                        <td><a href="/productItem/item/modify.html?id=${item.id}">编辑</a></td>
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

<%@include file="../include/footer.jsp" %>
<script>
function submitSearch() {
	$("#inputForm").attr("action","item.html");
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