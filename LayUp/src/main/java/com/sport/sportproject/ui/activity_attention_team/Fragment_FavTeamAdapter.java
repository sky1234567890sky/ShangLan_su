package com.sport.sportproject.ui.activity_attention_team;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sport.sportproject.R;
import com.sport.sportproject.base.BaseApp;
import com.sport.sportproject.bean.bean.team.FavTeamBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
 *   梨花带雨,我见优伶
 *      2019/4/19
 */
public class Fragment_FavTeamAdapter extends RecyclerView.Adapter {

    private final ArrayList<String> isFirst;
    private final ArrayList<FavTeamBean> favTeamEntities;
    private ArrayList<String> strings;
    private OnItemClickListener mListener;
    private boolean isClick = true;

    public Fragment_FavTeamAdapter(ArrayList<String> isFirst, ArrayList<FavTeamBean> listBeans, ArrayList<String> strings) {
        this.isFirst = isFirst;
        this.favTeamEntities = listBeans;
        this.strings = strings;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Fragment_FavTeamViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_favteam, null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        final Fragment_FavTeamViewHolder holder1 = (Fragment_FavTeamViewHolder) holder;
        holder1.mItemName.setText(favTeamEntities.get(position).getShort_name());
        Glide.with(BaseApp.getInstance()).load(favTeamEntities.get(position).getLogo()).into(holder1.mItemLogo);

        if (isFirst != null && isFirst.size() >0) {
            if (isFirst.contains(favTeamEntities.get(position).getId())) {
                holder1.mRl.setBackgroundResource(R.drawable.team_select_bg);
                holder1.mIvIcon.setVisibility(View.VISIBLE);
            } else {
                holder1.mRl.setBackgroundResource(R.drawable.team_unselect_bg);
                holder1.mIvIcon.setVisibility(View.INVISIBLE);
            }
        } else {
            if (strings.contains(favTeamEntities.get(position).getId())) {
                holder1.mRl.setBackgroundResource(R.drawable.team_select_bg);
                holder1.mIvIcon.setVisibility(View.VISIBLE);
            } else {
                holder1.mRl.setBackgroundResource(R.drawable.team_unselect_bg);
                holder1.mIvIcon.setVisibility(View.INVISIBLE);
            }
        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.OnItemClick(v, position);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return favTeamEntities != null ? favTeamEntities.size() : 0;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    public interface OnItemClickListener {
        void OnItemClick(View v, int position);
    }

    class Fragment_FavTeamViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_logo)
        ImageView mItemLogo;
        @BindView(R.id.item_name)
        TextView mItemName;
        @BindView(R.id.rl)
        RelativeLayout mRl;
        @BindView(R.id.iv_icom_gift_check)
        ImageView mIvIcon;

        public Fragment_FavTeamViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
