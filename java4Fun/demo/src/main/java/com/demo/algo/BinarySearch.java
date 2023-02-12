package main.java.com.demo.algo;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    /**
     * @param nums int array, source
     * @param target int value, target
     * @return -1 = not found, otherwise target value's index.
     */
    public static int search(int[] nums, int target) {
        if(nums.length == 0) {
            return -1;
        }
        return search(nums, target, 0, nums.length - 1);
    }

    public static int search(int[] nums, int target, int left, int right) {
        if(left > right) {
            return -1;
        }
        else if(left == right) {
            return nums[left] == target ? left : -1;
        }
        else {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] > target) {
                return search(nums,target, left, mid - 1);
            }
            else {
                return search(nums, target, mid + 1, right);
            }
        }
    }

    // https://leetcode.cn/problems/squares-of-a-sorted-array/?envType=study-plan&id=suan-fa-ru-men&plan=algorithms&plan_progress=jxt5bov
    public static int[] sortedSquares(int[] nums) {
        int minSquareIndex = findMinSquareIndex(nums);
        int[] res = new int[nums.length];
        res[0] = nums[minSquareIndex] * nums[minSquareIndex];

        int left = minSquareIndex - 1;
        int right = minSquareIndex + 1;

        for(int resIndex = 1; resIndex < nums.length; resIndex++) {
            if(left >= 0 && right < nums.length) {
                if(Math.abs(nums[left]) >= nums[right]) {
                    res[resIndex] = nums[right] * nums[right];
                    right++;
                }
                else {
                    res[resIndex] = nums[left] * nums[left];
                    left--;
                }
            }
            else if(left < 0 && right < nums.length) {
                res[resIndex] = nums[right] * nums[right];
                right++;
            }
            else if(right >= nums.length && left >= 0) {
                res[resIndex] = nums[left] * nums[left];
                left--;
            }
        }
        return res;
    }
    private static int findMinSquareIndex(int nums[]) {
        // 數組全是非負數的情況
        if(nums[0] >= 0) {
            return 0;
        }
        // 數組全是負數的情況
        if(nums[nums.length - 1] < 0) {
            return nums.length - 1;
        }
        // 數組全是非正數且最末為0的情況
        if(nums[nums.length - 1] == 0) {
            return nums.length - 1;
        }
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] < 0) {
                if(nums[i + 1] < 0) {
                    continue;
                }
                else if(nums[i + 1] == 0) {
                    return i + 1;
                }
                else {
                    return Math.abs(nums[i]) > nums[i + 1] ? i + 1 : i;
                }
            }
        }
        return -1;
    }
}
