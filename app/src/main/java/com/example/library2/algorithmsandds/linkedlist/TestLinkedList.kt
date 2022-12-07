package com.example.library2.algorithmsandds.linkedlist

fun main() {
    val linkedList = LinkedList<Int>()
    linkedList.push(1)
    linkedList.push(2)
    linkedList.push(3)
    println(linkedList.toString())

    val linkedList2 = LinkedList<Int>()
    linkedList2.pushChained(1).pushChained(2).pushChained(3)
    println(linkedList2.toString())
}