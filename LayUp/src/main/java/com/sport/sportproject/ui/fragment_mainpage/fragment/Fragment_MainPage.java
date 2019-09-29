package com.sport.sportproject.ui.fragment_mainpage.fragment;

import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.sport.sportproject.R;
import com.sport.sportproject.base.BaseFragment;
import com.sport.sportproject.base.BasePublicPresenter;
import com.sport.sportproject.base.PublicView;
import com.sport.sportproject.bean.bean.mainpage.MainPageTabBean;
import com.sport.sportproject.interfaces.Params;
import com.sport.sportproject.ui.fragment_mainpage.adapter.TabLayout_Adapter;
import com.sport.sportproject.ui.fragment_mainpage.model.Fragment_MainPage_Model;
import com.sport.sportproject.ui.fragment_match.net.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class Fragment_MainPage extends BaseFragment<BasePublicPresenter, Fragment_MainPage_Model> implements PublicView {
    @BindView(R.id.smartTab)
    SmartTabLayout mSmartTab;
    @BindView(R.id.viewpage)
    ViewPager mViewpage;
    private ArrayList<MainPageTabBean.DataBean.ListBean> listBeans = new ArrayList<>();
    private ArrayList<Fragment> fragments = new ArrayList<>();

    /**
     *
     * @param type 区分
     * @param objects
     */

    @Override
    public void onSuccess(int type, Object[] objects) {
        switch (type) {
            case Params.REQUEST_ONE:
                MainPageTabBean bean = (MainPageTabBean) objects[0];
                listBeans.addAll(bean.getData().getList());
                AddFragment(bean);
                break;
        }
    }
    /**
     *
     * @param e
     */
    @Override
    public void onFaile(Throwable e) {
        ToastUtil.showLong(e.getMessage());
    }

    /**
     *
     * @param bean
     */
    private void AddFragment(MainPageTabBean bean) {
        List<MainPageTabBean.DataBean.ListBean> list = bean.getData().getList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getType().equals("hot")) {
                HotFragment fragment = HotFragment.go2Fragment(list.get(i).getId(), list.get(i).getType());
                fragments.add(fragment);
            } else {
                Fragment_MainPage_Chick fragment_mainPage_chick = Fragment_MainPage_Chick.go2Fragment(list.get(i).getId(), list.get(i).getType());
                fragments.add(fragment_mainPage_chick);
            }
        }
        TabLayout_Adapter tabLayout_adapter = new TabLayout_Adapter(getChildFragmentManager(), listBeans, fragments);
        mViewpage.setAdapter(tabLayout_adapter);
        mSmartTab.setViewPager(mViewpage);
        mViewpage.setCurrentItem(1);
        tabLayout_adapter.notifyDataSetChanged();
    }

    /**
     * @return Fragment_MainPage_Model
     */
    @Override
    protected Fragment_MainPage_Model initModel() {
        return new Fragment_MainPage_Model();
    }
    /**
     * @return BasePublicPresenter
     */
    @Override
    protected BasePublicPresenter initPresenter() {
        return new BasePublicPresenter();
    }
    @Override
    protected void initListener() {

        mSmartTab.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                TextView tabAt = (TextView) mSmartTab.getTabAt(position);
                tabAt.setTextColor(getContext().getResources().getColor(R.color.c_fff));
                tabAt.setTextSize(14);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    tabAt.setTextAppearance(R.style.tab_text_style);
                }
                for (int i = 0; i < listBeans.size(); i++) {
                    if (i == position) {
                        continue;
                    } else {
                        TextView tabAt1 = (TextView) mSmartTab.getTabAt(i);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            tabAt1.setTextAppearance(R.style.tab_text_style);
                        }
                        tabAt1.setTextColor(getContext().getResources().getColor(R.color.c_fff));
                        tabAt1.setTextSize(12);
                    }
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void initData() {
        mPresenter.getData(Params.REQUEST_ONE);
    }
    @Override
    protected void initView() {
    }
    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_mainpage;
    }
}
