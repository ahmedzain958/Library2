package com.example.library2.scopefns

class myData(val id: Int, val name: String)

fun main() {
    val list = listOf<myData>(myData(1, "Zain"),
        myData(2, "Zain2"),
        myData(3, "Zain3")).let {
        val myListt = it.filter { additionalMessage: myData ->
            additionalMessage.id != 1
        }
        println(myListt.forEach{
            println(it.name)
        })
    }
}