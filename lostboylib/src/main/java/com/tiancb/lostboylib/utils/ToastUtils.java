package com.tiancb.lostboylib.utils;

import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.tiancb.lostboylib.base.LostBoyApp;
import com.tiancb.lostboylib.base.LostBoyMultiDexApp;

/**
 * Created by tiancb on 2017/4/24.
 */

public class ToastUtils {
    public static boolean DEBUG = true;

    private static Handler handler = new Handler(Looper.getMainLooper());

    private static Toast toast = null;

    private static Object synObj = new Object();

    /**
     * 用于调试的时候显示数据
     * @param msg
     */
    public static void showDebugMessage(final String msg){
        if (DEBUG){
            showMessage(msg);
        }

    }
    public static void showMessage(final String msg) {
        showMessage(msg, Toast.LENGTH_SHORT);
    }

    /**
     * 根据设置的文本显示
     * @param msg
     */
    public static void showMessage(final int msg) {
        showMessage(msg, Toast.LENGTH_SHORT);
    }

    /**
     * 显示一个文本并且设置时长
     * @param msg
     * @param len
     */
    public static void showMessage(final CharSequence msg, final int len) {
        if (msg == null || msg.equals("")) {
            //LogUtil.w("[ToastUtil] response message is null.");
            return;
        }



        handler.post(new Runnable() {
            @Override
            public void run() {
                synchronized (synObj) { //加上同步是为了每个toast只要有机会显示出来
                    if (toast != null) {
                        //toast.cancel();
                        toast.setText(msg);
                        toast.setDuration(len);
                    } else {
                        if (LostBoyApp.getInstance() != null){
                            toast = Toast.makeText(LostBoyApp.getInstance().getApplicationContext(), msg, len);
                        }else if(LostBoyMultiDexApp.getInstance() != null){
                            toast = Toast.makeText(LostBoyMultiDexApp.getInstance().getApplicationContext(), msg, len);
                        }
                    }
                    toast.show();
                }
            }
        });
    }

    /**
     * 资源文件方式显示文本
     * @param msg
     * @param len
     */
    public static void showMessage(final int msg, final int len) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                synchronized (synObj) {
                    if (toast != null) {
                        //toast.cancel();
                        toast.setText(msg);
                        toast.setDuration(len);
                   } else {
                        if (LostBoyApp.getInstance() != null){
                            toast = Toast.makeText(LostBoyApp.getInstance().getApplicationContext(), msg, len);
                        }else if(LostBoyMultiDexApp.getInstance() != null){
                            toast = Toast.makeText(LostBoyMultiDexApp.getInstance().getApplicationContext(), msg, len);
                        }


                    }
                    toast.show();
                }
            }
        });
    }
}
