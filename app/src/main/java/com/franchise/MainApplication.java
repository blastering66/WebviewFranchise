package com.franchise;
import android.app.Application;

import com.google.firebase.messaging.FirebaseMessaging;

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseMessaging.getInstance().subscribeToTopic("franchise_global_notif");
    }
}
