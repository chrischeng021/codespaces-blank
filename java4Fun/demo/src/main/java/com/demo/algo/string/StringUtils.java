package com.demo.algo.string;

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
}
