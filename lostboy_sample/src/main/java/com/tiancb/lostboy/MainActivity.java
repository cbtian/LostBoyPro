package com.tiancb.lostboy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tiancb.lostboylib.https.OkHttpUtils;
import com.tiancb.lostboylib.https.callback.StringCallback;

import butterknife.ButterKnife;
import butterknife.InjectView;
import okhttp3.Call;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.button)
    Button button;
    @InjectView(R.id.text)
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OkHttpUtils
                        .get()
                        .addHeader("Cache-Time","1000")
                        .url("http://www.391k.com/api/xapi.ashx/info.json?key=bd_hyrzjjfb4modhj&size=10&page=1")
                        .build()
                        .execute(new MyCallBack());
            }
        });
    }

    public class MyCallBack extends StringCallback{
        @Override
        public void onError(Call call, Exception e, int id) {
            text.setText("onError = " + e.getMessage());
        }

        @Override
        public void onResponse(String response, int id) {
            text.setText("onResponse = " + response);
        }
    }

}
