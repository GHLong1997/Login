package com.example.framgiahangoclong.demologingithub.screen;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

public abstract class BaseRecyclerViewAdapter<V extends RecyclerView.ViewHolder>
        extends RecyclerView.Adapter<V> {

    private final Context mContext;

    protected BaseRecyclerViewAdapter(Context context) {
        mContext = context;
    }

    protected Context getContext() {
        return mContext;
    }

    public interface OnItemClickListener<T> {
        void onItemClicked(T item);
    }
}
