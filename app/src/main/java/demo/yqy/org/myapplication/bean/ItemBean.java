package demo.yqy.org.myapplication.bean;

/**
 * @author yqy
 * @create 19-6-24
 * @Describe
 */
public class ItemBean {

    private String title;//对应的标题
    private String time;//视频的时长
    private String url;//图片的url

    private String otherInfo;

    /**
     * 我这里为了方便
     */
    private int drawableId;

    public int getDrawableId() {
        return drawableId;
    }

    public void setDrawableId(int drawableId) {
        this.drawableId = drawableId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
