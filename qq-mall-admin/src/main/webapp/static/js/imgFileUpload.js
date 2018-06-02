/**
 图片上传，图片列表处理
 **/
var url = "${basePath }/upload/uploadImg.html";
$('.imgFileUpload').change(function () {
    var self = this;
    var data = new FormData();
    $.each($(this)[0].files, function (i, file) {
        data.append('imgFile', file);
    });
    $.ajax({
        type: "POST",
        url: url,
        timeout: 400000,
        data: data,
        cache: false,
        contentType: false,
        processData: false,
        success: function (result) {
            result = JSON.parse(result);
            if (result.ResultInt == 0) {
                $(self).parent().find('input')[0].value = result.result.url;
                $($(self).parent().find('img')).attr('src', result.result.url)
                console.log("fileload_ajax-suc-[]->" + JSON.stringify(result));
            } else {
                alert(result.ResultString);
            }
        },
        error: function (xhr, errmsg) {
            console.log("ajax-err-[]->" + JSON.stringify(errmsg) + "|" + xhr);
            alert('error');
        },
        beforeSend: function (xhr) {

        },
    });

});
$('.multiImgFileUpload').change(function () {
    var self = this;
    var data = new FormData();
    $.each($(this)[0].files, function (i, file) {
        data.append('imgFile', file);
    });

    /*        $("#lunboImg").html(
     " <div> "+
     "<img src='${image.images}' width='30%'>"+
     "<input type='text' class='form-control'  name='images'placeholder='请选择轮播图片' value='${image.images}' onchange='javascript:this.parentNode.querySelector('img').src=this.value'>"+
     "排序：<input style='width:10%' name='sorts' value='${image.sort}'><input type='button' value='删除' onclick='javascript:this.parentNode.parentNode.removeChild(this.parentNode)'>"+
     "</div>"
     ); */
    $.ajax({
        type: "POST",
        url: url,
        timeout: 400000,
        data: data,
        cache: false,
        contentType: false,
        processData: false,
        success: function (result) {
            result = JSON.parse(result);
            if (result.ResultInt == 0) {
                /*  $(self).before(
                 "<div> "+
                 "<img src='"+result.result.url+"' width='30%'>"+
                 "<input type='text' class='form-control' name='images' placeholder='请选择轮播图片' value='"+result.result.url+"' onchange='javascript:this.parentNode.querySelector('img').src=this.value'>"+
                 "排序：<input style='width:10%' name='sorts' value='0'><input type='button' value='删除' onclick='javascript:this.parentNode.parentNode.removeChild(this.parentNode)'>"+
                 "</div>"
                 ); */
                $("#lunboImg").append(
                    '<div style="display: table;padding: 10px;width: 100%">' +
                    '<div style="display: table-cell;width: 200px;vertical-align:middle;">' +
                    '<img src="' + result.result.url + '" width="200px">' +
                    '</div>' +
                    '<div style="display: table-cell;width: 70%;vertical-align:top;padding-left: 10px">' +
                    '<input type="text" class="form-control" style="width: 50%;display: none;"  name="images" placeholder="请选择宝贝图片" value="' + result.result.url + '" onchange="javascript:this.parentNode.parentNode.querySelector(\'img\').src=this.value">' +
                    '<br>' +
                        /*  '设为首图<input type="radio" name="mainImgRad" value="'+result.result.url+'" onclick="javascript:$(\'#mainImage\').val(this.value)"><br>'+*/
                    '<br>' +
                    '<input type="button" value="上移" onclick="moveUp(this)">&nbsp;' +
                    '<input type="button" value="下移" onclick="moveDown(this)">&nbsp;' +
                    '<input type="button" value="删除" onclick="javascript:this.parentNode.parentNode.parentNode.removeChild(this.parentNode.parentNode)">' +
                    '</div>' +
                    '</div>'
                );
            } else {
                alert(result.ResultString);
            }
        },
        error: function (xhr, errmsg) {
            console.log("ajax-err-[]->" + JSON.stringify(errmsg) + "|" + xhr);
            alert('error');
        },
        beforeSend: function (xhr) {

        },
    });

});
function moveDown(self) {
    var children = $(self).parent().parent().parent().children();
    var index = 0;
    for (var i = 0; i < children.length; i++) {
        if ($(self).parent().parent().find('img').attr('src') == $(children[i]).find('img').attr('src') && i < children.length) {
            index = i;
        }
        ;
    }
    if (index >= 0 && index < children.length) {
        var tem = $(children[index]).html();
        $(children[index]).html($(children[index + 1]).html());
        $(children[index + 1]).html(tem)
    }

}
function moveUp(self) {
    var children = $(self).parent().parent().parent().children();
    var index = 0;
    for (var i = 0; i < children.length; i++) {
        if ($(self).parent().parent().find('img').attr('src') == $(children[i]).find('img').attr('src') && i > 0) {
            index = i;
        }
        ;
    }
    if (index > 0) {
        var tem = $(children[index]).html();
        $(children[index]).html($(children[index - 1]).html());
        $(children[index - 1]).html(tem)
    }
}