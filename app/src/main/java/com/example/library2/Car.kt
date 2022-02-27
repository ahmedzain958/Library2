package com.example.library2

enum class Direction {
    NORTH,
    SOUTH
}

class Car {
    fun drive(direction: Direction): String {
        return "Driving $direction at speed "
    }

    fun drive2(direction: Direction): String {
        return "Driving $direction at speed "
    }

    fun recordTelemetry(speed: Double, direction: Direction) {

    }
}