package com.example.library2.algorithmsandds.linkedlist

class LinkedList<T: Any> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size = 0

    fun isEmpty(): Boolean{
        return size == 0
    }

    override fun toString(): String {
        if (isEmpty()) {
            return "Empty list"
        } else {
            return head.toString()
        }
    }

    fun push(value: T){// insert at the front
        head = Node(value, next = head)
        if (tail == null){
            tail = head
        }
        size++
    }

    fun pushChained(value: T):LinkedList<T>{// insert at the front
        head = Node(value, next = head)
        if (tail == null){
            tail = head
        }
        size++
        return this
    }

    fun append(value: T){
        if (size == 0){
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