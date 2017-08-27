package com.akamahesh.belle.ui.infinite_scroll;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.akamahesh.belle.R;
import com.akamahesh.belle.ui.helper.Utils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by akaMahesh on 18/8/17
 * contact : mckay1718@gmail.com
 */

class InfiniteAdapter extends InfinityAdapter {

    private List<String> stringList;
    private Context context;

    InfiniteAdapter(Context context, List<String> strings, RecyclerView recyclerView) {
        super(context,strings,recyclerView);
        this.stringList = strings;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        if (viewType == 1) {
            View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
            viewHolder = new ViewHolder(layoutView);
        } else {
            View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_progress, parent, false);
            viewHolder = new ProgressHolder(layoutView);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            String string = stringList.get(position);
            ((ViewHolder) holder).textView.setText(string);
            ((ViewHolder) holder).textView.setTextColor(Utils.generateRandomColor());
        } else {
            String totalRecords = "Total Records : "+(getItemCount()-1)+"/"+getTotalRecords();
            ((ProgressHolder) holder).progressBar.setIndeterminate(true);
            ((ProgressHolder) holder).tvTotalRecords.setText(totalRecords);
        }
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_title)
        TextView textView;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }



}
