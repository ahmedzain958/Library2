package com.example.library2
 val ALPHABETICAL_LETTERS = listOf("A", "B", "C","D", "E", "F","G", "H", "I","J", "K", "L","M", "N", "O","P", "Q", "R",
    "S", "T", "U","V", "W", "X", "Y", "Z")
class SeatsGenerator {
    fun createSeats(rows: Int, seatsInRow: Int, firstRowNumber: Int): List<String> {
       val seatsList = mutableListOf<String>()
        for (row in firstRowNumber..rows){
            for (character in 0 until seatsInRow){
                seatsList.add("$row${ALPHABETICAL_LETTERS[character]}")
            }
        }
        return seatsList
    }

}

fun main() {
    val seatsGenerator = SeatsGenerator()
    val seats = seatsGenerator.createSeats(2, 4, 1)
    println(seats)
}