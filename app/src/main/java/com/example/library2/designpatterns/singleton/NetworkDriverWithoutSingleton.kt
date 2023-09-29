package com.example.library2.designpatterns.singleton

import org.apache.tools.ant.types.Assertions
import org.junit.Test

class NetworkDriverWithoutSingleton {
    init {
        println("Initializing $this")
    }

    fun log(): NetworkDriverWithoutSingleton = apply {
        println("Network Driver: $this")
    }
}

object NetworkDriverSingleton {
    init {
        println("Initializing $this")
    }

    fun log(): NetworkDriverSingleton = apply {
        println("Network Driver: $this")
    }
}

class NetworkDriverWithoutSingletonTest {
    @Test
    fun testNetworkDriverWithoutSingleton() {
        val networkDriverWithoutSingleton1 = NetworkDriverWithoutSingleton().log()
        val networkDriverWithoutSingleton2 = NetworkDriverWithoutSingleton().log()

        val networkDriverSingleton1 = NetworkDriverSingleton.log()
        val networkDriverSingleton2 = NetworkDriverSingleton.log()

        assert(networkDriverSingleton1 == networkDriverSingleton2)

    }
}