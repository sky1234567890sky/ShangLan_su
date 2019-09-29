package com.sport.sportproject.ui.fragment_data.adapter;

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
import com.sport.sportproject.bean.bean.data.DataPlayerBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
 *   梨花带雨,我见优伶
 *      2019/5/4
 */
public class RlvPlayerAdapter extends RecyclerView.Adapter {

    private final ArrayList<DataPlayerBean.ContentBean.DataBean> dataBeans;

    public RlvPlayerAdapter(ArrayList<DataPlayerBean.ContentBean.DataBean> dataBeans) {
        this.dataBeans = dataBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RlvPlayerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_player, null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RlvPlayerViewHolder holder1 = (RlvPlayerViewHolder) holder;
        DataPlayerBean.ContentBean.DataBean dataBean = dataBeans.get(position);
        holder1.mTvRank.setText(dataBean.getRank());
        Glide.with(BaseApp.getInstance()).load(dataBean.getPerson_logo()).into(holder1.mIvPersonLogo);
        holder1.mTvPersonName.setText(dataBean.getPerson_name());
        holder1.mTvTeamName.setText(dataBean.getTeam_name());
        holder1.mTvValue.setText(dataBean.getValue());

    }

    @Override
    public int getItemCount() {
        return dataBeans != null ? dataBeans.size() : 0;
    }

    class RlvPlayerViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_rank)
        TextView mTvRank;
        @BindView(R.id.iv_person_logo)
        ImageView mIvPersonLogo;
        @BindView(R.id.tv_person_name)
        TextView mTvPersonName;
        @BindView(R.id.tv_team_name)
        TextView mTvTeamName;
        @BindView(R.id.tv_value)
        TextView mTvValue;

        public RlvPlayerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
