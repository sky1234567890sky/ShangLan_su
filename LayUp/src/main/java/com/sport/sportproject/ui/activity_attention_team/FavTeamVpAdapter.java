package com.sport.sportproject.ui.activity_attention_team;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/*
 *   梨花带雨,我见优伶
 *      2019/4/19
 */
public class FavTeamVpAdapter extends FragmentPagerAdapter {
    private final ArrayList<Fragment> fragments;
    private final ArrayList<String> titles;

    public FavTeamVpAdapter(FragmentManager supportFragmentManager , ArrayList<Fragment> fragments, ArrayList<String> titles) {
        super(supportFragmentManager);
        this.fragments = fragments;
        this.titles = titles;
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
        return titles.get(position);
    }
}
