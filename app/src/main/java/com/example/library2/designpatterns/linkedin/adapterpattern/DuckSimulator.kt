package com.example.library2.designpatterns.linkedin.adapterpattern

class DuckSimulator {

    fun main() {
        val duck: Duck = MallardDuck()
        testDuck(duck)
        //what if we had a turkey and we want to use the turkey in the duck simulator,
        // but the turkey has a slightly different interface
        //we can't use the turkey because the duck simulator test method expects objects
        // that have the duck interface with the quack and fly methods
        val turkey: Turkey = WildTurkey()
        val turkeyAdapter = TurkeyAdapter(turkey)
        testDuck(turkeyAdapter)

    }

    fun testDuck(duck: Duck) {
        duck.fly()
        duck.quack()
    }
}

