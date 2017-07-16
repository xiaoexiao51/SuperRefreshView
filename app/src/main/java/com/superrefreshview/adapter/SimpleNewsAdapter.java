package com.superrefreshview.adapter;

import android.content.Context;

import com.superrefreshview.R;
import com.superrefreshview.bean.SimpleNewsBean;

import java.util.List;

/**
 * Created by lilei on 2017/5/10.
 */

public class SimpleNewsAdapter extends BaseRecyclerAdapter<SimpleNewsBean.ContentBean> {

    public SimpleNewsAdapter(Context ctx, List<SimpleNewsBean.ContentBean> list) {
        super(ctx, list);
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_simple_news;
    }

    @Override
    protected void bindData(final RecyclerViewHolder holder, int position, SimpleNewsBean.ContentBean item) {

        holder.getImageView(R.id.iv_newsimg).setImageResource(item.getTitleImg());
        holder.getTextView(R.id.tv_newstitle).setText(item.getContentTitle());
        holder.getTextView(R.id.tv_newstime).setText(item.getPublishTime());
    }

}


