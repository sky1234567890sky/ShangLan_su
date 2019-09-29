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
import com.sport.sportproject.bean.bean.data.DataRankTwoBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
 *   梨花带雨,我见优伶
 *      2019/5/6
 */
public class DataRankTwoAdapter extends RecyclerView.Adapter {

    private final ArrayList<DataRankTwoBean.ContentBeanX.RoundsBean.ContentBean.DataBean> dataBeans;

    public DataRankTwoAdapter(ArrayList<DataRankTwoBean.ContentBeanX.RoundsBean.ContentBean.DataBean> dataBeans) {
        this.dataBeans = dataBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DataRankTwoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data_rank_two, null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        DataRankTwoViewHolder holder1 = (DataRankTwoViewHolder) holder;
        DataRankTwoBean.ContentBeanX.RoundsBean.ContentBean.DataBean dataBean = dataBeans.get(position);
        holder1.mTvRank.setText(dataBean.getRank());
        Glide.with(BaseApp.getInstance()).load(dataBean.getTeam_logo()).into(holder1.mIvTeamLogo);
        holder1.mTvTeamName.setText(dataBean.getTeam_name());
        holder1.mTvWinLost.setText(dataBean.getWin_lost());
        holder1.mTvWinRate.setText(dataBean.getWin_rate());
        holder1.mTvStreak.setText(dataBean.getStreak());
    }

    @Override
    public int getItemCount() {
        return dataBeans != null ? dataBeans.size() : 0;
    }


    class DataRankTwoViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_rank)
        TextView mTvRank;
        @BindView(R.id.iv_team_logo)
        ImageView mIvTeamLogo;
        @BindView(R.id.tv_team_name)
        TextView mTvTeamName;
        @BindView(R.id.tv_win_lost)
        TextView mTvWinLost;
        @BindView(R.id.tv_win_rate)
        TextView mTvWinRate;
        @BindView(R.id.tv_streak)
        TextView mTvStreak;

        public DataRankTwoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
