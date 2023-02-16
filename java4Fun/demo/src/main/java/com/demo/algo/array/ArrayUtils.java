package com.demo.algo.array;
import com.demo.algo.search.BinarySearch;

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
            targetIndex = BinarySearch.search(numbers, target - numbers[i], left, right);
            if(targetIndex == -1) {
                continue;
            }
            else {
                return new int[]{i + 1, targetIndex + 1};
            }
        }
        return new int[]{};
    }

    // https://leetcode.cn/problems/merge-sorted-array
    // nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int index = m + n - 1;
    }

    // https://leetcode.cn/problems/maximum-number-of-pairs-in-array/
    public int[] numberOfPairs(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int pairCount = 0;
        for(int i : nums) {
            if(set.contains(i)) {
                set.remove(i);
                pairCount++;
            }
            else {
                set.add(i);
            }
        }
        return new int[]{pairCount, nums.length - pairCount * 2};
    }
}
