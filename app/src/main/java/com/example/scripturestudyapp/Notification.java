package com.example.scripturestudyapp;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.content.Intent;


import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.util.Calendar;

import static android.content.Context.ALARM_SERVICE;
import static androidx.core.content.ContextCompat.getSystemService;

//https://medium.com/exploring-android/exploring-android-o-notification-channels-94cd274f604c
//https://developer.android.com/training/notify-user/build-notification
//https://www.youtube.com/watch?v=1fV9NmvxXJo
public class Notification {
    String title;

    private static final String TAG = "My notification";
    String message;
    String notificationSetting;
    String channelId = "some_channel_id";
    CharSequence channelName = "Some Channel";
    int importance = NotificationManager.IMPORTANCE_LOW;


    //NotificationManager notificationManager =
    //    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);


    public boolean isMute(Context c){
        boolean mute = false;
        SharedPreferences pref = c.getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("mute", true);
        editor.commit();

        boolean newMute = pref.getBoolean("mute", false);

        return newMute;
    }

    public void sendNotification(NotificationCompat.Builder builder){
        //NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

// notificationId is a unique int for each notification that you must define
        //notificationManager.notify(channelId, builder.build());
    }
    public void setNotification(String message){
//        NotificationManagerCompat.notify(channelId, builder.build())
    }
    public void createNotification(Context context){
//    NotificationCompat.Builder builder = new NotificationCompat.Builder(context, channelId)
//            .setSmallIcon(res.drawable.icon_bell)
//            .setContentTitle(title)
//            .setContentText(message)
//            .setPriority(importance);
    }
    public void setChannel(String channelId, CharSequence channelName, int importance)
    {
        //NotificationChannel notificationChannel = new NotificationChannel(channelId, channelName, importance);
    }
    public void setTime(int hour, int min, Context context){
        Calendar calendar = Calendar.getInstance();
        Intent intent = new Intent(context, Notification.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,100,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        //AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        //alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
    }
    public void remove(){
//        cancel(channelName, channelId);
    }
}
