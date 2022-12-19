package com.ssong_develop.swiperefreshnestedscrollview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

class SwipeRefreshNestedScrollViewActivity : AppCompatActivity() {
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var testView: TextView

    private val randomTextList = listOf<String>("random1","random2","random3","random4","random5")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_swipe_refresh_nested_scroll_view)

        swipeRefreshLayout = findViewById(R.id.swipe_refresh)
        testView = findViewById(R.id.test)

        swipeRefreshLayout.setOnRefreshListener {
            /**
             * 예제 코드에서는 랜덤으로 텍스트만 변경했지만, 만약 api통신을 하거나, 변경된 날짜를 가져와야 하는 경우
             * 그 값들만 갱신해서 넣어주고, 반응형으로 만들어 준다면 모든 뷰가 갱신되는 듯한 효과를 만들 수 있습니다
             */
            swipeRefreshLayout.isRefreshing = false
            testView.text = randomTextList.random()
        }
    }
}