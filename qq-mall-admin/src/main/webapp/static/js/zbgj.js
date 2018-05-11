$.fn.serializeObject = function()
{
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};

var zbgj = {
    ajax : function(data){
        if (!data.url) {
            this.promptError("url不能为空");
            return;
        }
        var reqData = {};
        if (data.formData) {
            //校验
            if(!this.verifyForm(data.formData))
                return;
            reqData = $(data.formData).serializeObject();
        }
        if (data.jsonData) {
            reqData = data.jsonData;
        }
        var _this = this;
        $.ajax({
            type:data.type?data.type:"post",//请求方式get/post
            url:data.url,//请求对应的地址
            //application/json; charset=UTF-8
            contentType: data.contentType?data.contentType:"application/x-www-form-urlencoded",
            dataType : "json",
            data:reqData,//往服务器传递的参数，
            traditional: true,//这里设置为true
            success:function(result){//服务器交互成功调用的回调函数，data就是服务器端传递出来的数据
                if (result.code == 0) {
                    if (data.callback) {
                        data.callback(result.result);
                    }else{
                        _this.promptMessage(result.msg);
                    }
                } else {
                    _this.promptError(result.msg);
                }
            },
            error:function(XMLHttpRequest){
                console.log("请求出错");
                _this.promptError("请求出错,请联系工作人员！");
            },
            beforeSend:function () {
                _this.showFromModal();
            },
            complete:function (XMLHttpRequest, TS) {
                _this.hideFromModal();
            }
        });
    },
    verifyForm:function(formData){
        var self = this;
        var flag = true;
        $(formData).find("select,input,textarea").each(function(){
            var condition = $(this).attr("condition");
            console.log("condition========" + condition);
            if(condition){
                condition = JSON.parse(condition);
                if (condition.require && (condition.require==true || condition.require=='true' )) {
                    var val = $(this).val();
                    val = self.trim(val);
                    $(this).val(val);

                    if (val === '') {
                        //错误提示
                    }
                }
                if (condition.intValue && !isNaN(val)) {
                    var intValues = condition.intValue.split("~");
                    if (intValues.length==2) {
                        var oneN = isNaN(intValues[0]);
                        var twoN = isNaN(intValues[1]);

                        if (parseInt(intValues[0]) > val || parseInt(intValues[1]) < val) {
                            "输入值必须在"+condition.intValue+"之间";
                        }
                    }else{
                        alert('添加输入条件错误！');
                        flag = false;
                    }
                }
                if (condition.len) {
                    var lens = condition.len.split("~");
                    if (lens.length==2) {
                        var oneN = isNaN(lens[0]);
                        var twoN = isNaN(lens[1]);
                        if (oneN && twoN) {
                            alert('添加输入条件错误！');
                            flag = false;
                        }else if(!oneN && !twoN){
                            if (parseInt(lens[0]) > val.length || parseInt(lens[1]) < val.length) {
                                "输入长度必须在"+condition.length+"之间";
                                flag = false;
                            }
                        }else if(!oneN && twoN) {
                            if (parseInt(lens[0]) > val.length) {
                                console.log("输入长度大于"+lens[0]+"之间");
                                flag = false;
                            }
                        }else if(oneN && !twoN) {
                            if (parseInt(lens[1]) < val.length) {
                                console.log("输入长度小于"+lens[1]+"之间");
                                flag = false;
                            }
                        }
                    } else {
                        alert('添加输入条件错误！');
                        flag = false;
                    }
                }
                if (condition.compile) {
                    //正则表达式
                }
            }
        })

        return flag;
    },
    promptMessage:function(message) {
        var _this=this;
        var html = '<div id="prompt_message" onclick="zbgj.deleteEle(this)" style="position: fixed;top:0;display:none;width:100%;z-index:2;height: 60px;line-height: 60px;background-color: green;text-align: center;font-size:16px;color:#fff;">'+
            message + '</div>';
        $("body").prepend(html);
        $("#prompt_message").slideToggle("slow");
        setTimeout(function(){
            $("#prompt_message").slideUp("slow",function(){
                $("#prompt_message").remove();
            })
        },2000);
    },
    promptError:function(error) {
        var _this=this;
        var html = '<div id="prompt_error" onclick="zbgj.deleteEle(this)"  style="position: fixed;top:0;display:none;width:100%;z-index:2;height: 60px;line-height: 60px;background-color: red;text-align: center;font-size:16px;color:#fff;">'+
            (error) + '</div>';
        $("body").prepend(html);
        $("#prompt_error").slideToggle("slow");
       /* setTimeout(function(){
            $("#prompt_error").slideUp("slow",function(){
                $("#prompt_error").remove();
            })
        },2000);*/
    },
    showFromModal:function(message) {
        if (message) {
            $("#submitFromModal").find('.modal-body').html(message);
        }else{
            $("#submitFromModal").modal();
        }
    },
    hideFromModal:function(message) {
        $("#submitFromModal").modal('hide');
    },
    deleteEle:function(ele){
        $(ele).slideUp("slow",function(){
            $(ele).remove();
        })
    },
    trim:function(str)
    {
        return str.replace(/(^\s*)|(\s*$)/g, "");
    }
}