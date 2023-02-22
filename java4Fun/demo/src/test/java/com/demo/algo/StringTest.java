package com.demo.algo;

import com.demo.algo.string.StringUtils;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

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

    @Test
    public void testFreqAlphabets() {
        assertEquals("jkab", StringUtils.freqAlphabets("10#11#12"));
        assertEquals("acz", StringUtils.freqAlphabets("1326#"));
    }

    @Test
    public void testIsAlienSorted() {
        assertTrue(StringUtils.isAlienSorted(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        assertFalse(StringUtils.isAlienSorted(new String[]{"word","world","row"}, "worldabcefghijkmnpqstuvxyz"));
        assertFalse(StringUtils.isAlienSorted(new String[]{"apple","app"}, "abcdefghijklmnopqrstuvwxyz"));
    }

    @Test
    public void testFindTheDifference() {
        String s1 = "ihwrdisrhgxwbfevrxbtzgsywhnzleueadikniwyuasflpsviobwvsmydmyzppqjlmzakpbnouyttdigkcdzypvcqxbttmblttehgjlnpjwpzoprntifysfatjboasottnkpyyvmdcafpjicfpgmbwqdsaxdmmdmupnwhkpxixpdwmczntqtushemvavofszomtsrafzmxctpidjadwcwggdbyliqmcvuwscryfsvlvfrhfphmxvcnytbctomicwdwjjmdhmcqtnlqgixxdyjydhwnftkobotbhsgykawhtvnkxoykwkgvtqioqoiilergxlpuujabiug";
        String s2 = "gyptmtjntxlusjhbzkbgowslthwtytdnflsyfsgfytzrodatykdyvgsmvxsuemijitvodmwrrqmcabhwzyoouorfckhisjpduoxvtmttzvwmicdxsovsabmpcpppzycuwbmpihmxadmvkkwerimhgwdwdtvqwbwtetppkpkbcaifuqbenagycdqatklciaczcpglxmvfaqnwpnssdmnhcmifeyndzttvypwlgpttvhswoiijybchbvzklgngqziyaczowgwiufqyhxxdqjrxolddgnmriijopdsikqwtyhplhubrljfjanexxyfvjmudxsomnfbafntpib";
        assertEquals('t', StringUtils.findTheDifference(s1, s2));
    }
}
