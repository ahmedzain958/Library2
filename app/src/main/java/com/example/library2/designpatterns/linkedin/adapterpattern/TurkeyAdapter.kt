package com.example.library2.designpatterns.linkedin.adapterpattern

class TurkeyAdapter(private val turkey: Turkey) : Duck {
    override fun fly() {
        turkey.fly()
    }

    override fun quack() {
        turkey.gobble()
    }

}