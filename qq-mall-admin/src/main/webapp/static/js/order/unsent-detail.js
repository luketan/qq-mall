/**
 * Created by Dayong on 16/3/12.
 */

$(document).ready(function () {
    changeProduct();

});
/**
 * 在页面上保存记录
 * @param element
 */
function saveDeliveryItem(element){
    var cul = $(element);
    var deliveryNumber = $("#deliveryNumber");
    var number = eval(deliveryNumber.val());
    var productItem = $("#productItem").val();
    var productText = $("#productItem option:selected").text();
    var leftNumber = $("#productItem option:selected").attr("about");
    if (number == null) {
        cul.attr("data-content", "请填写发货的数量");
        cul.popover("show");
        return;
    } else if (number <= 0) {
        cul.attr("data-content", "数量不能小于或等于0");
        cul.popover("show");
        return;
    }else if(leftNumber - number < 0){
        cul.attr("data-content", "数量不能大于" + leftNumber);
        cul.popover("show");
        return;
    }
    var html = "<tr>" +
        "<td><input type='hidden' value='" + productItem + "'>" + productText + "</td>" +
        "<td class='row'>" + number + "</td>" +
        "<td><button type='button' class='btn btn-primary' onclick='deleteDeliveryItem(this)'>删除</button></td>" +
        "</tr>";
    cul.parent().parent().before(html);
    deliveryNumber.val("");
    cul.attr("data-content", "");
    cul.popover("hide");
    leftNumber = leftNumber - number;
    $("#productItem option:selected").attr("about", leftNumber);
    changeProduct();
}

/**
 * 在页面上删除单品发货记录
 * @param element
 */
function deleteDeliveryItem(element){
    var cul = $(element);
    var before = cul.parent().prev();
    var number = eval(before.text());
    var itemId = before.prev().find("input").val();
    var leftNumber = $("#productItem option[value='" + itemId + "']").attr("about");
    leftNumber = eval(leftNumber) + number;
    $("#productItem option[value='" + itemId + "']").attr("about", leftNumber);
    changeProduct();
    cul.parent().parent().remove();
}

/**
 * 保存整个包裹发货记录
 * @param element
 */
function saveDeliveryLog(element){
    var cul = $(element);
    //选中的快递公司
    var deliveryId = eval($("#deliveryId").val());
    //快递单号
    var deliveryNo = $("#deliveryNo").val();

    var idArr = $("#inputForm div table tbody tr td table tbody tr td input");
    var valArr = $("#inputForm div table tbody tr td table tbody tr td.row");
    var ids = new Array();
    var vals = new Array();
    for(var i = 0; i <idArr.length - 1;i++){
        ids[i] = eval(idArr[i].value);
        vals[i] = eval(valArr[i].innerText);
    }

    var formModal = $("#formModal");
    formModal.modal();
    var oid = $("#orderId").val();
    var param = {
        orderId: oid,
        deliveryId: deliveryId,
        deliveryNo: deliveryNo,
        ids: ids,
        vals: vals
    };
    $.ajax({
        type: "POST",
        url: "submit.html",
        contentType: "application/json; charset=UTF-8",
        data: JSON.stringify(param),
        dataType : "json",
        success: function (data) {
            formModal.find("div .modal-body").html(data.msg);
            if (data.code == 0) {
                setTimeout(function(){
                    window.location.href = "detail.html?id=" + oid;
                    //formModal.modal("hide");
                },1000);
            }
        },
        error: function (data) {
            formModal.find("div .modal-body").html("保存包裹信息失败!");
        }
    });
}

/**
 * 删除整个包裹发货记录信息
 * @param element
 */
function deleteDeliveryLog(element, id){
    var formModal = $("#formModal");
    formModal.modal();
    var param = {
        id: id
    };
    $.ajax({
        type: "POST",
        url: "delete.html",
        contentType: "application/json; charset=UTF-8",
        data: JSON.stringify(param),
        dataType : "json",
        success: function (data) {
            formModal.find("div .modal-body").html(data.msg);
            if (data.code == 0) {
                setTimeout(function(){
                    var cul = $(element);
                    // cul.parent().parent().remove();
                    // formModal.modal("hide");
                    window.location.href = window.location.href;
                },1000);
            }
        },
        error: function (data) {
            formModal.find("div .modal-body").html("删除发货记录信息失败!");
        }
    });
}

/**
 *
 */
function changeProduct() {

    var number = $("#productItem option:selected").attr("about");
    $("#deliveryNumber").val(number);

    /*var idArr = $("#inputForm div table tbody tr td table tbody tr td input");
    var valArr = $("#inputForm div table tbody tr td table tbody tr td.row");
    var ids = new Array();
    var vals = new Array();
    for(var i = 0; i <idArr.length - 1;i++){
        ids[i] = eval(idArr[i].value);
        vals[i] = eval(valArr[i].innerText);
    }*/

}


/**
 * 删除整个包裹发货记录信息
 * @param element
 */
function deliverUnsent(id){
    var formModal = $("#formModal");
    formModal.modal();
    var param = {
        id: id
    };
    $.ajax({
        type: "POST",
        url: "deliver.html",
        contentType: "application/json; charset=UTF-8",
        data: JSON.stringify(param),
        dataType : "json",
        success: function (data) {
            formModal.find("div .modal-body").html(data.msg);
            if (data.code == 0) {
                setTimeout(function(){
                    formModal.modal("hide");
                    window.location.href = "../list.html";
                },2000);
            }
        },
        error: function (data) {
            formModal.find("div .modal-body").html("删除发货记录信息失败!");
        }
    });
}