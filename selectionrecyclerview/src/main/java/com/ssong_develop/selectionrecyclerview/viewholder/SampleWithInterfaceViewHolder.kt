package com.ssong_develop.selectionrecyclerview.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.ssong_develop.selectionrecyclerview.common.SampleData
import com.ssong_develop.selectionrecyclerview.databinding.ItemSampleViewBinding

class SampleWithInterfaceViewHolder(
    private val binding: ItemSampleViewBinding,
    private val itemClickHandler: SampleItemClickHandler
): ViewHolder(binding.root), View.OnClickListener, View.OnLongClickListener {

    private lateinit var item: SampleData

    fun interface SampleItemClickHandler {
        fun onItemClick(item: SampleData, view: View)
    }

    init {
        itemView.setOnClickListener(this)
        itemView.setOnLongClickListener(this)
    }

    override fun onClick(view: View) {
        itemClickHandler.onItemClick(item, view)
    }

    override fun onLongClick(v: View?): Boolean = false

    fun bind(data: SampleData) {
        item = data
        binding.apply {
            this.data = data
            executePendingBindings()
        }
    }
}