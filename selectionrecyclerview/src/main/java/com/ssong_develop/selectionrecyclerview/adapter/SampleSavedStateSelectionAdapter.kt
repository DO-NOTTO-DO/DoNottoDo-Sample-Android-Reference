package com.ssong_develop.selectionrecyclerview.adapter

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ssong_develop.selectionrecyclerview.R
import com.ssong_develop.selectionrecyclerview.common.SampleData
import com.ssong_develop.selectionrecyclerview.databinding.ItemSampleViewBinding
import com.ssong_develop.selectionrecyclerview.viewholder.SampleWithInterfaceViewHolder

/**
 * 시험삼아 만든겁니다
 */
class SampleSavedStateSelectionAdapter(
    private val sampleItemClickHandler: SampleWithInterfaceViewHolder.SampleItemClickHandler,
    savedState: Bundle?
) : RecyclerView.Adapter<SampleWithInterfaceViewHolder>() {

    companion object {
        private const val STATE_KEY_SELECTED_IDS = "SampleSavedStateSelectionAdapter:selectedIds"
    }

    private val sampleItems = mutableListOf<SampleData>()

    private val selectedIds = mutableSetOf<Int>()

    init {
        savedState?.getIntegerArrayList(STATE_KEY_SELECTED_IDS)?.let {
            selectedIds.addAll(it)
        }
    }

    fun onSaveInstanceState(state: Bundle) {
        state.putIntArray(STATE_KEY_SELECTED_IDS, selectedIds.toTypedArray().toIntArray())
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SampleWithInterfaceViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemSampleViewBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_sample_view, parent, false)
        return SampleWithInterfaceViewHolder(binding, sampleItemClickHandler)
    }

    override fun onBindViewHolder(holder: SampleWithInterfaceViewHolder, position: Int) {
        holder.bind(sampleItems[position])
    }

    override fun getItemCount(): Int = sampleItems.size

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<SampleData>) {
        sampleItems.clear()
        sampleItems.addAll(list)
        notifyDataSetChanged()
    }
}