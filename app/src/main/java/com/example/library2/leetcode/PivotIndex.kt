package com.example.library2.leetcode

fun pivotIndex(nums: IntArray): Int {
    var sumLeftArray: IntArray = nums
    var sumRightArray: IntArray = nums
    sumLeftArray[0] = nums[0]
    sumRightArray[nums.size-1] = nums[nums.size-1]
    for (i in 1 until sumLeftArray.size) {
        sumLeftArray[i] += sumLeftArray[i-1]
    }
    for (i in sumRightArray.size-2 downTo  1) {
        sumRightArray[i] += sumRightArray[i-1]
        println(sumRightArray[i])
    }
}

fun main() {
    val nums = intArrayOf(1, 7, 3, 6, 5, 6)
    println(pivotIndex(nums))
}
