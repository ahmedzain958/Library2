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

/**
 * Omitting val or var in in a constructor,
 * then the only places that can access these parameters are initialization statements that are evaluated at construction time.
 */
class TestFromOuterClassAccessibilityToValVar() {
    init {
        val valVarInConstructor = ValVarInConstructor("hasVal", "hasNoVal", "hasVar", "hasNoVar")
        valVarInConstructor.hasVal
        //valVarInConstructor.hasNoVal//not accessible
        valVarInConstructor.hasVar
        //valVarInConstructor.hasNoVar//not accessible
    }
    fun test(){
        val valVarInConstructor = ValVarInConstructor("hasVal", "hasNoVal", "hasVar", "hasNoVar")
        valVarInConstructor.hasVal
        valVarInConstructor.hasVar
    }
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////class with privates
class ValVarInConstructorWithPrivates(
   private val hasVal: String,
   //private hasNoVal: String,//Modifier 'private' is not applicable to 'value parameter'
   private var hasVar: String,
   //private hasNoVar: String//Modifier 'private' is not applicable to 'value parameter'
) {
    init {
        println(hasVal)
        println(hasVar)
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
class TestFromOuterClassAccessibilityToValVarWithPrivates() {
    init {
        val valVarInConstructor = ValVarInConstructorWithPrivates("hasVal", "hasNoVal")
        //valVarInConstructor.hasVal//not accessible
        //valVarInConstructor.hasVar//not accessible
    }
    fun test(){
        val valVarInConstructor = ValVarInConstructorWithPrivates("hasVal", "hasNoVal")
    }
}