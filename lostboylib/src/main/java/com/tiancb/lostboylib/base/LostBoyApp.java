package com.tiancb.lostboylib.base;

import android.app.Application;
import android.content.res.Configuration;

import com.franmontiel.persistentcookiejar.ClearableCookieJar;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.tiancb.lostboylib.https.OkHttpUtils;
import com.tiancb.lostboylib.https.httputils.HttpsUtils;
import com.tiancb.lostboylib.https.interceptor.CacheInterceptor;
import com.tiancb.lostboylib.https.log.LoggerInterceptor;
import com.tiancb.lostboylib.https.provide.CacheProvide;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.OkHttpClient;

/**
 * 初始化自己的sdk  在新的项目中继承sdk时只需要继承这个application就可以
 * Created by tiancb on 2017/4/24.
 */

public class LostBoyApp extends Application {

    private static LostBoyApp instance;
    public static LostBoyApp getInstance() {
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        initSdk();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }

    public void initSdk() {
        instance = this;
        initHttpUtils();
    }
    /**
     * 初始化okhttps
     */
    /**
     * http://blog.csdn.net/u010286855/article/details/52608485   需要继续完善okhttpClient设置
     * 需要添加addNetworkInterceptor和网络超时设置
     *
     * PersistentCookieStore //持久化cookie
     * SerializableHttpCookie //持久化cookie
     * MemoryCookieStore //cookie信息存在内存中
     */

    private void initHttpUtils() {

        ClearableCookieJar cookieJar1 = new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(getApplicationContext()));
        HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory(null, null, null);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .addInterceptor(new LoggerInterceptor("TAG"))
                .addNetworkInterceptor(new CacheInterceptor())//添加网络拦截器
                .cache(new CacheProvide(getApplicationContext()).provideCache())//添加缓存路径
                .cookieJar(cookieJar1)
                .hostnameVerifier(new HostnameVerifier() {
                    @Override
                    public boolean verify(String hostname, SSLSession session) {
                        return true;
                    }
                })
                .sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
                .build();
        OkHttpUtils.initClient(okHttpClient);
    }


}
