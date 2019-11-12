package com.example.scripturestudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.LinkedList;

public class Profile extends AppCompatActivity {
    String userName;
    String password;
    LinkedList<String> goals = new LinkedList<>();
    //list of notifications
    //reading tracker

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    public void displayNotifications(String message)
    {

    }

    public void muteNotifications()
    {

    }


}
