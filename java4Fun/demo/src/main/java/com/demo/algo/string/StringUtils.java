package com.demo.algo.string;

import com.google.common.collect.ImmutableMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringUtils {
    private static char[] reverseString(char[] s) {
        int length = s.length;
        int range = (s.length - 1) / 2;
        if(length <= 1) {
            return s;
        }
        for(int i = 0; i <= range; i++) {
            char l = s[i];
            s[i] = s[length - 1 - i];
            s[length - 1 - i] = l;
        }
        return s;
    }

    public String reverseWords(String s) {
        String[] strArr = s.split(" ");
        int count = strArr.length;
        if(count == 1) {
            return String.valueOf(reverseString(s.toCharArray()));
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < count - 1; i++) {
            res.append(reverseString(strArr[i].toCharArray())).append(" ");
        }
        res.append(reverseString(strArr[count - 1].toCharArray()));
        return res.toString();
    }

    // https://leetcode.cn/problems/roman-to-integer/
    public static int romanToInt(String s) {
        int sum = 0;
        char[] str = s.toCharArray();
        Map<Character, Map<Character, Integer>> preDefinedSpecialValMap = ImmutableMap.of(
                'I', ImmutableMap.of('V',4, 'X', 9),
                'X', ImmutableMap.of('L',40, 'C', 90),
                'C', ImmutableMap.of('D',400, 'M', 900)
        );


        for(int i = 0; i < str.length; i++) {
            sum += checkSpecialCase(i, str, preDefinedSpecialValMap);
        }

        for(int i = 0; i < str.length; i++) {
            if(str[i] != '0') {
                switch (str[i]) {
                    case 'I': sum += 1;
                        break;
                    case 'V': sum += 5;
                        break;
                    case 'X': sum += 10;
                        break;
                    case 'L': sum += 50;
                        break;
                    case 'C': sum += 100;
                        break;
                    case 'D': sum += 500;
                        break;
                    case 'M': sum += 1000;
                        break;
                }
            }
        }
        return sum;
    }
    private static int checkSpecialCase(
            int index,
            char[] str,
            Map<Character, Map<Character, Integer>> preDefinedSpecialValMap) {
        if(preDefinedSpecialValMap.containsKey(str[index])
                && ((index + 1) < str.length)
                && preDefinedSpecialValMap.get(str[index]).containsKey(str[index + 1])) {
            Character[] right = preDefinedSpecialValMap.get(str[index]).keySet().toArray(new Character[2]);
            char leftKey = str[index];
            char rightKey = str[index + 1];
            str[index] = '0';
            str[index + 1] = '0';
            return rightKey == right[0] ?
                    preDefinedSpecialValMap.get(leftKey).get(right[0]) :
                    preDefinedSpecialValMap.get(leftKey).get(right[1]);
        }
        return 0;
    }

    public static boolean areAlmostEqual(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        int gap = 0;
        char s1First = 0;
        char s2First = 0;

        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)){
                gap++;
                if(gap == 1) {
                    s1First = s1.charAt(i);
                    s2First = s2.charAt(i);
                }
                else if(gap == 2){
                    if(s1.charAt(i) != s2First || s2.charAt(i) != s1First) {
                        return false;
                    }
                }
                else {
                    return false;
                }
            }
        }
        return gap == 0 || gap == 2;
    }

    // https://leetcode.cn/problems/first-unique-character-in-a-string
    public static int firstUniqChar(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), new ArrayList<>());
            }
            map.get(s.charAt(i)).add(i);
        }
        int minUniqCharIndex = Integer.MAX_VALUE;
        for(Character ch : map.keySet()) {
            if(map.get(ch).size() == 1 && map.get(ch).get(0) < minUniqCharIndex) {
                minUniqCharIndex = map.get(ch).get(0);
            }
        }
        return minUniqCharIndex == Integer.MAX_VALUE ? -1 : minUniqCharIndex;
    }

    // https://leetcode.cn/problems/ransom-note
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] res1 = calculateLowCaseAlphabetCount(ransomNote);
        int[] res2 = calculateLowCaseAlphabetCount(magazine);

        for(int i = 0 ; i < 26; i++) {
            if(res1[i] > res2[i]) {
                return false;
            }
        }
        return true;
    }
    private static int[] calculateLowCaseAlphabetCount(String str) {
        int[] res = new int[26];
        for(int i = 0; i < str.length(); i++) {
            res[str.charAt(i) - 'a']++;
        }
        return res;
    }

    // https://leetcode.cn/problems/intersection-of-two-arrays-ii
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = countNumberInArray(nums1);
        Map<Integer, Integer> map2 = countNumberInArray(nums2);

        List<Integer> list = new ArrayList<>();

        for(int i : map1.keySet()) {
            if(map2.containsKey(i)) {
                for(int j = 0; j < Math.min(map1.get(i), map2.get(i)); j++) {
                    list.add(i);
                }
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    public static Map<Integer, Integer> countNumberInArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            if(!map.containsKey(i)) {
                map.put(i, 1);
            }
            else {
                map.put(i, map.get(i) + 1);
            }
        }
        return map;
    }

    // https://leetcode.cn/problems/decrypt-string-from-alphabet-to-integer-mapping
    public static String freqAlphabets(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if( (i + 2) < s.length() && s.charAt(i + 2) == '#') {
                sb.append((char)('a' + (Integer.valueOf(s.substring(i, i + 2)) - 1)));
                i += 2;
            }
            else {
                sb.append((char)('a' + (Integer.valueOf(String.valueOf(s.charAt(i))) - 1)));
            }
        }
        return sb.toString();
    }

    // https://leetcode.cn/problems/to-lower-case
    public static String toLowerCase(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }

        char[] arr = s.toCharArray();

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] >= 'A' && arr[i] <= 'Z') {
                arr[i] = (char)(arr[i] - 'A' + 'a');
            }
        }
        return String.valueOf(arr);
    }

    // https://leetcode.cn/problems/verifying-an-alien-dictionary
    public static boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> seqMap = new HashMap<>();
        for(int i = 0; i < order.length(); i++) {
            seqMap.put(order.charAt(i), i);
        }
        for(int i = 0; i < words.length - 1; i++) {
            if(compareWordInDicSeq(words[i], words[i + 1], seqMap) == -1) {
                return false;
            }
        }
        return true;
    }

    // @RequestParam seqMap: dictionary sequence'
    // @Response:
    // 1: word1 <= word2
    // -1: word1 > word2
    public static int compareWordInDicSeq(String word1, String word2, Map<Character, Integer> seqMap) {
        int minLength = Math.min(word1.length(), word2.length());
        for(int i = 0; i < minLength; i++) {
            if(seqMap.get(word1.charAt(i)) > seqMap.get(word2.charAt(i))) {
                return -1;
            }
            else if(seqMap.get(word1.charAt(i)) < seqMap.get(word2.charAt(i))) {
                return 1;
            }
        }
        return word1.length() <= word2.length() ? 1 : -1;
    }

    // https://leetcode.cn/problems/find-the-difference/
    public static char findTheDifference(String s, String t) {
        int[] arr = new int[26];
        for(int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }
        arr[t.charAt(t.length() - 1) - 'a']--;

        for(int i = 0; i < 26; i++) {
            if(arr[i] != 0) {
                return (char)('a' + i);
            }
        }

        return 'a';
    }
}
