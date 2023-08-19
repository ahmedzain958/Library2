package com.example.library2.kotlinfns

fun main(args: Array<String>) {
    inlineFunction({ println("calling inline functions")})
}

inline fun inlineFunction(myFun: () -> Unit ) {
    myFun()
    print("code inside inline function")
}