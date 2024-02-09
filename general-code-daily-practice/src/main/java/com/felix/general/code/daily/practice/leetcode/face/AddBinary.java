package com.felix.general.code.daily.practice.leetcode.face;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2024-02-08
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        int i = ac.length - 1, j = bc.length - 1, carry = 0;
        while (i >= 0 && j >= 0) {
            int adigit = ac[i--] - '0';
            int bdigit = bc[j--] - '0';
            sb.append(adigit^bdigit^carry);
            int cur = adigit + bdigit + carry;
            if (cur > 1) {
                carry = 1;
            } else {
                carry = 0;
            }
        }
        return sb.reverse().toString();
    }
}
