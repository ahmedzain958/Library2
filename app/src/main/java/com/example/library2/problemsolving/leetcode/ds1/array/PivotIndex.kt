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
    for (i in 1..nums.size - 1) {
        rsum += nums[i]
    }

    /* iterating the loop from 0-n
        -> keep subtracting the pivot value from right sum
        -> also keep adding the left side of pivot value to left sum*/

    for (i in 0..nums.size - 1) {

        if (i > 0) { // this check is for case when pivot is at left and there are no elements to the left
            lsum += nums[i - 1]
            rsum -= nums[i]
        }

        if (lsum == rsum) {
            return i
        }
    }
    return -1
}


fun pivotIndex4(nums: IntArray): Int {
    var leftSum = 0
    var rightSum = 0
    var i = 0
    while (i < nums.size) {
        leftSum += nums[i]
        i++
    }
    var j = i + 1
    while (j < nums.size) {
        if (leftSum == rightSum + nums[i])
            return i
        else {
            rightSum += nums[j]
            j++
        }
    }
    for (j in nums.size-1 downTo 0){
        leftSum -= nums[j]
        rightSum += nums[j]
        if(leftSum == rightSum- nums[j])
            return j
    }
    return -1
}

//best solution
fun pivotIndex5(nums: IntArray): Int {
    var leftSum = 0
    var rightSum = 0
    var i = nums.size-1
    while (i >= 0 && i <= nums.size) {
        rightSum += nums[i]
        i--
    }

    for (j in nums.indices){
        leftSum += nums[j]
        if(leftSum == rightSum )
            return j
        rightSum -= nums[j]
    }
    return -1
}


fun main() {
    val array: Array<Int> = arrayOf(1, 7, 3, 6, 5, 6)
    val array2: Array<Int> = arrayOf(2,1,-1)
    val array3: Array<Int> = arrayOf(1,2,3)
    val array4: Array<Int> = arrayOf(-1,-1,0,0,-1,-1)
    val array5: Array<Int> = arrayOf(-1,-1,-1,-1,-1,0)
    println(pivotIndex5(array2.toIntArray()))
}