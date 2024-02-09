package com.felix.general.code.daily.practice.leetcode.face;

/**
 * Given an input string s, reverse the order of the words.

 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

 * Return a string of the words in reverse order concatenated by a single space.

 * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

 * Example 1:

 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:

 * Input: s = "  hello world  "
 * Output: "world hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:

 * Input: s = "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.

 * Constraints:

 * 1 <= s.length <= 104
 * s contains English letters (upper-case and lower-case), digits, and spaces ' '.
 * There is at least one word in s.
 * Follow-up: If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2024-02-01
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        char[] ch = s.toCharArray();
        // 1. 翻转字符串 a good   example ---> elpmaxe    doog a
        reverse(ch, 0, ch.length - 1);
        // 2. 找到每个字符串的起点和终点，翻转之间的内容，例如 0-6 example
        int wordBegin = 0, wordEnd = 0;
        boolean word = false;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == ' ') {
                if (word) {
                    wordEnd = i - 1;
                    reverse(ch, wordBegin, wordEnd);
                    word = false;
                }
            } else {
                if (!word) {
                    wordBegin = i;
                    word = true;
                }
            }
        }
        if (ch[ch.length - 1] != ' ') {
            reverse(ch, wordBegin, ch.length - 1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == ' ') {
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(ch[i]);
                }
            } else {
                sb.append(ch[i]);
            }
        }
        // 删除最后一个字符串后跟的空字符串
        if (sb.length() - 1 >= 0 && sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private void reverse(char[] ch, int begin, int end) {
        while (begin < end) {
            char temp = ch[begin];
            ch[begin] = ch[end];
            ch[end] = temp;
            begin++;
            end--;
        }
    }
}
