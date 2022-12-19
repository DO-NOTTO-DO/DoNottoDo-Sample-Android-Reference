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
            swipeRefreshLayout.isRefreshing = false
            testView.text = randomTextList.random()
        }
    }
}