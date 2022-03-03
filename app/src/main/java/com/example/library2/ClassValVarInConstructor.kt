package com.example.library2

class ValVarInConstructor(
    val hasVal: String,
    hasNoVal: String,
    var hasVar: String,
    hasNoVar: String
) {
    init {
        println(hasVal)
        println(hasNoVal)
        println(hasVar)
        println(hasNoVar)
    }

    fun testWithValVarAndWithoutAccessability() {
        println(hasVal)
//        println(hasNoVal)//not accessible
        println(hasVar)
//        println(hasNoVar)//not accessible
    }

    inner class TestFromInnerTheOuterClassAccessibilityToValVar() {
        init {
            println(hasVal)
//        println(hasNoVal)//not accessible
            println(hasVar)
//        println(hasNoVar)//not accessible
        }
    }
}

class TestFromOuterClassAccessibilityToValVar() {
    init {
        val valVarInConstructor = ValVarInConstructor("hasVal", "hasNoVal", "hasVar", "hasNoVar")
    }
    fun test(){
        val valVarInConstructor = ValVarInConstructor("hasVal", "hasNoVal", "hasVar", "hasNoVar")
    }
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////