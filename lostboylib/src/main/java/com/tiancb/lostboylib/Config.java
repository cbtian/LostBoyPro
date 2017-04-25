package com.tiancb.lostboylib;

import com.tiancb.lostboylib.utils.TLog;
import com.tiancb.lostboylib.utils.ToastUtils;

/**
 * Created by tiancb on 2017/4/25.
 */

public class Config {
    public static boolean DEBUG = true;
    public static void ConfigInit(){
        if (DEBUG){
            TLog.DEBUG = true;
            ToastUtils.DEBUG = true;
        }else {
            TLog.DEBUG = false;
            ToastUtils.DEBUG = false;
        }
    }

    /**
     *  只开启日志调试
     */
    public static void debugLog(){
        TLog.DEBUG = true;
        ToastUtils.DEBUG = false;
    }

    /**
     * 只开启Toast调试
     */
    public static void debugToast(){
        TLog.DEBUG = false;
        ToastUtils.DEBUG = true;
    }
}
