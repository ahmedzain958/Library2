package com.example.library2.openforextension
// sw entities (module, classes and fns ) should be open for extension closed for modification

class AreaCalculationViolation {
    fun calculateArea(shape: Shape){
        if(shape is Triangle){
            println(0.5* shape.height * shape.width)
        }
        else if(shape is Rectangle){
            println(shape.height * shape.width)
        }
        else if(shape is Circle){
            println(shape.height * shape.width)
        }
    }
    //if we got another shape like a square, we must add if condition to the method
}
interface ShapeSolution {
  fun calculateArea(): Int
}
class TriangleSolution: ShapeSolution{
    override fun calculateArea(): Int {
       return 1*1
    }
}
class RectangleSolution: ShapeSolution{
    override fun calculateArea(): Int {
       return 2*2
    }
}
class CircleSolution: ShapeSolution{
    override fun calculateArea(): Int {
     return  6*6
    }
}


class AreaCalculationSolution {
    fun calculateArea(shape: ShapeSolution): Int {
        return shape.calculateArea()
    }
//if we got another shape like a square, we must add if condition to the method
}