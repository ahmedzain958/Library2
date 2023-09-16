package com.example.library2.coroutines_flows

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

suspend fun main() = coroutineScope {
    val stateFlow = MutableStateFlow(0)
    launch {
        for (i in 1..10){
            stateFlow.emit(stateFlow.value++)
        }
    }
    print("")
}
/*
suspend fun main(): Nothing = runBlocking{
    val stateFlow = MutableStateFlow(0)
    for (i in 1..10){
        stateFlow.value++
    }
    stateFlow.collect{

    }
}
suspend fun main() = coroutineScope {
    launch {
        delay(2000)
        println("World")
    }
    println("Hello")
}*/
