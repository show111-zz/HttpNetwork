package com.show.series.httpnetwork.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.google.gson.Gson;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.show.series.httpnetwork.R;
import com.show.series.httpnetwork.adpter.LoadMoreAdatper;
import com.show.series.httpnetwork.model.LoadMoreModel;
import com.show.series.httpnetwork.utils.OkHttpUtils;
import com.show.series.httpnetwork.view.UrlContants;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by lihf on 16/5/30.
 */
public class LoadMoreActivity extends Activity implements SwipeRefreshLayout.OnRefreshListener{


    public static final String TAG = "LoadMoreActivity";

    private EasyRecyclerView listBtn;

    private LoadMoreAdatper adapter;
    private LoadMoreModel model;
    private Handler handler = new Handler();
    int page= 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.load_more);

        listBtn = (EasyRecyclerView) findViewById(R.id.list_btn);
        listBtn.setLayoutManager(new LinearLayoutManager(this));
        adapter = new LoadMoreAdatper(LoadMoreActivity.this);
        adapter.setMore(R.layout.view_more, new RecyclerArrayAdapter.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        page++;
                        loadData(page);
                        adapter.addAll(model.body.list);
                    }
                }, 1000);
            }
        });

        listBtn.setRefreshListener(this);
        onRefresh();
    }


    private void loadData(int page) {
        String url = UrlContants.URL_TOGETHER_LIST + "&token=" + UrlContants.tokenTest+"&page="+page;
        Log.e(TAG,url);
        OkHttpUtils.get().url(url).build().execute(new MyStringCallback());
    }

    @Override
    public void onRefresh() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                adapter.clear();
                page = 1;
                loadData(page);

                listBtn.setAdapter(adapter);

            }
        },1000);
    }


    public class MyStringCallback extends StringCallback {

        @Override
        public void onError(Call call, Exception e) {
            e.printStackTrace();
            Log.e(TAG, e.getMessage());
        }

        @Override
        public void onResponse(String response) {
            model = new Gson().fromJson(response, LoadMoreModel.class);
            if(model.header.status.equals("2")){
                adapter.stopMore();
            }else{
                adapter.addAll(model.body.list);
                adapter.notifyDataSetChanged();
            }

        }
    }


}
