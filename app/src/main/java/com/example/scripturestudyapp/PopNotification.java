package com.example.scripturestudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class PopNotification extends AppCompatActivity {

    private static final String TAG = "My notification";
    String message;
    String notificationSetting;
    String channelId = "some_channel_id";
    CharSequence channelName = "Some Channel";
    PopNotification n;
    int importance = NotificationManager.IMPORTANCE_LOW;
    //NotificationManager notificationManager =
    //    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

    }

//    public void isMute(){
//        boolean mute = false;
//        Context context;
//        SharedPreferences pref = this.getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
//        SharedPreferences.Editor editor = pref.edit();
//        editor.putBoolean("mute", true);
//        editor.commit();
//
//        boolean newMute = pref.getBoolean("mute", false);
//
//        Log.i(TAG, "isMute: " + newMute);
//    }

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
