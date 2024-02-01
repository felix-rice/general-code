package com.felix.general.code.daily.practice.leetcode.face;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2024-02-01
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        char[] ch = s.toCharArray();
        boolean findFirst = false;
        int len = 0;
        for (int i = ch.length - 1; i >= 0; i--) {
            if (ch[i] == ' ') {
                if (findFirst) {
                    break;
                }
            } else {
                if (!findFirst) {
                    findFirst = true;
                }
                len++;
            }
        }
        return len;
    }
}
