package com.example.library2
data class ZainCo(val a :Int,
                val z :Zain)
data class Zain(val a :Int,
                val b :Boolean,)
fun main() {
    val a = 5
    val b = true
    val z = Zain(a,b)
    val zc = ZainCo(a,z)
    with(zc){
        if (z.b)
            println("true")
        else
            println("f")
    }


}