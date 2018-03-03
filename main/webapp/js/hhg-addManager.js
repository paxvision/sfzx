$(function(){
	// 添加管理员
	$("#sub").click(function(){
		var data=new FormData($("#addManager")[0]);
        if(data.get("loginName")==""||data.get("loginName").length>10||data.get("loginName").length<3||data.get("password")==""||data.get("password").length<6||data.get("password").length>16||data.get("password")!=$(".confirmPassword").attr("value")){
            if(data.get("loginName")==""||data.get("loginName").length>10||data.get("loginName").length<3){
                $(".loginName").addClass("has-error");
            }else{
                $(".loginName").removeClass("has-error");
            }
            if(data.get("password")==""||data.get("password").length<6||data.get("password").length>16){
                $(".password").addClass("has-error");
            }else if(data.get("password")!=$(".confirmPassword").attr("value")){
                alert("两次密码输入不相同");
                $(".password").addClass("has-error");
            }else{
              $(".password").removeClass("has-error");
            }
        }else{
            $.ajax({
                type: "POST",
                url: "/insertUser",
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
                    }
                },
                error: function(XMLHttpRequest, textStatus, errorThrown) {
                    alert("提交失败，错误代码："+XMLHttpRequest.status);
                }
            });  
        }
	});
});