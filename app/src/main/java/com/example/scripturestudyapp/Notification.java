package com.example.scripturestudyapp;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;

import androidx.core.app.NotificationCompat;

//https://medium.com/exploring-android/exploring-android-o-notification-channels-94cd274f604c
//https://developer.android.com/training/notify-user/build-notification
public class Notification {
    String message;
    String notificationSetting;
    String channelId = "some_channel_id";
    CharSequence channelName = "Some Channel";
    Notification n;
    int importance = NotificationManager.IMPORTANCE_LOW;
    //NotificationManager notificationManager =
        //    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);



    public void sendNotification(String message){

    }
    public void setNotification(String message){

    }
    public void createNotification(){
//    NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
//            .setSmallIcon(R.drawable.notification_icon)
//            .setContentTitle(textTitle)
//            .setContentText(textContent)
//            .setPriority(NotificationCompat.PRIORITY_DEFAULT);
    }
    public void setChannel(String channelId, CharSequence channelName, int importance)
    {
        //NotificationChannel notificationChannel = new NotificationChannel(channelId, channelName, importance);
    }
    public void setTime(int hour, int min){}
    public void remove(){}
}
