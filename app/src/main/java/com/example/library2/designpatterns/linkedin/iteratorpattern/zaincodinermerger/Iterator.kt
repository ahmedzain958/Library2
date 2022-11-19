package com.example.library2.designpatterns.linkedin.iteratorpattern.zaincodinermerger

interface Iterator {
    fun next(): ZaincoMenuItem
    fun hasNext(): Boolean
}