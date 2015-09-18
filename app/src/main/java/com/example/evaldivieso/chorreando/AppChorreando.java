package com.example.evaldivieso.chorreando;

import android.app.Application;

/**
 * Created by evaldivieso on 16/09/2015.
 */
public class AppChorreando extends Application {
    public String username;

    @Override
    public void onCreate() {
        super.onCreate();
        username = "";
    }
}
