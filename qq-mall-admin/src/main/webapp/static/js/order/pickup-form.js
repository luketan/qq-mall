/**
 * Created by Dayong on 16/3/18.
 */

function submitModify(){
    var person = $("input[name='contactPerson']").val();
    var phone = $("input[name='contactPhone']").val();
    var desc = $("input[name='description']").val();
    var date = $("input[name='remarkDate']").val();
    var formModal = $("#formModal");

    if(person == null || person == ''){
        formModal.find("div .modal-body").html("联系人姓名不能为空!");
        formModal.modal();
        return;
    }
    if(phone == null || phone == ''){
        formModal.find("div .modal-body").html("联系电话不能为空!");
        formModal.modal();
        return;
    }
    if(desc == null || desc == ''){
        formModal.find("div .modal-body").html("自提地址不能为空!");
        formModal.modal();
        return;
    }
    if(date == null || date == ''){
        formModal.find("div .modal-body").html("自提备注说明不能为空!");
        formModal.modal();
        return;
    }
    $("#inputForm").submit();
}
