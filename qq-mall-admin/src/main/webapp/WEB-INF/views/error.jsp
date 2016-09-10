<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="include/taglib.jsp" %>
<!DOCTYPE html>
<html lang="cn">
<head>
    <meta name="desc" content="">
    <meta name="author" content="">

    <title>出错啦~~~ - ${site.title}</title>
    <%@include file="include/head.jsp" %>
</head>

<body>
<div id="wrapper">

    <!-- Navigation -->
    <%@include file="include/nav.jsp" %>

    <div id="page-wrapper">
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        出错啦~~~
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        ${errorMsg}
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

<%@include file="include/footer.jsp" %>
</body>
</html>