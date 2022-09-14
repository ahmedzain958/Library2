package com.example.library2.liskov

import java.io.File

open class FileLogger {
    open fun logError(error: String){
        val file = File("errors.txt").also {
            it.appendText(error)
        }
    }
}
/* Liskov's substitution
if we passed to the @MainRepository this CustomFileLogger class and requested to execute the logError() method, it will execute the Parent FileLogger.logError() that exists inside the child
CustomErrorFileLogger as it inherits not calling the CustomErrorFileLogger.customLogError(); override a  logError() inside the CustomErrorFileLogger class and remove the customLogError() method
hence:

https://www.linkedin.com/pulse/liskov-substitution-principle-lsp-paul-gichure-ctfl/#:~:text=This%20principle%20ensures,Liskov%20substitution%20principle.
=>  the objects of the subclasses should behave in the same way as the objects of the superclass.
=> This principle ensures that inheritance (one of the OOP principles) is used correctly. If an override method does nothing or just throws an exception, then you're probably violating the LSP.
The classic example of the inheritance technique causing problems is the circle-elipse problem (a.k.a the rectangle-square problem) which is a is a violation of the Liskov substitution principle.
 */
class CustomErrorFileLogger: FileLogger(){
    fun customLogError(error: String){
        val file = File("custom_errors.txt").also {
            it.appendText(error)
        }
    }
}