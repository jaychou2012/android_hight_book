package com.td.assist.utils;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.widget.RemoteViews;

import com.td.assist.R;
import com.td.assist.ui.MainActivity;

public class NotificationUtils {
    private Context context;
    private Notification notification;
    private String channelId = "channel";
    private int notificationId = 1;

    public NotificationUtils(Context context) {
        this.context = context;
    }

    public void showNotification() {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence channelName = "channelName";
            String channelDescription = "channelDescription";
            int channelImportance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel notificationChannel = new NotificationChannel(channelId, channelName, channelImportance);
            notificationChannel.setDescription(channelDescription);
            notificationChannel.setLockscreenVisibility(NotificationCompat.VISIBILITY_PUBLIC);
            notificationManager.createNotificationChannel(notificationChannel);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context, channelId);
            builder.setSmallIcon(R.mipmap.ic_launcher)//设置通知小图标在状态栏显示（必须设置）
                    //设置通知大图标，在通知栏显示
                    .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher))
                    //通知产生的时间，会在通知信息里显示，一般是系统获取到的时间
                    .setWhen(System.currentTimeMillis())
                    //设置该通知优先级
                    .setPriority(Notification.PRIORITY_HIGH)
                    //通知首次出现在通知栏，带上升动画效果的
                    .setTicker("标题Ticker")
                    //设置通知栏标题
                    .setContentTitle("标题ContentTitle")
                    //设置通知栏内容
                    .setContentText("标题ContentText")
                    //ture
                    .setOngoing(true)
                    //设置这个标志当用户单击面板就可以让通知将自动取消
                    .setAutoCancel(false);
            //创建PendingIntent，处理点击通知之后的逻辑
            Intent intent = new Intent(context, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
            builder.setContentIntent(pendingIntent);
            notification = builder.build();
            NotificationManagerCompat.from(context).notify(notificationId, notification);
        } else {
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context,channelId);
            mBuilder.setContentTitle("标题ContentTitle")//设置通知栏标题
                    //通知首次出现在通知栏，带上升动画效果的
                    .setTicker("标题Ticker")
                    //通知产生的时间，会在通知信息里显示，一般是系统获取到的时间
                    .setWhen(System.currentTimeMillis())
                    //设置该通知优先级
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    //设置通知栏内容
                    .setContentText("标题ContentText")
                    //设置通知大图标，在通知栏显示
                    .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher))
                    //设置这个标志当用户单击面板就可以让通知将自动取消
                    .setAutoCancel(false)
                    //ture
                    .setOngoing(true)
                    //设置通知小图标在状态栏显示（必须设置）
                    .setSmallIcon(R.mipmap.ic_launcher);//设置通知小ICON
            Intent intent = new Intent(context, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
            mBuilder.setContentIntent(pendingIntent);
            notification = mBuilder.build();
            if (notificationManager != null) {
                notificationManager.notify(notificationId, notification);
            }
        }
    }

    public void showNotification(int layoutId) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        RemoteViews views = new RemoteViews(context.getPackageName(), layoutId);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence channelName = "channelName";
            String channelDescription = "channelDescription";
            int channelImportance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel notificationChannel = new NotificationChannel(channelId, channelName, channelImportance);
            notificationChannel.setDescription(channelDescription);
            notificationChannel.setVibrationPattern(new long[]{0});
            notificationChannel.enableLights(false);
            notificationChannel.enableVibration(false);
            notificationChannel.setSound(null, null);
            notificationChannel.setLockscreenVisibility(NotificationCompat.VISIBILITY_PUBLIC);
            notificationManager.createNotificationChannel(notificationChannel);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context, channelId);
            builder.setSmallIcon(R.mipmap.ic_launcher)//设置通知小图标在状态栏显示（必须设置）
                    //设置通知大图标，在通知栏显示
                    .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher))
                    //通知产生的时间，会在通知信息里显示，一般是系统获取到的时间
                    .setWhen(System.currentTimeMillis())
                    .setContent(views)
                    //通知首次出现在通知栏，带上升动画效果的
                    .setTicker("标题Ticker")
                    //设置通知栏标题
                    .setContentTitle("标题ContentTitle")
                    //设置通知栏内容
                    .setContentText("标题ContentText")
                    .setVibrate(new long[]{0})
                    .setSound(null)
                    //ture
                    .setOngoing(true)
                    //设置这个标志当用户单击面板就可以让通知将自动取消
                    .setAutoCancel(false);
            //创建PendingIntent，处理点击通知之后的逻辑
            Intent intent = new Intent(context, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
            builder.setContentIntent(pendingIntent);
            notification = builder.build();
            NotificationManagerCompat.from(context).notify(notificationId, notification);
        } else {
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, channelId);
            mBuilder.setContentTitle("标题ContentTitle")//设置通知栏标题
                    //通知首次出现在通知栏，带上升动画效果的
                    .setTicker("标题Ticker")
                    //通知产生的时间，会在通知信息里显示，一般是系统获取到的时间
                    .setWhen(System.currentTimeMillis())
                    .setContent(views)
                    //设置该通知优先级
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    //设置通知栏内容
                    .setContentText("标题ContentText")
                    //设置通知大图标，在通知栏显示
                    .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher))
                    //设置这个标志当用户单击面板就可以让通知将自动取消
                    .setAutoCancel(false)
                    .setVibrate(new long[]{0})
                    .setSound(null)
                    //ture
                    .setOngoing(true)
                    //设置通知小图标在状态栏显示（必须设置）
                    .setSmallIcon(R.mipmap.ic_launcher);//设置通知小ICON
            Intent intent = new Intent(context, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
            mBuilder.setContentIntent(pendingIntent);
            notification = mBuilder.build();
            if (notificationManager != null) {
                notificationManager.notify(notificationId, notification);
            }
        }
    }

    public boolean isNotificationEnable() {
        NotificationManagerCompat manager = NotificationManagerCompat.from(context);
        boolean isOpened = manager.areNotificationsEnabled();
        return isOpened;
    }

    public void toSetApp() {
        Intent intent = new Intent();
        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", context.getPackageName(), null);
        intent.setData(uri);
        context.startActivity(intent);
    }
}
