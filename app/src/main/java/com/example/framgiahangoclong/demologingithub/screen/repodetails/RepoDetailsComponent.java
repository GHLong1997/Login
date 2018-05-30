package com.example.framgiahangoclong.demologingithub.screen.repodetails;

import com.example.framgiahangoclong.demologingithub.utils.dagger.ActivityScope;
import dagger.Component;

@ActivityScope
@Component (modules = RepoDetailsModule.class)
public interface RepoDetailsComponent {

    void inject(RepoDetailsActivity repoDetailsActivity);

}
