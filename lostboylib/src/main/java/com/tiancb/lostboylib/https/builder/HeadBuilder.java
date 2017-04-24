package com.tiancb.lostboylib.https.builder;


import com.tiancb.lostboylib.https.OkHttpUtils;
import com.tiancb.lostboylib.https.request.OtherRequest;
import com.tiancb.lostboylib.https.request.RequestCall;

/**
 * Created by tiancb on 2017/4/24.
 */
public class HeadBuilder extends GetBuilder {
    @Override
    public RequestCall build() {
        return new OtherRequest(null, null, OkHttpUtils.METHOD.HEAD, url, tag, params, headers, id).build();
    }
}
