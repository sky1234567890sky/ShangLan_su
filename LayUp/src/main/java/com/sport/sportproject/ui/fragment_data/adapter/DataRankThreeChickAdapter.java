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
import com.sport.sportproject.bean.bean.data.DataRankThreeBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
 *   梨花带雨,我见优伶
 *      2019/5/7
 */
class DataRankThreeChickAdapter extends RecyclerView.Adapter<DataRankThreeChickAdapter.DataRankThreeChickViewHolder> {


    private final List<DataRankThreeBean.ContentBeanX.RoundsBean.ContentBean.DataBeanX.DataBean> data;

    public DataRankThreeChickAdapter(List<DataRankThreeBean.ContentBeanX.RoundsBean.ContentBean.DataBeanX.DataBean> data) {

        this.data = data;
    }

    @NonNull
    @Override
    public DataRankThreeChickAdapter.DataRankThreeChickViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DataRankThreeChickViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_datarank_three_chick, null));
    }

    @Override
    public void onBindViewHolder(@NonNull DataRankThreeChickAdapter.DataRankThreeChickViewHolder holder, int position) {
        if (data != null) ;
        DataRankThreeBean.ContentBeanX.RoundsBean.ContentBean.DataBeanX.DataBean dataBean = data.get(position);
        holder.mItemTvRank.setText(dataBean != null ? dataBean.getRank() : "0");
        Glide.with(BaseApp.getInstance()).load(dataBean.getTeam_logo()).into(holder.mIvTeamLogo);
        holder.mTvTeamName.setText(dataBean != null ? dataBean.getTeam_name() : " - ");
        holder.mItemTvVictoryOrDefeat.setText(dataBean != null ? dataBean.getWin_lost() : " - ");
        holder.mItemTvWinRate.setText(dataBean != null ? dataBean.getWin_rate() : "0%");
        holder.mItemTvMarginPoints.setText(dataBean != null ? dataBean.getGb() : " - ");
        holder.mItemTvIntegral.setText(dataBean != null ? dataBean.getStreak() : " 0 ");

    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    class DataRankThreeChickViewHolder extends RecyclerView.ViewHolder {
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

        public DataRankThreeChickViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
