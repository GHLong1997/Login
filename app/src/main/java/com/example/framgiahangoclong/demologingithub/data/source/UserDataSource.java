package com.example.framgiahangoclong.demologingithub.data.source;

import com.example.framgiahangoclong.demologingithub.data.model.RepoResponse;
import com.example.framgiahangoclong.demologingithub.data.model.User;
import io.reactivex.Single;
import java.util.List;

public interface UserDataSource {

    interface LocalDataSource {}

    interface RemoteDataSource {

        Single<User> getGithubUserInfo(String token);

        Single<List<RepoResponse>> getListRepoGithub(String name);

    }
}
