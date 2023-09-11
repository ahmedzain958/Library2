package com.example.library2.kotlinfns

fun main() {
   val names: List<String> = List(10) { "$it" }
    names.forEach {
        println(it)
    }
}