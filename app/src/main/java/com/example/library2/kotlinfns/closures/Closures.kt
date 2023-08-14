package com.example.library2.kotlinfns.closures

class Closures {
    //1st Example clarifies the closures shape, which takes any type of parameter and returns any type of parameter//
    val closureShape = { ahmed: Int -> "$ahmed" }
    /////////////////////////////////////////////////////////////////////////////////
    //1d Example clarifies that Closures in functional programming are the functions that are aware of their surroundings By this, I mean that a closure function has access to the variables and parameters defined in the outer scope.
    //Remember that in Java and traditional procedural programming, the variables were tied to the scope, and as soon as the block got executed, local properties were blown out of the memory.
    //Java 8 lambdas can access outer variables, but can’t modify them, and this limits the capabilities if you try to do functional programming in Java 8.
    //Let’s take a look at an example where we work with closures in Kotlin.
    // the sum variable is defined in the outer scope; still, we are able to access and modify it.
    fun main (args: Array<String>) {
        var sum=0
        var listOfInteger= arrayOf (0, 1, 2, 3, 4, 5, 6, 7)
        listOfInteger.forEach {
            sum+=it
            println (sum)
        }
    }
    /////////////////////////////////////////////////////////////////////////////////
}