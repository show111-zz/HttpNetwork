package com.show.series.httpnetwork.activity.async;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.show.series.httpnetwork.R;

/**
 * Created by lihf on 16/8/4.
 */
public class TestHandleActivity extends Activity{

    Button handler_post_btn;

//    Handler handler = new Handler();

    Runnable thread = new Runnable() {
        @Override
        public void run() {
            Log.e("TestHandleActivity","Runnable thread:"+Thread.currentThread().getId());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.handler_act);

        handler_post_btn = (Button) findViewById(R.id.handler_post_btn);
        handler_post_btn.setOnClickListener(new StartPostListener());

        Log.e("TestHandleActivity","Main thread:"+Thread.currentThread().getId());

    }


    private class StartPostListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            // 创建一个名叫handler_hread的HandlerThread 对象
            HandlerThread handlerThread = new HandlerThread("handler_thread");
            handlerThread.start();
            myHandler handler = new myHandler(handlerThread.getLooper());
            handler.post(thread);
        }
    }

    private class myHandler extends Handler{
        public myHandler() {
        }

        public myHandler(Looper looper) {
            super(looper);
        }


        @Override
        public void handleMessage(Message msg) {

            Log.e("handleMessage","handler thread --"+Thread.currentThread().getId());
        }
    }



}
