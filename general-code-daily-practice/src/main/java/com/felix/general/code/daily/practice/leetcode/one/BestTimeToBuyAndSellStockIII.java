package com.felix.general.code.daily.practice.leetcode.one;

import java.util.Stack;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2023-09-25
 */
public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        /**
         * 五种状态：
         * 1. 未购买股票 未购入，因此可以以0代替
         * 2. 购买一次股票
         * 3. 卖出一次股票
         * 4. 购买二次股票
         * 5. 卖出二次股票
         */
        int buy1 = -prices[0], buy2 = -prices[0];
        int sell1 = 0, sell2 = 0;
        for (int i = 1; i < prices.length; i++) {
            // 购买一次
            buy1 = Math.max(buy1, -prices[i]);
            // 卖出一次
            sell1 = Math.max(sell1, buy1 + prices[i]);
            // 买入二次
            buy2 = Math.max(buy2, sell1 - prices[i]);
            // 卖出二次
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }

        return sell2;
    }
}
