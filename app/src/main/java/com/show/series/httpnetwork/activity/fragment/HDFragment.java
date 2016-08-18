package com.show.series.httpnetwork.activity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.show.series.httpnetwork.R;
import com.show.series.httpnetwork.activity.MyDonateActivity;
import com.show.series.httpnetwork.model.HomeModel;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lihf on 16/8/17.
 */
public class HDFragment extends Fragment implements View.OnClickListener{

    private HomeModel homeModel;

    RelativeLayout my_price_view;
    RelativeLayout my_project_view;

   TextView tv_paytotal;
   TextView tv_project_count;

    public void setHomeModel(HomeModel homeModel){
        this.homeModel = homeModel;
    }

    public static HDFragment getInstance(HomeModel model){
        HDFragment  hdFragment = new HDFragment();
        hdFragment.setHomeModel(model);
        return hdFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_has_data,null);
        my_price_view = (RelativeLayout) view.findViewById(R.id.my_price_view);
        my_project_view = (RelativeLayout) view.findViewById(R.id.my_project_view);
        tv_paytotal = (TextView) view.findViewById(R.id.tv_paytotal);
        tv_project_count = (TextView) view.findViewById(R.id.tv_project_count);
        return view ;
    }


    @Override
    public void onStart() {
        super.onStart();
        initListener();
        tv_paytotal.setText(homeModel.body.donate.payTotal);
        tv_project_count.setText(homeModel.body.donate.projectCount);
    }

    private void initListener() {
        my_price_view.setOnClickListener(this);
        my_project_view.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.my_price_view:
                startActivity(new Intent(getContext(),MyDonateActivity.class));
                break;
        }

    }
}
