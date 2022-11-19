package com.example.library2.designpatterns.linkedin.decoratorpattern.zainstarbuzz

class HouseBlend: ZaincoBevarage() {
    init {
        description = "HouseBlend"
    }
    override fun cost(): Double {
        return 0.99
    }
}