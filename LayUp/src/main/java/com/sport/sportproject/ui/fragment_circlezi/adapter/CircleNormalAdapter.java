package com.sport.sportproject.ui.fragment_circlezi.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.sport.sportproject.R;
import com.sport.sportproject.base.BaseApp;
import com.sport.sportproject.ui.fragment_circlezi.bean.CircleNormalBean;
import com.sport.sportproject.utils.CircleImageView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
public class CircleNormalAdapter extends RecyclerView.Adapter {
    private static final int TYPE_VIDEO = 445;
    private static final int TYPE_IMAGE = 385;
    public final ArrayList<CircleNormalBean.DataBean.FeedsListBean> dataBeans;
    private Context context;
    public CircleNormalAdapter(ArrayList<CircleNormalBean.DataBean.FeedsListBean> dataBeans) {
        this.dataBeans = dataBeans;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case TYPE_VIDEO:
                return new CircleNormalVideoViewHolder(inflater.inflate(R.layout.item_circle_recommend_video, null));
            case TYPE_IMAGE:
                return new CircleNormalImageViewHolder(inflater.inflate(R.layout.item_circle_recommend_image, null));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        BindSelectViewHolder(holder, position);

    }

    @Override
    public int getItemViewType(int position) {
        CircleNormalBean.DataBean.FeedsListBean feedsListBean = dataBeans.get(position);
        if (feedsListBean.getVideo_info() != null) {
            return TYPE_VIDEO;
        } else {
            return TYPE_IMAGE;
        }
    }

    @Override
    public int getItemCount() {
        return dataBeans != null ? dataBeans.size() : 0;
    }

    @SuppressLint("SetTextI18n")
    private void BindSelectViewHolder(RecyclerView.ViewHolder holder, int position) {
        CircleNormalBean.DataBean.FeedsListBean feedsListBean = dataBeans.get(position);
        RequestOptions options = new RequestOptions()
                .centerCrop();
        switch (getItemViewType(position)) {
            case TYPE_VIDEO:
                CircleNormalVideoViewHolder holder1 = (CircleNormalVideoViewHolder) holder;
                if (feedsListBean != null) {
                    Glide.with(BaseApp.getInstance()).load(feedsListBean.getAuthor().getAvatar()).apply(options).into(holder1.mHeader);
                    holder1.mUser.setText(feedsListBean.getAuthor().getUsername());
                    holder1.mTime.setText(feedsListBean.getCreated_at() + "");
                    holder1.mTitle.setText(feedsListBean.getContent());
                    holder1.mTvLikeNum.setText(feedsListBean.getLike_num() + "");
                    holder1.mTvCommentsNum.setText(feedsListBean.getComment_num() + "");

                    String heights = feedsListBean.getVideo_info().getHeight();
                    int height = Integer.parseInt(heights);
                    String widths = feedsListBean.getVideo_info().getWidth();
                    int width = Integer.parseInt(widths);

                    DisplayMetrics displayMetrics = BaseApp.getInstance().getResources().getDisplayMetrics();
                    int widthPixels = displayMetrics.widthPixels;
                    int i;
                    if (widthPixels > 470 && width < 1600 && height > 850 || widthPixels < 210 && height > 350) {
                        i = widthPixels / 2 * height / width;
                    } else {
                        i = widthPixels * height / width;
                    }
                    ViewGroup.LayoutParams layoutParams = holder1.mJiecao.getLayoutParams();
                    layoutParams.height = i;
                    layoutParams.width = widthPixels;
                    holder1.mJiecao.setMinimumWidth(width);
                    holder1.mJiecao.setMinimumHeight(height);
                    holder1.mJiecao.setUp(feedsListBean.getVideo_info().getUrl(), null);
                    Glide.with(BaseApp.getInstance()).load(feedsListBean.getVideo_info().getThumb()).apply(options).into(holder1.mJiecao.ivThumb);
                }
                break;
            case TYPE_IMAGE:
                CircleNormalImageViewHolder holder2 = (CircleNormalImageViewHolder) holder;
                Glide.with(BaseApp.getInstance()).load(feedsListBean.getAuthor().getAvatar()).apply(options).into(holder2.mHeader);
                holder2.mUser.setText(feedsListBean.getAuthor().getUsername());
                holder2.mTitle.setText(feedsListBean.getContent());
                holder2.mTvLikeNum.setText(feedsListBean.getLike_num() + "");
                holder2.mTime.setText(feedsListBean.getCreated_at() + "");
                holder2.mTvComments.setText(feedsListBean.getComment_num() + "");
                if ( null != (feedsListBean.getTopic())) {
                    holder2.mTeam.setText(feedsListBean.getTopic().getContent());
                } else {
                    holder2.mTeam.setVisibility(View.GONE);
                }
                if (holder2.mRlvIv != null) {
                    if (feedsListBean.getAttachments() != null) {
                        if (feedsListBean.getAttachments().size() == 1) {
                            holder2.mRlvIv.setLayoutManager(new LinearLayoutManager(BaseApp.getInstance()));
                        } else if (feedsListBean.getAttachments().size() == 2 || feedsListBean.getAttachments().size() == 4) {
                            holder2.mRlvIv.setLayoutManager(new GridLayoutManager(BaseApp.getInstance(), 2));
                        } else if (feedsListBean.getAttachments().size() >= 3 || feedsListBean.getAttachments().size() % 3 == 0) {
                            holder2.mRlvIv.setLayoutManager(new GridLayoutManager(BaseApp.getInstance(), 3));
                        }
                        holder2.mRlvIv.setAdapter(new CircleImageAdapter(feedsListBean.getAttachments()));
                    } else {
                        holder2.mRlvIv.setVisibility(View.GONE);
                    }
                }
                break;
        }
    }
    class CircleNormalImageViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.header)
        ImageView mHeader;
        @BindView(R.id.user)
        TextView mUser;
        @BindView(R.id.attention)
        TextView mAttention;
        @BindView(R.id.time)
        TextView mTime;
        @BindView(R.id.title)
        TextView mTitle;
        @BindView(R.id.rlv_iv)
        RecyclerView mRlvIv;
        @BindView(R.id.team)
        TextView mTeam;
        @BindView(R.id.rl)
        RelativeLayout mRl;
        @BindView(R.id.share)
        LinearLayout mShare;
        @BindView(R.id.tv_comments)
        TextView mTvComments;
        @BindView(R.id.search)
        LinearLayout mSearch;
        @BindView(R.id.tv_like_num)
        TextView mTvLikeNum;
        @BindView(R.id.settings)
        LinearLayout mSettings;
        public CircleNormalImageViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class CircleNormalVideoViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.header)
        ImageView mHeader;
        @BindView(R.id.user)
        TextView mUser;
        @BindView(R.id.attention)
        TextView mAttention;
        @BindView(R.id.time)
        TextView mTime;
        @BindView(R.id.title)
        TextView mTitle;
        @BindView(R.id.jiecao)
        JCVideoPlayer mJiecao;
        @BindView(R.id.tv_like_num)
        TextView mTvLikeNum;
        @BindView(R.id.tv_comments)
        TextView mTvCommentsNum;

        public CircleNormalVideoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

}
