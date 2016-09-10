/**
 * Created by Dayong on 16/3/11.
 */
function saveItem(ele, type) {
    var curEle = $(ele);
    var id = curEle.prev().val();
    var val = curEle.val();
    if (type == 1) {
        if (val < 0) {
            curEle.attr("data-content", "数量不能小于0");
            curEle.popover("show");
        }
    } else {
        if (val == null) {
            curEle.attr("data-content", "实际说明不能为空");
            curEle.popover("show");
        }
    }
    var param = {type: type, id: id, value: val};
    $.ajax({
        type: "POST",
        url: "item/save.html",
        data: param,
        success: function (data) {
            var result = jQuery.parseJSON(data);
            if (result.code == 0) {
                if (type == 1) {
                    // //$("#inputForm div table tbody tr td table tbody tr td span").css({ backgroundColor: "yellow", fontWeight: "bolder" });
                    // var specArr = $("#inputForm div table tbody tr td table tbody tr td span");
                    // //$("#inputForm div table tbody tr td table tbody tr td.has-warning").css({ backgroundColor: "yellow", fontWeight: "bolder" });
                    // var numArr = $("#inputForm div table tbody tr td table tbody tr td.has-warning input");
                    // var total = 0;
                    // var val = 0;
                    // var num = 0;
                    // for (var i = 0; i < specArr.length - 1; i++) {
                    //     val = eval(specArr[i].innerHTML);
                    //     num = eval(numArr[i].value);
                    //     total = eval(total) + (val * num);
                    // }
                    // $("#goldWeight").val(total);
                }
            } else {
                curEle.attr("data-content", data.msg);
                curEle.popover("show");
            }
        },
        error: function (data) {
            curEle.attr("data-content", "保存失败!");
            curEle.popover("show");
        }
    });
}
function saveFee(ele, type) {
    var id = $("#orderId").val();
    var fee = eval($("#feeValue").val());
    var curEle = $(ele);
    if (type == 2) {
        id = curEle.parent().parent().children("input").val();
        fee = curEle.val();
    }
    if (fee == null) {
        curEle.attr("data-content", "请填写具体的费用");
        curEle.popover("show");
        return;
    } else if (fee < 0) {
        curEle.attr("data-content", "费用不能小于0");
        curEle.popover("show");
        return;
    } else {
        curEle.attr("data-content", "");
        curEle.popover("hide");
    }
    var feeType = eval($("#feeType").val());
    var param = {type: type, id: id, feeType: feeType, fee: fee};
    $.ajax({
        type: "POST",
        url: "fee/save.html",
        data: param,
        success: function (data) {
            var result = jQuery.parseJSON(data);
            if (result.code == 0) {
                if (type == 1) {
                    var text = $("#feeType option:selected").text();
                    var html = "<tr>" +
                        "<td class=\"col-md-4 col-xs-4\">" + text + "</td>" +
                        "<td class=\"col-md-8 col-xs-8\">" +
                        "<div class=\"col-lg-8\">" +
                        "<div class=\"input-group has-warning\">" +
                        "<div class=\"input-group-addon\">¥</div>" +
                        "<input type=\"text\" class=\"form-control\" onblur=\"saveFee(this, 2)\" value=\"" + fee + "\" placeholder=\"请输入实际费用\">" +
                        "</div>" +
                        "<input type=\"hidden\" value=\"" + result.result + "\">" +
                        "</div>" +
                        "</td>" +
                        "</tr>";
                    curEle.parent().parent().before(html);
                }
                var total = 0;
                var arr = $("#inputForm div table tbody tr td div div input");
                for (var i = 0; i < arr.length - 1; i++) {
                    total = eval(total) + eval(arr[i].value);
                }
                $("#otherFee").val(total);
            } else {
                curEle.attr("data-content", data.msg);
                curEle.popover("show");
            }
        },
        error: function (data) {
            curEle.attr("data-content", "保存失败!");
            curEle.popover("show");
        }
    });
}

var submitType = 0;
function popupDialog(type) {
    var myModal = $("#myModal");
    submitType = type;
    if (type == 1) {
        myModal.find("div .modal-body").html("确认通过该订单的审核吗?");
    } else {
        myModal.find("div .modal-body").html("确认取消该订单吗?");
    }
    myModal.modal();
}

function submitForm() {
    var formModal = $("#formModal");
    formModal.modal();
    var orderId = $("#orderId").val();
    var goldWeight = eval($("#goldWeight").val());
    var otherFee = eval($("#otherFee").val());
    var itemFee = eval($("#itemFee").val());
    var discountFee = eval($("#discountFee").val());
    var deliveryFee = eval($("#deliveryFee").val());
    var illustrate = $("#illustrate").val();
    var param = {
        orderId: orderId,
        goldWeight: goldWeight,
        otherFee: otherFee,
        itemFee: itemFee,
        discountFee: discountFee,
        deliveryFee: deliveryFee,
        illustrate: illustrate,
        type: submitType
    };
    $.ajax({
        type: "POST",
        url: "save.html",
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
            formModal.find("div .modal-body").html("提交审核失败!");
        }
    });
}