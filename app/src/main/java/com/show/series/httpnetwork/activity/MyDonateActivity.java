package com.show.series.httpnetwork.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.show.series.httpnetwork.PagerSlidingTabStrip;
import com.show.series.httpnetwork.R;
import com.show.series.httpnetwork.activity.fragment.MyDonateFragment;
import com.show.series.httpnetwork.adpter.FragmentTabAdapter;
import com.show.series.httpnetwork.utils.OkHttpUtils;
import com.show.series.httpnetwork.utils.callback.ResultCallback;
import com.show.series.httpnetwork.view.UrlContants;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 *
 * Created by lihf on 16/8/17.
 */
public class MyDonateActivity extends AppCompatActivity {

    PagerSlidingTabStrip viewpager_strip;
    ViewPager viewPager ;

    private String [] titles = {"待付款","已付款"};
    List<Fragment> fragments  = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_donate);

        initWiget();
        initView();

        getWaitPayCount();
        getPayOkCount();
    }


    private void initView() {
        fragments = new ArrayList<>();
        fragments.add(MyDonateFragment.newInstance(false));
        fragments.add(MyDonateFragment.newInstance(true));

        FragmentTabAdapter mFragmentTabAdapter = new FragmentTabAdapter(getSupportFragmentManager(), fragments);
        mFragmentTabAdapter.setTitles(titles);
        viewPager.setAdapter(mFragmentTabAdapter);
        viewpager_strip.setViewPager(viewPager);
    }


    private void initWiget() {
        viewpager_strip = (PagerSlidingTabStrip) findViewById(R.id.viewpager_strip);
        viewPager = (ViewPager) findViewById(R.id.activity_vp);
    }

    private void setTabText(int i, String text){
        viewpager_strip.setTabText(i,titles[i]+"(?)".replace("?",text));
    }


    private void getPayOkCount() {
        String url = UrlContants.URL_WAIT_PAY_COUNT+"&token="+UrlContants.tokenTest;
        OkHttpUtils.get().url(url).build().execute(new ResultCallback() {
            @Override
            public void onError(Call call, Exception e) {

            }

            @Override
            public void onResponse(String response) {
                try {
                    JSONObject json = new JSONObject(response);
                    setTabText(1,json.getString("num"));
                    Log.e("getPayOkCount:",json.getString("num"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });


    }

    private void getWaitPayCount() {
        String url = UrlContants.URL_PAY_OK_COUNT+"&token="+UrlContants.tokenTest;
        OkHttpUtils.get().url(url).build().execute(new ResultCallback() {
            @Override
            public void onError(Call call, Exception e) {

            }

            @Override
            public void onResponse(String response) {
                try {
                    JSONObject json = new JSONObject(response);
                    setTabText(0,json.getString("num"));
                    Log.e("getWaitPayCount:", json.getString("num"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

    }


}
