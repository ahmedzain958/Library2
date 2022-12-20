package com.example.library2.problemsolving.leetcode

fun singleNumberSet(nums: IntArray): Int {
   val set = mutableSetOf<Int>()
    for (i in nums){
        if (set.contains(i))
            set -= i
        else
            set += i
    }
    return set.elementAtOrNull(0) ?: 0
}

fun singleNumberXor(nums: IntArray): Int {
    var result = 0
    for (i in nums){
        result = result.xor(i)
    }
    return result
}

fun main() {
   print( singleNumberXor(intArrayOf(0,1,1)))
}