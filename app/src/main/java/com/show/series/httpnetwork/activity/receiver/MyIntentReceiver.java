package com.show.series.httpnetwork.activity.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by lihf on 16/8/2.
 */
public class MyIntentReceiver extends BroadcastReceiver{


    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"received a message",Toast.LENGTH_LONG).show();
    }


}
