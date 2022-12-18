package com.ssong_develop.nestedrecyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.ssong_develop.nestedrecyclerview.R
import com.ssong_develop.nestedrecyclerview.databinding.ItemParentBinding
import com.ssong_develop.nestedrecyclerview.viewholder.ParentData
import com.ssong_develop.nestedrecyclerview.viewholder.ParentViewHolder

val diffUtil = object : DiffUtil.ItemCallback<ParentData>() {
    override fun areItemsTheSame(oldItem: ParentData, newItem: ParentData): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ParentData, newItem: ParentData): Boolean {
        return oldItem == newItem
    }
}

class ParentAdapter : ListAdapter<ParentData, ParentViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemParentBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_parent, parent, false)
        return ParentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ParentViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}