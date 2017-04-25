package com.tiancb.lostboylib.glide;

import android.graphics.Bitmap;

/**
 * Created by tiancb on 2017/4/25.
 */

public interface BitmapLoadingListener {

    void onSuccess(Bitmap b);

    void onError();
}
