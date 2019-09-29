package com.sport.sportproject.ui.fragment_mainpage.adapter;

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
import com.sport.sportproject.base.BaseApp;
import com.sport.sportproject.bean.bean.mainpage.MainPageNewsBean;
import com.sport.sportproject.ui.WebViewActivity;
import com.sport.sportproject.utils.RoundImageView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;
import com.youth.banner.transformer.RotateDownTransformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
public class MainPageNewsAdapter extends RecyclerView.Adapter {

    private static final int TYPE_BANNER = 890;
    private ArrayList<String> titles = new ArrayList<>();
    public ArrayList<MainPageNewsBean.ArticlesBean> articlesBeans;
    private ArrayList<MainPageNewsBean.RecommendBean> recommendBeans;
    private Context context;
    private int newPosition;
    private MainPageNewsBean.ArticlesBean bean1;


    public MainPageNewsAdapter(ArrayList<MainPageNewsBean.ArticlesBean> articlesBeans, ArrayList<MainPageNewsBean.RecommendBean> recommendBeans) {
        this.articlesBeans = articlesBeans;
        this.recommendBeans = recommendBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        if (viewType == TYPE_BANNER) {
            return new MainPageNewsBannerViewHolder(inflater.inflate(R.layout.item_mainpage_banner, null));
        } else {
            MainPageNewsBean.ArticlesBean bean = articlesBeans.get(viewType);
            if (bean.isIs_video()) {
                if (bean.getExtend() != null) {
                    return new MainPage_TopVideoViewHolder(inflater.inflate(R.layout.item_china_top_video, null));
                } else {
                    return new MainPageRightVideoViewHolder(inflater.inflate(R.layout.item_china_right_video, null));
                }
            } else {
                if (bean.getAlbum() != null && bean.getAlbum().getPics().size() > 0) {
                    return new MainPage_PhotosArrayViewHolder(inflater.inflate(R.layout.item_china_photosarray, null));
                } else {
                    return new MainPageNewsViewHolder(inflater.inflate(R.layout.item_mainpage_news, null));
                }
            }
        }
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        int viewType = getItemViewType(position);
        if (viewType == TYPE_BANNER) {
            for (int i = 0; i < recommendBeans.size(); i++) {
                titles.add(recommendBeans.get(i).getTitle());
            }

            MainPageNewsBannerViewHolder holder1 = (MainPageNewsBannerViewHolder) holder;
            holder1.mItemBanner.setImages(recommendBeans)
                    .setBannerTitles(titles)
                    .setDelayTime(3000)
                    .setBannerAnimation(Transformer.ZoomOutSlide)
                    .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
                    .setIndicatorGravity(BannerConfig.LEFT)
                    .setImageLoader(new ImageLoader() {
                        @Override
                        public void displayImage(Context context, Object path, ImageView imageView) {
                            MainPageNewsBean.RecommendBean bean = (MainPageNewsBean.RecommendBean) path;
                            Glide.with(context).load(bean.getThumb()).into(imageView);
                        }
                    })
                    .isAutoPlay(true)
                    .setOnBannerListener(new OnBannerListener() {
                @Override
                public void OnBannerClick(int position) {
                }
            }).start();
        } else {
            newPosition = position;
            if (recommendBeans != null) {
                newPosition = position - 1;
            }
            bean1 = articlesBeans.get(newPosition);
            RequestOptions options = new RequestOptions()
                    .centerCrop();
            if (bean1.isIs_video()) {
                if (bean1.getExtend() != null) {
                    MainPage_TopVideoViewHolder holder3 = (MainPage_TopVideoViewHolder) holder;
                    holder3.mTopvideoTvTitle.setText(bean1.getTitle());
                    Glide.with(BaseApp.getInstance()).load(bean1.getThumb()).apply(options).into(holder3.mTopvideoJcvideo.ivThumb);
                    if (bean1.getVideo_info() != null) {
                        holder3.mTopvideoTvvideoTime.setText(bean1.getVideo_info().getVideo_time() + R.string.nulls);
                        holder3.mTopvideoJcvideo.setUp(bean1.getVideo_info().getVideo_src(), null);
                    }
                    if (bean1.getComments_total() == 0) {
                        holder3.mTopvideoJcvideoTvCommentsTotal.setVisibility(View.GONE);
                    } else {
                        holder3.mTopvideoJcvideoTvCommentsTotal.setText(bean1.getComments_total() + R.string.comments);
                    }
                    if (bean1.getLabel() != null) {
                        holder3.mTopvideoTvlabel.setVisibility(View.VISIBLE);
                        holder3.mTopvideoTvlabel.setText(bean1.getLabel());
                    }
                } else {
                    MainPageRightVideoViewHolder holder5 = (MainPageRightVideoViewHolder) holder;
                    if (bean1.getTitle() != null) {
                        holder5.mRightVideoItemTitle.setText(bean1.getTitle());
                    }
                    if (bean1.getComments_total() == 0) {
                        holder5.mRightVideoTvComments.setVisibility(View.GONE);
                    } else {
                        holder5.mRightVideoTvComments.setText(bean1.getComments_total() + R.string.comments);
                    }
                    if (bean1.getThumb() != null) {
                        Glide.with(BaseApp.getInstance()).load(bean1.getThumb()).apply(options).into(holder5.mRightVideoItemThumb);
                    }
                    if (bean1.getLabel() != null) {
                        holder5.mRightVideoTvLabel.setVisibility(View.VISIBLE);
                        holder5.mRightVideoTvLabel.setText(bean1.getLabel());
                    } else {
                        holder5.mRightVideoTvLabel.setVisibility(View.GONE);
                    }
                }
            } else if (!bean1.isIs_video()) {
                if (bean1.getAlbum() != null) {
                    MainPage_PhotosArrayViewHolder holder4 = (MainPage_PhotosArrayViewHolder) holder;
                    holder4.mPhotosArrayTvTitle.setText(bean1.getTitle());
                    if (bean1.getComments_total() == 0) {
                        holder4.mPhotosArrayTvComments.setVisibility(View.GONE);
                    } else {
                        holder4.mPhotosArrayTvComments.setText(bean1.getComments_total() + R.string.comments);
                    }
                    if (bean1.getAlbum() != null) {
                        Glide.with(BaseApp.getInstance()).load(bean1.getAlbum().getPics().get(0)).into(holder4.mIvPics1);
                        Glide.with(BaseApp.getInstance()).load(bean1.getAlbum().getPics().get(1)).into(holder4.mIvPics2);
                        Glide.with(BaseApp.getInstance()).load(bean1.getAlbum().getPics().get(2)).into(holder4.mIvPics3);
                    }
                } else {
                    MainPageNewsViewHolder holder2 = (MainPageNewsViewHolder) holder;
                    if (bean1.getLabel() != null) {
                        holder2.mTvLabel.setVisibility(View.VISIBLE);
                        holder2.mTvLabel.setText(bean1.getLabel());
                    }
                    if (bean1.getAdd_to_tab() != null) {
                        if (bean1.getAdd_to_tab().equals("0")) {
                            holder2.mTvAddToTop.setVisibility(View.VISIBLE);
                        }
                    }
                    holder2.mTvComments.setText(bean1.getComments_total() + R.string.comments);
                    holder2.mItemTitle.setText(bean1.getTitle());
                    Glide.with(BaseApp.getInstance()).load(bean1.getThumb()).into(holder2.mItemThumb);
                }
            }
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!bean1.isIs_video()) {
                    WebViewActivity.go2Acitvity(context, bean1.getUrl(), bean1.getComments_total());
                }
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_BANNER;
        } else {
            return position - 1;
        }

    }

    @Override
    public int getItemCount() {
        if (articlesBeans != null) {
            return articlesBeans.size() + 1;
        } else {
            return articlesBeans.size();
        }
    }

    class MainPageNewsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_title)
        TextView mItemTitle;
        @BindView(R.id.item_thumb)
        RoundImageView mItemThumb;
        @BindView(R.id.tv_label)
        TextView mTvLabel;
        @BindView(R.id.tv_add_to_top)
        TextView mTvAddToTop;
        @BindView(R.id.tv_comments)
        TextView mTvComments;

        public MainPageNewsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class MainPageNewsBannerViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_banner)
        Banner mItemBanner;

        public MainPageNewsBannerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class MainPageRightVideoViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.right_video_item_thumb)
        RoundImageView mRightVideoItemThumb;
        @BindView(R.id.right_video_item_title)
        TextView mRightVideoItemTitle;
        @BindView(R.id.right_video_tv_label)
        TextView mRightVideoTvLabel;
        @BindView(R.id.right_video_tv_comments)
        TextView mRightVideoTvComments;

        public MainPageRightVideoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class MainPage_PhotosArrayViewHolder extends RecyclerView.ViewHolder {
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

        public MainPage_PhotosArrayViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class MainPage_TopVideoViewHolder extends RecyclerView.ViewHolder {
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

        public MainPage_TopVideoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
