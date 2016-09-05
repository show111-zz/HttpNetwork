package com.show.series.httpnetwork.activity.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.show.series.httpnetwork.R;
import com.show.series.httpnetwork.model.HomeModel;

/**
 * Created by lihf on 16/8/17.
 */
public class NDFragment extends Fragment{


    private HomeModel  homeModel;

    public void setHomeModel(HomeModel homeModel){
        this.homeModel = homeModel;
    }

    public static HDFragment getInstance(HomeModel model){
        HDFragment hdFragment = new HDFragment();
        hdFragment.setHomeModel(model);
        return hdFragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_no_data,null);
    }
}
