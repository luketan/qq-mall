$(document).ready(function () {
    setInterval(getNewOrderNum, 10000);
});
function getNewOrderNum() {
    $.ajax({
        type: "POST",
        url: "/order/count/new.html",
        contentType: "application/json; charset=UTF-8",
        dataType: "json",
        success: function (data) {
            if (data.code == 0) {
                if (data.result > 0) {
                    var audioNewOrder = document.getElementById("audioNewOrder");
                    audioNewOrder.play();
                    $('#orderMenuNumber').html(data.result);
                    $('.orderMenuNumber').html(data.result);
                    var times = 0;
                    var flush = setInterval(function () {
                        if (times % 2) {
                            $('#orderMenuIcon').removeClass("fa-bell");
                        } else {
                            $('#orderMenuIcon').addClass("fa-bell");
                        }
                        if (times++ > 8) {
                            clearInterval(flush);
                        }
                    }, 1000);
                }
            }
        }
    });
}