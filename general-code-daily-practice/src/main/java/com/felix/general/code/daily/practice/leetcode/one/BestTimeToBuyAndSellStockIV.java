package com.felix.general.code.daily.practice.leetcode.one;

import java.util.Arrays;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2023-09-27
 */
public class BestTimeToBuyAndSellStockIV {
    public static int maxProfit(int k, int[] prices) {
        if (k == 0 || prices == null || prices.length < 2) return 0;
        int[] buy = new int[k];
        int[] sell = new int[k];
        Arrays.fill(buy, -prices[0]);
        for (int n = 1; n < prices.length; n++) {
            sell[0] = Math.max(sell[0], buy[0] + prices[n]);
            buy[0] = Math.max(buy[0], -prices[n]);
            for (int i = 1; i < k; i++) {
                sell[i] = Math.max(sell[i], buy[i] + prices[n]);
                buy[i] = Math.max(buy[i], sell[i - 1] - prices[n]);
            }
        }
        return sell[k - 1];
    }

    public static void main(String[] args) {
        int k = 4;
        int[] prices = new int[] {5,7,2,7,3,3,5,3,0};
        System.out.println(maxProfit(k, prices));
    }
}
