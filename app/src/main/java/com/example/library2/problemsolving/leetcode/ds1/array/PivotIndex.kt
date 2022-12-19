package com.example.library2.problemsolving.leetcode.ds1.array

//         https://leetcode.com/problems/find-pivot-index/description/?envType=study-plan&id=level-1
fun pivotIndex(nums: IntArray): Int {
    var total = nums.sum()
    var leftSum = 0
    for (i in nums.indices) {
        if (i != 0) {
            leftSum += nums[i - 1]
        }
        if (leftSum == total - leftSum - nums[i]) {
            return i
        }
    }
    return -1
}


fun pivotIndex2(nums: IntArray): Int {
    var rsum = nums.sum()
    var lsum = 0
    for (i in 0..nums.size - 1) {
        rsum -= nums[i]
        if (rsum == lsum) return i
        lsum += nums[i]
    }
    return -1
}


fun pivotIndex3(nums: IntArray): Int {
    var lsum = 0
    var rsum = 0

    //pre calculating the right side of sum
    for(i in 1..nums.size-1){
        rsum += nums[i]
    }

    /* iterating the loop from 0-n
        -> keep subtracting the pivot value from right sum
        -> also keep adding the left side of pivot value to left sum*/

    for(i in 0..nums.size-1){

        if(i>0){ // this check is for case when pivot is at left and there are no elements to the left
            lsum += nums[i-1]
            rsum -= nums[i]
        }

        if(lsum == rsum){
            return i
        }
    }
    return -1
}


fun main() {
    val array: Array<Int> = arrayOf(1,7,3,6,5,6)
    println(pivotIndex3(array.toIntArray()))
}