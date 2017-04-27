package com.luo.jpush.app;

import android.app.Application;

import cn.jpush.android.api.JPushInterface;

/**
 * MyApp by Luo.
 * <p>
 * Created by Luo on 2017/4/27 0027.
 */
public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // 设置调试模式，这样就有日志信息，当项目上线的时候可以关闭
        JPushInterface.setDebugMode(true);
        // JPush 推送 SDK 的初始化
        JPushInterface.init(this);
    }
}
