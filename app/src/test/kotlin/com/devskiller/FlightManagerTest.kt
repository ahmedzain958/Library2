package com.devskiller

import com.example.library2.Flight
import com.example.library2.FlightManager
import org.junit.Assert.assertThat
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class FlightManagerTest {

    private val flightManager = FlightManager()
    private val flight1 = Flight("LO1533", "WAW", "MUC")
    private val flight2 = Flight("LH1232", "JFK", "PAR")
    private val flight3 = Flight("YH1732", "PAR", "JFK")

   /* @Test
    fun `creates a new flight`() {
        assertThat(flightManager.addNewFlight(flight1)).isTrue()
    }

    @Test
    fun `finds valid connection`() {
        flightManager.addNewFlight(flight1)
        flightManager.addNewFlight(flight2)
        flightManager.addNewFlight(flight3)

        val flights = flightManager.findFlightsBetween("JFK", "PAR", false)

        assertThat(flights).isEqualTo(listOf(flight2, flight3))
        print(listOf(flight2, flight3))
    }*/
}