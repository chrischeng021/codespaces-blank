package com.demo.algo.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KthLargest {
    // https://leetcode.cn/problems/kth-largest-element-in-a-stream
    // 数据流中的第 K 大元素
    List<Integer> data;
    int index;

    public KthLargest(int k, int[] nums) {
        data = new ArrayList<>();
        if(nums.length > 0) {
            Arrays.sort(nums);
            Arrays.stream(nums).forEach(i -> data.add(0, i));
        }
        this.index = k - 1;
    }

    public int add(int val) {
            int targetIndex = data.size() > 0 ? getFirstSmallerIndex(val, 0, data.size() - 1) : 0;
            data.add(targetIndex, val);
            return data.get(index);
    }

    // Find first element in array data that smaller than v
    private int getFirstSmallerIndex(int v, int l, int r) {
        if(data.get(l) <= v) {
            return l;
        }
        if(data.get(r) > v) {
            return Math.min(r + 1, data.size());
        }
        int mid = (l + r) / 2;

        if(data.get(mid) >= v) {
            return getFirstSmallerIndex(v, mid + 1, r);
        }
        else {
            return getFirstSmallerIndex(v, l, mid - 1);
        }
    }
}
