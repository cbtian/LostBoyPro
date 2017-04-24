package com.tiancb.lostboylib.https.builder;


import com.tiancb.lostboylib.https.request.PostStringRequest;
import com.tiancb.lostboylib.https.request.RequestCall;

import okhttp3.MediaType;

/**
 * Created by tiancb on 2017/4/24.
 */
public class PostStringBuilder extends OkHttpRequestBuilder<PostStringBuilder> {
    private String content;
    private MediaType mediaType;


    public PostStringBuilder content(String content) {
        this.content = content;
        return this;
    }

    public PostStringBuilder mediaType(MediaType mediaType) {
        this.mediaType = mediaType;
        return this;
    }

    @Override
    public RequestCall build() {
        return new PostStringRequest(url, tag, params, headers, content, mediaType, id).build();
    }


}
