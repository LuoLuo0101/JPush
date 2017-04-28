package com.luo.jpushs.app;

import android.app.Application;
import android.util.Log;

import com.luo.jpush.DeviceUtils;

import java.util.HashSet;
import java.util.Set;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;

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
        HashSet<String> tags = new HashSet<>();
        tags.add(DeviceUtils.getMD5(DeviceUtils.getUUID(this)));
        JPushInterface.setTags(this, tags, new TagAliasCallback() {
            @Override
            public void gotResult(int i, String s, Set<String> set) {
                String tags = "";
                for (String tag : set) {
                    tags += tag;
                }
                Log.e("自定义标签", "类名==MyApp" + "方法名==gotResult=====:" + tags);
            }
        });
    }
}
