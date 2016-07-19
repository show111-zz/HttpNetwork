package com.show.series.httpnetwork.utils;

import android.app.Activity;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by lihf on 16/6/14.
 */
public class FileUtils {

    // 保存到SD卡
    private static String sdState = Environment.getExternalStorageState();
    private static String path = Environment.getExternalStorageDirectory().toString();


    public static void saveBitmap(Bitmap bitmap, String imageName) {
        File file;
        File PicName;
        if (sdState.equals(Environment.MEDIA_MOUNTED)) {
            // 获得sd卡根目录
            file = new File(path + "/Huai/TicketsPic");
            if (!file.exists()) {
                file.mkdirs();
            }
            PicName = new File(file, imageName);
            try {
                if (!PicName.exists()) {
                    PicName.createNewFile();
                }
                FileOutputStream fos = new FileOutputStream(PicName);
                if (PicName.getName().endsWith(".png")) {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
                } else if (PicName.getName().endsWith(".jpg")) {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                }
                fos.flush();
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    // 从SD卡取
    public static Bitmap getBitmap(String imageName) {
        Bitmap bitmap = null;
        File imagePic;
        if (sdState.equals(Environment.MEDIA_MOUNTED)) {

            imagePic = new File(path + "/Huai/TicketsPic", imageName);
            if (imagePic.exists()) {
                try {
                    bitmap = BitmapFactory.decodeStream(new FileInputStream(imagePic));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return bitmap;
    }


    //获取图片存储地址
    public static String getExternDir(String dir) {
        String path = Environment.getExternalStorageDirectory().getAbsolutePath();
        if (dir != null) {
            path += dir;
        }
        return path;
    }



    /**
     * 将uri转换为String
     */
    public static String UriToString(Uri uri, Activity act) {
        String img_path = null;
        if(uri != null && act != null){
            String path = "";
            String[] proj = { MediaStore.Images.Media.DATA };
            Cursor actualimagecursor = act.managedQuery(uri, proj, null, null, null);
            int actual_image_column_index = actualimagecursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            actualimagecursor.moveToFirst();
            img_path = actualimagecursor.getString(actual_image_column_index);
        }
        return img_path;
    }

    /**
     * 将String转换为uri
     */
    public String uriToRealPath(Activity act, Uri uri) {
        Cursor cursor = act.getContentResolver().query(uri,
                new String[]{MediaStore.Images.Media.DATA},
                null,
                null,
                null);
        cursor.moveToFirst();
        String path = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA));
        return path;
    }


}
