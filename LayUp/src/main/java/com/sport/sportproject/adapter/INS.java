package com.sport.sportproject.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.sport.sportproject.R;
import com.sport.sportproject.adapter.bean.INSBean;
import com.sport.sportproject.base.BaseApp;
import com.sport.sportproject.utils.TimeChangeUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
public class INS extends RecyclerView.Adapter {

    public ArrayList<INSBean.FeedlistBean> insBeans;

    public INS(ArrayList<INSBean.FeedlistBean> insBeans) {
        this.insBeans = insBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new INSViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ins, null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        INSViewHolder holder1 = (INSViewHolder) holder;
        INSBean.FeedlistBean feedlistBean = insBeans.get(position);
        if (feedlistBean != null) {
            if (feedlistBean.getRelate_ico() != null && feedlistBean.getRelate_ico().length() == 0) {
                Glide.with(BaseApp.getInstance()).load(feedlistBean.getAvatar()).into(holder1.mIvAvatar);
            } else {
                holder1.mIvAvatar.setImageResource(R.drawable.img_weixiao);
            }
            holder1.mTvAccount.setText(feedlistBean.getAccount());
            holder1.mTvNote.setText(feedlistBean.getNote());
            holder1.mTvOriginalText.setText(feedlistBean.getOriginal_text());
            holder1.mTvtime.setText(TimeChangeUtils.CalculateTime(feedlistBean.getPublished_at()));
            holder1.mTvTranslationText.setText("[" + feedlistBean.getTranslation_text() + "]");
            if (feedlistBean.getAlbum().getPics().get(0).getUrl() != null) {
                RequestOptions options = new RequestOptions()
                        .transform(new RoundedCorners(10));
                Glide.with(BaseApp.getInstance()).load(feedlistBean.getAlbum().getPics().get(0).getUrl()).apply(options).into(holder1.mIvUrl);
            } else {
                holder1.mIvUrl.setImageResource(R.color.c_8a8a8a);
            }
            if (feedlistBean.getComments_total() == 0) {
                holder1.mTvCommentsTotal.setVisibility(View.GONE);
            } else {
                holder1.mTvCommentsTotal.setText(feedlistBean.getComments_total() + "评论");
            }
        }

    }

    @Override
    public int getItemCount() {
        return insBeans != null ? insBeans.size() : 0;
    }

    class INSViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_time)
        TextView mTvtime;
        @BindView(R.id.iv_avatar)
        ImageView mIvAvatar;
        @BindView(R.id.tv_account)
        TextView mTvAccount;
        @BindView(R.id.tv_note)
        TextView mTvNote;
        @BindView(R.id.tv_original_text)
        TextView mTvOriginalText;
        @BindView(R.id.tv_translation_text)
        TextView mTvTranslationText;
        @BindView(R.id.iv_url)
        ImageView mIvUrl;
        @BindView(R.id.tv_comments_total)
        TextView mTvCommentsTotal;
        @BindView(R.id.rl)
        RelativeLayout mRl;

        public INSViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
