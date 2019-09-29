package com.sport.sportproject.ui.fragment_data.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sport.sportproject.R;
import com.sport.sportproject.base.BaseApp;
import com.sport.sportproject.bean.bean.data.DataStandingBean;
import com.sport.sportproject.bean.bean.data.RankInfo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
 *   梨花带雨,我见优伶
 *      2019/5/10
 */
class Team_point_ranking extends RecyclerView.Adapter {
    private final List<RankInfo.ContentBeanX.RoundsBean.ContentBean.DataBean.DataBean2> datae;
    private Context context;

    public Team_point_ranking(List<RankInfo.ContentBeanX.RoundsBean.ContentBean.DataBean.DataBean2> datae) {
        this.datae = datae;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new TeamPointRankingViewHolder(LayoutInflater.from(context).inflate(R.layout.item_datarank_three_chick, null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TeamPointRankingViewHolder holder1 = (TeamPointRankingViewHolder) holder;
        if (position < 8) {
            holder1.mItemTvRank.setTextColor(ContextCompat.getColor(BaseApp.getInstance(), R.color.c_e34536));
            holder1.mLl.setBackgroundColor(ContextCompat.getColor(BaseApp.getInstance(),R.color.c_FEF3ED));
        }
        RankInfo.ContentBeanX.RoundsBean.ContentBean.DataBean.DataBean2 dataBeane = datae.get(position);
        holder1.mItemTvRank.setText(dataBeane.rank);
        if (dataBeane !=null);
        Glide.with(context).load(dataBeane.team_logo).into(holder1.mIvTeamLogo);
        holder1.mTvTeamName.setText(dataBeane.team_name);
        holder1.mItemTvVictoryOrDefeat.setText(dataBeane.win_lost);
        holder1.mItemTvWinRate.setText(dataBeane.win_rate);
        holder1.mItemTvMarginPoints.setText(dataBeane.gb);
        holder1.mItemTvIntegral.setText(dataBeane.streak);

    }

    @Override
    public int getItemCount() {
        return datae.size();
    }

    class TeamPointRankingViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_tv_rank)
        TextView mItemTvRank;
        @BindView(R.id.iv_team_logo)
        ImageView mIvTeamLogo;
        @BindView(R.id.tv_team_name)
        TextView mTvTeamName;
        @BindView(R.id.item_tv_victory_or_defeat)
        TextView mItemTvVictoryOrDefeat;
        @BindView(R.id.item_tv_win_rate)
        TextView mItemTvWinRate;
        @BindView(R.id.item_tv_Margin_points)
        TextView mItemTvMarginPoints;
        @BindView(R.id.item_tv_integral)
        TextView mItemTvIntegral;
        @BindView(R.id.ll)
        LinearLayout mLl;
        public TeamPointRankingViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
