package com.example.library2.concurrentprogramming.flows.philip.combinezipmerge

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class CombineZipMergeViewModel: ViewModel() {
    private val user = MutableStateFlow<User?>(null)
    private val posts = MutableStateFlow(emptyList<Post>())
    init {

    }
}