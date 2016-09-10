/**
 * Created by Dayong on 16/3/23.
 */
function enterKeydown(val, e) {
    var keyPressed = -1;
    if (window.event) {
        keyPressed = window.event.keyCode; // IE
    } else {
        keyPressed = e.which; // Firefox
    }
    if (keyPressed == 13) {
        if (val != null) {
            submitSearch()
        } else {

        }
    }
}

function submitSearch() {
    $("#inputForm").submit();
}