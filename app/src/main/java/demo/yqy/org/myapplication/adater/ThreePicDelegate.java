package demo.yqy.org.myapplication.adater;

import android.widget.ImageView;

import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import demo.yqy.org.myapplication.R;
import demo.yqy.org.myapplication.bean.ItemBean;
import demo.yqy.org.myapplication.bean.ShowBean;

/**
 * @author yqy
 * @create 19-6-24
 * @Describe
 */
public class ThreePicDelegate implements ItemViewDelegate<ShowBean> {
    @Override
    public int getItemViewLayoutId() {
        return R.layout.layout_item_three;
    }

    @Override
    public boolean isForViewType(ShowBean item, int position) {
        return item.getShowType() == ShowBean.Type_Three_Pic;
    }

    @Override
    public void convert(ViewHolder holder, ShowBean showBean, int position) {
        final ItemBean itemBean = (ItemBean) showBean;
        if (itemBean != null) {
            ((ImageView) holder.getView(R.id.iv_pic)).setImageResource(itemBean.getDrawableId());
        }

    }
}
