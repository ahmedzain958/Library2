package com.example.library2

open class Master {
    var x = 0
}

fun main() {
    val master = Master()
    println(master.x)
    val child1 = Child1()
    val child2 = Child2()
    child1.x = 1
    child2.x = 2
    println(master.x)
}