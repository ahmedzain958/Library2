package com.example.library2.concurrentprogramming.flows.philip.combinezipmerge

data class ProfileState(
    val profilePicUrl: String? = null,
    val username: String? = null,
    val description: String? = null,
    val posts: List<Post> = emptyList(),
)
