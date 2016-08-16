package com.show.series.httpnetwork.activity.async;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

/**
 *  理解 内存泄露
 * Created by lihf on 16/8/11.
 */
public class HandlerSampleActivity extends Activity{

    private final Handler mLeakyHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mLeakyHandler.postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        },1000*60*10);

        finish();

    }


}
