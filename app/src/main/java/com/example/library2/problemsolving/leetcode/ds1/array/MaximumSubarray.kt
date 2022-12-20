package com.example.library2.problemsolving.leetcode.ds1.array

import kotlin.math.max

fun maxSubArray(nums: IntArray): Int {
    var maxSub = nums[0]
    var currentSum = 0
    for (i in nums) {
        if (currentSum<0){
            currentSum = 0
        }
        currentSum += i
        maxSub = max(currentSum, maxSub)
    }
    return maxSub
}

fun main() {
    val array: Array<Int> = arrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)
    println(maxSubArray(array.toIntArray()))
}