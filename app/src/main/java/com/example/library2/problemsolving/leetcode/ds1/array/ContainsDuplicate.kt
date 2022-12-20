package com.example.library2.problemsolving.leetcode.ds1.array

    fun containsDuplicate(nums: IntArray): Boolean {
        val hashSet = HashSet<Int>()
        for(i in nums.indices){
            if (!hashSet.add(nums[i]))
                return true
        }
        return false
    }

    fun main() {
        val array: Array<Int> = arrayOf(2,14,18,22,22)
        println(containsDuplicate(array.toIntArray()))
    }
