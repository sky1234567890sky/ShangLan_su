package com.sport.sportproject.ui.fragment_data.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sport.sportproject.R;
import com.sport.sportproject.bean.bean.data.RankInfo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
 *   梨花带雨,我见优伶
 *      2019/5/15
 */
class RankItemEastAdapter extends RecyclerView.Adapter {
    private final Context context;
    private final List<RankInfo.ContentBeanX.RoundsBean.ContentBean.DataBean> pData;
    private final int lineNum;

    public RankItemEastAdapter(Context context, List<RankInfo.ContentBeanX.RoundsBean.ContentBean.DataBean> pData, int lineNum) {
        this.context = context;
        this.pData = pData;
        this.lineNum = lineNum;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FirstHolder(View.inflate(context, R.layout.rank_pk_east_layout, null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        FirstHolder holder1 = (FirstHolder) holder;
        Glide.with(context).load(pData.get(position).getTeam_A_logo()).into(holder1.leftTeamLogo);
        Glide.with(context).load(pData.get(position).getTeam_B_logo()).into(holder1.rightTeamLogo);
        holder1.rankNum.setText(pData.get(position).getTeam_A_rank()+"");
        holder1.rankNumRight.setText(pData.get(position).getTeam_B_rank()+"");
        if (TextUtils.isEmpty(pData.get(position).getTeam_A_name())){
            holder1.leftTeamName.setText("待定");
            holder1.leftTeamName.setBackgroundColor(ContextCompat.getColor(context,R.color.c_e7e7e7));
        } else {
            holder1.leftTeamName.setText(pData.get(position).getTeam_A_name());
            holder1.leftTeamName.setBackgroundColor(ContextCompat.getColor(context,R.color.c_e34536));
        }
        if (TextUtils.isEmpty(pData.get(position).getTeam_B_name())){
            holder1.rightTeamName.setText("待定");
            holder1.rightTeamName.setBackgroundColor(ContextCompat.getColor(context,R.color.c_e7e7e7));
        } else {
            holder1.rightTeamName.setText(pData.get(position).getTeam_B_name());
            holder1.rightTeamName.setBackgroundColor(ContextCompat.getColor(context,R.color.c_4782c4));
        }
        if (pData.get(position).getFs_A() == 0 && pData.get(position).getFs_B() == 0){
            if (lineNum == 4){
                holder1.vsText.setVisibility(View.VISIBLE);
            } else {
                holder1.vsText.setVisibility(View.GONE);
            }
            holder1.scoreText.setVisibility(View.GONE);
        } else {
            holder1.scoreText.setVisibility(View.VISIBLE);
            holder1.scoreText.setText(pData.get(position).getFs_A()+" : "+pData.get(position).getFs_B());
        }
    }

    @Override
    public int getItemCount() {
        return pData.size();
    }
    public class FirstHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.left_team_logo)
        ImageView leftTeamLogo;
        @BindView(R.id.rank_num)
        TextView rankNum;
        @BindView(R.id.left_team_name)
        TextView leftTeamName;
        @BindView(R.id.right_team_logo)
        ImageView rightTeamLogo;
        @BindView(R.id.rank_num_right)
        TextView rankNumRight;
        @BindView(R.id.right_team_name)
        TextView rightTeamName;
        @BindView(R.id.score_text)
        TextView scoreText;
        @BindView(R.id.vs_text)
        TextView vsText;
        public FirstHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
