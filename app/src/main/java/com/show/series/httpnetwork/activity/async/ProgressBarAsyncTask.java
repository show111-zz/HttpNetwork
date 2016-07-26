package com.show.series.httpnetwork.activity.async;

import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by lihf on 16/7/21.
 */
public class ProgressBarAsyncTask extends AsyncTask<String, Integer, String> {

    //第一个为doInBackground接受的参数，第二个为显示进度的参数，第第三个为doInBackground返回和onPostExecute传入的参数。
    private TextView textView;
    private ProgressBar mProgressBar;

    public ProgressBarAsyncTask(TextView textView, ProgressBar mProgressBar) {
        this.textView = textView;
        this.mProgressBar = mProgressBar;
    }

    //准备工作，如在界面上显示一个进度条，或者一些控件的实例化
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mProgressBar.setMax(100);
        textView.setText("start downloading...");
    }

    @Override
    protected String doInBackground(String... params) {
        String url = params[0];
        String dirName = Environment.getExternalStorageState() + "/myDownload/";
        File f = new File(dirName);
        if (!f.exists()) {
            f.mkdir();//只能在已经存在的目录中创建创建文件夹。
            //file.mkdirs()  可以在不存在的目录中创建文件夹。诸如：a\\b,既可以创建多级目录
        }
        //拼接新的文件名（保存到存储卡后的文件名）
        String newFileName = url.substring(url.lastIndexOf("/") + 1);
        newFileName = dirName + newFileName;
        File file = new File(newFileName);

        //如果目标文件已经存在，则删除，起到覆盖旧文件的效果
        if (file.exists()) {
            file.delete();
        }

        try {
            //打开连接
            HttpURLConnection connection = (HttpURLConnection) (new URL(url)).openConnection();
            connection.connect();
            int documentSize = connection.getContentLength();

            InputStream inputStream = connection.getInputStream();
            byte[] byteOfDocument = new byte[1024];
            int tempLength;
            int completeLength = 0;
            //输出流
            OutputStream outputStream = new FileOutputStream(newFileName);

            //读取数据
            while((tempLength = inputStream.read(byteOfDocument)) != -1){
                completeLength += tempLength;
                int completePercent = (completeLength/documentSize)*100;
                publishProgress(completePercent);
                outputStream.write(byteOfDocument,0,tempLength);
            }
            inputStream.close();
            outputStream.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "网络存在问题，请检查！";
        } catch (IOException e) {
            e.printStackTrace();
            return "存储文件出错，请检查！";
        }


        return "download complete";
    }

    //一个进度条进行展示
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        int value = values[0];
        mProgressBar.setProgress(value);
    }

    //UI 线程，并且在界面上展示给用户
    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        textView.setText(result);
    }

    //在用户取消线程操作的时候调用。在主线程中调用onCancelled()的时候调用
    @Override
    protected void onCancelled() {
        super.onCancelled();
        Log.e("ProgressTask","onCancelled");
    }


}
