package com.example.library2.dsl

import com.example.library2.R

//https://www.raywenderlich.com/2780058-domain-specific-languages-in-kotlin-getting-started

data class Puppy(var isLiked: Boolean = false, var imageResource: Int = 0)

fun puppyLambdaswithReceivers(lambda: Puppy.() -> Unit): Puppy {
    val puppy = Puppy()
    puppy.lambda()
    return puppy
}

//To make the code more simple, you can use Kotlin’s apply extension function
//fun puppy(lambda: Puppy.() -> Unit) = Puppy().apply(lambda)
/*
* apply allows you to make the function implementation a one-liner by directly referencing the new object without the need to create a named property.
* The puppy function is now called like:*/

fun main() {
    puppyLambdaswithReceivers {
        isLiked = true
        imageResource = R.drawable.abc_vector_test
    }
}
/////////////////////////////
fun puppy(lambda: (Puppy) -> Unit): Puppy {
    // 1
    val puppy = Puppy()
    // 2
    lambda(puppy)
    // 3
    return puppy
}