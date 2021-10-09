package com.example.library2

fun main() {
    //Throws an IllegalArgumentException if the value is false.
    fun getIndices(count: Int): List<Int> {
        require(count >= 0) { "Count must be non-negative, was $count" }
        // ...
        return List(count) { it + 1 }
    }

// getIndices(-1) // will fail with IllegalArgumentException

    println(getIndices(3)) // [1, 2, 3]
}