package com.sport.sportproject.ui.fragment_mainpage.adapter;

import android.annotation.SuppressLint;
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
import com.sport.sportproject.bean.bean.mainpage.MainPageLiveBean;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;
public class CctvRlvAdapter extends RecyclerView.Adapter {
    private final ArrayList<MainPageLiveBean> liveBeans;
    public CctvRlvAdapter(ArrayList<MainPageLiveBean> liveBeans) {
        this.liveBeans = liveBeans;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CctvViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cctvlive,null));
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CctvViewHolder holder1 = (CctvViewHolder) holder;
        MainPageLiveBean bean = liveBeans.get(position);
        holder1.mTvNbajihou.setText(bean.getMatch_title());

        Glide.with(BaseApp.getInstance()).load(bean.getTeam_B_logo()).into(holder1.mImg2);
        Glide.with(BaseApp.getInstance()).load(bean.getTeam_A_logo()).into(holder1.mImg1);

        if (!bean.getPlayoff_fs_A().equals("") || !bean.getPlayoff_fs_B().equals("")) {
            holder1.mTvName1.setText(bean.getTeam_A_name() + "("+ bean.getPlayoff_fs_A() + ")");
            holder1.mTvName2.setText(bean.getTeam_B_name() + "(" + bean.getPlayoff_fs_B() + ")");
        } else {
            holder1.mTvName1.setText(bean.getTeam_A_name());
            holder1.mTvName2.setText(bean.getTeam_B_name());
        }

        if (!bean.getFs_A().equals("") || !bean.equals("")){
            holder1.left_result.setText(bean.getFs_A());
            holder1.right_result.setText(bean.getFs_B());
        }
//        if (bean.getStatus().equals("Played")) {
//            holder1.mTvStart.setText("已结束");
//            holder1.mTvStart.setTextColor(BaseApp.getInstance().getResources().getColor(R.color.c_8a8a8a));
//        } else if (bean.getStatus().equals("Playing")) {
//            holder1.mTvStart.setText("已开始");
//            holder1.mTvStart.setTextColor(BaseApp.getInstance().getResources().getColor(R.color.c_5c90ca));
//        } else if (bean.getStatus().equals("Fixture")) {
//            holder1.mTvStart.setText("未开始");
//        }
    }

    @Override
    public int getItemCount() {
        return liveBeans != null ? liveBeans.size() : 0;
    }

    class CctvViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_nbajihou)
        TextView mTvNbajihou;
        @BindView(R.id.img_1)
        ImageView mImg1;
        @BindView(R.id.tv_name1)
        TextView mTvName1;
        @BindView(R.id.img2)
        ImageView mImg2;
        @BindView(R.id.tv_name2)
        TextView mTvName2;
        @BindView(R.id.tv_day)
        TextView mTvDay;
        @BindView(R.id.tv_start)
        TextView mTvStart;
        @BindView(R.id.left_result)
        TextView left_result;
        @BindView(R.id.right_result)
        TextView right_result;

        public CctvViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

}
