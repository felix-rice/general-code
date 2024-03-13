package com.felix.general.code.daily.practice.leetcode.face;

import java.util.Stack;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2024-02-17
 */
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else if (val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        int pee = stack.peek();
        stack.pop();
        if (!minStack.isEmpty()) {
            if (pee == minStack.peek()) {
                minStack.pop();
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}