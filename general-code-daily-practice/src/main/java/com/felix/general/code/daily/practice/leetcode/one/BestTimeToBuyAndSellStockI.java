package com.felix.general.code.daily.practice.leetcode.one;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2023-09-27
 */
public class BestTimeToBuyAndSellStockI {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profile = 0;
        for (int price : prices) {
            if (price < min) {
                min = price;
            } else if (price - min > profile) {
                profile = price - min;
            }
        }
        return profile;
    }
}
