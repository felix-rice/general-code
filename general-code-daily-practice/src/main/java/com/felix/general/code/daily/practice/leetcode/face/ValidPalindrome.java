package com.felix.general.code.daily.practice.leetcode.face;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2024-02-01
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        char[] ch = s.toCharArray();
        int i = 0, j = ch.length - 1;
        while(i < j) {
            if (ch[i] >= 'A' && ch[i] <= 'Z') {
                ch[i] = (char) (ch[i] - 'A' + 'a');
            }
            if (ch[j] >= 'A' && ch[j] <= 'Z') {
                ch[j] = (char) (ch[j] - 'A' + 'a');
            }
            if ((ch[i] >= 'a' && ch[i] <= 'z') || (ch[i] >= '0' && ch[i] <= '9')) {
                if (ch[j] >= 'a' && ch[j] <= 'z' || (ch[j] >= '0' && ch[j] <= '9')) {
                    if (ch[i] != ch[j]) {
                        return false;
                    }
                    i++;
                }
                j--;
            } else {
                i++;
            }
        }
        return true;
    }
}
