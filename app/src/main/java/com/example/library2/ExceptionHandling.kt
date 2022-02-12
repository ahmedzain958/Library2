package com.example.library2

/*exception is abnormal condition, code is successfully compiled and you can execute it, but while executing any event that interrupts the normal flow of your execution
is called exception, happens in runtime

ArithmeticException, OutOfBoundException, ... are classes used for exception handling
You can create you own custom exception class, each exception class contains the message, stacktrace
 */
fun main() {
    /*
    * If an exception gets thrown inside try{ }, all the catch clauses get checked one after another, and if one of the declared exceptions matches, the corresponding catch clause gets executed. */
try {
    vote2("Ahmed", 7)
}catch (e: IllegalVoterException){
    e.printStackTrace()
}catch (e: java.lang.Exception){}//multiple catch but one finally
//exception as expression
    val result = try {
        println("inside try")
        10 / 0
    } catch (e: ArithmeticException) {
        0
    }
    println("the result is $result")
}

//Exception classes hierarchy Throwable(master exception class) -> Exception -> predefined exceptions
fun vote(name: String, age: Int) {
    if (age < 18) throw IllegalArgumentException("Younger than 18 can't vote")
    print("$name voted")
}

fun vote2(name: String, age: Int) {
    if (age < 18) throw IllegalVoterException("Younger than 18 can't vote")
    print("$name voted")
}

class IllegalVoterException(message: String) : Exception(message)