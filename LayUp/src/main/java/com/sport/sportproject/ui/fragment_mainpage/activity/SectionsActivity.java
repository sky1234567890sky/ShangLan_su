package com.sport.sportproject.ui.fragment_mainpage.activity;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.sport.sportproject.R;
import com.sport.sportproject.base.BaseApp;
import com.sport.sportproject.base.BaseMvpActivity;
import com.sport.sportproject.base.BasePublicPresenter;
import com.sport.sportproject.base.PublicView;
import com.sport.sportproject.bean.bean.mainpage.SectionsBean;
import com.sport.sportproject.interfaces.LoadConfig;
import com.sport.sportproject.interfaces.Params;
import com.sport.sportproject.ui.fragment_mainpage.adapter.RlvSectionsAdapter;
import com.sport.sportproject.ui.fragment_mainpage.model.SectionsActivity_Model;
import com.sport.sportproject.utils.StatusBarUtil;
import com.sport.sportproject.utils.ToastUtil;
import java.util.ArrayList;
import butterknife.BindView;

//TODO:专题详情
public class SectionsActivity extends BaseMvpActivity<BasePublicPresenter, SectionsActivity_Model> implements PublicView {
    private static final String ID = "Id";
    @BindView(R.id.iv_banner)
    ImageView mIvBanner;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.iv_avatar)
    ImageView mIvAvatar;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.coll_toolbar)
    CollapsingToolbarLayout mCollToolbar;
    @BindView(R.id.appbar)
    AppBarLayout mAppbar;
    @BindView(R.id.rlv_sections)
    RecyclerView mRlvSections;
    @BindView(R.id.tv_description)
    TextView mTvDescription;

    private ArrayList<SectionsBean.DataBean> dataBeans = new ArrayList<>();
    private RlvSectionsAdapter rlvSectionsAdapter;
    private int id;
    public static void go2Activity(Context context, int id) {
        Intent intent = new Intent(context, SectionsActivity.class);
        intent.putExtra(ID, id);
        context.startActivity(intent);
    }
    @Override
    protected SectionsActivity_Model initModel() {
        return new SectionsActivity_Model();
    }
    @Override
    protected BasePublicPresenter initPresenter() {
        return new BasePublicPresenter();
    }

    @Override
    protected void initListener() {
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    @Override
    protected void initData() {
        mPresenter.getData(Params.REQUEST_ONE,id, LoadConfig.NOLOADMORE);
    }
    @Override
    protected void initView() {
        StatusBarUtil.setTranslucentStatus(this);
        id = getIntent().getIntExtra(ID, 0);
        mRlvSections.setLayoutManager(new LinearLayoutManager(BaseApp.getInstance()));
        rlvSectionsAdapter = new RlvSectionsAdapter(dataBeans);
        mRlvSections.setAdapter(rlvSectionsAdapter);
    }

    @Override
    protected int getActivityLayoutId() {
        return R.layout.activity_sections;
    }

    @Override
    public void onSuccess(int type, Object[] objects) {

        switch (type) {
            case Params.REQUEST_ONE:
                SectionsBean sectionsBean = (SectionsBean) objects[0];
                RequestOptions options = new RequestOptions().circleCrop();
                if (sectionsBean != null) {
                    Glide.with(BaseApp.getInstance()).load(sectionsBean.getAvatar()).apply(options).into(mIvAvatar);
                    Glide.with(BaseApp.getInstance()).load(sectionsBean.getBanner()).into(mIvBanner);
                    mTvTitle.setText(sectionsBean.getTitle());
                    mTvDescription.setText(sectionsBean.getDescription());
                    dataBeans.addAll(sectionsBean.getData());
                    rlvSectionsAdapter.notifyDataSetChanged();
                }
                break;
        }
    }

    @Override
    public void onFaile(Throwable e) {
        ToastUtil.showLong(e.getMessage());
    }

}
