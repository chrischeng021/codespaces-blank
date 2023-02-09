package main.java.com.demo.algo;

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

    private static int search(int[] nums, int target, int left, int right) {
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
}
