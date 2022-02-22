package com.example.library2

enum class Direction{
    NORTH,
    SOUTH
}
class Car {
    fun drive(direction: Direction, speed: Long):String {
        return "Driving $direction at speed $speed"
    }
}