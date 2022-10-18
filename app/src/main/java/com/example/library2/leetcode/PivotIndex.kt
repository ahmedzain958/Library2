package com.example.library2.leetcode

class PivotIndex {
    /* fun pivotIndex(nums: IntArray): Int {
         for (i in 1 until nums.size) {
             val sumLeftArray = Array(nums.size){nums[i]+nums[i-1]}
             val sumRightArray = arrayOf(nums.size)
             sumLeftArray[i - 1] += nums[i - 1]
             sumRightArray[i + 1] += nums[i + 1]
             if (sumLeftArray[i - 1] == sumRightArray[i + 1] - nums[i]) {
                 return i
             }
             return 0
         }
     }
     fun setUpLeftArray(index: Int){
         return
     }*/
}

fun main() {
    val nums = arrayOf(1, 7, 3, 6, 5, 6)
    for (i in 1 until nums.size) {
        val sumLeftArray = Array(nums.size) {
            nums[it] = nums[i-1] + nums[i]
            nums[it]
        }

//        sumLeftArray[i - 1] += nums[i - 1]
        println(sumLeftArray[i])
    }
    /*val fives = Array(5, ::fiver)
    fives.forEach {
        println(it)
    }*/
}

fun fiver(index: Int): Int {
    return index * 5
}