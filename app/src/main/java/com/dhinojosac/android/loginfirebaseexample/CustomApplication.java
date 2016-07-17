package com.dhinojosac.android.loginfirebaseexample;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by negro-PC on 16-Jul-16.
 */
public class CustomApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        setupFirebase();
    }

    private void setupFirebase() {
        Firebase.setAndroidContext(this);
        Firebase.getDefaultConfig().setPersistenceEnabled(true); // soporte caracteristicas offline
    }
}
