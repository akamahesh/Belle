package com.akamahesh.belle.ui.sliding_login;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import com.akamahesh.belle.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by akaMahesh on 25/8/17
 * contact : mckay1718@gmail.com
 */

public class SectionPagerAdapter extends FragmentPagerAdapter {

  private List<Fragment> fragmentList;
  private float factor;
  SectionPagerAdapter(FragmentManager fm,final ViewPager viewPager) {
    super(fm);
    final float textSize = viewPager.getResources().getDimension(R.dimen.fab_margin);
    final float textPadding = viewPager.getResources().getDimension(R.dimen.fab_margin);
    factor = 1- (textSize+textPadding)/viewPager.getWidth();
    fragmentList = new ArrayList<>();
  }

  void addFragment(Fragment fragment){
    fragmentList.add(fragment);
  }

  @Override
  public Fragment getItem(int position) {
    return fragmentList.get(position);
  }

  @Override
  public float getPageWidth(int position) {
    float f = super.getPageWidth(position);
    float x = factor;
    return 0.8f;
  }

  @Override
  public int getCount() {
    return fragmentList.size();
  }
}
