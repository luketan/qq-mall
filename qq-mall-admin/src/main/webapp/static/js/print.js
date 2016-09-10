function windowPrint() {
    var f = document.getElementById("wrapper");
    f.style.display = "";
    window.print();
    f.style.display = "none";
}

function myPrint(obj) {
    var newWindow = window.open("打印窗口", "_blank");
    var docStr = obj.innerHTML;
    newWindow.document.write(docStr);
    newWindow.document.close();
    newWindow.print();
    newWindow.close();
}