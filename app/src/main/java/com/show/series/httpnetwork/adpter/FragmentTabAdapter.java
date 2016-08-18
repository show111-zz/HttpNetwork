package com.show.series.httpnetwork.adpter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by lihf on 16/8/18.
 */
public class FragmentTabAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;

    private String[] titles;

    private boolean isPadding = false;


    public FragmentTabAdapter(FragmentManager fm) {
        super(fm);
    }


    public FragmentTabAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    public String[] getTitles() {
        return titles;
    }

    public void setTitles(String[] titles) {
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    public void setIsPadding(boolean isPadding) {
        this.isPadding = isPadding;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return  position < titles.length ? titles[position] : null;
    }

    @Override
    public float getPageWidth(int position) {
        if(isPadding){
            if(position == fragments.size() -1){
                return 1f;
            }
            return 0.95f;
        }else{
            return 1f;
        }
    }
}
