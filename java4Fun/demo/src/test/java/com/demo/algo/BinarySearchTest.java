package test.java.com.demo.algo;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import main.java.com.demo.algo.BinarySearch;

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
}
