package com.bawei.dome_zb;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

/**
 * Created by hasee on 2018/9/29.
 */


@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
public class NotificationMonitor extends NotificationListenerService {

    @SuppressLint("NewApi")
    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        //有新通知添加的时候调用
        Log.e("onNotificationPosted","posted");

        Log.i("xiaolong", "open" + "-----" + sbn.getPackageName());
        Log.i("xiaolong", "open" + "------" + sbn.getNotification().tickerText);
        Log.i("xiaolong", "open" + "-----" + sbn.getNotification().extras.get("android.title"));
        Log.i("xiaolong", "open" + "-----" + sbn.getNotification().extras.get("android.text"));
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
        //通知被移除的时候调用
        Log.e("onNotificationRemoved","posted");
        Log.i("xiaolong", "remove" + "-----" + sbn.getPackageName());



    }

    private boolean isNotificationServiceEnable() {
        return NotificationManagerCompat.getEnabledListenerPackages(this).contains(getPackageName());    }

}
