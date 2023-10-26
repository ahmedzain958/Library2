package com.example.library2.kotlinfns

fun main() {
    println(isStringValid("^ahmed*"))
}

fun isStringValid(input: String): Boolean {
    val disallowedCharactersRegex = Regex("[@\$#!?%^&*]")
    return !disallowedCharactersRegex.containsMatchIn(input)
}