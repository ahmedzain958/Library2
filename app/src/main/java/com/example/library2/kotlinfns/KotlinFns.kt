package com.example.library2.kotlinfns
fun main(){
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