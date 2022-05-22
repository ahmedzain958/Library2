package com.example.library2.designpatterns.builder

fun main(args: Array<String>) {
    FoodOrder.Builder()
        .bread("bread")
        .condiments("condiments")
        .meat("meat")
        .fish("bread").let { println(it) }
}