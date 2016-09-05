package com.show.series.httpnetwork.activity.act;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.show.series.httpnetwork.R;
import com.show.series.httpnetwork.activity.AndroidShare;
import com.show.series.httpnetwork.utils.FileUtils;
import com.show.series.httpnetwork.utils.ScreenShotUtil;
import com.show.series.httpnetwork.view.ScreenShot1;

/**
 * 屏幕截图分享
 * Created by lihf on 16/6/12.
 */
public class ScreenshotShareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_shot);
    }



    public void shareScreenShot(View view){
        //屏幕截图分享
        ScreenShot1.share(this,"screen shot");
    }


    public void getScreenShot(View view){
        //点击截图

        ScreenShotUtil.shotBitmap(this);
//        String path =  ScreenShotUtil.getExternDir();
    }



    public void dialogScreenShot(View view){

       String imageUri = FileUtils.UriToString(ScreenShot1.getUri(this,"share_pic.jpg"),ScreenshotShareActivity.this);

        //屏幕截图分享
        AndroidShare as = new AndroidShare(
                ScreenshotShareActivity.this,
                "哈哈---超方便的分享！！！来自allen",
                imageUri);
        as.show();
    }



}
