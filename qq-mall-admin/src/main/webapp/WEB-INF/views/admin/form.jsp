<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="description" content="">
    <meta name="author" content="">

    <title>${item.id==null?"添加":"修改"}系统权限 - ${site.title}</title>

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
                        ${item.id==null?"添加":"修改"}管理
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-6">
                                <form id="inputForm" role="form" action="saveOrUpdate.html" method="post">
                                    <input type="hidden" name="id" value="${item.id}">
                                    <div class="form-group">
                                        <label>登录名称</label>
                                        <input type="text" name="loginName" value="${item.loginName}" class="form-control" placeholder="请输入登录名称">
                                    </div>
                                    <c:if test="${item.id==null}">
                                    	<div class="form-group">
	                                        <label>密码</label>
	                                        <input type="password" name="password" class="form-control" placeholder="请输入密码">
                                 		</div>
                                    </c:if>
                                    <div class="form-group">
                                        <label>用户名称</label>
                                        <input type="text" name="userName" value="${item.userName}" class="form-control" placeholder="请输入用户名称">
                                    </div>
                                    <div class="form-group">
                                        <label>电话号码</label>
                                        <input type="text" name="telephone" value="${item.telephone}" class="form-control" placeholder="请输入电话号码">
                                    </div>
                                    <div class="form-group">
                                        <label>状态</label>
                                        <select name="active" class="form-control">
                                            <option value="true" ${item.active?'selected="selected"':''}>活跃</option>
                                            <option value="false" ${!item.active?'selected="selected"':''}>拉黑</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>角色</label>
                                        <div>
                                        	<c:forEach items="${roles}" var="role">
                                        		<c:set var="isCheck" value=""/>
                                        		<label class="checkbox" style="margin-left: 25px;display:inline-block;">
                                        			<c:forEach items="${adminRoles}" var="adminRole">
                                                        <c:out value="${role.id+'==='+adminRole.id }" />
											   	 		<c:if test="${role.id==adminRole.id }">
											   	 			<c:set var="isCheck" value='checked="checked"'/>
											   	 		</c:if>
											   	 	</c:forEach>
											   	 	<input name="roles" type="checkbox" ${isCheck} value="${role.id }">${role.name }==${isCheck}
												</label>
                                        	</c:forEach>
										</div>
                                    </div>
                                    <div>
                                    	  <button type="button" onclick="saveOrUpdate()" class="btn btn-success">确认 ${item.id==null?"添加":"修改"}</button>
                                   		  <c:if test="${item.id!=null}">
                                    	  	<button type="button" onclick="resetPwd()" class="btn btn-success">重置密码</button>
                                    	  	<span id="defaulPwd"></span>
                                    	  </c:if>
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
<form id="resetPwd" action="resetPwd.html" method="post">
<input type="hidden" name="id" value="${item.id}">
</form>
<%@include file="../include/footer.jsp"%>
<script>
function saveOrUpdate(){
	$("#inputForm").submit();
}
function resetPwd(){
	$("#resetPwd").submit();
}
if(GetQueryString("password")){
	var defaulPwd = GetQueryString("password");
	$("#defaulPwd").html("默认密码："+defaulPwd);
}
function GetQueryString(name)
{
   var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
   var r = window.location.search.substr(1).match(reg);
   if(r!=null)return unescape(decodeURI(r[2])); return '';
}
</script>
</body>
</html>