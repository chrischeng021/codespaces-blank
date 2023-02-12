package com.demo.algo;

public class ArrayUtils {
    private static <T> void swap(T[] arr, int l, int r) {
        T left = arr[l];
        arr[l] = arr[r];
        arr[r] = left;
    }
    //https://leetcode.cn/problems/move-zeroes/?envType=study-plan&id=suan-fa-ru-men&plan=algorithms&plan_progress=jxt5bov
    public static void moveZeroes(Integer[] nums) {
        int length = nums.length;
        if(length < 2) {
            return;
        }
        int zeroCursor = 0;
        int zeroCount = 0;
        int targetIndex = 0;
        while(zeroCursor < length - 1 && targetIndex <= length - 1) {
            if(nums[zeroCursor] != 0) {
                zeroCursor++;
                continue;
            }
            while(targetIndex < length - 1 && nums[targetIndex] == 0) {
                targetIndex++;
            }
            if(zeroCursor < targetIndex) {
                swap(nums, zeroCursor++, targetIndex++);
            }
            else {
                targetIndex++;
            }
        }
    }

    // https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/
    public static int[] twoSum(int[] numbers, int target) {
        int targetIndex = -1;
        for(int i = 0; i < numbers.length - 1; i++) {
            int left, right;
            if(numbers[i] * 2 > target) {
                left = 0;
                right = i - 1;
            }
            else {
                left = i + 1;
                right = numbers.length - 1;
            }
            targetIndex = main.java.com.demo.algo.BinarySearch.search(numbers, target - numbers[i], left, right);
            if(targetIndex == -1) {
                continue;
            }
            else {
                return new int[]{i + 1, targetIndex + 1};
            }
        }
        return new int[]{};
    }
}
