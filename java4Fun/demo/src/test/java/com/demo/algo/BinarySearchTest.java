package com.demo.algo;

import static org.junit.Assert.assertTrue;

import java.beans.Transient;

import static org.junit.Assert.assertEquals;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import com.demo.algo.search.BinarySearch;

@Slf4j
public class BinarySearchTest {
    @Test
    public void testArray_01() {
        assertEquals(0, BinarySearch.search(new int[] {0}, 0));
    }

    @Test
    public void testArray_02() {
        assertEquals(-1, BinarySearch.search(new int[] {0}, 3));
    }

    @Test
    public void testArray_03() {
        assertEquals(1, BinarySearch.search(new int[] {1, 2}, 2));
    }

    @Test
    public void testArray_04() {
        assertEquals(2, BinarySearch.search(new int[] {1, 2, 3}, 3));
    }

    @Test
    public void testArray_05() {
        assertEquals(1, BinarySearch.search(new int[] {1, 2, 3, 4}, 2));
    }

    @Test
    public void testSortSquares() {
        int[] nums = {-4,-1,0,0,0};
        log.info("Result: {}.", BinarySearch.sortedSquares(nums));
    }

    @Test
    public void testSearchInsert() {
        int[] nums = {1,3,5,6};
        int target = 7;
        log.info("Result: {}.", BinarySearch.searchInsert(nums, target));
    }
}
