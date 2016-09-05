package com.show.series.httpnetwork.activity.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.show.series.httpnetwork.R;
import com.show.series.httpnetwork.activity.fragment.CouponFragment;
import com.show.series.httpnetwork.activity.fragment.DiscoverFragment;
import com.show.series.httpnetwork.activity.fragment.HomeFragment;
import com.show.series.httpnetwork.activity.fragment.MessageFragment;
import com.show.series.httpnetwork.model.TabEntity;

import java.util.ArrayList;

/**
 * Created by lihf on 16/8/12.
 */
public class PrimaryActivity extends FragmentActivity {


    private String[] titles = {"首页", "发现", "答谢", "消息"};

    private int[] iconUnselectIds = {
            R.mipmap.tab_home_unselect,
            R.mipmap.tab_found_unselect,
            R.mipmap.tab_discount_unselect,
            R.mipmap.tab_message_unselect
    };

    private int[] iconSelectIds = {
            R.mipmap.tab_home_select,
            R.mipmap.tab_found_select,
            R.mipmap.tab_discount_select,
            R.mipmap.tab_message_select
    };

    private int showWhich = 0;
    private String currentFragmentTag;
    private CommonTabLayout tabLayout;
    private ArrayList<CustomTabEntity> tabs = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primary);
        tabLayout = (CommonTabLayout) findViewById(R.id.tabLayout);
        initTab();
    }

    private void initTab() {
        for (int i = 0, len = titles.length; i < len; i++) {
            tabs.add(new TabEntity(titles[i], iconSelectIds[i], iconUnselectIds[i]));
        }
        tabLayout.setTabData(tabs);
        tabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                showFragment(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

        showFragment(showWhich);
    }


    private void showFragment(int showWhich) {
        String title = titles[showWhich];

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if(currentFragmentTag != null){
            Fragment cfragment = getSupportFragmentManager().findFragmentByTag(currentFragmentTag);
            if(cfragment != null){
                transaction.hide(cfragment);
            }
        }


        Fragment fragment = null;
        Fragment oFragment = getSupportFragmentManager().findFragmentByTag(title);

        switch (showWhich) {
            case 0:
                fragment = oFragment != null ? oFragment : HomeFragment.newInstance(title);
                break;
            case 1:
                fragment = oFragment != null ? oFragment : DiscoverFragment.newInstance(title);
                break;
            case 2:
                fragment = oFragment != null ? oFragment : CouponFragment.newInstance(title);
                break;
            case 3:
                fragment = oFragment != null ? oFragment : MessageFragment.newInstance(title);
                break;
        }

        if (fragment != null && fragment.isAdded()) {
            transaction.show(fragment);
        } else {
            transaction.add(R.id.main_content_frame, fragment, title);
        }
        transaction.commit();
        currentFragmentTag = title;
    }


}
