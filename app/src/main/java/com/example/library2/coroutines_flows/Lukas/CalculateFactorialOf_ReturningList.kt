package com.example.library2.coroutines_flows.Lukas

import java.math.BigInteger

fun main() {
    val result = calculateFactorialOf(5)
    println("Result: $result")
}

private fun calculateFactorialOf(number: Int):List<BigInteger> =  buildList {
    var factorial = BigInteger.ONE
    for (i in 1..number) {
        Thread.sleep(10)
        factorial = factorial.multiply(BigInteger.valueOf(i.toLong()))
    }
    add(factorial) // to build a list we need add with no need for return
}