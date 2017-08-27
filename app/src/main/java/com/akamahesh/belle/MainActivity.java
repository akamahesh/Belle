package com.akamahesh.belle;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.akamahesh.belle.ui.constraint_designs.ConstraintActivity;
import com.akamahesh.belle.ui.dynamic_views.DynamicActivity;
import com.akamahesh.belle.ui.helper.GifImageView;
import com.akamahesh.belle.ui.infinite_scroll.InfiniteScrollActivity;
import com.akamahesh.belle.ui.script.ScriptActivity;
import com.akamahesh.belle.ui.sliding_login.LoginActivity;
import com.akamahesh.belle.ui.uplabs_news.NewsActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.gif_image_view)
    GifImageView gifImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        gifImageView.setGifImageResource(R.drawable.gif);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.action_news:
                startActivity(NewsActivity.getIntent(this));
                break;
            case R.id.action_infinite_scroll:
                startActivity(InfiniteScrollActivity.getIntent(this));
                break;
            case R.id.action_script:
                startActivity(ScriptActivity.getIntent(this));
                break;
            case R.id.action_dynamic:
                startActivity(DynamicActivity.getIntent(this));
                break;
            case R.id.action_constraint:
                startActivity(ConstraintActivity.getIntent(this));
                break;
            case R.id.action_login:
                startActivity(LoginActivity.getIntent(this));
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
