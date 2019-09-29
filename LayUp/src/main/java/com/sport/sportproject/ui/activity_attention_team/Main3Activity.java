package com.sport.sportproject.ui.activity_attention_team;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.sport.sportproject.R;
import com.sport.sportproject.base.BaseMvpActivity;
import com.sport.sportproject.base.BasePublicPresenter;
import com.sport.sportproject.bean.bean.team.FavTeamBean;
import com.sport.sportproject.interfaces.Params;
import com.sport.sportproject.ui.activity_main.MainActivity;
import com.sport.sportproject.utils.SharedPreferencesUtils;
import com.sport.sportproject.utils.SlideBackLayout;
import com.sport.sportproject.utils.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;

public class Main3Activity extends BaseMvpActivity<BasePublicPresenter, Fragment_FavTeam_Model> {

    private static final String FIRSI = "first";

    @BindView(R.id.tv_toolbar)
    TextView mTvToolbar;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.viewpage)
    ViewPager mViewpage;
    @BindView(R.id.tv_affirm)
    TextView mTvAffirm;
    @BindView(R.id.smarttab)
    SmartTabLayout mGuanzhuSmarttab;
    private ArrayList<String> titles;
    private ArrayList<Fragment> fragments = new ArrayList<>();

    @Override
    protected Fragment_FavTeam_Model initModel() {
        return new Fragment_FavTeam_Model();
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
                Finish();
            }
        });
    }

    @Override
    protected void initData() {
        mPresenter.getData(Params.REQUEST_ONE);
    }

    @Override
    protected void initView() {
        String hot = (String) SharedPreferencesUtils.getParam(FIRSI, "hot");
        if (hot.equals("hot")) {
            mTvToolbar.setText(R.string.select_you_like_team);
        } else {
            mTvToolbar.setText(R.string.fav_team);
        }
        StatusBarUtil.setStatusBarColor(this, R.color.c_e34536);
        SlideBackLayout slideBackLayout = new SlideBackLayout(this);
        slideBackLayout.bind();
        initTitle();
    }
    @Override
    protected int getActivityLayoutId() {
        return R.layout.activity_attention_team;
    }

    private void initTitle() {
        mToolbar.setTitle("");
        mToolbar.setNavigationIcon(R.drawable.back);
        setSupportActionBar(mToolbar);
        titles = new ArrayList<>();
    }
    @Override
    public void onSuccess(int type, Object[] objects) {
        switch (type) {
            case Params.REQUEST_ONE:
                FavTeamBean favTeamEntity = (FavTeamBean) objects[0];
                ArrayList<String> selected_teams = favTeamEntity.getSelected_teams();
                for (int i = 0; i < favTeamEntity.getTeam_list().size(); i++) {
                    List<FavTeamBean> list = favTeamEntity.getTeam_list().get(i).getList();
                    Fragment_FavTeam fragment_favTeam = Fragment_FavTeam.go2Fragment((ArrayList<FavTeamBean>) list, selected_teams);
                    fragments.add(fragment_favTeam);
                    titles.add(favTeamEntity.getTeam_list().get(i).getTitle());
                }
                FavTeamVpAdapter favTeamVpAdapter = new FavTeamVpAdapter(getSupportFragmentManager(), fragments, titles);
                if (favTeamEntity != null) {
                    mViewpage.setAdapter(favTeamVpAdapter);
                    mGuanzhuSmarttab.setViewPager(mViewpage);
                }
                break;
        }
    }

    @Override
    public void onFaile(Throwable e) {

    }


    private void Finish() {
        startActivity(new Intent(Main3Activity.this, MainActivity.class));
        finish();
        overridePendingTransition(R.anim.enter_left, R.anim.exit_right);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Finish();
    }

}
