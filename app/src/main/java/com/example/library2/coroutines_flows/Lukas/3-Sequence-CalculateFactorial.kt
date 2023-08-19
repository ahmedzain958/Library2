package com.example.library2.coroutines_flows.Lukas

import com.example.library2.utils.printWithTimePassed
import java.math.BigInteger
/*
fun main(args: Array<String>) {
    val startTime = System.currentTimeMillis()
    calculateFactorialOf(5).forEach {
        printWithTimePassed(it,startTime)
    }
    println("Ready for more work!")//executed synchronously
}*/


// factorial of n (n!) = 1 * 2 * 3 * 4 * ... * n
private fun calculateFactorialOf(number: Int): Sequence<BigInteger> = sequence {
    var factorial = BigInteger.ONE
    for (i in 1..number) {
        Thread.sleep(10)
        factorial = factorial.multiply(BigInteger.valueOf(i.toLong()))
        yield(factorial)
    }
}