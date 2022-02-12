package com.example.library2

/*exception is abnormal condition, code is successfully compiled and you can execute it, but while executing any event that interrupts the normal flow of your execution
is called exception, happens in runtime

ArithmeticException, OutOfBoundException, ... are classes used for exception handling
You can create you own custom exception class, each exception class contains the message, stacktrace
 */
fun main() {
    /*
    * If an exception gets thrown inside try{ }, all the catch clauses get checked one after another, and if one of the declared exceptions matches, the corresponding catch clause gets executed.
    * What you usually do if you want to catch several exceptions is to put the more specific catches at the beginning of the list and the most general at the end. */
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

/*
*  For example, say you have some code that accesses files, handles arrays, and in addition might throw unknown exceptions. Here you’d write
try {
    // ... file access
    // ... array access
} catch(e:IOException) {
    // do something...
} catch(e:ArrayIndexOutOfBoundsException) {
    // do something...
} catch(e:Exception) {
    // do something...
} finally {
    // do this by any means: ...
}
where the finally clause is optional, as usual.
*
* CautionBe careful not to abuse try-catch blocks for somewhat exceptional but otherwise expected program flow paths. You should really use exceptions only for unanticipated problems.*/