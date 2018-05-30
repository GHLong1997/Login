package com.example.framgiahangoclong.demologingithub.screen.repodetails;

import android.databinding.ObservableField;
import com.example.framgiahangoclong.demologingithub.data.model.RepoResponse;
import com.example.framgiahangoclong.demologingithub.screen.BaseViewModel;
import javax.inject.Inject;

public class RepoDetailsViewModel extends BaseViewModel{

    public ObservableField<RepoResponse> mResponseObservableField = new ObservableField<>();

    public RepoDetailsViewModel(RepoResponse repoResponse) {
        mResponseObservableField.set(repoResponse);
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }
}
