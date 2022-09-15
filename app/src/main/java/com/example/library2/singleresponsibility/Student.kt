package com.example.library2.singleresponsibility
//https://www.youtube.com/watch?v=or1ISx1zYSM&list=PLINp1xZ5bPrqtE3Hee3vnyrHCaOyMADBt&index=1
class Student {
    private val name:String =""
    private val age:Int = 15

    fun showGrade(){

    }
}

class StudentViolation {
    private val name:String =""
    private val age:Int = 15

    fun showGrade(){

    }

    fun print(){
        //not from the student responsibilities to print or format
    }

    fun format(){
        //not from the student responsibilities to print or format
    }

}