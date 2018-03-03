/**
 * Created by 赵小莉 on 2017/7/22.
 */
function AddFavorite(sURL, sTitle) {
    try {
        window.external.addFavorite(sURL, sTitle);
    } catch (e) {
        try {
            window.sidebar.addPanel(sTitle, sURL, "");
        } catch (e) {
            alert("抱歉，您的浏览器不支持，请使用Ctrl+D进行手动添加");
        }
    }
}