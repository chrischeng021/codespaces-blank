package com.demo.algo;

import com.demo.algo.array.ArrayUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

@Slf4j
public class ArrayTest {
    @Test
    public void testMoveZeros() {
        Integer[] nums = {1, 0, 0};
        ArrayUtils.moveZeroes(nums);
        log.info("Result: {}", Arrays.stream(nums).toArray());
    }

    @Test
    public void testTwoSum() {
        log.info("Result: {}.", ArrayUtils.twoSum(new int[] {1,3,4,4}, 8));
    }
}
