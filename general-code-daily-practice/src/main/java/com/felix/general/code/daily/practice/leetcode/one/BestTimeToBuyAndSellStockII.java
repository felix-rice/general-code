package com.felix.general.code.daily.practice.leetcode.one;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2023-09-27
 */
public class BestTimeToBuyAndSellStockII {
    private int dpMaxProfile(int[] prices) {
        // 1.当前持有股票的最大收益
        int[] dp0 = new int[prices.length];
        // 2.当前不持有股票的最大收益
        int[] dp1 = new int[prices.length];
        dp0[0] = 0;
        dp1[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp0[i] = Math.max(dp0[i - 1], dp1[i - 1] + prices[i]);
            dp1[i] = Math.max(dp1[i - 1], dp0[i - 1] - prices[i]);
        }
        return dp0[prices.length - 1];
    }
}
