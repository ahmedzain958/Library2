package com.example.library2.leetcode

fun pivotIndex(nums: IntArray): Int {
    val sumLeftArray = IntArray(nums.size)
    sumLeftArray[0] = nums[0]
    val sumRightArray = IntArray(nums.size)
    sumRightArray[0] = nums[0]

    for (i in 1 until sumLeftArray.size) {
        sumLeftArray[i] += nums[i-1]
        for (j in sumRightArray.size - 1 downTo i) {
            sumRightArray[j] += nums[j]
            if (sumRightArray[j] == 0) {
                return 0
            } else if (sumRightArray[j] == sumLeftArray[i]) {
                return i
            }
        }
    }
    return 0
}

fun main() {
    val nums = intArrayOf(1, 7, 3, 6, 5, 6)
    println(pivotIndex(nums))
}
