package com.example.framgiahangoclong.demologingithub.screen.repodetails;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.example.framgiahangoclong.demologingithub.R;
import com.example.framgiahangoclong.demologingithub.databinding.ActivityRepoDetailsBinding;
import com.example.framgiahangoclong.demologingithub.screen.BaseActivity;
import javax.inject.Inject;

public class RepoDetailsActivity extends BaseActivity {

    public static final String BUNDLE_REPO_DETAILS = "BUNDLE_REPO_DETAILS";

    @Inject
    public RepoDetailsViewModel mViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        DaggerRepoDetailsComponent.builder()
                .repoDetailsModule(new RepoDetailsModule(this))
                .build()
                .inject(this);

        super.onCreate(savedInstanceState);

        ActivityRepoDetailsBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_repo_details);
        binding.setViewModel(mViewModel);
    }
}
