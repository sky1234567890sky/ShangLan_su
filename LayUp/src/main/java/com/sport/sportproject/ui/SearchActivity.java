package com.sport.sportproject.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.sport.sportproject.R;
import com.sport.sportproject.base.BaseMvpActivity;
import com.sport.sportproject.base.BasePresenter;
import com.sport.sportproject.utils.StatusBarUtil;

import butterknife.BindView;
import butterknife.OnClick;
//首届面的搜索界面
public class SearchActivity extends BaseMvpActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.et_input_search_message)
    EditText mEtInputSearchMessage;
    @BindView(R.id.tv_start_search)
    TextView mTvStartSearch;

    public static void go2Activity(Context context) {
        Intent intent = new Intent(context, SearchActivity.class);
        context.startActivity(intent);
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
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        StatusBarUtil.setStatusBarColor(this, R.color.c_e34536);
    }

    @Override
    protected int getActivityLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    public void onSuccess(int type, Object[] objects) {

    }

    @Override
    public void onFaile(Throwable e) {

    }


    @OnClick(R.id.tv_start_search)
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_start_search:

                break;
        }
    }
}
