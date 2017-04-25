package com.tiancb.lostboy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tiancb.lostboylib.https.OkHttpUtils;
import com.tiancb.lostboylib.https.callback.StringCallback;
import com.tiancb.lostboylib.utils.TLog;

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
                        .url("http://www.jianshu.com/p/1ef0ba0bccc6")
                        .build()
                        .execute(new MyCallBack());
            }
        });
    }

    public class MyCallBack extends StringCallback{
        @Override
        public void onError(Call call, Exception e, int id) {
            TLog.log("onError = " + e.getMessage());
            text.setText("onError = " + e.getMessage());
        }

        @Override
        public void onResponse(String response, int id) {
            TLog.log("onResponse = " + response);
            text.setText("onResponse = " + response);
        }
    }

}
