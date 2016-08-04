package com.show.series.httpnetwork.activity.receiver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.show.series.httpnetwork.R;

/**
 * Created by lihf on 16/8/2.
 */
public class TestBroadcastActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_receiver_test);
    }

    public void startSend(){
        Intent intent = new Intent();
        intent.setAction("com.send.ACTION_SEND");
        sendBroadcast(intent);
    }


}
