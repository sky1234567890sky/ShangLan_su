package com.sport.sportproject.ui.fragment_data.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sport.sportproject.R;
import com.sport.sportproject.bean.bean.data.RankInfo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
 *   梨花带雨,我见优伶
 *      2019/5/10
 */
class Team_Point_Ranking_Group extends RecyclerView.Adapter {

    private final List<RankInfo.ContentBeanX.RoundsBean.ContentBean.DataBean> data1;
    private Context context;

    public Team_Point_Ranking_Group(List<RankInfo.ContentBeanX.RoundsBean.ContentBean.DataBean> data1) {
        this.data1 = data1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new Team_Point_Ranking_GroupViewHolde(LayoutInflater.from(context).inflate(R.layout.item_datarank_three, null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Team_Point_Ranking_GroupViewHolde holde = (Team_Point_Ranking_GroupViewHolde) holder;
        List<RankInfo.ContentBeanX.RoundsBean.ContentBean.DataBean.DataBean2> datae = data1.get(position).data;
        holde.mItemTvName.setText(data1.get(position).name);
        holde.mItemTvVictoryOrDefeat.setText(data1.get(position).header.get(0));
        holde.mItemTvWinRate.setText(data1.get(position).header.get(1));
        holde.mItemTvMarginPoints.setText(data1.get(position).header.get(2));
        holde.mItemTvIntegral.setText(data1.get(position).header.get(3));
        holde.mItemRlv.setLayoutManager(new LinearLayoutManager(context));
        Team_point_ranking team_point_ranking = new Team_point_ranking(datae);
        holde.mItemRlv.setAdapter(team_point_ranking);
        holde.mItemRlv.addItemDecoration(new DividerItemDecoration(context,DividerItemDecoration.VERTICAL));
    }

    @Override
    public int getItemCount() {
        return data1.size();
    }

    class Team_Point_Ranking_GroupViewHolde extends RecyclerView.ViewHolder {
        @BindView(R.id.item_tv_name)
        TextView mItemTvName;
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
        @BindView(R.id.item_rlv)
        RecyclerView mItemRlv;
        public Team_Point_Ranking_GroupViewHolde(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
