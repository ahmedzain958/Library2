package com.example.library2.kotlinfns

class SettersAndGettersProperty {
    var name: String = ""
        get() = field
        set(value){
            field = value
        }
}

/**
 * We have noticed these two identifiers in the above program.

Value: Conventionally, we choose the name of the setter parameter as value,
but we can choose a different name if we want.
The value parameter contains the value that a property is assigned to. In the above program,
we have initialized the property name as c.name = “GeeksforGeeks”,
the value parameter contains the assigned value “GeeksforGeeks”.
Backing Field (field): It allows storing the property value in memory possible.
When we initialize a property with a value, the initialized value is written to the backing field of that property.
In the above program, the value is assigned to field, and then, field is assigned to get().

 */
fun main() {
    val settersAndGettersProperty = SettersAndGettersProperty()
    settersAndGettersProperty.name  = "Geeks For Geeks"
    println(settersAndGettersProperty.name)
}