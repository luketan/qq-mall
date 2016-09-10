<%@ page contentType="text/html;charset=UTF-8" %>
<script  language="javascript" charset="UTF-8">
if('${message}' || GetQueryString("message")){
	var html = '<div id="prompt_message" onclick="deleteEle(this)" style="display:none;withd:100%;height: 60px;line-height: 60px;background-color: green;text-align: center;font-size:16px;color:#fff;">'+
	('${message}'?'${message}':GetQueryString("message"))+'</div>';
	$("body").prepend(html);
	$("#prompt_message").slideToggle("slow");
	setTimeout(function(){
		deleteEle($("#prompt_message"));
	},2000);
}
if('${error}' || GetQueryString("error")){
	var html = '<div id="prompt_error" onclick="deleteEle(this)" style="display:none;withd:100%;height: 60px;line-height: 60px;background-color: red;text-align: center;font-size:16px;color:#fff;">'+
	('${error}'?'${error}':GetQueryString("error"))+'</div>';
	$("body").prepend(html);
	$("#prompt_error").slideToggle("slow");
	setTimeout(function(){
		deleteEle($("#prompt_error"));
	},2000);
}
function deleteEle(ele){
	$(ele).slideUp("slow",function(){
		$(ele).remove();
	})
}
function GetQueryString(name)
{
   var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
   var r = window.location.search.substr(1).match(reg);
   if(r!=null)return unescape(decodeURI(r[2])); return '';
}
</script>