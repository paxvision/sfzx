$(function(){
	// 点击修改切换
	// 修改
    $(".tbody").on("click","#change",function(){
       $(".viewAllManager").css("display","none");
       $(".changemanagerMain").css("display","block");
       var oLoginName=$(this).parent().prev().prev().prev().prev().prev().html();
       var oUserName=$(this).parent().prev().prev().prev().prev().html();
       var oId=$(this).parent().prev().prev().prev().prev().prev().prev().html();
       $(".loginName").attr("value",oLoginName);
       $(".userName").attr("value",oUserName);
       $(".id").attr("value",oId);
       // 交互
       $("#changeClick").click(function(){
       		var data=new FormData($("#changeManager")[0]);
/*       		console.log(data.get("id"));
       		console.log(data.get("loginName"));
       		console.log(data.get("newPassword"));
       		console.log(data.get("userName"));*/
       		$.ajax({
                type: "POST",
                url: "/updateUser",
                data:data,
                async:false,
                cache:false,
                contentType:false,
                processData:false,
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
                     alert("修改失败，错误代码："+XMLHttpRequest.status);
                    // window.location.reload();
                }
            });  
       });
    });
});