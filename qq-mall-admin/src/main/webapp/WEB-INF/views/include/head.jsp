﻿   <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="/favicon.ico">

    <!-- Bootstrap Core CSS -->
    <link href="${basePath }/static/libs/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${basePath }/static/libs/bootstrap/css/bootstrap-dialog.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${basePath }/static/libs/bootstrap/css/bootstrap-multiselect.css" type="text/css"/>
    <link rel="stylesheet" href="${basePath }/static/libs/jquery/jquery-lightbox/css/lightbox.css" type="text/css"/>
	

    <!-- MetisMenu CSS -->
    <link href="${basePath }/static/libs/metisMenu/css/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${basePath }/static/libs/sb-admin/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${basePath }/static/libs/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script>
        window.basePath = '${basePath}';
    </script>

    <div class="modal fade bs-example-modal-sm" id="submitFromModal" tabindex="-1" role="dialog"
         aria-labelledby="formModalLabel" aria-hidden="false">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    正在提交...
                </div>
            </div>
        </div>
    </div>
    <%--  	$("#submitFromModal").modal();--%>
    <%--  	$("#submitFromModal").modal('hide');--%>