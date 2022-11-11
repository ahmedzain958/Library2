package com.example.library2.oop

open class Bird() {
    var color = "red"
    fun color(): String {
        return color
    }

    open fun fly() {
        println("Bird flying")
    }
}

class Pigeon : Bird() {
    fun changeColor() {
        super.color = "green"

        val b = Bird()
        b.color = "green"

    }

    override fun fly() {
        println("Pigeon flying")
    }
}

fun main() {
    val p = Pigeon()
    println("Pigeon color before calling change color from pigeon class is ")
    println("Pigeon color is the same as bird color ")
    println(p.color)
    println("-----------------------------------------------------------------")
    val b = Bird()
    p.changeColor()
    println("Bird color after calling change color from pigeon class is ")
    println(b.color)
    println("Bird color not affected by calling  super.color = \"green\"\n" +
            "    or    val b = Bird()\n" +
            "     or   b.color = \"green\"")
    println("-----------------------------------------------------------------")
    println("Pigeon color after calling change color from pigeon class is ")
    println(p.color)
    println("Pigeon color only affected by calling  super.color = \"green\"\n  or color = \"yello\""  +
            "        val b = Bird()\n" +
            "// not this        b.color = \"green\" ")
    println("-----------------------------------------------------------------")
    p.fly()
}