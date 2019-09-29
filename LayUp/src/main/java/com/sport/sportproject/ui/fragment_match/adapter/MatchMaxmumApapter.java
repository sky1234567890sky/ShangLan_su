package com.sport.sportproject.ui.fragment_match.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.sport.sportproject.ui.fragment_match.MatchMaxmumInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 华为 on 2019/7/5.
 */

public class MatchMaxmumApapter extends FragmentStatePagerAdapter{
    private final ArrayList<Fragment> fragments;
    private final List<MatchMaxmumInterface.LiveTabsBean> live_tabs;

    public MatchMaxmumApapter(FragmentManager childFragmentManager, ArrayList<Fragment> fragments, List<MatchMaxmumInterface.LiveTabsBean> live_tabs) {
        super(childFragmentManager);

        this.fragments = fragments;
        this.live_tabs = live_tabs;
    }
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }
    @Override
    public int getCount() {
        return live_tabs.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return live_tabs.get(position).getLabel();
    }
}
