package com.example.framgiahangoclong.demologingithub.screen.repodetails;

import android.app.Activity;
import com.example.framgiahangoclong.demologingithub.data.model.RepoResponse;
import com.example.framgiahangoclong.demologingithub.utils.dagger.ActivityScope;
import dagger.Module;
import dagger.Provides;

@Module
public class RepoDetailsModule {

    private Activity mActivity;

    public RepoDetailsModule (Activity activity) {
        mActivity = activity;
    }

    @Provides
    @ActivityScope
    public RepoResponse provideResponse() {
        return mActivity.getIntent().getParcelableExtra(RepoDetailsActivity.BUNDLE_REPO_DETAILS);
    }

    @Provides
    @ActivityScope
    public RepoDetailsViewModel provideRepoDetailsViewModel(RepoResponse repoResponse) {
        return new RepoDetailsViewModel(repoResponse);
    }

}
