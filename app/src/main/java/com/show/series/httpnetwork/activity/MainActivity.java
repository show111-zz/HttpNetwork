package com.show.series.httpnetwork.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.show.series.httpnetwork.R;
import com.show.series.httpnetwork.activity.async.AsncyTaskTestActivity;
import com.show.series.httpnetwork.activity.bus.EventBusComplexActivity;
import com.show.series.httpnetwork.activity.bus.TestEventBusActivity;
import com.show.series.httpnetwork.activity.data.SqliteOperateActivity;
import com.show.series.httpnetwork.activity.first.FirstSqliteActivity;
import com.show.series.httpnetwork.view.UrlContants;
import com.show.series.httpnetwork.utils.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Request;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @BindView(R.id.id_textview)
    TextView mTv;
    @BindView(R.id.id_progress)
    ProgressBar mProgressBar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;


    public class MyStringCallback extends StringCallback {

        @Override
        public void onBefore(Request request) {
            super.onBefore(request);
            setTitle("Loading...");
        }

        @Override
        public void onAfter() {
            super.onAfter();
            setTitle("OkHttpNetwork");
        }

        @Override
        public void onError(Call call, Exception e) {
            e.printStackTrace();
            mTv.setText("onError:" + e.getMessage());
        }

        @Override
        public void onResponse(String response) {
            Log.e(TAG, "onResponse complete" + response);
            mTv.setText(response);
        }

        @Override
        public void inProgress(float progress) {
            Log.e(TAG, "inProgress:" + progress);
            mProgressBar.setProgress((int) (100 * progress));
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(MainActivity.this);

        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "hello, snackbar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    public void getHtml(View view) {
        OkHttpUtils.get().url(UrlContants.URL_DISCOVER).build().execute(new MyStringCallback());
    }

//    public void postHtml(View view){
//        OkHttpUtils.post().url(UrlContants.URL_INVITE_FRIEND).addParams("pid", "88").addParams("token", UrlContants.tokenTest)
//                .build().execute(new MyStringCallback());
//
//    }

    public void postHtml(View view) {
        Map<String, String> params = new HashMap<>();
        params.put("pid", "88");
        params.put("token", UrlContants.tokenTest);

        OkHttpUtils.post().url(UrlContants.URL_INVITE_FRIEND).params(params)
                .build().execute(new MyStringCallback());
    }


    public void jumpTo(View view){
        Intent intent = new Intent(this,LoadMoreActivity.class);
        startActivity(intent);
    }


     public void createCustom(View view){
         startActivity(new Intent(this,CustomActivity.class));
     }


    public void screenShare(View view){
        startActivity(new Intent(this,ScreenshotShareActivity.class));
    }

    public void operateSqlite(View view){
        startActivity(new Intent(this,FirstSqliteActivity.class));
    }



    public void operateAsyncTask(View view){
        startActivity(new Intent(this,AsncyTaskTestActivity.class));
    }



    public void operateEventBus(View view){
        startActivity(new Intent(this,TestEventBusActivity.class));
    }

    public void operateComplexEventBus(View view){
        startActivity(new Intent(this,EventBusComplexActivity.class));
    }


}
