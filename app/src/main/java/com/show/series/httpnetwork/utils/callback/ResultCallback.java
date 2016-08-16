package com.show.series.httpnetwork.utils.callback;

import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by lihf on 16/8/16.
 */
public abstract class ResultCallback extends Callback<String> {

    @Override
    public String parseNetworkResponse(Response response) throws Exception {

        return response.body().string();
    }


}
