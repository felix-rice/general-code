package com.felix.general.code.daily.practice.leetcode.face;

import java.util.Deque;
import java.util.LinkedList;

import org.apache.commons.lang3.StringUtils;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2024-02-18
 */
public class BasicCalculator {
    /**
     * Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.
     *
     * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
     *
     *
     *
     * Example 1:
     *
     * Input: s = "1 + 1"
     * Output: 2
     * Example 2:
     *
     * Input: s = " 2-1 + 2 "
     * Output: 3
     * Example 3:
     *
     * Input: s = "(1+(4+5+2)-3)+(6+8)"
     * Output: 23
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 3 * 105
     * s consists of digits, '+', '-', '(', ')', and ' '.
     * s represents a valid expression.
     * '+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
     * '-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
     * There will be no two consecutive operators in the input.
     * Every number and running calculation will fit in a signed 32-bit integer.
     */
    public int calculate(String s) {
        char[] ch = s.toCharArray();
        int ans = 0;
        Deque<Integer> signStack = new LinkedList<>();
        signStack.push(1);
        int sign = 1, i = 0;
        while (i < ch.length) {
            if (ch[i] == ' ') {
                i++;
            }
            else if (ch[i] == '+') {
                sign = signStack.peek();
                i++;
            } else if (ch[i] == '-') {
                sign = -signStack.peek();
                i++;
            } else if (ch[i] == '(') {
                signStack.push(sign);
                i++;
            } else if (ch[i] == ')') {
                signStack.pop();
                i++;
            } else {
                int num = 0;
                while (i < ch.length && Character.isDigit(ch[i])) {
                    num *= 10;
                    num += ch[i] - '0';
                    i++;
                }
                ans += sign * num;
            }
        }
        return ans;
    }
}
