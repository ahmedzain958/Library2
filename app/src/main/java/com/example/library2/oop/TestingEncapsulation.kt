package com.example.library2.oop

open class Bird() {
    var color = "red"
    fun color(): String {
        return color
    }

    open fun fly() {
        println("Bird")
    }
}

class Pigeon : Bird() {
    fun changeColor() {
        super.color = "green"
        val b = Bird()
        b.color = "green"
    }

    override fun fly() {
        println("Pigeon")
    }
}

fun main() {
    val p = Pigeon()
    val b = Bird()
    p.changeColor()
    println(b.color)
    println(p.color)
    p.fly()
}