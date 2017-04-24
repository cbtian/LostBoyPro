package com.tiancb.lostboylib.https.callback;

/**
 * Created by tiancb on 2017/4/24.
 */
public interface IGenericsSerializator {
    <T> T transform(String response, Class<T> classOfT);
}
