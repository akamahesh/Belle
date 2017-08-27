package com.akamahesh.belle.ui.uplabs_news;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.akamahesh.belle.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.layout_dots)
    LinearLayout dotsLayout;
    SectionPagerAdapter sectionPagerAdapter;

    public static Intent getIntent(Context context){
        return new Intent(context,NewsActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        sectionPagerAdapter = new SectionPagerAdapter(getSupportFragmentManager());
        sectionPagerAdapter.addFragment(FeaturesFragment.getFragment());
        sectionPagerAdapter.addFragment(SportsFragment.getFragment());
        sectionPagerAdapter.addFragment(NatureFragment.getFragment());
        sectionPagerAdapter.addFragment(TechFragment.getFragment());
        viewPager.setAdapter(sectionPagerAdapter);
        viewPager.setOffscreenPageLimit(1);
        viewPager.addOnPageChangeListener(this);

        addBottomDots(0);

    }

    private void addBottomDots(int currentPage) {
        ImageView[] dots = new ImageView[sectionPagerAdapter.getCount()];



        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.canvas_circle_background_active));
            dots[i].setPadding(4,4,4,4);
            if(i==currentPage)
                dots[i].setImageDrawable(getResources().getDrawable(R.drawable.canvas_circle_background_active));
            else
                dots[i].setImageDrawable(getResources().getDrawable(R.drawable.canvas_circle_background_inactive));

            dotsLayout.addView(dots[i]);
        }

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        addBottomDots(position);
        tvTitle.setText(sectionPagerAdapter.getPageTitle(position));
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_news, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.action_refresh:
                Toast.makeText(this, "Refresh", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_sort:
                Toast.makeText(this, "Sort", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
