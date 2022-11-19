package com.example.library2.designpatterns.linkedin.decoratorpattern.zainstarbuzz

/**
 * Every decorator delegates the cost calculation the beverage it is composed with
 */
abstract class ZaincoCondimentDecorator: ZaincoBevarage() {
    abstract fun getDecoratorDescription(): String

}