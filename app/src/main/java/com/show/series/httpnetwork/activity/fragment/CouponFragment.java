package com.show.series.httpnetwork.activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.show.series.httpnetwork.R;

/**
 * Created by lihf on 16/8/12.
 */
public class CouponFragment extends Fragment {

    public static CouponFragment newInstance(String title){
        CouponFragment couponFragment = new CouponFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title",title);
        couponFragment.setArguments(bundle);
        return couponFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_coupon,null);
        return view;
    }
}
