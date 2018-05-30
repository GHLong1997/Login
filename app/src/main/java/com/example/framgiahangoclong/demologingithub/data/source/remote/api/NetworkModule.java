package com.example.framgiahangoclong.demologingithub.data.source.remote.api;

import android.app.Application;
import com.example.framgiahangoclong.demologingithub.BuildConfig;
import com.example.framgiahangoclong.demologingithub.data.model.Owner;
import com.example.framgiahangoclong.demologingithub.data.model.User;
import com.example.framgiahangoclong.demologingithub.data.source.remote.api.middleware
        .InterceptorImpl;
import com.example.framgiahangoclong.demologingithub.data.source.remote.api.service.Api;
import com.example.framgiahangoclong.demologingithub.utils.Constant;
import com.example.framgiahangoclong.demologingithub.utils.dagger.AppScope;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dagger.Module;
import dagger.Provides;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    private Application mApplication;

    public NetworkModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @AppScope
    @Provides
    public Application provideApplication() {
        return mApplication;
    }

    @AppScope
    @Provides
    public Gson provideGson() {
        return new GsonBuilder().create();
    }

    @AppScope
    @Provides
    public Cache provideOkHttpCache(Application application) {
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        return new Cache(application.getCacheDir(), cacheSize);
    }

    @AppScope
    @Provides
    public Interceptor provideInterceptor() {
        return new InterceptorImpl();
    }

    @AppScope
    @Provides
    public OkHttpClient provideOkHttpClient(Cache cache, Interceptor interceptor) {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.cache(cache)
                .readTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(interceptor);
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            okHttpClient.addInterceptor(logging);
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        }
        return okHttpClient.build();
    }

    @AppScope
    @Provides
    public Retrofit provideRetrofit(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder().client(okHttpClient)
                .baseUrl(Constant.END_POINT_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @AppScope
    @Provides
    public Api provideApi(Retrofit retrofit) {
        return retrofit.create(Api.class);
    }

}
