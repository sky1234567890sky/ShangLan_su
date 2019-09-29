package com.sport.sportproject.ui.fragment_data.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.sport.sportproject.R;
import com.sport.sportproject.base.BaseApp;
import com.sport.sportproject.base.BaseFragment;
import com.sport.sportproject.base.BasePublicPresenter;
import com.sport.sportproject.bean.bean.data.DataPersonTabBean;
import com.sport.sportproject.bean.bean.data.DataRankThreeBean;
import com.sport.sportproject.bean.bean.data.DataRankTwoBean;
import com.sport.sportproject.bean.bean.data.DataScheduleBean;
import com.sport.sportproject.bean.bean.data.RankInfo;
import com.sport.sportproject.ui.fragment_data.adapter.DataRankStandingAdapter;
import com.sport.sportproject.ui.fragment_data.adapter.DataRankThreeAdapter;
import com.sport.sportproject.ui.fragment_data.adapter.DataRankTwoAdapter;
import com.sport.sportproject.ui.fragment_data.adapter.RlvDataRankAdapter;
import com.sport.sportproject.utils.ToastUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.ITabView;
import q.rorbin.verticaltablayout.widget.TabView;

public class Fragment_Data_Small_Click extends BaseFragment {

    private static final String URL = "url";
    private static final String POSITION = "position";
    @BindView(R.id.rlv_data)
    RecyclerView mRlvData;
    @BindView(R.id.smart)
    SmartRefreshLayout mSmart;
    @BindView(R.id.vtab)
    VerticalTabLayout mVtab;
    @BindView(R.id.container)
    FrameLayout mContainer;
    @BindView(R.id.ll_vtab_viewpage)
    LinearLayout mLlVtabViewpage;
    @BindView(R.id.tv_header1)
    TextView mTvHeader1;
    @BindView(R.id.tv_header2)
    TextView mTvHeader2;
    @BindView(R.id.tv_header3)
    TextView mTvHeader3;
    @BindView(R.id.tv_header4)
    TextView mTvHeader4;
    @BindView(R.id.ll_header)
    LinearLayout mLlHeader;
    @BindView(R.id.tv_prev)
    TextView mTvPrev;
    @BindView(R.id.tv_round_name)
    TextView mTvRoundName;
    @BindView(R.id.tv_next)
    TextView mTvNext;
    @BindView(R.id.ll_schedule)
    LinearLayout mLlSchedule;
    @BindView(R.id.tv_description)
    TextView mTvDescription;

    private ArrayList<DataRankThreeBean.ContentBeanX.RoundsBean.ContentBean.DataBeanX> dataBeanXES = new ArrayList<>();
    private ArrayList<DataRankTwoBean.ContentBeanX.RoundsBean.ContentBean.DataBean> dataBeans = new ArrayList<>();
    private ArrayList<RankInfo.ContentBeanX.RoundsBean> dataStandingBeans = new ArrayList<>();
    private ArrayList<DataScheduleBean.ContentBean.MatchesBean> matchesBeans = new ArrayList<>();
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private ArrayList<String> titles = new ArrayList<>();
    private RlvDataRankAdapter rlvDataRankAdapter;
    private FragmentManager childFragmentManager;
    private int position, newPosition;
    private DataRankTwoBean.ContentBeanX.RoundsBean.ContentBean content;
    private DataRankTwoAdapter dataRankTwoAdapter;
    private DataPersonTabBean dataPersonTabBean;
    private DataScheduleBean dataScheduleBean;
    private DataRankThreeBean dataRankThreeBean;
    private DataRankTwoBean dataRankTwoBean;
    private DataRankThreeAdapter dataRankThreeAdapter;
    private OptionsPickerView<String> build;
    private DataScheduleBean.ContentBean content1;
    private String murl;
    private DataRankStandingAdapter dataRankStandingAdapter;
    private RankInfo dataStandingBean;
        /**
         *
     * @param position
     * @param url
     * @return
     */
    public static Fragment_Data_Small_Click go2Fragment(int position, String url) {
        Fragment_Data_Small_Click fragment_data_small_click = new Fragment_Data_Small_Click();
        Bundle bundle = new Bundle();
        bundle.putString(URL, url);
        bundle.putInt(POSITION, position);
        fragment_data_small_click.setArguments(bundle);
        return fragment_data_small_click;
    }

    /**
     * @param type    区分
     * @param objects
     */
    @Override
    public void onSuccess(int type, Object[] objects) {

    }

    /**
     * @param e
     */
    @Override
    public void onFaile(Throwable e) {

    }

    @Override
    protected Object initModel() {
        return null;
    }

    @Override
    protected BasePublicPresenter initPresenter() {
        return new BasePublicPresenter();
    }

    @Override
    protected void initListener() {
        if (murl.contains("person") || murl.contains("team")) {
            mSmart.setEnableRefresh(false);
        } else
            mSmart.setOnRefreshListener(new OnRefreshListener() {
                @Override
                public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                    if (content1 != null)
                        NetMessage(content1.getRounds().get(newPosition).getUrl());
                    else ToastUtil.showShort("请求错误");
                    mSmart.finishRefresh();
                }
            });

        mVtab.addOnTabSelectedListener(new VerticalTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabView tab, int position) {
//                TabView tabView2 = mVtab.getTabAt(position);
//                TabView tabView22 = tabView2.getTabView();
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                    tabView22.setBackground(getActivity().getDrawable(R.color.c_e7e7e7));
//                }
//                for (int i = 0; i < mVtab.getTabCount(); i++) {
//                    TabView tabAt = mVtab.getTabAt(i);
//                    TabView tabView = tabAt.getTabView();
//                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                        tabView.setBackground(getActivity().getDrawable(R.color.c_e7e7e7));
//                    }
//                    if (i == position) {
//                       continue;
//                    } else {
//                        TabView tabView1 = tab.getTabView();
//                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                            tabView1.setBackground(getActivity().getDrawable(R.color.c_fff));
//                        }
//                    }
//                }
                SwitchFragment(position);
            }

            @Override
            public void onTabReselected(TabView tab, int position) {

            }
        });
    }
    /**
     * standing  排名
     * person   球员
     * team     球队
     * schedule  赛程
     */
    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        clear();
        if (getArguments() != null) ;
        String url = getArguments().getString(URL);
        position = getArguments().getInt(POSITION, 0);
        mRlvData.setLayoutManager(new LinearLayoutManager(getContext()));
        // 适配器
        rlvDataRankAdapter = new RlvDataRankAdapter(matchesBeans);
        dataRankTwoAdapter = new DataRankTwoAdapter(dataBeans);
        dataRankThreeAdapter = new DataRankThreeAdapter(dataBeanXES);
        dataRankStandingAdapter = new DataRankStandingAdapter(dataStandingBeans);
        NetMessage(url);
        initViews();
    }
    @Override
    protected int getFragmentLayoutId() {
        childFragmentManager = getChildFragmentManager();
        return R.layout.fragment_data_small_click;
    }

    /**
     * 网络请求数据
     *
     * @param pUrl
     */
    private void NetMessage(final String pUrl) {
        if (pUrl == null) {
            return;
        }
        murl = pUrl;
        new OkHttpClient().newCall(new Request.Builder().url(murl).build()).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final Gson gson = new Gson();
                final String body = response.body().string();
                if (murl == null) return;
                if (murl.contains("standing")) {
                    if (position == 1 ) {
                        dataStandingBean = gson.fromJson(body, RankInfo.class);
                    } else if (position == 3) {
                        dataRankThreeBean = gson.fromJson(body, DataRankThreeBean.class);
                    } else {
                        dataRankTwoBean = gson.fromJson(body, DataRankTwoBean.class);
                    }
                } else if (murl.contains("person") || murl.contains("team")) {
                    dataPersonTabBean = gson.fromJson(body, DataPersonTabBean.class);
                } else if (murl.contains("schedule")) {
                    dataScheduleBean = gson.fromJson(body, DataScheduleBean.class);
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        RequestSuccessSetting(murl);
                    }
                });
            }
        });
    }

    /**
     *
     */
    private void initViews() {
        if (murl.contains("person") || murl.contains("team")) {
            if (mLlVtabViewpage.getVisibility() == View.GONE) {
                mLlVtabViewpage.setVisibility(View.VISIBLE);
                mRlvData.setVisibility(View.GONE);
            }
            mRlvData.setAdapter(rlvDataRankAdapter);
        }

        if (murl.contains("standing")) {
            if (mLlSchedule.getVisibility() == View.VISIBLE) mLlSchedule.setVisibility(View.GONE);
            if (position == 1) {
                if (position == 1) {
                    if (mTvDescription.getVisibility() == View.GONE)
                        mTvDescription.setVisibility(View.VISIBLE);
                    mRlvData.setAdapter(dataRankStandingAdapter);
                }
            } else if (position == 3) {
                mLlHeader.setVisibility(View.GONE);
                mRlvData.setAdapter(dataRankThreeAdapter);
                mRlvData.addItemDecoration(new DividerItemDecoration(BaseApp.getInstance(), DividerItemDecoration.VERTICAL));
            } else {
                mLlHeader.setVisibility(View.VISIBLE);
                mRlvData.setAdapter(dataRankTwoAdapter);
            }
        }

        if (murl.contains("schedule")) {
            if (mLlSchedule.getVisibility() == View.GONE) mLlSchedule.setVisibility(View.VISIBLE);
            mRlvData.setAdapter(rlvDataRankAdapter);
        }
    }

    /**
     * 请求成功设置数据
     *
     * @param url 地址
     */

    private void RequestSuccessSetting(String url) {
        if (url.contains("standing")) {
            if (position == 1 || position == 2) {
                if (position == 1) {
                    mTvDescription.setText(dataStandingBean.getContent().getDescription());
                    dataStandingBeans.addAll(dataStandingBean.getContent().getRounds());
                    dataRankStandingAdapter.notifyDataSetChanged();
                }
            } else if (position == 3) {
                if (dataRankThreeBean != null) dataBeanXES.clear();
                for (int i = 0; i < dataRankThreeBean.getContent().getRounds().size(); i++) {
                    dataBeanXES.addAll(dataRankThreeBean.getContent().getRounds().get(i).getContent().getData());
                }
                dataRankThreeAdapter.notifyDataSetChanged();
            } else {
                if (dataRankTwoBean != null) dataBeans.clear();
                List<DataRankTwoBean.ContentBeanX.RoundsBean> rounds = dataRankTwoBean.getContent().getRounds();

                for (int i = 0; i < rounds.size(); i++) {
                    content = rounds.get(i).getContent();
                }
                dataBeans.addAll(content.getData());
                dataRankTwoAdapter.notifyDataSetChanged();
                List<String> header = content.getHeader();

                if (header != null) ;
                mTvHeader1.setText(header.get(0));
                mTvHeader2.setText(header.get(1));
                mTvHeader3.setText(header.get(2));
                mTvHeader4.setText(header.get(3));
            }
        }
        if (url.contains("person") || url.contains("team")) {
            final List<DataPersonTabBean.ContentBean.DataBean> data = dataPersonTabBean.getContent().getData();
            if (dataPersonTabBean != null)
                for (int i = 0; i < data.size(); i++) {
                    fragments.add(Fragment_Data_Small_Click_Fragment.go2Fragment(data.get(i).getUrl()));
                }
            mVtab.setTabAdapter(new TabAdapter() {
                @Override
                public int getCount() {
                    return data.size();
                }

                @Override
                public ITabView.TabBadge getBadge(int position) {
                    return null;
                }

                @Override
                public ITabView.TabIcon getIcon(int position) {
                    return null;
                }

                @Override
                public ITabView.TabTitle getTitle(int position) {
                    return new ITabView.TabTitle.Builder()
                            .setContent(data.get(position).getName())
                            .setTextColor(ContextCompat.getColor(BaseApp.getInstance(), R.color.c_e34536), ContextCompat.getColor(BaseApp.getInstance(), R.color.c_222))
                            .setTextSize(14)
                            .build();
                }

                @Override
                public int getBackground(int position) {
                    return 0;
                }
            });
            ShowDefaultFragment();
        }

        if (url.contains("schedule")) {
            if (matchesBeans != null) matchesBeans.clear();
            content1 = dataScheduleBean.getContent();
            matchesBeans.addAll(content1.getMatches());
            rlvDataRankAdapter.notifyDataSetChanged();
            for (int i = 0; i < content1.getRounds().size(); i++) {
                titles.add(content1.getRounds().get(i).getName());
                if (content1.getRounds().get(i).isCurrent()) {
                    newPosition = i;
                }
            }
            //TODO:上一轮下一轮
            /**
             *  下一轮
             */
            if (newPosition == content1.getRounds().size() - 1) {
                mTvNext.setVisibility(View.INVISIBLE);
            } else {
                mTvNext.setVisibility(View.VISIBLE);
                mTvNext.setText(content1.getNext());
            }
            /**
             *  上一轮
             */
            if (newPosition == 0) {
                mTvPrev.setVisibility(View.INVISIBLE);
            } else {
                mTvPrev.setVisibility(View.VISIBLE);
                mTvPrev.setText(content1.getPrev());
            }
            mTvRoundName.setText(content1.getRounds().get(newPosition).getName());
            if (build == null) ;
            build = new OptionsPickerBuilder(getContext(), new OnOptionsSelectListener() {
                @Override
                public void onOptionsSelect(int options1, int options2, int options3, View v) {
                    mTvRoundName.setText(titles.get(options1));
                    NetMessage(content1.getRounds().get(options1).getUrl());
                }
            }).build();
            build.setPicker(titles);
        }
        if (mSmart.finishRefresh() != null) mSmart.finishRefresh(1000);
    }

    /**
     * 清除数据
     */
    private void clear() {
        FragmentTransaction transaction = childFragmentManager.beginTransaction();
        for (int i = 0; i < fragments.size(); i++) {
            transaction.remove(fragments.get(i));
        }
        transaction.commit();
    }

    /**
     * Fragment 切换
     *
     * @param position
     */
    private void SwitchFragment(int position) {
        FragmentTransaction transaction = childFragmentManager.beginTransaction();
        if (!fragments.get(position).isAdded()) {
            transaction.add(R.id.container, fragments.get(position));
        } else {
            transaction.replace(R.id.container, fragments.get(position));
        }
        transaction.commitAllowingStateLoss();
    }

    /**
     * 首次进行选中默认Fragment
     */
    private void ShowDefaultFragment() {
        FragmentTransaction transaction = childFragmentManager.beginTransaction();
        if (!fragments.get(0).isAdded()) {
            transaction.add(R.id.container, fragments.get(0));
        }
        transaction.commitAllowingStateLoss();
    }

    /**
     * 点击事件监听
     *
     * @param v
     */
    @OnClick({R.id.tv_prev, R.id.tv_round_name, R.id.tv_next})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_prev:
                if (null != content1.getRounds() && newPosition != 0)
                    NetMessage(content1.getRounds().get(newPosition - 1).getUrl());
                break;
            case R.id.tv_round_name:
                build.show();
                break;
            case R.id.tv_next:
                if (null != content1.getRounds() && newPosition != content1.getRounds().size() - 1)
                    NetMessage(content1.getRounds().get(newPosition + 1).getUrl());
                break;
        }
    }
    /*
     * java.lang.IllegalStateException: Can not perform this action after onSaveInstanceState
     *  将事物添加Fragment提交 commit() 方法 换成 commitAllowStateLoss()
     */

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (murl !=null) murl = null;
    }
}
