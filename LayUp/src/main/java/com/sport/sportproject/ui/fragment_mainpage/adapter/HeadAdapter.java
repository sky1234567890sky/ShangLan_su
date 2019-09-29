package com.sport.sportproject.ui.fragment_mainpage.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sport.sportproject.R;
import com.sport.sportproject.bean.bean.mainpage.MainPageHotBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
public class HeadAdapter extends RecyclerView.Adapter{
    public final ArrayList<MainPageHotBean.ContentsBean> hotBeans;
    private Context context;

    public HeadAdapter(ArrayList<MainPageHotBean.ContentsBean> hotBeans) {
        this.hotBeans = hotBeans;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new HeadViewHolder(LayoutInflater.from(context).inflate(R.layout.item_rlv,null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HeadViewHolder holder1 = (HeadViewHolder) holder;
        holder1.mItenRlv.setLayoutManager(new LinearLayoutManager(context));
        MainPageHotAdapter hotadapter = new MainPageHotAdapter((ArrayList<MainPageHotBean.ContentsBean.ArticlesBean>) hotBeans.get(position).getArticles());
        holder1.mItenRlv.setAdapter(hotadapter);
    }

    @Override
    public int getItemCount() {
        return hotBeans !=null ? hotBeans.size() : 0;
    }
    class HeadViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_rlv)
        RecyclerView mItenRlv;
        public HeadViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
