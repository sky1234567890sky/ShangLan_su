package com.sport.sportproject.ui.fragment_data.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.sport.sportproject.R;
import com.sport.sportproject.base.BaseFragment;
import com.sport.sportproject.base.BasePublicPresenter;
import com.sport.sportproject.base.PublicView;
import com.sport.sportproject.bean.bean.data.DataSeasonBean;
import com.sport.sportproject.bean.bean.data.DataTabBean;
import com.sport.sportproject.interfaces.Params;
import com.sport.sportproject.ui.fragment_data.model.Fragment_Data_Model;
import com.sport.sportproject.ui.fragment_match.net.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
public class Fragment_Data_Click extends BaseFragment<BasePublicPresenter, Fragment_Data_Model> implements PublicView {

    private static final String LIST = "list";
    private static final String BEAN = "bean";
    private static final String POSITION = "position";

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.tab)
    TabLayout mTab;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private FragmentManager manager;
    private int position;
    private OptionsPickerView<String> pickerView;
    private ArrayList<DataTabBean.DataTabsBean.SubTabsBean> subTabsBeans;
    private ArrayList<String> prckerLists = new ArrayList<>();
    private int mPosition;
    private DataTabBean.DataTabsBean.SeasonBean seasonBean;
    private ArrayList<DataSeasonBean> dataSeasonBeans;
    /**
     *
     * @param position
     * @param bean
     * @param list
     * @return
     */
    public static Fragment_Data_Click go2Fragment(int position, DataTabBean.DataTabsBean.SeasonBean bean, ArrayList<DataTabBean.DataTabsBean.SubTabsBean> list) {
        Fragment_Data_Click fragment_data_click = new Fragment_Data_Click();
        Bundle bundle = new Bundle();
        bundle.putInt(POSITION, position);
        bundle.putParcelable(BEAN, bean);
        bundle.putParcelableArrayList(LIST, list);
        fragment_data_click.setArguments(bundle);
        return fragment_data_click;
    }
    /**
     * @param type 区分
     * @param objects
     */

    @Override
    public void onSuccess(int type, Object[] objects) {
        switch (type) {
            case Params.REQUEST_TWO:
                dataSeasonBeans = (ArrayList<DataSeasonBean>) objects[0];
                if (dataSeasonBeans != null) {
                    if (prckerLists !=null) prckerLists.clear();
                    for (int i = 0; i < dataSeasonBeans.size(); i++) {
                        prckerLists.add(dataSeasonBeans.get(i).getSeason_name());
                    }
                    // 选择器
                    pickerView = new OptionsPickerBuilder(getContext(), new OnOptionsSelectListener() {
                        @Override
                        public void onOptionsSelect(int options1, int options2, int options3, View v) {
                            String season_name = prckerLists.get(options1);
                            mTvTitle.setText(season_name);
                            List<DataSeasonBean.SubTabsBean> sub_tabs = dataSeasonBeans.get(options1).getSub_tabs();
                            mTab.removeAllTabs();
                            fragments.clear();
                            for (int i = 0; i < sub_tabs.size(); i++) {
                                fragments.add(Fragment_Data_Small_Click.go2Fragment(position, sub_tabs.get(i).getUrl()));
                                mTab.addTab(mTab.newTab().setText(sub_tabs.get(i).getTitle()));
                            }
                        }
                    }).build();
                    pickerView.setPicker(prckerLists);
                    pickerView.show();
                }
                break;
        }
    }

    /**
     *
     * @param e
     */
    @Override
    public void onFaile(Throwable e) {
        ToastUtil.showShort(e.getMessage());
    }


    /**
     *
     * @return Fragment_Data_Model
     */
    @Override
    protected Fragment_Data_Model initModel() {
        return new Fragment_Data_Model();
    }

    /**
     *
     * @return BasePublicPresenter
     */
    @Override
    protected BasePublicPresenter initPresenter() {
        return new BasePublicPresenter();
    }

    /**
     *  InitListener
     */
    @Override
    protected void initListener() {
        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                SwitchFragment(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    /**
     *  InitData
     */
    @Override
    protected void initData() {

    }

    /**
     *   InitView
     */
    @Override
    protected void initView() {
//        clear();
        position = getArguments().getInt(POSITION, 0);
        seasonBean = getArguments().getParcelable(BEAN);
        subTabsBeans = getArguments().getParcelableArrayList(LIST);
        for (int i = 0; i < subTabsBeans.size(); i++) {
            mTab.addTab(mTab.newTab().setText(subTabsBeans.get(i).getTitle()));
            fragments.add(Fragment_Data_Small_Click.go2Fragment(position, subTabsBeans.get(i).getUrl()));
        }
        mTvTitle.setText(seasonBean.getTitle());
        ShowDefaultFragment();
    }

    private void clear() {
        FragmentTransaction transaction = manager.beginTransaction();
        for (int i = 0; i < fragments.size(); i++) {
            transaction.remove(fragments.get(i));
        }
        transaction.commit();
    }
    @Override
    protected int getFragmentLayoutId() {
        manager = getChildFragmentManager();
        return R.layout.fragment_data_click;
    }
    /**
     * @param position
     */
    private void SwitchFragment(int position) {
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.remove(fragments.get(mPosition)).replace(R.id.container,fragments.get(position));
        fragmentTransaction.commitAllowingStateLoss();
        mPosition = position;
    }
    /**
     *
     */
    private void ShowDefaultFragment() {
        FragmentTransaction transaction = manager.beginTransaction();
        if (!fragments.get(0).isAdded()) {
            transaction.add(R.id.container, fragments.get(0));
        } else {
            transaction.replace(R.id.container, fragments.get(0));
        }
        transaction.commitAllowingStateLoss();
    }
    @OnClick(R.id.tv_title)
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_title:
                mPresenter.getData(Params.REQUEST_TWO, seasonBean.getUrl());
                break;
        }
    }
}
