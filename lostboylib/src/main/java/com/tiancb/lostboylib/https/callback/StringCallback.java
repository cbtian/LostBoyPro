package com.tiancb.lostboylib.https.callback;

import java.io.IOException;

import okhttp3.Response;

/**
 * Created by tiancb on 2017/4/24.
 */
public abstract class StringCallback extends Callback<String> {
    @Override
    public String parseNetworkResponse(Response response, int id) throws IOException {
        return response.body().string();
    }
}
