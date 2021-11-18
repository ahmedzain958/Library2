package com.example.library2.delegation

import kotlin.reflect.KProperty
//https://stackoverflow.com/questions/38250022/what-does-by-keyword-do-in-kotlin
//Delegation for property:
class Delegate {
    // for get() method, ref - a reference to the object from
    // which property is read. prop - property
    operator fun getValue(ref: Any?, prop: KProperty<*>) = "textA"
    // for set() method, 'v' stores the assigned value
    operator fun setValue(ref: Any?, prop: KProperty<*>, v: String) {
        println("value = $v")
    }
}

object SampleBy {
    var s: String by Delegate() // delegation for property
    @JvmStatic fun main(args: Array<String>) {
        println(s)
        s = "textB"
    }
}
/*
Result:

textA
value = textB
*/
/////////////////
//Delegation for class:
interface BaseInterface {
    val value: String
    fun f()
}
interface SecondInterface {
    val value2: String
    fun f2()
}
class ClassA: BaseInterface {
    override val value = "property from ClassA"
    override fun f() { println("fun from ClassA") }
}
open class ClassZ: SecondInterface {
    override val value2 = "property from ClassB"
    override fun f2() { println("fun from ClassB") }
}
// The ClassB can implement the BaseInterface by delegating all public
// members from the ClassA.
class ClassB(classA: BaseInterface,classZ: ClassZ): BaseInterface by classA, ClassZ()//don't know why it wanted constructor invocation :D
object SampleBy2 {
    @JvmStatic fun main(args: Array<String>) {
        val classB = ClassB(ClassA(),ClassZ())
        println(classB.value)
        classB.f()
        classB.f2()
    }
}
////////////////
//Delegation for parameters:
// for val properties Map is used; for var MutableMap is used
class User(val mapA: Map<String, Any?>,val mapB: MutableMap<String, Any?>) {
    val name: String by mapA
    val age: Int by mapA
    var address: String by mapB
    var id: Long by mapB
}

object SampleBy3 {
    @JvmStatic fun main(args: Array<String>) {
        val user = User(mapOf("name" to "John", "age" to 30),
            mutableMapOf("address" to "city, street", "id" to 5000L))

        println("name: ${user.name}; age: ${user.age}; " +
                "address: ${user.address}; id: ${user.id}" +
                "\nuser.mapA: ${user.mapA}; user.mapB: ${user.mapB}")
    }
}
/*Result:

name: John; age: 30; address: city, street; id: 5000*/