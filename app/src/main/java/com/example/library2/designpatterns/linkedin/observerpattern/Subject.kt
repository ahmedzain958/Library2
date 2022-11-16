package com.example.library2.designpatterns.linkedin.observerpattern

interface Subject {
    fun registerObserver(observer: Observer)
    fun removeObserver(observer: Observer)
    fun notifyObservers()

}