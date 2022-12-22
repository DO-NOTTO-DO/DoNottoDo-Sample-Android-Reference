package com.ssong_develop.nestedrecyclerview.common

data class ParentData(
    val id: Int,
    val title: String,
    val childDatas: List<ChildData>
)