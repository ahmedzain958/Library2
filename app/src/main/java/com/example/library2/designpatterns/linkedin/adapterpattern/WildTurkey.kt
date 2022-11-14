package com.example.library2.designpatterns.linkedin.adapterpattern

class WildTurkey: Turkey {
    override fun fly() {
        println("I'm flying a short distance");
    }

    override fun gobble() {
        println("Gobble gobble");
    }
}