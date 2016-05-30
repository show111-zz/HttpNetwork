package com.show.series.httpnetwork.adpter;

import android.content.Context;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.show.series.httpnetwork.model.LoadMoreModel;
import com.show.series.httpnetwork.model.LoadMoreViewHolder;

/**
 * Created by lihf on 16/5/30.
 */
public class LoadMoreAdatper extends RecyclerArrayAdapter<LoadMoreModel.BodyBean.ListBean>{


    public LoadMoreAdatper(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new LoadMoreViewHolder(parent);
    }
}
