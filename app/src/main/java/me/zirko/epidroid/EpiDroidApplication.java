package me.zirko.epidroid;

import android.app.Application;

import me.zirko.epidroid.network.VolleySingleton;

public class EpiDroidApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        VolleySingleton.getInstance(getApplicationContext());
    }
}
