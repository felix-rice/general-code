package com.felix.general.code.daily.practice.leetcode.face;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2024-01-28
 */
public class RandomizedSet {
    List<Integer> arr;
    Map<Integer, Integer> val2IdxMap;
    Random random;

    public RandomizedSet() {
        arr = new ArrayList<>();
        val2IdxMap = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (val2IdxMap.containsKey(val)) {
            return false;
        }
        arr.add(val);
        val2IdxMap.put(val, arr.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!val2IdxMap.containsKey(val)) {
            return false;
        }
        int idx = val2IdxMap.get(val);
        if (idx < arr.size() - 1) {
            arr.set(idx, arr.get(arr.size() - 1));
            val2IdxMap.put(arr.get(idx), idx);
        }
        val2IdxMap.remove(val);
        arr.remove(arr.size() - 1);
        return true;
    }

    public int getRandom() {
        int randomNum = random.nextInt(arr.size());
        return arr.get(randomNum);
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(0);
        randomizedSet.insert(1);
        randomizedSet.remove(0);
        randomizedSet.insert(2);
        randomizedSet.remove(1);
        int random1 = randomizedSet.getRandom();
        System.out.println(random1);
    }
}