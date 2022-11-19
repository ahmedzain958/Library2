package com.example.library2.designpatterns.linkedin.decoratorpattern.zainstarbuzz

class Espresso: ZaincoBevarage() {
    init {
        description = "Espresso"
    }

    override fun cost(): Double {
        return 0.5
    }
}