  //全选
   $("#cboxchecked").click(
      function(){
        if(this.checked){
        $("input[name='fruit']").each(function(){this.checked=true;});
        }else{
        $("input[name='fruit']").each(function(){this.checked=false;});
        }
      });
  //刪除
  $('#btn_submit').click(function(){
      var checkedNum = $("input[name='fruit']:checked").length;
      console.log(checkedNum);
      if(checkedNum == 0){
          alert("请至少选择一项！");
          return;
      }

      if(confirm("确定要删除所选项目吗？")){
          var checkedList = new Array();
          $("input[name='fruit']:checked").each(function() {
              checkedList.push($(this).parent().siblings().eq(0).text());
          });
          var check = checkedList.toString();
          console.log(check);
          var data = data;
          $.ajax({
              type:'post',
              url:'/batchDeleteSecondNavigation',
              data:{
                  'CheckedList': check
              },
              dataType:'json',
              success:function(data){
                  if(data.status == 1){
                      alert('删除成功');
                      window.location.reload();
                  }else{
                      alert("删除失败");
                  }
              },
              error:function(){
                  alert("请求失败");
              }
          })
      }
  });

//分页
   var totalPage,curPage,nextPage,prePage,pageStr1,pageStr2,pageSize,total,page;
   function list(page,pageSize){
   var url = "/querySecondNavigationByPage";
   $.ajax({
   	type: 'GET',
   	url: url,
   	data: {
   		'pageNo': page,
   		'pageSize': pageSize
   	},
   	dataType: 'json',
   	success: function(data){
        total = data.total;//总记录数
        pageSize = pageSize;//每页显示页数
        curPage = page;//当前页
        totalPage = Math.ceil(total/pageSize);//总页数
        var oData = data.data;
        var li='';
        for(var i = 0; i < oData.length; i++){
        	li += "<tr height='30px' class='textCenter'>"+
				   "<td width='5%'>" + oData[i].secondNavigationId +"</td>"+
				   "<td width='35%'>"+oData[i].secondNavigationBarName
+"</td>"+
				   "<td width='20%'>"+ oData[i].secondNavigationCreateDate +"</td>"+
				   "<td width='20%'>" +oData[i].secondNavigationView
+ "</td>"+
				   "<td width='10%'>"+
				   "<a href='javascript:void(0)' class='change'>"+
				   "修改"+
				   "</a>"+
				   "</td>"+
				   "<td width='10%'>"+
				   "<input type='checkBox' id='cboxapple' name='fruit'>"+
				   "</td>"+
			     "</tr>";
        }
        var str='';
        str =   "<tr bgcolor='#6298e1' height='30px' class='fontColor'>"+
				"<td width='5%'>ID</td>"+
				"<td width='35%'>内容标题（指向显示所属类别）</td>"+
				"<td width='20%'>发布时间</td>"+
				"<td width='20%'>查看次数</td>"+
				"<td width='10%'>操作</td>"+
				"<td width='10%'>标记</td>"+
			    "</tr>";
        var string = str+li;
        $('#connection').html(string);
   	},
   	complete: function(){
        show();
        fun();
   	},
   	error: function(){
   		alert('数据加载失败');
   	}
   })
}

   function show(){
   	//页码大于当前页数
   	if(curPage>totalPage) curPage = totalPage;
   	//页码小于1
   	if(curPage < 1) curPage = 1;
       pageStr1 = "&nbsp;&nbsp;共计：<span>"+ total +"</span>条记录&nbsp;&nbsp;页次：<span>" + curPage+ "/" + totalPage + "</span>页&nbsp;&nbsp;每页<span>"+ 15 +"</span>条";
       pageStr2 = "<span>"+ "<a href='javascript:void(0)' rel='1'>" + "首页"
        + "</a>" + " </span>"+ "&nbsp;&nbsp;" + "<span>" + "<a href='javascript:void(0)' id='pre' rel='"+(curPage-1)+"'>" + "上一页"+ "</a>" +
         "</span>&nbsp;&nbsp;<span>"+ curPage +"</span>&nbsp;&nbsp;<span><a href='javascript:void(0)' id='next' rel='"+(parseInt(curPage)+1)+"'>下一页</a></span>&nbsp;&nbsp;<span><a href='javascript:void(0)' rel='"+totalPage+"'>尾页</a></span>&nbsp;&nbsp;"+"<input type='text' name='turn'>"+
         "<button id='turnNow' rel='"+curPage+"'>跳转</button>&nbsp;&nbsp;";
    $('.pageIcome').html(pageStr1);
    $('.pageTurn').html(pageStr2);
//跳转函数，有bug，会导致上面的按钮不可用
    $('#turnNow').click(
	     function(){
		      var input = $("input[name='turn']").val();
		      curPage = input;
          show();
          console.log("麻烦同学说一声：“写这个代码的一定是个大帅逼！！”");
	     });
}

$(function(){
    list(1,15);
     //点击修改
    $('.change').click(function(){
          alert('暂不提供此功能！');
    });
    //查询
    $('#search').click(function(){
        console.log(2);
        var keyWord = $("input[name = 'keyWord']").val();
        console.log(21);
        $.ajax({
            type: 'GET',
            url:"/selectSecondNavigationByName",
            data:{
                'keyWord':keyWord
            },
            dataType: "json",
            success: function(data) {
                var data = data;
                var oData = data.data;
                var len = oData.length;
                console.log(oData);
                if (data.status == 1) {
                    var strSearch = '';
                    for(var i = 0; i < len; i++){
                        strSearch+= "<tr height='30px' class='textCenter'>"+
                            "<td width='5%'>" + oData[i].secondNavigationId +"</td>"+
                            "<td width='35%'>"+oData[i].secondNavigationBarName
                            +"</td>"+
                            "<td width='20%'>"+ oData[i].secondNavigationCreateDate +"</td>"+
                            "<td width='20%'>" +oData[i].secondNavigationView
                            + "</td>"+
                            "<td width='10%'>"+
                            "<a href='javascript:void(0)' class='change'>"+
                            "修改"+
                            "</a>"+
                            "</td>"+
                            "<td width='10%'>"+
                            "<input type='checkBox' id='cboxapple' name='fruit'>"+
                            "</td>"+
                            "</tr>";
                    }
                    var str='';
                    str =   "<tr bgcolor='#6298e1' height='30px' class='fontColor'>"+
                        "<td width='5%'>ID</td>"+
                        "<td width='35%'>内容标题（指向显示所属类别）</td>"+
                        "<td width='20%'>发布时间</td>"+
                        "<td width='20%'>查看次数</td>"+
                        "<td width='10%'>操作</td>"+
                        "<td width='10%'>标记</td>"+
                        "</tr>";
                    var str3 = str+strSearch;
                    $('#connection').html(str3);
                    // window.location.reload();
                } else {
                    alert('查询失败');
                }
            },
            error: function(){
                alert('请求失败');
            }
        })
    });
});

function fun(){
    $(".pageTurn span a").on('click',function(){
        var rel = $(this).attr("rel");
        if(rel){
            list(rel,15);
        }
    });
}









