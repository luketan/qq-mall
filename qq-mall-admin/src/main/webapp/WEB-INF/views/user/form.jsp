<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="description" content="">
    <meta name="author" content="">

    <title>${item.id==null?"添加":"修改"}用户 - ${site.title}</title>

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
                            <div class="col-lg-12">
                                <form id="inputForm" role="form" action="updateUser.html" method="post">
                                    <input type="hidden" name="id" value="${item.id}">
                                    <div class="form-group col-lg-6">
                                        <label>登录名称</label>
                                        <input type="text" name="account" value="${item.account}" class="form-control" readonly >
                                    </div>
                                    <div class="form-group col-lg-6">
                                        <label>用户名称</label>
                                        <input type="text" name="nickName" value="${item.nickName}" class="form-control" readonly >
                                    </div>
                                    <div class="form-group col-lg-6">
                                        <label>个性签名</label>
                                        <input type="text" name="sign" value="${item.sign}" class="form-control" readonly >
                                    </div>
                                    <div class="form-group col-lg-6">
                                        <label>邮件</label>
                                        <input type="text" name="email" value="${item.email}" class="form-control" readonly>
                                    </div>
                                    <div class="form-group col-lg-6">
                                        <label>邮件认证</label>
                                        <select name="phoneIs" class="form-control" readonly>
                                            <option value="1" ${item.emailIs == 0?'selected="selected"':''}>否</option>
                                            <option value="2" ${item.emailIs == 1?'selected="selected"':''}>是</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-lg-6">
                                        <label>电话号码</label>
                                        <input type="text" name="phone" value="${item.phone}" class="form-control" readonly>
                                    </div>
                                    <div class="form-group col-lg-6">
                                        <label>电话认证</label>
                                        <select name="phoneIs" class="form-control" readonly>
                                            <option value="1" ${item.phoneIs == 0?'selected="selected"':''}>否</option>
                                            <option value="2" ${item.phoneIs == 1?'selected="selected"':''}>是</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-lg-6">
                                        <label>年龄</label>
                                        <input type="text" name="age" value="${item.age}" class="form-control" readonly >
                                    </div>
                                    <div class="form-group col-lg-6">
                                        <label>性别</label>
                                        <select name="sex" class="form-control" readonly>
                                            <option value="1" ${item.sex == 1?'selected="selected"':''}>男</option>
                                            <option value="2" ${item.sex == 2?'selected="selected"':''}>女</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-lg-6">
                                        <label>性取向</label>
                                        <select name="sexu" class="form-control" readonly>
                                            <option value="1" ${item.sexu == 1?'selected="selected"':''}>爱好男</option>
                                            <option value="2" ${item.sexu == 2?'selected="selected"':''}>爱好女</option>
                                            <option value="3" ${item.sexu == 3?'selected="selected"':''}>双性恋</option>
                                            <option value="4" ${item.sexu == 4?'selected="selected"':''}>双性恋</option>
                                            <option value="5" ${item.sexu == 5?'selected="selected"':''}>保密</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-lg-6">
                                        <label>婚恋状态</label>
                                        <select name="marr" class="form-control" readonly>
                                            <option value="1" ${item.marr == 1?'selected="selected"':''}>单身</option>
                                            <option value="2" ${item.marr == 2?'selected="selected"':''}>恋爱中</option>
                                            <option value="3" ${item.marr == 3?'selected="selected"':''}>双性恋</option>
                                            <option value="4" ${item.marr == 4?'selected="selected"':''}>已婚</option>
                                            <option value="5" ${item.marr == 5?'selected="selected"':''}>离异</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-lg-6">
                                        <label>是否是体验师</label>
                                        <select name="tryIs" class="form-control">
                                            <option value="1" ${item.tryIs == 0?'selected="selected"':''}>否</option>
                                            <option value="2" ${item.tryIs == 1?'selected="selected"':''}>是</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-lg-6">
                                        <label>类型</label>
                                        <select name="status" class="form-control">
                                            <option value="1" ${item.type == 1?'selected="selected"':''}>普通</option>
                                            <option value="2" ${item.type == 2?'selected="selected"':''}>小编</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-lg-6">
                                        <label>状态</label>
                                        <select name="status" class="form-control">
                                            <option value="1" ${item.status == 1?'selected="selected"':''}>正常</option>
                                            <option value="2" ${item.status == 2?'selected="selected"':''}>锁定</option>
                                            <option value="3" ${item.status == 3?'selected="selected"':''}>封号</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-lg-6">
                                        <label>备注</label>
                                        <textarea class="form-control" name="remark">${item.remark}</textarea>
                                    </div>
                                    <div class="form-group col-lg-12">
                                        <button type="button" onclick="saveOrUpdate()" class="btn btn-success">确认修改</button>
                                        <button type="button" onclick="resetPwd()" class="btn btn-success">重置密码</button>
                                        <span id="defaulPwd"></span>
                                    </div>
                                </form>
                            </div>
                            <!-- /.col-lg-12 (nested) -->
                            <div class="col-lg-12">
                                <form id="userBasisInputForm" role="form" action="updateUserBasis.html" method="post">
                                    <input type="hidden" name="id" value="${item.id}">
                                    <div class="form-group col-lg-6">
                                        <label>登录名称</label>
                                        <input type="text" name="account" value="${item.account}" class="form-control" readonly >
                                    </div>
                                    <div class="form-group col-lg-6">
                                        <label>用户名称</label>
                                        <input type="text" name="nickName" value="${item.nickName}" class="form-control" readonly >
                                    </div>
                                    <div class="form-group col-lg-12">
                                        <button type="button" onclick="saveOrUpdateUserBasis()" class="btn btn-success">确认修改</button>
                                    </div>
                                </form>
                            </div>
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