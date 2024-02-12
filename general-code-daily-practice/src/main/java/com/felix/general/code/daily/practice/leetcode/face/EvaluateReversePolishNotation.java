package com.felix.general.code.daily.practice.leetcode.face;

import java.util.Stack;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2024-02-10
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int ans = Integer.parseInt(tokens[0]);
        for (String token : tokens) {
            try {
                int num = Integer.parseInt(token);
                stack.push(num);
            } catch (Exception e) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                ans = compute(num2, num1, token);
                stack.push(ans);
            }
        }
        return ans;
    }

    private int compute(int num1, int num2, String op) {
        switch(op) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
        }
        return num1;
    }
}
