package com.example.framgiahangoclong.demologingithub.screen.main;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.example.framgiahangoclong.demologingithub.R;
import com.example.framgiahangoclong.demologingithub.data.model.RepoResponse;
import com.example.framgiahangoclong.demologingithub.databinding.ItemRepoMainBinding;
import com.example.framgiahangoclong.demologingithub.screen.BaseRecyclerViewAdapter;
import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends BaseRecyclerViewAdapter<MainAdapter.ViewHolder> {

    private List<RepoResponse> mRepoResponses = new ArrayList<>();
    private OnItemClickListener<RepoResponse> mItemClickListener;

    protected MainAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRepoMainBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.item_repo_main, parent, false);
        return new ViewHolder(binding, mItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(mRepoResponses.get(position));
    }

    @Override
    public int getItemCount() {
        return mRepoResponses != null ? mRepoResponses.size() : 0;
    }

    public void setListener(OnItemClickListener<RepoResponse> itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    void addData(List<RepoResponse> repoResponses) {
        if (repoResponses == null) {
            return;
        }
        mRepoResponses.clear();
        mRepoResponses.addAll(repoResponses);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private ItemRepoMainBinding mBinding;
        private OnItemClickListener<RepoResponse> mItemClickListener;

        public ViewHolder(ItemRepoMainBinding binding,
                OnItemClickListener<RepoResponse> itemClickListener) {
            super(binding.getRoot());
            mBinding = binding;
            mItemClickListener = itemClickListener;
        }

        void bind(RepoResponse repoResponse) {
            mBinding.setViewModel(new ItemMainViewModel(repoResponse, mItemClickListener));
            mBinding.executePendingBindings();
        }
    }
}
