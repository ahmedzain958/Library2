package com.example.library2.kotlinfns

fun higherOrderFunc(x: Int, y: Int, myFunc: (Int) -> Unit) {
    var sum = x + y
    myFunc(sum)
}

fun main() {
    //getSum will be called with sum as a parameter
    higherOrderFunc(10, 7, ::getSum)
    higherOrderFunc(10, 7, {z-> println(z)}) // using lamda
}

fun getSum(a: Int) {
    println("X add Y is $a")
}
