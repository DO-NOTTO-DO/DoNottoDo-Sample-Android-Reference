package com.ssong_develop.nestedrecyclerview.binding

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

object ViewBindingAdapter {

    @JvmStatic
    @BindingAdapter("app:visibility")
    fun bindVisibility(view: RecyclerView, visibility: Boolean) {
        view.visibility = if (visibility) View.VISIBLE else View.GONE
    }
}