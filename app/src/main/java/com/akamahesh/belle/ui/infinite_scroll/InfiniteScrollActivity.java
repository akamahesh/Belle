package com.akamahesh.belle.ui.infinite_scroll;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.akamahesh.belle.R;
import com.akamahesh.belle.ui.helper.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InfiniteScrollActivity extends AppCompatActivity implements InfiniteAdapter.OnLoadMoreListener{

    @BindView(R.id.recycler_view_infinite)
    RecyclerView recyclerView;
    InfiniteAdapter infiniteAdapter;
    List<String> dataList;
    private Handler handler;
    private int mPage = 1;

    public static Intent getIntent(Context context) {
        return new Intent(context, InfiniteScrollActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infinite_scroll);
        ButterKnife.bind(this);
        dataList = generateList(mPage);
        handler = new Handler();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        infiniteAdapter = new InfiniteAdapter(this,dataList,recyclerView);
        recyclerView.setAdapter(infiniteAdapter);
        infiniteAdapter.setTotalRecords(100);
        infiniteAdapter.setOnLoadMoreListener(this);
    }



    List<String> generateList(int page) {
        List<String> strings = new ArrayList<>();
        if(page<10){
            for (int i = 0; i < 10; i++) {
                strings.add(UUID.randomUUID().toString());
            }
        }
        return strings;
    }


    @Override
    public void onLoadMore() {
        dataList.add(null);
        infiniteAdapter.notifyItemInserted(dataList.size() - 1);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                dataList.remove(dataList.size() - 1);
                infiniteAdapter.notifyItemRemoved(dataList.size());
                dataList.addAll(generateList(++mPage));
                infiniteAdapter.notifyDataSetChanged();
                infiniteAdapter.setLoaded();
            }
        }, 4000);
    }
}
