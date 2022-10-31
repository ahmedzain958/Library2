package com.example.library2.leetcode;

public class PivotIndex {
    public static int pivotIndex(int[] nums) {
        int[] sumLeftArray = nums;
        int[] sumRightArray = nums;
        for (int i = 1; i < nums.length; i++) {
            System.out.println("outer loop of left array i="+i+" nums="+nums+" sumLeftArray="+sumLeftArray);
            sumLeftArray[i] += sumLeftArray[i-1];
            for (int j = nums.length - 2; i > 0; i--) {
                System.out.println("inner loop of right array j="+j+" nums="+nums+" sumRightArray="+sumRightArray);
                if (sumRightArray[j] == sumLeftArray[i]) {
                    return i;
                }
                sumRightArray[j] += sumRightArray[j+1];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{ 1,7,3,6,5,6 }));
    }
}
