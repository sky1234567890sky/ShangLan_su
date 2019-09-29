package com.sport.sportproject.ui.fragment_circlezi.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.sport.sportproject.R;
import com.sport.sportproject.base.BaseApp;
import com.sport.sportproject.base.BaseFragment;
import com.sport.sportproject.base.BasePublicPresenter;
import com.sport.sportproject.base.PublicView;
import com.sport.sportproject.interfaces.LoadConfig;
import com.sport.sportproject.interfaces.Params;
import com.sport.sportproject.ui.fragment_circlezi.adapter.CircleHotAdapter;
import com.sport.sportproject.ui.fragment_circlezi.adapter.CircleNormalAdapter;
import com.sport.sportproject.ui.fragment_circlezi.bean.CircleNormalBean;
import com.sport.sportproject.ui.fragment_mainpage.model.Fragment_CircleZi_Normal_Model;
import com.sport.sportproject.utils.TimeChangeUtils;

import java.text.ParseException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Fragment_CircleZi_Normal extends BaseFragment<BasePublicPresenter, Fragment_CircleZi_Normal_Model> implements PublicView {

    public static final String POSITION = "position";
    @BindView(R.id.iv_huati)
    ImageView mIvHuati;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.rlt_hot)
    RelativeLayout mRltHot;
    @BindView(R.id.rlv_circle)
    RecyclerView mRlvCircle;
    @BindView(R.id.smart)
    SmartRefreshLayout mSmart;
    @BindView(R.id.rlv_hot)
    RecyclerView mRlvHot;
    @BindView(R.id.iv_loading)
    ImageView mIvLoading;
    @BindView(R.id.tv_no_more)
    TextView mTvNoMore;
    @BindView(R.id.tv_loading)
    TextView mTvLoading;
    private int anInt;
    private ArrayList<CircleNormalBean.DataBean.FeedsListBean> dataBeans = new ArrayList<>();
    private ArrayList<CircleNormalBean.DataBean.TopicBannerBean.TopicListBean> topicBannerBeans = new ArrayList<>();
    private CircleHotAdapter circleHotAdapter;
    private CircleNormalAdapter circleNormalAdapter;
    private String creaed_at;
    /**
     *
     * @param position
     * @return
     */
    public static Fragment_CircleZi_Normal get2FragmentNormal(int position) {
        Fragment_CircleZi_Normal circleZi_focus = new Fragment_CircleZi_Normal();
        Bundle bundle = new Bundle();
        bundle.putInt(POSITION, position);
        circleZi_focus.setArguments(bundle);
        return circleZi_focus;
    }

    /**
     *
     * @param type 区分
     * @param objects
     */
    @Override
    public void onSuccess(int type, Object[] objects) {
        switch (type) {
            case Params.REQUEST_ONE:
                CircleNormalBean circleNormalBean = (CircleNormalBean) objects[0];
                int load = (int) objects[1];
                if (load == LoadConfig.REFRESH) {
                    circleNormalAdapter.dataBeans.clear();
                } else if (load == LoadConfig.LOADMORE) ;
                if (circleNormalBean != null && circleNormalBean.getData().getTopic_banner() != null) {
                    mTvTitle.setText(circleNormalBean.getData().getTopic_banner().getTitle());
                    Glide.with(BaseApp.getInstance()).load(circleNormalBean.getData().getTopic_banner().getIcon()).into(mIvHuati);
                    topicBannerBeans.addAll(circleNormalBean.getData().getTopic_banner().getTopic_list());
                    circleHotAdapter = new CircleHotAdapter(topicBannerBeans);
                    mRlvHot.setAdapter(circleHotAdapter);
                }
                dataBeans.addAll(circleNormalBean.getData().getFeeds_list());
                try {
                    creaed_at = String.valueOf(TimeChangeUtils.getTimeString2mill(dataBeans.get(dataBeans.size() - 1).getCreated_at()) / 1000 - 1);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case Params.REQUEST_TWO:
                CircleNormalBean circleNormalbean = (CircleNormalBean) objects[0];
                int load1 = (int) objects[1];
                if (load1 == LoadConfig.REFRESH) {
                    dataBeans.clear();
                } else if (load1 == LoadConfig.LOADMORE);
                if (circleNormalbean != null) {
                    dataBeans.addAll(circleNormalbean.getData().getFeeds_list());
                }
                break;
        }
        loadingDialog.dismiss();
        circleNormalAdapter.notifyDataSetChanged();
        mSmart.finishRefresh(1000);
        mSmart.finishLoadMore(1000);
    }
    /**
     * @param e
     */
    @Override
    public void onFaile(Throwable e) {
    }
    /**
     * @return Fragment_CircleZi_Normal_Model
     */
    @Override
    protected Fragment_CircleZi_Normal_Model initModel() {
        return new Fragment_CircleZi_Normal_Model();
    }
    /**
     *
     * @return BasePublicPresenter
     */
    @Override
    protected BasePublicPresenter initPresenter() {
        return new BasePublicPresenter();
    }
    /**
     *  initListener
     */
    @Override
    protected void initListener() {
        mSmart.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                mIvLoading.startAnimation(animation);
                if (anInt == 1) {
                    mPresenter.getData(Params.REQUEST_ONE, LoadConfig.LOADMORE, creaed_at);
                } else {
                    mPresenter.getData(Params.REQUEST_TWO,LoadConfig.LOADMORE,creaed_at);
                }
            }
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                if (anInt == 1) {
                    mPresenter.getData(Params.REQUEST_ONE, LoadConfig.NOLOADMORE);
                } else {
                    mPresenter.getData(Params.REQUEST_TWO,LoadConfig.NOLOADMORE);
                }
            }
        });
    }
    /**
     *  InitData
     */
    @Override
    protected void initData() {
        loadingDialog.show();
        if (anInt == 1) {
            mPresenter.getData(Params.REQUEST_ONE, LoadConfig.NOLOADMORE);
        } else {
            mPresenter.getData(Params.REQUEST_TWO,LoadConfig.NOLOADMORE);
        }
    }
    @Override
    protected void initView() {
        getto();
        circleNormalAdapter = new CircleNormalAdapter(dataBeans);
        mRlvHot.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        mRlvCircle.setLayoutManager(new LinearLayoutManager(getContext()));
        // 1 == 推荐  2 == 视频(Video)
        if (anInt == 1) {
            if (mRltHot.getVisibility() == View.GONE) {
                mRltHot.setVisibility(View.VISIBLE);
            }
        }
        mRlvCircle.setAdapter(circleNormalAdapter);
    }
    /**
     * @return  Layout
     */

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_circlezi_normal;
    }
    private void getto() {
        anInt = getArguments().getInt(POSITION);
    }
}
