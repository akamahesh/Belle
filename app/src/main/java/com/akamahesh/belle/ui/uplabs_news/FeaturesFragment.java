package com.akamahesh.belle.ui.uplabs_news;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.akamahesh.belle.R;
import com.akamahesh.belle.ui.uplabs_news.adapters.NewsAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class FeaturesFragment extends Fragment {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    NewsAdapter newsAdapter;
    List<String> dataList;

    public static Fragment getFragment(){
        return new FeaturesFragment();
    }

    public FeaturesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_features, container, false);
        ButterKnife.bind(this,view);
        dataList = generateList();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        newsAdapter = new NewsAdapter(getContext(),dataList);
        recyclerView.setAdapter(newsAdapter);
        return view;
    }

    List<String> generateList() {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            strings.add(UUID.randomUUID().toString());
        }
        return strings;
    }

}
