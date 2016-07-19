package com.show.series.httpnetwork.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by lihf on 16/6/13.
 */
public class ScreenShot1 {


    private static  final int SAVE_AUTHORITY = Context.MODE_PRIVATE;

    private static HashMap<String,String> appNameMapping  = new HashMap<>();

    //获取指定activity的截屏，保存到png文件
    private static Bitmap takeScreenShot(Activity activity){

        //View 是你需要截图的View
        View view  = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap bitmap= view.getDrawingCache();

        //获取状态栏高度
        Rect frame = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        int statusBarHeight  = frame.top;
        Log.e("bar heigth:" ,statusBarHeight+"");

        //获取屏幕长和高
        int width = activity.getWindowManager().getDefaultDisplay().getWidth();
        int height = activity.getWindowManager().getDefaultDisplay().getHeight();
        Log.e("screen heigth:" ,height+"screen width:"+width);


        //去掉标题栏
        Bitmap bitmap1 = Bitmap.createBitmap(bitmap,0,statusBarHeight,width,height- statusBarHeight);
        view.destroyDrawingCache();

        return bitmap1;
    }


    //保存到sd卡中
    public static void savePic(Activity act, Bitmap bitmap,String strFileName){
        FileOutputStream fos = null;
        try{
            fos = act.openFileOutput(strFileName,SAVE_AUTHORITY);
            bitmap.compress(Bitmap.CompressFormat.JPEG,90,fos);
            fos.flush();
            fos.close();

        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public static Uri  getUri(Activity act, String strName){
        Uri uri = null;
        FileInputStream input = null;
        try{
            input = act.openFileInput(strName);
            Bitmap bitmap = BitmapFactory.decodeStream(input);
            uri = Uri.parse(MediaStore.Images.Media.insertImage(act.getContentResolver(),bitmap,null,null));
            input.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return uri;
    }


    public static void shareAct(Activity act, String strName,String text){
       Uri uri = getUri(act,strName);

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        shareIntent.setType("image/jpeg");
        shareIntent.addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION);
        shareIntent.putExtra(Intent.EXTRA_STREAM,uri);
//        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "friend comment");
//        shareIntent.putExtra(Intent.EXTRA_TEXT,text);
//        shareIntent.putExtra("Kdescription",text);
        act.startActivity(Intent.createChooser(shareIntent, "发送"));
//        act.startActivity(shareIntent);

    }

    public static void share(Activity act,String text){
        String saveFileName = "share_pic.jpg";
        savePic(act,ScreenShot1.takeScreenShot(act),saveFileName);
        shareAct(act, saveFileName, text);
    }


}
