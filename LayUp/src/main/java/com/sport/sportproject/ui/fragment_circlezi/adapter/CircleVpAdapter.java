package com.sport.sportproject.ui.fragment_circlezi.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.sport.sportproject.ui.fragment_circlezi.bean.CircleTabBean;
import com.sport.sportproject.ui.fragment_circlezi.fragment.Fragment_CircleZi_Normal;

import java.util.ArrayList;

/*
 *   梨花带雨,我见优伶
 *      2019/4/24
 */
public class CircleVpAdapter extends FragmentPagerAdapter {

    private final ArrayList<Fragment> fragments;
    private final ArrayList<CircleTabBean.DataBean.ListBean> dataBeans;


    public CircleVpAdapter(FragmentManager childFragmentManager, ArrayList<Fragment> fragments, ArrayList<CircleTabBean.DataBean.ListBean> dataBeans) {
        super(childFragmentManager);
        this.fragments = fragments;
        this.dataBeans = dataBeans;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments !=null ? fragments.get(position) : null;
    }

    @Override
    public int getCount() {
        return fragments !=null ?fragments.size() : 0 ;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return dataBeans !=null ? dataBeans.get(position).getLabel() : null;
    }
}
