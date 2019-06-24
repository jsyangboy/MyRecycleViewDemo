package demo.yqy.org.myapplication;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;

import java.util.ArrayList;
import java.util.List;

import demo.yqy.org.myapplication.adater.BigPicDelegate;
import demo.yqy.org.myapplication.adater.FourPicDelegate;
import demo.yqy.org.myapplication.adater.ThreePicDelegate;
import demo.yqy.org.myapplication.adater.TitleDelegate;
import demo.yqy.org.myapplication.adater.TowPicDelegate;
import demo.yqy.org.myapplication.bean.ItemBean;
import demo.yqy.org.myapplication.bean.ShowBean;
import demo.yqy.org.myapplication.bean.TitleBean;

public class MainActivity extends AppCompatActivity {

    MultiItemTypeAdapter multiItemTypeAdapter;

    List<ShowBean> showBeanList = new ArrayList<>(30);

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleView);

        /**
         * demo这里一行对多12个item,这个12是由每行显示的最小公倍数,我这里显示的类型有每行有1,2,3,4个,所以最小公倍数为
         * 12
         */
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 12);

        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                final ShowBean showBean = showBeanList.get(position);
                if (showBean == null) {
                    return 0;
                }

                switch (showBean.getShowType()) {
                    case ShowBean.Type_Title:
                        /**
                         * 指标题栏一个就占12个
                         */
                        return 12;
                    case ShowBean.Type_Big_Pic:
                        /**
                         * 大图一个就占12个
                         */
                        return 12;
                    case ShowBean.Type_Tow_Pic:
                        /**
                         * 一行显示两个图片,那一个图片所占的位置为6个
                         */
                        return 6;
                    case ShowBean.Type_Three_Pic:
                        /**
                         * 一行显示三个图片,那一个图片所占的位置为4个
                         */
                        return 4;
                    case ShowBean.Type_Four_Pic:
                        /**
                         * 一行显示四个图片,那一个图片所占的位置为3个
                         */
                        return 3;
                    default:
                        return -1;
                }
            }
        });

        recyclerView.setLayoutManager(gridLayoutManager);
        multiItemTypeAdapter = new MultiItemTypeAdapter(this, showBeanList);
        recyclerView.setAdapter(multiItemTypeAdapter);

        /**
         * 你还可以定义更多的不同的类型
         */
        multiItemTypeAdapter.addItemViewDelegate(new TitleDelegate());
        multiItemTypeAdapter.addItemViewDelegate(new BigPicDelegate());
        multiItemTypeAdapter.addItemViewDelegate(new TowPicDelegate());
        multiItemTypeAdapter.addItemViewDelegate(new ThreePicDelegate());
        multiItemTypeAdapter.addItemViewDelegate(new FourPicDelegate());

        loadData();
    }

    private void loadData() {
        showBeanList.add(loadTitle("我是1个的"));
        showBeanList.add(loadBigPic("好漂亮好漂亮好漂亮好漂亮好漂亮好漂亮好漂亮"));

        showBeanList.add(loadTitle("我是2个的"));
        showBeanList.add(loadTowPic("好漂亮"));
        showBeanList.add(loadTowPic("好漂亮"));

        showBeanList.add(loadTitle("我是3个的"));
        showBeanList.add(loadThreePic("好漂亮"));
        showBeanList.add(loadThreePic("好漂亮"));
        showBeanList.add(loadThreePic("好漂亮"));

        showBeanList.add(loadTitle("我是4个的"));
        showBeanList.add(loadFourPic("好漂亮"));
        showBeanList.add(loadFourPic("好漂亮"));
        showBeanList.add(loadFourPic("好漂亮"));
        showBeanList.add(loadFourPic("好漂亮"));

        multiItemTypeAdapter.notifyDataSetChanged();
    }

    /**
     * 设置标题数据
     *
     * @param title
     * @return
     */
    private ShowBean loadTitle(String title) {
        final ShowBean showBean = new ShowBean();
        showBean.setShowType(ShowBean.Type_Title);

        if (TextUtils.isEmpty(title)) {
            title = "";
        }
        showBean.setTitleBean(new TitleBean(title));
        return showBean;
    }

    /**
     * 获取大图的数据
     *
     * @param title
     * @return
     */
    private ShowBean loadBigPic(String title) {
        final ShowBean showBean = new ShowBean();
        showBean.setShowType(ShowBean.Type_Big_Pic);

        if (TextUtils.isEmpty(title)) {
            title = "";
        }

        final ItemBean itemBean = new ItemBean();
        itemBean.setTitle(title);
        itemBean.setDrawableId(R.mipmap.none_event_img_meinv0);
        showBean.setItemBean(itemBean);
        return showBean;
    }

    /**
     * 获取两张图片的数据
     *
     * @param title
     * @return
     */
    private ShowBean loadTowPic(String title) {
        final ShowBean showBean = new ShowBean();
        showBean.setShowType(ShowBean.Type_Tow_Pic);

        if (TextUtils.isEmpty(title)) {
            title = "";
        }

        final ItemBean itemBean = new ItemBean();
        itemBean.setTitle(title);
        itemBean.setDrawableId(R.mipmap.none_event_img_meinv1);
        showBean.setItemBean(itemBean);

        return showBean;
    }

    /**
     * 获取三张图片的数据
     *
     * @param title
     * @return
     */
    private ShowBean loadThreePic(String title) {
        final ShowBean showBean = new ShowBean();
        showBean.setShowType(ShowBean.Type_Three_Pic);

        if (TextUtils.isEmpty(title)) {
            title = "";
        }

        final ItemBean itemBean = new ItemBean();
        itemBean.setTitle(title);
        itemBean.setDrawableId(R.mipmap.none_event_img_meinv2);
        showBean.setItemBean(itemBean);
        return showBean;
    }

    /**
     * 获取四张图片的数据
     *
     * @param title
     * @return
     */
    private ShowBean loadFourPic(String title) {
        final ShowBean showBean = new ShowBean();
        showBean.setShowType(ShowBean.Type_Four_Pic);

        if (TextUtils.isEmpty(title)) {
            title = "";
        }

        final ItemBean itemBean = new ItemBean();
        itemBean.setTitle(title);
        itemBean.setDrawableId(R.mipmap.none_event_img_meinv3);
        showBean.setItemBean(itemBean);
        return showBean;
    }

}
