package com.sport.sportproject.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.sport.sportproject.R;
import com.sport.sportproject.base.BaseApp;
import com.sport.sportproject.bean.bean.mainpage.MainPageNewsBean;
import com.sport.sportproject.ui.WebViewActivity;
import com.sport.sportproject.utils.RoundImageView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/*
 *   梨花带雨,我见优伶  
 *      2019/4/21        
 */
public class China_BasketBall extends RecyclerView.Adapter {
    private static final int TYPE_TOP_TITLE_VIDEO = 189;
    private static final int TYPE_RIGHT_VIDEO = 333;
    private static final int TYPE_RIGHT_PHOTOS = 370;
    private static final int TYPE_PHOTOS_ARRAY = 315;

    public ArrayList<MainPageNewsBean.ArticlesBean> articlesBeans;
    private Context context;
    public China_BasketBall(ArrayList<MainPageNewsBean.ArticlesBean> articlesBeans) {
        this.articlesBeans = articlesBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            // 1.顶部标题,下面大视频
            case TYPE_TOP_TITLE_VIDEO:
                return new China_BasketBall_TopVideoViewHolder(inflater.inflate(R.layout.item_china_top_video, null));
            // 2.右边带有视频,左边标题
            case TYPE_RIGHT_VIDEO:
                return new China_BasketBall_RightVideoViewHolder(inflater.inflate(R.layout.item_china_right_video, null));
            // 3.右边带有图片,左边图片
            case TYPE_RIGHT_PHOTOS:
                return new China_BasketBall_RightPhotoViewHolder(inflater.inflate(R.layout.item_mainpage_news, null));
            // 4.上面标题,下面多个图片 3个
            case TYPE_PHOTOS_ARRAY:
                return new China_BasketBall_PhotosArrayViewHolder(inflater.inflate(R.layout.item_china_photosarray, null));

        }
        return null;
    }
    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        RequestOptions options = new RequestOptions().centerCrop();
        if (articlesBeans != null) {
            MainPageNewsBean.ArticlesBean articlesBean = articlesBeans.get(position);
            switch (getItemViewType(position)) {
                // 1.顶部标题,下面大视频
                case TYPE_TOP_TITLE_VIDEO:
                    China_BasketBall_TopVideoViewHolder holder1 = (China_BasketBall_TopVideoViewHolder) holder;
                    holder1.mTopvideoTvTitle.setText(articlesBean.getTitle());
                    Glide.with(BaseApp.getInstance()).load(articlesBean.getThumb()).apply(options).into(holder1.mTopvideoJcvideo.ivThumb);
                    holder1.mTopvideoTvvideoTime.setText(articlesBean.getVideo_info().getVideo_time());
                    holder1.mTopvideoJcvideo.setUp(articlesBean.getVideo_info().getVideo_src(), null);
                    if (articlesBean.getComments_total() == 0) {
                        holder1.mTopvideoJcvideoTvCommentsTotal.setVisibility(View.GONE);
                    } else {
                        holder1.mTopvideoJcvideoTvCommentsTotal.setText(articlesBean.getComments_total() + "评论");
                    }
                    if (articlesBean.getLabel() != null) {
                        holder1.mTopvideoTvlabel.setVisibility(View.VISIBLE);
                        holder1.mTopvideoTvlabel.setText(articlesBean.getLabel());
                    }
                    break;
                // 2.右边带有视频,左边标题
                case TYPE_RIGHT_VIDEO:
                    China_BasketBall_RightVideoViewHolder holder2 = (China_BasketBall_RightVideoViewHolder) holder;
                    holder2.mRightVideoItemTitle.setText(articlesBean.getTitle());
                    if (articlesBean.getComments_total() == 0) {
                        holder2.mRightVideoTvComments.setVisibility(View.GONE);
                    } else {
                        holder2.mRightVideoTvComments.setText(articlesBean.getComments_total() + "评论");
                    }
                    if (articlesBean.getThumb() != null) {
                        Glide.with(BaseApp.getInstance()).load(articlesBean.getThumb()).into(holder2.mRightVideoItemThumb);
                    }
                    if (articlesBean.getLabel() != null) {
                        holder2.mRightVideoTvLabel.setVisibility(View.VISIBLE);
                        holder2.mRightVideoTvLabel.setText(articlesBean.getLabel());
                    }

                    break;
                // 3.右边带有图片,左边图片
                case TYPE_RIGHT_PHOTOS:
                    China_BasketBall_RightPhotoViewHolder holder3 = (China_BasketBall_RightPhotoViewHolder) holder;
                    holder3.mItemTitle.setText(articlesBean.getTitle());
                    if (articlesBean.getLabel() != null) {
                        holder3.mTvLabel.setVisibility(View.VISIBLE);
                        holder3.mTvLabel.setText(articlesBean.getLabel());
                    }
                    if (articlesBean.getAdd_to_tab() != null) {
                        if (articlesBean.getAdd_to_tab().equals("0")) {
                            holder3.mTvAddToTop.setVisibility(View.VISIBLE);
                        }
                    }
                    holder3.mTvComments.setText(articlesBean.getComments_total() + "评论");
                    holder3.mItemTitle.setText(articlesBean.getTitle());
                    Glide.with(BaseApp.getInstance()).load(articlesBean.getThumb()).into(holder3.mItemThumb);
                    break;
                // 4.上面标题,下面多个图片 3个
                case TYPE_PHOTOS_ARRAY:
                    China_BasketBall_PhotosArrayViewHolder holder4 = (China_BasketBall_PhotosArrayViewHolder) holder;
                    holder4.mPhotosArrayTvTitle.setText(articlesBean.getTitle());
                    if (articlesBean.getComments_total() == 0) {
                        holder4.mPhotosArrayTvComments.setVisibility(View.GONE);
                    } else {
                        holder4.mPhotosArrayTvComments.setText(articlesBean.getComments_total() + "评论");
                    }
                    if (articlesBean.getAlbum() != null) {
                        Glide.with(BaseApp.getInstance()).load(articlesBean.getAlbum().getPics().get(0)).into(holder4.mIvPics1);
                        Glide.with(BaseApp.getInstance()).load(articlesBean.getAlbum().getPics().get(1)).into(holder4.mIvPics2);
                        Glide.with(BaseApp.getInstance()).load(articlesBean.getAlbum().getPics().get(2)).into(holder4.mIvPics3);
                    }
                    break;
            }
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (articlesBeans.get(position).getChannel().equals("article")) {
                    WebViewActivity.go2Acitvity(context, String.valueOf(articlesBeans.get(position).getId()), articlesBeans.get(position).getComments_total());
                } else return;
            }
        });

    }

    @Override
    public int getItemViewType(int position) {
        if (articlesBeans != null && articlesBeans.size() > 0) {
            if (articlesBeans.get(position).isIs_video() && articlesBeans.get(position).getVideo_info() != null) {
                if (articlesBeans.get(position).getExtend() != null) {
                    return TYPE_TOP_TITLE_VIDEO;
                } else {
                    return TYPE_RIGHT_VIDEO;
                }
            } else {
                if (articlesBeans.get(position).getAlbum() != null && articlesBeans.get(position).getAlbum().getPics().size() > 0) {
                    return TYPE_PHOTOS_ARRAY;
                } else {
                    return TYPE_RIGHT_PHOTOS;
                }
            }
        }
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return articlesBeans != null ? articlesBeans.size() : 0;
    }
    class China_BasketBall_TopVideoViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.topvideo_tv_title)
        TextView mTopvideoTvTitle;
        @BindView(R.id.topvideo_jcvideo)
        JCVideoPlayer mTopvideoJcvideo;
        @BindView(R.id.topvideo_jcvideo_tv_comments_total)
        TextView mTopvideoJcvideoTvCommentsTotal;
        @BindView(R.id.topvideo_tv_label)
        TextView mTopvideoTvlabel;
        @BindView(R.id.topvideo_tv_video_time)
        TextView mTopvideoTvvideoTime;

        public China_BasketBall_TopVideoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

    class China_BasketBall_RightVideoViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.right_video_item_thumb)
        RoundImageView mRightVideoItemThumb;
        @BindView(R.id.right_video_item_title)
        TextView mRightVideoItemTitle;
        @BindView(R.id.right_video_tv_label)
        TextView mRightVideoTvLabel;
        @BindView(R.id.right_video_tv_comments)
        TextView mRightVideoTvComments;

        public China_BasketBall_RightVideoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class China_BasketBall_RightPhotoViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_thumb)
        RoundImageView mItemThumb;
        @BindView(R.id.item_title)
        TextView mItemTitle;
        @BindView(R.id.tv_label)
        TextView mTvLabel;
        @BindView(R.id.tv_add_to_top)
        TextView mTvAddToTop;
        @BindView(R.id.tv_comments)
        TextView mTvComments;
        public China_BasketBall_RightPhotoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    class China_BasketBall_PhotosArrayViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.photos_array_tv_title)
        TextView mPhotosArrayTvTitle;
        @BindView(R.id.iv_pics1)
        RoundImageView mIvPics1;
        @BindView(R.id.iv_pics2)
        RoundImageView mIvPics2;
        @BindView(R.id.iv_pics3)
        RoundImageView mIvPics3;
        @BindView(R.id.photos_array_tv_comments)
        TextView mPhotosArrayTvComments;
        public China_BasketBall_PhotosArrayViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
