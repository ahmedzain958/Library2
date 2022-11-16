package com.example.library2.designpatterns.linkedin.observerpattern

class SimpleSubject(val observers: ArrayList<Observer>) : Subject {
    private var valueToPublish: Int = 0
    fun setValue(newValue: Int){
        valueToPublish = newValue
        notifyObservers()
    }
    override fun registerObserver(observer: Observer) {
        observers.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }

    override fun notifyObservers() {
        observers.forEach {
            it.update(valueToPublish)
        }
    }
}