package com.tiancb.lostboy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.tiancb.lostboylib.glide.ImageLoadConfig;
import com.tiancb.lostboylib.glide.ImageLoader;
import com.tiancb.lostboylib.glide.LoaderListener;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.button)
    Button button;
    @InjectView(R.id.text)
    ImageView text;
    String url = "http://pic6.huitu.com/res/20130116/84481_20130116142820494200_1.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
      final  ImageLoadConfig imageLoadConfig = new ImageLoadConfig.Builder().
                setCropType(ImageLoadConfig.CENTER_CROP).
                setAsBitmap(true).
            setPlaceHolderResId(R.mipmap.ic_launcher).
            setErrorResId(R.mipmap.ic_launcher).
        setDiskCacheStrategy(ImageLoadConfig.DiskCache.SOURCE).
                        setPrioriy(ImageLoadConfig.LoadPriority.HIGH).build();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ImageLoader.loadBitmap(MainActivity.this, url, new BitmapLoadingListener() {
//                    @Override
//                    public void onSuccess(Bitmap b) {
//                        text.setImageBitmap(b);
//                    }
//
//                    @Override
//                    public void onError() {
//
//                    }
//                });

                ImageLoader.loadStringRes(text, url, imageLoadConfig, new LoaderListener() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {

                    }
                });

//                OkHttpUtils
//                        .get()
//                        .addHeader("Cache-Time","1000")
//                        .url("http://www.391k.com/api/xapi.ashx/info.json?key=bd_hyrzjjfb4modhj&size=10&page=1")
//                        .build()
//                        .execute(new MyCallBack());
            }
        });





    }

//    public class MyCallBack extends StringCallback{
//        @Override
//        public void onError(Call call, Exception e, int id) {
//            text.setText("onError = " + e.getMessage());
//        }
//
//        @Override
//        public void onResponse(String response, int id) {
//            text.setText("onResponse = " + response);
//        }
//    }

}
