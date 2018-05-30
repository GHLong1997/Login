package com.example.framgiahangoclong.demologingithub.screen.main;

import com.example.framgiahangoclong.demologingithub.AppComponent;
import com.example.framgiahangoclong.demologingithub.utils.dagger.ActivityScope;
import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = MainModule.class)
public interface MainComponent {

    void inject(MainActivity mainActivity);

}
