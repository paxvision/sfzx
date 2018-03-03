
$(function(){
	$('#first').change(function(){
		var index = $(this).get(0).selectedIndex;
        $('.second').css('display', 'none');
        $('.second').eq(index).css('display','block');


    $('#submitNow').click(function(){
       // var index02 = $(this).get(0).selectedIndex;
    	if(confirm('确认提交？'))
    	{
        var articleTitle = $('#title').val();
        var secondNavigationBarName = $('#first').val();
        var articleContent = $('#customized-buttonpane').html();
        var data = data;
        console.log(articleTitle);
        console.log(secondNavigationBarName);
        console.log(articleContent);
        $.ajax({
			type: 'POST',
			url: 'http://localhost:8080/insertArticleContent',
			data:{
                    'articleTitle':articleTitle,
                    'articleContent': articleContent,
                    'secondNavigationBarName':secondNavigationBarName
			},
			success: function(data){
				if(data.status == 1)
                {
                	window.location.reload();
                    alert('提交成功');
                }else{
				    alert('提交失败');
                }
			},
			error: function () {
                    alert("请求失败");
                }

		})
    }}
    )
})
});