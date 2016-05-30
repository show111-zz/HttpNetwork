package com.show.series.httpnetwork;

import android.app.Application;

import com.show.series.httpnetwork.utils.OkHttpUtils;

import java.util.concurrent.TimeUnit;

/**
 * Created by lihf on 16/5/25.
 */
public class HttpApplication extends Application{




    @Override
    public void onCreate() {
        super.onCreate();
        OkHttpUtils.getInstance().debug("OkHttpUtils").setConnectTimeOut(100000, TimeUnit.MILLISECONDS);

    }
}
