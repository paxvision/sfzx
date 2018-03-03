/**
 * Created by 赵小莉 on 2017/7/20.
 */
//广告首页tab导航
function nTabs(tabObj,obj){
    var tabList = document.getElementById(tabObj).getElementsByTagName("li");
    for(i=0; i <tabList.length; i++)
    {
        if (tabList[i].id == obj.id)
        {
            document.getElementById(tabObj+"_Title"+i).className = "active";
            document.getElementById(tabObj+"_Content"+i).style.display = "block";
        }else{
            document.getElementById(tabObj+"_Title"+i).className = "normal";
            document.getElementById(tabObj+"_Content"+i).style.display = "none";
        }
    }
}