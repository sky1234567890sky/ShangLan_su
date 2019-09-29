package com.sport.sportproject.ui.fragment_data.adapter;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sport.sportproject.R;
import com.sport.sportproject.base.BaseApp;
import com.sport.sportproject.bean.bean.data.DataScheduleBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
 *   梨花带雨,我见优伶
 *      2019/4/29
 */
public class RlvDataRankAdapter extends RecyclerView.Adapter {

    public ArrayList<DataScheduleBean.ContentBean.MatchesBean> matchesBeans;

    public RlvDataRankAdapter(ArrayList<DataScheduleBean.ContentBean.MatchesBean> matchesBeans) {

        this.matchesBeans = matchesBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RlvDataRankViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data_rank, null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RlvDataRankViewHolder holder1 = (RlvDataRankViewHolder) holder;
        DataScheduleBean.ContentBean.MatchesBean matchesBean = matchesBeans.get(position);

        holder1.mTvTeamAName.setText(matchesBean.getTeam_A_name());
        Glide.with(BaseApp.getInstance()).load(matchesBean.getTeam_A_logo()).into(holder1.mTvTeamALogo);
        holder1.mTvTeamBName.setText(matchesBean.getTeam_B_name());
        Glide.with(BaseApp.getInstance()).load(matchesBean.getTeam_B_logo()).into(holder1.mIvTeamBLogo);
        if (matchesBean.getStatus().equals("Played") || matchesBean.getStatus().equals("Fixture")) {
            holder1.mTvStartPlay.setText(matchesBean.getStart_play());
        } else if (matchesBean.getStatus().equals("Playing")) {
            holder1.mTvStartPlay.setText("进行中");
            holder1.mTvStartPlay.setTextColor(ContextCompat.getColor(BaseApp.getInstance(), R.color.c_e34536));
            holder1.mTvFsaFsb.setTextColor(ContextCompat.getColor(BaseApp.getInstance(), R.color.c_e34536));
        }
        if (matchesBean.getStatus().equals("Fixture")) {
            holder1.mTvFsaFsb.setText(R.string.vs);
        } else {
            holder1.mTvFsaFsb.setText(matchesBean.getFs_A() + " : "+ matchesBean.getFs_B());
        }
    }

    @Override
    public int getItemCount() {
        return matchesBeans != null ? matchesBeans.size() : 0;
    }

    class RlvDataRankViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_start_play)
        TextView mTvStartPlay;
        @BindView(R.id.tv_team_a_name)
        TextView mTvTeamAName;
        @BindView(R.id.tv_team_a_logo)
        ImageView mTvTeamALogo;
        @BindView(R.id.tv_fsa_fsb)
        TextView mTvFsaFsb;
        @BindView(R.id.iv_team_b_logo)
        ImageView mIvTeamBLogo;
        @BindView(R.id.tv_team_b_name)
        TextView mTvTeamBName;

        public RlvDataRankViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
