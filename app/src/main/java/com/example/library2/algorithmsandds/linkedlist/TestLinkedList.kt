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


    val list = LinkedList<Int>()
    list.push(3)
    list.push(2)
    list.push(1)

    println("Before inserting: $list")
    var middleNode = list.nodeAt(1)!!
    for (i in 1..3) {
        middleNode = list.insert(-1 * i, middleNode)
    }
    println("After inserting: $list")
}