package com.example.library2.kotlinfns

data class Game(val gameId: String)
class GetOrDefault {

}

fun main() {
    val id = "bla"
    val activeGames = mapOf(id to Game(id), id to Game(id) )
    val game1 = activeGames.getOrDefault(id, Game(id))
    // prints type of variable
    println("game1= $game1 -> game1's type is ${game1::class.simpleName}")
    println("game1= $game1 -> game1's type is ${game1.javaClass.simpleName}")

    println("activeGames= $activeGames-> activeGames' type is ${activeGames.javaClass.simpleName}")


    val callBack : (() -> Unit)? = null
}