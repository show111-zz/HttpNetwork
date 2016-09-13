package com.show.series.httpnetwork.activity.act;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.show.series.httpnetwork.R;
import com.show.series.httpnetwork.databinding.ActDataBindBinding;
import com.show.series.httpnetwork.model.User;

/**
 * Created by lihf on 16/9/9.
 */
public class DataBindActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActDataBindBinding binding = DataBindingUtil.setContentView(this,R.layout.act_data_bind);
        User user = new User("lee","liang");
        binding.setUser(user);
    }



}
