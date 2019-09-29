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
import com.sport.sportproject.bean.bean.data.DataTeamBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
 *   梨花带雨,我见优伶
 *      2019/5/4
 */
public class RlvTeamAdapter extends RecyclerView.Adapter {
    private final ArrayList<DataTeamBean.ContentBean.DataBean> teamBeans;

    public RlvTeamAdapter(ArrayList<DataTeamBean.ContentBean.DataBean> teamBeans) {
        this.teamBeans = teamBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RlvTeamViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_team, null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        RlvTeamViewHolder holder1 = (RlvTeamViewHolder) holder;
        DataTeamBean.ContentBean.DataBean dataBean = teamBeans.get(position);
        holder1.mTvRank.setText(dataBean.getRank());
        holder1.mTvTeamName.setText(dataBean.getTeam_name());
        Glide.with(BaseApp.getInstance()).load(dataBean.getTeam_logo()).into(holder1.mIvPersonLogo);
        holder1.mTvValue.setText(dataBean.getValue());
    }

    @Override
    public int getItemCount() {
        return teamBeans != null ? teamBeans.size() : 0;
    }

    class RlvTeamViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_rank)
        TextView mTvRank;
        @BindView(R.id.iv_team_logo)
        ImageView mIvPersonLogo;
        @BindView(R.id.tv_value)
        TextView mTvValue;
        @BindView(R.id.tv_team_name)
        TextView mTvTeamName;

        public RlvTeamViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

}
