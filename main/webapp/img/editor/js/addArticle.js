
$(function() {
	var pendingRequests = {};
	$.ajaxPrefilter(function( options, originalOptions, jqXHR ) {
			 var key = options.url;
			 console.log(key);
			 if (!pendingRequests[key]) {
			  pendingRequests[key] = jqXHR;
			 }else{
			  //jqXHR.abort(); //放弃后触发的提交
			  pendingRequests[key].abort(); // 放弃先触发的提交
			 }
			 
			 var complete = options.complete;
			 options.complete = function(jqXHR, textStatus) {
			  pendingRequests[key] = null;
			  if ($.isFunction(complete)) {
			  complete.apply(this, arguments);
			  }
		 };
	});
	/*生成id*/
    //var myID = new Date().getTime();
	$('#submit').click(function() {
        var myID = new Date().getTime();
        console.log(myID);
		var title = $("input[type='text']").val();
		var content = $('#customized-buttonpane').html();
        console.log(content);
        
		
        $.ajax({
			type:"POST",
			url:"http://rapapi.org/mockjsdata/22327/management/insertArticle",
			data:{
				articleTitle:title,
				articleContent:content,
				articleId:myID

			},
			success:function(data) {
				if(data.status==1){
                    alert("保存成功！");
                    window.open("listArticel.html");
				}
				console.log(title);
			},
			error:function(jqXHR, textStatus, errorThrown){
			  if(errorThrown != 'abort'){
			   //ajax被调用abort后执行的方法
			   alert('您的ajax方法被停止了');
			  }
			}
		})
	});
	//不需要去单独获取图片，因为插件可以自己上传图片数据
	/*$(document).on("change",'input[type="file"]',function() {
		console.log(23);
		var file = this.files[0];
		console.log(file);
		var data = new FormData("picture",file);
		data.append("imageRef",myID);
		var oReq = new XMLHttpRequest();
		oReq.open("POST", "/blog/management/uploadImage", true);
		  oReq.onload = function(data) {
		    console.log(data);
		    
		  };


          oReq.send(data);

		$.ajax({
			type:"POST",
			url:"http://rapapi.org/mockjsdata/22327/management/uploadImage",
			data:{
				data
			},
			success:function() {
				console.log('success');
			},
			erroe:function() {
				console.log('erroe');
			}
		})
	});*/


});