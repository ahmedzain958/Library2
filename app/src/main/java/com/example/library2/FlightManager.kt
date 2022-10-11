package com.example.library2

data class Flight(val flightNumber: String, val origin: String, val destination: String)

class FlightManager {
    val listOfFlights = mutableListOf<Flight>()

    fun addNewFlight(flight: Flight): Boolean {
        val hasFlight: Boolean = listOfFlights.any {
            it.flightNumber == flight.flightNumber
        }
        if (!hasFlight) {
            listOfFlights.add(flight)
            return true
        }
        return false
    }

    fun findFlightsBetween(
        origin: String,
        destination: String,
        directionSensitive: Boolean,
    ): List<Flight> {
        val flights = listOfFlights.filter {
            if (directionSensitive) it.origin == origin && it.destination == destination else it.origin == origin
        }
        return flights
    }
}