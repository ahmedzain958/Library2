package com.example.library2

data class Flight(val flightNumber: String, val origin: String, val destination: String)

class FlightManager {

    fun addNewFlight(flight: Flight): Boolean {
       return true
    }

    fun findFlightsBetween(origin: String, destination: String, directionSensitive: Boolean): List<Flight> {
        return emptyList()
    }
}