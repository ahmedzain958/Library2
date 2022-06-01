package com.example.library2

open class Parent {
    fun foo() {
        bar()
    }

    private fun bar() {
    }
}

class Child: Parent()