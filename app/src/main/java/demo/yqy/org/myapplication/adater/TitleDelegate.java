package demo.yqy.org.myapplication.adater;


import android.widget.TextView;

import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import demo.yqy.org.myapplication.R;
import demo.yqy.org.myapplication.bean.ShowBean;
import demo.yqy.org.myapplication.bean.TitleBean;

/**
 * @author yqy
 * @create 19-6-24
 * @Describe
 */
public class TitleDelegate implements ItemViewDelegate<ShowBean> {


    @Override
    public int getItemViewLayoutId() {
        return R.layout.layout_item_title;
    }

    @Override
    public boolean isForViewType(ShowBean item, int position) {
        return item.getShowType() == ShowBean.Type_Title;
    }

    @Override
    public void convert(ViewHolder holder, ShowBean showBean, int position) {
        final TitleBean titleBean = showBean.getTitleBean();
        if (titleBean != null) {
            ((TextView) holder.getView(R.id.tv_title)).setText(titleBean.getTitle());
        }
    }
}
