package com.sport.sportproject.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.sport.sportproject.R;
import com.sport.sportproject.base.BaseApp;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 华为 on 2019/7/21.
 */

public class PhotoBrowserActivity extends AppCompatActivity {
    //    MJavascriptInterface mJavascriptInterface;
    @BindView(R.id.pager)
    ViewPager mPager;

    private String[] imageUrls;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_webview_content_item);
        EventBus.getDefault().register(this);
        ButterKnife.bind(this);
        initView();
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void getData(String[] url) {
        if (!imageUrls.equals("")) {
            imageUrls = url;
        }
        Log.i("tag", "传: " + imageUrls);
    }

    private void initView() {

        mPager.setPageMargin((int) (getResources().getDisplayMetrics().density * 15));

        mPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return imageUrls.length;
            }
            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view == object;
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {

                View inflate = View.inflate(PhotoBrowserActivity.this, R.layout.viewpage_item_imageview2, null);
                ImageView img = inflate.findViewById(R.id.img_content);
                Glide.with(PhotoBrowserActivity.this).load(imageUrls[position]).into(img);
                return inflate;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//                super.destroyItem(container, position, object);
                container.removeView((View) object);
            }
        });

        //        mPager.setAdapter(new PagerAdapter() {
//            @Override
//            public int getCount() {
//                return imageUrls.length;
//            }
//
//            @Override
//            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
//                return view == object;
//            }
//
//            @NonNull
//            @Override
//            public Object instantiateItem(@NonNull ViewGroup container, int position) {
//                if (imageUrls[position].equals("") && imageUrls[position] != null) {
//                    PhotoView view = new PhotoView(PhotoBrowserActivity.this);
//                    view.enable();
//                    view.setScaleType(ImageView.ScaleType.FIT_CENTER);
//                    RequestOptions requestOptions = new RequestOptions();
//                    //详解glide中crossfade引发的默认图变形
//                    RequestOptions requestOptions1 = requestOptions.override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL).fitCenter();
//                    Glide.with(PhotoBrowserActivity.this).load(imageUrls[position]).into(view);
////                    Glide.with(PhotoBrowserActivity.this).load(imageUrls[position]).apply(requestOptions).listener(new RequestListener<Drawable>() {
////                        @Override
////                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
////                            return false;
////                        }
////
////                        @Override
////                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
////                            return false;
////                        }
////                    });
//                    return view;
//                }
//                return null;
//            }
//
////            @Override
////            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
////
//////                super.destroyItem(container, position, object);
////
////                releaseOnePosition(position);
////
////                container.removeView((View) object);
////            }
////        });
////        curPosition = returnClickedPosition() == -1 ? 0 : returnClickedPosition();
////
////        mPager.setCurrentItem(curPosition);
////
////        mPager.setTag(curPosition);
////
////        if (initialedPositions[curPosition] != curPosition) {//如果当前页面未加载完毕，则显示加载动画，反之相反；
////
////            showLoadingAnimation();
////        }
////        photoOrderTv.setText((curPosition + 1) + "/" + imageUrls.length);//设置页面的编号
////
////        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
////            @Override
////            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
////
////            }
////
////            @Override
////            public void onPageSelected(int position) {
////
////            }
////
////            @Override
////            public void onPageScrollStateChanged(int state) {
////
////            }
////        });
//
//            //    }
////            private void releaseOnePosition(int position) {
    }
    //传值
//    public static void getData(String[] urls, BaseApp context) {
//        Intent intent = new Intent(context, PhotoBrowserActivity.class);
//        intent.putExtra("urls",urls);
//        context.startActivity(intent);
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}