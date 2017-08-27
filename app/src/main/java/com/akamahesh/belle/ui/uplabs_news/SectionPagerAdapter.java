package com.akamahesh.belle.ui.uplabs_news;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by akaMahesh on 16/8/17
 * contact : mckay1718@gmail.com
 */

public class SectionPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;
    public SectionPagerAdapter(FragmentManager fm) {
        super(fm);
        fragmentList = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    public void addFragment(Fragment fragment){
        fragmentList.add(fragment);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Features";
            case 1:
                return "Sports";
            case 2:
                return "Nature";
            case 3:
                return "Technology";
            default:
                return "News Update";
        }
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
