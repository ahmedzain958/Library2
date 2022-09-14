package com.example.library2.liskovsubstitution

import java.io.File
//https://www.youtube.com.mcas.ms/watch?v=t8VTLxMsufU
open class LogError {//this class isn't replaceable/substitutable by the subtype class
    open fun logError(error: String){
        val file = File("errors.txt")
        file.appendText(error)
    }
}
class CustomLogError: LogError() {// cause this has extra method called customLogError()

    fun customLogError(error: String){
        val file = File("custom_errors.txt")
        file.appendText(error)
    }
}

/*if we used LogError in another class and replaced with CustomLogError,
the call of logError() method will use the parent/supertype method not the child onw
 */

//---------------------solution------------------
class CustomLogError2: LogError() {// CustomLogError

    override fun logError(error: String){
        val file = File("custom_errors.txt")
        file.appendText(error)
    }
}