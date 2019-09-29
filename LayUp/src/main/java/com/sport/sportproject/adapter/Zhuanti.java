package com.sport.sportproject.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sport.sportproject.R;
import com.sport.sportproject.adapter.bean.ZhuantiBean;
import com.sport.sportproject.base.BaseApp;
import com.sport.sportproject.ui.fragment_mainpage.activity.SectionsActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
public class Zhuanti extends RecyclerView.Adapter {
    public ArrayList<ZhuantiBean.ArticlesBean> articlesBeans;
    private Context context;
    public Zhuanti(ArrayList<ZhuantiBean.ArticlesBean> articlesBeans) {
        this.articlesBeans = articlesBeans;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new ZhuanTiViewHolder(LayoutInflater.from(context).inflate(R.layout.item_zhuanti, null));
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if (articlesBeans != null && articlesBeans.size() > 0) {
            ZhuanTiViewHolder holder1 = (ZhuanTiViewHolder) holder;
            holder1.mTvTitle.setText(articlesBeans.get(position).getTitle());
            Glide.with(BaseApp.getInstance()).load(articlesBeans.get(position).getThumb()).into(holder1.mIvThumb);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SectionsActivity.go2Activity(context,articlesBeans.get(position).getId());
            }
        });
    }
    @Override
    public int getItemCount() {
        return articlesBeans != null ? articlesBeans.size() : 0;
    }
    class ZhuanTiViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_thumb)
        ImageView mIvThumb;
        @BindView(R.id.tv_title)
        TextView mTvTitle;

        public ZhuanTiViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

}
