$(function(){
    // 格式化时间
    Date.prototype.Format = function (fmt) { 
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
	// 获取数据并分页
  $.ajax({
    type: "GET",
    url: "/findAllUsers",
    dataType : "json",
    success : function(data){
        if(data.status==1){
                    // 定义当前页码
                    var pageNow;
                    //设置每页显示的个数
                    var pageNumber=15;
                    // 计算页数
                    var page=Math.ceil(data.data.length/pageNumber);
                    //插入页数
                    for(var j=1;j<=page;j++){
                        $(".pageNum").append("<a href='javascript:;' id='"+j+"' class='pageNumMain'>"+j+"</a>");
                    }
                    // 初始页码为1
                    for(var i=0;i<Math.min(pageNumber,data.data.length);i++){
                        if(data.data[i].recentTime==null){
                            var Ryear="";
                            var Rmonth="";
                            var Rday="";
                        }else{
                            var Ryear=data.data[i].recentTime.year;
                            var Rmonth=data.data[i].recentTime.monthValue;
                            var Rday=data.data[i].recentTime.dayOfMonth;
                        }
                        if(data.data[i].createTime==null){
                            var Cyear="";
                            var Cmonth="";
                            var Cday="";
                        }else{
                            var Cyear=data.data[i].createTime.year;
                            var Cmonth=data.data[i].createTime.monthValue;
                            var Cday=data.data[i].createTime.dayOfMonth;
                        }
                        pageNow=1;
                        // 页次
                        $(".nowPagesNumber").html(pageNow);
                        $(".pageNum a").css("color","black");
                        $(".pageNum a:eq("+(pageNow-1)+")").css("color","red");
                        var str="<tr>"+
                        "<td>"+data.data[i].id+"</td>"+
                        "<td>"+data.data[i].loginName+"</td>"+
                        "<td>"+data.data[i].userName+"</td>"+
                        "<td>"+new Date(Ryear+"/"+Rmonth+"/"+Rday).Format("yyyy-MM-dd")+"</td>"+
                        "<td>"+data.data[i].recentIp+"</td>"+
                        "<td>"+new Date(Cyear+"/"+Cmonth+"/"+Cday).Format("yyyy-MM-dd")+"</td>"+
                        "<td><a href='javascript:;' alt="+data.data[i].id+" id='change'>修改</a></td>"+
                        "<td><input type='checkbox' alt="+data.data[i].id+" name='delete'></td>"+
                        "</tr>";
                        $(".tbody").append(str);
                        if(data.data[i].recentTime==null){
                            $("tr:eq("+(i+1)+") td:eq(3)").html("暂无");
                        }
                        if(data.data[i].recentIp==null||data.data[i].recentIp==""){
                            $("tr:eq("+(i+1)+") td:eq(4)").html("暂无");
                        }
                        pageChange();
                    }
                    $(".pageNumMain").click(function(){
                        pageNow=$(this).attr("id");
                        // 页次
                        $(".nowPagesNumber").html(pageNow);
                        $(".pageNum a").css("color","black");
                        $(".pageNum a:eq("+(pageNow-1)+")").css("color","red");
                        $(".tbody").html("");
                        var pageN=$(this).attr("id");
                        var NumStart=pageNumber*(pageN-1);
                        for(var i=NumStart;i<Math.min(data.data.length,NumStart+pageNumber);i++){
                            if(data.data[i].recentTime==null){
                                var Ryear="";
                                var Rmonth="";
                                var Rday="";
                            }else{
                                var Ryear=data.data[i].recentTime.year;
                                var Rmonth=data.data[i].recentTime.monthValue;
                                var Rday=data.data[i].recentTime.dayOfMonth;
                            }
                            if(data.data[i].createTime==null){
                                var Cyear="";
                                var Cmonth="";
                                var Cday="";
                            }else{
                                var Cyear=data.data[i].createTime.year;
                                var Cmonth=data.data[i].createTime.monthValue;
                                var Cday=data.data[i].createTime.dayOfMonth;
                            }
                            var str="<tr>"+
                            "<td>"+data.data[i].id+"</td>"+
                            "<td>"+data.data[i].loginName+"</td>"+
                            "<td>"+data.data[i].userName+"</td>"+
                            "<td>"+new Date(Ryear+"/"+Rmonth+"/"+Rday).Format("yyyy-MM-dd")+"</td>"+
                            "<td>"+data.data[i].recentIp+"</td>"+
                            "<td>"+new Date(Cyear+"/"+Cmonth+"/"+Cday).Format("yyyy-MM-dd")+"</td>"+
                            "<td><a href='javascript:;' alt="+data.data[i].id+" id='change'>修改</a></td>"+
                            "<td><input type='checkbox' alt="+data.data[i].id+" name='delete'></td>"+
                            "</tr>";
                            $(".tbody").append(str);
                            if(data.data[i].recentTime==null){
                                $("tr:eq("+(i+1)+") td:eq(3)").html("暂无");
                            }
                            if(data.data[i].recentIp==null||data.data[i].recentIp==""){
                                $("tr:eq("+(i+1)+") td:eq(4)").html("暂无");
                            }
                        }
                        pageChange();
                        window.scroll(0,0);
                    });
                     // 点击首页
                     $(".pageFirst").click(function(){
                        $("#1").click();
                    });
                      // 点击尾页
                      $(".pageLast").click(function(){
                        $("#"+page).click();
                    });
                      // 点击上一页
                      $(".pagePre").click(function(){
                        if(pageNow==1){
                            alert("已经是第一页啦~!");
                        }else{
                            pageNow--;
                            // 页次
                            $(".nowPagesNumber").html(pageNow);
                            $(".pageNum a").css("clolr","black");
                            $(".pageNum a:eq("+(pageNow-1)+")").css("color","red");
                            $(".tbody").html("");
                            var NumStart=pageNumber*(pageNow-1);
                            for(var i=NumStart;i<Math.min(data.data.length,NumStart+pageNumber);i++){
                                function Rtime(Ryear,Rmonth,Rday){
                                    if(data.data[i].recentTime==null){
                                        var Ryear="";
                                        var Rmonth="";
                                        var Rday="";
                                        return "暂无";
                                    }else{
                                        var Ryear=Ryear;
                                        var Rmonth=Rmonth;
                                        var Rday=Rday;
                                        return new Date(Ryear+"/"+Rmonth+"/"+Rday).Format("yyyy-MM-dd");
                                    }
                                }
                                var str="<tr>"+
                                "<td>"+data.data[i].id+"</td>"+
                                "<td>"+data.data[i].loginName+"</td>"+
                                "<td>"+data.data[i].userName+"</td>"+
                                "<td>"+Rtime(data.data[i].recentTime.year,data.data[i].recentTime.monthValue,data.data[i].recentTime.dayOfMonth)+"</td>"+
                                "<td>"+data.data[i].recentIp+"</td>"+
                                "<td>"+Rtime(data.data[i].createTime.year,data.data[i].createTime.monthValue,data.data[i].createTime.dayOfMonth)+"</td>"+
                                "<td><a href='javascript:;' alt="+data.data[i].id+" id='change'>修改</a></td>"+
                                "<td><input type='checkbox' alt="+data.data[i].id+" name='delete'></td>"+
                                "</tr>";
                                $(".tbody").append(str);
                                if(data.data[i].recentTime==null){
                                    $("tr:eq("+(i+1)+") td:eq(3)").html("暂无");
                                }
                                if(data.data[i].recentIp==null||data.data[i].recentIp==""){
                                    $("tr:eq("+(i+1)+") td:eq(4)").html("暂无");
                                }
                            }
                            pageChange();
                        }
                        window.scroll(0,0);
                    });
                      // 点击下一页
                      $(".pageNext").click(function(){
                        if(pageNow==page){
                            alert("已经是最后一页啦~!");
                        }else{
                            pageNow++;
                            // 页次
                            $(".nowPagesNumber").html(pageNow);
                            $(".pageNum a").css("color","black");
                            $(".pageNum a:eq("+(pageNow-1)+")").css("color","red");
                            $(".tbody").html("");
                            var NumStart=pageNumber*(pageNow-1);
                            for(var i=NumStart;i<Math.min(data.data.length,NumStart+pageNumber);i++){
                                if(data.data[i].recentTime==null){
                                    var Ryear="";
                                    var Rmonth="";
                                    var Rday="";
                                }else{
                                    var Ryear=data.data[i].recentTime.year;
                                    var Rmonth=data.data[i].recentTime.monthValue;
                                    var Rday=data.data[i].recentTime.dayOfMonth;
                                }
                                if(data.data[i].createTime==null){
                                    var Cyear="";
                                    var Cmonth="";
                                    var Cday="";
                                }else{
                                    var Cyear=data.data[i].createTime.year;
                                    var Cmonth=data.data[i].createTime.monthValue;
                                    var Cday=data.data[i].createTime.dayOfMonth;
                                }
                                var str="<tr>"+
                                "<td>"+data.data[i].id+"</td>"+
                                "<td>"+data.data[i].loginName+"</td>"+
                                "<td>"+data.data[i].userName+"</td>"+
                                "<td>"+new Date(Ryear+"/"+Rmonth+"/"+Rday).Format("yyyy-MM-dd")+"</td>"+
                                "<td>"+data.data[i].recentIp+"</td>"+
                                "<td>"+new Date(Cyear+"/"+Cmonth+"/"+Cday).Format("yyyy-MM-dd")+"</td>"+
                                "<td><a href='javascript:;' alt="+data.data[i].id+" id='change'>修改</a></td>"+
                                "<td><input type='checkbox' alt="+data.data[i].id+" name='delete'></td>"+
                                "</tr>";
                                $(".tbody").append(str);
                                if(data.data[i].recentTime==null){
                                    $("tr:eq("+(i+1)+") td:eq(3)").html("暂无");
                                }
                                if(data.data[i].recentIp==null||data.data[i].recentIp==""){
                                    $("tr:eq("+(i+1)+") td:eq(4)").html("暂无");
                                }
                            }
                            pageChange();
                        }
                        window.scroll(0,0);
                    });
                      // 页码显示问题
                      function pageChange(){
                        // 每次显示五个页码，前三个页面显示时，随着页码移动，不居中
                        if($('.pageNum').children().length>5&&pageNow<=3){
                            $(".pageNum").children().hide();
                            for(var i=0;i<5;i++){
                                $(".pageNum a:eq("+i+")").show();
                        } // 每次显示五个页码，最后三个页面显示时，随着页码移动，不居中
                    }else if($('.pageNum').children().length>5&&pageNow>page-3){
                        $(".pageNum").children().hide();
                        for(var i=page-5;i<page;i++){
                            $(".pageNum a:eq("+i+")").show();
                        }//中间显示的页码，当前页码居中
                    }else if($('.pageNum').children().length>5){
                        $(".pageNum").children().hide();
                        var pageSta=pageNow-3;
                        for(var i=pageSta;i<pageSta+5;i++){
                            $(".pageNum a:eq("+i+")").show();
                        }
                    }
                }
                    // 总记录数
                    $(".totalNumber").html(data.data.length);
                    // 总页数
                    $(".totalPages").html("/"+page);
                    // 每页条数
                    $(".everyPagesNumber").html(pageNumber);
                }else{
                    alert(data.message);
                }
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
             alert("请求失败，错误代码："+XMLHttpRequest.status);
         }
     });


	//全选反选
	$(".selectAll").click(function(){
			if(this.checked){//如果当前点击的多选框被选中
             $('input[type=checkbox]').attr("checked", true );
         }else{								
            $('input[type=checkbox]').attr("checked", false );
        }
    }); 
	$(".unselect").click(function(){
        $('input[type=checkbox]').each(function(){
           this.checked=!this.checked;
       });
    });


	// 删除所选
	$(".deleteButton").click(function(){
		// 统计选中数目
		var i=0;
        //获取选中数目
        $("input[name='delete']:checked").each(function() {
            i++;
        });
        if(i<=0){
        	alert("请至少选择一项进行删除");
        }else if(i==1){
        	var co=confirm("删除后无法恢复，确定删除？");
        	if(co){
        		var deleteUserNameArray="";
                // =new Array();
                $(".tbody tr").each(function(i){
                    var chk=$(this).find("input[name='delete']");
                    if(chk.attr("checked")){
                    	deleteUserNameArray+=chk.attr("alt")+",";
                    }
                });
                deleteUserNameArray=deleteUserNameArray.substr(0,deleteUserNameArray.lastIndexOf(","));
                // console.log(deleteUserNameArray);
                // 交互
                $.ajax({
                    type: "GET",
                    url: "/deleteUser",
                    data:{
                        id: deleteUserNameArray
                    },
                    success: function (data) {
                        if(data.status==1){
                            alert(data.message);
                            window.location.reload();
                        }else{
                            alert(data.message);
                            // window.location.reload();
                        }
                    },
                    error: function(XMLHttpRequest, textStatus, errorThrown) {
                     alert("删除失败，错误代码："+XMLHttpRequest.status);
                       // window.location.reload();
                   }
               });
            }
        }else{
         var co=confirm("删除后无法恢复，确定删除？");
         if(co){
            var deleteUserNameArray="";
                // =new Array();
                $(".tbody tr").each(function(i){
                    var chk=$(this).find("input[name='delete']");
                    if(chk.attr("checked")){
                        deleteUserNameArray+=chk.attr("alt")+",";
                    }
                });
                deleteUserNameArray=deleteUserNameArray.substr(0,deleteUserNameArray.lastIndexOf(","));
                // console.log(deleteUserNameArray);
                // 交互
                $.ajax({
                    type: "GET",
                    url: "/deleteUsers",
                    data:{
                        ids: deleteUserNameArray
                    },
                    success: function (data) {
                        if(data.status==1){
                            alert(data.message);
                            window.location.reload();
                        }else{
                            alert(data.message);
                            // window.location.reload();
                        }
                    },
                    error: function(XMLHttpRequest, textStatus, errorThrown) {
                     alert("删除失败，错误代码："+XMLHttpRequest.status);
                       // window.location.reload();
                   }
               });
            } 
        }
    });
});