package com.sport.sportproject.ui.fragment_data;

import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.sport.sportproject.R;
import com.sport.sportproject.base.BaseFragment;
import com.sport.sportproject.base.BasePublicPresenter;
import com.sport.sportproject.base.PublicView;
import com.sport.sportproject.bean.bean.data.DataTabBean;
import com.sport.sportproject.interfaces.Params;
import com.sport.sportproject.ui.fragment_data.adapter.DataVpAdapter;
import com.sport.sportproject.ui.fragment_data.fragment.Fragment_Data_Click;
import com.sport.sportproject.ui.fragment_data.model.Fragment_Data_Model;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
public class Fragment_Data extends BaseFragment<BasePublicPresenter, Fragment_Data_Model> implements PublicView {
    //TODO:数据Activity
    @BindView(R.id.smartTab)
    SmartTabLayout mSmartTab;
    @BindView(R.id.viewpage)
    ViewPager mViewpage;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private List<DataTabBean.DataTabsBean> data_tabs;

    @Override
    public void onSuccess(int type, Object[] objects) {
        switch (type) {
            case Params.REQUEST_ONE:
                DataTabBean dataTabBean = (DataTabBean) objects[0];
                if (dataTabBean != null) {
                    data_tabs = dataTabBean.getData_tabs();
                    for (int i = 0; i < data_tabs.size(); i++) {
                        DataTabBean.DataTabsBean dataTabsBean = data_tabs.get(i);
                        fragments.add(Fragment_Data_Click.go2Fragment(dataTabsBean.getPosition(), dataTabsBean.getSeason(),
                                (ArrayList<DataTabBean.DataTabsBean.SubTabsBean>) dataTabsBean.getSub_tabs()));
                    }
                    mViewpage.setAdapter(new DataVpAdapter(getChildFragmentManager(), dataTabBean.getData_tabs(), fragments));
                    mSmartTab.setViewPager(mViewpage);
                }
                break;
        }
//        loadingDialog.dismiss();
    }

    @Override
    public void onFaile(Throwable e) {

    }

    @Override
    protected Fragment_Data_Model initModel() {
        return new Fragment_Data_Model();
    }

    @Override
    protected BasePublicPresenter initPresenter() {
        return new BasePublicPresenter();
    }

    @Override
    protected void initListener() {
        mSmartTab.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int size = data_tabs.size();
                TextView tabAt = (TextView) mSmartTab.getTabAt(position);
                tabAt.setTextColor(getContext().getResources().getColor(R.color.c_000));
                tabAt.setTextSize(10);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    tabAt.setTextAppearance(R.style.tab_text_style);
                }
                for (int i = 0; i < size; i++) {
                    if (i == position) {
                        continue;
                    } else {
                        TextView tabAt1 = (TextView) mSmartTab.getTabAt(i);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            tabAt1.setTextAppearance(R.style.tab_text_style);
                        }
                        tabAt1.setTextColor(getContext().getResources().getColor(R.color.c_e34536));
                        tabAt1.setTextSize(10);
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
//        loadingDialog.show();
        mPresenter.getData(Params.REQUEST_ONE);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_data;
    }


}
