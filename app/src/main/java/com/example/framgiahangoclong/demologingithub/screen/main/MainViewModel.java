package com.example.framgiahangoclong.demologingithub.screen.main;

import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import com.example.framgiahangoclong.demologingithub.data.model.RepoResponse;
import com.example.framgiahangoclong.demologingithub.data.model.User;
import com.example.framgiahangoclong.demologingithub.data.repository.UserRepository;
import com.example.framgiahangoclong.demologingithub.screen.BaseRecyclerViewAdapter;
import com.example.framgiahangoclong.demologingithub.screen.BaseViewModel;
import com.example.framgiahangoclong.demologingithub.screen.repodetails.RepoDetailsActivity;
import com.example.framgiahangoclong.demologingithub.utils.navigator.Navigator;
import com.example.framgiahangoclong.demologingithub.utils.rx.SchedulerProvider;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.List;

public class MainViewModel extends BaseViewModel
        implements BaseRecyclerViewAdapter.OnItemClickListener<RepoResponse> {

    private static final String TOKEN = "dfdb82106be3f23d7e508ee40c3108b030eba6ae";
    private UserRepository mUserRepository;
    private MainAdapter mAdapter;
    private SchedulerProvider mSchedulerProvider;
    private Navigator mNavigator;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public MainViewModel(UserRepository userRepository, MainAdapter adapter,
            SchedulerProvider schedulerProvider, Navigator navigator) {
        mUserRepository = userRepository;
        mSchedulerProvider = schedulerProvider;
        mNavigator = navigator;
        mAdapter = adapter;
        mAdapter.setListener(this);
    }

    @Override
    public void onStart() {
        getGithubUserInfo();
    }

    @Override
    public void onStop() {
        mCompositeDisposable.clear();
    }

    @Override
    public void onItemClicked(RepoResponse item) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(RepoDetailsActivity.BUNDLE_REPO_DETAILS, item);
        mNavigator.startActivity(RepoDetailsActivity.class, bundle);
    }

    public MainAdapter getAdapter() {
        return mAdapter;
    }

    public void getGithubUserInfo() {
        Disposable disposable = mUserRepository.getGithubUserInfo(TOKEN)
                .flatMap(new Function<User, SingleSource<List<RepoResponse>>>() {
                    @Override
                    public SingleSource<List<RepoResponse>> apply(User user) throws Exception {
                        try {
                            return mUserRepository.getListRepoGithub(user.getLogin());
                        }catch (Exception e) {
                            return Single.error(e);
                        }

                    }
                })
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(new Consumer<List<RepoResponse>>() {
                    @Override
                    public void accept(List<RepoResponse> repoResponses) throws Exception {
                        mAdapter.addData(repoResponses);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d("ahha", "accept: " + throwable.getLocalizedMessage());
                    }
                });

        mCompositeDisposable.add(disposable);
    }
}
