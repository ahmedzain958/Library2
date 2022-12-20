package com.example.library2.problemsolving.leetcode.ds1.array

class RunningSumOF1DArray {
    fun runningSum(nums: IntArray): IntArray {
        for(i in 1 until nums.size){
            nums[i] += nums[i-1]
        }
        return nums
    }
}