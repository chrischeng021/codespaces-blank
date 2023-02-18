package com.demo.algo;

import com.demo.algo.string.StringUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringTest {
    @Test
    public void testRoman2Integer() {
        assertEquals(3, StringUtils.romanToInt("III"));
        assertEquals(4, StringUtils.romanToInt("IV"));
        assertEquals(9, StringUtils.romanToInt("IX"));
        assertEquals(58, StringUtils.romanToInt("LVIII"));
    }

    @Test
    public void testAlmostEqual() {
        assertTrue(StringUtils.areAlmostEqual("bank", "kanb"));
        assertTrue(StringUtils.areAlmostEqual("kelb", "kelb"));
        assertFalse(StringUtils.areAlmostEqual("attack", "defend"));
        assertFalse(StringUtils.areAlmostEqual("abcd", "dcba"));
    }

    @Test
    public void testUniqChar() {
        assertEquals(-1, StringUtils.firstUniqChar("aabb"));
        assertEquals(2, StringUtils.firstUniqChar("loveleetcode"));
        assertEquals(0, StringUtils.firstUniqChar("leetcode"));
    }
}
