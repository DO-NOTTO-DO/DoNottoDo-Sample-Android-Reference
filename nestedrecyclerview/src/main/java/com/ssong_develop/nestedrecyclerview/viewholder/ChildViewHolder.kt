package com.ssong_develop.nestedrecyclerview.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.ssong_develop.nestedrecyclerview.common.ChildData
import com.ssong_develop.nestedrecyclerview.databinding.ItemChildBinding

class ChildViewHolder(
    private val binding: ItemChildBinding,
    private val childClickListener: (view: View, childData: ChildData) -> Unit
) : ViewHolder(binding.root), View.OnClickListener, View.OnLongClickListener {

    private lateinit var childData: ChildData

    init {
        binding.root.setOnClickListener(this)
        binding.root.setOnLongClickListener(this)
    }

    fun bind(data: ChildData) {
        childData = data
        binding.apply {
            this.data = data
        }
    }

    override fun onClick(view: View) {
        childClickListener.invoke(view, childData)
    }

    override fun onLongClick(v: View?): Boolean = false
}
