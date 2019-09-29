package com.sport.sportproject.ui.fragment_data.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.sport.sportproject.R;
import com.sport.sportproject.base.BaseApp;
import com.sport.sportproject.base.BaseFragment;
import com.sport.sportproject.base.BasePresenter;
import com.sport.sportproject.bean.bean.data.DataPlayerBean;
import com.sport.sportproject.bean.bean.data.DataTeamBean;
import com.sport.sportproject.ui.fragment_data.adapter.RlvPlayerAdapter;
import com.sport.sportproject.ui.fragment_data.adapter.RlvTeamAdapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
public class Fragment_Data_Small_Click_Fragment extends BaseFragment {
    private static final String URL = "url";
    @BindView(R.id.rlv)
    RecyclerView mRlv;
    @BindView(R.id.tv_rank)
    TextView mTvRank;
    @BindView(R.id.tv_team_name)
    TextView mTvTeamName;
    @BindView(R.id.tv_value)
    TextView mTvValue;
    @BindView(R.id.smart)
    SmartRefreshLayout mSmart;
    @BindView(R.id.rl)
    LinearLayout mRl;
    private String url;
    private ArrayList<DataPlayerBean.ContentBean.DataBean> dataBeans = new ArrayList<>();
    private ArrayList<DataTeamBean.ContentBean.DataBean> teamBeans = new ArrayList<>();
    private RlvPlayerAdapter rlvPlayerAdapter;
    private RlvTeamAdapter rlvTeamAdapter;
    private DataPlayerBean dataPlayerBean;
    private DataTeamBean dataTeamBean;

    /**
     * @param url
     * @return
     */
    public static Fragment_Data_Small_Click_Fragment go2Fragment(String url) {
        Fragment_Data_Small_Click_Fragment fragment_data_small_click_fragment = new Fragment_Data_Small_Click_Fragment();
        Bundle bundle = new Bundle();
        bundle.putString(URL, url);
        fragment_data_small_click_fragment.setArguments(bundle);
        return fragment_data_small_click_fragment;
    }
    @Override
    public void onSuccess(int type, Object[] objects) {

    }

    @Override
    public void onFaile(Throwable e) {

    }

    @Override
    protected Object initModel() {
        return null;
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initListener() {
        mSmart.setEnableLoadMore(false);
        mSmart.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                initData();
            }
        });
    }

    /**
     * 请求数据
     */
    @Override
    protected void initData() {

        new OkHttpClient().newCall(new Request.Builder().url(url).build()).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(final Call call, Response response) throws IOException {
                final Gson gson = new Gson();
                final String body = response.body().string();
                if (url.contains("person_ranking")) {
                    dataPlayerBean = gson.fromJson(body, DataPlayerBean.class);
                } else if (url.contains("team_ranking")) {
                    dataTeamBean = gson.fromJson(body, DataTeamBean.class);
                }
                if (getActivity() == null) return;
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (url.contains("person_ranking")) {
                                if (dataPlayerBean != null) dataBeans.clear();
                                DataPlayerBean.ContentBean content = dataPlayerBean.getContent();
                                dataBeans.addAll(content.getData());
                                rlvPlayerAdapter.notifyDataSetChanged();
                                List<String> header = content.getHeader();
                                mTvRank.setText(header.get(0));
                                mTvTeamName.setText(header.get(1));
                                mTvValue.setText(header.get(2));
                            }

                            if (url.contains("team_ranking")) { // 球队
                                if (dataTeamBean != null) teamBeans.clear();
                                DataTeamBean.ContentBean content = dataTeamBean.getContent();
                                teamBeans.addAll(content.getData());
                                rlvTeamAdapter.notifyDataSetChanged();
                                if (content != null) {
                                    mTvRank.setText(content.getHeader().get(0));
                                    mTvValue.setText(content.getHeader().get(1));
                                }
                            }
                            mSmart.finishRefresh(1000);
                        }
                    });
            }
        });
    }

    @Override
    protected void initView() {
        // 1. 获取传输数据
        if (getArguments() != null) url = getArguments().getString(URL);
        mRlv.setLayoutManager(new LinearLayoutManager(BaseApp.getInstance()));
        rlvPlayerAdapter = new RlvPlayerAdapter(dataBeans);
        rlvTeamAdapter = new RlvTeamAdapter(teamBeans);

        if (url == null) return;
        // 球员
        if (url.contains("person_ranking")) {
            mRlv.setAdapter(rlvPlayerAdapter);
        } else if (url.contains("team_ranking")) { // 球队
            if (mRl.getVisibility() == View.VISIBLE) {
                mTvTeamName.setVisibility(View.GONE);
            }
            mRlv.setAdapter(rlvTeamAdapter);
        }
        mRlv.addItemDecoration(new DividerItemDecoration(BaseApp.getInstance(), DividerItemDecoration.VERTICAL));
    }
    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_data_small_click_fragment;
    }

}
