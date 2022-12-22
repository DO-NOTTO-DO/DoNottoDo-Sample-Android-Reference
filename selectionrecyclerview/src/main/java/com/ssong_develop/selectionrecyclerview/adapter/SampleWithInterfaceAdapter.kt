package com.ssong_develop.selectionrecyclerview.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ssong_develop.selectionrecyclerview.R
import com.ssong_develop.selectionrecyclerview.common.SampleData
import com.ssong_develop.selectionrecyclerview.databinding.ItemSampleViewBinding
import com.ssong_develop.selectionrecyclerview.viewholder.SampleWithInterfaceViewHolder

/**
 * 일반적인 아이템 클릭을 처리할 떄는 이와 같이 처리합니다.
 *
 * 클릭 시 아이템의 ui적인 변화가 없거나 일반적일 떄는 이와 같은 방법을 사용하면 보다, 효율적으로 어댑터를 만들 수 있습니다.
 *
 * interface의 경우, 만약 로직이 view layer 여기서는 activity겠네요. 그곳까지 가야하는 작업이라면, activity에 interface 구현체를 만들어서 사용하면 됩니다
 */
class SampleWithInterfaceAdapter(
    private val sampleItemClickHandler: SampleWithInterfaceViewHolder.SampleItemClickHandler
) : RecyclerView.Adapter<SampleWithInterfaceViewHolder>() {

    private val sampleItems = mutableListOf<SampleData>()

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