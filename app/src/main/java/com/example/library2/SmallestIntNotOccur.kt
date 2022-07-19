package com.example.library2

fun main() {

}
fun solution(A: IntArray): Int {
     A.sort()
    var i = 1
    while (i <= A.size)
    {
        if (A[i-1] == i){
            i++
            continue
        } else {
            return i
        }
    }
    return 1
}
