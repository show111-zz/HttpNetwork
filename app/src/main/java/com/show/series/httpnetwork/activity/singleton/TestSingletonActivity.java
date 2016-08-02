package com.show.series.httpnetwork.activity.singleton;

import android.app.Activity;

/**
 * 测试单例模式(饿汉式)
 * Created by lihf on 16/8/1.
 */
public class TestSingletonActivity extends Activity{

    /**
     *  饿汉式单例类，在类初始化时，已经自行实现实例化
     *
     */

 /**

    private static final TestSingletonActivity singletonAct = new TestSingletonActivity();

    private TestSingletonActivity(){}

    public static final TestSingletonActivity getInstance(){
        return singletonAct;
    }

  */


    /**
     *  懒汉式单例类，在第一次调用的时候实例化自己
     *
     *  懒汉，线程安全
     */

    private static  TestSingletonActivity singletonAct = null;

    private TestSingletonActivity(){}

    public static synchronized TestSingletonActivity getInstance(){
        if(singletonAct == null){
            singletonAct = new TestSingletonActivity();
        }
        return singletonAct;
    }



}
