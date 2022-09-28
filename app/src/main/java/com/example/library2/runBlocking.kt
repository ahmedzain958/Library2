package com.example.library2

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    println("current thread")
    GlobalScope.launch {
        printCoroutines()
    }
    println("current thread"+ "after")
}

suspend fun printCoroutines(){
    GlobalScope.launch {
        delay(2000)
        println("hello from inside coroutines")
    }
}