package com.example.library2.kotlinfns

fun main(args: Array<String>) {
    inlineFunction({ println("calling inline functions")})
}

inline fun inlineFunction(myFun: () -> Unit ) {
    myFun()
    print("code inside inline function")
}

//using inline function vs normal function
/*
inline functions: created in public, not inside another functions
inline functions: kotlin bytecode doesn't create new classes for its functions just places the called && passed lamda function inside the inlined one without any redundant classes creation, counterwise
normal functions: when passed a lamda function, it creates extra classes in kotlin bytcode
 */