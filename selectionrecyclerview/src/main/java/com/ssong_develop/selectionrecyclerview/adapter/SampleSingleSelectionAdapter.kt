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
 * SingleSelection 즉, 단일 선택 기능을 만들 때 알아둬야 하는 개념은 위치값으로 클릭을 표시한다는 것입니다.
 * 즉, 내가 선택한 위치의 아이템에 notifyItemChange를 해주면 되는것입니다.
 *
 * 알고리즘을 세울 때 중요한 것은, 내가 선택한 위치 뿐만 아니라, 내가 이전에 선택한 위치의 뷰 또한 변경해줘야 하기 때문에
 * 현재 선택한 위치 값, 내가 마지막으로 선택한 위치값 이렇게 2개의 필드를 활용해서 기능을 만들어냅니다.
 */
class SampleSingleSelectionAdapter : RecyclerView.Adapter<SampleViewHolder>() {

    private val sampleItems = mutableListOf<SampleData>()

    /** 선택한 위치의 값을 저장해주는 필드 **/
    private var selectedPosition = -1

    /** 이전에 선택한 위치의 값을 저장해주는 필드**/
    private var lastItemSelectedPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemSampleViewBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_sample_view, parent, false)
        return SampleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SampleViewHolder, position: Int) {
        if (position == selectedPosition) {
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

    private fun bind(
        holder: SampleViewHolder,
        position: Int
    ) {
        if (!holder.itemView.hasOnClickListeners()) {
            holder.itemView.setOnClickListener {
                selectedPosition = position
                lastItemSelectedPosition = if (lastItemSelectedPosition == -1) {
                    selectedPosition
                } else {
                    notifyItemChanged(lastItemSelectedPosition)
                    selectedPosition
                }
                notifyItemChanged(selectedPosition)
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

