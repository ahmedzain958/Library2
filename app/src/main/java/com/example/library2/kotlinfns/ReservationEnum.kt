package com.example.library2.kotlinfns

enum class ReservationEnum(val status: String) {
    ACTIVE("ACTIVE"),
    EXPIRED("EXPIRED"),
    CANCELLED("CANCELLED")
}

fun main() {
    for (day in ReservationEnum.values()) {
        println(
            "Ordinal = [${day.ordinal}] \n Name =  ${day.name} \n" +
                    " status = (${day.status})"
        )
        println(
            "*-------------------------------*"
        )
    }

}