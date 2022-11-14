package com.example.library2.designpatterns.linkedin.adapterpattern

class MallardDuck : Duck {
    override fun fly() {
        println("Mallard Flying")
    }

    override fun quack() {
        println("Mallard Quacking")
    }
}