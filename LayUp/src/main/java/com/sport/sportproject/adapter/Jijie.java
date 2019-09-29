package com.sport.sportproject.adapter;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sport.sportproject.R;
import com.sport.sportproject.adapter.bean.JijieBean;
import com.sport.sportproject.base.BaseApp;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
public class Jijie extends RecyclerView.Adapter {
    public ArrayList<JijieBean.ArticlesBean> articlesBeans;

    public Jijie(ArrayList<JijieBean.ArticlesBean> articlesBeans) {
        this.articlesBeans = articlesBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new JijieViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_jijie, null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        JijieViewHolder holder1 = (JijieViewHolder) holder;
        if (articlesBeans != null) {
            JijieBean.ArticlesBean articlesBean = articlesBeans.get(position);
            if (articlesBean.getThumb() != null) {
                Glide.with(BaseApp.getInstance()).load(articlesBean.getThumb()).into(holder1.mIvThumb);
            } else {
                holder1.mIvThumb.setImageResource(R.color.c_8a8a8a);
            }
            holder1.mTvTitle.setText(articlesBean.getTitle());
            if (articlesBean.getComments_total() == 0) {
                holder1.mTvCommentsTotal.setVisibility(View.GONE);
            } else {
                holder1.mTvCommentsTotal.setText(articlesBean.getComments_total() + R.string.comments);
            }
        }
    }

    @Override
    public int getItemCount() {
        return articlesBeans != null ? articlesBeans.size() : 0;
    }

    class JijieViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_thumb)
        ImageView mIvThumb;
        @BindView(R.id.tv_title)
        TextView mTvTitle;
        @BindView(R.id.tv_comments_total)
        TextView mTvCommentsTotal;

        public JijieViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
