package com.sport.sportproject.ui.fragment_match.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.sport.sportproject.R;
import com.sport.sportproject.ui.fragment_match.bean.LeagueBean;
import com.sport.sportproject.ui.fragment_match.bean.MatchName;
import java.util.List;

/**
 * Created by 华为 on 2019/7/7.
 */
public class LeagueAdapter extends RecyclerView.Adapter<LeagueAdapter.ItemViewHolder> {
    private Context context;
    private List<LeagueBean.ListBean> list;
    private List<MatchName.DataBean> data;
    public LeagueAdapter(LeagueBean leagueBean, List<MatchName.DataBean> matchDatabean) {
        this.list = leagueBean.getList();
        this.data = matchDatabean;
    }

    public void setData(List<MatchName.DataBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public LeagueAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.fragment_match_item2, null));
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull LeagueAdapter.ItemViewHolder holder, int position) {
        LeagueBean.ListBean listBean = list.get(position);
        if (!listBean.getPlayoff_fs_A().equals("") && !listBean.getPlayoff_fs_B().equals("")) {
            holder.leftTv.setText(listBean.getTeam_A_name() + "(" + listBean.getPlayoff_fs_A() + ")");
            holder.rightTv.setText(listBean.getTeam_B_name() + "(" + listBean.getPlayoff_fs_B() + ")");
        } else {
            holder.leftTv.setText(listBean.getTeam_A_name() + "(" + "-" + ")");
            holder.rightTv.setText(listBean.getTeam_B_name() + "(" + "-" + ")");
        }
        RequestOptions requestOptions = new RequestOptions().circleCrop();
        holder.contreTimeNbaMatch.setText("09:00  " + listBean.getCompetition_name() + listBean.getRound_name());
        Glide.with(context).load(listBean.getTeam_A_logo()).apply(requestOptions).into(holder.leftImg);
        Glide.with(context).load(listBean.getTeam_B_logo()).apply(requestOptions).into(holder.rightImg);
        holder.fsA.setText(listBean.getFs_A());
        holder.fsB.setText(listBean.getFs_B());
        //下面的头像跟名字
        if (data != null) {
            for (MatchName.DataBean dataBean : data) {
                holder.rightBottomFenLanZhu.setText(dataBean.getSts_B().getTips());
                holder.rightBottomName.setText(dataBean.getSts_B().getName());
                holder.leftBottomName.setText(dataBean.getSts_A().getName());
                holder.leftBottomFenLanZhu.setText(dataBean.getSts_A().getTips());
                Glide.with(context).load(dataBean.getSts_A().getLogo()).apply(requestOptions).into(holder.leftHeadlerBottomImg);
                Glide.with(context).load(dataBean.getSts_B().getLogo()).apply(requestOptions).into(holder.rightHeadlerBottomImg);
            }
        }
    }

    @Override
    public int getItemCount() {
        if (data != null) return data.size();
        else
            return list != null ? list.size() : 0;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView leftImg;
        private TextView leftTv;
        private ImageView rightImg;
        private TextView rightTv;
        private TextView contreTimeNbaMatch;
        private TextView fsA;
        private TextView fsB;

        private ImageView leftHeadlerBottomImg;
        private TextView leftBottomName;
        private TextView leftBottomFenLanZhu;
        private ImageView rightHeadlerBottomImg;
        private TextView rightBottomName;
        private TextView rightBottomFenLanZhu;

        public ItemViewHolder(View itemView) {
            super(itemView);
            leftImg = (ImageView) itemView.findViewById(R.id.left_img);
            leftTv = (TextView) itemView.findViewById(R.id.left_tv);
            rightImg = (ImageView) itemView.findViewById(R.id.right_img);
            rightTv = (TextView) itemView.findViewById(R.id.right_tv);
            contreTimeNbaMatch = (TextView) itemView.findViewById(R.id.contre_time_nba_match);
            fsA = (TextView) itemView.findViewById(R.id.fs_a);
            fsB = (TextView) itemView.findViewById(R.id.fs_b);

            leftHeadlerBottomImg = (ImageView) itemView.findViewById(R.id.left_headler_bottom_img);
            leftBottomName = (TextView) itemView.findViewById(R.id.left_bottom_name);
            leftBottomFenLanZhu = (TextView) itemView.findViewById(R.id.left_bottom_fen_lan_zhu);
            rightHeadlerBottomImg = (ImageView) itemView.findViewById(R.id.right_headler_bottom_img);
            rightBottomName = (TextView) itemView.findViewById(R.id.right_bottom_name);
            rightBottomFenLanZhu = (TextView) itemView.findViewById(R.id.right_bottom_fen_lan_zhu);

//            matchGather = (ImageView) itemView.findViewById(R.id.match_gather);
        }
    }
}
