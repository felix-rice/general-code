package com.felix.general.code.daily.practice.leetcode.face;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2024-02-18
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        String[] names = path.split("/");
        for (String name : names) {
            if ("..".equals(name)) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            }
            else if (name.length() > 0 && !name.equals(".")) {
                stack.offerLast(name);
            }
        }
        StringBuilder ans = new StringBuilder();
        if (stack.isEmpty()) ans.append('/');
        while (!stack.isEmpty()) {
            ans.append('/');
            ans.append(stack.pollFirst());
        }
        return ans.toString();
    }
}
