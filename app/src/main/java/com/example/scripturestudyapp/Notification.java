package com.example.scripturestudyapp;

import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class Notification {

    private static final String TAG = "My notification";
    String message;
    String notificationSetting;
    String channelId = "some_channel_id";
    CharSequence channelName = "Some Channel";
    PopNotification n;
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
