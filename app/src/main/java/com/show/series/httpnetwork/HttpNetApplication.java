package com.show.series.httpnetwork;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import java.net.MulticastSocket;

/**
 * Created by lihf on 16/8/17.
 */
public class HttpNetApplication extends Application{

    private static HttpNetApplication application ;

    private HttpNetApplication(){};

    public static HttpNetApplication getInstance(){
        return  application;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(application);
    }
}
