package com.ssong_develop.catchfragmentevent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

/**
 * fragment에서 특정 Event가 발생했을 때, 이를 Activity에서 처리해야할 떄 사용하는 로직
 *
 * 대부분 activityViewModel을 활용해 mvvm스럽게 작업을 진행하곤 합니다.
 * 하지만 viewModel이라는 개념이 없던 때에는 이와 같은 방법으로 event를 전파시켜서 사용하곤 합니다.
 *
 * 이와 같은 방법을 listener라고 합니다
 */

class CatchFragmentEventView : AppCompatActivity(), SampleFragment.OnFragmentEventListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catch_fragment_event_view)
    }

    override fun onFragmentInteraction() {
        Toast.makeText(this,"버튼이 눌렸습니다",Toast.LENGTH_SHORT).show()
    }
}