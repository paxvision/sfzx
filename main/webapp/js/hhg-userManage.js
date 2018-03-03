$(function(){
	// 右下角时间
	// 格式化时间
	Date.prototype.Format = function (fmt) { //author: meizz 
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds(), //毫秒 
        "w": this.getDay()//星期
    };
    if(o.w==1){
    	o.w="一";
    }else if(o.w==2){
    	o.w="二";
    }else if(o.w==3){
    	o.w="三";
    }else if(o.w==4){
    	o.w="四";
    }else if(o.w==5){
    	o.w="五";
    }else if(o.w==6){
    	o.w="六";
    }else{
    	o.w="日";
    }
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}
	function getTime(){
		var oTime=new Date().Format("yyyy/MM/dd hh:mm:ss 星期w");
		$(".time").html(oTime);
	}
	setInterval(getTime,1000);
});