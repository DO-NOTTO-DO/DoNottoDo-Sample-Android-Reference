package com.ssong_develop.nestedrecyclerview.viewholder

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.ssong_develop.nestedrecyclerview.adapter.ChildAdapter
import com.ssong_develop.nestedrecyclerview.common.ParentData
import com.ssong_develop.nestedrecyclerview.databinding.ItemParentBinding

class ParentViewHolder(
    private val binding: ItemParentBinding
) : ViewHolder(binding.root) {

    private lateinit var parentData: ParentData

    /**
     * 자식 어댑터, 즉 하위로 생성되는 리사이클러뷰의 어댑터를 상위 뷰홀더(parent ViewHolder)가 생성될 떄 단 한번만 생성되면 됩니다.
     */
    private val childAdapter: ChildAdapter = ChildAdapter()

    private var isExpand = false

    init {
        initRecyclerView()
        binding.ivArrow.setOnClickListener {
            isExpand = !isExpand
            binding.isExpanded = isExpand
        }
    }

    /**
     * 상위 뷰홀더(parentViewHolder)가 생성될 떄 단 한번, 자식 뷰(child)를 보여줄 리사이클러뷰의 초기화 또한 단 한번이면 됩니다.
     */
    private fun initRecyclerView() {
        binding.rvParent.apply {
            adapter = childAdapter
        }
    }

    /**
     * 리사이클러뷰에서 onBindViewHolder메서드는 특정 뷰가 위로 스크롤 되어 보이지 않았다가, 나중에 다시 보이게 되는 경우에도 호출되고, 굉장히 자주 호출되는 메서드입니다.
     * 그렇기 떄문에, 어댑터의 생성(create)을 onBindViewHolder가 아닌 생성된 어댑터의 데이터를 갱신(update, submit)하는 과정을 onBindViewHolder에서 해줌으로써,
     * 가장 최신화된 데이터를 갱신할 수 있습니다.
     * 물론 데이터가 변환이 되었다면, 갱신한다는 등의 로직을 작성해서 넣어줄 수도 있습니다!
     */
    fun bind(data: ParentData) {
        parentData = data
        childAdapter.submitList(data.childDatas)
        binding.apply {
            this.data = data
            this.isExpanded = isExpand
            executePendingBindings()
        }
    }
}