package com.show.series.httpnetwork.utils.http;

import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.show.series.httpnetwork.model.CommonProtocolModel;
import com.show.series.httpnetwork.utils.OkHttpUtils;
import com.show.series.httpnetwork.utils.callback.ResultCallback;
import com.show.series.httpnetwork.view.UrlContants;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONObject;

import java.security.Key;

import okhttp3.Call;

/**
 * Created by lihf on 16/8/15.
 */
public class PasserbyClient {


    public static boolean invalidToken;


    public static void get(String url, final ResultCallback callback, Object... params) {
        get(url, true, callback, params);
    }

    public static void get(String url, boolean appendDefaultParams, final ResultCallback callback, Object[] params) {
        final String completeUrl = getCompleteUrl(url, appendDefaultParams, params);
        Log.e("PasserbyClient",completeUrl);
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e) {
                try {
                    if (callback != null) {
                        callback.onError(call,e);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void onResponse(String response) {
                if (!TextUtils.isEmpty(response)) {
                    try {
                        CommonProtocolModel protocol = new Gson().fromJson(response, CommonProtocolModel.class);
                        if(protocol.header.status.equals("1")){
                            if(callback != null){
                                invalidToken = false;
                                callback.onResponse(new JSONObject(response).optString("body"));
                            }
                            return;
                        }else if("6".equals(protocol.header.status)){
                           if(!invalidToken){
                               invalidToken = true;
                           }
                            return;
                        }else if("2".equals(protocol.header.status)){
                            invalidToken = false;
//                            callback.onFailure();
                            return;
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }

    private static String getCompleteUrl(String url, boolean appendDefaultParams, Object... params) {
        url = String.format(url, params);
        if (appendDefaultParams) {
            url = appendDefaultGetParams(url);
        }

        return url;
    }


    private static String appendDefaultGetParams(String url) {

        return url + "&devid=ffffffff-a301-7ba5-e498-5a5c00000000&pcode=01011000&version=2.0.0" + "&token=" + UrlContants.tokenTest;
    }


    public static interface HttpCallback {
        void onSuccess(String result);

        void onFailure(Exception ex);
    }


}
