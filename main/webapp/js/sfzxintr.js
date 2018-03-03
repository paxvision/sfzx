$(function(){
    //动态移除js，css文件
    function removejscssfile(filename, filetype){
        var targetelement=(filetype=="js")? "script" : (filetype=="css")? "link" : "none"
        var targetattr=(filetype=="js")? "src" : (filetype=="css")? "href" : "none"
        var allsuspects=document.getElementsByTagName(targetelement)
        for (var i=allsuspects.length; i>=0; i--){
            if (allsuspects[i] && allsuspects[i].getAttribute(targetattr)!=null && allsuspects[i].getAttribute(targetattr).indexOf(filename)!=-1)
                allsuspects[i].parentNode.removeChild(allsuspects[i])
        }
    }
    //一级导航点击生成二级导航
    $('#mainNav li').click(function(){
        var firstNavigationName = $(this).text();
        console.log(firstNavigationName);
        var leftTitle = '';
            leftTitle =
                    '<div class="ico">'+
                    '<img src="img/ico.jpg">'+
                    '</div>'+
                    '<div class="LE_title">'+
                    firstNavigationName+
                    '</div>';
        $('.LE_header').html(leftTitle);
        if(firstNavigationName == "中心首页"){
            window.location.href="index.html";
        }else{
            $.ajax({
                type:'GET',
                url:'/selectSecondNavigations',
                data:{
                    'firstNavigationName': firstNavigationName
                },
                success: function(data){
                    var odata = data.data;
                    var len = odata.length;
                    if(data.status == 1){
                        var str = '';
                        for(var i=0; i< len; i++) {
                            str += '<li>' + odata[i].secondNavigationBarName  + '</li>' ;
                        }
                        console.log(555);
                        var str2 ='';
                        str2 = '<div class="part">' +
                               '<ul id="secNav">' +
                                str+
                               '</ul>' +
                               '</div>';
                        $('.S_secNav').html(str2);
						var leftNav = '';
                        for(var i=0; i< len; i++) {
                            leftNav+='<li>'+ '<img src="img/Arrow_01.jpg">'+'<a>'+odata[i].secondNavigationBarName+'</a>'+
                                '</li>';
                        }
                        var leftContainer = '';
                            leftContainer =  '<ul>'+leftNav+ '</ul>';
                        $('.left_nav').html(leftContainer);
                        //通过二级导航加载相应内容
                        $('#secNav li').click(function(){
                            var secondNavigationName = $(this).text();
                            console.log(secondNavigationName);
                            $.ajax({
                                type:'GET',
                                url:'/selectSecondNavigation',
                                data:{
                                    'secondNavigationName': secondNavigationName
                                },
                                success: function(data){
                                    var odata = data.data;
                                    if(data.status == 1){
                                        var headtitle = '';
                                        headtitle = '<img src="img/circle.jpg">'+
                                                    '<span><a href="">首页</a></span>'+
                                                    '<img src="img/Arrow_02.gif">'+
                                                    '<span><a href="">'+secondNavigationName+'</a></span>';
                                        $('.Right_head').html(headtitle);
                                        var articleTitle = odata.articleTitle;
                                        $('.Right_title').html(articleTitle);
                                        console.log(articleTitle);
                                        var updateTime = '更新时间:&nbsp;'+odata.articleCreateDate;
                                        $('.updataTime').html(updateTime);
                                        console.log(updateTime);
                                        var articleContent = odata.articleContent;
                                        $('.blank').html(articleContent);
                                        console.log(articleContent);
                                    }
                                },
								error: function(){
                                	alert('请求失败');
								}
                            })
                        });
                    }
                },
                error: function(){
                    alert('请求失败');
                }
            })
        }
    });
//页面查询
   $('#go').click(function(){
       var secondNavigationName = $("input[name='keyword']").val();
       console.log(secondNavigationName);
       $.ajax({
           type:'GET',
           url:'/selectFirstNavigationAndSecondNavigation',
           data:{
               'secondNavigationName': secondNavigationName
           },
           success: function(data){
               var odata = data.data;
               var Data = odata.secondNavigationList[0];
               console.log(odata);
               var len = odata.length;
               if(data.status == 1){
                   var headtitle = '';
                   headtitle = '<img src="img/circle.jpg">'+
                       '<span><a href="">首页</a></span>'+
                       '<img src="img/Arrow_02.gif">'+
                       '<span><a href="">'+secondNavigationName+'</a></span>';
                   $('.Right_head').html(headtitle);
                   var articleTitle = Data.articleTitle;
                   $('.Right_title').html(articleTitle);
                   console.log(articleTitle);
                   var updateTime = '更新时间:&nbsp;'+Data.articleCreateDate;
                   $('.updataTime').html(updateTime);
                   console.log(updateTime);
                   var articleContent = Data.articleContent;
                   $('.blank').html(articleContent);
                   console.log(articleContent);
                   //左侧标题
                   var leftTitle = '';
                   leftTitle =
                       '<div class="ico">'+
                       '<img src="img/ico.jpg">'+
                       '</div>'+
                       '<div class="LE_title">'+
                       odata.firstNavigationBarName+
                       '</div>';
                   $('.LE_header').html(leftTitle);
                   //左侧导航
                   var leftNav = '';

                       leftNav+='<li>'+ '<img src="img/Arrow_01.jpg">'+'<a>'+secondNavigationName+'</a>'+
                           '</li>';

                   var leftContainer = '';
                   leftContainer =  '<ul>'+leftNav+ '</ul>';
                   $('.left_nav').html(leftContainer);
               }
           },
           error: function(){
               alert('请求失败');
           }
       })
   });
})

