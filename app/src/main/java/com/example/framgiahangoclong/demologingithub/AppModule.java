package com.example.framgiahangoclong.demologingithub;

import android.content.Context;
import com.example.framgiahangoclong.demologingithub.utils.dagger.AppScope;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private Context mContext;

    public AppModule (Context context) {
        mContext = context;
    }

    @Provides
    @AppScope
    public Context provideApplicationContext() {
        return mContext;
    }

}
