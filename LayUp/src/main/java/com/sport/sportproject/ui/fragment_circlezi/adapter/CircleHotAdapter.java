package com.sport.sportproject.ui.fragment_circlezi.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sport.sportproject.R;
import com.sport.sportproject.base.BaseApp;
import com.sport.sportproject.ui.fragment_circlezi.bean.CircleNormalBean;
import com.sport.sportproject.utils.RoundImageView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
 *   梨花带雨,我见优伶
 *      2019/4/25
 */
public class CircleHotAdapter extends RecyclerView.Adapter {

    private final ArrayList<CircleNormalBean.DataBean.TopicBannerBean.TopicListBean> topicBannerBeans;

    public CircleHotAdapter(ArrayList<CircleNormalBean.DataBean.TopicBannerBean.TopicListBean> topicBannerBeans) {
        this.topicBannerBeans = topicBannerBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CircleHotViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_circlehot, null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CircleHotViewHolder hotViewHolder = (CircleHotViewHolder) holder;
        hotViewHolder.mTvTitle.setText(topicBannerBeans.get(position).getTitle());
        hotViewHolder.mTvSubtitle.setText(topicBannerBeans.get(position).getSubtitle());
        Glide.with(BaseApp.getInstance()).load(topicBannerBeans.get(position).getBg_url()).into(hotViewHolder.mTvBgUrl);
    }

    @Override
    public int getItemCount() {
        return topicBannerBeans != null ? topicBannerBeans.size() : 0;
    }

    class CircleHotViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_bg_url)
        RoundImageView mTvBgUrl;
        @BindView(R.id.tv_title)
        TextView mTvTitle;
        @BindView(R.id.tv_subtitle)
        TextView mTvSubtitle;

        public CircleHotViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
