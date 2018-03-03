$("#my_button").click(function() {

    var loginName = $("#username").val();
    var password = $("#password").val();

    $.ajax({
        type:"post",
        url:"/login",
        data:{
            loginName: loginName,
            password: password
        },
        success:function(data){
            if(data.status == 1){
                window.location.href = "admin.html";
            }else{
                alert("用户名或密码错误!");
            }
        }
    });
})
