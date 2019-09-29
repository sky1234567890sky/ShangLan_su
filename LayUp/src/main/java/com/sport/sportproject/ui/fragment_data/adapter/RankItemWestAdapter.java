package com.sport.sportproject.ui.fragment_data.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sport.sportproject.R;
import com.sport.sportproject.bean.bean.data.RankInfo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.scwang.smartrefresh.layout.util.DensityUtil.dp2px;

/*
 *   梨花带雨,我见优伶
 *      2019/5/15
 */
class RankItemWestAdapter extends RecyclerView.Adapter {
    private final Context context;
    private final List<RankInfo.ContentBeanX.RoundsBean.ContentBean.DataBean> pData;
    private final int lineNum;

    public RankItemWestAdapter(Context context, List<RankInfo.ContentBeanX.RoundsBean.ContentBean.DataBean> pData, int lineNum) {
        this.context = context;
        this.pData = pData;
        this.lineNum = lineNum;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FirstHolder(View.inflate(context, R.layout.rank_pk_west_layout, null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        FirstHolder holder1 = (FirstHolder) holder;
        controlCenterLine(holder1);
        Glide.with(context).load(pData.get(position).getTeam_A_logo()).into(holder1.leftTeamLogo);
        Glide.with(context).load(pData.get(position).getTeam_B_logo()).into(holder1.rightTeamLogo);
        holder1.rankNumLeft.setText(pData.get(position).getTeam_A_rank()+"");
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
            holder1.rightTeamName.setBackgroundColor(ContextCompat.getColor(context,R.color.c_e34536));
        }
        if (pData.get(position).getFs_A() == 0 && pData.get(position).getFs_B() == 0){
            if (lineNum == 2 || lineNum == 3){
                holder1.vsText.setVisibility(View.VISIBLE);
                if (lineNum == 3){
                    holder1.vsText.setTextSize(dp2px(12));
                }
            } else {
                holder1.vsText.setVisibility(View.GONE);
            }
            holder1.resultScore.setVisibility(View.GONE);
        } else {
            holder1.resultScore.setVisibility(View.VISIBLE);
            holder1.resultScore.setText(pData.get(position).getFs_A()+" : "+pData.get(position).getFs_B());
        }
    }
    private void controlCenterLine(FirstHolder holder) {
        if (lineNum != 3) {
            holder.leftVerticalLine.setVisibility(View.VISIBLE);
            holder.rightVerticalLine.setVisibility(View.VISIBLE);
            holder.rightBottomLine.setVisibility(View.VISIBLE);
            holder.bottomVerticalLine.setVisibility(View.VISIBLE);
        } else {
            holder.leftVerticalLine.setVisibility(View.GONE);
            holder.rightVerticalLine.setVisibility(View.GONE);
            holder.rightBottomLine.setVisibility(View.GONE);
            holder.bottomVerticalLine.setVisibility(View.GONE);
        }
    }
    @Override
    public int getItemCount() {
        return pData.size();
    }
    public class FirstHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.result_score)
        TextView resultScore;
        @BindView(R.id.left_team_logo)
        ImageView leftTeamLogo;
        @BindView(R.id.rank_num_left)
        TextView rankNumLeft;
        @BindView(R.id.left_team_name)
        TextView leftTeamName;
        @BindView(R.id.left_vertical_line)
        View leftVerticalLine;
        @BindView(R.id.right_team_logo)
        ImageView rightTeamLogo;
        @BindView(R.id.rank_num_right)
        TextView rankNumRight;
        @BindView(R.id.right_team_name)
        TextView rightTeamName;
        @BindView(R.id.right_vertical_line)
        View rightVerticalLine;
        @BindView(R.id.right_bottom_line)
        View rightBottomLine;
        @BindView(R.id.vs_text)
        TextView vsText;
        @BindView(R.id.bottom_vertical_line)
        View bottomVerticalLine;
        @BindView(R.id.father_rl)
        RelativeLayout fatherRl;

        public FirstHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
