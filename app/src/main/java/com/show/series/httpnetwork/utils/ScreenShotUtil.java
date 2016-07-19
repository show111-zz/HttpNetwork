package com.show.series.httpnetwork.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Environment;
import android.util.Log;
import android.view.View;

import java.io.FileOutputStream;

/**
 * 屏幕截图
 * Created by lihf on 16/6/13.
 */
public class ScreenShotUtil {

    //进行截取屏幕
    public static Bitmap takeScreenShot(Activity activity){

        Bitmap bitmap = null;
        View view = activity.getWindow().getDecorView();

        //设置是否可以进行绘图缓存
        view.setDrawingCacheEnabled(true);
        //如果不能进行绘制缓存，需要轻质构建绘图缓存
        view.buildDrawingCache();
        //返回这个缓存视图
        bitmap = view.getDrawingCache();

        //获取状态栏高度
        Rect frame = new Rect();
        //测量屏幕的宽高
        view.getWindowVisibleDisplayFrame(frame);
        int statusHeight = frame.top;
        Log.e("screen shot :","statusHeight"+ statusHeight);

        int width = activity.getWindowManager().getDefaultDisplay().getWidth();
        int height = activity.getWindowManager().getDefaultDisplay().getHeight();

        //根据坐标点和需要的宽高创建bitmap
        bitmap = Bitmap.createBitmap(bitmap,0,statusHeight,width,height-statusHeight);

        return bitmap;
    }


    //保存图片到sd卡中
    public static boolean savePic(Bitmap bitmap,String strName){
        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream(strName);
            if(fos != null){
                bitmap.compress(Bitmap.CompressFormat.PNG,90,fos);
                fos.flush();
                fos.close();
                return true;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }


    //截图
    public static boolean shotBitmap(Activity activity){
        return ScreenShotUtil.savePic(takeScreenShot(activity),"sdcard/share_screen_shot.png");
    }





}
