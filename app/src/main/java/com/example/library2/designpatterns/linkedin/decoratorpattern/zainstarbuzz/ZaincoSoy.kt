package com.example.library2.designpatterns.linkedin.decoratorpattern.zainstarbuzz

class ZaincoSoy(val zaincoBevarage: ZaincoBevarage) : ZaincoCondimentDecorator() {

    var bevarage: ZaincoBevarage = zaincoBevarage
    init {
        description = bevarage.description + ", Soy"

    }
    override fun getDecoratorDescription(): String {
        return bevarage.description + ", Soy"
    }

    override fun cost(): Double {
        return 0.1 + bevarage.cost()
    }
}