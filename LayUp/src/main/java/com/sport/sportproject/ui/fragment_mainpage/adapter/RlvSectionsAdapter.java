package com.sport.sportproject.ui.fragment_mainpage.adapter;

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
import com.sport.sportproject.R;
import com.sport.sportproject.base.BaseApp;
import com.sport.sportproject.bean.bean.mainpage.SectionsBean;
import com.sport.sportproject.ui.WebViewActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
public class RlvSectionsAdapter extends RecyclerView.Adapter {
    private ArrayList<SectionsBean.DataBean> dataBeans;
    private Context context;
    public RlvSectionsAdapter(ArrayList<SectionsBean.DataBean> dataBeans) {
        this.dataBeans = dataBeans;
    }

    @SuppressLint("InflateParams")
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new RlvSectionsViewHolder(LayoutInflater.from(context).inflate(R.layout.item_sections, null));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        RlvSectionsViewHolder holder1 = (RlvSectionsViewHolder) holder;
        holder1.mTvTitle.setText(dataBeans.get(position).getTitle());
        holder1.mTvCommentsTotal.setText(dataBeans.get(position).getComments_total() + "评论");
        Glide.with(BaseApp.getInstance()).load(dataBeans.get(position).getLitpic()).into(holder1.mIvLitpic);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebViewActivity.go2Acitvity(context,dataBeans.get(position).getAid(),dataBeans.get(position).getComments_total());
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataBeans != null ? dataBeans.size() : 0;
    }

    class RlvSectionsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_litpic)
        ImageView mIvLitpic;
        @BindView(R.id.tv_title)
        TextView mTvTitle;
        @BindView(R.id.tv_comments_total)
        TextView mTvCommentsTotal;
        public RlvSectionsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
