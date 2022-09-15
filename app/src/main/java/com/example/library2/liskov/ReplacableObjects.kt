package com.example.library2.liskov

open class SuperType(){

}

class SubType: SuperType() {

}

fun main1() {
    var superType = SuperType()
     superType = SubType()
}

/*
let's violate
 */

open class SuperTypeViolation {
    open fun sayHello(){
        println("Hello")
    }
    open fun sayOk(){
        println("Ok")
    }
}

class SubTypeViolation: SuperTypeViolation() {
    override fun sayHello(){
        // no implementation or throw exception
    }
    override fun sayOk(){
        println("Ok")
    }
}

fun main() {
    var superType = SuperTypeViolation()
    superType = SubTypeViolation()
    superType.sayHello() // won't say Hello as it is fretful (3abbos)
    superType.sayOk() // would say Ok only :)
}