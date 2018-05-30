package com.example.framgiahangoclong.demologingithub.screen.main;

import android.app.Activity;
import android.support.annotation.NonNull;
import com.example.framgiahangoclong.demologingithub.data.repository.UserRepository;
import com.example.framgiahangoclong.demologingithub.data.source.local.UserLocalDataSource;
import com.example.framgiahangoclong.demologingithub.data.source.remote.UserRemoteDataSource;
import com.example.framgiahangoclong.demologingithub.data.source.remote.api.service.Api;
import com.example.framgiahangoclong.demologingithub.utils.dagger.ActivityScope;
import com.example.framgiahangoclong.demologingithub.utils.navigator.Navigator;
import com.example.framgiahangoclong.demologingithub.utils.rx.SchedulerProvider;
import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    @NonNull
    private Activity mActivity;

    public MainModule(@NonNull Activity activity) {
        mActivity = activity;
    }

    @ActivityScope
    @Provides
    public MainViewModel provideMainViewModel(UserRepository userRepository, MainAdapter mainAdapter,
            SchedulerProvider schedulerProvider, Navigator navigator) {
        return new MainViewModel(userRepository, mainAdapter, schedulerProvider, navigator);
    }

    @ActivityScope
    @Provides
    public UserRepository provideUserRepository(UserLocalDataSource userLocalDataSource,
            UserRemoteDataSource userRemoteDataSource) {
        return new UserRepository(userLocalDataSource, userRemoteDataSource);
    }

    @ActivityScope
    @Provides
    public MainAdapter provideMainAdapter() {
        return new MainAdapter(mActivity);
    }

    @ActivityScope
    @Provides
    public Navigator provideNavigator() {
        return new Navigator(mActivity);
    }

    @ActivityScope
    @Provides
    public SchedulerProvider provideScheduler() {
        return SchedulerProvider.getInstance();
    }
}
