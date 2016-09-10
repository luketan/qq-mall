/**
 * Created by Dayong on 16/3/18.
 */
function sureCancel(id){
    var formModal = $("#formModal");
    formModal.modal();
    var param = {id: id};
    $.ajax({
        type: "POST",
        url: "sure.html",
        contentType: "application/json; charset=UTF-8",
        data: JSON.stringify(param),
        dataType : "json",
        success: function (data) {
            formModal.find("div .modal-body").html(data.msg);
            if (data.code == 0) {
                setTimeout(function(){
                    formModal.modal("hide");
                    window.location.href = "../list.html";
                },1000);
            }
        },
        error: function (data) {
            formModal.find("div .modal-body").html("提交确认失败!");
        }
    });
}