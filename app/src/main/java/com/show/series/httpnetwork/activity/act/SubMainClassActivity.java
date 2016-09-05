package com.show.series.httpnetwork.activity.act;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.show.series.httpnetwork.R;
import com.show.series.httpnetwork.activity.Custom.TextApartActivity;

/**
 * Created by lihf on 16/9/5.
 */
public class SubMainClassActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_act);
    }


    public void getMultiplyText(View view){
        startActivity(new Intent(this, TextApartActivity.class));
    }


    public void createCustomTheme(View view){
        startActivity(new Intent(this, CustomThemeActivity.class));
    }


}
