package com.example.framgiahangoclong.demologingithub;

import android.app.Application;
import com.example.framgiahangoclong.demologingithub.data.source.remote.api.NetworkModule;

public class MainApplication extends Application {

    private AppComponent mAppComponent;

    public AppComponent getAppComponent() {
        if (mAppComponent == null) {
            mAppComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(getApplicationContext()))
                    .networkModule(new NetworkModule(this))
                    .build();
        }
        return mAppComponent;
    }
}
