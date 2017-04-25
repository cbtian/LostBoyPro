package com.tiancb.lostboylib.https.interceptor;

import android.text.TextUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by tiancb on 2017/4/25.
 */

public class CacheInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
//        Request request = chain.request();
//        if (!NetWorkUtils.isConnected(LostBoyApp.getInstance().getApplicationContext())){
//            request = request.newBuilder()
//                            .cacheControl(CacheControl.FORCE_CACHE)
//                            .build();
//        }
//        Response response = chain.proceed(request);
//        if (NetWorkUtils.isConnected(LostBoyApp.getInstance().getApplicationContext())){
//            String cacheContrl =  request.cacheControl().toString();
//            return response.newBuilder()
//                    .header("Cache-Control", "max-age="+0)
//                    .removeHeader("Pragma")
//                    .build();
//        }else {
//            int maxTime = 4*24*60*60;
//            return response.newBuilder()
//                    //这里的设置的是我们的没有网络的缓存时间，想设置多少就是多少。
//                    .header("Cache-Control", "public, only-if-cached, max-stale="+maxTime)
//                    .removeHeader("Pragma")
//                    .build();
//        }
        Request request = chain.request();
        Response response = chain.proceed(request);
        String cache = request.header("Cache-Time");
        if (!TextUtils.isEmpty(cache)) {//缓存时间不为空
            Response response1 = response.newBuilder()
                    .removeHeader("Pragma")
                    .removeHeader("Cache-Control")
                    //cache for cache seconds
                    .header("Cache-Control", "max-age="+cache)
                    .build();
            return response1;
        } else {
            return response;
        }
    }
}
