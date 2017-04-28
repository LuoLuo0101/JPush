package com.luo.jpushs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import cn.jpush.android.api.JPushInterface;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button resumePush;
    private Button stopPush;
    private Button isStopPush;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        resumePush = (Button) findViewById(R.id.resumePush);
        stopPush = (Button) findViewById(R.id.stopPush);
        isStopPush = (Button) findViewById(R.id.isStopPush);
        resumePush.setOnClickListener(this);
        stopPush.setOnClickListener(this);
        isStopPush.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.resumePush:
                JPushInterface.resumePush(v.getContext());
                break;
            case R.id.stopPush:
                JPushInterface.stopPush(v.getContext());
                break;
            case R.id.isStopPush:
                boolean isStop = JPushInterface.isPushStopped(v.getContext());
                Toast.makeText(this, isStop ? "停止了推送" : "开始了推送", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
