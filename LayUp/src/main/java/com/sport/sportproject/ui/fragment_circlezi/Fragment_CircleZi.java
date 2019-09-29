package com.sport.sportproject.ui.fragment_circlezi;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.TextView;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.sport.sportproject.R;
import com.sport.sportproject.base.BaseFragment;
import com.sport.sportproject.base.BasePublicPresenter;
import com.sport.sportproject.base.PublicView;
import com.sport.sportproject.interfaces.Params;
import com.sport.sportproject.ui.fragment_circlezi.adapter.CircleVpAdapter;
import com.sport.sportproject.ui.fragment_circlezi.bean.CircleTabBean;
import com.sport.sportproject.ui.fragment_circlezi.fragment.Fragment_CircleZi_Focus;
import com.sport.sportproject.ui.fragment_circlezi.fragment.Fragment_CircleZi_Normal;
import com.sport.sportproject.ui.fragment_circlezi.fragment.Fragment_CircleZi_Topic;
import com.sport.sportproject.ui.fragment_circlezi.model.Fragment_CircleZi_Model;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
public class Fragment_CircleZi extends BaseFragment<BasePublicPresenter, Fragment_CircleZi_Model> implements PublicView {
    @BindView(R.id.smartTab)
    SmartTabLayout mSmartTab;
    @BindView(R.id.viewpage)
    ViewPager mViewpage;

    private ArrayList<Fragment> fragments = new ArrayList<>();
    private ArrayList<CircleTabBean.DataBean.ListBean> dataBeans = new ArrayList<>();
    private Fragment_CircleZi_Focus fragmentFocus;
    private Fragment_CircleZi_Normal fragmentNormal;
    private Fragment_CircleZi_Topic fragmentTopic;
    private CircleVpAdapter circleVpAdapter;
    //TODO:圈子总Fragment
    @Override
    public void onSuccess(int type, Object[] objects) {
        switch (type) {
            case Params.REQUEST_ONE:
                CircleTabBean circleTabBean = (CircleTabBean) objects[0];
                List<CircleTabBean.DataBean.ListBean> list = circleTabBean.getData().getList();
                dataBeans.addAll(list);
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getType().equals("fav")) {
                        fragmentFocus = Fragment_CircleZi_Focus.get2FragmentFocus();
                        fragments.add(fragmentFocus);
                    } else if (list.get(i).getType().equals("normal")) {
                        fragmentNormal = Fragment_CircleZi_Normal.get2FragmentNormal(i);
                        fragments.add(fragmentNormal);
                    } else {
                        fragmentTopic = Fragment_CircleZi_Topic.get2FragmentTopic();
                        fragments.add(fragmentTopic);
                    }
                }
                circleVpAdapter = new CircleVpAdapter(getChildFragmentManager(), fragments, dataBeans);
                if (circleVpAdapter != null){
                    mViewpage.setAdapter(circleVpAdapter);
                    mSmartTab.setViewPager(mViewpage);
                    circleVpAdapter.notifyDataSetChanged();
                    mViewpage.setCurrentItem(1);
                }
                break;
        }
    }
    @Override
    public void onFaile(Throwable e) {

    }
    @Override
    protected Fragment_CircleZi_Model initModel() {
        return new Fragment_CircleZi_Model();
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
                int size = dataBeans.size();
                TextView tabAt = (TextView) mSmartTab.getTabAt(position);
                tabAt.setTextColor(getContext().getResources().getColor(R.color.c_e34536));
                tabAt.setTextSize(14);
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
                        tabAt1.setTextColor(getContext().getResources().getColor(R.color.c_222));
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
        return R.layout.fragment_circlezi;
    }

}
