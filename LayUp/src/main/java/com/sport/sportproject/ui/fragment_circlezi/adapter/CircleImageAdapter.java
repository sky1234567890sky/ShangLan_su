package com.sport.sportproject.ui.fragment_circlezi.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.sport.sportproject.R;
import com.sport.sportproject.base.BaseApp;
import com.sport.sportproject.ui.fragment_circlezi.bean.CircleNormalBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CircleImageAdapter extends RecyclerView.Adapter {
    private final List<CircleNormalBean.DataBean.FeedsListBean.AttachmentsBean> attachments;

    public CircleImageAdapter(List<CircleNormalBean.DataBean.FeedsListBean.AttachmentsBean> attachments) {
        this.attachments = attachments;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflater;
        if (attachments.size() == 1) {
            inflater = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_circle_image, null);
            return new CircleImageViewHolder(inflater);
        } else if (attachments.size() == 2 || attachments.size() == 4) {
            inflater = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_circle_image1, null);
            return new CircleImageViewHolder(inflater);
        } else  {
            inflater = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_circle_image2, null);
            return new CircleImageViewHolder(inflater);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CircleImageViewHolder holder1 = (CircleImageViewHolder) holder;
        if (attachments != null) {
            CircleNormalBean.DataBean.FeedsListBean.AttachmentsBean attachmentsBean = attachments.get(position);
            Glide.with(BaseApp.getInstance()).asBitmap().load(attachmentsBean.getUrl()).into(holder1.mIvCircleThumb);
        }
    }

    @Override
    public int getItemCount() {
        return attachments != null ? attachments.size() : 0;
    }


    class CircleImageViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_circle_thumb)
        ImageView mIvCircleThumb;

        public CircleImageViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
