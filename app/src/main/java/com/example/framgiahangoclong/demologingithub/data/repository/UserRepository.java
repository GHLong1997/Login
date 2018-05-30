package com.example.framgiahangoclong.demologingithub.data.repository;

import com.example.framgiahangoclong.demologingithub.data.model.RepoResponse;
import com.example.framgiahangoclong.demologingithub.data.model.User;
import com.example.framgiahangoclong.demologingithub.data.source.UserDataSource;
import com.example.framgiahangoclong.demologingithub.data.source.local.UserLocalDataSource;
import com.example.framgiahangoclong.demologingithub.data.source.remote.UserRemoteDataSource;
import io.reactivex.Single;
import java.util.List;

public class UserRepository {

    private UserDataSource.LocalDataSource mLocalDataSource;
    private UserDataSource.RemoteDataSource mRemoteDataSource;

    public UserRepository(UserLocalDataSource localDataSource,
            UserRemoteDataSource remoteDataSource) {
        mLocalDataSource = localDataSource;
        mRemoteDataSource = remoteDataSource;
    }

    public Single<User> getGithubUserInfo(String token) {
        return mRemoteDataSource.getGithubUserInfo(token);
    }

    public Single<List<RepoResponse>> getListRepoGithub(String name) {
       return mRemoteDataSource.getListRepoGithub(name);
    }
}
