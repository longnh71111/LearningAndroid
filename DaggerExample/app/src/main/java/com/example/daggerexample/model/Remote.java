package com.example.daggerexample.model;

import android.util.Log;

import javax.inject.Inject;

public class Remote {

    public Remote() {
    }

    public void logInsideRemote() {
        Log.d("testing", " enable remote ");
    }
}
