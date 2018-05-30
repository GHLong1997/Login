package com.example.framgiahangoclong.demologingithub.data.source.remote.api.service;

import com.example.framgiahangoclong.demologingithub.data.model.RepoResponse;
import com.example.framgiahangoclong.demologingithub.data.model.User;
import io.reactivex.Single;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {

    @GET("/user")
    Single<User> getGithubUserInfo(@Query("access_token") String token);

    @GET("/users/{name}/repos")
    Single<List<RepoResponse>> getListRepoGithub(@Path("name") String name);

}
