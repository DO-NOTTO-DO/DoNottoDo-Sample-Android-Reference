package com.ssong_develop.selectionrecyclerview

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator
import com.ssong_develop.selectionrecyclerview.adapter.SampleMultipleSelectionAdapter
import com.ssong_develop.selectionrecyclerview.adapter.SampleSavedStateSelectionAdapter
import com.ssong_develop.selectionrecyclerview.adapter.SampleSingleSelectionAdapter
import com.ssong_develop.selectionrecyclerview.adapter.SampleWithInterfaceAdapter
import com.ssong_develop.selectionrecyclerview.common.SampleData

class RecyclerViewSelectionView : AppCompatActivity() {

    private lateinit var sampleSingleSelectionAdapter: SampleSingleSelectionAdapter
    private lateinit var sampleMultipleSelectionAdapter: SampleMultipleSelectionAdapter
    private lateinit var sampleWithInterfaceAdapter: SampleWithInterfaceAdapter
    private lateinit var sampleSavedStateSelectionAdapter: SampleSavedStateSelectionAdapter

    private lateinit var testRecyclerView: NoChangeAnimationRecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_selection_view)
        sampleSingleSelectionAdapter = SampleSingleSelectionAdapter()
        sampleMultipleSelectionAdapter = SampleMultipleSelectionAdapter()
        sampleWithInterfaceAdapter = SampleWithInterfaceAdapter(
            sampleItemClickHandler = { item, view ->
                Toast.makeText(this,"${item}, ${view}",Toast.LENGTH_SHORT).show()
            }
        )
        sampleSavedStateSelectionAdapter = SampleSavedStateSelectionAdapter(
            sampleItemClickHandler = { item, view ->
                val intent = Intent(
                    Intent.ACTION_DIAL,
                    Uri.parse("tel: 010-1111-1111")
                )
                startActivity(intent)
            },
            savedInstanceState
        )

        testRecyclerView = findViewById(R.id.test)

        testRecyclerView.apply {
            adapter = sampleSavedStateSelectionAdapter
        }
        initTestData()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        sampleSavedStateSelectionAdapter.onSaveInstanceState(savedInstanceState)
    }

    private fun initTestData() {
        sampleSingleSelectionAdapter.submitList(
            listOf(
                SampleData(1,"hello1"),
                SampleData(2,"hello2"),
                SampleData(3,"hello3"),
                SampleData(4,"hello4"),
                SampleData(5,"hello5"),
                SampleData(6,"hello6"),
                SampleData(7,"hello7"),
                SampleData(8,"hello8"),
                SampleData(9,"hello9"),
                SampleData(10,"hello10"),
                SampleData(11,"hello11"),
                SampleData(12,"hello12"),
                SampleData(13,"hello13"),
                SampleData(14,"hello14"),
                SampleData(15,"hello15"),
                SampleData(16,"hello16"),
                SampleData(17,"hello17"),
                SampleData(18,"hello18"),
                SampleData(19,"hello19"),
                SampleData(20,"hello20"),
                SampleData(21,"hello21")
            )
        )

        sampleMultipleSelectionAdapter.submitList(
            listOf(
                SampleData(1,"hello1"),
                SampleData(2,"hello2"),
                SampleData(3,"hello3"),
                SampleData(4,"hello4"),
                SampleData(5,"hello5"),
                SampleData(6,"hello6"),
                SampleData(7,"hello7"),
                SampleData(8,"hello8"),
                SampleData(9,"hello9"),
                SampleData(10,"hello10"),
                SampleData(11,"hello11"),
                SampleData(12,"hello12"),
                SampleData(13,"hello13"),
                SampleData(14,"hello14"),
                SampleData(15,"hello15"),
                SampleData(16,"hello16"),
                SampleData(17,"hello17"),
                SampleData(18,"hello18"),
                SampleData(19,"hello19"),
                SampleData(20,"hello20"),
                SampleData(21,"hello21")
            )
        )

        sampleWithInterfaceAdapter.submitList(
            listOf(
                SampleData(1,"hello1"),
                SampleData(2,"hello2"),
                SampleData(3,"hello3"),
                SampleData(4,"hello4"),
                SampleData(5,"hello5"),
                SampleData(6,"hello6"),
                SampleData(7,"hello7"),
                SampleData(8,"hello8"),
                SampleData(9,"hello9"),
                SampleData(10,"hello10"),
                SampleData(11,"hello11"),
                SampleData(12,"hello12"),
                SampleData(13,"hello13"),
                SampleData(14,"hello14"),
                SampleData(15,"hello15"),
                SampleData(16,"hello16"),
                SampleData(17,"hello17"),
                SampleData(18,"hello18"),
                SampleData(19,"hello19"),
                SampleData(20,"hello20"),
                SampleData(21,"hello21")
            )
        )
        sampleSavedStateSelectionAdapter.submitList(
            listOf(
                SampleData(1,"hello1"),
                SampleData(2,"hello2"),
                SampleData(3,"hello3"),
                SampleData(4,"hello4"),
                SampleData(5,"hello5"),
                SampleData(6,"hello6"),
                SampleData(7,"hello7"),
                SampleData(8,"hello8"),
                SampleData(9,"hello9"),
                SampleData(10,"hello10"),
                SampleData(11,"hello11"),
                SampleData(12,"hello12"),
                SampleData(13,"hello13"),
                SampleData(14,"hello14"),
                SampleData(15,"hello15"),
                SampleData(16,"hello16"),
                SampleData(17,"hello17"),
                SampleData(18,"hello18"),
                SampleData(19,"hello19"),
                SampleData(20,"hello20"),
                SampleData(21,"hello21")
            )
        )
    }
}