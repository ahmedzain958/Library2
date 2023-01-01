package com.example.library2.algorithmsandds.linkedlist

fun main() {
    val linkedList = LinkedList<Int>()
    linkedList.push(1)
    linkedList.push(2)
    linkedList.push(3)
    println(linkedList.toString())
    println("-------------------------")

    val linkedList2 = LinkedList<Int>()
    linkedList2.pushChained(1).pushChained(2).pushChained(3)
    println(linkedList2.toString())
    println("-------------------------")


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
    println("-------------------------")


    val node1 = Node(value = 1)
    val node2 = Node(value = 2)
    val node3 = Node(value = 3)

    node1.next = node2
    node2.next = node3

    println(node1)
    println("-------------------------")
}