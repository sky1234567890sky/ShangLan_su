package com.sport.sportproject.ui.fragment_mainpage.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.sport.sportproject.R;
import com.sport.sportproject.adapter.China_BasketBall;
import com.sport.sportproject.adapter.INS;
import com.sport.sportproject.adapter.Jijie;
import com.sport.sportproject.adapter.Zhuanti;
import com.sport.sportproject.adapter.bean.INSBean;
import com.sport.sportproject.adapter.bean.JijieBean;
import com.sport.sportproject.adapter.bean.ZhuantiBean;
import com.sport.sportproject.base.BaseApp;
import com.sport.sportproject.base.BaseFragment;
import com.sport.sportproject.base.BasePublicPresenter;
import com.sport.sportproject.base.PublicView;
import com.sport.sportproject.bean.bean.mainpage.MainPageLiveBean;
import com.sport.sportproject.bean.bean.mainpage.MainPageNewsBean;
import com.sport.sportproject.interfaces.LoadConfig;
import com.sport.sportproject.interfaces.Params;
import com.sport.sportproject.ui.fragment_mainpage.adapter.CctvRlvAdapter;
import com.sport.sportproject.ui.fragment_mainpage.model.Fragment_MainPage_Chick_Model;
import com.sport.sportproject.utils.TimeChangeUtils;
import com.sport.sportproject.utils.ToastUtil;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class Fragment_MainPage_Chick extends BaseFragment<BasePublicPresenter, Fragment_MainPage_Chick_Model> implements PublicView {
    private static final String ID = "id";
    private static final String TYPE = "type";
    private static boolean isCreate;
    @BindView(R.id.rlv)
    RecyclerView mRlv;
    @BindView(R.id.smart)
    SmartRefreshLayout mSmart;
    @BindView(R.id.iv_loading)
    ImageView mIvLoading;
    @BindView(R.id.tv_no_more)
    TextView mTvNomore;
    @BindView(R.id.cctv_rlv)
    RecyclerView mCctvRlv;
    @BindView(R.id.iv_red_bg)
    ImageView mIvRedBg;
    @BindView(R.id.mbanner)
    Banner mBanner;
    @BindView(R.id.view)
    View mview;
    @BindView(R.id.rl_backgroud)
    RelativeLayout mRlBackgroud;
    @BindView(R.id.tv_loading)
    TextView mTvLoading;
    private int anInt;
    private ArrayList<MainPageNewsBean.ArticlesBean> articlesBeans = new ArrayList<>();  // 文章集合
    private ArrayList<JijieBean.ArticlesBean> jijieBeans = new ArrayList<>(); // 视频集合
    private ArrayList<INSBean.FeedlistBean> feedlistBeans = new ArrayList<>(); // INS 论坛集合
    private ArrayList<ZhuantiBean.ArticlesBean> zhuangtiBeans = new ArrayList<>();  // 专题集合
    private ArrayList<MainPageLiveBean> liveBeans = new ArrayList<>();
    private int page = 1;
    private String type;
    private Jijie jijie;
    private INS ins;
    private Zhuanti zhuanti;
    private boolean isvisible;
    private Animation animation;
    private CctvRlvAdapter cctvRlvAdapter;
    private China_BasketBall china_basketBall;
    private MainPageNewsBean bean;
    private JijieBean jijieBean;
    private INSBean insBean;
    private Long mill;
    private ArrayList<MainPageLiveBean> liveBean;

    /**
     * @param id   id用于请求网络
     * @param type type区分接口
     * @return
     */
    public static Fragment_MainPage_Chick go2Fragment(int id, String type) {
        Fragment_MainPage_Chick fragment_mainPage_chick = new Fragment_MainPage_Chick();
        Bundle bundle = new Bundle();
        bundle.putInt(ID, id);
        bundle.putString(TYPE, type);
        fragment_mainPage_chick.setArguments(bundle);
        isCreate = true;
        return fragment_mainPage_chick;
    }

    /**
     * @param type    区分
     * @param objects
     */
    @Override
    public void onSuccess(int type, final Object[] objects) {
        loadingDialog.dismiss();
        switch (type) {
            case Params.REQUEST_ONE:
                bean = (MainPageNewsBean) objects[0];
                int load = (int) objects[1];
                if (load == LoadConfig.REFRESH) {
                    china_basketBall.articlesBeans.clear();
                } else if (load == LoadConfig.LOADMORE) ;
                if (bean.getRecommend() != null)
                    ShowBanner(bean.getRecommend());
                if (bean.getArticles() != null) {
                    articlesBeans.addAll(bean.getArticles());
                }
                china_basketBall.notifyDataSetChanged();
                break;
            case Params.REQUEST_TWO:
                jijieBean = (JijieBean) objects[0];
                int load1 = (int) objects[1];
                if (load1 == LoadConfig.REFRESH) {
                    jijie.articlesBeans.clear();
                } else if (load1 == LoadConfig.LOADMORE) ;
                if (jijieBean != null) {
                    jijieBeans.addAll(jijieBean.getArticles());
                }
                jijie.notifyDataSetChanged();
                break;

            case Params.REQUEST_THREE:
                insBean = (INSBean) objects[0];
                int load2 = (int) objects[1];
                if (load2 == LoadConfig.REFRESH) {
                    feedlistBeans.clear();
                } else if (load2 == LoadConfig.LOADMORE) ;
                feedlistBeans.addAll(insBean.getFeedlist());
                ins.notifyDataSetChanged();
                break;
            case Params.REQUEST_FOUR:
                ZhuantiBean zhuantiBean = (ZhuantiBean) objects[0];
                int load3 = (int) objects[1];
                if (load3 == LoadConfig.REFRESH) {
                    zhuangtiBeans.clear();
                } else if (load3 == LoadConfig.LOADMORE) ;
                zhuangtiBeans.addAll(zhuantiBean.getArticles());
                zhuanti.notifyDataSetChanged();
                break;
            case Params.REQUEST_HEAD_LIVE:
                liveBean = (ArrayList<MainPageLiveBean>) objects[0];
                liveBeans.addAll(liveBean);
                cctvRlvAdapter.notifyDataSetChanged();
                if (liveBean != null)
                    if (liveBean.size() == 1) {
                        mCctvRlv.setLayoutManager(new GridLayoutManager(getContext(), 1));
                    } else if (liveBean.size() == 2) {
                        mCctvRlv.setLayoutManager(new GridLayoutManager(getContext(), 2));
                    }
                break;
        }
        mSmart.finishLoadMore(1000);
        mSmart.finishRefresh(1000);
    }

    /**
     * @param e
     */
    @Override
    public void onFaile(Throwable e) {
        ToastUtil.showShort(e.toString());
    }
    /**
     * @param recommend 头条轮播图
     */
    private void ShowBanner(List<MainPageNewsBean.RecommendBean> recommend) {
        if (recommend.size() > 0) {
            ArrayList<String> titles = new ArrayList<>();
            for (int i = 0; i < recommend.size(); i++) {
                titles.add(recommend.get(i).getTitle());
            }
            mBanner.setImages(recommend)                                                            // Accordion 翻页形状
                    .setBannerTitles(titles)                                                        // CubeOut 180 + 90 C 效果
                    .setDelayTime(3000)                                                             // BackgroundToForeground  X轴 Y 轴 从右放大
                    .setBannerAnimation(Transformer.FlipVertical)                                      // CubeIn 垂直屏效果
                    .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE)                     // DepthPage 左滑动效果
                    .setImageLoader(new ImageLoader() {
                        @Override
                        public void displayImage(Context context, Object path, ImageView imageView) {                    // FlipHorizontal 左右反转效果
                            MainPageNewsBean.RecommendBean bean = (MainPageNewsBean.                // FlipVertical  上下反转效果
                                    RecommendBean) path;                                            // ForegroundToBackground 从大到小效果
                            RequestOptions options = new RequestOptions()
                                    .transform(new RoundedCorners(10));
                            Glide.with(context).load(bean.getThumb()).apply(options).into(imageView);              // RotateDown 从下倾斜切换效果
                        }
                    }).setOnBannerListener(new OnBannerListener() {
                @Override
                public void OnBannerClick(int position) {

                }
            }).start();                   // RotateUp  从上倾斜切换效果
        }                                                                                           // ScaleInOut 关闭

    }

    /**
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            isvisible = isVisibleToUser;
            setvisible();
        } else {
            isvisible = isVisibleToUser;
        }
    }

    @Override
    protected Fragment_MainPage_Chick_Model initModel() {
        return new Fragment_MainPage_Chick_Model();
    }

    @Override
    protected BasePublicPresenter initPresenter() {
        return new BasePublicPresenter();
    }

    @Override
    protected void initListener() {

        mSmart.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                if (type.equals("classification")) {
                    mTvLoading.setVisibility(View.GONE);
                    mIvLoading.setVisibility(View.GONE);
                    mTvNomore.setVisibility(View.VISIBLE);
                } else {
                    page++;
                    mIvLoading.startAnimation(animation);
                    if (type.equals("normal"))
                        mPresenter.getData(Params.REQUEST_ONE, anInt, LoadConfig.LOADMORE, page, bean.getMin());
                    if (type.equals("video"))
                        mPresenter.getData(Params.REQUEST_TWO, anInt, LoadConfig.LOADMORE, page, String.valueOf(jijieBean.getMin()));
                    if (type.equals("wall")) {
                        String publishedAt = insBean.getFeedlist().get(insBean.getFeedlist().size() - 1).getPublished_at();
                        try {
                            mill = TimeChangeUtils.getTimeFormat2mill(publishedAt);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        mPresenter.getData(Params.REQUEST_THREE, type, LoadConfig.LOADMORE, page, (mill / 1000 - 1));
                    }
                }
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                if (type.equals("normal"))
                    mPresenter.getData(Params.REQUEST_ONE, anInt, LoadConfig.REFRESH);
                else if (type.equals("video"))
                    mPresenter.getData(Params.REQUEST_TWO, anInt, LoadConfig.REFRESH);
                else if (type.equals("wall"))
                    mPresenter.getData(Params.REQUEST_THREE, type, LoadConfig.REFRESH);
            }
        });
    }

    @Override
    protected void initData() {
        loadingDialog.show();
        if (type.equals("normal")) {
            if (anInt == 1) {
                mPresenter.getData(Params.REQUEST_HEAD_LIVE, anInt, LoadConfig.NOLOADMORE);
            }
            mPresenter.getData(Params.REQUEST_ONE, anInt, LoadConfig.NOLOADMORE);
        } else if (type.equals("video")) {
            mPresenter.getData(Params.REQUEST_TWO, anInt, LoadConfig.NOLOADMORE);
        } else if (type.equals("wall")) {
            mPresenter.getData(Params.REQUEST_THREE, type, LoadConfig.NOLOADMORE);
        } else if (type.equals("classification")) {
            mPresenter.getData(Params.REQUEST_FOUR, anInt, LoadConfig.NOLOADMORE);
        }
    }

    @Override
    protected void initView() {
        getto();
        animation = new AnimationUtils().loadAnimation(getContext(), R.anim.zuqiu_bg);
        mRlv.setLayoutManager(new LinearLayoutManager(BaseApp.getInstance()));
        if (type != null) {
            if (type.equals("normal")) { // 头条 : NBA : 中国篮球 : 深度 : 闲情 : 世界杯
                if (anInt == 1) {
                    if (mview.getVisibility() == View.GONE && mRlBackgroud.getVisibility() ==
                            View.GONE && mCctvRlv.getVisibility() == View.GONE) {
                        mview.setVisibility(View.VISIBLE);
                        mRlBackgroud.setVisibility(View.VISIBLE);
                        mCctvRlv.setVisibility(View.VISIBLE);
                    }
                    cctvRlvAdapter = new CctvRlvAdapter(liveBeans);
                    mCctvRlv.setAdapter(cctvRlvAdapter);
                }
                china_basketBall = new China_BasketBall(articlesBeans);
                mRlv.setAdapter(china_basketBall);
            } else {
                if (type.equals("video")) { // 集锦
                    jijie = new Jijie(jijieBeans);
                    mRlv.setAdapter(jijie);
                } else if (type.equals("wall")) { //INS
                    ins = new INS(feedlistBeans);
                    mRlv.setAdapter(ins);
                } else if (type.equals("classification")) { // 专题
                    zhuanti = new Zhuanti(zhuangtiBeans);
                    mRlv.setAdapter(zhuanti);
                }
                UnVisibility();
            }
            if (!type.equals("classification")) {
                mRlv.addItemDecoration(new DividerItemDecoration(BaseApp.getInstance(),
                        DividerItemDecoration.VERTICAL));
            }
        }
    }

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_mainpage_click;
    }
    private void setvisible() {
        if (isvisible && isCreate) {
            isvisible = false;
            isCreate = false;
        }
    }

    private void UnVisibility() {
        mview.setVisibility(View.GONE);
        mRlBackgroud.setVisibility(View.GONE);
        mCctvRlv.setVisibility(View.GONE);
    }

    private void getto() {
        Bundle bundle = getArguments();
        anInt = bundle.getInt(ID, 0);
        type = bundle.getString(TYPE);
    }

}
