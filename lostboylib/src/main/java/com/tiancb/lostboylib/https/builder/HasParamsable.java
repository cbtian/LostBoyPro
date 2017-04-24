package com.tiancb.lostboylib.https.builder;

import java.util.Map;

/**
 * Created by tiancb on 2017/4/24.
 */
public interface HasParamsable
{
    OkHttpRequestBuilder params(Map<String, String> params);
    OkHttpRequestBuilder addParams(String key, String val);
}
