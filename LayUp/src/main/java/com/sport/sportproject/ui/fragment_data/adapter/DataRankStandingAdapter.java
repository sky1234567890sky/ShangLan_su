package com.sport.sportproject.ui.fragment_data.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sport.sportproject.R;
import com.sport.sportproject.bean.bean.data.DataStandingBean;
import com.sport.sportproject.bean.bean.data.RankInfo;
import com.sport.sportproject.weight.DataInnerPresenter;
import com.sport.sportproject.weight.TempRankInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
 *  排名  比赛
 */
public class DataRankStandingAdapter extends RecyclerView.Adapter {
    // team_point_ranking_knockout 球队比赛
    private static final int TEAM_POINT_RANKING_KNOCKOUT = 630;
    // team_point_ranking_group 球队排名
    private static final int TEAM_POINT_RANKING_GROUP = 215;

    private final ArrayList<RankInfo.ContentBeanX.RoundsBean> dataStandingBeans;
    private LayoutInflater inflater;
    private Context context;
    private DataInnerPresenter dataInnerPresenter;
    private RankAdapter mAdapter;

    public DataRankStandingAdapter(ArrayList<RankInfo.ContentBeanX.RoundsBean> dataStandingBeans) {
        this.dataStandingBeans = dataStandingBeans;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        inflater = LayoutInflater.from(context);
        if (viewType == TEAM_POINT_RANKING_KNOCKOUT) {
            return new DataRankMatchViewHolder(inflater.inflate(R.layout.item_data_rankmatch, null));
        } else {
            return new DataRankTeamViewHolder(inflater.inflate(R.layout.item_data_rankteam, null));
        }
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            // 比赛排名
            case TEAM_POINT_RANKING_KNOCKOUT:
                if (dataInnerPresenter == null) {
                    dataInnerPresenter = new DataInnerPresenter();
                }

                List<TempRankInfo> rankList = dataInnerPresenter.getRankList(dataStandingBeans.get(0));
                DataRankMatchViewHolder holder1 = (DataRankMatchViewHolder) holder;
                holder1.mItemRecyclerRankMatch.setLayoutManager(new LinearLayoutManager(context));
                mAdapter = new RankAdapter(context, rankList);
                holder1. mItemRecyclerRankMatch.setAdapter(mAdapter);
                break;
            // 球队排名
            case TEAM_POINT_RANKING_GROUP:
                List<RankInfo.ContentBeanX.RoundsBean.ContentBean.DataBean> datae = dataStandingBeans.get(1).getContent().getData();
                DataRankTeamViewHolder holder2 = (DataRankTeamViewHolder) holder;
                holder2.mItemRecyclerRankTeam.setLayoutManager(new LinearLayoutManager(context));
                Team_Point_Ranking_Group team_point_ranking_group = new Team_Point_Ranking_Group(datae);
                holder2.mItemRecyclerRankTeam.setAdapter(team_point_ranking_group);
                team_point_ranking_group.notifyDataSetChanged();
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        // team_point_ranking_knockout 球队比赛
        if (dataStandingBeans.get(position).getTemplate().equals("team_point_ranking_knockout")) {
            return TEAM_POINT_RANKING_KNOCKOUT;
        } else {
            return TEAM_POINT_RANKING_GROUP;
        }
    }

    @Override
    public int getItemCount() {
        return dataStandingBeans != null ? dataStandingBeans.size() : 0;
    }

    class DataRankMatchViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_recycler_rank_match)
        RecyclerView mItemRecyclerRankMatch;
        public DataRankMatchViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class DataRankTeamViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_recycler_rank_team)
        RecyclerView mItemRecyclerRankTeam;
        public DataRankTeamViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
