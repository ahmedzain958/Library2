package com.example.library2.oop.abstractmethodvsinheritedmethod

open abstract class Duck {
    //could be implemented as swimming is shared behavior among all ducks
    open fun swim() {
        println("Duck swimming")
    }

    //must be abstract and
    //must be implemented as display differs among all ducks
    abstract fun display()
}

class MullardDuck : Duck() {
    override fun swim() {
        println("MullardDuck swimming")
    }

    override fun display() {
        TODO("Not yet implemented")
    }
}