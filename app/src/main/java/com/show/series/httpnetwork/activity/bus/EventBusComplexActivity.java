package com.show.series.httpnetwork.activity.bus;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.show.series.httpnetwork.R;

/**
 * Created by lihf on 16/7/26.
 */
public class EventBusComplexActivity extends FragmentActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.complex_event_bus);
    }
}
