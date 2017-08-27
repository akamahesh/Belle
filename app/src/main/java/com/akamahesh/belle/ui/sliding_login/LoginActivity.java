package com.akamahesh.belle.ui.sliding_login;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.akamahesh.belle.R;
import com.akamahesh.belle.ui.sliding_login.fragments.LoginFragment;
import com.akamahesh.belle.ui.sliding_login.fragments.SignupFragment;

public class LoginActivity extends AppCompatActivity implements
    LoginFragment.OnFragmentInteractionListener,
    SignupFragment.OnFragmentInteractionListener{


  @BindView(R.id.view_pager)
  ViewPager mViewPager;

  public static Intent getIntent(Context context){
    return new Intent(context,LoginActivity.class);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    ButterKnife.bind(this);
    SectionPagerAdapter sectionPagerAdapter = new SectionPagerAdapter(getSupportFragmentManager(),mViewPager);
    sectionPagerAdapter.addFragment(LoginFragment.newInstance());
    sectionPagerAdapter.addFragment(SignupFragment.newInstance());
    mViewPager.setAdapter(sectionPagerAdapter);
  }

  @Override
  public void onFragmentInteraction(Uri uri) {

  }
}
