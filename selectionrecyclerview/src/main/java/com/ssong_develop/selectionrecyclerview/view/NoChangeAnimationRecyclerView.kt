package com.ssong_develop.selectionrecyclerview.view

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator

/**
 * NotifyDataSetChanged 등과 같이 Notify를 RecyclerView에서 적용하면 깜빡이는 효과가 많이 등장하곤 합니다.
 *
 * 이유는 RecyclerView에 적용된 default Animation 떄문인데, 아래와 같이 변경되는 애니메이션을 꺼주게 되면 깜빡이는 효과를 제거할 수 있습니다.
 *
 * 이후엔 View처럼 사용 가능합니다
 */
class NoChangeAnimationRecyclerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr) {

    init {
        (itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
    }

}