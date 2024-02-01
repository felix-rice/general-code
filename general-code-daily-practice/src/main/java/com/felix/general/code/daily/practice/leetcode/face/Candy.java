package com.felix.general.code.daily.practice.leetcode.face;

import java.util.Arrays;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2024-01-29
 */
public class Candy {
    /**
     * 2 3 5 6 7 9 11 8 7 6 5 5
     * 1 2 3 4 5 6 7  8 7 6 5 1
     */
    public int candy0(int[] ratings) {
        int n = ratings.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] == ratings[i - 1]) {
                dp[i] = 1;
            } else if (ratings[i] > ratings[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
                // todo 可以优化，直接计算出累加的数量，变为O1
                // 回溯到递减的最初元素
                int j = i - 1;
                while (j >= 0 && ratings[j] > ratings[j + 1]) {
                    if (dp[j] > dp[j + 1]) {
                        break;
                    }
                    dp[j] = dp[j + 1] + 1;
                    j--;
                }
            }
        }
        int sum = 0;
        for (int num : dp) {
            sum += num;
        }
        return sum;
    }

    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] dp0 = new int[n];
        int[] dp1 = new int[n];
        Arrays.fill(dp0, 1);
        Arrays.fill(dp1, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                dp0[i] = dp0[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                dp1[i] = dp1[i + 1] + 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.max(dp0[i], dp1[i]);
        }
        return sum;
    }
}
