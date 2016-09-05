package com.show.series.httpnetwork.activity.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.show.series.httpnetwork.R;

/**
 * Created by lihf on 16/8/17.
 */
public class MyDonateFragment extends Fragment {


    public static MyDonateFragment newInstance(boolean paySuccess){
        MyDonateFragment myDonateFragment = new MyDonateFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean("paySuccess",paySuccess);
        myDonateFragment.setArguments(bundle);
        return myDonateFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my_donate,null);
    }





}
