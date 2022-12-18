package com.ssong_develop.nestedrecyclerview

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.ssong_develop.nestedrecyclerview.adapter.ParentAdapter
import com.ssong_develop.nestedrecyclerview.databinding.ActivityNestedRecyclerViewBinding
import com.ssong_develop.nestedrecyclerview.viewholder.ChildData
import com.ssong_develop.nestedrecyclerview.viewholder.ParentData
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class NestedRecyclerViewActivity : AppCompatActivity() {
    private val parentAdapter: ParentAdapter = ParentAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityNestedRecyclerViewBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_nested_recycler_view)
        binding.rvTest.apply {
            adapter = parentAdapter
            layoutManager = LinearLayoutManager(this@NestedRecyclerViewActivity)
        }
        test()
    }

    private fun test() {
        lifecycleScope.launch {
            delay(1000L)
            parentAdapter.submitList(
                listOf(
                    ParentData(
                        1,
                        "hello1",
                        listOf(
                            ChildData(
                                1, "helloChild1"
                            ),
                            ChildData(
                                2, "helloChild2"
                            ),
                            ChildData(
                                3, "helloChild3"
                            )
                        )
                    ),
                    ParentData(
                        2,
                        "hello2",
                        listOf(
                            ChildData(
                                4, "helloChild4"
                            ),
                            ChildData(
                                5, "helloChild5"
                            ),
                            ChildData(
                                6, "helloChild6"
                            )
                        )
                    )
                )
            )
        }

    }
}