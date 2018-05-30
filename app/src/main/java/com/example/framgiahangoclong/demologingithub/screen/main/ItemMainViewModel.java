package com.example.framgiahangoclong.demologingithub.screen.main;

import android.databinding.ObservableField;
import android.view.View;
import com.example.framgiahangoclong.demologingithub.data.model.RepoResponse;
import com.example.framgiahangoclong.demologingithub.screen.BaseRecyclerViewAdapter;

public class ItemMainViewModel {

    private BaseRecyclerViewAdapter.OnItemClickListener<RepoResponse> mItemClickListener;

    public ObservableField<RepoResponse> mResponseObservableField = new ObservableField<>();


    public ItemMainViewModel(RepoResponse repoResponse, BaseRecyclerViewAdapter.OnItemClickListener<RepoResponse> itemClickListener) {

        mResponseObservableField.set(repoResponse);
        mItemClickListener = itemClickListener;
    }

    public void onItemClicked(View view) {
        if (mItemClickListener == null || mResponseObservableField == null) {
            return;
        }
        mItemClickListener.onItemClicked(mResponseObservableField.get());
    }
}
