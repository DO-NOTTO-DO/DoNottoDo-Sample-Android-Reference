package com.ssong_develop.nestedrecyclerview.viewholder

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.ssong_develop.nestedrecyclerview.common.ChildData
import com.ssong_develop.nestedrecyclerview.databinding.ItemChildBinding

class ChildViewHolder(
    private val binding: ItemChildBinding
) : ViewHolder(binding.root) {

    private lateinit var childData: ChildData

    fun bind(data: ChildData) {
        childData = data
        binding.apply {
            this.data = data
        }
    }
}