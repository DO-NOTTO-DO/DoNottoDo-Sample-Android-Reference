package com.ssong_develop.selectionrecyclerview.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ssong_develop.selectionrecyclerview.R
import com.ssong_develop.selectionrecyclerview.common.SampleData
import com.ssong_develop.selectionrecyclerview.databinding.ItemSampleViewBinding
import com.ssong_develop.selectionrecyclerview.viewholder.SampleViewHolder

/**
 * Multiple Selection 다중 선택을 할 때 가장 중요한 것 또한 위치 값입니다.
 * 위치를 저장해줄 수 있는 set 혹은 list여도 괜찮지만, 중복 제거를 하는데 필요한 것이 set이기 떄문에 set으로 구현합니다
 *
 * 값이 존재하는지에 대한 유무를 확인할 수 있고, 그에 따라 원하는 로직을 작성할 수 있습니다.
 */
class SampleMultipleSelectionAdapter : RecyclerView.Adapter<SampleViewHolder>() {
    private val sampleItems = mutableListOf<SampleData>()

    private val selectedItemPositions = mutableSetOf<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemSampleViewBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_sample_view, parent, false)
        return SampleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SampleViewHolder, position: Int) {
        if (selectedItemPositions.contains(position)) {
            selectBackground(holder, sampleItems[position])
        } else {
            normalBackground(holder, sampleItems[position])
        }
        bind(holder, position)
    }

    override fun getItemCount(): Int = sampleItems.size

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<SampleData>) {
        sampleItems.clear()
        sampleItems.addAll(list)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun bind(
        holder: SampleViewHolder,
        position: Int
    ) {
        if (!holder.itemView.hasOnClickListeners()) {
            holder.itemView.setOnClickListener {
                if (selectedItemPositions.contains(position)) {
                    selectedItemPositions.remove(position)
                } else {
                    selectedItemPositions.add(position)
                }
                notifyItemChanged(position)
            }
        }
    }

    private fun normalBackground(
        holder: SampleViewHolder,
        data: SampleData
    ) {
        holder.binding.apply {
            this.data = data
            root.setBackgroundColor(Color.parseColor("#334455"))
            executePendingBindings()
        }
    }

    private fun selectBackground(
        holder: SampleViewHolder,
        data: SampleData
    ) {
        holder.binding.apply {
            this.data = data
            root.setBackgroundColor(Color.parseColor("#112233"))
            executePendingBindings()
        }
    }
}