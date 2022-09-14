package com.example.library2.liskov
/*
https://www.linkedin.com/pulse/liskov-substitution-principle-lsp-paul-gichure-ctfl/
this class violates liskov's substitution principle, by using inheritance, much as technically Penguin is a bird, it doesn't fly
 */
open class Bird {
    open fun fly(){

    }
    open fun walk(){

    }
}
class Dove: Bird(){
    override fun walk() {
        println("I can walk");

    }

    override fun fly() {
        println("I can fly");

    }
}
class Penguin : Bird() {
    override fun fly() {
        println("I can't fly");
    }
    //rather you would implement an empty fly method
    /*
        override fun fly() {
        //violates Liskov's p
        }
     */
    override fun walk() {
        super.walk()
    }
}
/*
    To correct this, the developer would be forced modify the code to accommodate the instance of Penguin (adhere to LSP or violate OCP principle)
 */
open class BirdSolution {

    open fun walk(){

    }
}
open class FlyingBird: BirdSolution() {
    open fun fly(){

    }
}
class DoveSolution: FlyingBird() {
    /*
    the dove can both walk(from the BirdSolution class) and fly (from the flying bird class)
     */
    override fun walk() {
        super.walk()
    }
    override  fun fly(){
    }
}
class PenguinSolution: BirdSolution(){
    override fun walk() {
        super.walk()
    }
}