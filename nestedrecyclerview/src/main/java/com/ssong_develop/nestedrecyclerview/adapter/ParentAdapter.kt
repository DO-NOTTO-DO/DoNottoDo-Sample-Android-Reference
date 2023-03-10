package com.ssong_develop.nestedrecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.ssong_develop.nestedrecyclerview.R
import com.ssong_develop.nestedrecyclerview.common.ChildData
import com.ssong_develop.nestedrecyclerview.common.ParentData
import com.ssong_develop.nestedrecyclerview.databinding.ItemParentBinding
import com.ssong_develop.nestedrecyclerview.viewholder.ParentViewHolder

internal object ParentDiffUtilItemCallback : DiffUtil.ItemCallback<ParentData>() {
    override fun areItemsTheSame(oldItem: ParentData, newItem: ParentData): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ParentData, newItem: ParentData): Boolean {
        return oldItem == newItem
    }
}

class ParentAdapter(
    private val testChildItemViewClickBlock : (view: View, childData: ChildData) -> Unit
) : ListAdapter<ParentData, ParentViewHolder>(ParentDiffUtilItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemParentBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_parent, parent, false)
        return ParentViewHolder(
            binding
        ) { view, childData ->
            testChildItemViewClickBlock(view, childData)
        }
    }

    override fun onBindViewHolder(holder: ParentViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}