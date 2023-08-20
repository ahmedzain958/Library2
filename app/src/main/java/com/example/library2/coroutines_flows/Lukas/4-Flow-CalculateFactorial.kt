package com.example.library2.coroutines_flows.Lukas

import com.example.library2.utils.printWithTimePassed
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.math.BigInteger

fun main(args: Array<String>) {
    runBlocking {
        val startTime = System.currentTimeMillis()
        launch {
            calculateFactorialOf(5).collect {// using collect in the flow is similar to using foreach in collections
                printWithTimePassed(it, startTime =startTime)
            }
        }
    }
}

private fun calculateFactorialOf(number: Int): Flow<BigInteger> = flow {
    var factorial = BigInteger.ONE
    for (i in 1..number) {
        delay(10)//flows supports coroutines, inwhich we can call suspend functions
        factorial = factorial.multiply(BigInteger.valueOf(i.toLong()))
    }
    emit(factorial)
}.flowOn(Dispatchers.Default)
