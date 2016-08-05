package com.show.series.httpnetwork.activity.Custom;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import com.show.series.httpnetwork.R;

/**
 * Created by lihf on 16/8/5.
 */
public class TextApartActivity extends Activity{


    private TextView text1;
    private TextView text2;
    private TextView text3;
    private TextView text4;
    private TextView text5;
    private TextView text6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_apart_act);

        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
        text3 = (TextView) findViewById(R.id.text3);
        text4 = (TextView) findViewById(R.id.text4);
        text5 = (TextView) findViewById(R.id.text5);
        text6 = (TextView) findViewById(R.id.text6);
        loadText();
    }

    private void loadText() {
        text1.setText(Html.fromHtml("北京发布黄色预警，<font color='#ff0000'><big><big>外出携带</big></big></font>口罩"));

        text2.setText(Html.fromHtml("北京发布黄色预警，<h3><font color='#ff0000'>外出携带好</font></h3>口罩"));


        text3.setText("北京发布黄色预警，外出携带好口罩");
        Spannable spannable = new SpannableString(text3.getText());
        spannable.setSpan(new AbsoluteSizeSpan(58),11,16, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannable.setSpan(new ForegroundColorSpan(Color.RED), 11, 16, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannable.setSpan(new BackgroundColorSpan(Color.YELLOW), 11, 16, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        text3.setText(spannable);

        text4.setText(Html.fromHtml("北京发布黄色预警，<font color='#ff0000'><small><small>外出携带好</small></small></font>口罩"));

        String content = "1000.33";
        text5.setText(this.getResources().getString(R.string.my_urgency_goal).replace("?",content ));
        Spannable spannable1 = new SpannableString(text5.getText());
        spannable1.setSpan(new ForegroundColorSpan(Color.RED),3,content.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        text5.setText(spannable1);

        text6.setText(Html.fromHtml("已筹：<font color='#ff0000'>"+content+"</font>元"));
    }


}
