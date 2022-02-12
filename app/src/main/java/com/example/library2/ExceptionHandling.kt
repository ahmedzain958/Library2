package com.example.library2

import java.lang.ArithmeticException

/*exception is abnormal condition, code is successfully compiled and you can execute it, but while executing any event that interrupts the normal flow of your execution
is called exception, happens in runtime

ArithmeticException, OutOfBoundException, ... are classes used for exception handling
You can create you own custom exception class, each exception class contains the message, stacktrace
 */
fun main() {
//exception as expression
    val result = try{10/0}catch (e: ArithmeticException){ 0 }
    println(result)
}