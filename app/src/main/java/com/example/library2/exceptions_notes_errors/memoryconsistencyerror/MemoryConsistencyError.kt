package com.example.library2.exceptions_notes_errors.memoryconsistencyerror

import kotlin.jvm.JvmStatic

/**
 * When the concept of multithreading is implemented,
 * it is possible that changes made by one thread wouldn’t be visible to the other thread.
 * This indicates that the view of each thread is inconsistent with respect to each other.
 * This is known as memory consistency error.
 */
class MemoryConsistencyError {
    fun inc() {
        for (j in 0..4) {
            m = m + 1
            println("After its increment is " + m)
        }
    }

    fun dec() {
        for (j in 0..4) {
            m = m - 1
            println("After its decrement is " + m)
        }
    }

    companion object {

        var m = 2
        @JvmStatic
        fun main(args: Array<String>) {
            val my_inst = MemoryConsistencyError()
            val my_t_1: Thread = object : Thread() {
                override fun run() {
                    my_inst.inc()
                }
            }
            val my_t_2: Thread = object : Thread() {
                override fun run() {
                    my_inst.dec()
                }
            }
            my_t_1.start()
            my_t_2.start()
        }
    }
}