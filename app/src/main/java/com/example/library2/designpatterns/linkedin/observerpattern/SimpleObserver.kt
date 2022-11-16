package com.example.library2.designpatterns.linkedin.observerpattern

class SimpleObserver: Observer {
    lateinit var subject: Subject
    constructor(simpleSubject: Subject){
        subject = simpleSubject
        subject.registerObserver(this)
    }
    override fun update(valueToPublish: Int) {
        TODO("Not yet implemented")
    }
}