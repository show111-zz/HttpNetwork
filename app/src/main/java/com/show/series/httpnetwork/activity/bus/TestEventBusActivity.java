package com.show.series.httpnetwork.activity.bus;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.show.series.httpnetwork.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lihf on 16/7/26.
 */
public class TestEventBusActivity extends Activity{

    TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_event_bus);
        ButterKnife.bind(TestEventBusActivity.this);

        text = (TextView) findViewById(R.id.text);
        //注册
        EventBus.getDefault().register(this);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAsyncJson();
            }
        });
    }


    //订阅者
    @Subscribe
    public void helloEventBus(String message){
        text.setText(message);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    //发布者
    public void getAsyncJson(){
        String json = "post json data";
        EventBus.getDefault().post(json);
    }


}
