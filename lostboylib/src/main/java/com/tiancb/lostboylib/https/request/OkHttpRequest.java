package com.tiancb.lostboylib.https.request;


import com.tiancb.lostboylib.https.callback.Callback;
import com.tiancb.lostboylib.https.httputils.Exceptions;
import com.tiancb.lostboylib.utils.TLog;
import com.tiancb.lostboylib.utils.ToastUtils;

import java.util.Map;

import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by tiancb on 2017/4/24.
 */
public abstract class OkHttpRequest {
    protected String url;
    protected Object tag;
    protected Map<String, String> params;
    protected Map<String, String> headers;
    protected int id;

    protected Request.Builder builder = new Request.Builder();

    protected OkHttpRequest(String url, Object tag,
                            Map<String, String> params, Map<String, String> headers, int id) {
        this.url = url;
        this.tag = tag;
        this.params = params;
        this.headers = headers;
        this.id = id;

        if (url == null) {
            Exceptions.illegalArgument("url can not be null.");
        }
        String string = "http请求  url = " + url;
        if (params != null){
            string = string+", 参数 = " + params.toString();
        }else if (tag != null){
            string = string+", tag = "+ tag;
        }
        string = string +", id = "+ id;
        TLog.error(string);
        ToastUtils.showDebugMessage(string);
        initBuilder();
    }


    /**
     * 初始化一些基本参数 url , tag , headers
     */
    private void initBuilder() {
        builder.url(url).tag(tag);
        appendHeaders();
    }

    protected abstract RequestBody buildRequestBody();

    protected RequestBody wrapRequestBody(RequestBody requestBody, final Callback callback) {
        return requestBody;
    }

    protected abstract Request buildRequest(RequestBody requestBody);

    public RequestCall build() {
        return new RequestCall(this);
    }


    public Request generateRequest(Callback callback) {
        RequestBody requestBody = buildRequestBody();
        RequestBody wrappedRequestBody = wrapRequestBody(requestBody, callback);
        Request request = buildRequest(wrappedRequestBody);
        return request;
    }


    protected void appendHeaders() {
        Headers.Builder headerBuilder = new Headers.Builder();
        if (headers == null || headers.isEmpty()) return;

        for (String key : headers.keySet()) {
            headerBuilder.add(key, headers.get(key));
        }
        builder.headers(headerBuilder.build());
    }

    public int getId() {
        return id;
    }

}
