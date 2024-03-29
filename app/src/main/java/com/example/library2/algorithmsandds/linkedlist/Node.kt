package com.example.library2.algorithmsandds.linkedlist

class Node<T: Any> (var value: T, var next: Node<T>?=null) {
    override fun toString(): String {
        return if (next != null){
            "$value -> ${next.toString()}"
        }else{
            "$value"
        }
    }
}