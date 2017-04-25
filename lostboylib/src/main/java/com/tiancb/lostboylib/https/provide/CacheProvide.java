package com.tiancb.lostboylib.https.provide;

import android.content.Context;

import com.tiancb.lostboylib.utils.TLog;

import okhttp3.Cache;

/**
 * Created by tiancb on 2017/4/25.
 */

public class CacheProvide {
    Context mContext;

    public CacheProvide(Context context){
        mContext = context;
    }

    public Cache provideCache(){
        TLog.log("mContext.getCacheDir() = " + mContext.getCacheDir());
        return new Cache(mContext.getCacheDir(),1024*1024*10);
    }
}
