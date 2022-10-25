package com.example.library2.leetcode

class RunningSumOf1DArray {
    fun runningSum(nums: IntArray): IntArray {
        for(i in 1 until nums.size){
            nums[i] += nums[i-1]
        }
        return nums
    }
}