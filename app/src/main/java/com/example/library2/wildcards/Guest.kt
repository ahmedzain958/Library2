package com.example.library2.wildcards

//https://www.youtube.com/watch?v=1Omf1Vba44Y
fun main() {
    val t = Tray()
    t.add(Glass<OrangeJuice>())
    t.add(Glass<Juice>())
    t.add(Glass())//without mentioning it will take the default
    t.remove(Glass<CokeZero>())
    t.remove(Glass<Coke>())
    t.remove(Glass<CokeDiet>())
    /*
    t.remove(Glass<Juice>())
    Type mismatch.
    Required:Glass<in CokeZero!>!
    Found:Glass<Juice>
     */

}
/*
compile Time vs Runtime
Kotlin is a compiled language, meaning that your program is translated into machine-language instructions prior to execution by a special program, called the compiler. During this step, the compiler ensures that certain requirements are met by your code before the instructions are generated.

For example, the compiler checks whether null is assigned to a nullable type. As you have seen, if you attempt to assign null to a non-nullable type, Kotlin will refuse to compile your program.

Errors caught at compile time are called compile-time errors, and they are one of the advantages of working with Kotlin. It may sound odd to say that errors are an advantage, but having the compiler check your work during development – before you allow others to run your program and tell you about your mistakes – makes it much easier to track down problems.

On the other hand, a runtime error is a mistake that happens after the program has compiled and is already running, because the compiler was unable to discover it. For example, because Java lacks any distinction between nullable and non-nullable types, the Java compiler cannot tell you that there is a problem if you ask a variable with a value of null to perform work. Code like that compiles just fine in Java, but it will crash at runtime.

Generally speaking, compile-time errors are preferable to runtime errors. Finding out about a problem while you are writing code is better than finding out later. And finding out after your program has been released? That is the worst.
 */