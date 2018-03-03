$(function(){
    // 选中当前tab
    $(".p9").click();
	  $.ajax({
        type: "GET",
        url: "js/ceshi1.json",
        dataType : "json",
        success : function(data){
                    // 定义当前页码
                    var pageNow;
                    //设置每页显示的个数
                    var pageNumber=5;
                    // 计算页数
                    var page=Math.ceil(data.infoSystemZiyuan.length/pageNumber);
                    //插入页数
                    for(var j=1;j<=page;j++){
                        $(".pageNum").append("<a href='javascript:;' id='"+j+"' class='pageNumMain'>"+j+"</a>");
                    }
                    // 初始页码为1
                    for(var i=0;i<pageNumber;i++){
                        pageNow=1;
                        // 页次
                         $(".nowPagesNumber").html(pageNow);
                        $(".pageNum a").css("color","black");
                        $(".pageNum a:eq("+(pageNow-1)+")").css("color","red");
                        var str="<div class='infoMainMiniBlock'>"+
                                                            "<img src='"+data.infoSystemZiyuan[i].pic+"' class='miniPic'>"+
                                                            "<div class='intro'>"+
                                                            "<div class='name'><img src='img/Arrow_04.gif'>"+data.infoSystemZiyuan[i].title+"</div>"+
                                                            "<div class='message'>"+data.infoSystemZiyuan[i].intro+"</div>"+
                                                            "</div>"+
                                                            "</div>";
                        $(".infoMainMiniBlockBig").append(str);
                        pageChange();
                    }
                    $(".pageNumMain").click(function(){
                        pageNow=$(this).attr("id");
                        // 页次
                        $(".nowPagesNumber").html(pageNow);
                        $(".pageNum a").css("color","black");
                        $(".pageNum a:eq("+(pageNow-1)+")").css("color","red");
                        $(".infoMainMiniBlockBig").html("");
                        var pageN=$(this).attr("id");
                        var NumStart=pageNumber*(pageN-1);
                        for(var i=NumStart;i<Math.min(data.infoSystemZiyuan.length,NumStart+pageNumber);i++){
                            var str="<div class='infoMainMiniBlock'>"+
                                                    "<img src='"+data.infoSystemZiyuan[i].pic+"' class='miniPic'>"+
                                                    "<div class='intro'>"+
                                                    "<div class='name'><img src='img/Arrow_04.gif'>"+data.infoSystemZiyuan[i].title+"</div>"+
                                                    "<div class='message'>"+data.infoSystemZiyuan[i].intro+"</div>"+
                                                    "</div>"+
                                                    "</div>";
                             $(".infoMainMiniBlockBig").append(str);
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
                            $(".infoMainMiniBlockBig").html("");
                            var NumStart=pageNumber*(pageNow-1);
                            for(var i=NumStart;i<Math.min(data.infoSystemZiyuan.length,NumStart+pageNumber);i++){
                            var str="<div class='infoMainMiniBlock'>"+
                                            "<img src='"+data.infoSystemZiyuan[i].pic+"' class='miniPic'>"+
                                            "<div class='intro'>"+
                                            "<div class='name'><img src='img/Arrow_04.gif'>"+data.infoSystemZiyuan[i].title+"</div>"+
                                            "<div class='message'>"+data.infoSystemZiyuan[i].intro+"</div>"+
                                            "</div>"+
                                            "</div>";
                            $(".infoMainMiniBlockBig").append(str);
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
                            $(".infoMainMiniBlockBig").html("");
                            var NumStart=pageNumber*(pageNow-1);
                            for(var i=NumStart;i<Math.min(data.infoSystemZiyuan.length,NumStart+pageNumber);i++){
                                 var str="<div class='infoMainMiniBlock'>"+
                                            "<img src='"+data.infoSystemZiyuan[i].pic+"' class='miniPic'>"+
                                            "<div class='intro'>"+
                                            "<div class='name'><img src='img/Arrow_04.gif'>"+data.infoSystemZiyuan[i].title+"</div>"+
                                            "<div class='message'>"+data.infoSystemZiyuan[i].intro+"</div>"+
                                            "</div>"+
                                            "</div>";
                            $(".infoMainMiniBlockBig").append(str);
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
                    $(".totalNumber").html(data.infoSystemZiyuan.length);
                    // 总页数
                    $(".totalPages").html("/"+page);
                    // 每页条数
                    $(".everyPagesNumber").html(pageNumber);
                   },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            alert(textStatus);
        }
    });
});