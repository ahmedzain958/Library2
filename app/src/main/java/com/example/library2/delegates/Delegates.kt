package com.example.library2.delegates

import kotlin.reflect.KProperty

class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    /**
     *
     * @param thisRef first parameter is the object you read p from, ex: if p variable is inside another class
     */
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }
}

class Delegates{
    var p: String by Delegate()

}

fun main() {
    val d = Delegates()
    d.p = "hhh"
//    println(p)
}

interface Base {
    fun print()
}

class BaseImpl(val x: Int) : Base {
    override fun print() {
        print(x)
    }
}

class Derived(b: Base) : Base by b

/*
fun main() {
    val b = BaseImpl(10)
    Derived(b).print()
}*/
