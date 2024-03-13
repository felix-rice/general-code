package com.felix.general.code.daily.practice.leetcode.face;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2024-02-18
 */
public class LRUCache {
    int count;
    int cap;
    Map<Integer, Integer> cache;
    public LRUCache(int capacity) {
        cache = new HashMap<>(capacity);
        count = 0;
        cap = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
        } else {
            if (count < cap) {
                cache.put(key, value);
                count++;
            }
        }
    }
}
