package com.luo.jpush;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import cn.jpush.android.api.JPushInterface;

/**
 * MyReceiver by Luo.
 * <p>
 * Created by Luo on 2017/4/28 0028.
 */
public class MyReceiver extends BroadcastReceiver {

    /**
     * 这里接收到来自极光推送的东西
     *
     * @param context 上下文对象
     * @param intent  意图
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        String action = intent.getAction();

        if (JPushInterface.ACTION_REGISTRATION_ID.equals(action)) {
            // SDK 向 JPush Server 注册所得到的注册 ID
            // SDK 向 JPush Server 注册所得到的注册 全局唯一的 ID ，可以通过此 ID 向对应的客户端发送消息和通知
            String regId = bundle.getString(JPushInterface.EXTRA_REGISTRATION_ID);
            Log.e("自定义标签", "类名==MyReceiver" + "方法名==onReceive=====接收Registration Id:" + regId);
            //send the Registration Id to your server...
            // 发送这个Id到你的服务端
        } else if (JPushInterface.ACTION_MESSAGE_RECEIVED.equals(action)) {
            String title = bundle.getString(JPushInterface.EXTRA_TITLE);
            Log.e("自定义标签", "类名==MyReceiver" + "方法名==onReceive=====ACTION_MESSAGE_RECEIVED:" + title);
            String message = bundle.getString(JPushInterface.EXTRA_MESSAGE);
            Log.e("自定义标签", "类名==MyReceiver" + "方法名==onReceive=====ACTION_MESSAGE_RECEIVED:" + message);
            String extras = bundle.getString(JPushInterface.EXTRA_EXTRA);
            Log.e("自定义标签", "类名==MyReceiver" + "方法名==onReceive=====ACTION_MESSAGE_RECEIVED:" + extras);
            String file = bundle.getString(JPushInterface.EXTRA_MSG_ID);
            Log.e("自定义标签", "类名==MyReceiver" + "方法名==onReceive=====ACTION_MESSAGE_RECEIVED:" + file);

        } else if (JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals(action)) {
            String title = bundle.getString(JPushInterface.EXTRA_NOTIFICATION_TITLE);
            Log.e("自定义标签", "类名==MyReceiver" + "方法名==onReceive=====ACTION_NOTIFICATION_RECEIVED:" + title);
            String content = bundle.getString(JPushInterface.EXTRA_ALERT);
            Log.e("自定义标签", "类名==MyReceiver" + "方法名==onReceive=====ACTION_NOTIFICATION_RECEIVED:" + content);
            String extras = bundle.getString(JPushInterface.EXTRA_EXTRA);
            Log.e("自定义标签", "类名==MyReceiver" + "方法名==onReceive=====ACTION_NOTIFICATION_RECEIVED:" + extras);
            int notifactionId = bundle.getInt(JPushInterface.EXTRA_NOTIFICATION_ID);
            Log.e("自定义标签", "类名==MyReceiver" + "方法名==onReceive=====ACTION_NOTIFICATION_RECEIVED:" + notifactionId);
            String fileHtml = bundle.getString(JPushInterface.EXTRA_RICHPUSH_HTML_PATH);
            Log.e("自定义标签", "类名==MyReceiver" + "方法名==onReceive=====ACTION_NOTIFICATION_RECEIVED:" + fileHtml);
            String fileStr = bundle.getString(JPushInterface.EXTRA_RICHPUSH_HTML_RES);
            Log.e("自定义标签", "类名==MyReceiver" + "方法名==onReceive=====ACTION_NOTIFICATION_RECEIVED:" + fileStr);
            String file = bundle.getString(JPushInterface.EXTRA_MSG_ID);
            Log.e("自定义标签", "类名==MyReceiver" + "方法名==onReceive=====ACTION_NOTIFICATION_RECEIVED:" + file);
            String bigText = bundle.getString(JPushInterface.EXTRA_BIG_TEXT);
            Log.e("自定义标签", "类名==MyReceiver" + "方法名==onReceive=====ACTION_NOTIFICATION_RECEIVED:" + bigText);
            String bigPicPath = bundle.getString(JPushInterface.EXTRA_BIG_PIC_PATH);
            Log.e("自定义标签", "类名==MyReceiver" + "方法名==onReceive=====ACTION_NOTIFICATION_RECEIVED:" + bigPicPath);
            String inboxJson = bundle.getString(JPushInterface.EXTRA_INBOX);
            Log.e("自定义标签", "类名==MyReceiver" + "方法名==onReceive=====ACTION_NOTIFICATION_RECEIVED:" + inboxJson);
            String priority = bundle.getString(JPushInterface.EXTRA_NOTI_PRIORITY);
            Log.e("自定义标签", "类名==MyReceiver" + "方法名==onReceive=====ACTION_NOTIFICATION_RECEIVED:" + priority);
            String category = bundle.getString(JPushInterface.EXTRA_NOTI_CATEGORY);
            Log.e("自定义标签", "类名==MyReceiver" + "方法名==onReceive=====ACTION_NOTIFICATION_RECEIVED:" + category);

        } else if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(action)) {
            String title = bundle.getString(JPushInterface.EXTRA_NOTIFICATION_TITLE);
            Log.e("自定义标签", "类名==MyReceiver" + "方法名==onReceive=====ACTION_NOTIFICATION_OPENED:" + title);
            String content = bundle.getString(JPushInterface.EXTRA_ALERT);
            Log.e("自定义标签", "类名==MyReceiver" + "方法名==onReceive=====ACTION_NOTIFICATION_OPENED:" + content);
            String type = bundle.getString(JPushInterface.EXTRA_EXTRA);
            Log.e("自定义标签", "类名==MyReceiver" + "方法名==onReceive=====ACTION_NOTIFICATION_OPENED:" + type);
            int notificationId = bundle.getInt(JPushInterface.EXTRA_NOTIFICATION_ID);
            Log.e("自定义标签", "类名==MyReceiver" + "方法名==onReceive=====ACTION_NOTIFICATION_OPENED:" + notificationId);
            String file = bundle.getString(JPushInterface.EXTRA_MSG_ID);
            Log.e("自定义标签", "类名==MyReceiver" + "方法名==onReceive=====ACTION_NOTIFICATION_OPENED:" + file);
            //打开自定义的Activity
//            Intent i = new Intent(context, TestActivity.class);
//            i.putExtras(bundle);
//            //i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            context.startActivity(i);

        } else if (JPushInterface.ACTION_RICHPUSH_CALLBACK.equals(action)) {
            String extra = bundle.getString(JPushInterface.EXTRA_EXTRA);
            Log.e("自定义标签", "类名==MyReceiver" + "方法名==onReceive=====用户收到到RICH PUSH CALLBACK:" + extra);
            //在这里根据 JPushInterface.EXTRA_EXTRA 的内容处理代码，比如打开新的Activity， 打开一个网页等..

        } else if (JPushInterface.ACTION_CONNECTION_CHANGE.equals(action)) {
            boolean connected = intent.getBooleanExtra(JPushInterface.EXTRA_CONNECTION_CHANGE, false);
            Log.e("自定义标签", "类名==MyReceiver" + "方法名==onReceive=====连接状态:" + connected);
        } else {
            Log.e("自定义标签", "类名==MyReceiver" + "方法名==onReceive=====未处理的Intent:" + action);
        }
    }
}
