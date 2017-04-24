package com.tiancb.lostboylib.https.httputils;

/**
 * Created by tiancb on 2017/4/24.
 */
public class Exceptions {
    public static void illegalArgument(String msg, Object... params) {
        throw new IllegalArgumentException(String.format(msg, params));
    }


}
