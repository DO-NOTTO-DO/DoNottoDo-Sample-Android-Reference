package com.ssong_develop.nestedrecyclerview.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ssong_develop.nestedrecyclerview.R
import com.ssong_develop.nestedrecyclerview.common.ChildData
import com.ssong_develop.nestedrecyclerview.databinding.ItemChildBinding
import com.ssong_develop.nestedrecyclerview.viewholder.ChildViewHolder

class ChildAdapter(
    private val childClickListener: (view: View, childData: ChildData) -> Unit
) : RecyclerView.Adapter<ChildViewHolder>() {

    private val childItems = mutableListOf<ChildData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemChildBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_child, parent, false)
        return ChildViewHolder(binding, childClickListener)
    }

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        holder.bind(childItems[position])
    }

    override fun getItemCount(): Int = childItems.size

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<ChildData>) {
        childItems.clear()
        childItems.addAll(list)
        notifyDataSetChanged()
    }
}