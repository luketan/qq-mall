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
        if (data.url) {
            promptError("url不能为空");
        }
        var reqData = {};
        if (data.formData) {
            //校验
            if(!this.verifyForm(formData))
                return;
            reqData = JSON.stringify($(data.formData).serializeObject());
        }
        if (data.jsonData) {
            reqData = data.jsonData;
        }

        $.ajax({
            type:data.type?data.type:"post",//请求方式get/post
            url:data.url,//请求对应的地址
            data:data,//往服务器传递的参数，
            success:function(data){//服务器交互成功调用的回调函数，data就是服务器端传递出来的数据
                if (data.code == 0) {
                    if (data.callback) {
                        data.callback(data.result);
                    }
                } else {
                    promptError(data.msg);
                }
            },
            error:function(XMLHttpRequest){
                console.log("请求出错");
                promptError("请求出错,请联系工作人员！");
            },
            beforeSend:function () {

            },
            complete:function (XMLHttpRequest, TS) {
                
            }
        });
    },
    verifyForm:function(formData){
        var self = this;
        var flag = true;
        $(formData).find().each(function(){
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
    trim:function(str)
    {
        return str.replace(/(^\s*)|(\s*$)/g, "");
    }
}