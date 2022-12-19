package com.example.library2.algorithmsandds.linkedlist

class LinkedList<T : Any> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size = 0

    fun isEmpty(): Boolean {
        return size == 0
    }

    override fun toString(): String {
        if (isEmpty()) {
            return "Empty list"
        } else {
            return head.toString()
        }
    }

    fun push(value: T) {// insert at the front
        head = Node(value, next = head)
        if (tail == null) {
    /*
    head first insertion
     */
    fun push2(value: T){// insert at the front
        head = Node(value, next = head/*always the next is the current head*/)
        if (tail == null){
            tail = head
        }
        size++
    }

    fun pushChained(value: T): LinkedList<T> {// insert at the front
        head = Node(value, next = head)
        if (tail == null) {
            tail = head
        }
        size++
        return this
    }

    /**
     * The third and final operation for adding values is insert(afterNode: Node<T>). This operation inserts a value at a particular place in the list and requires two steps:

    Finding a particular node in the list.
    Inserting the new node after that node.
    First, you’ll implement the code to find the node where you want to insert your value.

    In LinkedList.kt, add the following code just below append:
     */
    fun nodeAt(index: Int): Node<T>? {
        var currentNode = head
        var currentIndex = 0
        while (currentNode != null && currentIndex < index){
            currentNode = currentNode.next
            currentIndex++
        }
        return currentNode
    }

    fun insert(value: T, afterNode: Node<T>): Node<T>{
        if (tail == afterNode ){//|| index == size-1
            append(value)
            return tail!!
        }
        val node = Node(value, afterNode.next)
        afterNode.next = node
        size++
        return node
    }
    fun append(value: T) {
        if (size == 0) {
            head = Node(value, head)
            tail = head
            size++
            //or rather write push(value)
            return
        }
        val newTail = Node(value, null)
        tail?.next = newTail
        tail = newTail
        size++
    }


}