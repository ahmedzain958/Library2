package com.example.library2.designpatterns.linkedin.observerpattern

class SimpleObserver(var simpleSubject: Subject): Observer {
    var subject: Subject = simpleSubject

    init {
        subject.registerObserver(this)
    }
    override fun update(valueToPublish: Int) {
        TODO("Not yet implemented")
    }
}