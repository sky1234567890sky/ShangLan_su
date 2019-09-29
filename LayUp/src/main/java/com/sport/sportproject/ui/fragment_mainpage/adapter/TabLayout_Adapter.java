package com.sport.sportproject.ui.fragment_mainpage.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.sport.sportproject.bean.bean.mainpage.MainPageTabBean;

import java.util.ArrayList;
public class TabLayout_Adapter extends FragmentPagerAdapter{
    private final ArrayList<MainPageTabBean.DataBean.ListBean> listBeans;
    private final ArrayList<Fragment> fragments;

    public TabLayout_Adapter(FragmentManager childFragmentManager, ArrayList<MainPageTabBean.DataBean.ListBean> listBeans, ArrayList<Fragment> fragments) {
        super(childFragmentManager);
        this.listBeans = listBeans;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return  fragments.size() ;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listBeans.get(position).getLabel();
    }
}
