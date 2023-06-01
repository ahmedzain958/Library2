package com.example.library2.views.recyclerview_expandable

data class LanguageData(
    val title: String,
    val desc: String,
    var isExpandable: Boolean = false
)