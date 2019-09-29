package com.sport.sportproject.ui.fragment_mainpage.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.sport.sportproject.R;
import com.sport.sportproject.base.BaseApp;
import com.sport.sportproject.base.BaseFragment;
import com.sport.sportproject.base.BasePublicPresenter;
import com.sport.sportproject.base.PublicView;
import com.sport.sportproject.bean.bean.mainpage.MainPageHotBean;
import com.sport.sportproject.interfaces.LoadConfig;
import com.sport.sportproject.interfaces.Params;
import com.sport.sportproject.ui.fragment_mainpage.adapter.HeadAdapter;
import com.sport.sportproject.ui.fragment_mainpage.model.Fragment_MainPage_Chick_Model;
import com.sport.sportproject.utils.TimeChangeUtils;
import com.sport.sportproject.utils.ToastUtil;

import java.util.ArrayList;

import butterknife.BindView;
import qdx.stickyheaderdecoration.NormalDecoration;

//热门
public class HotFragment extends BaseFragment<BasePublicPresenter, Fragment_MainPage_Chick_Model> implements PublicView {
    private static final String ID = "id";
    private static final String TYPE = "type";

    @BindView(R.id.rlv)
    RecyclerView mRlv;
    @BindView(R.id.smart)
    SmartRefreshLayout mSmart;
    @BindView(R.id.iv_loading)
    ImageView mIvLoading;
    @BindView(R.id.tv_loading)
    TextView mTvLoading;
    int page = 1;

    private int anInt;
    private String type;
    private ArrayList<MainPageHotBean.ContentsBean> hotBeans = new ArrayList<>();
    private ArrayList<String> heads = new ArrayList<>();
    private HeadAdapter headAdapter;
    private MainPageHotBean hotBean;
    private Animation animation;
    public static HotFragment go2Fragment(int id, String type) {
        HotFragment fragment = new HotFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ID, id);
        bundle.putString(TYPE, type);
        fragment.setArguments(bundle);
        return fragment;
    }
    /**
     *
     * @param type 区分
     * @param objects
     */

    @Override
    public void onSuccess(int type, Object[] objects) {
        switch (type) {
            case Params.REQUEST_HOT_DATA:
                hotBean = (MainPageHotBean) objects[0];
                int loads = (int) objects[1];
                if (loads == LoadConfig.REFRESH) {
                    headAdapter.hotBeans.clear();
                } else if (loads == LoadConfig.LOADMORE) ;
                for (int i = 0; i < hotBean.getContents().size(); i++) {
                    heads.add(hotBean.getContents().get(i).getDay());
                }
                hotBeans.addAll(hotBean.getContents());
                headAdapter.notifyDataSetChanged();
                break;
        }
        mSmart.finishLoadMore(1000);
        mSmart.finishRefresh(1000);
    }

    @Override
    public void onFaile(Throwable e) {
        ToastUtil.showLong(e.getMessage());
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
                page++;
                mPresenter.getData(Params.REQUEST_HOT_DATA, anInt, LoadConfig.LOADMORE, page, hotBean.getMin());
                mIvLoading.startAnimation(animation);
            }
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                if (type.equals("hot"))
                    mPresenter.getData(Params.REQUEST_HOT_DATA, anInt, LoadConfig.REFRESH);
            }
        });
    }
    @Override
    protected void initData() {
        if (type.equals("hot")) {
            mPresenter.getData(Params.REQUEST_HOT_DATA, anInt, LoadConfig.NOLOADMORE);
        }
    }
    @Override
    protected void initView() {

        Bundle bundle = getArguments();
        anInt = bundle.getInt(ID,0);
        type = bundle.getString(TYPE);
        animation = new AnimationUtils().loadAnimation(getContext(), R.anim.zuqiu_bg);
        headAdapter = new HeadAdapter(hotBeans);

        mRlv.setLayoutManager(new LinearLayoutManager(BaseApp.getInstance()));
        NormalDecoration normalDecoration = new NormalDecoration() {
            @Override
            public String getHeaderName(int i) {
                return heads.get(i);
            }
        };

        normalDecoration.setOnDecorationHeadDraw(new NormalDecoration.OnDecorationHeadDraw() {
            @SuppressLint("SetTextI18n")
            @Override
            public View getHeaderView(int i) {
                View inflate = LayoutInflater.from(getContext()).inflate(R.layout.decoration, null);
                TextView mTv = inflate.findViewById(R.id.tv_decortaion);
                mTv.setText(heads.get(i) +""+ TimeChangeUtils.getWeek(heads.get(i)));
                return inflate;
            }
        });

        mRlv.addItemDecoration(normalDecoration);
        mRlv.setAdapter(headAdapter);

    }
    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_hot;
    }
}
