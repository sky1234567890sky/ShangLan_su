package com.sport.sportproject.ui.fragment_circlezi.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sport.sportproject.R;
import com.sport.sportproject.ui.fragment_circlezi.bean.CircleTopicBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
class CircleTopicClickAdapter extends RecyclerView.Adapter {

    private static final int LINE_TWO = 755;
    private static final int LINE_FOUR = 925;

    private String type;
    private final List<CircleTopicBean.DataBean.TopicListBean.ListBean> list;

    public CircleTopicClickAdapter(String type, List<CircleTopicBean.DataBean.TopicListBean.ListBean> list) {
        this.type = type;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case LINE_TWO:
                return new CircleTopicLine_TwoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_linetwo, null));
            case LINE_FOUR:
                return new CircleTopicLine_FourViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_linefour, null));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case LINE_FOUR:
                CircleTopicLine_FourViewHolder holder2 = (CircleTopicLine_FourViewHolder) holder;
                holder2.mItemTvLinefour.setText(list.get(position).getContent());
                break;
            case LINE_TWO:
                CircleTopicLine_TwoViewHolder holder1 = (CircleTopicLine_TwoViewHolder) holder;
                holder1.mTvLinetwo.setText(list.get(position).getContent());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (type.equals("line_two")) {
            return LINE_TWO;
        } else {
            return LINE_FOUR;
        }

    }

    class CircleTopicLine_TwoViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_linetwo)
        TextView mTvLinetwo;
        public CircleTopicLine_TwoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class CircleTopicLine_FourViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_tv_linefour)
        TextView mItemTvLinefour;

        public CircleTopicLine_FourViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
