package com.ssong_develop.nestedrecyclerview.viewholder

import android.util.Log
import android.view.View
import androidx.databinding.ObservableField
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.ssong_develop.nestedrecyclerview.adapter.ChildAdapter
import com.ssong_develop.nestedrecyclerview.databinding.ItemParentBinding

data class ParentData(
    val id: Int,
    val title: String,
    val childDatas: List<ChildData>
)

class ParentViewHolder(
    private val binding: ItemParentBinding
) : ViewHolder(binding.root) {

    private lateinit var parentData: ParentData

    private val childAdapter: ChildAdapter = ChildAdapter()

    private var recyclerViewVisibilityState: Boolean = false

    init {
        initRecyclerView()
        binding.title.setOnClickListener {
            recyclerViewVisibilityState = !recyclerViewVisibilityState
            if (recyclerViewVisibilityState) {
                binding.rvParent.visibility = View.VISIBLE
            } else {
                binding.rvParent.visibility = View.GONE
            }
        }
    }

    private fun initRecyclerView() {
        binding.rvParent.apply {
            adapter = childAdapter
        }
    }

    fun bind(data: ParentData) {
        parentData = data
        childAdapter.submitList(data.childDatas)
        binding.apply {
            this.data = data
        }
    }
}