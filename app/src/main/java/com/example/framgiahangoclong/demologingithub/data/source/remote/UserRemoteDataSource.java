package com.example.framgiahangoclong.demologingithub.data.source.remote;

import com.example.framgiahangoclong.demologingithub.data.model.RepoResponse;
import com.example.framgiahangoclong.demologingithub.data.model.User;
import com.example.framgiahangoclong.demologingithub.data.source.UserDataSource;
import com.example.framgiahangoclong.demologingithub.data.source.remote.api.service.Api;
import io.reactivex.Single;
import java.util.List;
import javax.inject.Inject;

public class UserRemoteDataSource implements UserDataSource.RemoteDataSource {

    private Api mApi;

    @Inject
    public UserRemoteDataSource(Api api) {
        mApi = api;
    }

    @Override
    public Single<User> getGithubUserInfo(String token) {
        return mApi.getGithubUserInfo(token);
    }

    @Override
    public Single<List<RepoResponse>> getListRepoGithub(String name) {
        return mApi.getListRepoGithub(name);
    }
}
