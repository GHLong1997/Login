package com.example.framgiahangoclong.demologingithub;

import android.content.Context;
import com.example.framgiahangoclong.demologingithub.data.model.User;
import com.example.framgiahangoclong.demologingithub.data.source.remote.api.NetworkModule;
import com.example.framgiahangoclong.demologingithub.data.source.remote.api.service.Api;
import com.example.framgiahangoclong.demologingithub.utils.dagger.AppScope;
import dagger.Component;

@AppScope
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {

    Api api();

    Context applicationContext();
}
