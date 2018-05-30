package com.example.framgiahangoclong.demologingithub.utils.binding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

public final class BindingUtils {

    @BindingAdapter("recyclerAdapter")
    public static void setAdapter(RecyclerView recyclerView, RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);
    }
}
