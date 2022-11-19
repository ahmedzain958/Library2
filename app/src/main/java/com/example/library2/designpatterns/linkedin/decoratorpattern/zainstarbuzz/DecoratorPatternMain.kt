package com.example.library2.designpatterns.linkedin.decoratorpattern.zainstarbuzz

fun main() {
    var zaincoBevarage: ZaincoBevarage = Espresso()
    zaincoBevarage = ZaincoMilk(zaincoBevarage)
    println(zaincoBevarage.cost())
    println(zaincoBevarage.getDecoratorDescription())

    var houseBlend: ZaincoBevarage = HouseBlend()
    houseBlend = ZaincoSoy(houseBlend)
    houseBlend = ZaincoMilk(houseBlend)
    println(houseBlend.cost())
    println(houseBlend.getDecoratorDescription())
    println("------wrapping a condiment by a basic cofee of a decorated coffee----------")

    houseBlend = ZaincoSoy(houseBlend)
    println(houseBlend.cost())
    println(houseBlend.getDecoratorDescription())
}