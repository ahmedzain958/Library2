package com.example.problemsolving;

public class MyClass {
    public static int pivotIndex(int[] nums) {
        int total = 0, temp = 0;
        for (int num : nums) total += num;
        for (int i = 0; i < nums.length; temp += nums[i])
            if (nums[i]==total-2*temp) return i;
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{ 1,7,3,6,5,6 }));
    }
}