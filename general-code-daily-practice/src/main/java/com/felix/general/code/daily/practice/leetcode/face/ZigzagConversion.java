package com.felix.general.code.daily.practice.leetcode.face;

import java.util.ArrayList;
import java.util.List;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"

 * Write the code that will take a string and make this conversion given a number of rows:

 * string convert(string s, int numRows);

 * Example 1:

 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:

 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * Example 3:

 * Input: s = "A", numRows = 1
 * Output: "A"

 * Constraints:

 * 1 <= s.length <= 1000
 * s consists of English letters (lower-case and upper-case), ',' and '.'.
 * 1 <= numRows <= 1000
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2024-02-01
 */
public class ZigzagConversion {
    public static String convert(String s, int numRows) {
        List<List<Character>> sima = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            sima.add(new ArrayList<>());
        }
        int i = 0;
        /*
         * P     I    N
         * A   L S  I G
         * Y A   H R
         * P     I
         */
        while (i < s.length()) {
            for (int j = 0; j < numRows && i < s.length(); j++) {
                sima.get(j).add(s.charAt(i++));
            }
            for (int j = numRows - 2; j > 0 && i < s.length(); j--) {
                sima.get(j).add(s.charAt(i++));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < numRows; j++) {
            for (char c : sima.get(j)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        String convert = convert(s, 3);
        // PAHNAPLSIIGYIR
        System.out.println(convert);
    }
}
