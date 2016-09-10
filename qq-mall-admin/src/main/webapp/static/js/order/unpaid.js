/**
 * Created by Dayong on 16/3/11.
 */

function sendMessage() {
    var formModal = $("#formModal");
    var orderId = $("#orderId").val();
    var accountId = $("input[name='rdAccount']").val();
    if (accountId == null || accountId == '') {
        formModal.find("div .modal-body").html("请选择发送的账号");
        formModal.modal();
        return;
    }

    formModal.modal();
    var param = {orderId: orderId, accountId: accountId};
    $.ajax({
        type: "POST",
        url: "message.html",
        data: param,
        dataType: "json",
        success: function (result) {
            formModal.find("div .modal-body").html(result.msg);
            if (result.code == 0) {
                setTimeout(function () {
                    formModal.modal("hide");
                    //$("#btnSendMsg").attr("disabled", true);
                }, 1000);
            }
        },
        error: function (data) {
            formModal.find("div .modal-body").html("发送失败!");
        }
    });
}

var submitType = 0;
function popupDialog(type, value) {
    var button = $("button.btn-danger");
    var myModal = $("#myModal");
    var html = "";
    submitType = type;
    if (type == 1) {
        html = "确认该订单的原料已经到账吗?" +
            "<div class='form-group'>" +
            "<label class='col-sm-2 control-label'>转料账号</label>" +
            "<div class='col-sm-10'>" +
            "<input id='payAccount' type='text' class='form-control' onkeyup='checkInput()' placeholder='请输入转料的账号'>" +
            "</div>" +
            "</div>" +
            "<div class='form-group'>" +
            "<label for='inputPassword' class='col-sm-2 control-label'>转料数量</label>" +
            "<div class='col-sm-10'>" +
            "<input id='payNumber' type='text' class='form-control' onkeyup='checkInput()' placeholder='请输入原料数量'>" +
            "</div>" +
            "</div>";
        button.attr("disabled", true);
        myModal.find("div .modal-body").html(html);
    } else if (type == 2) {
        html = "确认该订单的金额已经到账吗?" +
            "<div class='form-group'>" +
            "<label class='col-sm-2 control-label'>打款账号</label>" +
            "<div class='col-sm-10'>" +
            "<input id='payAccount' type='text' class='form-control' onkeyup='checkInput()' placeholder='请输入打款的账号'>" +
            "</div>" +
            "</div>" +
            "<div class='form-group'>" +
            "<label for='inputPassword' class='col-sm-2 control-label'>打款金额</label>" +
            "<div class='col-sm-10'>" +
            "<input id='payNumber' type='text' class='form-control' onkeyup='checkInput()' placeholder='请输入打款的金额'>" +
            "</div>" +
            "</div>" +
            "<div class='form-group'>" +
            "<label for='inputPassword' class='col-sm-2 control-label'>实际支付</label>" +
            "<div class='col-sm-10'>" +
            "<label class='radio-inline'>" +
            "<input type='radio' name='paymentType' value='1' checked> 支付宝" +
            "</label>" +
            "<label class='radio-inline'>" +
            "<input type='radio' name='paymentType' value='4'> 橙e付" +
            "</label>" +
            "<label class='radio-inline'>" +
            "<input type='radio' name='paymentType' value='5'> 线下支付" +
            "</label>" +
            "</div>" +
            "</div>";
        button.attr("disabled", true);
        myModal.find("div .modal-body").html(html);
    } else if (type == 3) {
        button.attr("disabled", false);
        myModal.find("div .modal-body").html("确认取消该订单原料的到账吗?");
    } else {
        button.attr("disabled", false);
        myModal.find("div .modal-body").html("确认取消该订单金额的到账吗?");
    }
    myModal.modal();
}

function checkInput() {
    var payAccount = $("#payAccount").val();
    var payNumber = $("#payNumber").val();
    if (payAccount != null && payAccount != '' && payNumber != null && payNumber != '') {
        $("button.btn-danger").attr("disabled", false);
    } else {
        $("button.btn-danger").attr("disabled", true);
    }
}

function surePayment(id) {
    var payAccount = $("#payAccount").val();
    var payNumber = $("#payNumber").val();
    var paymentType = "0";
    if(submitType == 2){
        paymentType = $("input[name='paymentType']:checked").val()
    }
    if(submitType == 3|| submitType == 4){
        payAccount = "";
        payNumber = "0";
    }
    var formModal = $("#formModal");
    formModal.modal();
    var param = {type: submitType, id: id, payAccount: payAccount, payNumber: payNumber, paymentType: paymentType};
    $.ajax({
        type: "POST",
        url: "sure.html",
        data: param,
        success: function (data) {
            var result = jQuery.parseJSON(data);
            formModal.find("div .modal-body").html(result.msg);
            if (result.code == 0) {
                setTimeout(function () {
                    formModal.modal("hide");
                    window.location.href = "../list.html";
                }, 1000);
            }
        },
        error: function (data) {
            formModal.find("div .modal-body").html("提交确认失败!");
        }
    });
}
