package demo.yqy.org.myapplication.bean;

/**
 * @author yqy
 * @create 19-6-24
 * @Describe
 */
public class ShowBean {
    public final static int Type_Title = 0;
    public final static int Type_Big_Pic = 1;
    public final static int Type_Tow_Pic = 2;
    public final static int Type_Three_Pic = 3;
    public final static int Type_Four_Pic = 4;


    private int showType;

    /*private TitleBean titleBean;
    private ItemBean itemBean;

    public TitleBean getTitleBean() {
        return titleBean;
    }

    public void setTitleBean(TitleBean titleBean) {
        this.titleBean = titleBean;
    }

    public ItemBean getItemBean() {
        return itemBean;
    }

    public void setItemBean(ItemBean itemBean) {
        this.itemBean = itemBean;
    }
*/
    public int getShowType() {
        return showType;
    }

    public void setShowType(int showType) {
        this.showType = showType;
    }
}
