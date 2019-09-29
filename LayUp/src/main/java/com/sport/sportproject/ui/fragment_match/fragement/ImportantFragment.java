package com.sport.sportproject.ui.fragment_match.fragement;


import android.annotation.SuppressLint;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.sport.sportproject.R;
import com.sport.sportproject.base.BaseFragment;
import com.sport.sportproject.base.BasePublicPresenter;
import com.sport.sportproject.base.PublicView;
import com.sport.sportproject.bean.bean.team.FavTeamBean;
import com.sport.sportproject.interfaces.Params;
import com.sport.sportproject.ui.fragment_match.adapter.ImportantAdapter;
import com.sport.sportproject.ui.fragment_match.adapter.LeagueAdapter;
import com.sport.sportproject.ui.fragment_match.bean.ImportantBean;
import com.sport.sportproject.ui.fragment_match.bean.LeagueBean;
import com.sport.sportproject.ui.fragment_match.bean.MatchName;
import com.sport.sportproject.ui.fragment_match.model.Fragment_Match_TabItem_Model;
import com.sport.sportproject.ui.fragment_match.net.ToastUtil;
import com.sport.sportproject.utils.LoadingDialog;
import com.sport.sportproject.utils.TimeChangeUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import qdx.stickyheaderdecoration.NormalDecoration;

/**
 * A simple {@link Fragment} subclass.
 */
//重要界面
@SuppressLint("ValidFragment")
public class ImportantFragment extends BaseFragment<BasePublicPresenter, Fragment_Match_TabItem_Model> implements PublicView {
//    LoadingDialog loadingDialog;

    private static final String ID = "id";
    private static final String TYPE = "type";
    private static final String API = "api";
    private String label;
    private String type;
    private String api;
    @BindView(R.id.stickyheader_recyclerview)
    RecyclerView lv;
    @BindView(R.id.match_smart)
    SmartRefreshLayout srl;
    @BindView(R.id.foot_style)
    RelativeLayout foot;

    @BindView(R.id.headler_style)
    MaterialHeader headler;

    @BindView(R.id.guanzhu_rotato)
    ImageView mIv;
    private AnimationDrawable drawable;
    private List<MatchName.DataBean> data = new ArrayList<>();


    @SuppressLint("ValidFragment")
    public ImportantFragment(String label, String type, String api) {
        this.label = label;
        this.type = type;
        this.api = api;
    }

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_important;
    }

    @Override
    protected Fragment_Match_TabItem_Model initModel() {
        return new Fragment_Match_TabItem_Model();
    }

    @Override
    protected BasePublicPresenter initPresenter() {
        return new BasePublicPresenter();
    }

    @Override
    protected void initListener() {
        srl.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {

            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {

            }
        });
    }

    @Override
    protected void initData() {
        loadingDialog.show();
        mPresenter.getData(Params.REQUEST_ONE);//
        initDatas();

    }
    @Override
    public void onSuccess(int type, Object[] objects) {
//        lv.setItemViewCacheSize();类似于缓存
        lv.setLayoutManager(new LinearLayoutManager(getActivity()));
        lv.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        switch (type) {
            case Params.REQUEST_ONE:
                MatchName data1 = (MatchName) objects[0];
                data.addAll(data1.getData());
                break;
            case Params.REQUEST_TWO:
                //隐藏
                foot.setVisibility(View.GONE);
                headler.setVisibility(View.GONE);
                mIv.setVisibility(View.VISIBLE);
                break;
            case Params.REQUEST_THREE:
                final ImportantBean importantBean = (ImportantBean) objects[0];
                ImportantAdapter importantAdapter = new ImportantAdapter(importantBean, data);
                if (data != null) {
                    importantAdapter.setData(data);
                }
                lv.setAdapter(importantAdapter);

                /**
                 * 监听RecyclerView滚动，实现粘性头部
                 */
                NormalDecoration normalDecoration = new NormalDecoration() {
                    @Override
                    public String getHeaderName(int i) {
                        return importantBean.getList().get(i).getStart_play();
                    }
                };
                normalDecoration.setOnDecorationHeadDraw(new NormalDecoration.OnDecorationHeadDraw() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public View getHeaderView(int i) {
                        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.decoration, null);
                        TextView mTv = inflate.findViewById(R.id.tv_decortaion);
                        mTv.setText(importantBean.getList().get(i).getStart_play() + "" + TimeChangeUtils.getWeek(importantBean.getList().get(i).getStart_play()));
                        return inflate;
                    }
                });

                normalDecoration.setHeaderHeight(60);
                normalDecoration.setTextColor(R.color.c_000);
                normalDecoration.setTextSize(R.dimen.dp_13);
                lv.addItemDecoration(normalDecoration);
                break;
            case Params.REQUEST_FOUR:
                final LeagueBean leagueBean = (LeagueBean) objects[0];
                LeagueAdapter leagueAdapter = new LeagueAdapter(leagueBean, data);
//                leagueAdapter.setData(leagueBean);
                if (data != null) {
                    leagueAdapter.setData(data);
                }
                lv.setAdapter(leagueAdapter);
//                Log.i("tag", "leagueBean==》: " + leagueBean.toString());
                NormalDecoration r = new NormalDecoration() {
                    @Override
                    public String getHeaderName(int i) {
                        return leagueBean.getList().get(i).getStart_play();
                    }
                };
                r.setOnDecorationHeadDraw(new NormalDecoration.OnDecorationHeadDraw() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public View getHeaderView(int i) {
                        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.decoration, null);
                        TextView mTv = inflate.findViewById(R.id.tv_decortaion);
                        mTv.setText(leagueBean.getList().get(i).getStart_play() + "" + TimeChangeUtils.getWeek(leagueBean.getList().get(i).getStart_play()));
                        return inflate;
                    }
                });
                r.setHeaderHeight(60);
                r.setTextColor(R.color.c_000);
                r.setTextSize(R.dimen.dp_13);
                lv.addItemDecoration(r);
                break;
        }
        loadingDialog.dismiss();
    }

    @Override
    public void onFaile(Throwable e) {
        ToastUtil.showLong(e.getMessage());
    }

    private static final String TAG = "ImportantFragment";
    public void initDatas() {
        //下面的
//        String bottom = "https://bkbapi.dqdgame.com/data/tab/matchs/max/person?match_ids=[11528,11532,11579,11596,11607,11608,11609,11610,11619,11620]";
        OkHttpClient bild = new OkHttpClient.Builder()
                .build();
        bild.newCall(new Request.Builder().get().url(api).build())
                .enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                    }
                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        final String string = response.body().string();
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                switchData(string);
                            }
                        });
                    }
                });
    }

    @Override
    protected void initView() {
    }

    private void switchData(String string) {

        switch (type) {
            case "favor":
//                //隐藏
                mPresenter.getData(Params.REQUEST_TWO,api);
                break;
            case "important":
                mPresenter.getData(Params.REQUEST_THREE,api);
                break;
            case "league":
                mPresenter.getData(Params.REQUEST_FOUR,api);
                break;
        }
//        loadingDialog.dismiss();
    }
    @Override
    public void onResume() {
        super.onResume();
        drawable = (AnimationDrawable) mIv.getDrawable();
        if (drawable != null) {
            drawable.start();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        drawable.stop();
    }


}
