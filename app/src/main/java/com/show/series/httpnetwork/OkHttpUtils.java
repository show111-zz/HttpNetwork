package com.show.series.httpnetwork;

import android.os.Handler;
import android.os.Looper;

import com.zhy.http.okhttp.builder.GetBuilder;
import com.zhy.http.okhttp.builder.PostFormBuilder;
import com.zhy.http.okhttp.builder.PostStringBuilder;
import com.zhy.http.okhttp.cookie.CookieJarImpl;
import com.zhy.http.okhttp.cookie.store.MemoryCookieStore;
import com.zhy.http.okhttp.log.LoggerInterceptor;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.OkHttpClient;

/**
 * Created by lihf on 16/5/25.
 */
public class OkHttpUtils {

    private static OkHttpUtils mInstance;
    private OkHttpClient mOkHttpClient;
    private Handler mDelivery;


    public OkHttpUtils(OkHttpClient okHttpClient){
        if(okHttpClient == null){
            OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
            okHttpClientBuilder.cookieJar(new CookieJarImpl(new MemoryCookieStore()));
            okHttpClientBuilder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });

            mOkHttpClient = okHttpClientBuilder.build();

        }else{
            mOkHttpClient = okHttpClient;
        }

        init();

    }

    private void init() {
        mDelivery = new Handler(Looper.getMainLooper());
    }


    public OkHttpUtils debug(String tag){
        mOkHttpClient = getOkHttpClient().newBuilder().addInterceptor(new LoggerInterceptor(tag,false)).build();
        return this;
    }

    /**
     * showResponse may cause error, but you can try .
     */
    public OkHttpUtils debug(String tag,boolean showResponse){
        mOkHttpClient = getOkHttpClient().newBuilder().addInterceptor(new LoggerInterceptor(tag,showResponse)).build();
        return  this;
    }


    public static OkHttpUtils getInstance(){

        if(mInstance == null){
            synchronized (OkHttpUtils.class){
                if(mInstance == null){
                    mInstance = new OkHttpUtils(null);
                }
            }
        }
        return mInstance;
    }

    public static OkHttpUtils getInstance(OkHttpClient okHttpClient){
        if(mInstance == null){
            synchronized (OkHttpUtils.class){
                if(mInstance == null){
                    mInstance = new OkHttpUtils(okHttpClient);
                }
            }
        }
        return  mInstance;
    }

    public Handler getDelivery(){
        return mDelivery;
    }

    public OkHttpClient getOkHttpClient(){
        return mOkHttpClient;
    }


    public static GetBuilder get(){
        return new GetBuilder();
    }

    public static PostStringBuilder postString(){
        return new PostStringBuilder();
    }

    public static PostFormBuilder post(){
        return new PostFormBuilder();
    }


    /**
     * for https mutual authentication
     */

    public void setConnectTimeOut(int timeout, TimeUnit units){
        mOkHttpClient = getOkHttpClient().newBuilder().connectTimeout(timeout,units).build();
    }





}
