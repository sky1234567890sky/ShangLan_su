package com.sport.sportproject.ui.fragment_circlezi.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sport.sportproject.R;
import com.sport.sportproject.base.BaseApp;
import com.sport.sportproject.ui.fragment_circlezi.bean.CircleTopicBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CircleTopicAdapter extends RecyclerView.Adapter {
    private ArrayList<CircleTopicBean.DataBean.TopicListBean> topicListBeans;
    private Context context;

    public CircleTopicAdapter(ArrayList<CircleTopicBean.DataBean.TopicListBean> topicListBeans) {
        this.topicListBeans = topicListBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new CircleTopicViewHolder(LayoutInflater.from(context).inflate(R.layout.item_topic, null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CircleTopicViewHolder holder1 = (CircleTopicViewHolder) holder;
        CircleTopicBean.DataBean.TopicListBean topicListBean = topicListBeans.get(position);
        holder1.mItemTvTitle.setText(topicListBean.getTitle());
        Glide.with(BaseApp.getInstance()).load(topicListBean.getLogo_url()).into(holder1.mItemIvLogo);

        if (topicListBean.getType().equals("line_two")) {
            holder1.mItemRlv.setLayoutManager(new GridLayoutManager(context, 2));
        } else {
            holder1.mItemRlv.setLayoutManager(new GridLayoutManager(context, 4));
        }
        CircleTopicClickAdapter circleTopicClickAdapter = new CircleTopicClickAdapter(topicListBean.getType(), topicListBean.getList());
        holder1.mItemRlv.setAdapter(circleTopicClickAdapter);
        circleTopicClickAdapter.notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        return topicListBeans != null ? topicListBeans.size() : 0;
    }

    class CircleTopicViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_iv_logo)
        ImageView mItemIvLogo;
        @BindView(R.id.item_tv_title)
        TextView mItemTvTitle;
        @BindView(R.id.item_rlv)
        RecyclerView mItemRlv;

        public CircleTopicViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
