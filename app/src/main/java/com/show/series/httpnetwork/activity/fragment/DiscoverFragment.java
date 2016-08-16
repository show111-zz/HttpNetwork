package com.show.series.httpnetwork.activity.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.show.series.httpnetwork.R;

/**
 * Created by lihf on 16/8/12.
 */
public class DiscoverFragment extends Fragment {

    public static DiscoverFragment newInstance(String title){
        DiscoverFragment discoverFragment = new DiscoverFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title",title);
        discoverFragment.setArguments(bundle);
        return discoverFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover,null);
        return view;
    }
}
