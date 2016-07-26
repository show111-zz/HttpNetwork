package com.show.series.httpnetwork.activity.async;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.show.series.httpnetwork.R;

import butterknife.BindView;

/**
 * Created by lihf on 16/7/21.
 */
public class AsncyTaskTestActivity extends Activity {

    //    @BindView(R.id.progressBar1)ProgressBar progressBar1;
//    @BindView(R.id.text)TextView textView;
//    @BindView(R.id.start_btn)Button start_btn;
    ProgressBar progressBar1;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.async_act);
        progressBar1 = (ProgressBar) findViewById(R.id.progressBar1);
        Button start_btn = (Button) findViewById(R.id.start_btn);
        textView = (TextView) findViewById(R.id.text);


        final String downloadUrl = "http://dl.ops.baidu.com/appsearch_AndroidPhone_1426l.apk";

        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressBarAsyncTask asyncTask = new ProgressBarAsyncTask(textView, progressBar1);
                asyncTask.execute(downloadUrl);
            }
        });

    }


}
