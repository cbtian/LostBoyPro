package com.tiancb.lostboylib.https.httputils;

import android.util.Log;

/**
 * Created by tiancb on 2017/4/24.
 */
public class L {
    private static boolean debug = false;

    public static void e(String msg) {
        if (debug) {
            Log.e("OkHttp", msg);
        }
    }

}

