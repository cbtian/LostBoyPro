package com.tiancb.lostboylib.https.builder;


import com.tiancb.lostboylib.https.request.PostFileRequest;
import com.tiancb.lostboylib.https.request.RequestCall;

import java.io.File;

import okhttp3.MediaType;

/**
 * Created by tiancb on 2017/4/24.
 */
public class PostFileBuilder extends OkHttpRequestBuilder<PostFileBuilder> {
    private File file;
    private MediaType mediaType;


    public OkHttpRequestBuilder file(File file) {
        this.file = file;
        return this;
    }

    public OkHttpRequestBuilder mediaType(MediaType mediaType) {
        this.mediaType = mediaType;
        return this;
    }

    @Override
    public RequestCall build() {
        return new PostFileRequest(url, tag, params, headers, file, mediaType, id).build();
    }


}
