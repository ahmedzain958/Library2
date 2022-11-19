package com.example.library2.designpatterns.linkedin.decoratorpattern.zainstarbuzz

class ZaincoMilk(val zaincoBevarage: ZaincoBevarage) : ZaincoCondimentDecorator() {


    var bevarage: ZaincoBevarage = zaincoBevarage
    init {
        description = bevarage.description + ", Milk"

    }
    override fun getDecoratorDescription(): String {
        return bevarage.description + ", Milk"
    }

    override fun cost(): Double {
        return 0.1 + bevarage.cost()
    }

}