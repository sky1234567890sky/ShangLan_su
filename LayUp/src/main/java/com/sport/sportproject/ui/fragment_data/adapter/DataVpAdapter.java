package com.sport.sportproject.ui.fragment_data.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.sport.sportproject.bean.bean.data.DataTabBean;

import java.util.ArrayList;
import java.util.List;

/*
 *   梨花带雨,我见优伶
 *      2019/4/29
 */
public class DataVpAdapter extends FragmentPagerAdapter {
    private final List<DataTabBean.DataTabsBean> data_tabs;
    private final ArrayList<Fragment> fragments;

    public DataVpAdapter(FragmentManager childFragmentManager, List<DataTabBean.DataTabsBean> data_tabs, ArrayList<Fragment> fragments) {
        super(childFragmentManager);
        this.data_tabs = data_tabs;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return data_tabs != null ? data_tabs.get(position).getLabel() : null;
    }
}
