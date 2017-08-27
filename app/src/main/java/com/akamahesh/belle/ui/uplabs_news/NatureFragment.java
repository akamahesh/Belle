package com.akamahesh.belle.ui.uplabs_news;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.akamahesh.belle.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NatureFragment extends Fragment {


    public static Fragment getFragment(){
        return new NatureFragment();
    }

    public NatureFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nature, container, false);
    }

}
