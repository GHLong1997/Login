package com.example.framgiahangoclong.demologingithub.utils.rx;

import android.support.annotation.NonNull;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SchedulerProvider {

    private static SchedulerProvider sInstance;

    private SchedulerProvider() {
    }

    public static synchronized SchedulerProvider getInstance() {
        if (sInstance == null) {
            sInstance = new SchedulerProvider();
        }
        return sInstance;
    }

    @NonNull
    public Scheduler io() {
        return Schedulers.io();
    }

    @NonNull
    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }
}
