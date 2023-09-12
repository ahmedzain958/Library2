package com.example.library2.kotlinfns

fun main() {
    // create a mutable list
    val someList = arrayListOf(false, false, false)

// iterate it using a mutable iterator and modify values
    val iterate = someList.listIterator()
    while (iterate.hasNext()) {
        val oldValue = iterate.next()
        iterate.set(!oldValue)
    }
    someList.forEach {
        println(it)
    }
}

fun filtered(
    numbers: List<Int> = listOf(3, 4, 6, 7, 10, 12, 15, 22),
): List<Int> {
    return numbers.filter {
        it % 3 == 0
    }
}
