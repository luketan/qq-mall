/**
 * Created by Dayong on 16/3/22.
 */
var setting = {
    check: {
        enable: true,
        chkboxType: {"Y": "ps", "N": "ps"}
    },
    data: {
        simpleData: {
            enable: true
        }
    },
    callback: {
        onCheck: zTreeonCheck
    }
};

var id = $("[name$='id']").val();
$(document).ready(function () {
    $.fn.zTree.init($("#securityTree"), setting, zNodes);
    var treeObj = $.fn.zTree.getZTreeObj("securityTree");
    treeObj.expandAll(true);
    if (id != null) {
        for (var i = 0; i < zRoles.length; i++) {
            var node = treeObj.getNodeByParam("id", zRoles[i].toString());
            treeObj.checkNode(node, true);
        }
    }
});

var adds = new Array();
var dels = new Array();
function zTreeonCheck(event, treeId, treeNode) {
    var flag = true;
    var id = treeNode.id;
    var checked = treeNode.checked;
    for (var i = 0; i < zRoles.length; i++) {
        if (id == zRoles[i]) {
            if (checked == false) {
                dels[dels.length] = id;
            }
            flag = false;
            break;

        }
    }
    if (flag) {
        if (checked == true) {
            //server duplicate detection
            adds[adds.length] = id;
        }
    }
};

function submitSave(type) {
    var formModal = $("#formModal");
    formModal.modal();
    var name = $("[name$='name']").val();
    var type = $("[name$='type']").val();
    var desc = $("[name$='desc']").val();
    if (name == null) {
        formModal.find("div .modal-body").html("角色名称不能为空!");
        formModal.modal();
        return;
    }
    if (desc == null) {
        formModal.find("div .modal-body").html("角色描述不能为空!");
        formModal.modal();
        return;
    }
    var param = {
        id: id,
        name: name,
        type: type,
        desc: desc,
        adds: adds,
        dels: dels
    };
    $.ajax({
        type: "POST",
        url: "save.html",
        contentType: "application/json; charset=UTF-8",
        data: JSON.stringify(param),
        dataType: "json",
        success: function (data) {
            formModal.find("div .modal-body").html(data.msg);
            if (data.code == 0) {
                setTimeout(function () {
                    formModal.modal("hide");
                    window.location.href = "../role.html";
                }, 1000);
            }
        },
        error: function (data) {
            formModal.find("div .modal-body").html("保存系统角色失败!");
        }
    });
}