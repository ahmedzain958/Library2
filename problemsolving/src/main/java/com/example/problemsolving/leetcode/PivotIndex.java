package com.example.problemsolving.leetcode;

public class PivotIndex {
    public static int pivotIndex(int[] nums) {
        int total = 0, temp = 0;
        for (int num : nums) total += num;
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++){
            if (i != 0) //throws index out of bound if i=0, if there is no condition
                leftSum += nums[i-1];
            if (total - leftSum - nums[i] == leftSum){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{ 1,7,3,6,5,6 }));
    }
}
