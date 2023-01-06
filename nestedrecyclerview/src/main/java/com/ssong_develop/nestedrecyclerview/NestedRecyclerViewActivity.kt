package com.ssong_develop.nestedrecyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.ssong_develop.nestedrecyclerview.adapter.ParentAdapter
import com.ssong_develop.nestedrecyclerview.common.ChildData
import com.ssong_develop.nestedrecyclerview.common.ParentData
import com.ssong_develop.nestedrecyclerview.databinding.ActivityNestedRecyclerViewBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class NestedRecyclerViewActivity : AppCompatActivity() {
    private lateinit var parentAdapter: ParentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityNestedRecyclerViewBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_nested_recycler_view)
        parentAdapter = ParentAdapter(
            // 서버 통신
            testChildItemViewClickBlock = { view, childData ->
                Toast.makeText(this,"${childData} 클릭 됐어요",Toast.LENGTH_SHORT).show()
            }
        )
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