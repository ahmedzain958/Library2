package com.example.library2

fun main() {
    var x = 5
    for (i in 0..10){
        x= 6
        println("inside fn x = $x")
    }
    println("outside fn x = $x")
}